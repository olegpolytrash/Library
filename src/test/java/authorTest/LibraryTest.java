package authorTest;

import com.soft.library.dataBase.dao.LibraryDAO;
import com.soft.library.dataBase.dao.impl.AuthorDAOImpl;
import com.soft.library.dataBase.dao.oneOp.AuthorDAO;
import com.soft.library.dataBase.dao.oneOp.BookDAO;
import com.soft.library.dataBase.dao.oneOp.PublisherDAO;
import com.soft.library.dataBase.dataBaseCore.JPAUtil;
import com.soft.library.dataBase.model.Author;
import com.soft.library.dataBase.model.Book;
import com.soft.library.dataBase.model.Library;
import com.soft.library.dataBase.model.Publisher;
import org.apache.commons.lang3.builder.EqualsBuilder;
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
import java.util.*;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertTrue;

public class LibraryTest {

    public LibraryTest() {
        JPAUtil.getEntityManagerFactory();
    }

    private static IDatabaseTester databaseTester;
    static IDataSet dataSet;

    @BeforeClass
    public static void setUp() throws Exception {
        databaseTester = new JdbcDatabaseTester("com.mysql.jdbc.Driver",
                "jdbc:mysql://localhost/sql373362", "root", "1234");

        dataSet = new FlatXmlDataSetBuilder().build(new File("src\\test\\resources\\library.xml"));

        databaseTester.setDataSet(dataSet);
    }

    @AfterClass
    public static void tearDown() throws Exception {
        DatabaseOperation.DELETE_ALL.execute(databaseTester.getConnection(), dataSet);
    }

    static boolean isEqual(Library o1, Library o2) {
        if (!o1.getPages().equals(o2.getPages())) return false;
        if (!o1.getYear().equals(o2.getYear())) return false;
        if (!o1.getQuantity().equals(o2.getQuantity())) return false;
        if (!o1.getBook().equals(o2.getBook())) return false;
        return o1.getPublisher().equals(o2.getPublisher());
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

//        p1 = (Publisher) dataSet.getTable("publisher").getValue(1, "id");
//        p2 = (Publisher) dataSet.getTable("publisher").getValue(2, "id");
//        p3 = (Publisher) dataSet.getTable("publisher").getValue(3, "id");
//
//        b1 = (Book) dataSet.getTable("book").getValue(1, "id");
//        b2 = (Book) dataSet.getTable("book").getValue(2, "id");
//        b3 = (Book) dataSet.getTable("book").getValue(3, "id");
//
//        a1 = (Author) dataSet.getTable("author").getValue(1, "id");
//        a2 = (Author) dataSet.getTable("author").getValue(2, "id");
//        a3 = (Author) dataSet.getTable("author").getValue(3, "id");
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

    @Test
    public void testSave() {
        LibraryDAO libraryDAO = new com.soft.library.dataBase.dao.oneOp.LibraryDAO();

        // create and saveNewEntity an author
        Library library1 = new Library(100, 2011, 10, b1, p1);
        Library library2 = new Library(200, 2012, 20, b2, p2);
        Library library3 = new Library(300, 2013, 30, b3, p3);

        library1 = libraryDAO.saveEntity(library1);
        library2 = libraryDAO.saveEntity(library2);
        library3 = libraryDAO.saveEntity(library3);

        // find the author in the db
        Library libraryFromBD1 = libraryDAO.findById(library1.getId());
        Library libraryFromBD2 = libraryDAO.findById(library2.getId());
        Library libraryFromBD3 = libraryDAO.findById(library3.getId());

        // check if the correct author was found
        assertTrue(isEqual(libraryFromBD1, library1));
        assertTrue(isEqual(libraryFromBD2, library2));
        assertTrue(isEqual(libraryFromBD3, library3));
    }

    @Test
    public void testRemove() {
        LibraryDAO libraryDAO = new com.soft.library.dataBase.dao.oneOp.LibraryDAO();

        // create and saveNewEntity an author
        Library library1 = new Library(100, 2011, 10, b1, p1);
        Library library2 = new Library(200, 2012, 20, b2, p2);
        Library library3 = new Library(300, 2013, 30, b3, p3);

        library1 = libraryDAO.saveEntity(library1);
        library2 = libraryDAO.saveEntity(library2);
        library3 = libraryDAO.saveEntity(library3);

        // remove one library
        libraryDAO.remove(library2);

        // check lengths
        assertEquals(2, libraryDAO.getAll().size());
    }

//    @Test
//    public void testRemove() {
//        LibraryDAO libraryDAO = new com.soft.library.dataBase.dao.oneOp.LibraryDAO();
//
//        // create and saveNewEntity an author
//        Library library1 = new Library(100, 2011, 10, b1, p1);
//        Library library2 = new Library(200, 2012, 20, b2, p2);
//        Library library3 = new Library(300, 2013, 30, b3, p3);
//
//        library1 = libraryDAO.saveEntity(library1);
//        library2 = libraryDAO.saveEntity(library2);
//        library3 = libraryDAO.saveEntity(library3);
//
//        // remove one library
//        libraryDAO.remove(library2);
//
//        // check lengths
//        assertEquals(2, libraryDAO.getAll().size());
//    }
}
