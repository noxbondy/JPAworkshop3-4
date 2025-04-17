package se.lexicon.jpaworkshop34.repository;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;
import se.lexicon.jpaworkshop34.entity.Book;

import java.time.LocalDate;
import java.util.List;

import static org.junit.jupiter.api.Assertions.*;
@DataJpaTest
class BookRepositoryTest {
    @Autowired
    private BookRepository bookRepository;

    @Test
    void findByIsbnIgnoreCase() {
        Book book = new Book();
        book.setIsbn("123");
        book.setTitle("Title");
        book.setMaxLoanDays(LocalDate.now().getDayOfMonth());
       bookRepository.save(book);
       book = bookRepository.findByIsbnIgnoreCase("123");
       assertNotNull(book);


    }


    @Test
    void findByTitleContains() {
    }

    @Test
    void findByMaxLoanDaysLessThan() {
    }
}