package se.lexicon.jpaworkshop34.entity;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.time.LocalDate;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@Entity
public class BookLoan {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;
    private LocalDate loanDate;
    private LocalDate dueDate;
    private boolean returned;

    @ManyToOne
    @JoinColumn(name= "borrower_id")
    private  AppUser borrower;

    @ManyToOne
    @JoinColumn(name="book_id")
    private Book book;

    @PrePersist
    public void prePersist() {
        loanDate = LocalDate.now();
        dueDate = LocalDate.now().plusDays(1);
        borrower = null;
        book = null;
        this.returned = false;
    }
    public void TakeBookLoan(BookLoan bookLoan) {
        returned = true;
    }
    public void returnBook(Book book) {
        this.book = book;
    }
}
