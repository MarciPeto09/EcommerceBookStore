package org.example.order;

import jakarta.persistence.*;
import lombok.*;
import org.example.book.BookEntity;
import org.example.user.UserEntity;

import java.awt.print.Book;
import java.time.LocalDate;
import java.util.List;
import java.util.UUID;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
//@ToString(exclude = {"book", "user","author","category","author_book"})
@ToString
@Entity
@Table(name = "orders")
public class OrderEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private int id;

    private LocalDate data;

    private String adress;

    private String status;



    @ToString.Exclude
    @ManyToOne( fetch = FetchType.EAGER, cascade = CascadeType.PERSIST)
    @JoinColumn(name = "user_id")
    private UserEntity user;



    @ToString.Exclude
    @OneToMany(mappedBy = "order")
    private List<BookEntity> books;


}
