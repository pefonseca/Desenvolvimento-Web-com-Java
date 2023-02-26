package br.edu.infnet.appcar.model.domain;

import br.edu.infnet.appcar.model.exceptions.QuilometragemVeiculoInvalidoException;
import br.edu.infnet.appcar.model.exceptions.ValorZeradoException;

public class Carro extends Veiculo {

    public Carro(Integer id, String nome, String cor, Integer ano, String marca, String primeiroDono, Double valor, Double quilometragem) throws ValorZeradoException {
        super(id, nome, cor, ano, marca, primeiroDono, valor, quilometragem);
    }

    @Override
    public Double calcularValorVenda() throws QuilometragemVeiculoInvalidoException {
        return 0.0;
    }
}
