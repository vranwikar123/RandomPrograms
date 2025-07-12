package ArrayHashing;

import java.util.Stack;

public class Asteroids {

    public static void main(String[] args) {
        int[] asteroids = {10, 5, -5};
        Stack<Integer> stack = new Stack<Integer>();
        boolean flag = true;
        for (int i = 0; i < asteroids.length; i++)
        {
            while (!stack.isEmpty() && stack.peek() < 0 && asteroids[i] > 0)
            {

            }

            if(flag)
            {
                stack.push(asteroids[i]);
            }
        }
    }
}
