package br.edu.infnet.appcar.controller;

import br.edu.infnet.appcar.client.Endereco;
import br.edu.infnet.appcar.model.domain.Usuario;
import br.edu.infnet.appcar.service.UsuarioService;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;

@Controller
public class UsuarioController {

    private String msg;

    private final UsuarioService usuarioService;

    public UsuarioController(UsuarioService usuarioService) {
        this.usuarioService = usuarioService;
    }

    @GetMapping(value = "/usuario")
    public String telaCadastro() {
        return "usuario/cadastro";
    }

    @GetMapping(value = "/usuario/lista")
    public String telaLista(Model model) {
        model.addAttribute("usuarios", usuarioService.obterLista());

        model.addAttribute("mensagem", msg);

        msg = null;

        return "usuario/lista";
    }

    @PostMapping(value = "/usuario/incluir")
    public String incluir(Usuario usuario) {
        usuarioService.incluir(usuario);

        msg = "A inclusão do usuário "+ usuario.getNome() +" foi realizada com sucesso!!!";

        return "redirect:/usuario/lista";
    }

    @GetMapping(value = "/usuario/{id}/excluir")
    public String excluir(@PathVariable Integer id) {

        usuarioService.excluir(id);

        msg = "A exclusão do usuário id: " + id + " foi realizada com sucesso!!";

        return "redirect:/usuario/lista";
    }
}
