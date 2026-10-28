package com.guilherme.CadastroUsuario.model;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Entity
@Table(name ="usuario_table")
@Data
@AllArgsConstructor
@NoArgsConstructor
public class Usuario {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "Id")
    private Long id ;
    @Column(name ="nome")
    private String nome;
    @Column(name = "email")
    private String email;
    @Column(name="fone")
    private String fone;
    @Column(name="fone2")
    private String fone2;
}
