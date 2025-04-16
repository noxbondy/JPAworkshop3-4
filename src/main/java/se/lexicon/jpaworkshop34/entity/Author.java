package se.lexicon.jpaworkshop34.entity;

import jakarta.persistence.*;
import lombok.*;

import java.util.Set;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@EqualsAndHashCode
@ToString
@Entity
public class Author {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private int authorId;
    @Column(unique = true, nullable = false, length = 100)
    private String firstName;
    @Column(unique = true, nullable = false, length = 100)
    private String lastName;

    @ManyToMany(mappedBy = "author")
    private Set<Book> WrittenBooks;

    // Contructor


    public Author(String firstName, String lastName) {
        this.firstName = firstName;
        this.lastName = lastName;
    }
}