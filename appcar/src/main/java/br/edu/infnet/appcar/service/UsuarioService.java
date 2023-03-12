package br.edu.infnet.appcar.service;

import br.edu.infnet.appcar.model.domain.Usuario;
import br.edu.infnet.appcar.repository.UsuarioRepository;
import org.springframework.stereotype.Service;

import java.util.Collection;

@Service
public class UsuarioService {

    private final UsuarioRepository usuarioRepository;

    public UsuarioService(UsuarioRepository usuarioRepository) {
        this.usuarioRepository = usuarioRepository;
    }

    public Usuario incluir(Usuario usuario) {
        return usuarioRepository.save(usuario);
    }

    public void excluir(Integer key) {
        usuarioRepository.deleteById(key);
    }

    public Collection<Usuario> obterLista() {
        return usuarioRepository.findAll();
    }
}
