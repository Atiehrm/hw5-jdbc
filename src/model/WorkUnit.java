package model;

import java.util.ArrayList;
import java.util.List;

public class WorkUnit {
    private int id;
    private String name;
    private int phone;
    private List<Employee> employees = new ArrayList<>();

    public WorkUnit(int id, String name, int phone) {
        this.id = id;
        this.name = name;
        this.phone = phone;
    }

    public List<Employee> getEmployees() {
        return employees;
    }

    public void setEmployees(List<Employee> employees) {
        this.employees = employees;
    }

    public WorkUnit(String name, int phone) {
        this.id = id;
        this.name = name;
        this.phone = phone;
    }

    public WorkUnit() {
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getPhone() {
        return phone;
    }

    public void setPhone(int phone) {
        this.phone = phone;
    }

    @Override
    public String toString() {
        return "WorkUnit{ id = " + id +
                " Name = " + name +
                " phone = " + phone +
                '}';
    }
}
