/* <h1>FileName: Patient_add_appoinment_tabController.java</h1>
 * @author	Phanindra Chandraprakash
 * @version	1.0
 * @date	12/02/2016
 * FinalProject: HospitalManagementSystem
 * Description: This is an FXML controller class which manages Patient appointment details page.
 */
package com.controller.Tab;

import com.model.Appoinment;
import com.model.Connect_with_database;
import com.model.Current_user_detail;
import com.model.Display_message;
import com.model.Doctor;
import java.net.URL;
import java.sql.Connection;
import java.sql.Date;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.Calendar;
import java.util.ResourceBundle;
import java.util.logging.Level;
import java.util.logging.Logger;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.collections.transformation.FilteredList;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.ComboBox;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.cell.PropertyValueFactory;

public class Patient_add_appoinment_tabController implements Initializable {

    /**
     * Initializes the controller class.
     */
    long last_date=0;
    String currentpatientName=null;
     @FXML
    private ComboBox<String> cbDoctors;
     
     private ObservableList<Doctor> doctorData = FXCollections.observableArrayList();
     private ObservableList<Appoinment> appoinmentData = FXCollections.observableArrayList();
   
     @FXML
    private TableView appoinmentsTable;
    @FXML
    private TableColumn appoinmentIdColumn;
    @FXML
    private TableColumn patientNameColumn;
    @FXML
    private TableColumn doctorNameColumn;
    @FXML
    private TableColumn appoinmentDateColumn;
    @FXML
    private TableColumn isConfirmedColumn;
     
     
     @Override
    public void initialize(URL url, ResourceBundle rb) {
        // TODO
        getMaxDate();
        getDoctorData();
        cbSearchInit();
        getAppoinmentData();
        initTable();
        
        
    }    
     public void cbSearchInit() 
     {
         for(int i=0;i<doctorData.size();i++)
         {
             cbDoctors.getItems().add(doctorData.get(i).getNameProperty());
         }
        if(doctorData.size()>0)
            cbDoctors.setValue(doctorData.get(0).getNameProperty());
    }
    private void getDoctorData() 
    {
        Connection con=null;
            try {
                con=Connect_with_database.createConnection();
            String sql = "SELECT * FROM fp.pchand_Doctor";
            Statement st = con.createStatement();
            ResultSet rs = st.executeQuery(sql);
            while (rs.next()) {
                Doctor doctor = new Doctor();
                doctor.setIdProperty(rs.getInt(1)+"");
                doctor.setNameProperty(rs.getString(2));
                doctor.setDepartmentProperty(rs.getInt(3)+"");
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
     
    private void getAppoinmentData() 
    {
        Connection con=null;
            try {
                con=Connect_with_database.createConnection();
            String sql = "SELECT fp.pchand_appoinments.*,fp.pchand_doctor.doctorname FROM fp.pchand_appoinments  INNER JOIN fp.pchand_Doctor On fp.pchand_appoinments.doctorid = fp.pchand_doctor.doctorid where fp.pchand_appoinments.patientid="+Current_user_detail.current_user_id;
            Statement st = con.createStatement();
            ResultSet rs = st.executeQuery(sql);
            while (rs.next()) {
                Appoinment appoinment=new Appoinment();
                appoinment.setAppoinmentidProperty(rs.getInt(1)+"");
                appoinment.setPatientIdProperty(rs.getInt(2)+"");
                appoinment.setDoctorIdProperty(rs.getInt(3)+"");
                appoinment.setAppoinmentDateProperty(rs.getString(4));
                int status=rs.getInt(5);
                if(status==1)
                {
                    appoinment.setAppoinmentStatusProperty("Confirmed");    
                }
                    else
                {
                    appoinment.setAppoinmentStatusProperty("Not Confirmed");
                }                
//appoinment.setPatientNameProperty(Current_user_detail.patient1+"");
                appoinment.setPatientNameProperty("patient1");
                appoinment.setDoctorNameProperty(rs.getString(6));
                appoinmentData.add(appoinment);
                
            }
            if(rs!=null)
                rs.close();
            }
            catch (Exception ex) {
            ex.printStackTrace();
        }
            finally
            {
                Connect_with_database.closeConnection(con);
            }
    }
     public String getDoctorIdFromList(String doctorname)
     {
         for (int i=0;i<doctorData.size();i++)
         {
             if(doctorData.get(i).getNameProperty().equals(doctorname))
                 return doctorData.get(i).getIdProperty();
         }
         return "";
             }
    @FXML
    public void handleAddButton() 
    {
        if(Calendar.getInstance().getTimeInMillis()<last_date)
        {
            Display_message.showError("Error", "You already have one appoinment!");
            return;
        } 
        if(!checkCanInsert())
        {
            Display_message.showError("Error", "You already have applied for appoinment!");
            return;
        }
        else {
            String doctorName =cbDoctors.getValue();
            String doctorId="";
            String appoinmentId="";
            String patient_name="";
            
            String add = "INSERT INTO fp.pchand_appoinments (patientid,doctorid,appoinmenttime,confirmed)"
                    + "VALUES (?, ?,?, ?)";
            Connection con=null;
            try {
                con=Connect_with_database.createConnection();
                PreparedStatement ps =con.prepareStatement(add);
                ps.setInt(1, Current_user_detail.current_user_id);
                ps.setInt(2,Integer.parseInt(doctorId=getDoctorIdFromList(doctorName)));
                ps.setString(3,"0000-00-00 00:00:00");
                ps.setInt(4, 0);
                int res=ps.executeUpdate();
                if(res>0)
                {
                    ps.close();
                    String appoinmentid=getAppoinmentId(con)+"";
                   Appoinment appoinment=new Appoinment();
                   appoinment.setAppoinmentidProperty(appoinmentid);
                   appoinment.setDoctorIdProperty(doctorId);
                   appoinment.setDoctorNameProperty(doctorName);
                   appoinment.setPatientIdProperty(Current_user_detail.current_user_id+"");    
                   appoinment.setPatientNameProperty(currentpatientName);
                   appoinment.setAppoinmentDateProperty("");
                   appoinment.setAppoinmentStatusProperty("Not Confirmed");
                    appoinmentData.add(appoinment);
                }
                else
                {
                    Display_message.showError("Error", "Record Not Inserted!");
                }
            } catch (SQLException ex) {
                Display_message.showError("Exception", "Ooops, there was an exception!");
                ex.printStackTrace();
            }
            finally
            {
            Connect_with_database.closeConnection(con);
            }
        }
        
    }
    private void initTable() {
        appoinmentIdColumn.setCellValueFactory(
                new PropertyValueFactory<>("appoinmentidProperty")
        );
        patientNameColumn.setCellValueFactory(
                new PropertyValueFactory<>("patientNameProperty")
        );
        appoinmentDateColumn.setCellValueFactory(
                new PropertyValueFactory<>("appoinmentDateProperty")
        );
        doctorNameColumn.setCellValueFactory(
                new PropertyValueFactory<>("doctorNameProperty")
        );
        isConfirmedColumn.setCellValueFactory(
                new PropertyValueFactory<>("appoinmentStatusProperty")
        );
        
        
        FilteredList<Appoinment> filteredData = new FilteredList<>(appoinmentData, p -> true);
        appoinmentsTable.setItems(filteredData);

       
    }
    public void getMaxDate()
    {
        PreparedStatement ps=null;
        ResultSet rs=null;
        Connection con=null;    
        try {
            con=Connect_with_database.createConnection();
                String checkAccount = "SELECT max(appoinmenttime) FROM fp.pchand_appoinments where patientid=? and confirmed=1";
                ps = con.prepareStatement(checkAccount);
                ps.setInt(1,Current_user_detail.current_user_id);
                rs = ps.executeQuery();
                if (rs.next()) {
                    Date date=rs.getDate(1);
                    if(date!=null)
                    last_date =date.getTime();
                  }
            } catch (Exception e) {
                e.printStackTrace();
            }
            finally
            {
            try {
                ps.close();
                rs.close();
                Connect_with_database.closeConnection(con);
            } catch (SQLException ex) {
                Logger.getLogger(PatientTabController.class.getName()).log(Level.SEVERE, null, ex);
            }
            }
    }
    public int getAppoinmentId(Connection con)
    {
     
        PreparedStatement ps=null;
        ResultSet rs=null;
            
        try {
            con=Connect_with_database.createConnection();
                String checkAccount = "SELECT max(fp.pchand_appoinments.appoinmentid),fp.pchand_patient.patientname FROM fp.pchand_appoinments INNER JOIN fp.pchand_patient on fp.pchand_appoinments.patientid=fp.pchand_patient.patientid";
                ps = con.prepareStatement(checkAccount);
                rs = ps.executeQuery();
                if (rs.next())
                {
                    int value = rs.getInt(1);
                    currentpatientName=rs.getString(2);
                    return value;
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
        return 0;
    }
    public boolean checkCanInsert()
    {
        PreparedStatement ps=null;
        ResultSet rs=null;
        Connection con=null;    
        try {
            con=Connect_with_database.createConnection();
                String checkAccount = "SELECT * FROM fp.pchand_appoinments where patientid=? and confirmed=0";
                ps = con.prepareStatement(checkAccount);
                ps.setInt(1,Current_user_detail.current_user_id);
                rs = ps.executeQuery();
                if (rs.next()) {
                    return false;
                  }
            } catch (Exception e) {
                e.printStackTrace();
            }
            finally
            {
            try {
                ps.close();
                rs.close();
                Connect_with_database.closeConnection(con);
            } catch (SQLException ex) {
                Logger.getLogger(PatientTabController.class.getName()).log(Level.SEVERE, null, ex);
            }
            }
        return true;
            }
}