package ArrayHashing;

import java.util.HashMap;
import java.util.Map;

public class TwoSum {

    public static void main(String[] args)
    {
        int[] nums = {1,2,3,4,5,6};
        int target = 10;
        Map<Integer, Integer> map = new HashMap<>();
        int[] res = new int[2];
        for(int i=0;i<nums.length;i++)
        {
            map.put(nums[i], i);
        }

        for (int i = 0; i < nums.length; i++)
        {
            int t = target - nums[i];

            if(map.containsKey(t))
            {
                int j = map.get(t);

                if(i != j)
                {
                    if(i < map.get(t))
                    {
                        res[0] = i;
                        res[1] = j;
                    }
                    else
                    {
                        res[0] = j;
                        res[1] = i;
                    }
                }
            }
        }

        System.out.println(res[0] + " " + res[1]);

    }
}
