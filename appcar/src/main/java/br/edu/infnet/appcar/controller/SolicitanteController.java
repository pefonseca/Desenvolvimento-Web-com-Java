package br.edu.infnet.appcar.controller;

import br.edu.infnet.appcar.client.Endereco;
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
    public String incluir(Solicitante solicitante, Endereco endereco, @SessionAttribute("usuario") Usuario usuario) {

        solicitante.setUsuario(usuario);
        solicitante.setEndereco(endereco);

        service.incluir(solicitante);

        msg = "A inclusão do solicitante " + solicitante.getNome() + " foi realizada com sucesso!!!";

        return "redirect:/solicitante/lista";
    }

    @GetMapping(value = "/solicitante/{id}/excluir")
    public String excluir(@PathVariable Integer id) {
        try {
            service.excluir(id);

            msg = "A exclusão do solicitante id: " + id + " foi realizada com sucesso!!";
        } catch (Exception e) {
            msg = "Impossível realizar a exclusão do solicitante id: " + id + "!!!";
        }

        return "redirect:/solicitante/lista";
    }
}
