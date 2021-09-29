package model;

import java.sql.Date;

public class Employee {
    private int id;
    private String firstName;
    private String lastName;
    private int employeeNumber;
    private Date birthDay;
    private int workUnitId;

    public Employee(String firstName, String lastName, int employeeNumber, Date birthDay, int workUnitId) {
        this.id = id;
        this.firstName = firstName;
        this.lastName = lastName;
        this.employeeNumber = employeeNumber;
        this.birthDay = birthDay;
        this.workUnitId = workUnitId;
    }

    public Employee(int id, String firstName, String lastName, int employeeNumber, Date birthDay, int workUnitId) {
        this.id = id;
        this.firstName = firstName;
        this.lastName = lastName;
        this.employeeNumber = employeeNumber;
        this.birthDay = birthDay;
        this.workUnitId = workUnitId;
    }

    public void setWorkUnitId(int workUnitId) {
        this.workUnitId = workUnitId;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getFirstName() {
        return firstName;
    }

    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    public String getLastName() {
        return lastName;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    public int getWorkUnitId() {
        return workUnitId;
    }

    public int getEmployeeNumber() {
        return employeeNumber;
    }

    public void setEmployeeNumber(int employeeNumber) {
        this.employeeNumber = employeeNumber;
    }

    public Date getBirthDay() {
        return birthDay;
    }

    public void setBirthDay(Date birthDay) {
        this.birthDay = birthDay;
    }


    @Override
    public String toString() {
        return "Employee{ id = " + id +
                " firstName = " + firstName +
                " lastName = " + lastName +
                " employeeNumber = " + employeeNumber +
                " birthday = " + birthDay +
                " workUnit = " + workUnitId +
                '}';
    }
}
