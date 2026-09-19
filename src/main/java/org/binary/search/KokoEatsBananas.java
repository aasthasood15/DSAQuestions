package org.binary.search;

public class KokoEatsBananas {

    public void minEatingSpeed() {
        int[] piles = {1, 4, 3, 2};
        int h = 9;
        int minSpeed = 1;
        int maxSpeed = 0;
        for (int p : piles) {
            maxSpeed = Math.max(maxSpeed, p);
        }

        while (minSpeed < maxSpeed) {
            int mid = minSpeed + maxSpeed - minSpeed / 2;

            if (canEatInTime(piles, h, mid)) {
                maxSpeed = mid;
            } else {
                minSpeed = mid + 1;
            }
        }
        System.out.println(minSpeed);
    }

    private static boolean canEatInTime(int[] piles, int h, int mid) {
        int hours = 0;
        for (int p : piles) {
            hours = hours + (int) Math.ceil((double) p / mid);
        }
        return hours <= h;
    }
}
