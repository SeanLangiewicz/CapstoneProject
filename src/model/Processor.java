package model;

public class Processor
{



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

    public int getSpeed() {
        return speed;
    }

    public void setSpeed(int speed) {
        this.speed = speed;
    }

    public String getSocket() {
        return socket;
    }

    public void setSocket(String socket) {
        this.socket = socket;
    }

    public int getCores() {
        return cores;
    }

    public void setCores(int cores) {
        this.cores = cores;
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


    public Processor(int id, String name, String description, String make, String model, int speed, String socket, int cores, int onHand, int minOnHand, float price, float discount) {
        this.id = id;
        this.name = name;
        this.description = description;
        this.make = make;
        this.model = model;
        this.speed = speed;
        this.socket = socket;
        this.cores = cores;
        this.onHand = onHand;
        this.minOnHand = minOnHand;
        this.price = price;
        this.discount = discount;
    }
    public String toString()
    {
        return (name);
    }

    int id;
    String name;
    String description;
    String make;
    String model;
    int speed;
    String socket;
    int cores;
    int onHand;
    int minOnHand;
    float price;
    float discount;
}
