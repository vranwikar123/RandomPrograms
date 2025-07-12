package TwoPointer;

/**
 * Max Water Container
 *
 * You are given an integer array heights where heights[i] represents the height of the ithith bar.
 *
 * You may choose any two bars to form a container. Return the maximum amount of water a container can store.
 */
public class MaxContainer {
    public static void main(String[] args) {
        int[] inp = {1,7,2,5,4,7,3,6};
        int res = getMaxWaterContain(inp);

        System.out.println(res);

    }

    private static int getMaxWaterContain(int[] inp)
    {
        int left = 0;
        int right = inp.length -1;
        int res = 0;

        while(left < right)
        {
            int cl = right - left;
            int maxArea = cl * Math.min(inp[left], inp[right]);
            res = Math.max(maxArea, res);

            if(inp[left] < inp[right])
            {
                left++;
            }
            else
            {
                right--;
            }
        }

        return res;
    }
}
