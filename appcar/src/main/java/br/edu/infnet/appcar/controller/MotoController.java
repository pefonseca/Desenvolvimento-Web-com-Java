package br.edu.infnet.appcar.controller;

import br.edu.infnet.appcar.model.domain.Moto;
import br.edu.infnet.appcar.model.domain.Usuario;
import br.edu.infnet.appcar.repository.MotoRepository;
import br.edu.infnet.appcar.service.MotoService;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.SessionAttribute;

@Controller
public class MotoController {

    private String msg;

    private final MotoService service;

    public MotoController(MotoService service) {
        this.service = service;
    }

    @GetMapping(value = "/moto")
    public String telaCadastro() {
        return "moto/cadastro";
    }

    @GetMapping(value = "/moto/lista")
    public String telaLista(Model model) {
        model.addAttribute("motos", service.obterLista());

        model.addAttribute("mensagem", msg);

        msg = null;

        return "moto/lista";
    }

    @PostMapping(value = "/moto/incluir")
    public String incluir(Moto moto, @SessionAttribute("usuario") Usuario usuario) {
        moto.setUsuario(usuario);

        service.incluir(moto);

        msg = "A inclusão da moto "+ moto.getNome() +" foi realizada com sucesso!!!";

        return "redirect:/moto/lista";
    }

    @GetMapping(value = "/moto/{id}/excluir")
    public String excluir(@PathVariable Integer id) {

        service.excluir(id);

        msg = "A exclusão da moto id: " + id + " foi realizada com sucesso!!";

        return "redirect:/moto/lista";
    }

}
