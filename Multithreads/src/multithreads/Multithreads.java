/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package multithreads;
import java.util.*;
import java.lang.InterruptedException;
/**
 *
 * @author slazur
 */

 class NewThread implements Runnable {
     Thread t;
     String name;
     
     NewThread(String name){
         this.name = name;
         t = new Thread(this,name);
         System.out.println("dother thread");
         t.start();
     }
     
    Thread getThread() { return t; }
     
    @Override
    public void run(){
        try {
            for ( int i = 0; i < 5; i++){
                System.out.println( name + ": " + i);
                Thread.sleep(500);
            }
        } catch ( InterruptedException e){
            System.out.println("thread is interrupted");
        }
        System.out.println(name + " thread is ended.");
    }

}

class testClass extends NewThread {
    testClass(String name){
        super(name);
    }
}

public class Multithreads {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        NewThread my = new NewThread("thread 1");
        NewThread my2 = new testClass("thread 2");
        NewThread my3 = new testClass("thread 3");
       
        System.out.println("Thread 1 status: " + my.t.isAlive());
        System.out.println("Thread 2 status: " + my2.t.isAlive());
        System.out.println("Thread 3 status: " + my3.t.isAlive());
        
        try {

            System.out.println("Waiting threads end");
            my.t.join();
            my2.t.join();
            my3.t.join();

        } catch (InterruptedException e) {
            System.out.println("Main thread is interrupted");
        }
        
        System.out.println("Thread 1 status: " + my.t.isAlive());
        System.out.println("Thread 2 status: " + my2.t.isAlive());
        System.out.println("Thread 3 status: " + my3.t.isAlive());
        
        System.out.println("Mother thread is ended.");
    }
    
}
