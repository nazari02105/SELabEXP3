import classes.Book;
import classes.Library;
import classes.Student;
import org.junit.Test;

import static org.junit.Assert.*;

public class BugFixTests {
    @Test
    public void testPrintMessage() {
        Book book = new Book("Book-1", "Author-1", 10);
        assertEquals(book.toString(), "Book-1 by Author-1");
    }

    @Test
    public void lendBookTest() {
        Library library = new Library();

        Book book1 = new Book("Book-1", "Author-1", 10);
        Book book2 = new Book("Book-2", "Author-2", 11);

        Student student1 = new Student("Alice", 10);
        Student student2 = new Student("Bob", 11);

        library.addBook(book1);
        library.addBook(book2);
        library.addStudent(student1);

        assertTrue(library.lendBook(book1, student1));
        assertFalse(library.lendBook(book2, student2));
    }

    @Test
    public void returnBookTest() {
        Library library = new Library();

        Book book1 = new Book("Book-1", "Author-1", 10);

        Student student1 = new Student("Alice", 10);

        library.addBook(book1);
        library.addStudent(student1);

        assertTrue(library.lendBook(book1, student1));
        assertTrue(student1.hasBook(book1));
        assertTrue(library.returnBook(book1, student1));
        assertFalse(student1.hasBook(book1));
    }
}
