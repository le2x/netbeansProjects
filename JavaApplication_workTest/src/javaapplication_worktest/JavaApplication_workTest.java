/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package javaapplication_worktest;

import java.util.*;
/**
 *
 * @author slazur
 */


public class JavaApplication_workTest {
    /**
     * @param args the command line arguments
     */
    public static Map<String, Integer> getFilePermissionCodes(String output) {

        final int fileName = 1;
        final int filePermissions = 0;
        final int expectedStringsCouts = 2;

        final String[] containerFileList = output.split("\n");
        HashMap<String, Integer> resultmap = new HashMap<>();

        for (String fileLsInfo : containerFileList) {
            String[] temp = fileLsInfo.split("/", -1);
            for (String tmpstr : temp) {
                if (tmpstr.equals("")) {
                    break;
                }
            }
            resultmap.put(temp[fileName], Integer.parseInt(temp[filePermissions]));
        }
        return resultmap;
    }
    
    public static void testFunc(Integer... param){
        for(Integer temp:param){
            System.out.println("temp = " + temp);
        }
    }
    
    
    public static void main(String[] args) {
      Integer[] massive1 = {1,2,3,4,5};
      List<Integer> massive2 = new ArrayList<>();
      massive2.add(20);
      massive2.add(30);
      massive2.add(40);
      
      Integer[] massive3 = new Integer[massive2.size()];
      massive2.toArray(massive3);
      
      testFunc(massive1);
      Integer[] newArray = massive2.toArray(new Integer[0]);
      
      Integer[] myArray = massive2.stream().toArray(Integer[]::new);
      
      testFunc(newArray);
      testFunc(massive3);
      
      
        
        
    }
    
}
