package se.lexicon.jpaworkshop34.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import se.lexicon.jpaworkshop34.entity.Author;
import se.lexicon.jpaworkshop34.entity.Book;

import java.util.List;
@Repository
public interface BookRepository extends JpaRepository<Book, Integer> {
    Book findByIsbnIgnoreCase(String isbn);
    List<Book> findByTitleContains(String keyword);
    List<Book> findByMaxLoanDaysLessThan(int maxLoanDays);



}
