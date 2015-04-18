/**
 * 
 */
package com.soft.library.dataBase.service;

import java.util.HashSet;
import java.util.List;
import java.util.Set;

import com.soft.library.dataBase.dao.BaseDao;
import com.soft.library.dataBase.dao.impl.ElementDAOImpl;
import com.soft.library.dataBase.dao.impl.LibraryDAOImpl;
import com.soft.library.dataBase.model.Book;

/**
 * @author rd
 *
 */
public class Contributors<E extends BaseDao<E>> {

    public <E extends BaseDao> Set<Book> getContributors(Set<String> names, E e) {
        Set <Book> books = new HashSet<Book>();
        List<Book> list = (List<Book>) e.getAll();
        Set<String> temp = new HashSet<String>();
        for (Book b : list) {
            temp.add(b.getName());
        }
        names.removeAll(temp);
        for(String s : names){
            books.add(new Book(s));
        }
        return books;
    }
}