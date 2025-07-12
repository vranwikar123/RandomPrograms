package BinarySearch;

public class RotatedArrSearch {
    public static void main(String[] args) {

        int[] inp = {1};
        int pivot = getPivotIndex(inp);
        int target = 1;

        int answer = binarySearch(inp, 0, pivot - 1, target);

        if(answer == -1)
            answer = binarySearch(inp, pivot, inp.length-1, target);

        System.out.println(answer);
    }

    private static int getPivotIndex(int[] inp)
    {
        int left = 0;
        int right = inp.length - 1;

        while(left <= right)
        {
            int mid =left +  (right - left) / 2;

            if(inp[mid] > inp[inp.length-1]) {
                left = mid + 1;
            }
            else {
                right = mid - 1;
            }
        }

        return left;
    }

    private static int binarySearch(
            int[] nums,
            int left,
            int right,
            int target
    ) {
        while (left <= right) {
            int mid = (left + right) / 2;
            if (nums[mid] == target) {
                return mid;
            } else if (nums[mid] > target) {
                right = mid - 1;
            } else {
                left = mid + 1;
            }
        }
        return -1;
    }
}
