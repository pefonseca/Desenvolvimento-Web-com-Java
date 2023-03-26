package br.edu.infnet.appcar.controller;

import br.edu.infnet.appcar.model.domain.Usuario;
import br.edu.infnet.appcar.model.domain.Veiculo;
import br.edu.infnet.appcar.service.VeiculoService;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.SessionAttribute;

import java.util.Optional;

@Controller
public class VeiculoController {
    private String msg;

    private final VeiculoService veiculoService;

    public VeiculoController(VeiculoService veiculoService) {
        this.veiculoService = veiculoService;
    }

    @GetMapping(value = "/veiculo")
    public String telaCadastro() {
        return "veiculo/cadastro";
    }

    @GetMapping(value = "/veiculo/lista")
    public String telaLista(Model model) {
        model.addAttribute("veiculos", veiculoService.obterLista());

        model.addAttribute("mensagem", msg);

        msg = null;

        return "veiculo/lista";
    }

    @PostMapping(value = "/veiculo/incluir")
    public String incluir(Veiculo veiculo, @SessionAttribute("usuario") Usuario usuario) {

        veiculo.setUsuario(usuario);

        veiculoService.incluir(veiculo);

        msg = "A inclusão do veiculo "+ veiculo.getNome() +" foi realizada com sucesso!!!";

        return "redirect:/veiculo/lista";
    }

    @GetMapping(value = "/veiculo/{id}/excluir")
    public String excluir(@PathVariable Integer id) {
        try {
            veiculoService.excluir(id);

            msg = "A exclusão do veiculo id: " + id + " foi realizada com sucesso!!";
        } catch (Exception e) {
            msg = "Impossível realizar a exclusão do veiculo " + id + "!!!";
        }

        return "redirect:/veiculo/lista";
    }
}
