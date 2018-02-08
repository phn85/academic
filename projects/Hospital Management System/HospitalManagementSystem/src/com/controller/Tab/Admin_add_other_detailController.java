/* <h1>FileName: Admin_add_other_detailController.java</h1>
 * @author	Phanindra Chandraprakash
 * @version	1.0
 * @date	12/02/2016
 * FinalProject: HospitalManagementSystem
 * Description: This is an FXML controller class which manages other details page.
 */
package com.controller.Tab;

import com.model.Connect_with_database;
import com.model.Display_message;
import com.model.Patient;
import java.net.URL;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ResourceBundle;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.TextField;

public class Admin_add_other_detailController implements Initializable {
    /**
     * Initializes the controller class.
     */
    @FXML
    TextField tfDepartmentName;
    @FXML
    TextField tfDiseaseName;
    @Override
    public void initialize(URL url, ResourceBundle rb) {
    }    
  public void handleAddDepartmentButton()
  {
    if (tfDepartmentName.getText().trim().equals("")) {
            Display_message.showError("Error", "Please enter department name!");
            
        } 
        else {
            String departmentname=tfDepartmentName.getText();
            if(checkDepartmentAvailable(departmentname))
            {
                Display_message.showError("Error", "This departemnt alresdy exists!");
                return;
            }
            String add = "INSERT INTO fp.pchand_department (departmentname)"
                    + "VALUES (?)";
            Connection con=null;
            try {
                con=Connect_with_database.createConnection();
                PreparedStatement ps = con.prepareStatement(add);
                ps.setString(1, departmentname);
                int res=ps.executeUpdate();
                if(res>0)
                {
                    ps.close();
                    Display_message.showInformation("Sucessful", "Department added sucessfully");
                    tfDepartmentName.setText("");
                }
                else
                {
                    Display_message.showError("Error", "Record Not Inserted!");
                }
            } catch (SQLException ex) 
            {
                ex.printStackTrace();
                Display_message.showError("Exception", "Ooops, there was an exception!");
            }
            finally
            {
            Connect_with_database.closeConnection(con);
            }
        }
        
    }
   public boolean checkDepartmentAvailable(String departmentname)
    {
        Connection con=null;
            try {
                con=Connect_with_database.createConnection();
            String sql = "SELECT * FROM fp.pchand_department where departmentname='"+departmentname+"'";
            Statement st = con.createStatement();
            ResultSet rs = st.executeQuery(sql);
            if(rs.next())
            {
                return true;
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
            return false;
    }
    public void handleAddDiseaseButton()
    {
      if (tfDiseaseName.getText().trim().equals("")) {
            Display_message.showError("Error", "Please enter disease name!");
            
        } 
        else {
            String diseasename=tfDiseaseName.getText();
            if(checkDiseaseAvailable(diseasename))
            {
                Display_message.showError("Error", "This disease alresdy exists!");
                return;
            }
            String add = "INSERT INTO fp.pchand_disease (diseasename)"
                    + "VALUES (?)";
            Connection con=null;
            try {
                con=Connect_with_database.createConnection();
                PreparedStatement ps = con.prepareStatement(add);
                ps.setString(1, diseasename);
                int res=ps.executeUpdate();
                if(res>0)
                {
                    ps.close();
                    Display_message.showInformation("Sucessful", "Disease added sucessfully");
                    tfDiseaseName.setText("");
                }
                else
                {
                    Display_message.showError("Error", "Record Not Inserted!");
                }
            } catch (SQLException ex) 
            {
                ex.printStackTrace();
                Display_message.showError("Exception", "Ooops, there was an exception!");
            }
            finally
            {
            Connect_with_database.closeConnection(con);
            }
        }
        
    }  
    public boolean checkDiseaseAvailable(String diseasename)
    {
        Connection con=null;
            try {
                con=Connect_with_database.createConnection();
            String sql = "SELECT * FROM fp.pchand_disease where diseasename='"+diseasename+"'";
            Statement st = con.createStatement();
            ResultSet rs = st.executeQuery(sql);
            if(rs.next())
            {
                return true;
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
            return false;
    }
}