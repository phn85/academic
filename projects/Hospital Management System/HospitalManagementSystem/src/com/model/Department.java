/* <h1>FileName: Department.java</h1>
 * @author	Phanindra Chandraprakash
 * @version	1.0
 * @date	12/02/2016
 * FinalProject: HospitalManagementSystem
 * Description: This java file contains getters and setters of Department screen.
 */
package com.model;

import javafx.beans.property.SimpleStringProperty;

public class Department
{
    private  SimpleStringProperty departmentIdProperty = new SimpleStringProperty();
    private  SimpleStringProperty departmentNameProperty = new SimpleStringProperty();

    public String getDepartmentIdProperty() {
        return departmentIdProperty.get();
    }

    public void setDepartmentIdProperty(String departmentIdProperty) {
        this.departmentIdProperty.set(departmentIdProperty);
    }
    public String getDepartmentNameProperty() {
        return departmentNameProperty.get();
    }

    public void setDepartmentNameProperty(String departmentNameProperty) {
        this.departmentNameProperty.set(departmentNameProperty);
    }
}
