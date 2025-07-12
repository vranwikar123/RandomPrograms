package Test;// Framework: Standard Java
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class Turnstile {

    public static void main(String[] args) {
        List<Integer> time = new ArrayList<>();
        List<Integer> direction = new ArrayList<>();

        time.add(0);time.add(0);time.add(1);time.add(5);
        direction.add(0);direction.add(1);direction.add(1);direction.add(0);

        List<Integer> res = turnstile(time, direction);


    }
    public static List<Integer> turnstile(List<Integer> time, List<Integer> direction)
    {
        int peopleSize = time.size();
        int[] result = new int[peopleSize];
        List<Integer> exitQueue = new ArrayList<>();
        List<Integer> enterQueue = new ArrayList<>();
        int index = 0;
        int lastUsed = -1;
        int currentTime = 0;

        while (index < peopleSize || !exitQueue.isEmpty() || !enterQueue.isEmpty()) {

            while (index < peopleSize && time.get(index) <= currentTime) {
                if (direction.get(index) == 1)
                {
                    exitQueue.add(index);
                }
                else
                {
                    enterQueue.add(index);
                }
                index++;
            }

            //&&
            //                    exitQueue.get(0) < enterQueue.get(0)
            if (!exitQueue.isEmpty() && (lastUsed == 0 || enterQueue.isEmpty() || lastUsed == -1 ))
            {
                int exitIndex = exitQueue.remove(0);
                result[exitIndex] = currentTime;
                lastUsed = 0;
            }
            else if (!enterQueue.isEmpty())
            {
                int enterIndex = enterQueue.remove(0);
                result[enterIndex] = currentTime;
                lastUsed = 1;
            }
            else
            {
                currentTime = (index < peopleSize) ? time.get(index) : currentTime + 1;
                lastUsed = -1;
                continue;
            }

            currentTime++;
        }

        List<Integer> resList = new ArrayList<>();

        for (int j : result) {
            resList.add(j);
        }

        return resList;
    }
}