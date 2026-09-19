package org.sliding.window;

import java.util.ArrayDeque;
import java.util.Deque;

public class SlidingWindowMax {
    public void slidingWindowMax() {
        int[] arr = {1, 3, -1, -3, 5, 3, 3, 6, 7};
        int len = arr.length;

        int k = 3;
        int[] res = new int[len - k + 1];
        Deque<Integer> deq = new ArrayDeque<>();
        int index = 0;
        while (index < k) {
            while (!deq.isEmpty() && arr[deq.peekLast()] <= arr[index]) {
                deq.pollLast();
            }
            deq.offerLast(index);

            index++;
        }
        res[0] = arr[deq.peekFirst()];
        // System.out.println(arr[n]);

        for (int i = 1; i < len - k + 1; i++) {
            if (!deq.isEmpty() && deq.peekFirst() <= i - 1) {
                deq.pollFirst();
            }
            while (!deq.isEmpty() && arr[deq.peekLast()] <= arr[i + k - 1]) {
                deq.pollLast();
            }
            deq.offerLast(i + k - 1);
            res[i] = arr[deq.peekFirst()];
        }
        for (int n : res) {
            System.out.println(n);
        }

    }
}
