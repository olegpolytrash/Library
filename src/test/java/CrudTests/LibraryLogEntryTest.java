package CrudTests;

import com.soft.library.dataBase.dao.isolated.*;
import com.soft.library.dataBase.dataBaseCore.JpaUtil;
import com.soft.library.dataBase.model.*;
import org.dbunit.IDatabaseTester;
import org.dbunit.dataset.IDataSet;
import org.dbunit.dataset.xml.FlatXmlDataSetBuilder;
import org.dbunit.operation.DatabaseOperation;
import org.junit.AfterClass;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;

import java.io.File;
import java.util.Arrays;
import java.util.Date;
import java.util.List;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertTrue;

/**
 * Class for testing LibraryLogEntry's entity crud operations.
 */
public class LibraryLogEntryTest {
    private static IDatabaseTester databaseTester;
    private static IDataSet dataSet;

    private Book book1;
    private Book book2;
    private Book book3;
    private Reader reader1;
    private Reader reader2;
    private Reader reader3;

    public LibraryLogEntryTest() {
        JpaUtil.ENTITY_MANAGER_FACTORY.getEntityManagerFactory();
    }

    @BeforeClass
    public static void setUp() throws Exception {
        databaseTester = TestUtils.getJdbcDatabaseTester();
        dataSet = new FlatXmlDataSetBuilder().build(new File("src\\test\\resources\\datasets\\libraryLogEntry.xml"));
        databaseTester.setDataSet(dataSet);
    }

    @AfterClass
    public static void tearDown() throws Exception {
        DatabaseOperation.DELETE_ALL.execute(databaseTester.getConnection(), dataSet);
    }

    @Before
    public void tear() throws Exception {
        DatabaseOperation.CLEAN_INSERT.execute(databaseTester.getConnection(), dataSet);

        // get pre-inserted db entries
        book1 = new BookDaoIsolated().findById(1);
        book2 = new BookDaoIsolated().findById(2);
        book3 = new BookDaoIsolated().findById(3);

        reader1 = new ReaderDaoIsolated().findById(1);
        reader2 = new ReaderDaoIsolated().findById(2);
        reader3 = new ReaderDaoIsolated().findById(3);
    }

    @Test
    public void testInsert() {
        LibraryLogEntryDaoIsolated libraryLogEntryDAO = new LibraryLogEntryDaoIsolated();

        LibraryLogEntry libraryLogEntry1 = new LibraryLogEntry(book1, reader1, new Date(123123), new Date(345345));
        LibraryLogEntry libraryLogEntry2 = new LibraryLogEntry(book2, reader2, new Date(123123), new Date(345345));
        LibraryLogEntry libraryLogEntry3 = new LibraryLogEntry(book3, reader3, new Date(123123), new Date(345345));

        libraryLogEntry1 = libraryLogEntryDAO.saveEntity(libraryLogEntry1);
        libraryLogEntry2 = libraryLogEntryDAO.saveEntity(libraryLogEntry2);
        libraryLogEntry3 = libraryLogEntryDAO.saveEntity(libraryLogEntry3);

        LibraryLogEntry libraryLogEntryFromBD1 = libraryLogEntryDAO.findById(libraryLogEntry1.getId());
        LibraryLogEntry libraryLogEntryFromBD2 = libraryLogEntryDAO.findById(libraryLogEntry2.getId());
        LibraryLogEntry libraryLogEntryFromBD3 = libraryLogEntryDAO.findById(libraryLogEntry3.getId());

        assertEquals(libraryLogEntry1, libraryLogEntryFromBD1);
        assertEquals(libraryLogEntry2, libraryLogEntryFromBD2);
        assertEquals(libraryLogEntry3, libraryLogEntryFromBD3);
    }

    @Test
    public void getAll() {
        LibraryLogEntryDaoIsolated libraryLogEntryDAO = new LibraryLogEntryDaoIsolated();

        List<LibraryLogEntry> logs = Arrays.asList(new LibraryLogEntry(book1, reader1, new Date(123123), new Date(345345)),
                new LibraryLogEntry(book2, reader2, new Date(123123), new Date(345345)),
                new LibraryLogEntry(book3, reader3, new Date(123123), new Date(345345)));

        for (int i = 0; i < logs.size(); ++i) {
            logs.set(i, libraryLogEntryDAO.saveEntity(logs.get(i)));
        }

        int expectedSize = 3;
        assertEquals(expectedSize, libraryLogEntryDAO.getAll().size());
    }

    @Test
    public void remove() {
        LibraryLogEntryDaoIsolated libraryLogEntryDAO = new LibraryLogEntryDaoIsolated();

        List<LibraryLogEntry> logs = Arrays.asList(new LibraryLogEntry(book1, reader1, new Date(123123), new Date(345345)),
                new LibraryLogEntry(book2, reader2, new Date(123123), new Date(345345)),
                new LibraryLogEntry(book3, reader3, new Date(123123), new Date(345345)));

        for (int i = 0; i < logs.size(); ++i) {
            logs.set(i, libraryLogEntryDAO.saveEntity(logs.get(i)));
        }

        libraryLogEntryDAO.remove(logs.get(1));

        int expectedSize = 2;
        assertEquals(expectedSize, libraryLogEntryDAO.getAll().size());
    }

    @Test
    public void update() {
        LibraryLogEntryDaoIsolated libraryLogEntryDAO = new LibraryLogEntryDaoIsolated();

        LibraryLogEntry libraryLogEntry1 = new LibraryLogEntry(book1, reader1, new Date(123123), new Date(345345));
        libraryLogEntry1 = libraryLogEntryDAO.saveEntity(libraryLogEntry1);

        libraryLogEntry1.setReturned(new Date(4444444));
        libraryLogEntry1 = libraryLogEntryDAO.saveEntity(libraryLogEntry1);

        LibraryLogEntry logFromDB = libraryLogEntryDAO.findById(libraryLogEntry1.getId());

        assertEquals(libraryLogEntry1, logFromDB);
        assertEquals(1, libraryLogEntryDAO.getAll().size());
    }
}
