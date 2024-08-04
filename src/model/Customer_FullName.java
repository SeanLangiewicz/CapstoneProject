package model;

public class Customer_FullName
{
    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getFullName() {
        return fullName;
    }

    public void setFullName(String fullName) {
        this.fullName = fullName;
    }

    int id;

    public Customer_FullName(int id, String fullName) {
        this.id = id;
        this.fullName = fullName;
    }
    public String toString()
    {
        return (fullName);
    }

    String fullName;
 }
