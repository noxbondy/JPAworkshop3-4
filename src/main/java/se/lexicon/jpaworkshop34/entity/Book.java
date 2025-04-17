package se.lexicon.jpaworkshop34.entity;

import jakarta.persistence.*;
import lombok.*;

import java.util.HashSet;
import java.util.Set;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor

@Entity
public class Book {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;
    private String isbn;
    private String title;
    private int maxLoanDays;


    @ManyToMany
    @JoinTable(
            name="book_author",
            joinColumns = @JoinColumn(name = "book_id"),
            inverseJoinColumns = @JoinColumn(name="author_id")
    )
    private Set<Author> authors= new HashSet<Author>();

    @OneToMany(mappedBy = "book", cascade = {CascadeType.PERSIST, CascadeType.REMOVE,
            CascadeType.MERGE}, fetch = FetchType.EAGER)
    private Set<BookLoan>bookLoans;

    public void addAuthor(Author author) {
        authors.add(author);
    }
    public void removeAuthor(Author author) {
        authors.remove(author);
    }
}


