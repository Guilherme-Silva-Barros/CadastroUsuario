package com.guilherme.CadastroUsuario.model;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor

public class UsuarioDTO {

    private Long id ;

    private String nome;

    private String email;

    private String fone;

    private String fone2;

    private String endereco;
}
