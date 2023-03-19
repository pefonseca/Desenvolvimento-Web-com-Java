package br.edu.infnet.appcar.repository;

import br.edu.infnet.appcar.model.domain.Pedido;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface PedidoRepository extends JpaRepository<Pedido, Integer> {

    @Query("from Pedido p where p.usuario.id = :userId")
    List<Pedido> obterLista(Integer userId);
}
