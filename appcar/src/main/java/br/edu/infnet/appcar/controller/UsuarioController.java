package br.edu.infnet.appcar.controller;

import br.edu.infnet.appcar.model.domain.Usuario;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;

@Controller
public class UsuarioController {

    @GetMapping(value = "/usuario")
    public String telaCadastro() {
        return "usuario/cadastro";
    }

    @PostMapping(value = "/usuario/incluir")
    public String incluir(Usuario usuario) {
        System.out.println("Inclusão realizada com sucesso: " + usuario);

        return "redirect:/";
    }
}
