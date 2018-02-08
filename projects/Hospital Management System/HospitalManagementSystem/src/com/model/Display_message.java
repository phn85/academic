/* <h1>FileName: Display_message.java</h1>
 * @author	Phanindra Chandraprakash
 * @version	1.0
 * @date	12/02/2016
 * FinalProject: HospitalManagementSystem
 * Description: This java file contains information about alert message dialogue boxes.
 */
package com.model;

import javafx.scene.control.Alert;

public class Display_message 
{
    public static void showInformation(String title,String message)
    {
        Alert alert = new Alert(Alert.AlertType.INFORMATION);
    alert.setTitle(title);
    alert.setContentText(message);
    alert.show();
    }
    public static void showError(String title,String message)
    {
        Alert alert = new Alert(Alert.AlertType.ERROR);
    alert.setTitle(title);
    alert.setContentText(message);
    alert.show();
    } 
}
