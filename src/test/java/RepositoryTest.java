import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

public class RepositoryTest {
    @Test
    public void testRemoveProduct() {
        Repository repo = new Repository();
        Book book1 = new Book(1, "Andromeda strain", 200, "Michael Crichton");
        Book book2 = new Book(13, "Shadow forest", 150, "Frank Tillier");
        Book book3 = new Book(2, "Andromeda star", 230, "Maks Krypton");
        Book book4 = new Book(5, "Amnesia", 199, "Frederico Aksat");
        Smartphone phone1 = new Smartphone(33, "samsung GalaxyA23", 25_000, "Samsung");
        Smartphone phone2 = new Smartphone(54, "NokiaX10", 25_600, "Nokia");


        repo.add(book1);
        repo.add(book2);
        repo.add(book3);
        repo.add(book4);
        repo.add(phone1);
        repo.add(phone2);
        repo.removeById(1);
        Product[] actual = repo.findAll();
        Product[] expected = {book2, book3, book4, phone1, phone2};

        Assertions.assertArrayEquals(expected, actual);
    }

    @Test
    public void testRemoveProductOnePhone() {
        Repository repo = new Repository();
        Book book1 = new Book(1, "Andromeda strain", 200, "Michael Crichton");
        Book book2 = new Book(13, "Shadow forest", 150, "Frank Tillier");
        Book book3 = new Book(2, "Andromeda star", 230, "Maks Krypton");
        Book book4 = new Book(5, "Amnesia", 199, "Frederico Aksat");
        Smartphone phone1 = new Smartphone(33, "samsung GalaxyA23", 25_000, "Samsung");
        Smartphone phone2 = new Smartphone(54, "NokiaX10", 25_600, "Nokia");


        repo.add(book1);
        repo.add(book2);
        repo.add(book3);
        repo.add(book4);
        repo.add(phone1);
        repo.add(phone2);
        repo.removeById(33);
        Product[] actual = repo.findAll();
        Product[] expected = {book1, book2, book3, book4, phone2};

        Assertions.assertArrayEquals(expected, actual);
    }

    @Test
    public void testRemoveProductNotFoundExcept() {
        Repository repo = new Repository();
        Book book1 = new Book(1, "Andromeda strain", 200, "Michael Crichton");
        Book book2 = new Book(13, "Shadow forest", 150, "Frank Tillier");
        Book book3 = new Book(2, "Andromeda star", 230, "Maks Krypton");
        Book book4 = new Book(5, "Amnesia", 199, "Frederico Aksat");
        Smartphone phone1 = new Smartphone(33, "samsung GalaxyA23", 25_000, "Samsung");
        Smartphone phone2 = new Smartphone(54, "NokiaX10", 25_600, "Nokia");


        repo.add(book1);
        repo.add(book2);
        repo.add(book3);
        repo.add(book4);
        repo.add(phone1);
        repo.add(phone2);

        Assertions.assertThrows(NotFoundException.class,
                () -> repo.removeById(20)
        );
    }

}
