package authorTest;

import com.soft.library.dataBase.dao.LibraryDAO;
import com.soft.library.dataBase.dao.oneOp.*;
import com.soft.library.dataBase.dataBaseCore.JPAUtil;
import com.soft.library.dataBase.model.*;
import org.dbunit.IDatabaseTester;
import org.dbunit.JdbcDatabaseTester;
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

public class LibraryLogEntryTest {

    public LibraryLogEntryTest() {
        JPAUtil.getEntityManagerFactory();
    }

    private static IDatabaseTester databaseTester;
    static IDataSet dataSet;

    @BeforeClass
    public static void setUp() throws Exception {
        databaseTester = new JdbcDatabaseTester("com.mysql.jdbc.Driver",
                "jdbc:mysql://localhost/sql373362", "root", "1234");

        dataSet = new FlatXmlDataSetBuilder().build(new File("src\\test\\resources\\libraryLogEntry.xml"));

        databaseTester.setDataSet(dataSet);
    }

    @AfterClass
    public static void tearDown() throws Exception {
        DatabaseOperation.DELETE_ALL.execute(databaseTester.getConnection(), dataSet);
    }

    static boolean isEqual(LibraryLogEntry o1, LibraryLogEntry o2) {
        if (!o1.getBook().equals(o2.getBook())) return false;
        if (!o1.getReader().equals(o2.getReader())) return false;
        if (!o1.getTaken().equals(o2.getTaken())) return false;
        return o1.getReturned().equals(o2.getReturned());
    }

    @Before
    public void tear() throws Exception {
        DatabaseOperation.CLEAN_INSERT.execute(databaseTester.getConnection(), dataSet);

        p1 = new PublisherDAO().findById(1);
        p2 = new PublisherDAO().findById(2);
        p3 = new PublisherDAO().findById(3);

        b1 = new BookDAO().findById(1);
        b2 = new BookDAO().findById(2);
        b3 = new BookDAO().findById(3);

        a1 = new AuthorDAO().findById(1);
        a2 = new AuthorDAO().findById(2);
        a3 = new AuthorDAO().findById(3);

        r1 = new ReaderDAO().findById(1);
        r2 = new ReaderDAO().findById(2);
        r3 = new ReaderDAO().findById(3);
    }

    Publisher p1;
    Publisher p2;
    Publisher p3;
    Book b1;
    Book b2;
    Book b3;
    Author a1;
    Author a2;
    Author a3;
    Reader r1;
    Reader r2;
    Reader r3;

    @Test
    public void testInsert() {
        LibraryLogEntryDAO libraryLogEntryDAO = new LibraryLogEntryDAO();

        LibraryLogEntry libraryLogEntry1 = new LibraryLogEntry(b1, r1, new Date(123123), new Date(345345));
        LibraryLogEntry libraryLogEntry2 = new LibraryLogEntry(b2, r2, new Date(123123), new Date(345345));
        LibraryLogEntry libraryLogEntry3 = new LibraryLogEntry(b3, r3, new Date(123123), new Date(345345));

        libraryLogEntry1 = libraryLogEntryDAO.saveEntity(libraryLogEntry1);
        libraryLogEntry2 = libraryLogEntryDAO.saveEntity(libraryLogEntry2);
        libraryLogEntry3 = libraryLogEntryDAO.saveEntity(libraryLogEntry3);

        LibraryLogEntry libraryLogEntryFromBD1 = libraryLogEntryDAO.findById(libraryLogEntry1.getId());
        LibraryLogEntry libraryLogEntryFromBD2 = libraryLogEntryDAO.findById(libraryLogEntry2.getId());
        LibraryLogEntry libraryLogEntryFromBD3 = libraryLogEntryDAO.findById(libraryLogEntry3.getId());

        assertTrue(isEqual(libraryLogEntry1, libraryLogEntryFromBD1));
        assertTrue(isEqual(libraryLogEntry2, libraryLogEntryFromBD2));
        assertTrue(isEqual(libraryLogEntry3, libraryLogEntryFromBD3));
    }

    @Test
    public void getAll() {
        LibraryLogEntryDAO libraryLogEntryDAO = new LibraryLogEntryDAO();

        List<LibraryLogEntry> logs = Arrays.asList(new LibraryLogEntry(b1, r1, new Date(123123), new Date(345345)),
                new LibraryLogEntry(b2, r2, new Date(123123), new Date(345345)),
                new LibraryLogEntry(b3, r3, new Date(123123), new Date(345345)));

        for (int i = 0; i < logs.size(); ++i) {
            logs.set(i, libraryLogEntryDAO.saveEntity(logs.get(i)));
        }

        assertEquals(3, libraryLogEntryDAO.getAll().size());
    }
}
