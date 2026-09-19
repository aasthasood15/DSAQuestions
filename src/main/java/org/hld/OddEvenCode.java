package org.hld;


public class OddEvenCode {
    // Online Java Compiler
// Use this editor to write, compile and run your Java code online
// PS : The name of the public class has to be Main for the code to work

    public static void main(String[] args) {
        OddEven odd = new OddEven(1, 10);
        OddEven even = new OddEven(0, 10);

        odd.start();
        even.start();


    }
}
    class OddEven extends Thread{
        private int remainder;
        private int n;
        private static Object lock  = new Object();
        public OddEven(int remainder, int n){
            this.remainder = remainder;
            this.n = n;
        }
        public void run(){
            printOddEven(n);
        }
        public void printOddEven( int n){
            for(int i=0;i<n;i++){
                synchronized(lock){
                    if(i%2==remainder){
                        System.out.println(Thread.currentThread().getName()+" "+i);
                    }
                }
            }
        }

    }




