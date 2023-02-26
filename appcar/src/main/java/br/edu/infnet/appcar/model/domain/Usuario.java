package br.edu.infnet.appcar.model.domain;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class Usuario {

    private Integer id;
    private String nome;
    private String senha;
    private String email;
    private String[] caracteristicas;
    private String tipo;
    private String setor;
    private int idade;
    private float salario;

    public Usuario() { }

    public Usuario(String email, String senha) {
        this();
        this.setEmail(email);
        this.setSenha(senha);
    }

    public Usuario(String nome, String email, String senha) {
        this(email, senha);
        this.setNome(nome);
    }

    @Override
    public String toString() {

        return String.format(
                "O usuário %s tem as credenciais %s e %s, %d anos e ganha R$%.2f. "
                        + "É um usuário do tipo %s, atua no setor %s e tem %d características",
                nome,
                email,
                senha,
                idade,
                salario,
                tipo,
                setor,
                caracteristicas.length
        );
    }
}
