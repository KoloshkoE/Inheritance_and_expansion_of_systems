import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertArrayEquals;

public class ProductRepositoryTest {
    private ProductRepository repository = new ProductRepository();
    Product book = new Book(001, "Death of the Poet", 300, "Mikhail Lermontov");
    Product smartphone = new Smartphone(002, "Honor as3", 24500, "Honor");
    Product product = new Product(003, "Coffee", 230);

    @Test
    public void shouldSaveTest() {
        repository.save(book);
        Product[] expected = {book};
        Product[] actual = repository.findAll();
        assertArrayEquals(expected, actual);
    }

    @Test
    public void shouldFindAllTest() {
        repository.save(book);
        repository.save(smartphone);
        repository.save(product);
        Product[] expected = {book, smartphone, product};
        Product[] actual = repository.findAll();
        assertArrayEquals(expected, actual);

    }

    @Test
    public void shouldRemoveByIDTest() {
        repository.save(book);
        repository.save(smartphone);
        repository.save(product);
        repository.removeByID(002);
        Product[] expected = {book, product};
        Product[] actual = repository.findAll();
        assertArrayEquals(expected, actual);
    }

    @Test
    public void shouldRemoveAllByIdTest() {
        repository.save(book);
        repository.save(smartphone);
        repository.save(product);
        repository.removeByID(001);
        repository.removeByID(002);
        repository.removeByID(003);
        Product[] expected = {};
        Product[] actual = repository.findAll();
        assertArrayEquals(expected, actual);
    }
}
