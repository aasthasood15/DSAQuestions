package org.stack;

import java.util.Stack;

public class NextGreaterElement {

    public void nextGreaterElement(){
        {
            int[] arr = {4,12,5,3,1,2,5};
            int [] ans = new int[arr.length];
            Stack<Integer> st = new Stack<>();

            ans[arr.length-1] =-1;
            st.push(arr[arr.length-1]);

            for (int i=arr.length-2; i>=0 ;i--) {
                while(!st.isEmpty() && st.peek() <= arr[i]){
                    st.pop();
                }

                if(st.isEmpty()){
                    ans[i] = -1;
                } else {
                    ans[i] = st.peek();
                }
                st.push(arr[i]);
            }
            for(int a : ans){
                System.out.print(a+" ");
            }


        }
    }
}
