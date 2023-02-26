package br.edu.infnet.appcar.controller;

import br.edu.infnet.appcar.model.domain.Carro;
import br.edu.infnet.appcar.repository.CarroRepository;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;

@Controller
public class CarroController {

    private String msg;

    @GetMapping(value = "/carro")
    public String telaCadastro() {
        return "carro/cadastro";
    }

    @GetMapping(value = "/carro/lista")
    public String telaLista(Model model) {
        model.addAttribute("carros", CarroRepository.obterLista());

        model.addAttribute("mensagem", msg);

        msg = null;

        return "carro/lista";
    }

    @PostMapping(value = "/carro/incluir")
    public String incluir(Carro carro) {
        CarroRepository.incluir(carro);

        msg = "A inclusão do carro "+ carro.getNome() +" foi realizada com sucesso!!!";

        return "redirect:/carro/lista";
    }

    @GetMapping(value = "/carro/{id}/excluir")
    public String excluir(@PathVariable Integer id) {

        Carro carro = CarroRepository.excluir(id);

        msg = "A exclusão do carro " + carro.getNome() + " foi realizada com sucesso!!";

        return "redirect:/carro/lista";
    }

}
