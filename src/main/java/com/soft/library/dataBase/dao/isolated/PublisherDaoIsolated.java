/**
 * 
 */
package com.soft.library.dataBase.dao.isolated;

import com.soft.library.dataBase.dao.PublisherDao;
import com.soft.library.dataBase.model.Publisher;

/**
 * @author rd
 *
 */
public class PublisherDaoIsolated extends BaseDaoIsolated<Publisher> implements PublisherDao {

    public PublisherDaoIsolated() {
        super(Publisher.class);
    }
}
