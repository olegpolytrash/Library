package authorTest;

import com.soft.library.dataBase.dao.BookDAO;
import com.soft.library.dataBase.dataBaseCore.JPAUtil;
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

public class BookTest {

    private static IDatabaseTester databaseTester;
    private static IDataSet dataSet;

    @BeforeClass
    public static void setUp() throws Exception {
        databaseTester = new JdbcDatabaseTester("com.mysql.jdbc.Driver",
                "jdbc:mysql://localhost/sql373362", "root", "1234");

        dataSet = new FlatXmlDataSetBuilder().build(new File("src\\test\\resources\\book.xml"));

        databaseTester.setDataSet(dataSet);

    }

    public BookTest() {
        JPAUtil.getEntityManagerFactory();
    }

    static boolean isEqual(Book o1, Book o2, boolean checkAuthors) {
            if (!o1.equals(o2)) {
                return false;
            }

            if (!o1.getName().equals(o2.getName())) {
                return false;
            }

        if (checkAuthors) {
            Iterator<Author> itO1 = o1.getAuthors().iterator();
            Iterator<Author> itO2 = o1.getAuthors().iterator();

            while (itO2.hasNext()) {
                if (!AuthorTest.isEqual(itO1.next(), itO2.next(), false)) {
                    return false;
                }
            }
        } else {
            if (o1.getAuthors().size() != o2.getAuthors().size()) {
                return false;
            }
        }

            return true;
        }

    @Before
    public void tearDown() throws Exception {
        DatabaseOperation.DELETE_ALL.execute(databaseTester.getConnection(), dataSet);
    }

    @Test
    public void testSave() {
        BookDAO bookDAO = new com.soft.library.dataBase.dao.oneOp.BookDAO();
        Set<Author> authors = new HashSet<>(  new com.soft.library.dataBase.dao.oneOp.AuthorDAO().getAll() );

        // create and saveNewEntity a book
        Book originalBook = new Book("test", authors);
        originalBook = bookDAO.saveEntity(originalBook);

        // find the book in the db
        Book bookFromBD = bookDAO.findById(originalBook.getId());

        // check if the correct book was found
       assertTrue(isEqual(originalBook, bookFromBD, true));
    }

    @Test
    public void testUpdateObjectInOneTransaction() {
        BookDAO bookDAO = new com.soft.library.dataBase.dao.oneOp.BookDAO();
        Set<Author> authors = new HashSet<>(  new com.soft.library.dataBase.dao.oneOp.AuthorDAO().getAll() );

        // add a book to the db
        Book originalBook = new Book("test", authors);
        originalBook = bookDAO.saveEntity(originalBook);

        // make a change in the book and update db
        originalBook.setName("book new name");
        originalBook = bookDAO.saveEntity(originalBook);

        // check if update was successful
        Book book = bookDAO.findById(originalBook.getId());
        assertTrue(isEqual(originalBook, book, true));
    }

    @Test
    public void testGetAll() {
        BookDAO bookDAO = new com.soft.library.dataBase.dao.oneOp.BookDAO();

        // add books to the db
        Book books[] = {new Book("test1"), new Book("test2"), new Book("test3")};

        for (int i = 0; i < books.length; i++) {
            books[i] = bookDAO.saveEntity(books[i]);
        }

        // check if all books were selected
        assertEquals(books.length, bookDAO.getAll().size());
        assertTrue(bookDAO.getAll().equals(Arrays.asList(books)));
    }

    @Test
    public void testRemove() {
        BookDAO bookDAO = new com.soft.library.dataBase.dao.oneOp.BookDAO();

        // add a book to the db
        Book books[] = {new Book("test1"), new Book("test2"), new Book("test3")};

        for (int i = 0; i < books.length; i++) {
            books[i] = bookDAO.saveEntity(books[i]);
        }

        // remove a book
        bookDAO.remove(books[1]);

        // check if the book was removed
        Book a = bookDAO.findById(books[1].getId());

        assertEquals(null, a);
    }

    @Test
    public void testFindByID() {
        BookDAO bookDAO = new com.soft.library.dataBase.dao.oneOp.BookDAO();

        // add a book to the db
        Book originalBook = new Book();
        originalBook.setName("test");
        originalBook = bookDAO.saveEntity(originalBook);

        // find an book by id
        Book bookFromBD = bookDAO.findById(originalBook.getId());

        // check
        assertTrue(isEqual(originalBook, bookFromBD, true));
    }
}
