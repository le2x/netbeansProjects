/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package eatingcirclesbynetwork;

import java.io.IOException;

/**
 *
 * @author slazur
 */
public class EatingCirclesByNetwork {

    /**
     * just main class
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        Server s = new Server();
        try {
            s.startServer();
        } catch (IOException ex) {
            ex.printStackTrace();
        }
    }

}
