/**
 * 
 */
package com.soft.library.dataBase.dao.oneOp;

import com.soft.library.dataBase.model.Author;

/**
 * @author rd
 *
 */

public class AuthorDAO extends ElementDAO<Author> implements com.soft.library.dataBase.dao.AuthorDAO {

    public AuthorDAO() {
        super(Author.class);
    }


}
