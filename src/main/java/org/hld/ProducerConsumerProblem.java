package org.hld;

// Online Java Compiler
// Use this editor to write, compile and run your Java code online
// PS : The name of the public class has to be Main for the code to work

public class ProducerConsumerProblem {

    public static void main(String[] args) {

        SharedResource sr = new SharedResource();

        Thread producer = new Thread(() -> {
            try {
                for (int i = 0; i < 10; i++) {
                    sr.produce(i);
                }
            } catch (Exception ex) {

            }
        });

        Thread consumer = new Thread(() -> {
            try {
                for (int i = 0; i < 10; i++) {
                    sr.consume();
                }

            } catch (Exception ex) {

            }
        });

        producer.start();
        consumer.start();
    }
}


class SharedResource {

    private boolean hasData;
    private int data;

    public synchronized void produce(int value) throws InterruptedException {

        while (hasData) {
            wait();
        }

        this.data = value;
        this.hasData = true;

        System.out.println("Produced Data: " + data);

        notify();
    }


    public synchronized void consume() throws InterruptedException {

        while (!hasData) {
            wait();
        }

        System.out.println("Consumed Data: " + data);

        this.hasData = false;

        notify();
    }
}