package BinarySearch;

public class NextLetter
{
    public static void main(String[] args) {

        System.out.println(nextLetter(
                new char[] { 'a', 'c', 'f', 'h' }, 'f'));
        System.out.println(nextLetter(
                new char[] { 'a', 'c', 'f', 'h' }, 'h'));
    }

    public static char nextLetter(char[] chars, char key)
    {
        int n = chars.length;
        int start = 0;
        int end = n-1;

        while(start <= end)
        {
            int mid = start + (end - start)/2;
            if(key < chars[mid])
            {
                end = mid - 1;
            }
            else
            {
                start = mid + 1;
            }
        }

        return chars[start % n];
    }
}
