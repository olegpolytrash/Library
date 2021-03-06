package CrudTests;

import com.soft.library.dataBase.dao.BookDao;
import com.soft.library.dataBase.dao.isolated.AuthorDaoIsolated;
import com.soft.library.dataBase.dao.isolated.BookDaoIsolated;
import com.soft.library.dataBase.dataBaseCore.JpaUtil;
import com.soft.library.dataBase.model.Author;
import com.soft.library.dataBase.model.Book;
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
import java.util.HashSet;
import java.util.Iterator;
import java.util.Set;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertTrue;

/**
 * Class for testing Book's entity crud operations.
 */
public class BookTest {
    private static IDatabaseTester databaseTester;
    private static IDataSet dataSet;

    @BeforeClass
    public static void setUp() throws Exception {
        databaseTester = TestUtils.getJdbcDatabaseTester();
        dataSet = new FlatXmlDataSetBuilder().build(new File("src\\test\\resources\\datasets\\book.xml"));
        databaseTester.setDataSet(dataSet);
    }

    public BookTest() {
        JpaUtil.ENTITY_MANAGER_FACTORY.getEntityManagerFactory();
    }

    @Before
    public void tearDown() throws Exception {
        DatabaseOperation.DELETE_ALL.execute(databaseTester.getConnection(), dataSet);
    }

    @Test
    public void testSave() {
        BookDao bookDao = new BookDaoIsolated();
        Set<Author> authors = new HashSet<>(  new AuthorDaoIsolated().getAll() );

        // create and saveNewEntity a book
        Book originalBook = new Book("test", authors);
        originalBook = bookDao.saveEntity(originalBook);

        // find the book in the db
        Book bookFromBD = bookDao.findById(originalBook.getId());

        // check if the correct book was found
       assertEquals(originalBook, bookFromBD);
    }

    @Test
    public void testUpdateObjectInOneTransaction() {
        BookDao bookDao = new BookDaoIsolated();
        Set<Author> authors = new HashSet<>(  new AuthorDaoIsolated().getAll() );

        // add a book to the db
        Book originalBook = new Book("test", authors);
        originalBook = bookDao.saveEntity(originalBook);

        // make a change in the book and update db
        originalBook.setName("book new name");
        originalBook = bookDao.saveEntity(originalBook);

        // check if update was successful
        Book book = bookDao.findById(originalBook.getId());
        assertEquals(originalBook, book);
    }

    @Test
    public void testGetAll() {
        BookDao bookDao = new BookDaoIsolated();

        // add books to the db
        Book books[] = {new Book("test1"), new Book("test2"), new Book("test3")};

        for (int i = 0; i < books.length; i++) {
            books[i] = bookDao.saveEntity(books[i]);
        }

        // check if all books were selected
        assertEquals(books.length, bookDao.getAll().size());
        assertTrue(bookDao.getAll().equals(Arrays.asList(books)));
    }

    @Test
    public void testRemove() {
        BookDao bookDao = new BookDaoIsolated();

        // add a book to the db
        Book books[] = {new Book("test1"), new Book("test2"), new Book("test3")};

        for (int i = 0; i < books.length; i++) {
            books[i] = bookDao.saveEntity(books[i]);
        }

        // remove a book
        bookDao.remove(books[1]);

        // check if the book was removed
        Book book = bookDao.findById(books[1].getId());

        assertEquals(null, book);
    }

    @Test
    public void testFindByID() {
        BookDao bookDao = new BookDaoIsolated();

        // add a book to the db
        Book originalBook = new Book();
        originalBook.setName("test");
        originalBook = bookDao.saveEntity(originalBook);

        // find an book by id
        Book bookFromBD = bookDao.findById(originalBook.getId());

        // check
        assertEquals(originalBook, bookFromBD);
    }
}
