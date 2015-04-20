package authorTest;

import com.soft.library.dataBase.dao.PublisherDAO;
import com.soft.library.dataBase.dataBaseCore.JPAUtil;
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

public class PublisherTest {

    private static IDatabaseTester databaseTester;
    private static IDataSet dataSet;

    @BeforeClass
    public static void setUp() throws Exception {
        databaseTester = new JdbcDatabaseTester("com.mysql.jdbc.Driver",
                "jdbc:mysql://localhost/sql373362", "root", "1234");

        dataSet = new FlatXmlDataSetBuilder().build(new File("src\\test\\resources\\publisher.xml"));

        databaseTester.setDataSet(dataSet);
    }

    public PublisherTest() {
        JPAUtil.getEntityManagerFactory();
    }

    @Before
    public void tearDown() throws Exception {
        DatabaseOperation.DELETE_ALL.execute(databaseTester.getConnection(), dataSet);
    }

    @Test
    public void testSave() {
        PublisherDAO publisherDAO = new com.soft.library.dataBase.dao.oneOp.PublisherDAO();

        // create and saveNewEntity a publisher
        Publisher originalPublisher = new Publisher("test");
        publisherDAO.saveNewEntity(originalPublisher);

        // find the publisher in the db
        Publisher publisherFromBD = publisherDAO.findById(originalPublisher.getId());

        // check if the correct publisher was found
        assertEquals(publisherFromBD, originalPublisher);
        assertEquals(publisherFromBD.getName(), originalPublisher.getName());
    }

    @Test
    public void testUpdateObjectInOneTransaction() {
        PublisherDAO publisherDAO = new com.soft.library.dataBase.dao.oneOp.PublisherDAO();

        // add a publisher to the db
        Publisher originalPublisher = new Publisher("test");
        publisherDAO.saveNewEntity(originalPublisher);

        // make a change in the publisher and update db
        originalPublisher.setName("publisher new name");
        publisherDAO.saveEntity(originalPublisher);

        // check if update was successful
        Publisher publisherFromBD = publisherDAO.findById(originalPublisher.getId());
        assertEquals(publisherFromBD, originalPublisher);
        assertEquals(publisherFromBD.getName(), originalPublisher.getName());
    }

    @Test
    public void testUpdateObjectInDifferentTransactions() {
        PublisherDAO publisherDAO = new com.soft.library.dataBase.dao.oneOp.PublisherDAO();

        // add a publisher to the db
        Publisher originalPublisher = new Publisher("test");
        publisherDAO.saveNewEntity(originalPublisher);

        // change name of the detached object and update it
        originalPublisher.setName("asd");
        originalPublisher = publisherDAO.saveEntity(originalPublisher);

        // get the updated publisher from bd and check if the name was updated
        Publisher publisherFromBD = publisherDAO.findById(originalPublisher.getId());
        assertEquals(publisherFromBD.getName(), originalPublisher.getName());
    }

    @Test
    public void testGetAll() {
        PublisherDAO publisherDAO = new com.soft.library.dataBase.dao.oneOp.PublisherDAO();

        // add publishers to the db
        Publisher publishers[] = {new Publisher("test1"), new Publisher("test2"), new Publisher("test3")};

        for (Publisher publisher : publishers) {
            publisherDAO.saveNewEntity(publisher);
        }

        // check if all publishers were selected
        assertEquals(publishers.length, publisherDAO.getAll().size());
        assertTrue(publisherDAO.getAll().equals(Arrays.asList(publishers)));
    }

    @Test
    public void testRemove() {
        PublisherDAO publisherDAO = new com.soft.library.dataBase.dao.oneOp.PublisherDAO();

        // add a publisher to the db
        Publisher publishers[] = {new Publisher("test1"), new Publisher("test2"), new Publisher("test3")};

        for (Publisher publisher : publishers) {
            publisherDAO.saveNewEntity(publisher);
        }

        // remove a publisher
        publisherDAO.remove(publishers[1]);

        // check if the publisher was removed
        Publisher a = publisherDAO.findById(publishers[1].getId());

        assertEquals(null, a);
    }

    @Test
    public void testFindByID() {
        PublisherDAO publisherDAO = new com.soft.library.dataBase.dao.oneOp.PublisherDAO();

        // add a publisher to the db
        Publisher originalPublisher = new Publisher("test");
        publisherDAO.saveNewEntity(originalPublisher);

        // find a publisher by id
        Publisher publisherFromBD = publisherDAO.findById(originalPublisher.getId());

        // check
        assertEquals(publisherFromBD, originalPublisher);
        assertEquals(publisherFromBD.getName(), originalPublisher.getName());
    }
}
