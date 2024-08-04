package model;

import java.sql.Time;
import java.util.Date;

public class Customer
{





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

    public String getInitial() {
        return initial;
    }

    public void setInitial(String initial) {
        this.initial = initial;
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

    public Float getBalance() {
        return balance;
    }

    public void setBalance(Float balance) {
        this.balance = balance;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public Time getLast_Updated() {
        return last_Updated;
    }

    public void setLast_Updated(Time last_Updated) {
        this.last_Updated = last_Updated;
    }

    public String getLast_Updated_By() {
        return last_Updated_By;
    }

    public void setLast_Updated_By(String last_Updated_By) {
        this.last_Updated_By = last_Updated_By;
    }

    public Date getCreate_date() {
        return create_date;
    }

    public void setCreate_date(Date create_date) {
        this.create_date = create_date;
    }

    public String getCreated_by() {
        return created_by;
    }

    public void setCreated_by(String created_by) {
        this.created_by = created_by;
    }



    public Customer(int id, String firstName, String lastName, String initial, int areaCode, int phoneNumber, Float balance, String address, Time last_Updated, String last_Updated_By, Date create_date, String created_by) {
        this.id = id;
        this.firstName = firstName;
        this.lastName = lastName;
        this.initial = initial;
        this.areaCode = areaCode;
        this.phoneNumber = phoneNumber;
        this.balance = balance;
        this.address = address;
        this.last_Updated = last_Updated;
        this.last_Updated_By = last_Updated_By;
        this.create_date = create_date;
        this.created_by = created_by;
    }



    @Override
    public String toString() {
        return "Customer{" +
                "firstName='" + firstName + '\'' +
                ", lastName='" + lastName + '\'' +
                '}';
    }
    private int id;
    private String firstName;
    private String lastName;
    private String initial;
    private int areaCode;
    private int phoneNumber;
    private Float balance;
    private String address;
    private Time last_Updated;
    private String last_Updated_By;
    private Date create_date;
    private String created_by;

}
