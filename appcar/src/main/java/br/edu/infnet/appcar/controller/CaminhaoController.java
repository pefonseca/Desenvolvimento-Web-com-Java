package br.edu.infnet.appcar.controller;

import br.edu.infnet.appcar.model.domain.Caminhao;
import br.edu.infnet.appcar.model.domain.Usuario;
import br.edu.infnet.appcar.repository.CaminhaoRepository;
import br.edu.infnet.appcar.repository.UsuarioRepository;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;

@Controller
public class CaminhaoController {

    private String msg;

    @GetMapping(value = "/caminhao")
    public String telaCadastro() {
        return "caminhao/cadastro";
    }

    @GetMapping(value = "/caminhao/lista")
    public String telaLista(Model model) {
        model.addAttribute("caminhoes", CaminhaoRepository.obterLista());

        model.addAttribute("mensagem", msg);

        msg = null;

        return "caminhao/lista";
    }

    @PostMapping(value = "/caminhao/incluir")
    public String incluir(Caminhao caminhao) {
        CaminhaoRepository.incluir(caminhao);

        msg = "A inclusão do caminhão "+ caminhao.getNome() +" foi realizada com sucesso!!!";

        return "redirect:/caminhao/lista";
    }

    @GetMapping(value = "/caminhao/{id}/excluir")
    public String excluir(@PathVariable Integer id) {

        Caminhao caminhao = CaminhaoRepository.excluir(id);

        msg = "A exclusão do caminhão " + caminhao.getNome() + " foi realizada com sucesso!!";

        return "redirect:/caminhao/lista";
    }
}
