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
import com.soft.library.dataBase.model.Reader;

/**
 * @author rd
 *
 */
public class Contributors {
    @SuppressWarnings({ "unchecked", "rawtypes" })
    public <E extends BaseDao> Set<Book> getBook(Set<String> names, E e) {
        Set<Book> books = new HashSet<Book>();
        List<Book> list = (List<Book>) e.getAll();
        for (String s : names) {
            for (Book b : list) {
                if (s.equals(b.getName())) {
                    books.add(b);
                    break;
                }
            }
            Book book = new Book(s);
            e.save(book);
            books.add(book);
        }
        return books;
    }
    @SuppressWarnings({ "unchecked", "rawtypes" })
    public <E extends BaseDao> Book getBook(String name, E e) {
        List<Book> list = (List<Book>) e.getAll();

        for (Book b : list) {
            if (name.equals(b.getName())) {
                return b;
            }
        }
        Book book = new Book(name);
        e.save(book);
        return book;
    }

    @SuppressWarnings({ "unchecked", "rawtypes" })
    public <E extends BaseDao> Set<Author> getAuthor(Set<String> names, E e) {
        Set<Author> authors = new HashSet<Author>();
        List<Author> list = (List<Author>) e.getAll();
        for (String s : names) {
            for (Author a : list) {
                if (s.equals(a.getName())) {
                    authors.add(a);
                    break;
                }
            }
            Author author = new Author(s);
            e.save(author);
            authors.add(author);
        }
        return authors;
    }
    @SuppressWarnings({ "unchecked", "rawtypes" })
    public <E extends BaseDao> Author getAuthor(String name, E e) {
        List<Author> list = (List<Author>) e.getAll();
            for (Author a : list) {
                if (name.equals(a.getName())) {
                    return a;
                }
            }
            Author author = new Author(name);
            e.save(author);
        return author;
    }
//    @SuppressWarnings({ "unchecked", "rawtypes" })
//    public <E extends BaseDao> Reader getReader(String name, E e) {
//        List<Reader> list = (List<Reader>) e.getAll();
//        for (Reader a : list) {
//            if (name.equals(a.getName())) {
//                return a;
//            }
//        }
//        Reader author = new Reader(name);
//        e.save(author);
//        return author;
//    }

}