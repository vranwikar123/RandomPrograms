package TwoPointer;

/**
 * Given a string s, return true if it is a palindrome, otherwise return false.
 * A palindrome is a string that reads the same forward and backward. It is also case-insensitive and ignores
 * all non-alphanumeric characters.
 * Example 1:
 * Input: s = "Was it a car or a cat I saw?"
 * Output: true
 */
public class ValidPalindrome {
    public static void main(String[] args) {

        String str = "Was it a car or a cat I saw?";
        System.out.println(isValidPalindrome(str));
    }

    private static boolean isValidPalindrome(String str) {
        StringBuilder sb = new StringBuilder();

        for(Character ch: str.toCharArray())
        {
            if(Character.isLetterOrDigit(ch))
                sb.append(Character.toLowerCase(ch));
        }

        String st = sb.toString();
        String revStr = sb.reverse().toString();

        if(revStr.equals(st)) {
            return true;
        }
        else {
            return false;
        }
    }
}
