package br.edu.infnet.appcar.service;

import br.edu.infnet.appcar.model.domain.Pedido;
import br.edu.infnet.appcar.model.domain.Usuario;
import br.edu.infnet.appcar.repository.PedidoRepository;
import org.springframework.stereotype.Service;

import java.util.Collection;

@Service
public class PedidoService {

    private final PedidoRepository pedidoRepository;


    public PedidoService(PedidoRepository pedidoRepository) {
        this.pedidoRepository = pedidoRepository;
    }

    public Pedido incluir(Pedido pedido) {
        return pedidoRepository.save(pedido);
    }

    public void excluir(Integer id) {
        pedidoRepository.deleteById(id);
    }

    public Collection<Pedido> obterLista(){
        return pedidoRepository.findAll();
    }

    public Collection<Pedido> obterLista(Usuario usuario){
        return pedidoRepository.obterLista(usuario.getId());
    }

    public Pedido obterPorId(Integer id) {
        return pedidoRepository.findById(id).orElse(null);
    }
}
