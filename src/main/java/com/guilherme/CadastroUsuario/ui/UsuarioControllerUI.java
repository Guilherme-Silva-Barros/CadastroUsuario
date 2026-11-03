package com.guilherme.CadastroUsuario.ui;

import com.guilherme.CadastroUsuario.model.Usuario;
import com.guilherme.CadastroUsuario.model.UsuarioDTO;
import com.guilherme.CadastroUsuario.model.UsuarioMapper;
import com.guilherme.CadastroUsuario.service.UsuarioService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

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

    @GetMapping("delete/{id}")
    public String delete(@PathVariable Long id){
        usuarioService.deleteById(id);
        return "redirect:/cadastro/ui/listar";
    }

    @GetMapping("/listar/{id}")
    public String getById(@PathVariable Long id, Model  model){
         UsuarioDTO usuario = usuarioService.buscaPorId(id);
         if(usuario != null){
             model.addAttribute("usuario", usuario);
             return "detalhesUsuario";
         }else{
             model.addAttribute("mensagem", "Usuário não encontrado");
             return "listarUsuarios";
         }
    }
    @GetMapping("/adicionar")
    public String mostrarFormularioAddUser(Model model){
        model.addAttribute("usuario", new UsuarioDTO());
        return "adicionarUsuario.html";
    }
    @PostMapping("/salvar")
    public String salvarUsuario(@ModelAttribute UsuarioDTO usuario, RedirectAttributes attributes){
        usuarioService.save(usuario);
        attributes.addFlashAttribute("mensagem", "Usuario salvo com sucesso");
        return "redirect:/cadastro/ui/listar";
    }
}
