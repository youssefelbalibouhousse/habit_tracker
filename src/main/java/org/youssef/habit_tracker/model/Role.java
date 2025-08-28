package org.youssef.habit_tracker.model;


import jakarta.persistence.*;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@Entity
@Table(name = "roles")
public class Role {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;

    @Enumerated(EnumType.STRING)
    @Column(length = 20, unique = true, nullable = false)
    private ERole name; // Nom du rôle

    // Constructeur pour les enum
    public Role(ERole name) {
        this.name = name;
    }

    // Enumération des rôles disponibles
    public enum ERole {
        ROLE_USER,  // Par défaut pour tous les utilisateurs
        ROLE_ADMIN, // Accès complet
        ROLE_PREMIUM // Exemple de rôle customisé
    }
}