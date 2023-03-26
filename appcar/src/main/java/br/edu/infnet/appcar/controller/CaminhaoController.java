package br.edu.infnet.appcar.controller;

import br.edu.infnet.appcar.model.domain.Caminhao;
import br.edu.infnet.appcar.model.domain.Usuario;
import br.edu.infnet.appcar.service.CaminhaoService;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.SessionAttribute;

@Controller
public class CaminhaoController {

    private String msg;

    private final CaminhaoService service;

    public CaminhaoController(CaminhaoService service) {
        this.service = service;
    }

    @GetMapping(value = "/caminhao")
    public String telaCadastro() {
        return "caminhao/cadastro";
    }

    @GetMapping(value = "/caminhao/lista")
    public String telaLista(Model model) {
        model.addAttribute("caminhoes", service.obterLista());

        model.addAttribute("mensagem", msg);

        msg = null;

        return "caminhao/lista";
    }

    @PostMapping(value = "/caminhao/incluir")
    public String incluir(Caminhao caminhao, @SessionAttribute("usuario") Usuario usuario) {
        caminhao.setUsuario(usuario);

        service.incluir(caminhao);

        msg = "A inclusão do caminhão "+ caminhao.getNome() +" foi realizada com sucesso!!!";

        return "redirect:/caminhao/lista";
    }

    @GetMapping(value = "/caminhao/{id}/excluir")
    public String excluir(@PathVariable Integer id) {

        try {
            service.excluir(id);

            msg = "A exclusão do caminhão id: " + id + " foi realizada com sucesso!!";
        } catch (Exception e) {
            msg = "Impossível realizar a exclusão do caminhão id: " + id + "!!!";
        }

        return "redirect:/caminhao/lista";
    }
}
