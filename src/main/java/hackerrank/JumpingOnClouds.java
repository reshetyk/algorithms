package hackerrank;

public class JumpingOnClouds {
    public static int count (int... seq) {
        int jumps = 0;
        for (int i = 0; i + 1 < seq.length; i++, jumps++) {
            if (i + 2 < seq.length && seq[i + 2] == 0)  {
                i = i + 1;
            }
        }

        return jumps;
    }
}
