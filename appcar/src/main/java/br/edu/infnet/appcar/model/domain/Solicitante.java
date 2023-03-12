package br.edu.infnet.appcar.model.domain;

import br.edu.infnet.appcar.model.exceptions.SolicitanteInvalidoException;
import jakarta.persistence.*;
import lombok.*;

@Getter
@Setter
@ToString
@Builder
@NoArgsConstructor
@AllArgsConstructor
@Entity
@Table(name = "TSolicitante")
public class Solicitante {

    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE)
    private Integer id;
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
