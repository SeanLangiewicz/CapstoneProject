package model;

public abstract class Prebuilt
{
    private int id;
    private String name;
    private String description;
    private String processor;
    private String caseType;
    private String graphicsCard;
    private String motherBoard;
    private String powerSupply;
    private int RAM;
    private int onHand;
    private int minOnHand;
    private float price;
    private float discount;


    public Prebuilt(int id, String name, String description, String processor, String caseType, String graphicsCard, String motherBoard, String powerSupply, int RAM, int onHand, int minOnHand, float price, float discount) {
        this.id = id;
        this.name = name;
        this.description = description;
        this.processor = processor;
        this.caseType = caseType;
        this.graphicsCard = graphicsCard;
        this.motherBoard = motherBoard;
        this.powerSupply = powerSupply;
        this.RAM = RAM;
        this.onHand = onHand;
        this.minOnHand = minOnHand;
        this.price = price;
        this.discount = discount;
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

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public String getProcessor() {
        return processor;
    }

    public void setProcessor(String processor) {
        this.processor = processor;
    }

    public String getCaseType() {
        return caseType;
    }

    public void setCaseType(String caseType) {
        this.caseType = caseType;
    }

    public String getGraphicsCard() {
        return graphicsCard;
    }

    public void setGraphicsCard(String graphicsCard) {
        this.graphicsCard = graphicsCard;
    }

    public String getMotherBoard() {
        return motherBoard;
    }

    public void setMotherBoard(String motherBoard) {
        this.motherBoard = motherBoard;
    }

    public String getPowerSupply() {
        return powerSupply;
    }

    public void setPowerSupply(String powerSupply) {
        this.powerSupply = powerSupply;
    }

    public int getRAM() {
        return RAM;
    }

    public void setRAM(int RAM) {
        this.RAM = RAM;
    }

    public int getOnHand() {
        return onHand;
    }

    public void setOnHand(int onHand) {
        this.onHand = onHand;
    }

    public int getMinOnHand() {
        return minOnHand;
    }

    public void setMinOnHand(int minOnHand) {
        this.minOnHand = minOnHand;
    }

    public float getPrice() {
        return price;
    }

    public void setPrice(float price) {
        this.price = price;
    }

    public float getDiscount() {
        return discount;
    }

    public void setDiscount(float discount) {
        this.discount = discount;
    }







}
