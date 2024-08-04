package model;

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.util.Date;

public class Employees {



    public int getEmployeeNumber() {
        return employeeNumber;
    }

    public void setEmployeeNumber(int employeeNumber) {
        this.employeeNumber = employeeNumber;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
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

    public String getInitial() {
        return initial;
    }

    public void setInitial(String initial) {
        this.initial = initial;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public int getAreaCode() {
        return areaCode;
    }

    public void setAreaCode(int areaCode) {
        this.areaCode = areaCode;
    }

    public int getPhoneNumber() {
        return phoneNumber;
    }

    public void setPhoneNumber(int phoneNumber) {
        this.phoneNumber = phoneNumber;
    }

    int employeeNumber;

    public Employees(int employeeNumber, String title, String firstName, String lastName, String initial, String address, int areaCode, int phoneNumber) {
        this.employeeNumber = employeeNumber;
        this.title = title;
        this.firstName = firstName;
        this.lastName = lastName;
        this.initial = initial;
        this.address = address;
        this.areaCode = areaCode;
        this.phoneNumber = phoneNumber;
    }

    String title;
    String firstName;
    String lastName;
    String initial;
    String address;
    int areaCode;
    int phoneNumber;


}