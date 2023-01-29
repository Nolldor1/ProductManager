import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import ru.netology.Book;
import ru.netology.Product;
import ru.netology.Smartphone;
import ru.netology.repository.ProductRepository;

public class ProductRepositoryTest {

    Product product1 = new Product(001, "Мяч", 800);
    Product product2 = new Product(002, "Кружка", 400);
    Product product3 = new Product(003, "Рамка", 200);
    Book product4 = new Book(201, "Lord of The Rings", 1000, "Tolkin");
    Book product5 = new Book(202, "Lord of The Rings 2", 1000, "Tolkin");
    Book product6 = new Book(203, "Lord of The Rings 3", 1000, "Tolkin");
    Smartphone product7 = new Smartphone(101, "Apple Iphone 14", 70000, "Apple Inc");


    @Test
    public void testFindAll() {
        ProductRepository repo = new ProductRepository();
        repo.add(product1);
        repo.add(product2);
        repo.add(product3);
        repo.add(product4);
        repo.add(product5);
        repo.add(product6);
        repo.add(product7);

        Product[] expected = {product1, product2, product3, product4, product5, product6, product7};
        Product[] actual = repo.findAll();

        Assertions.assertArrayEquals(expected, actual);
    }

    @Test
    public void removeByIdOnlyOne() {
        ProductRepository repo = new ProductRepository();
        repo.add(product1);
        repo.add(product2);
        repo.add(product3);
        repo.add(product4);
        repo.add(product5);
        repo.add(product6);
        repo.add(product7);
        repo.removeById(product2.getId());

        Product[] expected = {product1, product3, product4, product5, product6, product7};
        Product[] actual = repo.findAll();

        Assertions.assertArrayEquals(expected, actual);
    }

    @Test
    public void removeByIdFirstAndLast() {
        ProductRepository repo = new ProductRepository();
        repo.add(product1);
        repo.add(product2);
        repo.add(product3);
        repo.add(product4);
        repo.add(product5);
        repo.add(product6);
        repo.add(product7);
        repo.removeById(product1.getId());
        repo.removeById(product7.getId());

        Product[] expected = {product2, product3, product4, product5, product6,};
        Product[] actual = repo.findAll();

        Assertions.assertArrayEquals(expected, actual);
    }

    @Test
    public void removeByIdSomeFromMiddle() {
        ProductRepository repo = new ProductRepository();
        repo.add(product1);
        repo.add(product2);
        repo.add(product3);
        repo.add(product4);
        repo.add(product5);
        repo.add(product6);
        repo.add(product7);
        repo.removeById(product3.getId());
        repo.removeById(product4.getId());
        repo.removeById(product5.getId());

        Product[] expected = {product1, product2, product6, product7};
        Product[] actual = repo.findAll();

        Assertions.assertArrayEquals(expected, actual);
    }
}
