package model;

/**
 * Polymorphism and and inheritance applied here
 */

public class InHouse extends  Prebuilt
{
    private int buildNumber;

    public Integer getBuildNumber()
    {
        return buildNumber;
    }
    public InHouse(int id,String name, int buildNumber, String description, String processor, String caseType,
                   String graphicsCard, String motherBoard, String powerSupply, int RAM, int onHand, int minOnHand,
                   float price, float discount )
    {
        super(id, name, description, processor, caseType, graphicsCard, motherBoard, powerSupply, RAM, onHand,
                minOnHand, price, discount);
        this.buildNumber = buildNumber;
    }
}
