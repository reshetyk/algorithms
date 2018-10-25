package hackerrank;

import org.junit.Test;

public class SuperStackTest {

    @Test
    public void processTest() {
        String sOperations =
                "PUSH 1\n" +
                "POP\n" +
                "PUSH 3\n" +
                "PUSH 4\n" +
                "PUSH 5\n" +
                "INC 3 1\n" +
                "POP\n" +
                "PUSH 9";

        SuperStack.execute(sOperations.split("\\n+"));
//        SuperStackMachine.process(new String[] { "PUSH 4", "POP", "PUSH 3", "PUSH 5", "PUSH 2"
//                , "INC 3 1", "POP", "PUSH 1", "INC 2 2", "PUSH 4"
//                , "POP", "POP", "PUSH 10", "PUSH 11"});
    }
}