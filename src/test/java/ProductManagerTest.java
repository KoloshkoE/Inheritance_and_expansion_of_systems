import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertArrayEquals;

public class ProductManagerTest {
    ProductRepository repository = new ProductRepository();
    ProductManager manager = new ProductManager(repository);
    Product book = new Book(201, "Death_of_the_Poet", 300, "Mikhail Lermontov");
    Product smartphone = new Smartphone(702, "Honor_as3", 24500, "Honor");
    Product product = new Product(903, "Coffee", 230);



    @Test
    void shouldAdd() {
        manager.add(book);
        Product[] expected = {book};
        Product[] actual = repository.findAll();
        assertArrayEquals(expected, actual);
    }

    @Test
    void shouldAddAll() {
        manager.add(book);
        manager.add(smartphone);
        manager.add(product);
        Product[] expected = {book, smartphone, product};
        Product[] actual = repository.findAll();
        assertArrayEquals(expected, actual);
    }

    @Test
    void shouldSearchBy() {
        manager.add(book);
        manager.add(smartphone);
        manager.add(product);
        String name ="Honor_as3";
        String name2 ="Coffee";
        Product[] expected = {smartphone, product};
        Product[][] actual ={manager.searchBy(name), manager.searchBy(name2) };
        assertArrayEquals(expected, actual);
    }

    @Test
    void shouldSearchWhenFewProductsSuit() {
        manager.add(book);
        manager.add(smartphone);
        manager.add(product);
        String name ="Poet";
        String name2 ="Coffee";
        Product[] expected = {book, product};
        Product[][] actual ={manager.searchBy(name), manager.searchBy(name2) };
        assertArrayEquals(expected, actual);
    }

    @Test
    void shouldSearchWhenProductsNotSuit() {
        manager.add(book);
        manager.add(smartphone);
        manager.add(product);
        String name = "Samsung";
        Product[] expected = {};
        Product[] actual = manager.searchBy(name);
        assertArrayEquals(expected, actual);
    }

}
