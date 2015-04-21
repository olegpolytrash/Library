package CrudTests;

import com.soft.library.dataBase.dao.LibraryDao;
import com.soft.library.dataBase.dao.isolated.BookDaoIsolated;
import com.soft.library.dataBase.dao.isolated.LibraryDaoIsolated;
import com.soft.library.dataBase.dao.isolated.PublisherDaoIsolated;
import com.soft.library.dataBase.dataBaseCore.JpaUtil;
import com.soft.library.dataBase.model.Book;
import com.soft.library.dataBase.model.Library;
import com.soft.library.dataBase.model.Publisher;
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
import java.util.List;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertTrue;

/**
 * Class for testing Library's entity crud operations.
 */
public class LibraryTest {
    private static IDatabaseTester databaseTester;
    private static IDataSet dataSet;

    private Publisher publisher1;
    private Publisher publisher2;
    private Publisher publisher3;
    private Book book1;
    private Book book2;
    private Book book3;

    public LibraryTest() {
        JpaUtil.ENTITY_MANAGER_FACTORY.getEntityManagerFactory();
    }

    @BeforeClass
    public static void setUp() throws Exception {
        databaseTester = TestUtils.getJdbcDatabaseTester();
        dataSet = new FlatXmlDataSetBuilder().build(new File("src\\test\\resources\\datasets\\library.xml"));
        databaseTester.setDataSet(dataSet);
    }

    @AfterClass
    public static void tearDown() throws Exception {
        DatabaseOperation.DELETE_ALL.execute(databaseTester.getConnection(), dataSet);
    }

    @Before
    public void before() throws Exception {
        DatabaseOperation.CLEAN_INSERT.execute(databaseTester.getConnection(), dataSet);

        // get pre-inserted db entries
        publisher1 = new PublisherDaoIsolated().findById(1);
        publisher2 = new PublisherDaoIsolated().findById(2);
        publisher3 = new PublisherDaoIsolated().findById(3);

        book1 = new BookDaoIsolated().findById(1);
        book2 = new BookDaoIsolated().findById(2);
        book3 = new BookDaoIsolated().findById(3);
    }

    @Test
    public void testSave() {
        LibraryDao libraryDao = new LibraryDaoIsolated();

        /// create and save library entries
        Library library1 = new Library(100, 2011, 10, book1, publisher1);
        Library library2 = new Library(200, 2012, 20, book2, publisher2);
        Library library3 = new Library(300, 2013, 30, book3, publisher3);

        library1 = libraryDao.saveEntity(library1);
        library2 = libraryDao.saveEntity(library2);
        library3 = libraryDao.saveEntity(library3);

        // find each of the saved libraries in the db
        Library libraryFromBD1 = libraryDao.findById(library1.getId());
        Library libraryFromBD2 = libraryDao.findById(library2.getId());
        Library libraryFromBD3 = libraryDao.findById(library3.getId());

        // check if the correct libraries were found
        assertEquals(libraryFromBD1, library1);
        assertEquals(libraryFromBD2, library2);
        assertEquals(libraryFromBD3, library3);
    }

    @Test
    public void testRemove() {
        LibraryDao libraryDao = new LibraryDaoIsolated();

        // create and save library entries
        Library library1 = new Library(100, 2011, 10, book1, publisher1);
        Library library2 = new Library(200, 2012, 20, book2, publisher2);
        Library library3 = new Library(300, 2013, 30, book3, publisher3);

        libraryDao.saveEntity(library1);
        library2 = libraryDao.saveEntity(library2);
        libraryDao.saveEntity(library3);

        // remove one library
        libraryDao.remove(library2);

        // check lengths
        int expectedSize = 2;
        assertEquals(expectedSize, libraryDao.getAll().size());
    }

    @Test
    public void testUpdate() {
        LibraryDao libraryDao = new LibraryDaoIsolated();

        // create and save a library
        Library library1 = new Library(100, 2011, 10, book1, publisher1);

        library1 = libraryDao.saveEntity(library1);

        // update the library
        library1.setPages(123);
        library1 = libraryDao.saveEntity(library1);

        // get updated library
        Library libraryFromBD1 = libraryDao.findById(library1.getId());

        // check lengths
        assertEquals(libraryFromBD1, library1);
    }

    @Test
    public void testGetAll() {
        LibraryDao libraryDao = new LibraryDaoIsolated();

        // create and save a list of library's entries
        List<Library> originalLibraries = Arrays.asList(new Library(100, 2011, 10, book1, publisher1),
                new Library(200, 2012, 20, book2, publisher2),
                new Library(300, 2013, 30, book3, publisher3));

        originalLibraries.forEach(libraryDao::saveEntity);

        // get all libraries from the db
        List<Library> libraries = libraryDao.getAll();

        // check if the correct library was found
        int expectedSize = 3;
        assertEquals(expectedSize, libraries.size());
    }


}
