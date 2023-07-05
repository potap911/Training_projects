package org.example;

public class MyThread extends Thread {
    private int treadNumber;

    public MyThread(int treadNumber) {
        this.treadNumber = treadNumber;
    }

    @Override
    public void run() {
        System.out.println(treadNumber);
    }
}
