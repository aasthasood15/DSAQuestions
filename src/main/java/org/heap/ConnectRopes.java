package org.heap;

import java.util.PriorityQueue;

public class ConnectRopes {

    public static int minCost(int[] ropes) {

        PriorityQueue<Integer> minHeap = new PriorityQueue<>();

        // Add all ropes to heap
        for (int rope : ropes) {
            minHeap.offer(rope); //O(log n)
        }

        int totalCost = 0;

        while (minHeap.size() > 1) {

            int first = minHeap.poll();
            int second = minHeap.poll();

            int currentCost = first + second;

            totalCost += currentCost;

            minHeap.offer(currentCost);
        }

        return totalCost;
    }

    public static void main(String[] args) {

        int[] ropes = {4, 3, 2, 6};

        System.out.println(minCost(ropes));
    }
}