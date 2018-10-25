package codility;

import org.junit.Assert;
import org.junit.Test;

import static org.hamcrest.core.Is.is;

public class RepeatedStringTest {

    @Test
    public void repeatedString() {
        Assert.assertThat(RepeatedString.repeatedString("epsxyyflvrrrxzvnoenvpegvuonodjoxfwdmcvwctmekpsnamchznsoxaklzjgrqruyzavshfbmuhdwwmpbkwcuomqhiyvuztwvq", 549382313570L), is(16481469408L));
        Assert.assertThat(RepeatedString.repeatedString("aab", 882787), is(588525L));
        Assert.assertThat(RepeatedString.repeatedString("addddddddddda", 2), is(1L));
        Assert.assertThat(RepeatedString.repeatedString("a", 100), is(100L));
        Assert.assertThat(RepeatedString.repeatedString("aca", 10), is(7L));
        Assert.assertThat(RepeatedString.repeatedString("fffeeeeff", 1000), is(0L));
    }
}