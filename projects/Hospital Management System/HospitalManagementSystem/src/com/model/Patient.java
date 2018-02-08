/* <h1>FileName: Patient.java</h1>
 * @author	Phanindra Chandraprakash
 * @version	1.0
 * @date	12/02/2016
 * FinalProject: HospitalManagementSystem
 * Description: This java file contains getters and setters information of Patient screen.
 */
package com.model;

import javafx.beans.property.SimpleStringProperty;

public class Patient {

    private SimpleStringProperty idProperty = new SimpleStringProperty();
    private SimpleStringProperty nameProperty = new SimpleStringProperty();
    private SimpleStringProperty diseaseProperty = new SimpleStringProperty();
    private SimpleStringProperty doctorIdProperty = new SimpleStringProperty();
    private SimpleStringProperty doctorNameProperty = new SimpleStringProperty();
    private SimpleStringProperty ageProperty = new SimpleStringProperty();
    private SimpleStringProperty sexProperty = new SimpleStringProperty();
    private SimpleStringProperty addressProperty = new SimpleStringProperty();
    private SimpleStringProperty phoneProperty = new SimpleStringProperty();
    private SimpleStringProperty weightProperty = new SimpleStringProperty();
    private SimpleStringProperty dischargeDateProperty = new SimpleStringProperty();
    private SimpleStringProperty patientAmountPaidProperty = new SimpleStringProperty();
    private SimpleStringProperty departmentNameProperty = new SimpleStringProperty();
    public void setIdProperty(String s) {
        this.idProperty.setValue(s);
    }

    public void setNameProperty(String s) {
        this.nameProperty.setValue(s);
    }

    public void setDiseaseProperty(String s) {
        this.diseaseProperty.setValue(s);
    }

    public String getIdProperty() {
        return idProperty.get();
    }

    public String getNameProperty() {
        return nameProperty.get();
    }

    public String getDiseaseProperty() {
        return diseaseProperty.get();
    }

    public String getDoctorNameProperty() {
        return doctorNameProperty.get();
    }

    public void setDoctorNameProperty(String doctorNameProperty) {
        this.doctorNameProperty.setValue(doctorNameProperty);
    }

    public String getAgeProperty() {
        return ageProperty.get();
    }

    public void setAgeProperty(String ageProperty) {
        this.ageProperty.setValue(ageProperty);
    }

    public String getSexProperty() {
        return sexProperty.get();
    }

    public void setSexProperty(String sexProperty) {
        this.sexProperty.setValue(sexProperty);
    }

    public String getAddressProperty() {
        return addressProperty.get();
    }

    public void setAddressProperty(String addressProperty) {
        this.addressProperty.setValue(addressProperty);
    }

    public String getPhoneProperty() {
        return phoneProperty.get();
    }

    public void setPhoneProperty(String phoneProperty) {
        this.phoneProperty.setValue(phoneProperty);
    }

    public String getWeightProperty() {
        return weightProperty.get();
    }

    public void setWeightProperty(String weightProperty) {
        this.weightProperty.setValue(weightProperty);
    }
    
    public String getDoctorIdProperty() {
        return doctorIdProperty.get();
    }

    public void setDoctorIdProperty(String doctorId) {
        this.doctorIdProperty.setValue(doctorId);
    }
    
    public String getPatientAmountPaidProperty() {
        return patientAmountPaidProperty.get();
    }

    public void setPatientAmountPaidProperty(String finalamount) {
        this.patientAmountPaidProperty.setValue(finalamount);
    }
    
    public String getDischargeDateProperty() {
        return dischargeDateProperty.get();
    }

    public void setDischargeDateProperty(String dischargedate) {
        this.dischargeDateProperty.setValue(dischargedate);
    }
    
    public void setDepartmentNameProperty(String departmentNameProperty) {
        this.departmentNameProperty.set(departmentNameProperty);
    }
    public String getDepartmentNameProperty() {
        return departmentNameProperty.get();
 
    }
    
}
