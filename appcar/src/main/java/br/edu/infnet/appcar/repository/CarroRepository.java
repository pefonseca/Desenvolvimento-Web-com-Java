package br.edu.infnet.appcar.repository;

import br.edu.infnet.appcar.model.domain.Carro;
import org.springframework.data.domain.Sort;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface CarroRepository extends JpaRepository<Carro, Integer> {

    @Query("from Carro v where v.usuario.id = :id")
    List<Carro> obterLista(Integer id, Sort sort);
}
