package model;

import java.util.Date;

public class InHouseSold
{

    public int getSoldID() {
        return soldID;
    }

    public void setSoldID(int soldID) {
        this.soldID = soldID;
    }

    public int getComputerID() {
        return computerID;
    }

    public void setComputerID(int computerID) {
        this.computerID = computerID;
    }

    public int getCustomerID() {
        return customerID;
    }

    public void setCustomerID(int customerID) {
        this.customerID = customerID;
    }

    public Date getSoldDate() {
        return soldDate;
    }

    public void setSoldDate(Date soldDate) {
        this.soldDate = soldDate;
    }



    public InHouseSold(int soldID, int computerID, int customerID, Date soldDate) {
        this.soldID = soldID;
        this.computerID = computerID;
        this.customerID = customerID;
        this.soldDate = soldDate;
    }

    int soldID;
    int computerID;
    int customerID;
    Date soldDate;
}
