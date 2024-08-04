package model;

import javafx.collections.FXCollections;
import javafx.collections.ObservableList;

public class Motherboards
{

    private ObservableList<Motherboards> associatedMotherBoards = FXCollections.observableArrayList();


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

    public String getMake() {
        return make;
    }

    public void setMake(String make) {
        this.make = make;
    }

    public String getModel() {
        return model;
    }

    public void setModel(String model) {
        this.model = model;
    }

    public String getSize() {
        return size;
    }

    public void setSize(String size) {
        this.size = size;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
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



    public Motherboards(int id, String name, String make, String model, String size, String description, int onHand, int minOnHand, float price, float discount) {
        this.id = id;
        this.name = name;
        this.make = make;
        this.model = model;
        this.size = size;
        this.description = description;
        this.onHand = onHand;
        this.minOnHand = minOnHand;
        this.price = price;
        this.discount = discount;
    }
    public String toString()
    {
        return (name);
    }

    private int id;
    private String name;
    private String make;
    private String model;
    private String size;
    private String description;
    private int onHand;
    private int minOnHand;
    private float price;
    private float discount;

    public ObservableList<Motherboards>getAssociatedMotherBoards()
    {
        return associatedMotherBoards;
    }
}
