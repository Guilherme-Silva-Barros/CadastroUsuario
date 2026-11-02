package com.guilherme.CadastroUsuario.service;

import com.guilherme.CadastroUsuario.model.Usuario;
import com.guilherme.CadastroUsuario.model.UsuarioDTO;
import com.guilherme.CadastroUsuario.model.UsuarioMapper;
import com.guilherme.CadastroUsuario.repository.UsuarioRepository;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;
import org.springframework.web.server.ResponseStatusException;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

@Service
public class UsuarioService {
    private final UsuarioRepository usuarioRepository;
    private final UsuarioMapper usuarioMapper;
    public  UsuarioService(UsuarioRepository usuarioRepository, UsuarioMapper usuarioMapper) {
        this.usuarioRepository = usuarioRepository;
        this.usuarioMapper = usuarioMapper;
    }

    public List<UsuarioDTO> getAll(){
        List<Usuario>usuario =  usuarioRepository.findAll();
        return usuario.stream()
                .map(usuarioMapper::map)
                .collect(Collectors.toList());
    }

    public UsuarioDTO save(UsuarioDTO usuarioDto){
        if (usuarioRepository.existsByEmail(usuarioDto.getEmail())) {
            throw new RuntimeException("Email já cadastrado");
        }
        Usuario usuario = usuarioMapper.map(usuarioDto);
        usuario = usuarioRepository.save(usuario);
        return  usuarioMapper.map(usuario);
    }

    public UsuarioDTO update(Long id, UsuarioDTO novoUsuario){
        Optional<Usuario> usuario = usuarioRepository.findById(id);
        if(usuario.isPresent()){
            Usuario novoUsusario = usuarioMapper.map(novoUsuario);
            novoUsusario.setId(id);
            Usuario usuarioUpdate = usuarioRepository.save(novoUsusario);
            return usuarioMapper.map(usuarioUpdate);
        }
        return null;
    }
    public Usuario buscaPorId(Long id){
            return usuarioRepository.findById(id)
                    .orElseThrow(()->new ResponseStatusException(HttpStatus.NOT_FOUND, "Usuário não encontrado"));
    }

    public void deleteById(Long id){
        if(!usuarioRepository.existsById(id)){
            throw new ResponseStatusException(HttpStatus.NOT_FOUND,"Usuário não encontrado");
        }
        usuarioRepository.deleteById(id);
    }
}
