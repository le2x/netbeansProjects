/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package libraryclasstask10;

import libraryclasstask10.locateClass;

/**
 *
 * @author slazur
 */
public class bookClass {
    private booksStatus status;
    private locateClass locating;
    private String author;
    private String title;
    private String publisher;
    private int year;
    private int id;
        
    public void setAuthor( String author) { this.author = author; }
    public void setTitle ( String title) { this.title = title;}
    public void setPublisher( String publisher) { this.publisher = publisher; }
    public void setYear(int year) { this.year = year; }
    public void setId(int id) { this.id = id; }
    
    public String getAuthor() { return author; }
    public String getTitle() { return title; }
    public String getPublisher() { return publisher; }
    public int getYear() { return year; }
    public int getId() { return id; }
    
    /**
     * this method sets following book status:
     * - "lost"
     * - "on the rack"
     * - "given out"
     * - "repairing"
     * @param status string must be one of listed strings
     */
    public void setStatus(String status){
        if (status.toLowerCase().equals("lost")){ this.status = booksStatus.lost; }
        if (status.toLowerCase().equals("on the rack")){ this.status = booksStatus.OnTheRack; }
        if (status.toLowerCase().equals("given out")){ this.status = booksStatus.givenOut; }
        if (status.toLowerCase().equals("reparing")){ this.status = booksStatus.reparing; }
    }
}

class locateClass {
    private int section;
    private int rack;
    private int row;
    private String ovner;
    
    locateClass(){
        section = -1;
        rack = -1;
        row = -1;
        ovner = "";
    }
    
    locateClass(int... parameters){
        if(parameters.length > 3){
            System.out.println("wrong number of parameters");
        }
        section = parameters[0];
        rack = parameters[1];
        row = parameters[2];
    }
    
    public void setSection(int section) { this.section = section; } 
    public void setRack(int rack) { this.rack = rack; }
    public void setRow(int row) { this.row = row; }
    public void setOvner( String ovner) { this.ovner = ovner; }
    
    public int getSection() { return section; }
    public int getRack() { return rack; }
    public int getRow() { return row; }
    public String getOvner() { return ovner; }
}

enum booksStatus {
        OnTheRack, givenOut, reparing, lost
    }