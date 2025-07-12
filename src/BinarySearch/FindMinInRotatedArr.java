package BinarySearch;

public class FindMinInRotatedArr {

    public static void main(String[] args) {

        int[] inp = {3,4,5,1,2};
        int min = findMin(inp);
        System.out.println(min);
    }

    private static int findMin(int[] inp) {

        if(inp.length == 1)
        {
            return inp[0];
        }

        if(inp.length == 2)
        {
            return Math.min(inp[0], inp[1]);
        }

        int left = 0;
        int right = inp.length - 1;

        if(inp[left] <= inp[right])
        {
            return inp[left];
        }

        while(left <= right)
        {
            int mid = left + (right - left)/2;

            if(inp[mid] > inp[mid+1])
            {
                return inp[mid+1];
            }

            if(inp[mid] < inp[mid-1])
            {
                return inp[mid];
            }

            if(inp[mid] > inp[0])
            {
                left = mid + 1;
            }
            else
            {
                right = mid -1;
            }

        }

        return Integer.MAX_VALUE;
    }

}
