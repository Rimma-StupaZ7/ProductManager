import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

public class ManagerTest {

    @Test
    public void testFindProduct() {
        Repository repo = new Repository();
        Manager manager = new Manager(repo);
        Book book1 = new Book(1, "Andromeda strain", 200, "Michael Crichton");
        Book book2 = new Book(13, "Shadow forest", 150, "Frank Tillier");
        Book book3 = new Book(2, "Andromeda star", 230, "Maks Krypton");
        Smartphone phone1 = new Smartphone(33, "samsung GalaxyA23", 25_000, "Samsung");

        manager.add(book1);
        manager.add(book2);
        manager.add(book3);
        manager.add(phone1);
        Product[] actual = manager.searchBy("Andromeda");
        Product[] expected = {book1, book3};

        Assertions.assertArrayEquals(expected, actual);
    }

    @Test
    public void testFindZeroProduct() {
        Repository repo = new Repository();
        Manager manager = new Manager(repo);
        Book book1 = new Book(1, "Andromeda strain", 200, "Michael Crichton");
        Book book2 = new Book(13, "Shadow forest", 150, "Frank Tillier");
        Book book3 = new Book(2, "Andromeda star", 230, "Maks Krypton");
        Book book4 = new Book(5, "Amnesia", 199, "Frederico Aksat");
        Smartphone phone1 = new Smartphone(33, "samsung GalaxyA23", 25_000, "Samsung");
        Smartphone phone2 = new Smartphone(54, "NokiaX10", 25_600, "Nokia");

        manager.add(book1);
        manager.add(book2);
        manager.add(book3);
        manager.add(book4);
        manager.add(phone1);
        Product[] actual = manager.searchBy("Potter");
        Product[] expected = {};

        Assertions.assertArrayEquals(expected, actual);
    }

    @Test
    public void testFindPhoneProduct() {
        Repository repo = new Repository();
        Manager manager = new Manager(repo);
        Book book1 = new Book(1, "Andromeda strain", 200, "Michael Crichton");
        Book book2 = new Book(13, "Shadow forest", 150, "Frank Tillier");
        Book book3 = new Book(2, "Andromeda star", 230, "Maks Krypton");
        Book book4 = new Book(5, "Amnesia", 199, "Frederico Aksat");
        Smartphone phone1 = new Smartphone(33, "samsung GalaxyA23", 25_000, "Samsung");
        Smartphone phone2 = new Smartphone(54, "NokiaX10", 25_600, "Nokia");
        Smartphone phone3 = new Smartphone(3, "NokiaX", 15_600, "Nokia");

        manager.add(book1);
        manager.add(book2);
        manager.add(book3);
        manager.add(phone1);
        manager.add(phone2);
        manager.add(phone3);

        Product[] actual = manager.searchBy("Nokia");
        Product[] expected = {phone2, phone3};

        Assertions.assertArrayEquals(expected, actual);
    }

    @Test
    public void testFindProductBook() {
        Repository repo = new Repository();
        Manager manager = new Manager(repo);
        Book book1 = new Book(1, "Andromeda strain", 200, "Michael Crichton");
        Book book2 = new Book(13, "Shadow forest", 150, "Frank Tillier");
        Smartphone phone1 = new Smartphone(33, "samsung GalaxyA23", 25_000, "Samsung");
        Smartphone phone2 = new Smartphone(54, "NokiaX10", 25_600, "Nokia");

        manager.add(book1);
        manager.add(book2);
        manager.add(phone1);
        manager.add(phone2);

        Product[] actual = manager.searchBy("Shadow");
        Product[] expected = {book2};

        Assertions.assertArrayEquals(expected, actual);
    }

}
