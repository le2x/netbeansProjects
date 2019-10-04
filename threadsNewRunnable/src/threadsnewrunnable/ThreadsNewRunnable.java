/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package threadsnewrunnable;

/**
 *
 * @author slazur
 */
class Mythread implements Runnable {
    Thread t;
    
    Mythread(){
       t = new Thread(this,"mythread");
       System.out.println("myThread - " + t);
       t.start();
    }
    
    @Override
    public void run(){
        try{
            for(int i = 0; i < 10; i++){
                System.out.println(" dother thread: " + i);
                Thread.sleep(200);
            }
        }catch(InterruptedException e){
            System.out.println("Dother thread was interrupted for some reasons ");
        }
        System.out.println("dother thread is ends");
    }
}

public class ThreadsNewRunnable {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        new Mythread();
        new Mythread();
        new Mythread();
        new Mythread();
        new Mythread();
        
        try{
            for(int i = 0; i < 10; i++){
                System.out.println(" Main thread: " + i);
                Thread.sleep(100);
            }
        }catch(InterruptedException e){
            System.out.println("Main thread was interrupted for some reasons ");
        }
        System.out.println("Main thread is ends");
    }
    
}
