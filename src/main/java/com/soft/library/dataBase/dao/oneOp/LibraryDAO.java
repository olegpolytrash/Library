/**
 * 
 */
package com.soft.library.dataBase.dao.oneOp;

import com.soft.library.dataBase.model.Library;

/**
 * @author rd
 *
 */
public class LibraryDAO extends ElementDAO<Library> implements com.soft.library.dataBase.dao.LibraryDAO {

    public LibraryDAO() {
        super(Library.class);
    }
}
