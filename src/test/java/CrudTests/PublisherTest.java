package CrudTests;

import com.soft.library.dataBase.dao.PublisherDao;
import com.soft.library.dataBase.dao.isolated.PublisherDaoIsolated;
import com.soft.library.dataBase.dataBaseCore.JpaUtil;
import com.soft.library.dataBase.model.Publisher;
import org.dbunit.IDatabaseTester;
import org.dbunit.JdbcDatabaseTester;
import org.dbunit.dataset.IDataSet;
import org.dbunit.dataset.xml.FlatXmlDataSetBuilder;
import org.dbunit.operation.DatabaseOperation;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;

import java.io.File;
import java.util.Arrays;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertTrue;

/**
 * Class for testing Publisher's entity crud operations.
 */
public class PublisherTest {
    private static IDatabaseTester databaseTester;
    private static IDataSet dataSet;

    @BeforeClass
    public static void setUp() throws Exception {
        databaseTester = TestUtils.getJdbcDatabaseTester();
        dataSet = new FlatXmlDataSetBuilder().build(new File("src\\test\\resources\\datasets\\publisher.xml"));
        databaseTester.setDataSet(dataSet);
    }

    public PublisherTest() {
        JpaUtil.ENTITY_MANAGER_FACTORY.getEntityManagerFactory();
    }

    @Before
    public void tearDown() throws Exception {
        DatabaseOperation.DELETE_ALL.execute(databaseTester.getConnection(), dataSet);
    }

    @Test
    public void testSave() {
        PublisherDao publisherDao = new PublisherDaoIsolated();

        // create and saveNewEntity a publisher
        Publisher originalPublisher = new Publisher("test");
        publisherDao.saveNewEntity(originalPublisher);

        // find the publisher in the db
        Publisher publisherFromBD = publisherDao.findById(originalPublisher.getId());

        // check if the correct publisher was found
        assertEquals(publisherFromBD, originalPublisher);
    }

    @Test
    public void testUpdateObjectInOneTransaction() {
        PublisherDao publisherDao = new PublisherDaoIsolated();

        // add a publisher to the db
        Publisher originalPublisher = new Publisher("test");
        publisherDao.saveNewEntity(originalPublisher);

        // make a change in the publisher and update db
        originalPublisher.setName("publisher new name");
        publisherDao.saveEntity(originalPublisher);

        // check if update was successful
        Publisher publisherFromBD = publisherDao.findById(originalPublisher.getId());
        assertEquals(publisherFromBD, originalPublisher);
    }

    @Test
    public void testUpdateObjectInDifferentTransactions() {
        PublisherDao publisherDao = new PublisherDaoIsolated();

        // add a publisher to the db
        Publisher originalPublisher = new Publisher("test");
        publisherDao.saveNewEntity(originalPublisher);

        // change name of the detached object and update it
        originalPublisher.setName("new name");
        originalPublisher = publisherDao.saveEntity(originalPublisher);

        // get the updated publisher from bd and check if the name was updated
        Publisher publisherFromBD = publisherDao.findById(originalPublisher.getId());
    }

    @Test
    public void testGetAll() {
        PublisherDao publisherDao = new PublisherDaoIsolated();

        // add publishers to the db
        Publisher publishers[] = {new Publisher("test1"), new Publisher("test2"), new Publisher("test3")};

        for (Publisher publisher : publishers) {
            publisherDao.saveNewEntity(publisher);
        }

        // check if all publishers were selected
        assertEquals(publishers.length, publisherDao.getAll().size());
        assertTrue(publisherDao.getAll().equals(Arrays.asList(publishers)));
    }

    @Test
    public void testRemove() {
        PublisherDao publisherDao = new PublisherDaoIsolated();

        // add a publisher to the db
        Publisher publishers[] = {new Publisher("test1"), new Publisher("test2"), new Publisher("test3")};

        for (Publisher publisher : publishers) {
            publisherDao.saveNewEntity(publisher);
        }

        // remove a publisher
        publisherDao.remove(publishers[1]);

        // check if the publisher was removed
        Publisher a = publisherDao.findById(publishers[1].getId());

        assertEquals(null, a);
    }

    @Test
    public void testFindByID() {
        PublisherDao publisherDao = new PublisherDaoIsolated();

        // add a publisher to the db
        Publisher originalPublisher = new Publisher("test");
        publisherDao.saveNewEntity(originalPublisher);

        // find a publisher by id
        Publisher publisherFromBD = publisherDao.findById(originalPublisher.getId());

        // check
        assertEquals(publisherFromBD, originalPublisher);
    }
}
