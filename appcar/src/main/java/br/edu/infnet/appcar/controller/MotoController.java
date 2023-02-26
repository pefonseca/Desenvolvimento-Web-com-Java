package br.edu.infnet.appcar.controller;

import br.edu.infnet.appcar.model.domain.Moto;
import br.edu.infnet.appcar.repository.MotoRepository;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;

@Controller
public class MotoController {

    private String msg;

    @GetMapping(value = "/moto")
    public String telaCadastro() {
        return "moto/cadastro";
    }

    @GetMapping(value = "/moto/lista")
    public String telaLista(Model model) {
        model.addAttribute("motos", MotoRepository.obterLista());

        model.addAttribute("mensagem", msg);

        msg = null;

        return "moto/lista";
    }

    @PostMapping(value = "/moto/incluir")
    public String incluir(Moto moto) {
        MotoRepository.incluir(moto);

        msg = "A inclusão da moto "+ moto.getNome() +" foi realizada com sucesso!!!";

        return "redirect:/moto/lista";
    }

    @GetMapping(value = "/moto/{id}/excluir")
    public String excluir(@PathVariable Integer id) {

        Moto moto = MotoRepository.excluir(id);

        msg = "A exclusão da moto " + moto.getNome() + " foi realizada com sucesso!!";

        return "redirect:/moto/lista";
    }

}
