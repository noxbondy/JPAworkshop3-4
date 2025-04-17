package se.lexicon.jpaworkshop34.entity;

import jakarta.persistence.*;
import lombok.*;

import java.time.LocalDate;
import java.util.List;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@EqualsAndHashCode
@ToString
@Entity
public class AppUser {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;
    @Column(nullable = false, length = 100, unique = true)
    private String username;
    @Column(nullable = false, length = 100)
    private String password;
    private LocalDate regDate;

    @OneToOne
    @JoinColumn(name="details_id")
    private UserDetails details;


    @OneToMany(mappedBy = "borrower", cascade = {CascadeType.PERSIST,
            CascadeType.REMOVE, CascadeType.MERGE}, fetch = FetchType.EAGER)
    private List<BookLoan> bookLoans;

    // Constructor
    public AppUser(int id, String username, String password, UserDetails details) {
        this.id = id;
        this.username = username;
        this.password = password;
        this.details = details;
    }
public void addBookLoan(BookLoan bookLoan) {
        bookLoans.add(bookLoan);
}
public void removeBookLoan(BookLoan bookLoan) {
        bookLoans.remove(bookLoan);
}

}