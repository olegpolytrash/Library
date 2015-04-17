/**
 * 
 */
package com.soft.library.dataBase.dao.impl;

import com.soft.library.dataBase.model.Publisher;
import com.soft.library.dataBase.dao.PublisherDAO;

import javax.persistence.EntityManager;

/**
 * @author rd
 *
 */
public class PublisherDAOImpl extends ElementDAOImpl<Publisher> implements PublisherDAO {

    public PublisherDAOImpl(EntityManager entityManager) {
        super(Publisher.class, entityManager);
    }
}
