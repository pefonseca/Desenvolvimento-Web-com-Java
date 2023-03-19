package br.edu.infnet.appcar.repository;

import br.edu.infnet.appcar.model.domain.Solicitante;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface SolicitanteRepository extends JpaRepository<Solicitante, Integer> {

    @Query("from Solicitante s where s.usuario.id = :userId")
    List<Solicitante> obterLista(Integer userId);
}
