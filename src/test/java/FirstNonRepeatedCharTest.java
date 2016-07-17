import org.junit.Test;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertFalse;

public class FirstNonRepeatedCharTest {

    @Test
    public void testFind() throws Exception {
        assertEquals("s", FirstNonRepeatedChar.find("ababattasna").get());
        assertEquals("t", FirstNonRepeatedChar.find("stress").get());
        assertEquals("r", FirstNonRepeatedChar.find("teeter").get());
        assertFalse(FirstNonRepeatedChar.find("aabbccee").isPresent());
    }
}