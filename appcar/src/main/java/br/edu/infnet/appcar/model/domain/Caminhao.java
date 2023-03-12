package br.edu.infnet.appcar.model.domain;

import br.edu.infnet.appcar.model.exceptions.QuilometragemVeiculoInvalidoException;
import br.edu.infnet.appcar.model.exceptions.ValorZeradoException;
import jakarta.persistence.*;
import lombok.*;

@Getter
@Setter
@Entity
@Table(name = "TCaminhao")
public class Caminhao extends Veiculo {

    private float carga;

    public Caminhao() {
        super();
    }

    public Caminhao(String nome, String cor, Integer ano, String marca, String primeiroDono, Double valor, Double quilometragem, float carga) throws ValorZeradoException {
        super(nome, cor, ano, marca, primeiroDono, valor, quilometragem);
        this.carga = carga;
    }

    @Override
    public Double calcularValorVenda() throws QuilometragemVeiculoInvalidoException {
        if (this.getQuilometragem() > 30000) {
            return this.getValor() - 10000;
        }

        return this.getValor();
    }
}
