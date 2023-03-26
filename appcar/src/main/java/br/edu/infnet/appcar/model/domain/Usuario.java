package br.edu.infnet.appcar.model.domain;

import br.edu.infnet.appcar.client.Endereco;
import jakarta.persistence.*;
import lombok.*;

import java.util.List;
import java.util.Vector;

@Getter
@Setter
@Builder
@NoArgsConstructor
@AllArgsConstructor
@Entity
@Table(name = "TUsuario")
public class Usuario {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;
    private String nome;
    private String senha;
    private String email;
    @ElementCollection
    private List<String> caracteristicas;
    private String tipo;
    private String setor;
    private int idade;
    private float salario;
    private boolean admin;
    @OneToMany(cascade = CascadeType.REMOVE, orphanRemoval = true)
    @JoinColumn(name = "idUsuario")
    private List<Solicitante> solicitantes;
    @OneToMany(cascade = CascadeType.REMOVE, orphanRemoval = true)
    @JoinColumn(name = "idUsuario")
    private List<Veiculo> veiculos;
    @OneToMany(cascade = CascadeType.REMOVE, orphanRemoval = true)
    @JoinColumn(name = "idUsuario")
    private List<Pedido> pedidos;
    @OneToOne(cascade = CascadeType.PERSIST)
    @JoinColumn(name = "idEndereco")
    private Endereco endereco;

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
                caracteristicas.size()
        );
    }
}
