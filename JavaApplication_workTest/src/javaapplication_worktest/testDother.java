/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package javaapplication_worktest;

/**
 *
 * @author slazur
 */
public class testDother {
    
    private int mass[];
    private int tos;
    
    /**
     * 
     * @param stackSize number of stack elements.
     */
    testDother(int stackSize){
        mass = new int[stackSize];
        tos = -1;
    }
    
    void checkOfPopTheory( int number){
        if (tos < mass.length){
            mass[++tos] = number;
            System.out.println("mass[" + tos + "] = " + mass[tos]);
        };
    }
    
}
