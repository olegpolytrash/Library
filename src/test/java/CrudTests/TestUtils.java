package CrudTests;

import com.soft.library.dataBase.model.Author;
import com.soft.library.dataBase.model.Book;
import com.soft.library.dataBase.model.Library;
import com.soft.library.dataBase.model.LibraryLogEntry;
import org.dbunit.IDatabaseTester;
import org.dbunit.JdbcDatabaseTester;

import java.util.Iterator;

/**
 * Utility methods for tests.
 */
public class TestUtils {
    /**
     * @return standard connection string for the test db
     * @throws ClassNotFoundException if db driver' class wasn't found
     */
    static JdbcDatabaseTester getJdbcDatabaseTester() throws ClassNotFoundException {
        return new JdbcDatabaseTester("com.mysql.jdbc.Driver",
                "jdbc:mysql://localhost/sql373362", "root", "1234");
    }

    /**
     * Check two authors for equality
     * @param o1 first author to compare
     * @param o2 second author to compare
     * @param checkBooks true if author's books must be checked for equality,
     *                   fase otherwise
     * @return true if authors are equals, false otherwise
     */
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
                if (!TestUtils.isEqual(itO1.next(), itO2.next(), false)) {
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

    /**
     * Check two books for equality
     * @param o1 first book to compare
     * @param o2 second book to compare
     * @param checkAuthors true if book's authors must be checked for equality,
     *                   fase otherwise
     * @return true if books are equals, false otherwise
     */
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
                if (!TestUtils.isEqual(itO1.next(), itO2.next(), false)) {
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

    /**
     * Check two libraryLogEntries for equality
     * @param o1 first libraryLogEntry to compare
     * @param o2 second libraryLogEntry to compare
     * @return true if libraryLogEntries are equals, false otherwise
     */
    static boolean isEqual(LibraryLogEntry o1, LibraryLogEntry o2) {
        if (!o1.getBook().equals(o2.getBook())) return false;
        if (!o1.getReader().equals(o2.getReader())) return false;
        if (!o1.getTaken().equals(o2.getTaken())) return false;
        return o1.getReturned().equals(o2.getReturned());
    }

    /**
     * Check two libraries for equality
     * @param o1 first library to compare
     * @param o2 second library to compare
     * @return true if libraries are equals, false otherwise
     */
    static boolean isEqual(Library o1, Library o2) {
        if (!o1.getPages().equals(o2.getPages())) return false;
        if (!o1.getYear().equals(o2.getYear())) return false;
        if (!o1.getQuantity().equals(o2.getQuantity())) return false;
        if (!o1.getBook().equals(o2.getBook())) return false;
        return o1.getPublisher().equals(o2.getPublisher());
    }
}
