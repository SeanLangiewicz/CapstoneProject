package model;

public class Employees_Builders
{

    public int getEmployeeID() {
        return employeeID;
    }

    public void setEmployeeID(int employeeID) {
        this.employeeID = employeeID;
    }

    public String getFullName() {
        return fullName;
    }

    public void setFullName(String fullName) {
        this.fullName = fullName;
    }

    public Employees_Builders(int employeeID, String fullName) {
        this.employeeID = employeeID;
        this.fullName = fullName;
    }


    @Override
    public String toString() {
        return (fullName);
    }
    int employeeID;
    String fullName;
}
