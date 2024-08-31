package org.example.author;


import jakarta.persistence.*;
import lombok.*;
import org.example.InterfaceRepository;
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
public class AuthorEntity  {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private int id;

    private String name;

    private String surname;

    @Enumerated(EnumType.STRING)
    private AuthorNationality nationality;

    private LocalDate birthday;

    @ManyToMany( fetch = FetchType.EAGER, cascade = CascadeType.PERSIST)
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


    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append(name + " " + surname)
                .append("    id: ").append(id).append(",\n")
                .append("    nationality: ").append(nationality).append(",\n")
                .append("    birthday: ").append(birthday).append(",\n")
                .append("    listOfBookXAuthor: [\n");

        if (listOfBookXAuthor != null) {
            for (BookEntity book : listOfBookXAuthor) {
                sb.append("        ").append(book.toString()).append(",\n");
            }
        }

        sb.append("    ]\n")
                .append("}");

        return sb.toString();
    }
}
