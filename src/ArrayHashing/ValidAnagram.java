package ArrayHashing;

import java.util.Arrays;

public class ValidAnagram
{
    public static void main(String[] args)
    {
        String  s = "racecar", t = "carrace";

        char[] sArr = s.toCharArray() ;
        char[] tArr = t.toCharArray() ;

        Arrays.sort(sArr);
        Arrays.sort(tArr);

        String sDup = new String(sArr);
        String tDup = new String(tArr);

        System.out.println(sDup.equals(tDup));
    }
}
