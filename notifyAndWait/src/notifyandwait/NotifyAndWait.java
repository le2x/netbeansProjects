/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package notifyandwait;
class Q {
    int n;
    boolean valueSet = false;
    
    synchronized int get(){
        while(!valueSet){
            try{
                wait();
            }catch( InterruptedException e){
                System.out.println("ouups we crashed =)");
            }
        }
        System.out.println("taken: " + n);
        notify();
        valueSet = false;
        return n;
    }
    
    synchronized void put(int n){
        while(valueSet){
            try{
                wait();
            }catch ( InterruptedException e){
                System.out.println("ouups we crashed =)");
            }
        }
        System.out.println("seteing - " + n);
        this.n = n;
        valueSet = true;
        notify();
    }
}

class Produser implements Runnable {
    Q q;
    
    Produser(Q q){
        this.q = q;
        new Thread(this,"provider").start();
    }
    
    public void run(){
        int i = 0;
        
        while(true){
            q.put(i++);
        }
    }
}

class Consumer implements Runnable {
    Q q;
    
    Consumer(Q q){
        this.q = q;
        new Thread(this, "consumer").start();
    }
    
    @Override
    public void run(){
        while(true){
            q.get();
        }
    }
}

class Privider {
    
}
/**
 *
 * @author slazur
 */
public class NotifyAndWait {

    public static void main(String[] args) {
        Q q = new Q();
        new Produser(q);
        new Consumer(q);
    }
    
}
