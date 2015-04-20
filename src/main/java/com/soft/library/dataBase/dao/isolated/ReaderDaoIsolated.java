/**
 * 
 */
package com.soft.library.dataBase.dao.isolated;

import com.soft.library.dataBase.dao.ReaderDao;
import com.soft.library.dataBase.model.Reader;

/**
 * @author rd
 *
 */
public class ReaderDaoIsolated extends BaseDaoIsolated<Reader> implements ReaderDao {

    public ReaderDaoIsolated() {
        super(Reader.class);
    }
}
