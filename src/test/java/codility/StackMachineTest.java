package codility;

import org.junit.Test;

import static codility.StackMachine.calc2;
import static org.junit.Assert.assertEquals;

public class StackMachineTest {

    @Test
    public void testCalc() throws Exception {

        assertEquals(182, calc2("13+62*7+*"));
//        assertEquals(-1, calc("12++"));
//        assertEquals(-1, calc(""));
//        assertEquals(-1, calc("21+3g+"));
    }
}