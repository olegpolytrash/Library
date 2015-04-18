package authorTest;

import com.soft.library.dataBase.dao.AuthorDAO;
import com.soft.library.dataBase.dao.impl.AuthorDAOImpl;
import com.soft.library.dataBase.dataBaseCore.JPAUtil;
import com.soft.library.dataBase.model.Author;
import org.dbunit.dataset.IDataSet;
import org.dbunit.dataset.xml.FlatXmlDataSet;
import org.dbunit.operation.DatabaseOperation;
import org.junit.Before;
import org.junit.Test;

import javax.persistence.EntityManager;

public class InsertTest extends DBUnitConfig {

    public InsertTest() {
        super("asd");
        JPAUtil.getEntityManagerFactory();
    }

    @Before
    public void tearDown() throws Exception {
        DatabaseOperation.DELETE_ALL.execute(this.getDatabaseTester()
                .getConnection(), getDataSet());
    }

    @Test
    public void testInsertion() {
        // prepare
        EntityManager entityManager = JPAUtil.getEntityManagerFactory().createEntityManager();
        entityManager.getTransaction().begin();

        // initialize DAO
        AuthorDAO authorDAO = new AuthorDAOImpl(entityManager);

        // add an author
        Author originalAuthor = new Author();
        originalAuthor.setName("test");
        authorDAO.save(originalAuthor);

        // close and prepare for reuse
        entityManager.getTransaction().commit();
        entityManager.clear();
        entityManager.getTransaction().begin();

        Author authorFromBD = authorDAO.findById(originalAuthor.getId());

        assertEquals(authorFromBD, originalAuthor);
        assertEquals(authorFromBD.getName(), originalAuthor.getName());

        // close
        entityManager.getTransaction().commit();
    }

    @Test
    public void testUpdateObjectFromDB() {
        // prepare
        EntityManager entityManager = JPAUtil.getEntityManagerFactory().createEntityManager();
        entityManager.getTransaction().begin();
        AuthorDAO authorDAO = new AuthorDAOImpl(entityManager);

        Author originalAuthor = new Author();
        originalAuthor.setName("test");
        authorDAO.save(originalAuthor);

        entityManager.getTransaction().commit();
        entityManager.clear();
        entityManager.getTransaction().begin();

        //test
        originalAuthor.setName("author new name");
        authorDAO.getUpdatedEntity(originalAuthor);

        entityManager.getTransaction().commit();
        entityManager.clear();
        entityManager.getTransaction().begin();

        Author author = authorDAO.findById(originalAuthor.getId());
        assertEquals(author, originalAuthor);
        assertEquals(author.getName(), originalAuthor.getName());

        // close
        entityManager.getTransaction().commit();
    }

    @Test
    public void testUpdateObject() {
        // create and add new Author
        EntityManager entityManager = JPAUtil.getEntityManagerFactory().createEntityManager();
        entityManager.getTransaction().begin();
        AuthorDAO authorDAO = new AuthorDAOImpl(entityManager);

        Author originalAuthor = new Author();
        originalAuthor.setName("test name");
        authorDAO.save(originalAuthor);

        entityManager.getTransaction().commit();

        // change name of a detached object and getUpdatedEntity it
        entityManager = JPAUtil.getEntityManagerFactory().createEntityManager();
        entityManager.getTransaction().begin();

        authorDAO = new AuthorDAOImpl(entityManager);

        originalAuthor = authorDAO.getUpdatedEntity(originalAuthor);
        originalAuthor.setName("test new name");
        System.out.println("after: " + originalAuthor);

        entityManager.getTransaction().commit();

        printAll();

        // get updated author from bd and check if name was updated
        Author authorByID = getAuthorByID(originalAuthor.getId());
        assertEquals(authorByID.getName(), originalAuthor.getName());
    }

    public Author getAuthorByID(int id) {
        // prepare
        EntityManager entityManager = JPAUtil.getEntityManagerFactory().createEntityManager();
        entityManager.getTransaction().begin();

        // initialize DAO
        AuthorDAO authorDAO = new AuthorDAOImpl(entityManager);

        // add an author
        Author originalAuthor = authorDAO.findById(id);

        // close and prepare for reuse
        entityManager.getTransaction().commit();

        return originalAuthor;
    }

    public void printAll() {
        // prepare
        EntityManager entityManager = JPAUtil.getEntityManagerFactory().createEntityManager();
        entityManager.getTransaction().begin();

        // initialize DAO
        AuthorDAO authorDAO = new AuthorDAOImpl(entityManager);

        System.out.println("print all:");
       authorDAO.getAll().forEach(System.out::println);
        System.out.println("print all;");

        // close and prepare for reuse
        entityManager.getTransaction().commit();
    }

    @Override
    protected IDataSet getDataSet() throws Exception {
        return new FlatXmlDataSet(this.getClass().getResourceAsStream(
                "/author.xml"));
    }
}
