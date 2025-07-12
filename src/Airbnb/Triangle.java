package Airbnb;

public class Triangle {

    public static void main(String[] args) {

        System.out.println(pointsBelong(452 ,476 ,46 ,1790 ,184 ,1656 ,1 ,1 ,2 ,2 ));
    }

    public static int pointsBelong(int x1, int y1, int x2, int y2, int x3, int y3, int xp, int yp, int xq, int yq) {
        // Write your code here
        int p1 = x1 > x2 ? x1-x2 : x2-x1;
        int p2 = y1 > y2 ? y1-y2 : y2-y1;

        double ab = Math.sqrt(Math.abs(p1*p1 - p2*p2));

        p1 =x2 > x3 ? x2-x3 : x3-x2;
        p2 = y2 > y3 ? y2-y3 : y3-y2;

        double bc = Math.sqrt(Math.abs(p1*p1 - p2*p2));

        p1 = x1 > x3 ? x1-x3 : x3-x1;
        p2 = y1 > y3 ? y1-y3 : y3-y2;

        double ac = Math.sqrt(Math.abs(p1*p1 - p2*p2));

        if ( (ab + bc <= ac) || (bc + ac <= ab) || (ac + bc <= ac) ) {
            return 0;
        }

        boolean isP1Inside = isInside(x1, y1, x2, y2, x3, y3, xp, yp);
        boolean isP2Inside = isInside(x1, y1, x2, y2, x3, y3, xq, yq);

        StringBuilder sb = new StringBuilder();
        sb.append(x1 + " ,");
        sb.append(y1 + " ,");
        sb.append(x2 + " ,");
        sb.append(y2 + " ,");
        sb.append(x3 + " ,");
        sb.append(y3 + " ,");
        sb.append(xp + " ,");
        sb.append(yp + " ,");
        sb.append(xq + " ,");
        sb.append(yq + " ,");
        sb.append(isP1Inside);
        sb.append(isP2Inside);
        System.out.println(sb.toString());
        if (isP1Inside && !isP2Inside)
        {
            return 1;
        }

        if (!isP1Inside && isP2Inside)
        {
            return 2;
        }

        if (isP1Inside && isP2Inside)
        {
            return 3;
        }

        if (!isP1Inside && !isP2Inside)
        {
            return 4;
        }

        return -1;
    }

    private static double triangleArea(int x1, int y1, int x2, int y2,
                       int x3, int y3)
    {
        return Math.abs((x1*(y2-y3) + x2*(y3-y1)+ x3*(y1-y2))/2.0);
    }

    private static boolean isInside(int x1, int y1, int x2,
                            int y2, int x3, int y3, int x, int y)
    {
        double totalArea = triangleArea (x1, y1, x2, y2, x3, y3);
        double areaPart1 = triangleArea (x, y, x2, y2, x3, y3);
        double areaPart2 = triangleArea (x1, y1, x, y, x3, y3);
        double areaPart3 = triangleArea (x1, y1, x2, y2, x, y);

        return (totalArea == areaPart1 + areaPart2 + areaPart3);
    }
}
