package br.edu.infnet.appcar.controller;

import br.edu.infnet.appcar.model.domain.Solicitante;
import br.edu.infnet.appcar.model.domain.Usuario;
import br.edu.infnet.appcar.service.SolicitanteService;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

@Controller
public class SolicitanteController {

    private String msg;
    private final SolicitanteService service;

    public SolicitanteController(SolicitanteService solicitanteService) {
        this.service = solicitanteService;
    }

    @GetMapping(value = "/solicitante")
    public String telaCadastro() {
        return "solicitante/cadastro";
    }

    @GetMapping(value = "/solicitante/lista")
    public String telaLista(Model model, @SessionAttribute("usuario") Usuario usuario) {

        model.addAttribute("solicitantes", service.obterLista(usuario));
        model.addAttribute("mensagem", msg);

        msg = null;

        return "solicitante/lista";
    }

    @PostMapping(value = "/solicitante/incluir")
    public String incluir(Solicitante solicitante, @SessionAttribute("usuario") Usuario usuario) {

        solicitante.setUsuario(usuario);

        service.incluir(solicitante);

        msg = "A inclusão do solicitante " + solicitante.getNome() + " foi realizada com sucesso!!!";

        return "redirect:/solicitante/lista";
    }

    @GetMapping(value = "/solicitante/{id}/excluir")
    public String excluir(@PathVariable Integer id) {
        service.excluir(id);

        msg = "A exclusão do solicitante " + id + " foi realizada com sucesso!!!";

        return "redirect:/solicitante/lista";
    }
}
