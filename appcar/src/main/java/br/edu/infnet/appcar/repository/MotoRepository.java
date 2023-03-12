package br.edu.infnet.appcar.repository;

import br.edu.infnet.appcar.model.domain.Moto;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface MotoRepository extends JpaRepository<Moto, Integer> {

}
