/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package javanetlesson3echoserver;

import java.io.*;
import java.util.*;
import java.net.*;
/**
 *
 * @author slazur
 */
public class JavaNetLesson3echoServer {

    public static void main(String[] args) throws IOException {
        try ( ServerSocket s = new ServerSocket(8189)){
            try(Socket incoming = s.accept()){
                InputStream in = incoming.getInputStream();
                OutputStream out = incoming.getOutputStream();
                try(Scanner scaner = new Scanner(in)){
                    PrintWriter writer = new PrintWriter(out, true);
                    writer.println("hello!");
                    boolean done = false;
                    
                    while (!done && scaner.hasNextLine()){
                        String line = scaner.nextLine();
                        writer.println("Echo: " + line);
                        if (line.trim().equals("bye")) done = true;
                    }
                }
            }
        }
    }
    
}
