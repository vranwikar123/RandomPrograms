package ArrayHashing;

import java.util.*;

public class AnagramGrp
{
    /**
     * Given an array of strings strs, group all anagrams together into sublists.
     * You may return the output in any order.
     *
     * An anagram is a string that contains the exact same characters as another string,
     * but the order of the characters can be different.
     *
     * Input: strs = ["act","pots","tops","cat","stop","hat"]
     *
     * Output: [["hat"],["act", "cat"],["stop", "pots", "tops"]]
     * @param args
     */
    public static void main(String[] args)
    {
        String[] inps = {"act","pots","tops","cat","stop","hat"};
        Map<String, List<String>> map = new LinkedHashMap<>();
        List<List<String>> result = new ArrayList<>();

        for(String str: inps)
        {
            char[] sArr = str.toCharArray();
            Arrays.sort(sArr);
            String sDup = new String(sArr);

            if (map.get(sDup) != null)
            {
               List<String> lst = map.get(sDup);
               lst.add(str);
            }
            else
            {
                List<String> lst = new ArrayList<>();
                lst.add(str);
                map.put(sDup, lst);
            }
        }

        for(Map.Entry<String, List<String>> entry : map.entrySet())
        {
            String str = entry.getKey();
            result.add(entry.getValue());
        }

    }
}
