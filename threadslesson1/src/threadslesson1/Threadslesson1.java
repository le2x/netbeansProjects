/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package threadslesson1;

/**
 *
 * @author slazur
 */
public class Threadslesson1 {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        Thread t = Thread.currentThread();
        System.out.println("thread - " + t);

        t.setName("mythread");
        System.out.println("thread - " + t);
        try {
            Thread.sleep(1000);
        } catch (InterruptedException e) {
            System.out.println("thread was interupted");
        }
    }
    
}
