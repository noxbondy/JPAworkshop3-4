package se.lexicon.jpaworkshop34.repository;

import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;
import se.lexicon.jpaworkshop34.entity.Author;

import java.util.List;
@Repository
public interface AuthorRepository extends CrudRepository<Author, Integer> {

    List<Author> findByFirstName(String firstName);

    List<Author> findByLastName(String lastName);

    List<Author> findByFirstNameContainingIgnoreCaseOrLastNameContainingIgnoreCase(String keyword1, String keyword2);


   @Modifying
    @Query("UPDATE Author a set a.firstName= :firstName,a.lastName=:lastname where a.authorId=:id")
    int UpdateAuthorById(int id, String firstName, String lastName);

    void deleteAuthorByAuthorId(int authorId);



}

