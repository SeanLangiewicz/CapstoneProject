package SLHardwareOrderingSystem;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class unitTestingTest {

    @Test
    void twoPlusTwoShouldEqual4()
    {
        unitTesting calc = new unitTesting();
        assertEquals(4,calc.add(2,2));
    }
    @Test
    void threePlulsSevenShouldEqualTen()
    {
        unitTesting calc = new unitTesting();
        assertEquals(10,calc.add(3,7));
    }
}