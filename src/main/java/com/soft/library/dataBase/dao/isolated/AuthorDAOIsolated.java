/**
 * 
 */
package com.soft.library.dataBase.dao.isolated;

import com.soft.library.dataBase.dao.AuthorDao;
import com.soft.library.dataBase.model.Author;

/**
 * @author rd
 *
 */

public class AuthorDaoIsolated extends BaseDaoIsolated<Author> implements AuthorDao {

    public AuthorDaoIsolated() {
        super(Author.class);
    }


}
