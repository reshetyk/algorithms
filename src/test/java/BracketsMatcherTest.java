import org.junit.Test;

import static org.junit.Assert.assertEquals;

public class BracketsMatcherTest {

    @Test
    public void testCheck() throws Exception {
        assertEquals(false, BracketsMatcher.check("t(se)s)"));
        assertEquals(true, BracketsMatcher.check(""));
        assertEquals(true, BracketsMatcher.check("a(b)"));
        assertEquals(true, BracketsMatcher.check("[{}]"));
        assertEquals(false, BracketsMatcher.check("[(]"));
        assertEquals(false, BracketsMatcher.check("}{"));
        assertEquals(true, BracketsMatcher.check("z([{}-()]{a})"));
        assertEquals(true, BracketsMatcher.check("(the (test)of the brackets)"));

    }

    @Test
    public void testIsBalanced() throws Exception {
        assertEquals(false, BracketsMatcher.isBalanced(""));
        assertEquals(true, BracketsMatcher.isBalanced("[{}]"));
        assertEquals(false, BracketsMatcher.isBalanced("[(]"));
        assertEquals(false, BracketsMatcher.isBalanced("}{"));
//        assertEquals(true, BracketsMatcher.check("([{}()]{})"));
//        assertEquals(true, BracketsMatcher.check("(the (test)of the brackets)"));

    }
}