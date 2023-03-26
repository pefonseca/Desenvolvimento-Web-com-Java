package br.edu.infnet.appcar.repository;

import br.edu.infnet.appcar.model.domain.Moto;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;
import org.springframework.data.domain.Sort;

import java.util.List;

@Repository
public interface MotoRepository extends JpaRepository<Moto, Integer> {

    @Query("from Moto v where v.usuario.id = :id")
    List<Moto> obterLista(Integer id, Sort sort);
}
