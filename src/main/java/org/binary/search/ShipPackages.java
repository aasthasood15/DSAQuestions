package org.binary.search;

public class ShipPackages {

    public int shipPackages(){
        //weights = [1,2,3,4,5,6,7,8,9,10], days = 5
        int[] weights = {1,2,3,4,5,6,7,8,9,10};
        int days = 5;
        int minCapacity =0;
        int maxCapacity =0;
        for(int w: weights){
            minCapacity = Math.max(minCapacity, w);
            maxCapacity = maxCapacity +w;
        }

        while(minCapacity<maxCapacity){
            int mid = minCapacity + (maxCapacity-minCapacity)/2;

            if(canShip(weights, mid,days)){
                maxCapacity = mid;
            } else{
                minCapacity = mid+1;
            }
        }
        return minCapacity;
    }
    private boolean canShip(int[] weights, int maxCapacity ,int days){
        int allowedDays = 1;
        int totalWeightsOFar =0;
        for(int w: weights){
            if(totalWeightsOFar + w <= maxCapacity){
                totalWeightsOFar = totalWeightsOFar + w;

            } else{
                totalWeightsOFar =0+w;
                allowedDays++;
            }

        }
        return allowedDays<=days;

    }
}
