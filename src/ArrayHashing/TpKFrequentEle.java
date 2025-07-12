package ArrayHashing;

import java.util.ArrayList;
import java.util.HashMap;

public class TpKFrequentEle {
    public static void main(String[] args) {

        int[] inp = new int[]{1,1,1,2,2,3};
        int k = 2;

        int[] res = getTopKElements(inp, k);
        for (int re : res) {
            System.out.println(re + " ");
        }
    }

    private static int[] getTopKElements(int[] inp, int k) {
        int[] res = new int[k];

        HashMap<Integer,Integer> map = new HashMap<>();
        for (int j : inp) {
            map.merge(j, 1, Integer::sum);
        }
        ArrayList<Integer> list = new ArrayList<>(map.keySet());
        list.sort((a,b) -> map.get(b) - map.get(a));
        for(int i=0;i<k;i++){
            res[i]=list.get(i);
        }
        return res;

    }
}
