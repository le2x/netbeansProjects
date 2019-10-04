/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package javanetlesson1;

import java.net.*;

/**
 *
 * @author slazur
 */
public class JavaNetLesson1 {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) throws UnknownHostException {
        InetAddress local = InetAddress.getLocalHost();
        System.out.println(local);
        
        local = InetAddress.getByName("www.ya.ru");
        System.out.println(local);
        
        InetAddress[] locals = InetAddress.getAllByName("www.google.com");
        for (InetAddress temp:locals){
            System.out.println(temp);
        }
    }
    
}
