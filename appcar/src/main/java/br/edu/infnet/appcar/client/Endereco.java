package br.edu.infnet.appcar.client;

import jakarta.persistence.*;
import lombok.*;

@Getter
@Setter
@Builder
@NoArgsConstructor
@AllArgsConstructor
@Entity
@Table(name = "TEndereco")
public class Endereco {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;
    private String cep;
    private String logradouro;
    private String complemento;
    private String bairro;
    private String localidade;
    private String uf;

    @Override
    public String toString() {

        return String.format("%s, %s - $s - %s - %s, %s", logradouro, complemento, bairro, localidade, cep, uf);
    }
}
