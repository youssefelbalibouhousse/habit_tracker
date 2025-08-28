package org.youssef.habit_tracker.model;

import jakarta.persistence.*;
import lombok.Data;

import java.util.HashSet;
import java.util.Set;

@Data // This is a Lombok annotation that generates getter and setter methods for the class
@Entity // This tells Hibernate to make a table out of this class
@Table(name = "users") // This is the name of the table
public class User {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(unique = true, nullable = false)
    private String username;

    @Column(nullable = false)
    private String password;

    private String email;
    // Ce champ est optionnel, ce qui signifie que l'utilisateur n'est pas obligé  de fournir son adresse e-mail
    // lors de l'inscription.
    @ManyToMany(fetch = FetchType.EAGER)
    @JoinTable(
            name = "user_roles",
            joinColumns = @JoinColumn(name = "user_id"),
            inverseJoinColumns = @JoinColumn(name = "role_id"),
            foreignKey = @ForeignKey(name = "FK_USER_ROLES_USER"),
            inverseForeignKey = @ForeignKey(name = "FK_USER_ROLES_ROLE")
    )
    private Set<Role> roles = new HashSet<>(); // Initialisation recommandée
}