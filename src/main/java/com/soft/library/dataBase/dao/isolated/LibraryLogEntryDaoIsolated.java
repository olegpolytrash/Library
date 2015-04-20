/**
 * 
 */
package com.soft.library.dataBase.dao.isolated;

import com.soft.library.dataBase.dao.LibraryLogEntryDao;
import com.soft.library.dataBase.model.LibraryLogEntry;

/**
 * Class for the LibraryLogEntry entity dao methods.
 * All methods of this class are isolated, each of them runs in it's own transaction.
 * It's impossible to call a method of this class with a method of any other dao class in a single shared transaction.
 */
public class LibraryLogEntryDaoIsolated extends BaseDaoIsolated<LibraryLogEntry> implements LibraryLogEntryDao {

    public LibraryLogEntryDaoIsolated() {
        super(LibraryLogEntry.class);
    }
}
