package ru.netology.itemManager;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import ru.netology.data.Book;
import ru.netology.data.Product;
import ru.netology.data.Smartphone;
import ru.netology.repository.Repository;

import static org.junit.jupiter.api.Assertions.*;

public class ManagerTest {
    Book book1 = new Book(
            1,
            "Россия в квадрате",
            4_100,
            "Дмитрий Марков");
    Book book2 = new Book(
            2,
            "Россия в царские времена",
            560,
            "Григорий Распутин");
    Book book3 = new Book(
            3,
            "Бесы",
            1_200,
            "Григорий Распутин");
    Smartphone smartphone1 = new Smartphone(
            10,
            "p40pro Ultra",
            89_999,
            "Huawei");
    Smartphone smartphone2 = new Smartphone(
            11,
            "12 Ultra",
            129_000,
            "Apple");
    Smartphone smartphone3 = new Smartphone(
            12,
            "iPhone 13 pro max",
            159_900,
            "Apple");
    Repository repository = new Repository();
    Manager manager = new Manager(repository);


    @Test
    public void shouldFindProduct() {

        manager.add(book1);
        manager.add(book2);
        manager.add(book3);
        manager.add(smartphone1);
        manager.add(smartphone2);
        manager.add(smartphone3);

        Product[] actual = manager.searchBy("Россия");
        Product[] expected = {book1, book2};

        Assertions.assertArrayEquals(expected, actual);
    }

    @Test
    public void shouldFindProduct2() {

        manager.add(book1);
        manager.add(book2);
        manager.add(book3);
        manager.add(smartphone1);
        manager.add(smartphone2);
        manager.add(smartphone3);

        Product[] actual = manager.searchBy("Ultra");
        Product[] expected = {smartphone1, smartphone2};

        Assertions.assertArrayEquals(expected, actual);
    }

    @Test
    public void shouldFindDualProduct() {

        manager.add(book1);
        manager.add(book2);
        manager.add(book3);
        manager.add(smartphone1);
        manager.add(smartphone2);
        manager.add(smartphone3);

        Product[] actual = manager.searchBy("Дмитрий Распутин");
        Product[] expected = {};

        Assertions.assertArrayEquals(expected, actual);
    }

    @Test
    public void shouldFindProductWithoutData() {

        Product[] actual = manager.searchBy("Дмитрий");
        Product[] expected = {};

        Assertions.assertArrayEquals(expected, actual);
    }

    @Test
    public void shouldFindAloneProduct() {

        manager.add(book1);
        manager.add(book2);
        manager.add(book3);
        manager.add(smartphone1);
        manager.add(smartphone2);
        manager.add(smartphone3);

        Product[] actual = manager.searchBy("iPhone");
        Product[] expected = {smartphone3};

        Assertions.assertArrayEquals(expected, actual);
    }

    @Test
    public void shouldFindAllProduct() {

        manager.add(book1);
        manager.add(book2);
        manager.add(book3);

        Product[] actual = manager.findAll();
        Product[] expected = {book1, book2, book3};

        Assertions.assertArrayEquals(expected, actual);
    }
}