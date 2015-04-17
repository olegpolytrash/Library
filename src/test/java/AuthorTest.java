import com.soft.library.dataBase.dataBaseCore.JPAUtil;
import com.soft.library.dataBase.model.Author;
import org.hibernate.HibernateException;

import javax.persistence.EntityManager;
import javax.persistence.EntityTransaction;
import java.util.Iterator;
import java.util.List;

/**
 * Created by Oleg on 12.04.2015.
 */
public class AuthorTest {
    public static void getAll() {
        EntityManager entityManager = JPAUtil.getEntityManagerFactory().createEntityManager();
        EntityTransaction transaction = null;
        try{
            transaction = entityManager.getTransaction();
            transaction.begin();
            List authors = entityManager.createQuery("SELECT a FROM com.soft.library.dataBase.model.Author a").getResultList();
            for (Iterator iterator = authors.iterator(); iterator.hasNext();) {
                Author author = (Author) iterator.next();
                System.out.print(author);
                System.out.println();
            }
            transaction.commit();
        }catch (HibernateException e) {
            if (transaction!=null) transaction.rollback();
            e.printStackTrace();
        } finally {
            entityManager.close();
        }
    }

//    @Test
//    public void testInsert() {
//        Session session = TestingSessionFactory.INSTANCE.get().openSession();
//        Transaction tx = session.getTransaction();
//
//        Author author1 = new Author("author1");
//        session.save(author1);
//
//        tx.commit();
//        session.close();
//    }
}
