package view_controllers.ShippingScreen;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class ShippingControllerTest
{
    @Test
    void calcTest()
    {
        ShippingController calcPrice = new ShippingController();
       assertEquals(5097f, calcPrice.calcPrice(300f,999f,999f,150f,399f,2250f));

    }

}