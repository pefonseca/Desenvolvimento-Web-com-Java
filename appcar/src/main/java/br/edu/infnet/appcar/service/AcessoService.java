package br.edu.infnet.appcar.service;

import br.edu.infnet.appcar.model.domain.Usuario;
import br.edu.infnet.appcar.repository.AcessoRepository;
import org.springframework.stereotype.Service;

@Service
public class AcessoService implements AcessoRepository {
    @Override
    public Usuario autenticar(Usuario usuario) {
        if(usuario.getEmail().equalsIgnoreCase(usuario.getSenha())) {
            return new Usuario("Administrador", usuario.getEmail(), usuario.getSenha());
        }
        return null;
    }
}
