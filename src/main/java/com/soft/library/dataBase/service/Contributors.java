/**
 * 
 */
package com.soft.library.dataBase.service;

import java.util.HashSet;
import java.util.List;
import java.util.Set;

import com.soft.library.dataBase.dao.BaseDao;
import com.soft.library.dataBase.model.Author;
import com.soft.library.dataBase.model.Book;

/**
 * @author rd
 *
 */
public class Contributors {
    @SuppressWarnings({ "unchecked", "rawtypes" })
    public <E extends BaseDao> Set<Book> getBooks(Set<String> names, E e) {
        Set <Book> books = new HashSet<Book>();
        List<Book> list = (List<Book>) e.getAll();
        for(String s : names){
            for (Book b : list) {
                if(s.equals(b.getName())){
                    books.add(b);
                    break;
                }
            }
            Book b = new Book(s);
            e.save(b);
            books.add(b);
        }
        return books;
    }
    @SuppressWarnings({ "unchecked", "rawtypes" })
    public <E extends BaseDao> Set<Author> getAuthors(Set<String> names, E e) {
        Set <Author> authors = new HashSet<Author>();
        List<Author> list = (List<Author>) e.getAll();
        for(String s : names){
            for (Author a : list) {
                if(s.equals(a.getName())){
                    authors.add(a);
                    break;
                }
            }
            Author a = new Author(s);
            e.save(a);
            authors.add(a);
        }
        return authors;
    }
 
}