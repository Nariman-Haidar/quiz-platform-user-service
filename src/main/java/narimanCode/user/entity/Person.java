package narimanCode.user.entity;

import jakarta.persistence.*;
import lombok.*;

@Entity
@Table(name = "persons")
@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class Person {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(name = "first_name", nullable = false)
    private String firstName;

    @Column(name = "last_name", nullable = false)
    private String lastName;

    @Column(unique = true, nullable = false)
    private String username;

    @Column(unique = true, nullable = false)
    private String email;

    @Column(nullable = false)
    private String password;

    @Column(name = "phone_number")
    private String phoneNumber;

    @Column(name = "account_locked", nullable = false)
    private boolean accountLocked = false;

    @ManyToOne
    @JoinColumn(name = "role_id", nullable = false)
    private Role role;

    @Version
    private Long version;
}