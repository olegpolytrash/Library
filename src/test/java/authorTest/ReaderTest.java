package authorTest;

import com.soft.library.dataBase.dao.ReaderDAO;
import com.soft.library.dataBase.dataBaseCore.JPAUtil;
import com.soft.library.dataBase.model.Reader;
import org.dbunit.IDatabaseTester;
import org.dbunit.JdbcDatabaseTester;
import org.dbunit.dataset.IDataSet;
import org.dbunit.dataset.xml.FlatXmlDataSetBuilder;
import org.dbunit.operation.DatabaseOperation;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;

import javax.persistence.PersistenceException;
import java.io.File;
import java.util.Arrays;
import java.util.Date;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertTrue;

public class ReaderTest {

    public ReaderTest() {
        JPAUtil.getEntityManagerFactory();
    }

    private static IDatabaseTester databaseTester;
    static IDataSet dataSet;

    @BeforeClass
    public static void setUp() throws Exception {
        databaseTester = new JdbcDatabaseTester("com.mysql.jdbc.Driver",
                "jdbc:mysql://localhost/sql373362", "root", "1234");

        dataSet = new FlatXmlDataSetBuilder().build(new File("src\\test\\resources\\reader.xml"));

        databaseTester.setDataSet(dataSet);

    }

    @Before
    public void tearDown() throws Exception {
        DatabaseOperation.DELETE_ALL.execute(databaseTester
                .getConnection(), dataSet);
    }

    @Test
    public void testSave() {
        ReaderDAO readerDAO = new com.soft.library.dataBase.dao.oneOp.ReaderDAO();

        // create and saveNewEntity a reader
        Reader originalReader = new Reader("name1", "surname1", "1234567890", "address1", new Date(123123));
        readerDAO.saveNewEntity(originalReader);

        // find the reader in the db
        Reader readerFromBD = readerDAO.findById(originalReader.getId());

        // check if the correct reader was found
        assertEquals(readerFromBD, originalReader);
        assertEquals(readerFromBD.getName(), originalReader.getName());
    }

    @Test
    public void testUpdateObjectInOneTransaction() {
        ReaderDAO readerDAO = new com.soft.library.dataBase.dao.oneOp.ReaderDAO();

        // add a reader to the db
        Reader originalReader = new Reader("name1", "surname1", "1234567890", "address1", new Date(123123));
        readerDAO.saveNewEntity(originalReader);

        // make a change in the reader and update db
        originalReader.setName("reader new name");
        readerDAO.saveEntity(originalReader);

        // check if update was successful
        Reader readerFromBD = readerDAO.findById(originalReader.getId());
        assertEquals(readerFromBD, originalReader);
        assertEquals(readerFromBD.getName(), originalReader.getName());
    }

    @Test
    public void testUpdateObjectInDifferentTransactions() {
        ReaderDAO readerDAO = new com.soft.library.dataBase.dao.oneOp.ReaderDAO();

        // add a reader to the db
        Reader originalReader = new Reader("name1", "surname1", "1234567890", "address1", new Date(123123));
        readerDAO.saveNewEntity(originalReader);

        // change name of the detached object and update it
        originalReader.setName("asd");
        originalReader = readerDAO.saveEntity(originalReader);

        // get the updated reader from bd and check if the name was updated
        Reader readerFromBD = readerDAO.findById(originalReader.getId());
        assertEquals(readerFromBD.getName(), originalReader.getName());
    }

    @Test
    public void testGetAll() {
        ReaderDAO readerDAO = new com.soft.library.dataBase.dao.oneOp.ReaderDAO();

        // add readers to the db
        Reader readers[] = {new Reader("name1", "surname1", "1234567890", "address1", new Date(123123)),
                new Reader("name2", "surname2", "1234567890", "address2", new Date(3452354)),
                new Reader("name3", "surname3", "1234567890", "address3", new Date(111111))};

        for (Reader reader : readers) {
            readerDAO.saveNewEntity(reader);
        }

        // check if all readers were selected
        assertEquals(readers.length, readerDAO.getAll().size());
        assertTrue(readerDAO.getAll().equals(Arrays.asList(readers)));
    }

    @Test
    public void testRemove() {
        ReaderDAO readerDAO = new com.soft.library.dataBase.dao.oneOp.ReaderDAO();

        // add readers to the db
        Reader readers[] = {new Reader("name1", "surname1", "1234567890", "address1", new Date(123123)),
                new Reader("name2", "surname2", "1234567890", "address2", new Date(3452354)),
                new Reader("name3", "surname3", "1234567890", "address3", new Date(111111))};

        for (Reader reader : readers) {
            readerDAO.saveNewEntity(reader);
        }

        // remove a reader
        readerDAO.remove(readers[1]);

        // check if the reader was removed
        Reader a = readerDAO.findById(readers[1].getId());

        assertEquals(null, a);
    }

    @Test
    public void testFindByID() {
        ReaderDAO readerDAO = new com.soft.library.dataBase.dao.oneOp.ReaderDAO();

        // add a reader to the db
        Reader originalReader = new Reader("name1", "surname1", "1234567890", "address1", new Date(123123));
        readerDAO.saveNewEntity(originalReader);

        // find a reader by id
        Reader readerFromBD = readerDAO.findById(originalReader.getId());

        // check
        assertEquals(readerFromBD, originalReader);
        assertEquals(readerFromBD.getName(), originalReader.getName());
    }

    @Test(expected = PersistenceException.class)
    public void testUniqueNameSurnameConstraint() {
        ReaderDAO readerDAO = new com.soft.library.dataBase.dao.oneOp.ReaderDAO();

        // add readers to the db
        Reader reader1 = new Reader("name1", "surname1", "1234567890", "address1", new Date(123123));
        Reader reader2 = new Reader("name1", "surname1", "1234567890", "address1", new Date(123123));

        readerDAO.saveEntity(reader1);
        readerDAO.saveEntity(reader2);
    }
}
