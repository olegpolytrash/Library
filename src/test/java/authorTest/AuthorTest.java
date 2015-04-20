package authorTest;

import com.soft.library.dataBase.dao.AuthorDAO;
import com.soft.library.dataBase.dao.impl.AuthorDAOImpl;
import com.soft.library.dataBase.dataBaseCore.JPAUtil;
import com.soft.library.dataBase.model.Author;
import com.soft.library.dataBase.model.Book;
import org.dbunit.IDatabaseTester;
import org.dbunit.JdbcDatabaseTester;
import org.dbunit.dataset.IDataSet;
import org.dbunit.dataset.xml.FlatXmlDataSetBuilder;
import org.dbunit.operation.DatabaseOperation;
import org.junit.AfterClass;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;

import javax.persistence.EntityManager;
import java.io.File;
import java.util.Arrays;
import java.util.HashSet;
import java.util.Iterator;
import java.util.Set;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertTrue;

public class AuthorTest {

    public AuthorTest() {
        JPAUtil.getEntityManagerFactory();
    }

    private static IDatabaseTester databaseTester;
    static IDataSet dataSet;

    @BeforeClass
    public static void setUp() throws Exception {
        databaseTester = new JdbcDatabaseTester("com.mysql.jdbc.Driver",
                "jdbc:mysql://localhost/sql373362", "root", "1234");

        dataSet = new FlatXmlDataSetBuilder().build(new File("src\\test\\resources\\author.xml"));

        databaseTester.setDataSet(dataSet);

    }

    @AfterClass
    public static void tearDown() throws Exception {
        DatabaseOperation.DELETE_ALL.execute(databaseTester.getConnection(), dataSet);
    }

    static boolean isEqual(Author o1, Author o2, boolean checkBooks) {
            if (!o1.equals(o2)) {
                return false;
            }

            if (!o1.getName().equals(o2.getName())) {
                return false;
            }

            if (o1.getBooks().size() != o2.getBooks().size()) {
                return false;
            }

        if (checkBooks) {
            Iterator<Book> itO1 = o1.getBooks().iterator();
            Iterator<Book> itO2 = o1.getBooks().iterator();

            while (itO2.hasNext()) {
                if (!BookTest.isEqual(itO1.next(), itO2.next(), false)) {
                    return false;
                }
            }
        } else {
            if (o1.getBooks().size() != o2.getBooks().size()) {
                return false;
            }
        }

            return true;
        }

    @Before
    public void tear() throws Exception {
        DatabaseOperation.CLEAN_INSERT.execute(databaseTester.getConnection(), dataSet);
    }

    @Test
    public void testSave() {
        AuthorDAO authorDAO = new com.soft.library.dataBase.dao.oneOp.AuthorDAO();
        Set<Book> books = new HashSet<>(  new com.soft.library.dataBase.dao.oneOp.BookDAO().getAll() );

        // create and saveNewEntity an author
        Author originalAuthor = new Author("test");
        originalAuthor.setBooks(books);
        originalAuthor = authorDAO.saveEntity(originalAuthor);

        // find the author in the db
        Author authorFromBD = authorDAO.findById(originalAuthor.getId());

        // check if the correct author was found
        assertTrue(isEqual(authorFromBD, originalAuthor, true));
    }

    @Test
    public void testUpdateObjectInDifferentTransactions() {
        AuthorDAO authorDAO = new com.soft.library.dataBase.dao.oneOp.AuthorDAO();
        Set<Book> books = new HashSet<>(  new com.soft.library.dataBase.dao.oneOp.BookDAO().getAll() );

        // add an author to the db
        Author originalAuthor = new Author("test");
        originalAuthor.setBooks(books);
        originalAuthor = authorDAO.saveEntity(originalAuthor);

        // make a change in author and update db
        originalAuthor.setName("author new name");
        originalAuthor = authorDAO.saveEntity(originalAuthor);

        // check if update was successful
        Author author = authorDAO.findById(originalAuthor.getId());
        assertTrue(isEqual(author, originalAuthor, true));
    }

    @Test
    public void testUpdateObjectInOneTransactionn() {
        AuthorDAO authorDAO = new com.soft.library.dataBase.dao.oneOp.AuthorDAO();
        Set<Book> books = new HashSet<>(  new com.soft.library.dataBase.dao.oneOp.BookDAO().getAll() );

        EntityManager entityManager = JPAUtil.getEntityManagerFactory().createEntityManager();
        entityManager.getTransaction().begin();

        // add an author to the db
        Author originalAuthor = new Author("test", books);
        originalAuthor = authorDAO.saveEntity(originalAuthor);

        AuthorDAO authorDAO2 = new AuthorDAOImpl(entityManager);

        // change name of a detached object and update it
        originalAuthor.setName("test new name");
        originalAuthor = authorDAO2.saveEntity(originalAuthor);

        entityManager.getTransaction().commit();

        // get the updated author from bd and check if the name was updated
        Author authorByID = authorDAO.findById(originalAuthor.getId());
        assertTrue(isEqual(authorByID, originalAuthor, true));
    }

    @Test
    public void testGetAll() {
        AuthorDAO authorDAO = new com.soft.library.dataBase.dao.oneOp.AuthorDAO();
        Set<Book> books = new HashSet<>(  new com.soft.library.dataBase.dao.oneOp.BookDAO().getAll() );

        // add authors to the database
        Author authors[] = {new Author("test1", books), new Author("test2", books), new Author("test3", books)};

        for (int i = 0; i < authors.length; i++) {
            authors[i] = authorDAO.saveEntity(authors[i]);
        }

        // check if all authors were selected
        assertEquals(authors.length, authorDAO.getAll().size());
        assertTrue(authorDAO.getAll().equals(Arrays.asList(authors)));
    }

    @Test
    public void testRemove() {
        AuthorDAO authorDAO = new com.soft.library.dataBase.dao.oneOp.AuthorDAO();
        Set<Book> books = new HashSet<>(  new com.soft.library.dataBase.dao.oneOp.BookDAO().getAll() );

        // add authors to the database
        Author authors[] = {new Author("test1", books), new Author("test2", books), new Author("test3", books)};

        for (int i = 0; i < authors.length; i++) {
            authors[i] = authorDAO.saveEntity(authors[i]);
        }

        // remove an author
        authorDAO.remove(authors[1]);

        // check if the author was removed
        Author a = authorDAO.findById(authors[1].getId());

        assertEquals(null, a);
    }

    @Test
    public void testFindByID() {
        AuthorDAO authorDAO = new com.soft.library.dataBase.dao.oneOp.AuthorDAO();
        Set<Book> books = new HashSet<>(  new com.soft.library.dataBase.dao.oneOp.BookDAO().getAll() );

        // add an author to the db
        Author originalAuthor = new Author("test", books);
        originalAuthor = authorDAO.saveEntity(originalAuthor);

        // find an author by id
        Author authorFromBD = authorDAO.findById(originalAuthor.getId());

        // check
        assertTrue(isEqual(authorFromBD, originalAuthor, true));
    }
}
