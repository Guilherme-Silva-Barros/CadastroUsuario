package com.guilherme.CadastroUsuario.service;

import com.guilherme.CadastroUsuario.model.Usuario;
import com.guilherme.CadastroUsuario.repository.UsuarioRepository;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class UsuarioService {
    private UsuarioRepository usuarioRepository;

    public UsuarioService(UsuarioRepository usuarioRepository) {
        this.usuarioRepository = usuarioRepository;
    }

    public List<Usuario> getAll(){
        return usuarioRepository.findAll();
    }

    public Usuario save(Usuario usuario){
        return usuarioRepository.save(usuario);
    }

    public Usuario update(Long id, Usuario novoUsuario){
        Usuario usuario =  usuarioRepository.findById(id).orElseThrow(()
                ->new RuntimeException("Usuário não encontrado"));
        usuario.setNome(novoUsuario.getNome());
        usuario.setEmail(novoUsuario.getEmail());
        usuario.setFone(novoUsuario.getFone());

        return usuarioRepository.save(usuario);
    }
    public void deleteById(Long id){
        usuarioRepository.deleteById(id);
    }
}
