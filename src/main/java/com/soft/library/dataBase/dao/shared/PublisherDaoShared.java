/**
 * 
 */
package com.soft.library.dataBase.dao.shared;

import com.soft.library.dataBase.dao.PublisherDao;
import com.soft.library.dataBase.model.Publisher;

import javax.persistence.EntityManager;

/**
 * @author rd
 *
 */
public class PublisherDaoShared extends BaseDaoShared<Publisher> implements PublisherDao {

    public PublisherDaoShared(EntityManager entityManager) {
        super(Publisher.class, entityManager);
    }
}
