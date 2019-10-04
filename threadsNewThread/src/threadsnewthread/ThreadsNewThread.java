/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package threadsnewthread;

import java.util.*;
import java.io.IOException;

class MyThread extends Thread {
    
    private String name;
    Thread ob;

    MyThread(int threadCount) {
        super("myThread - " + threadCount);
        name = "myThread - " + threadCount;
        System.out.println("create meThread - " + name);
        start();
    }
    
     MyThread(int threadCount, Thread my) {
        super("myThread - " + threadCount);
        ob = my;
        name = "myThread - " + threadCount;
        System.out.println("create meThread - " + name);
        start();
    }

    @Override
    public void run() {
        try {
            if (ob != null) {
                ob.join();
            }
            for (int i = 0; i < 5; i++) {
                System.out.println(" dother thread: " + name + " : " + i);
            }
        } catch (InterruptedException e) {
            System.out.println("Dother thread was interrupted for some reasons ");
        }
        System.out.println("dother thread is ends");
    }
}

public class ThreadsNewThread {

    public static void main(String[] args) {
        Thread main = Thread.currentThread();
        MyThread ob1 = new MyThread(1);
        MyThread ob2 = new MyThread(2, ob1);
        MyThread ob3 = new MyThread(3, ob2);
        MyThread ob4 = new MyThread(4, ob3);
        MyThread ob5 = new MyThread(5, ob4);

        System.out.println("поток 1 - " + ob1.isAlive());
        System.out.println("поток 2 - " + ob2.isAlive());
        System.out.println("поток 3 - " + ob3.isAlive());
        System.out.println("поток 4 - " + ob4.isAlive());
        System.out.println("поток 5 - " + ob5.isAlive());

        try {
//            ob1.join();
////            ob2.join();
//            ob3.join();
//            ob4.join();
            ob5.join();
            for (int i = 0; i < 5; i++) {
                System.out.println("main thread say - " + i);
            }
        } catch (Exception e) {
            System.out.println("main thread is dead");
        }

        System.out.println("поток 1 - " + ob1.isAlive());
        System.out.println("поток 2 - " + ob2.isAlive());
        System.out.println("поток 3 - " + ob3.isAlive());
        System.out.println("поток 4 - " + ob4.isAlive());
        System.out.println("поток 5 - " + ob5.isAlive());

        System.out.println("main thread is sucsessfully ends");
    }

}
