package br.edu.infnet.appcar.service;

import br.edu.infnet.appcar.model.domain.Usuario;
import br.edu.infnet.appcar.model.domain.Veiculo;
import br.edu.infnet.appcar.repository.VeiculoRepository;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Service;

import java.util.Collection;
import java.util.Optional;

@Service
public class VeiculoService {

    private final VeiculoRepository veiculoRepository;

    public VeiculoService(VeiculoRepository veiculoRepository) {
        this.veiculoRepository = veiculoRepository;
    }

    public Veiculo incluir(Veiculo veiculo) {
        return veiculoRepository.save(veiculo);
    }

    public void excluir(Integer id) {
        veiculoRepository.deleteById(id);
    }

    public Collection<Veiculo> obterLista(){
        return veiculoRepository.findAll();
    }

    public Collection<Veiculo> obterLista(Usuario usuario){
        return veiculoRepository.obterLista(usuario.getId(), Sort.by(Sort.Direction.ASC, "nome"));
    }
}
