package model;

import java.sql.Date;
import java.time.LocalDate;

public class Built_by_Builder
{    int buildNumber;
    String caseName;
    String graphicCardName;
    String motherboardName;
    String powerSupply;
    String processorName;
    String ramName;
    Float price;
    int builderID;
    int customerID;
    LocalDate date;

    public Built_by_Builder(int buildNumber, String caseName, String graphicCardName, String motherboardName, String powerSupply, String processorName, String ramName, Float price, int builderID, int customerID, LocalDate date) {
        this.buildNumber = buildNumber;
        this.caseName = caseName;
        this.graphicCardName = graphicCardName;
        this.motherboardName = motherboardName;
        this.powerSupply = powerSupply;
        this.processorName = processorName;
        this.ramName = ramName;
        this.price = price;
        this.builderID = builderID;
        this.customerID = customerID;
        this.date = date;
    }

    public int getBuildNumber() {
        return buildNumber;
    }

    public void setBuildNumber(int buildNumber) {
        this.buildNumber = buildNumber;
    }

    public String getCaseName() {
        return caseName;
    }

    public void setCaseName(String caseName) {
        this.caseName = caseName;
    }

    public String getGraphicCardName() {
        return graphicCardName;
    }

    public void setGraphicCardName(String graphicCardName) {
        this.graphicCardName = graphicCardName;
    }

    public String getMotherboardName() {
        return motherboardName;
    }

    public void setMotherboardName(String motherboardName) {
        this.motherboardName = motherboardName;
    }

    public String getPowerSupply() {
        return powerSupply;
    }

    public void setPowerSupply(String powerSupply) {
        this.powerSupply = powerSupply;
    }

    public String getProcessorName() {
        return processorName;
    }

    public void setProcessorName(String processorName) {
        this.processorName = processorName;
    }

    public String getRamName() {
        return ramName;
    }

    public void setRamName(String ramName) {
        this.ramName = ramName;
    }

    public Float getPrice() {
        return price;
    }

    public void setPrice(Float price) {
        this.price = price;
    }

    public int getBuilderID() {
        return builderID;
    }

    public void setBuilderID(int builderID) {
        this.builderID = builderID;
    }

    public int getCustomerID() {
        return customerID;
    }

    public void setCustomerID(int customerID) {
        this.customerID = customerID;
    }

    public LocalDate getDate() {
        return date;
    }

    public void setDate(LocalDate date) {
        this.date = date;
    }
}
