package google.easy;

public class MountainArray {
    public static void main(String[] args) {
        int[] inp = {4, 5, 6, 7, 8, 7, 6, 5};
        int peak = -1;
        for(int i = 1; i < inp.length; i++) {
            if(inp[i] > inp[i-1]) {
                i++;
            }
            else
            {
            }

        }
    }
}
