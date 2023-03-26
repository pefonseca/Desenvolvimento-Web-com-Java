package br.edu.infnet.appcar.service;

import br.edu.infnet.appcar.model.domain.Caminhao;
import br.edu.infnet.appcar.model.domain.Usuario;
import br.edu.infnet.appcar.repository.CaminhaoRepository;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Service;

import java.util.Collection;

@Service
public class CaminhaoService {

    private final CaminhaoRepository repository;

    public CaminhaoService(CaminhaoRepository repository) {
        this.repository = repository;
    }

    public Caminhao incluir(Caminhao caminhao) {
        return repository.save(caminhao);
    }

    public void excluir(Integer key) {
        repository.deleteById(key);
    }

    public Collection<Caminhao> obterLista() {
        return repository.findAll();
    }

    public Collection<Caminhao> obterLista(Usuario usuario){
        return repository.obterLista(usuario.getId(), Sort.by(Sort.Direction.ASC, "nome"));
    }
}
