/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package anotherlesson;

import java.util.Scanner;
/**
 *
 * @author slazur
 */
public class AnotherLesson {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        
        	Scanner sc = new Scanner(System.in);
		System.out.println("Введите любое слово или фразу: ");
		String phrase1 = sc.nextLine();
		System.out.println(phrase1);
    }
    
}
