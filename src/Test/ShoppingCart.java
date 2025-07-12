package Test;

import java.util.*;

public class ShoppingCart {

    public static int findLowestPrice(List<List<String>> products, List<List<String>> discounts)
    {
        Map<String, List<DiscountInfo>> discountInfoMap = new HashMap<>(); // Map to store discounts

        for (List<String> discount : discounts) {
            String tag = discount.get(0);
            int type = Integer.parseInt(discount.get(1));
            int amount = Integer.parseInt(discount.get(2));

            if (!discountInfoMap.containsKey(tag)) {
                discountInfoMap.put(tag, new ArrayList<>());
            }
            discountInfoMap.get(tag).add(new DiscountInfo(type, amount));
        }

        int totalCost = 0;

        for (List<String> product : products)
        {
            int productPrice = Integer.parseInt(product.get(0));
            int minPrice = productPrice;

            for (int i = 1; i < product.size(); i++)
            {
                if (!product.get(i).equals("EMPTY"))
                {
                    List<DiscountInfo> discountInfoList = discountInfoMap.get(product.get(i));
                    for(DiscountInfo discount : discountInfoList)
                    {
                        int type = discount.getType();
                        int amount = discount.getValue();

                        if (type == 0)
                        {
                            minPrice = Math.min(minPrice, amount);
                        }
                        else if (type == 1)
                        {
                            int discountedPrice = (int) (productPrice - ((productPrice * amount) / 100.0));
                            minPrice = Math.min(minPrice, discountedPrice);
                        }
                        else if (type == 2)
                        {
                            int discountedPrice = productPrice - amount;
                            minPrice = Math.min(minPrice, discountedPrice);
                        }
                    }

                }
            }

            totalCost += minPrice;
        }

        return totalCost;
    }

    static class DiscountInfo {
        private int type;
        private int value;

        public DiscountInfo(int type, int value) {
            this.type = type;
            this.value = value;
        }

        public int getType() {
            return type;
        }

        public int getValue() {
            return value;
        }
    }
}

