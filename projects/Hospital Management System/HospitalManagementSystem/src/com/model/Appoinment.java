/* <h1>FileName: Appoinment.java</h1>
 * @author	Phanindra Chandraprakash
 * @version	1.0
 * @date	12/02/2016
 * FinalProject: HospitalManagementSystem
 * Description: This java file contains getters and setters of Appointment screen.
 */
package com.model;

import javafx.beans.property.SimpleStringProperty;

public class Appoinment 
{
    private  SimpleStringProperty appoinmentidProperty = new SimpleStringProperty();
        private  SimpleStringProperty patientIdProperty = new SimpleStringProperty();
        private  SimpleStringProperty doctorIdProperty = new SimpleStringProperty();
        private  SimpleStringProperty appoinmentDateProperty = new SimpleStringProperty();
        private  SimpleStringProperty appoinmentStatusProperty = new SimpleStringProperty();
        private  SimpleStringProperty doctorNameProperty = new SimpleStringProperty();
        private  SimpleStringProperty patientNameProperty = new SimpleStringProperty();
        private  SimpleStringProperty patientDiseaseProperty = new SimpleStringProperty();

    public String getAppoinmentidProperty() {
        return appoinmentidProperty.get();
    }

    public void setAppoinmentidProperty(String appoinmentidProperty) {
        this.appoinmentidProperty.setValue(appoinmentidProperty);
    }

    public String getPatientIdProperty() {
        return patientIdProperty.get();
    }

    public void setPatientIdProperty(String patientIdProperty) {
        this.patientIdProperty.setValue(patientIdProperty);
    }

    public String getDoctorIdProperty() {
        return doctorIdProperty.get();
    }

    public void setDoctorIdProperty(String doctorIdProperty) {
        this.doctorIdProperty.setValue(doctorIdProperty);
    }

    public String getAppoinmentDateProperty() {
        return appoinmentDateProperty.get();
    }

    public void setAppoinmentDateProperty(String appoinmentDateProperty) {
        this.appoinmentDateProperty.setValue(appoinmentDateProperty);
    }

    public String getAppoinmentStatusProperty() {
        return appoinmentStatusProperty.get();
    }

    public void setAppoinmentStatusProperty(String appoinmentStatusProperty) {
        this.appoinmentStatusProperty.setValue(appoinmentStatusProperty);
    }

    public String getDoctorNameProperty() {
        return doctorNameProperty.get();
    }

    public void setDoctorNameProperty(String doctorNameProperty) {
        this.doctorNameProperty.setValue(doctorNameProperty);
    }

    public String getPatientNameProperty() {
        return patientNameProperty.get();
    }

    public void setPatientNameProperty(String patientNameProperty) {
        this.patientNameProperty.setValue(patientNameProperty);
    }
    
     public String getPatientDiseaseProperty() {
        return patientDiseaseProperty.get();
    }

    public void setPatientDiseaseProperty(String patientDiseaseProperty) {
        this.patientDiseaseProperty.setValue(patientDiseaseProperty);
    }
}