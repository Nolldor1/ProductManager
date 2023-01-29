package ru.netology;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import ru.netology.repository.ProductRepository;

import static org.junit.jupiter.api.Assertions.*;

public class ProductManagerTest {

    Book product1 = new Book(201, "Lord of The Rings", 1000, "Tolkin");
    Book product2 = new Book(202, "Lord of The Rings 2", 1000, "Tolkin");
    Book product3 = new Book(203, "Lord of The Rings 3", 1000, "Tolkin");
    Smartphone product4 = new Smartphone(101, "Apple Iphone 14", 70000, "Apple Inc");

    @Test
    public void searchByNameAmongSeveral() {
        ProductRepository repo = new ProductRepository();
        ProductManager manager = new ProductManager(repo);

        manager.add(product1);
        manager.add(product2);
        manager.add(product3);
        manager.add(product4);
        Product[] actual = manager.searchBy("Lord");
        Product[] expected = {product1, product2, product3};


        Assertions.assertArrayEquals(expected, actual);
    }

    @Test
    public void searchByNameIncorrectRequest() {
        ProductRepository repo = new ProductRepository();
        ProductManager manager = new ProductManager(repo);

        manager.add(product1);
        manager.add(product2);
        manager.add(product3);
        manager.add(product4);
        Product[] actual = manager.searchBy("Harry Potter");
        Product[] expected = {};


        Assertions.assertArrayEquals(expected, actual);
    }

    @Test
    public void searchByNameOnlyOne() {
        ProductRepository repo = new ProductRepository();
        ProductManager manager = new ProductManager(repo);

        manager.add(product1);
        manager.add(product2);
        manager.add(product3);
        manager.add(product4);
        Product[] actual = manager.searchBy("Iphone");
        Product[] expected = {product4};


        Assertions.assertArrayEquals(expected, actual);
    }

}