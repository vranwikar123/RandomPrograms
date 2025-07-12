package ArrayHashing;

import java.util.Arrays;
import java.util.Collections;
import java.util.HashMap;
import java.util.Map;

public class RansomNote {

    public static void main(String[] args)
    {
        String ransomNote = "a";
        String magazine = "b";
        System.out.println(canConstruct(ransomNote, magazine));
    }


    public static boolean canConstruct(String ransomNote, String magazine) {

        Map<Character, Integer> map = new HashMap<>();
        for (char c : magazine.toCharArray()) {
            map.put(c, map.getOrDefault(c, 0) + 1);
        }

        for(char c : ransomNote.toCharArray()) {
            if (map.get(c) != null && map.get(c) > 0) {
                map.put(c, map.get(c) - 1);
            }
            else {
                return false;
            }
        }
        return true;
    }
}
