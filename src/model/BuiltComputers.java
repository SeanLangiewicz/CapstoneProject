package model;

public class BuiltComputers
{


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

    public String getGraphicsCardName() {
        return graphicsCardName;
    }

    public void setGraphicsCardName(String graphicsCardName) {
        this.graphicsCardName = graphicsCardName;
    }

    public String getMotherboardName() {
        return motherboardName;
    }

    public void setMotherboardName(String motherboardName) {
        this.motherboardName = motherboardName;
    }

    public String getPowerSupplyName() {
        return powerSupplyName;
    }

    public void setPowerSupplyName(String powerSupplyName) {
        this.powerSupplyName = powerSupplyName;
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

    public Float getTotalPrice() {
        return totalPrice;
    }

    public void setTotalPrice(Float totalPrice) {
        this.totalPrice = totalPrice;
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



    public BuiltComputers(int buildNumber, String caseName, String graphicsCardName, String motherboardName, String powerSupplyName, String processorName, String ramName, Float totalPrice, int builderID, int customerID) {
        this.buildNumber = buildNumber;
        this.caseName = caseName;
        this.graphicsCardName = graphicsCardName;
        this.motherboardName = motherboardName;
        this.powerSupplyName = powerSupplyName;
        this.processorName = processorName;
        this.ramName = ramName;
        this.totalPrice = totalPrice;
        this.builderID = builderID;
        this.customerID = customerID;
    }

    int buildNumber;
    String caseName;
    String graphicsCardName;
    String motherboardName;
    String powerSupplyName;
    String processorName;
    String ramName;
    Float totalPrice;
    int builderID;
    int customerID;
}
