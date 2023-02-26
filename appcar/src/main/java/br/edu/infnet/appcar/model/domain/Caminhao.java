package br.edu.infnet.appcar.model.domain;

import br.edu.infnet.appcar.model.exceptions.QuilometragemVeiculoInvalidoException;
import br.edu.infnet.appcar.model.exceptions.ValorZeradoException;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class Caminhao extends Veiculo {

    private float carga;

    public Caminhao(Integer id, String nome, String cor, Integer ano, String marca, String primeiroDono, Double valor, Double quilometragem, float carga) throws ValorZeradoException {
        super(id, nome, cor, ano, marca, primeiroDono, valor, quilometragem);
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
