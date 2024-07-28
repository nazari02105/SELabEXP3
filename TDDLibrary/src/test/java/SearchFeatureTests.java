import classes.Book;
import classes.Library;
import classes.SearchByType;
import classes.Student;
import org.junit.Before;
import org.junit.Test;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import static org.junit.Assert.*;

public class SearchFeatureTests {
    Library library = new Library();
    Book book1 = new Book("Book-1", "Author-1", 10);
    Book book2 = new Book("Book-2", "Author-2", 11);
    Book book3 = new Book("Book-3", "Author-3", 12);
    Student student1 = new Student("Alice", 10);
    Student student2 = new Student("Bob", 11);

    @Before
    public void createLibrary() {
        library.addBook(book1);
        library.addBook(book2);
        library.addStudent(student1);
        library.addStudent(student2);
    }

    @Test
    public void searchBookTest() {
        var keys = new ArrayList<Object>(Arrays.asList(10, 11));
        List<Book> result = library.searchBooks(SearchByType.ID, keys);
        assertTrue(result.contains(book1));
        assertTrue(result.contains(book2));
        assertFalse(result.contains(book3));
    }

    @Test
    public void searchBookNullTest() {
        var keys = new ArrayList<Object>(Arrays.asList("Ali", "Reza"));
        List<Book> result = library.searchBooks(SearchByType.NAME, keys);
        assertEquals(null, result);
    }

    @Test
    public void searchStudentTest() {
        var keys = new ArrayList<Object>(Arrays.asList("Alice"));
        List<Student> result = library.searchStudents(SearchByType.NAME, keys);
        assertTrue(result.contains(student1));
        assertFalse(result.contains(student2));
    }

    @Test
    public void searchStudentNullTest() {
        var keys = new ArrayList<Object>(Arrays.asList("Ali", "Reza"));
        List<Student> result = library.searchStudents(SearchByType.AUTHOR, keys);
        assertEquals(null, result);
    }
}
