/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package networklesson3url;

import java.io.*;
import java.net.*;
import java.util.Date;
/**
 *
 * @author slazur
 */

public class NetworkLesson3URL {
    int c;
    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        try{
        URL hp = new URL("http://www.pro-java.ru");
        HttpURLConnection hpCon = (HttpURLConnection)hp.openConnection();
        
        hpCon.setAllowUserInteraction(false);
	hpCon.setDoInput(true);
	hpCon.setDoOutput(true);
	hpCon.setIfModifiedSince(100000);
	hpCon.setUseCaches(false);
	
	hpCon.setRequestMethod("POST");
        
//        hpCon.getResponseCode();
        hpCon.connect();
        
        long d = hpCon.getDate();
        if (d == 0 ){
            System.out.println("нет сведений о дате");
        }else{
            System.out.println("data " + d);
        }
        
        }catch(MalformedURLException e){
            System.out.println("oops");
        }catch ( java.io.IOException e ){
            System.out.println("oops2");
        }
    }
    
}
