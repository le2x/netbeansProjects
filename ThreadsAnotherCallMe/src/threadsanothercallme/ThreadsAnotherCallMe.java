/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package threadsanothercallme;

/**
 *
 * @author slazur
 */
class Callme {

   void call(String msg) {
        System.out.print("[ " + msg);
        try {
            Thread.sleep(100);
        } catch (InterruptedException e) {
            System.out.println("broken 2");
        }
        System.out.println(" ]");
    }
}

class Caller implements Runnable {

    Callme target;
    Thread t;
    String msg;

    Caller(Callme targ, String msg) {
        target = targ;
        t = new Thread(this);
        this.msg = msg;
        t.start();
    }

    @Override
    public void run() {
        synchronized(target)
        {
            target.call(msg);
        }
    }
}

public class ThreadsAnotherCallMe {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        Callme i = new Callme();
        Caller ob1 = new Caller(i, " добро пожаловать ");
        Caller ob2 = new Caller(i, " в синхронизированный мир ");
        try {
            Thread.sleep(100);
        } catch (InterruptedException e) {
            System.out.println("broken 2");
        }
        Caller ob3 = new Caller(i, " мать вашу ! =) ");
//        try {
//            ob1.t.join();
//            ob2.t.join();
//            ob3.t.join();
//        } catch (InterruptedException e) {
//            System.out.println("broken 2");
//        }
    }

}
