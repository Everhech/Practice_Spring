package com.Lab_seguridad.seguridad.user_module.user_core.entities;

import jakarta.persistence.*;
import lombok.Data;

@Data
@Entity
@Table(name = "usuario")
public class User {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;

    @Column(name = "nombre")
    private String name;

    @Column(name = "apellido")
    private String lastname;

    @Column(name = "usuario")
    private String username;

    @Column(name = "clave")
    private String password;
}
