package com.guilherme.CadastroUsuario.controller;

import com.guilherme.CadastroUsuario.model.Usuario;
import com.guilherme.CadastroUsuario.model.UsuarioDTO;
import com.guilherme.CadastroUsuario.service.UsuarioService;
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

    @GetMapping
    public List<UsuarioDTO> getAll(){
        return usuarioService.getAll();
    }

    @PostMapping
    public UsuarioDTO save(@RequestBody UsuarioDTO usuario){

        return usuarioService.save(usuario);
    }

    @PutMapping("/{id}")
    public ResponseEntity<UsuarioDTO>update(@PathVariable Long id, @RequestBody UsuarioDTO usuario){
    UsuarioDTO usuarioUpdate = usuarioService.update(id, usuario);
    return ResponseEntity.ok(usuarioUpdate);
    }

    @GetMapping("/{id}")
    public Usuario getById(@PathVariable Long id){
        return usuarioService.buscaPorId(id);
    }
    @DeleteMapping("/{id}")
    public void delete(@PathVariable Long id){
         usuarioService.deleteById(id);
    }


}
