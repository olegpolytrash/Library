/**
 * 
 */
package com.soft.library.dataBase.dao.isolated;

import com.soft.library.dataBase.dao.PublisherDao;
import com.soft.library.dataBase.model.Publisher;

/**
 * Class for the Publisher entity dao methods.
 * All methods of this class are isolated, each of them runs in it's own transaction.
 * It's impossible to call a method of this class with a method of any other dao class in a single shared transaction.
 */
public class PublisherDaoIsolated extends BaseDaoIsolated<Publisher> implements PublisherDao {

    public PublisherDaoIsolated() {
        super(Publisher.class);
    }
}
