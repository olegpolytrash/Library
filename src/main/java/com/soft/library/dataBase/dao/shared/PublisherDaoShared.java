/**
 * 
 */
package com.soft.library.dataBase.dao.shared;

import com.soft.library.dataBase.dao.PublisherDao;
import com.soft.library.dataBase.model.Publisher;

import javax.persistence.EntityManager;

/**
 * Class for the Publisher entity dao methods.
 * All methods of this class can be used in a shared transaction with other methods.
 */
public class PublisherDaoShared extends BaseDaoShared<Publisher> implements PublisherDao {
    public PublisherDaoShared(EntityManager entityManager) {
        super(Publisher.class, entityManager);
    }
}
