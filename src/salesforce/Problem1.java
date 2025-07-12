package salesforce;

import java.util.*;

// Driver Class
public class Problem1 {

    public static void main(String[] args)
    {
        String str = "0082663";

        System.out.println(getLargestNumber(str));
    }

    public static String getLargestNumber(String str)
    {
        int[] nums = new int[str.length()];
        List<List<Integer>> resultList = new ArrayList<>();
        StringBuilder sb = new StringBuilder();
        
        for (int i = 0; i < str.length(); i++) {
            nums[i] = (Integer.parseInt(String.valueOf(str.charAt(i))));
        }
        int i = 0;

        while (i < str.length()) {
            int j = i;
            List<Integer> temp = new ArrayList<>();

            while (j < (str.length() - 1) && ((nums[j] ^ nums[j+1]) & 1) == 0) {
                temp.add(nums[j]);
                j++;
            }

            temp.add(nums[j]);
            Collections.sort(temp, Collections.reverseOrder());
            resultList.add(temp);
            i = j + 1;
        }

        for (List<Integer> lst : resultList) {
            for (Integer num : lst) {
                sb.append(num);
            }
        }

        return sb.toString();
    }
}