package util;

import javafx.scene.Parent;

public class calcDiscount
{


    private static Float totalwithDiscount = null;
    private static Float discountAmount = null;
    private static Float convertDiscount = null;

    public static Float pricewithDiscount(Float price, Float discount)
    {

        int numbForPerct = 100;


        convertDiscount = discount / numbForPerct;
        discountAmount = price * convertDiscount;
        totalwithDiscount = price - discountAmount;

        return price - discountAmount;


    }
    public  Float calcDiscount(Float discount)
    {
        Float discountPercentage = null;
        discountPercentage = discount / 100;

        return discountPercentage;
    }

}
