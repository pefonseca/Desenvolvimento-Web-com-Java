package br.edu.infnet.appcar.service;

import br.edu.infnet.appcar.model.domain.Solicitante;
import br.edu.infnet.appcar.model.domain.Usuario;
import br.edu.infnet.appcar.repository.SolicitanteRepository;
import org.springframework.stereotype.Service;

import java.util.Collection;

@Service
public class SolicitanteService {

    private final SolicitanteRepository repository;

    public SolicitanteService(SolicitanteRepository solicitanteRepository) {
        this.repository = solicitanteRepository;
    }

    public Solicitante incluir(Solicitante solicitante) {
        return repository.save(solicitante);
    }

    public void excluir(Integer key) {
        repository.deleteById(key);
    }

    public Collection<Solicitante> obterLista() {
        return repository.findAll();
    }

    public Collection<Solicitante> obterLista(Usuario usuario) {
        return repository.obterLista(usuario.getId());
    }
}
