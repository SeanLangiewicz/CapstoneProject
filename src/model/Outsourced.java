package model;

/**
 * Polymorphism and and inheritance applied here
 */

public class Outsourced  extends Prebuilt
{
    public String getVendorName() {
        return vendorName;
    }

    public void setVendorName(String vendorName) {
        this.vendorName = vendorName;
    }

    private String vendorName;



    public Outsourced(int id,  String vendorName, String name, String description, String processor, String caseType,
                      String graphicsCard,
                      String motherBoard, String powerSupply, int RAM, int onHand, int minOnHand, float price,
                      float discount)
    {
        super(id, name, description, processor, caseType, graphicsCard, motherBoard, powerSupply, RAM, onHand,
                minOnHand, price, discount);
        this.vendorName = vendorName;
    }
}
