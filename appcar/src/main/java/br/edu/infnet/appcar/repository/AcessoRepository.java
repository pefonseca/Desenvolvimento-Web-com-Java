package br.edu.infnet.appcar.repository;

import br.edu.infnet.appcar.model.domain.Usuario;
import org.springframework.stereotype.Repository;

@Repository
public interface AcessoRepository {

	Usuario autenticar(Usuario usuario);
}