/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package callme;
import java.util.Random;


/**
 *
 * @author slazur
 */
class callMeToo{
    int[] massive;
    Random random;
    int result;
    int progress;
    
    callMeToo(int size){
        random = new Random();
        massive = new int[size];
        for( int i = 0; i < massive.length; i++){
            massive[i] = random.nextInt(100);
        }
        
//        for (int temp:massive){
//            System.out.print(temp + " ");
//            System.out.println();
//        }
    }
    
    synchronized int[] getRange() {
        if (progress < (massive.length - 1)) {
            int[] tempMassive = new int[massive.length/3];
            for (int i = 0; i < (tempMassive.length-1) ; i++) {
                tempMassive[i] = massive[progress + i];
            }
            progress += tempMassive.length;
            System.out.println( "progress" + progress);
            return tempMassive;
        } else {
            return null;
        }
    }
    
    void addResult(int summ){
        result += summ;
    }
    
    void call(String msg){
        System.out.print("[" + msg);
        
        System.out.println("]");
    }
}

class Caller implements Runnable {
    String msg;
    callMeToo target;
    Thread t;
    
    public Caller(callMeToo target, String s) {
        this.target = target;
        msg = s;
        t = new Thread(this);
        t.start();
    }
    
    @Override
    public void run() {
        int summ = 0;
        int[] mass = target.getRange();
        System.out.println("this is " + msg + " " + mass.length);
        for (int temp:mass){
            summ+=temp;
        }
        
        target.addResult(summ);
        synchronized (target) {
            target.call(msg);
        }
    }
}

public class Callme {
    
    public static void main(String[] args) {
        callMeToo target = new callMeToo(30);
        Caller ob1 = new Caller(target, "1");
        Caller ob2 = new Caller(target, "2");
        Caller ob3 = new Caller(target, "3");
        
        try{
            ob1.t.join();
            ob2.t.join();
            ob3.t.join();
        } catch (InterruptedException e) {
            System.out.println("broken 2");
        }
        
        System.out.println("result is - " + target.result);
    }
    
}
