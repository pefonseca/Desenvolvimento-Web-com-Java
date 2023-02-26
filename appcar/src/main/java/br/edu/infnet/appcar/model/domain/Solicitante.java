package br.edu.infnet.appcar.model.domain;

import br.edu.infnet.appcar.model.exceptions.SolicitanteInvalidoException;
import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

@Getter
@Setter
@ToString
public class Solicitante {

    private String nome;
    private String cpf;
    private String email;

    public Solicitante(String nome, String cpf, String email) throws SolicitanteInvalidoException {

        if(nome == null) {
            throw new SolicitanteInvalidoException("O nome do solicitante deve ser preenchido!");
        }

        if(cpf == null) {
            throw new SolicitanteInvalidoException("O CPF do solicitante deve ser preenchido!");
        }

        if(email == null) {
            throw new SolicitanteInvalidoException("O e-mail do solicitante deve ser preenchido!");
        }

        this.nome = nome;
        this.cpf = cpf;
        this.email = email;
    }
}
