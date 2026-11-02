package com.guilherme.CadastroUsuario.controller;

import com.guilherme.CadastroUsuario.model.Usuario;
import com.guilherme.CadastroUsuario.model.UsuarioDTO;
import com.guilherme.CadastroUsuario.service.UsuarioService;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/cadastro")
public class UsuarioController {

    public final UsuarioService usuarioService;
    public UsuarioController(UsuarioService usuarioService) {
        this.usuarioService = usuarioService;
    }

    @GetMapping("/listar")
    public ResponseEntity<List<UsuarioDTO>> getAll(){
        List<UsuarioDTO>usuarios = usuarioService.getAll();
        return ResponseEntity.ok().body(usuarios);
    }

    @PostMapping
    public ResponseEntity<String> save(@RequestBody UsuarioDTO usuario){
        UsuarioDTO usuarioDTO =  usuarioService.save(usuario);
        return ResponseEntity.status(HttpStatus.CREATED)
                .body("Usuario:"+usuarioDTO.getNome()+", foi adicionado com sucesso"+"ID:"+usuarioDTO.getId());
    }

    @PutMapping("/{id}")
    public ResponseEntity<?>update(@PathVariable Long id, @RequestBody UsuarioDTO usuario){
    UsuarioDTO usuarioUpdate = usuarioService.update(id, usuario);
    if(usuarioUpdate!=null){
        return ResponseEntity.ok(usuarioUpdate);
    }else{
        return ResponseEntity.status(HttpStatus.NOT_FOUND).body("Usuário não encontrado");
    }
    }

    @GetMapping("/{id}")
    public UsuarioDTO getById(@PathVariable Long id){
        return usuarioService.buscaPorId(id);
    }

    @DeleteMapping("delete/{id}")
    public ResponseEntity<String> delete(@PathVariable Long id){
        usuarioService.deleteById(id);
        return ResponseEntity.ok("Usuário deletado com sucesso");

    }

}

