/**
 * 
 */
package com.soft.library.dataBase.dao.isolated;

import com.soft.library.dataBase.dao.ReaderDao;
import com.soft.library.dataBase.model.Reader;

/**
 * Class for the Reader entity dao methods.
 * All methods of this class are isolated, each of them runs in it's own transaction.
 * It's impossible to call a method of this class with a method of any other dao class in a single shared transaction.
 */
public class ReaderDaoIsolated extends BaseDaoIsolated<Reader> implements ReaderDao {

    public ReaderDaoIsolated() {
        super(Reader.class);
    }
}
