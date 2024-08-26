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
@ToString(exclude = {"authors", "category"})
public class BookEntity {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private UUID id;

    private String title;

    private double price;

    @ManyToMany(mappedBy = "listOfBookXAuthor",cascade = CascadeType.ALL, fetch = FetchType.EAGER )
    private List<AuthorEntity> listOfAuthorsXBook;

    @ManyToOne(cascade = CascadeType.ALL, fetch = FetchType.EAGER )
    @JoinColumn(name = "category_id")
    private CategoryEntity category;


    @ManyToOne(cascade = CascadeType.ALL, fetch = FetchType.EAGER )
    @JoinColumn(name = "book")
    private OrderEntity order;

}
