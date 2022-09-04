package ru.netology.repository;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import ru.netology.data.Book;
import ru.netology.data.Product;
import ru.netology.data.Smartphone;

import static org.junit.jupiter.api.Assertions.*;

class RepositoryTest {
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

    @Test
    public void addNewAndRemoveProduct() {
        Repository repository = new Repository();
        repository.add(book1);
        repository.add(book2);
        repository.add(book3);
        repository.add(smartphone1);
        repository.add(smartphone2);
        repository.removeById(book3.getId());

        Product[] expected = {book1, book2, smartphone1, smartphone2};
        Product[] actual = repository.findAll();

        Assertions.assertArrayEquals(expected, actual);
    }
}