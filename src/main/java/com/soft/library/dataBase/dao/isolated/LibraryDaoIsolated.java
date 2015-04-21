/**
 * 
 */
package com.soft.library.dataBase.dao.isolated;

import com.soft.library.dataBase.dao.LibraryDao;
import com.soft.library.dataBase.model.Library;

/**
 * Class for the Library entity dao methods.
 * All methods of this class are isolated, each of them runs in it's own transaction.
 * It's impossible to call a method of this class with a method of any other dao class in a single shared transaction.
 */
public class LibraryDaoIsolated extends BaseDaoIsolated<Library> implements LibraryDao {
    public LibraryDaoIsolated() {
        super(Library.class);
    }
}
