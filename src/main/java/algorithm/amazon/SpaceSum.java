package algorithm.amazon;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.StringReader;
import java.util.Arrays;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * Created by Reshetuyk on 15.06.2017.
 */
public class SpaceSum {
    private final static Map<String, List<String>> map = new HashMap<>();

    static {
        map.put("music", Arrays.asList("mp3","aac", "flac"));
        map.put("image", Arrays.asList("jpg","bmp", "gif"));
    }

    public String solution(String S) {

        BufferedReader bufReader = new BufferedReader(new StringReader(S));
        StringBuffer res = new StringBuffer();
        String line;
        try {
            while( (line=bufReader.readLine()) != null )
            {
                String[] split = line.split("\\s");
                String fileName = split[0];
                String ext = fileName.substring(fileName.lastIndexOf('.') + 1);
                String size = split[1];
                String unit = size.substring(size.length() - 1);

            }
        } catch (IOException e) {
            throw new RuntimeException(e);
        }


        return "";
    }
}
