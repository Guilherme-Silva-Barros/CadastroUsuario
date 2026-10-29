package com.guilherme.CadastroUsuario.service;

import com.guilherme.CadastroUsuario.model.Usuario;
import com.guilherme.CadastroUsuario.model.UsuarioDTO;
import com.guilherme.CadastroUsuario.model.UsuarioMapper;
import com.guilherme.CadastroUsuario.repository.UsuarioRepository;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class UsuarioService {
    private UsuarioRepository usuarioRepository;
    private UsuarioMapper usuarioMapper;
    public  UsuarioService(UsuarioRepository usuarioRepository, UsuarioMapper usuarioMapper) {
        this.usuarioRepository = usuarioRepository;
        this.usuarioMapper = usuarioMapper;
    }

    public List<Usuario> getAll(){
        return usuarioRepository.findAll();
    }

    public UsuarioDTO save(UsuarioDTO usuarioDto){
        Usuario usuario = usuarioMapper.map(usuarioDto);
        usuario = usuarioRepository.save(usuario);
        return  usuarioMapper.map(usuario);
    }

    public Usuario update(Long id, Usuario novoUsuario){
        Usuario usuario =  usuarioRepository.findById(id).orElseThrow(()
                ->new RuntimeException("Usuário não encontrado"));
        usuario.setNome(novoUsuario.getNome());
        usuario.setEmail(novoUsuario.getEmail());
        usuario.setFone(novoUsuario.getFone());
        usuario.setFone2(novoUsuario.getFone2());

        return usuarioRepository.save(usuario);
    }
    public Usuario buscaPorId(Long id){
            return usuarioRepository.findById(id)
                    .orElseThrow(()->new RuntimeException("Usuário não encontrado"));
    }

    public void deleteById(Long id){
        usuarioRepository.deleteById(id);
    }
}
