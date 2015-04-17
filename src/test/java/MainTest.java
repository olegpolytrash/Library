import com.soft.library.dataBase.dataBaseCore.JPAUtil;
import com.soft.library.dataBase.model.*;

import javax.persistence.EntityManager;
import javax.persistence.EntityTransaction;
import java.sql.Date;


/**
 * Example
 */
public class MainTest {
    public void testMethod(){
        EntityManager entityManager = JPAUtil.getEntityManagerFactory().createEntityManager();
        EntityTransaction tx = null;

        try{
            tx = entityManager.getTransaction();
            tx.begin();

            Author a1 = new Author();
            a1.setName("a1");
            entityManager.persist(a1);
            Author a2 = new Author();
            a2.setName("a2");
            entityManager.persist(a2);

            Book b1 = new Book();
            b1.setName("b1");
            entityManager.persist(b1);

            Book b2 = new Book();
            b2.setName("b2");
            entityManager.persist(b2);

            b2.getAuthors().add(a2);
            a1.getBooks().add(b1);

            Publisher p1 = new Publisher();
            p1.setName("p1");
            entityManager.persist(p1);

            Reader r1 = new Reader();
            r1.setName("rn1");
            r1.setSurname("rs1");
                    r1.setAddress("a1");
            r1.setMobilePhone("rmob1");
            r1.setBirthDate(new Date(123123));
            entityManager.persist(r1);

            Library library = new Library();
            library.setYear(10);
            library.setPages(123);
            library.setBook(b1);
            library.setQuantity(4);
            library.setPublisher(p1);

            entityManager.persist(library);

            LibraryLogEntry libraryLogEntry = new LibraryLogEntry();
            libraryLogEntry.setBook(b1);
            libraryLogEntry.setReader(r1);
            libraryLogEntry.setReturned(new Date(123123));
            libraryLogEntry.setTaken(new Date(123123123));
            entityManager.persist(libraryLogEntry);

            tx.commit();
        } catch (Exception e) {
            if (tx != null) tx.rollback();
            e.printStackTrace();
        } finally {
            if (entityManager != null)
                entityManager.close();
        }

        AuthorTest.getAll();
        BookTest.getAll();
        PublisherTest.getAll();
        ReaderTest.getAll();
        LibraryTest.getAll();
        LibraryLogEntryTest.getAll();

        JPAUtil.getEntityManagerFactory().close();
    }

    public static void main(String[] args) {
        MainTest mainTest = new MainTest();
        mainTest.testMethod();
    }

}
