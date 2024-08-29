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
    private int id;

    private String categoryType;

    @OneToMany(mappedBy = "category")
    private List<BookEntity> booksForCategory;

    public CategoryEntity(String categoryType, List<BookEntity> booksForCategory) {
        this.categoryType = categoryType;
        this.booksForCategory = booksForCategory;
    }

    public CategoryEntity(String categoryType) {
        this.categoryType = categoryType;
    }

    public CategoryEntity(int id, String categoryType) {
        this.id = id;
        this.categoryType = categoryType;
    }
}
