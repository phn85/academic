/* <h1>FileName: DoctorTabController.java</h1>
 * @author	Phanindra Chandraprakash
 * @version	1.0
 * @date	12/02/2016
 * FinalProject: HospitalManagementSystem
 * Description: This is an FXML controller class which manages Doctor Details page.
 */
package com.controller.Tab;

import com.model.Connect_with_database;
import com.model.Department;
import com.model.Display_message;
import com.model.Doctor;
import java.net.URL;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ResourceBundle;
import java.util.logging.Level;
import java.util.logging.Logger;
import javafx.application.Platform;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.collections.transformation.FilteredList;
import javafx.event.EventHandler;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Button;
import javafx.scene.control.ComboBox;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.TextField;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.scene.control.cell.TextFieldTableCell;

public class DoctorTabController implements Initializable {

 
    private PreparedStatement ps = null;
    private Statement st = null;
    private ResultSet rs;
    @FXML
    private Button btSave;
    @FXML
    private TextField tfDoctorSearch;
    @FXML
    private Button btAddDoctor;
    @FXML
   // private Button btDelete;
    //@FXML
    private ComboBox<String> cbSearch;
    @FXML
    private TableView<Doctor> doctorTable;
    @FXML
    private TableColumn doctorIdColumn;
    @FXML
    private TableColumn doctorNameColumn;
    @FXML
    private TableColumn departmentColumn;
    @FXML
    private TextField tfAddDoctorId;
    @FXML
    private TextField tfAddDoctorName;
    @FXML
    private ComboBox cbAddDepartment;
    
    private ObservableList<Doctor> doctorData = FXCollections.observableArrayList();
    private ObservableList<Department> departmentData = FXCollections.observableArrayList();
    private ObservableList<Doctor> filteredData = FXCollections.observableArrayList();

    @Override
    public void initialize(URL location, ResourceBundle resources) {
        
        getDepartment();
        initDepartmentCb();
        getDoctorData();
        initTable();
        setEditable();
        cbSearchInit();
    }

    @FXML
    public void handleBtAddDoctor()
    {
        if (tfAddDoctorId.getText().trim().equals("") || tfAddDoctorName.getText().equals("") ) {
           Display_message.showError("Error", "All Text Field must be filled!");
        }
        else {
            int position=cbAddDepartment.getSelectionModel().getSelectedIndex();
            String name = tfAddDoctorName.getText();
            String department = departmentData.get(position).getDepartmentIdProperty();
            int doctorid=Integer.parseInt(tfAddDoctorId.getText());
            int i=checkUserAvailable(doctorid);
            if(i==0)
            {
                Display_message.showError("Error", "Please first create user id for this user!");
                return;
            }
            String add="" ;
            if(i==1)
            add= "INSERT INTO fp.pchand_admindetail (adminid,adminname, departmentid) VALUES (?,?, ?)";
            else if(i==2)
            add= "INSERT INTO fp.pchand_doctor (doctorid,doctorname, departmentid) VALUES (?,?, ?)";
            Connection con=null;
            try {
                con=Connect_with_database.createConnection();
                ps = con.prepareStatement(add);
                ps.setInt(1, doctorid);
                ps.setString(2, name);
                ps.setString(3, department);
                int res=ps.executeUpdate();
                if(res>0)
                {
                    if(i==2)
                    {
                        Doctor doctor = new Doctor();
                        doctor.setNameProperty(name);
                        doctor.setDepartmentNameProperty(departmentData.get(position).getDepartmentNameProperty());
                        doctor.setDepartmentProperty(department);
                        doctor.setIdProperty(doctorid+"");
                        doctorData.add(doctor);
                    }
                    else
                    {
                        Display_message.showInformation("Sucessful", "Admin created sucessfully!");
                    }
                    tfAddDoctorId.setText("");
                    
                    tfAddDoctorName.setText("");
                }

            } catch (SQLException ex) {
            	System.out.println("Format is improper");
            }
            finally
            {
                Connect_with_database.closeConnection(con);
            }
        }
    }
    public int checkUserAvailable(int doctorid)
    {
        Connection con=null;
            try {
                con=Connect_with_database.createConnection();
            String sql = "SELECT * FROM fp.pchand_user where userid="+doctorid+" and role in ("+"'doctor', 'admin' )";
            st = con.createStatement();
            rs = st.executeQuery(sql);
            if(rs.next()) 
            {
                String role=rs.getString(3);
              rs.close();
                if(role.equals("admin"))
                {
                    sql = "SELECT * FROM fp.pchand_admindetail where adminid="+doctorid;
                   st = con.createStatement();
                   rs = st.executeQuery(sql);
                   if(rs.next()) 
                   {
                       rs.close();
                       Display_message.showError("Error", "Admin already registered");
                       return 0;
                   }   
                       return 1;
                   }
                else
                {    
                    sql = "SELECT * FROM fp.pchand_admindetail where adminid="+doctorid;
                   st = con.createStatement();
                   rs = st.executeQuery(sql);
                   if(rs.next()) 
                   {
                       rs.close();
                       Display_message.showError("Error", "Doctor already registered");
                       return 0;
                   }   
                       return 2;
                   }
            }
            }
            catch (Exception ex) 
            {
                ex.printStackTrace();
        }
            finally
            {
                Connect_with_database.closeConnection(con);
            }
            return 0;
    }
    public String getMaxDoctorId(Connection con)
    {
        String doctorId="";
            try {
                String checkAccount = "SELECT max(doctorid) FROM fp.pchand_doctor";
                ps = con.prepareStatement(checkAccount);
                rs = ps.executeQuery();
                if (rs.next()) {
                    doctorId = rs.getInt(1)+"";
                }
            } catch (Exception e) {
                e.printStackTrace();
            }
            finally
            {
            try {
                ps.close();
                rs.close();
            } catch (SQLException ex) {
                Logger.getLogger(PatientTabController.class.getName()).log(Level.SEVERE, null, ex);
            }
                
            }
            return doctorId;
    }
    
    public void clear_textField()
    {
        tfAddDoctorId.clear();
        tfAddDoctorName.clear();

    }

    
    private void setTableColumnProperty(TableColumn column,String column_name,int type)
    {
        column.setEditable(true);
        column.setCellFactory(TextFieldTableCell.forTableColumn());
        column.setOnEditCommit(new EventHandler<TableColumn.CellEditEvent<Doctor, String>>() {
            @Override
            public void handle(TableColumn.CellEditEvent<Doctor, String> t) {
                Doctor doctor = ((Doctor) t.getTableView().getItems().get(t.getTablePosition().getRow()));
                if (t.getNewValue().length() == 0) {
                    forceRefresh();
                    Display_message.showError("Error","Field cannot be empty!");
                } 
                else {
                    String update = "UPDATE fp.pchand_doctor SET "+column_name+" = ? WHERE doctorid = ?";
                    Connection con=null;
                    try {
                        con=Connect_with_database.createConnection();
                        ps = con.prepareStatement(update);
                        switch(type)
                        {
                            case 0:
                                ps.setString(1, t.getNewValue());
                                break;
                            case 1:
                                ps.setInt(1, Integer.parseInt(t.getNewValue()));
                                break;
                            case 2:
                                ps.setDouble(1, Double.parseDouble(t.getNewValue()));
                                break;
                            case 3:
                                ps.setLong(1, Long.parseLong(t.getNewValue()));
                                break;
                        }
                                ps.setInt(2, Integer.parseInt(doctor.getIdProperty().trim()));
                        int res=ps.executeUpdate();
                        if(res>0)
                        {
                            //Display_message.showInformation("Success", "Record sucessfully updated!");
                        }
                        else
                        {
                            Display_message.showError("Error", "Record not updated!");
                        }
                    }
                    catch (SQLException ex) 
                    {
                        Display_message.showError("Exception", "Ooops, there was an exception!");
                        ex.printStackTrace();
                    }
                    finally
                    {
                    Connect_with_database.closeConnection(con);
                    }
                }
            }
        });
        
    }

    @FXML
    public void handleBtDelete() {
        int selectedIndex = doctorTable.getSelectionModel().getSelectedIndex();
        if(selectedIndex<0)
        {
            Display_message.showError("Error", "Please select a record first!");
            return;
        }
        String selectedID = doctorData.get(selectedIndex).getIdProperty();
        String detele = "DELETE FROM fp.pchand_DOCTOR WHERE doctorid = ?";
        Connection con=null;
            try {
                con=Connect_with_database.createConnection();
            ps = con.prepareStatement(detele);
            ps.setString(1, selectedID);
            int res=ps.executeUpdate();
            if(res>0)
            {
                Display_message.showInformation("Successful", "Record deleted sucessfully!");
            }
            else
            {
                Display_message.showInformation("Error", "Record not deleted!");
            }
        } catch (SQLException ex) {
            Display_message.showError("Exception","Ooops, there was an exception!");
        }
            finally
            {
                Connect_with_database.closeConnection(con);
            }

        doctorData.remove(selectedIndex);
    }

    public void cbSearchInit() {
        cbSearch.getItems().addAll("ID", "Name", "Department");
        cbSearch.setValue("ID");
    }

    private void getDoctorData() 
    {
        Connection con=null;
            try {
                con=Connect_with_database.createConnection();
            String sql = "SELECT fp.pchand_doctor.*, fp.pchand_department.departmentname FROM fp.pchand_Doctor inner join fp.pchand_department on fp.pchand_doctor.departmentid=fp.pchand_department.departmentid";
            st = con.createStatement();
            rs = st.executeQuery(sql);
            while (rs.next()) {
                Doctor doctor = new Doctor();
                doctor.setIdProperty(rs.getInt(1)+"");
                doctor.setNameProperty(rs.getString(2));
                doctor.setDepartmentProperty(rs.getInt(3)+"");
                doctor.setDepartmentNameProperty(rs.getString(4));
                doctorData.add(doctor);
            }
            }
            catch (Exception ex) {
            ex.printStackTrace();
        }
            finally
            {
                Connect_with_database.closeConnection(con);
            }
    }

    public void initTable() {
        doctorIdColumn.setCellValueFactory(
                new PropertyValueFactory<>("idProperty")
        );
        doctorNameColumn.setCellValueFactory(
                new PropertyValueFactory<>("nameProperty")
        );
        departmentColumn.setCellValueFactory(
                new PropertyValueFactory<>("departmentNameProperty")
        );

        //Create fillter for search field
        FilteredList<Doctor> filteredData = new FilteredList<>(doctorData, p -> true);
        doctorTable.setItems(filteredData);
        tfDoctorSearch.textProperty().addListener((observable, oldValue, newValue) -> {
            filteredData.setPredicate(doctor -> {
                // If filter text is empty, display all
                if (newValue == null || newValue.isEmpty()) {
                    return true;
                }
                String lowerCaseFilter = newValue.toLowerCase();
                switch (cbSearch.getValue()) {
                    case "ID":
                        if (doctor.getIdProperty().toLowerCase().contains(lowerCaseFilter)) {
                            return true; 
                        }
                    break;
                    case "Name":
                        if (doctor.getNameProperty().toLowerCase().contains(lowerCaseFilter)) {
                            return true; 
                        }
                    break;
                    case "Department":
                        if (doctor.getDepartmentProperty().toLowerCase().contains(lowerCaseFilter)) {
                            return true; 
                        }
                    break;
                }
                return false;
            });
        });
    }

    public void setEditable() {
        doctorTable.setEditable(true);
        setTableColumnProperty(doctorNameColumn, "doctorname", 0);
        setTableColumnProperty(departmentColumn, "department", 0);
        doctorIdColumn.setEditable(false);
        departmentColumn.setEditable(false);
        
    }

    public void forceRefresh() {
        new java.util.Timer().schedule(new java.util.TimerTask() {
            public void run() {
                Platform.runLater(() -> {
                    TableView<Doctor> docTab;
                    docTab = doctorTable;
                    docTab.getColumns().get(0).setVisible(false);
                    docTab.getColumns().get(0).setVisible(true);
                });
            }
        }, 50);
    }
    
    public void getDepartment()
    {
        departmentData.clear();
             Connection con=null;
            try {
                con=Connect_with_database.createConnection();
            String sql = "SELECT * from fp.pchand_department";
            st = con.createStatement();
            rs = st.executeQuery(sql);
            while (rs.next()) {
                Department d=new Department();
                d.setDepartmentIdProperty(rs.getInt(1)+"");
                d.setDepartmentNameProperty(rs.getString(2));
                departmentData.add(d);
            }
            }
            catch (Exception ex) {
            ex.printStackTrace();
        }
            finally
            {
                Connect_with_database.closeConnection(con);
            }   
      }
    
    public void initDepartmentCb()
    {
        for(int i=0;i<departmentData.size();i++)
        {
        cbAddDepartment.getItems().add(departmentData.get(i).getDepartmentNameProperty());               
        }
        cbAddDepartment.setValue(departmentData.get(0).getDepartmentNameProperty());
    }
}
