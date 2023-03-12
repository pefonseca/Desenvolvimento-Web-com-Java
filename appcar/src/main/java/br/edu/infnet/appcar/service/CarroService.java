package br.edu.infnet.appcar.service;

import br.edu.infnet.appcar.model.domain.Carro;
import br.edu.infnet.appcar.repository.CarroRepository;
import org.springframework.stereotype.Service;

import java.util.Collection;

@Service
public class CarroService {

    private final CarroRepository repository;

    public CarroService(CarroRepository repository) {
        this.repository = repository;
    }
    public Carro incluir(Carro carro) {
        return repository.save(carro);
    }

    public void excluir(Integer key) {
        repository.deleteById(key);
    }

    public Collection<Carro> obterLista() {
        return repository.findAll();
    }
}
