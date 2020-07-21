package ru.netology.repository;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import ru.netology.domain.Book;
import ru.netology.domain.Product;
import ru.netology.domain.Smartphone;
import ru.netology.exception.NotFoundException;

import static org.junit.jupiter.api.Assertions.assertArrayEquals;
import static org.junit.jupiter.api.Assertions.assertThrows;

public class ProductRepositoryTest {

    private ProductRepository repository = new ProductRepository();

    private Product first = new Book(1,"Name1", 1, "author1");
    private Product second = new Book(2,"Name2", 2, "author2");
    private Product third = new Smartphone(3,"Name3", 3, "fabric1");
    private Product fourth = new Smartphone(4,"Name4", 4, "fabric1");


    @BeforeEach
    public void setUp() {
        repository.save(first);
        repository.save(second);
        repository.save(third);
        repository.save(fourth);
    }

    @Test
    public void shouldRemoveByIdIfExist(){
        repository.removeById(2);
        Product[] expected = {first,third,fourth};
        assertArrayEquals(expected,repository.findAll());
    }

    @Test
    public void shouldNotRemoveByIdIfNotExist(){
        assertThrows(NotFoundException.class, () -> repository.removeById(5));
    }
}
