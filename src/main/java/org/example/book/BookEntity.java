package org.example.book;

import jakarta.persistence.*;
import jakarta.persistence.criteria.Order;
import lombok.*;
import org.example.author.AuthorEntity;
import org.example.category.CategoryEntity;
import org.example.order.OrderEntity;

import java.util.List;
import java.util.UUID;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Entity
@Table(name = "book")
@ToString
public class BookEntity {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private int id;

    private String title;

    private double price;

    @ToString.Exclude
    @ManyToMany(mappedBy = "listOfBookXAuthor", cascade = CascadeType.ALL, fetch = FetchType.EAGER)
    private List<AuthorEntity> listOfAuthorsXBook;


    @ToString.Exclude
    @ManyToOne(cascade = CascadeType.PERSIST, fetch = FetchType.EAGER)
    @JoinColumn(name = "category_id")
    private CategoryEntity category;

    @ToString.Exclude
    @ManyToOne(fetch = FetchType.EAGER)
    @JoinColumn(name = "book")
    private OrderEntity order;


    public BookEntity(String title, double price, List<AuthorEntity> listOfAuthorsXBook, CategoryEntity category, OrderEntity order) {
        this.title = title;
        this.price = price;
        this.listOfAuthorsXBook = listOfAuthorsXBook;
        this.category = category;
        this.order = order;
    }


    @Override
    public String toString() {
        return title +
                "  id=" + id +
                ", price=" + price +
                '}';

    }
}
