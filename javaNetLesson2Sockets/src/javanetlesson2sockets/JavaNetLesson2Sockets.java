/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package javanetlesson2sockets;

import java.net.*;
import java.io.*;
import java.util.*;
/**
 *
 * @author slazur
 */


public class JavaNetLesson2Sockets {

    public static void main(String[] args) throws IOException{
        try (Socket s = new Socket("time-A.timefreq.bldrdoc.gov", 13)) {
            InputStream in = s.getInputStream();
            Scanner input = new Scanner(in);
            
            while(input.hasNextLine()){
                String line = input.nextLine();
                System.out.println(line);
            }
        }
//        int c;
//        
//        InetAddress address = InetAddress.getByName("localhost");
//        System.out.println(address);
//        
//        
//        Socket s = new Socket(address);
//        InputStream in = s.getInputStream();
//        OutputStream out = s.getOutputStream();
//        
//        System.out.println(s.isConnected());
        
    }
    
}
