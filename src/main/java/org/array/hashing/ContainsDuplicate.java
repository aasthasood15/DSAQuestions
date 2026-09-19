package org.array.hashing;

import java.util.HashSet;

public class ContainsDuplicate {
    public void containsDuplicate() {
        int[] num = {1, 2, 3, 3};
        HashSet<Integer> hs = new HashSet<>();
        boolean res = false;
        for (int i = 0; i < num.length; i++) {
            if (hs.contains(num[i])) {
                res = true;
            }
            hs.add(num[i]);
        }

        System.out.println(res);

    }

}
