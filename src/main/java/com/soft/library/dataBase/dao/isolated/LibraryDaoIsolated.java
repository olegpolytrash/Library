/**
 * 
 */
package com.soft.library.dataBase.dao.isolated;

import com.soft.library.dataBase.dao.LibraryDao;
import com.soft.library.dataBase.model.Library;

/**
 * @author rd
 *
 */
public class LibraryDaoIsolated extends BaseDaoIsolated<Library> implements LibraryDao {

    public LibraryDaoIsolated() {
        super(Library.class);
    }
}
