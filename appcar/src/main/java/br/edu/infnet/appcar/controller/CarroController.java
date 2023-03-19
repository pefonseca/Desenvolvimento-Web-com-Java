package br.edu.infnet.appcar.controller;

import br.edu.infnet.appcar.model.domain.Carro;
import br.edu.infnet.appcar.model.domain.Usuario;
import br.edu.infnet.appcar.repository.CarroRepository;
import br.edu.infnet.appcar.service.CarroService;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.SessionAttribute;

@Controller
public class CarroController {

    private String msg;

    private final CarroService service;

    public CarroController(CarroService service) {
        this.service = service;
    }

    @GetMapping(value = "/carro")
    public String telaCadastro() {
        return "carro/cadastro";
    }

    @GetMapping(value = "/carro/lista")
    public String telaLista(Model model) {
        model.addAttribute("carros", service.obterLista());

        model.addAttribute("mensagem", msg);

        msg = null;

        return "carro/lista";
    }

    @PostMapping(value = "/carro/incluir")
    public String incluir(Carro carro, @SessionAttribute("usuario") Usuario usuario) {
        carro.setUsuario(usuario);

        service.incluir(carro);

        msg = "A inclusão do carro "+ carro.getNome() +" foi realizada com sucesso!!!";

        return "redirect:/carro/lista";
    }

    @GetMapping(value = "/carro/{id}/excluir")
    public String excluir(@PathVariable Integer id) {

        service.excluir(id);

        msg = "A exclusão do carro id: " + id + " foi realizada com sucesso!!";

        return "redirect:/carro/lista";
    }

}
