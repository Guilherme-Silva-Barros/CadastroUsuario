package com.guilherme.CadastroUsuario.model;

import org.springframework.stereotype.Component;

@Component
public class UsuarioMapper {
    public Usuario map(UsuarioDTO usuarioDTO) {
        Usuario usuario = new Usuario();
        usuario.setId(usuarioDTO.getId());
        usuario.setNome(usuarioDTO.getNome());
        usuario.setEmail(usuarioDTO.getEmail());
        usuario.setFone(usuarioDTO.getFone());
        usuario.setFone2(usuarioDTO.getFone2());
        usuario.setEndereco(usuarioDTO.getEndereco());

        return usuario;
    }

    public UsuarioDTO map(Usuario usuario) {
        UsuarioDTO usuarioDTO = new UsuarioDTO();
        usuarioDTO.setId(usuario.getId());
        usuarioDTO.setNome(usuario.getNome());
        usuarioDTO.setEmail(usuario.getEmail());
        usuarioDTO.setFone(usuario.getFone());
        usuarioDTO.setFone2(usuario.getFone2());
        usuarioDTO.setEndereco(usuario.getEndereco());
        return usuarioDTO;
    }
}
