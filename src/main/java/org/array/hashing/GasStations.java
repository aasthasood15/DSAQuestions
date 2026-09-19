package org.array.hashing;

public class GasStations {

    public int canCompleteCircuit(int[] gas, int[] cost) {
        int currTank = 0;
        int start = 0;

        int totalGas = 0;
        int totalCost = 0;

        for (int i = 0; i < gas.length; i++) {
            currTank = currTank + gas[i] - cost[i];
            if (currTank < 0) {
                currTank = 0;
                start = i + 1;
            }
            totalGas = totalGas + gas[i];
            totalCost = totalCost + cost[i];

        }

        if (totalGas < totalCost) {
            return -1;
        }
        return start;
    }

}
