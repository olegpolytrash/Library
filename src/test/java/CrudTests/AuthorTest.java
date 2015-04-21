package CrudTests;

import com.soft.library.dataBase.dao.AuthorDao;
import com.soft.library.dataBase.dao.isolated.AuthorDaoIsolated;
import com.soft.library.dataBase.dao.isolated.BookDaoIsolated;
import com.soft.library.dataBase.dao.shared.AuthorDaoShared;
import com.soft.library.dataBase.dataBaseCore.JpaUtil;
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

/**
 * Class for testing Author's entity crud operations.
 */
public class AuthorTest {
    private static IDatabaseTester databaseTester;
    private static IDataSet dataSet;

    public AuthorTest() {
        JpaUtil.ENTITY_MANAGER_FACTORY.getEntityManagerFactory();
    }

    @BeforeClass
    public static void setUp() throws Exception {
        databaseTester = TestUtils.getJdbcDatabaseTester();
        dataSet = new FlatXmlDataSetBuilder().build(new File("src\\test\\resources\\datasets\\author.xml"));
        databaseTester.setDataSet(dataSet);
    }

    @AfterClass
    public static void tearDown() throws Exception {
        DatabaseOperation.DELETE_ALL.execute(databaseTester.getConnection(), dataSet);
    }

    @Before
    public void tear() throws Exception {
        DatabaseOperation.CLEAN_INSERT.execute(databaseTester.getConnection(), dataSet);
    }

    @Test
    public void testSave() {
        AuthorDao authorDao = new AuthorDaoIsolated();
        Set<Book> books = new HashSet<>(  new BookDaoIsolated().getAll() );

        // create and save an author
        Author originalAuthor = new Author("test");
        originalAuthor.setBooks(books);
        originalAuthor = authorDao.saveEntity(originalAuthor);

        // find the author in the db
        Author authorFromBD = authorDao.findById(originalAuthor.getId());

        // check if the correct author was found
        assertEquals(authorFromBD, originalAuthor);
    }

    @Test
    public void testUpdateObjectInDifferentTransactions() {
        AuthorDao authorDao = new AuthorDaoIsolated();
        Set<Book> books = new HashSet<>(  new BookDaoIsolated().getAll() );

        // add an author to the db
        Author originalAuthor = new Author("test");
        originalAuthor.setBooks(books);
        originalAuthor = authorDao.saveEntity(originalAuthor);

        // make a change in author and update db
        originalAuthor.setName("author new name");
        originalAuthor = authorDao.saveEntity(originalAuthor);

        // check if update was successful
        Author author = authorDao.findById(originalAuthor.getId());
        assertEquals(author, originalAuthor);
    }

    @Test
    public void testUpdateObjectInOneTransactionn() {
        AuthorDao authorDao = new AuthorDaoIsolated();
        Set<Book> books = new HashSet<>(  new BookDaoIsolated().getAll() );

        EntityManager entityManager = JpaUtil.ENTITY_MANAGER_FACTORY.createEntityManager();
        entityManager.getTransaction().begin();

        // add an author to the db
        Author originalAuthor = new Author("test", books);
        originalAuthor = authorDao.saveEntity(originalAuthor);

        AuthorDao authorDao2 = new AuthorDaoShared(entityManager);

        // change name of a detached object and update it
        originalAuthor.setName("test new name");
        originalAuthor = authorDao2.saveEntity(originalAuthor);

        entityManager.getTransaction().commit();

        // get the updated author from bd and check if the name was updated
        Author authorByID = authorDao.findById(originalAuthor.getId());
        assertEquals(authorByID, originalAuthor);
    }

    @Test
    public void testGetAll() {
        AuthorDao authorDao = new AuthorDaoIsolated();
        Set<Book> books = new HashSet<>(  new BookDaoIsolated().getAll() );

        // add authors to the database
        Author authors[] = {new Author("test1", books), new Author("test2", books), new Author("test3", books)};

        for (int i = 0; i < authors.length; i++) {
            authors[i] = authorDao.saveEntity(authors[i]);
        }

        // check if all authors were selected
        assertEquals(authors.length, authorDao.getAll().size());
        assertTrue(authorDao.getAll().equals(Arrays.asList(authors)));
    }

    @Test
    public void testRemove() {
        AuthorDao authorDao = new AuthorDaoIsolated();
        Set<Book> books = new HashSet<>(  new BookDaoIsolated().getAll() );

        // add authors to the database
        Author authors[] = {new Author("test1", books), new Author("test2", books), new Author("test3", books)};

        for (int i = 0; i < authors.length; i++) {
            authors[i] = authorDao.saveEntity(authors[i]);
        }

        // remove an author
        authorDao.remove(authors[1]);

        // check if the author was removed
        Author author = authorDao.findById(authors[1].getId());

        assertEquals(null, author);
    }

    @Test
    public void testFindByID() {
        AuthorDao authorDao = new AuthorDaoIsolated();
        Set<Book> books = new HashSet<>(  new BookDaoIsolated().getAll() );

        // add an author to the db
        Author originalAuthor = new Author("test", books);
        originalAuthor = authorDao.saveEntity(originalAuthor);

        // find an author by id
        Author authorFromBD = authorDao.findById(originalAuthor.getId());

        // check
        assertEquals(authorFromBD, originalAuthor);
    }
}
