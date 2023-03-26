package br.edu.infnet.appcar.controller;

import br.edu.infnet.appcar.service.EnderecoService;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;

@Controller
public class EnderecoController {

    private final EnderecoService enderecoService;

    public EnderecoController(EnderecoService enderecoService) {
        this.enderecoService = enderecoService;
    }

    @PostMapping(value = "/cep")
    public String buscaCep(Model model, @RequestParam String cep) {

        model.addAttribute("endereco", enderecoService.buscaPorCep(cep));

        return "usuario/cadastro";
    }
}
