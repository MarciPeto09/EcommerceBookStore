package org.example;



import org.example.author.AuthorEntity;
import org.example.book.BookEntity;
import org.example.category.CategoryEntity;
import org.example.order.OrderEntity;
import org.example.user.UserEntity;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

public class Main {
    public static void main(String[] args) {

        SessionFactory sessionFactory = new Configuration()
                .configure("Hibernate.cfg.xml")
                .addAnnotatedClass(AuthorEntity.class)
                .addAnnotatedClass(BookEntity.class)
                .addAnnotatedClass(CategoryEntity.class)
                .addAnnotatedClass(OrderEntity.class)
                .addAnnotatedClass(UserEntity.class)
                .buildSessionFactory();

    }
}