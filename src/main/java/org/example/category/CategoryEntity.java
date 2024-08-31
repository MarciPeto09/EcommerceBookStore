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

    @OneToMany(mappedBy = "category",fetch = FetchType.EAGER, cascade = CascadeType.PERSIST)
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


    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append(categoryType)
                .append("    id: ").append(id).append(",\n")
                .append("    books: [\n");

        if (booksForCategory != null) {
            for (BookEntity book : booksForCategory) {
                sb.append("        ").append(book.toString()).append(",\n");
            }
        }

        sb.append("    ]\n")
                .append("}");

        return sb.toString();
    }
}
