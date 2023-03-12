package br.edu.infnet.appcar.repository;

import br.edu.infnet.appcar.model.domain.Caminhao;
import br.edu.infnet.appcar.model.domain.Usuario;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Collection;
import java.util.HashMap;
import java.util.Map;

public interface CaminhaoRepository extends JpaRepository<Caminhao, Integer> {

}
