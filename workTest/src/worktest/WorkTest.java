/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package worktest;

import java.util.*;
import java.util.regex.Pattern;
import java.util.regex.Matcher;

import XcdCliCommands.XcdCliCommands;
import XcdCliCommands.XcdCliCommands.dpErrorEvents;

/**
 *
 * @author slazur
 */

public class WorkTest {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        
        MyNumber2 myNum;
        myNum = (n) -> {
            int result = 1;
            for(int i = 1; i <= n; i++){
                result = result * i;
            }
            return result;
        };
        System.out.println(myNum.getValue(4));
//        Runnable runnable = () -> System.out.println("Hello world!");
//        Thread t = new Thread(runnable, "myThread");
//        t.start();
        //myNum = (n) -> n >= 0;
        System.out.println(myNum.getValue(6));
        System.out.println(myNum.getValue(10));
    }
}

interface MyNumber2 {
    int getValue(int a);
}

