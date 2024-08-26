package org.example.category;

import jakarta.persistence.*;
import lombok.*;
import org.example.book.BookEntity;

import java.util.List;
import java.util.UUID;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Entity
@Table(name = "category")
@ToString(exclude = {"authors", "book"})
public class CategoryEntity {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private UUID id;

    private String categoryType;

    @OneToMany(mappedBy = "category")
    private List<BookEntity> booksForCategory;
}
