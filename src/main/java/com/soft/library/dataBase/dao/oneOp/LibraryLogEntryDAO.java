/**
 * 
 */
package com.soft.library.dataBase.dao.oneOp;

import com.soft.library.dataBase.model.LibraryLogEntry;

/**
 * @author rd
 *
 */
public class LibraryLogEntryDAO extends ElementDAO<LibraryLogEntry> implements com.soft.library.dataBase.dao.LibraryLogEntryDAO {

    public LibraryLogEntryDAO() {
        super(LibraryLogEntry.class);
    }
}
