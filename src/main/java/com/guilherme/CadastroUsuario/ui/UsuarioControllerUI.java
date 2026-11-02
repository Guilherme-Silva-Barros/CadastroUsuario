package com.guilherme.CadastroUsuario.ui;

import com.guilherme.CadastroUsuario.model.UsuarioDTO;
import com.guilherme.CadastroUsuario.model.UsuarioMapper;
import com.guilherme.CadastroUsuario.service.UsuarioService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import java.util.List;

@Controller
@RequestMapping("/cadastro/ui")
public class UsuarioControllerUI {

    private final UsuarioService usuarioService;

    public UsuarioControllerUI(UsuarioService usuarioService) {
        this.usuarioService = usuarioService;
    }

    @GetMapping("/listar")
    public String getAll(Model model) {
        List<UsuarioDTO>usuarios = usuarioService.getAll();
        model.addAttribute("usuarios", usuarios);
        return "listarUsuarios";
    }
}
