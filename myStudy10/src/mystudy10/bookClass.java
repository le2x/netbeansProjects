/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package mystudy10;

/**
 *
 * @author slazur
 */
public class bookClass {
    private String name;
    private String author;
    private String sizeFormat;
    private int id;
    private int count;

    
    public void setName(String name){this.name = name;}
    public void setAuthor(String author) {this.author = author;}
    public void setSizeFormat(String sizeFormat) {this.sizeFormat = sizeFormat;}
    public void setId(int id){this.id = id;}
    public void setCount(int count) {this.count = count;}
    
    public String getName(){return name;}
    public String getAuthor(){return author;}
    public String getSizeFormat(){return sizeFormat;}
    public int getId() { return id;}
    public int getCount() {return count;}
    
    @Override
    public String toString(){
        StringBuilder returnString = new StringBuilder();
        returnString.append(name + " ");
        returnString.append(author + " ");
        returnString.append(sizeFormat + " ");
        returnString.append(id + " ");
        returnString.append(count + " ");
        
        return returnString.toString();
    }
    
    
}
