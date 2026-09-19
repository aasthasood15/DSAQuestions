package org.sliding.window;

public class BuySellStocks {
    public void buySellStocks() {

        int[] arr = {7, 1, 5, 3, 6, 4};
        int len = arr.length;

        int buy_price = arr[0];
        int max_profit = 0;

        for (int i = 0; i < len; i++) {
            if (buy_price > arr[i]) {
                buy_price = arr[i];
            } else {
                int curr_profit = arr[i] - buy_price;
                max_profit = Math.max(curr_profit, max_profit);
            }
        }


        System.out.println(max_profit);


    }
}
