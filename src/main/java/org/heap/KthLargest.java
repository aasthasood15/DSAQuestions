package org.heap;

import java.util.PriorityQueue;

public class KthLargest {

    public static int kthLargest(int[] arr, int k) {

        PriorityQueue<Integer> minHeap = new PriorityQueue<>();

        for (int num : arr) {

            minHeap.offer(num);

            if (minHeap.size() > k) {
                minHeap.poll();
            }
        }

        return minHeap.peek();//nlogk
    }

    public static void main(String[] args) {

        int[] arr = {3,2,1,5,6,4};

        System.out.println(kthLargest(arr,2));
    }
}
