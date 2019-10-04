/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package extendthreadclass;
import java.util.*;
import java.lang.InterruptedException;

class NewThread extends Thread {
    NewThread(){
        super("demo thread");
        System.out.println("this is dother thread");
        start();
    }
    
    public void run(){
        try {
            for ( int i = 0; i < 5; i++){
                System.out.println("Dother thread: " + i);
                Thread.sleep(300);
            }
        } catch ( InterruptedException e){
            System.out.println("thread is interrupted");
        }
        System.out.println("dother thread is ended.");
    }
}


public class ExtendThreadClass {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        for (int i = 0; i <= 10; i++) {
            new NewThread();
        }

        try {
            for (int i = 5; i > 0; i--) {
                System.out.println("main thread: " + i);
                Thread.sleep(1000);
            }
        } catch (InterruptedException e) {
            System.out.println("Main thread is interrupted");
        }
        System.out.println("Mother thread is ended.");
    }
    
}
