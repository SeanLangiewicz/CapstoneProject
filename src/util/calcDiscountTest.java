package util;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class calcDiscountTest {

    @Test
    void fiveConvertedtoPerceantShouldBePointZerofive()
    {
        calcDiscount calc = new calcDiscount();
        assertEquals(.05f,calc.calcDiscount(5f));



    }


}