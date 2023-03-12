package br.edu.infnet.appcar.service;

import br.edu.infnet.appcar.model.domain.Moto;
import br.edu.infnet.appcar.model.domain.Solicitante;
import br.edu.infnet.appcar.repository.MotoRepository;
import org.springframework.stereotype.Service;

import java.util.Collection;

@Service
public class MotoService {

    private final MotoRepository repository;

    public MotoService(MotoRepository repository) {
        this.repository = repository;
    }

    public Moto incluir(Moto moto) {
        return repository.save(moto);
    }

    public void excluir(Integer key) {
        repository.deleteById(key);
    }

    public Collection<Moto> obterLista() {
        return repository.findAll();
    }
}
