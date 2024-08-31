package org.example.user;


import jakarta.persistence.*;
import lombok.*;
import org.example.order.OrderEntity;

import java.time.LocalDate;
import java.util.List;
import java.util.UUID;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@ToString(exclude = {"author", "order"})
@Entity
@Table(name = "user")
public class UserEntity {
    @Id
    @GeneratedValue
    private int id;

    private String name;

    private String surname;

    private String email;

    private String password;

    private LocalDate dateOfRegistration;


    @OneToMany(mappedBy = "user",fetch = FetchType.EAGER, cascade = CascadeType.PERSIST)
    private List<OrderEntity> orders;


    public UserEntity(String name, String surname, String email, String password, LocalDate dateOfRegistration, List<OrderEntity> orders) {
        this.name = name;
        this.surname = surname;
        this.email = email;
        this.password = password;
        this.dateOfRegistration = dateOfRegistration;
        this.orders = orders;
    }
}
