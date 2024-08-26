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
    private UUID id;

    private String name;

    private String surname;

    private String email;

    private String password;

    private LocalDate dateOfRegistration;


    @OneToMany(mappedBy = "user", cascade = CascadeType.ALL, fetch = FetchType.EAGER)
    private List<OrderEntity> orders;

}
