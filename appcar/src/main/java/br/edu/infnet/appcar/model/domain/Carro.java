package br.edu.infnet.appcar.model.domain;

import br.edu.infnet.appcar.model.exceptions.QuilometragemVeiculoInvalidoException;
import br.edu.infnet.appcar.model.exceptions.ValorZeradoException;
import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
@Entity
@Table(name = "TCarro")
public class Carro extends Veiculo {

    public Carro() {
        super();
    }

    public Carro(String nome, String cor, Integer ano, String marca, String primeiroDono, Double valor, Double quilometragem) throws ValorZeradoException {
        super(nome, cor, ano, marca, primeiroDono, valor, quilometragem);
    }

    @Override
    public Double calcularValorVenda() throws QuilometragemVeiculoInvalidoException {
        return 0.0;
    }
}
