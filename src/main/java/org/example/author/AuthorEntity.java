package org.example.author;


import jakarta.persistence.*;
import lombok.*;
import org.example.book.BookEntity;

import java.time.LocalDate;
import java.util.List;
import java.util.UUID;

@Getter
@Setter
@NoArgsConstructor
@ToString(exclude = {"book", "user","orders","category","author_book"})
@Entity
@Table(name = "author")
public class AuthorEntity {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private int id;

    private String name;

    private String surname;

    @Enumerated(EnumType.STRING)
    private AuthorNationality nationality;

    private LocalDate birthday;

    @ManyToMany(cascade = CascadeType.ALL, fetch = FetchType.EAGER)
    @JoinTable(
            name = "author_book",
            joinColumns = @JoinColumn(name = "author_id"),
            inverseJoinColumns = @JoinColumn(name = "book_id")
    )
    private List<BookEntity> listOfBookXAuthor;

    public AuthorEntity(String name, String surname, AuthorNationality nationality, LocalDate birthday, List<BookEntity> listOfBookXAuthor) {
        this.name = name;
        this.surname = surname;
        this.nationality = nationality;
        this.birthday = birthday;
        this.listOfBookXAuthor = listOfBookXAuthor;
    }
}
