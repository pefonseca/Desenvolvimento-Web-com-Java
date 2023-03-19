package br.edu.infnet.appcar.controller;

import br.edu.infnet.appcar.model.domain.Pedido;
import br.edu.infnet.appcar.model.domain.Usuario;
import br.edu.infnet.appcar.service.PedidoService;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.SessionAttribute;

@Controller
public class PedidoController {

    private final PedidoService pedidoService;

    private String msg;

    public PedidoController(PedidoService pedidoService) {
        this.pedidoService = pedidoService;
    }

    @GetMapping(value = "/pedido")
    public String telaCadastro() {
        return "pedido/cadastro";
    }

    @GetMapping(value = "/pedido/lista")
    public String telaLista(Model model, @SessionAttribute("usuario") Usuario usuario) {

        model.addAttribute("pedidos", pedidoService.obterLista(usuario));

        model.addAttribute("mensagem", msg);

        msg = null;

        return "pedido/lista";
    }

    @PostMapping(value = "/pedido/incluir")
    public String incluir(Pedido pedido, @SessionAttribute("usuario") Usuario usuario) {

        pedido.setUsuario(usuario);

        pedidoService.incluir(pedido);

        msg = "A inclusão do pedido "+pedido.getDescricao()+" foi realizada com sucesso!!!";

        return "redirect:/pedido/lista";
    }

    @GetMapping(value = "/pedido/{id}/excluir")
    public String excluir(@PathVariable Integer id) {

        Pedido pedido = pedidoService.obterPorId(id);

        pedidoService.excluir(id);

        msg = "A exclusão do pedido "+pedido.getDescricao()+" foi realizada com sucesso!!!";

        return "redirect:/pedido/lista";
    }
}
