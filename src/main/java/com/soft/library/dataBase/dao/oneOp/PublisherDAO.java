/**
 * 
 */
package com.soft.library.dataBase.dao.oneOp;

import com.soft.library.dataBase.model.Publisher;

/**
 * @author rd
 *
 */
public class PublisherDAO extends ElementDAO<Publisher> implements com.soft.library.dataBase.dao.PublisherDAO {

    public PublisherDAO() {
        super(Publisher.class);
    }
}
