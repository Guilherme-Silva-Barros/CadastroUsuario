package com.guilherme.CadastroUsuario.controller;

import com.guilherme.CadastroUsuario.model.Usuario;
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
    public List<Usuario> getAll(){
        return usuarioService.getAll();
    }
    @PostMapping
    public Usuario save(@RequestBody Usuario usuario){
        return usuarioService.save(usuario);
    }
    @PutMapping("/{id}")
    public ResponseEntity<Usuario>update(@PathVariable Long id, @RequestBody Usuario usuario){
    Usuario usuarioUpdate = usuarioService.update(id, usuario);
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
