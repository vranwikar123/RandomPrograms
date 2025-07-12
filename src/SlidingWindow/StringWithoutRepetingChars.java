package SlidingWindow;

import java.util.HashSet;
import java.util.Set;

public class StringWithoutRepetingChars {

    public static void main(String[] args) {
        String str = "abcdaef";
        int st = longestSubStrWRepChars(str);
        System.out.println(st);
    }

    private static int longestSubStrWRepChars(String str)
    {
        Set<Character> set = new HashSet<>();
        int start = 0, end = 0, maxLength = 0;

        while(end < str.length())
        {
            if(!set.contains(str.charAt(end)))
            {
                set.add(str.charAt(end));
                maxLength = Math.max(maxLength, end - start + 1);
                end++;
            }
            else
            {
                set.remove(str.charAt(start));
                start++;
            }
        }
        
        return maxLength;
    }


}
