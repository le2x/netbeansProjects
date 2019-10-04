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
public interface libraryInterface {
    void sort( String parameter);
    
    bookClass getByName(String name);
    bookClass getByAuthor(String Author);
    bookClass getBySizeFormat(String sizeFormat);
    bookClass getById(int Id);
    bookClass getBycount(int count);
    
    void addBook(bookClass book);
    
    void deleteByName(String name);
    void deleteByAuthor(String Author);
    void deleteBySizeFormat(String sizeFormat);
    void deleteById(int id);
    void deleteByCount(int count);
}
