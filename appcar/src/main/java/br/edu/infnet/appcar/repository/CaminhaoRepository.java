package br.edu.infnet.appcar.repository;

import br.edu.infnet.appcar.model.domain.Caminhao;
import br.edu.infnet.appcar.model.domain.Usuario;
import br.edu.infnet.appcar.model.domain.Veiculo;
import org.springframework.data.domain.Sort;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.util.Collection;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public interface CaminhaoRepository extends JpaRepository<Caminhao, Integer> {

    @Query("from Caminhao v where v.usuario.id = :id")
    List<Caminhao> obterLista(Integer id, Sort sort);

}
