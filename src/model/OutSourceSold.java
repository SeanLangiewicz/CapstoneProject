package model;

import java.util.Date;

public class OutSourceSold
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

    public Float getPrice() {
        return price;
    }

    public void setPrice(Float price) {
        this.price = price;
    }

    int soldID;
    int computerID;
    int customerID;
    Date soldDate;
    Float price;

    public OutSourceSold(int soldID, int computerID, int customerID, Date soldDate, Float price) {
        this.soldID = soldID;
        this.computerID = computerID;
        this.customerID = customerID;
        this.soldDate = soldDate;
        this.price = price;
    }
}
