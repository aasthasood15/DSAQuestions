package org.stack;

import java.util.Stack;

public class DailyTemperatures {

    public void dailyTemperatures(){
        {
            int[] arr = {73, 74, 75, 71, 69, 72, 76, 73};
            int [] ans = new int[arr.length];
            Stack<Integer> st = new Stack<>();

            ans[arr.length-1] = 0;
            st.push(arr.length-1);

            for (int i= arr.length-2; i>=0 ;i--) {
                while(!st.isEmpty() && arr[st.peek()] <= arr[i]){
                    st.pop();
                }

                if(st.isEmpty()){
                    ans[i] = 0;
                } else {
                    ans[i] = st.peek()-i;
                }
                st.push(i);
            }
            for(int a : ans){
                System.out.print(a+" ");
            }


        }
    }
}
