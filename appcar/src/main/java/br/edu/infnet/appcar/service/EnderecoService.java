package br.edu.infnet.appcar.service;

import br.edu.infnet.appcar.client.Endereco;
import br.edu.infnet.appcar.client.IEnderecoClient;
import org.springframework.stereotype.Service;

@Service
public class EnderecoService {

    private final IEnderecoClient enderecoClient;

    public EnderecoService(IEnderecoClient enderecoClient) {
        this.enderecoClient = enderecoClient;
    }

    public Endereco buscaPorCep(String cep) {
        return enderecoClient.buscaPorCep(cep);
    }
}
