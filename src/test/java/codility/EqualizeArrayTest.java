package codility;

import org.junit.Assert;
import org.junit.Test;

import static org.hamcrest.core.Is.is;

public class EqualizeArrayTest {

    @Test
    public void equalizeArray() {
        Assert.assertThat(EqualizeArray.equalizeArray(3,3,2,1,3), is(2));
        Assert.assertThat(EqualizeArray.equalizeArray(2,1,2), is(1));
        Assert.assertThat(EqualizeArray.equalizeArray(3,5), is(1));
        Assert.assertThat(EqualizeArray.equalizeArray(4,8,8,4,4), is(2));
        Assert.assertThat(EqualizeArray.equalizeArray(2,2,3,3), is(2));
        Assert.assertThat(EqualizeArray.equalizeArray(1,2,5,1), is(2));
    }
}