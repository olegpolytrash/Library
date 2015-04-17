import com.soft.library.dataBase.dataBaseCore.JPAUtil;
import com.soft.library.dataBase.model.LibraryLogEntry;
import org.hibernate.HibernateException;

import javax.persistence.EntityManager;
import javax.persistence.EntityTransaction;
import java.util.Iterator;
import java.util.List;

/**
 * Created by Oleg on 12.04.2015.
 */
public class LibraryLogEntryTest {
    public static void getAll() {
        EntityManager entityManager = JPAUtil.getEntityManagerFactory().createEntityManager();
        EntityTransaction transaction = null;
        try{
            transaction = entityManager.getTransaction();
            transaction.begin();
            List authors = entityManager.createQuery("SELECT a FROM com.soft.library.dataBase.model.LibraryLogEntry a").getResultList();
            for (Iterator iterator = authors.iterator(); iterator.hasNext();) {
                LibraryLogEntry author = (LibraryLogEntry) iterator.next();
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
}
