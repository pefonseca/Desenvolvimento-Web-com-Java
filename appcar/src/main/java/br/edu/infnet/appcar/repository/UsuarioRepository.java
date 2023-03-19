package br.edu.infnet.appcar.repository;

import br.edu.infnet.appcar.model.domain.Usuario;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

@Repository
public interface UsuarioRepository extends JpaRepository<Usuario, Integer> {

    @Query("select u from Usuario u where u.email = :email and u.senha = :senha")
    Usuario autenticacao(String email, String senha);
}
