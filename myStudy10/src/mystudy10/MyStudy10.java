/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package mystudy10;

import java.util.*;
/**
 *
 * @author slazur
 */

public class MyStudy10 implements libraryInterface {
    
    ArrayList<bookClass> array = new ArrayList<>();
    
    @Override
    public void addBook(bookClass book){
        array.add(book);
    }
    
    @Override
    public bookClass getByName(String name){
        for(bookClass temp:array){
            if(temp.getName().equals(name)){
                return temp;
            }
        }
        return null;
    }
    
    @Override
    public bookClass getByName(String name){
        for(bookClass temp:array){
            if(temp.getName().equals(name)){
                return temp;
            }
        }
        return null;
    }
    
    @Override
    public bookClass getByName(String name){
        for(bookClass temp:array){
            if(temp.getName().equals(name)){
                return temp;
            }
        }
        return null;
    }
    
    @Override
    public bookClass getByName(String name){
        for(bookClass temp:array){
            if(temp.getName().equals(name)){
                return temp;
            }
        }
        return null;
    }
    
    @Override
    public bookClass getByName(String name){
        for(bookClass temp:array){
            if(temp.getName().equals(name)){
                return temp;
            }
        }
        return null;
    }

    public static void main(String[] args) {
        // TODO code application logic here
    }
    
}
