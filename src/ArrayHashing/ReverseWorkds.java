package ArrayHashing;

public class ReverseWorkds {
    public static void main(String[] args) {
        char[] st = {'t','h','e',' ','s','k','y',' ','i','s',' ','b','l','u','e'};
        reverseWords(st);
    }
    public static void reverseWords(char[] s) {
        int l = 0;
        int st = 0;
        int length = s.length;

        while(l < length)
        {
            st = l;
            while((l < length && s[l] != ' '))
                l++;

            reverse(st, l-1, s);
            l++;
        }
        System.out.println();
    }

    public static void reverse(int s, int e, char[] ch)
    {
        while(s<e)
        {
            char chr = ch[s];
            ch[s] = ch[e];
            ch[e] = chr;
            s++;
            e--;
        }
    }

}
