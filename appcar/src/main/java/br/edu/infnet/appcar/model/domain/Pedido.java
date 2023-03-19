package br.edu.infnet.appcar.model.domain;

import br.edu.infnet.appcar.model.exceptions.PedidoSemSolicitanteException;
import br.edu.infnet.appcar.model.exceptions.PedidoSemVeiculoException;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.List;

@Getter
@Setter
@Entity
@Table(name = "TPedido")
@NoArgsConstructor
@AllArgsConstructor
public class Pedido {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;
    private String descricao;
    private boolean web;
    private LocalDate data;
    @OneToOne(cascade = CascadeType.DETACH)
    @JoinColumn(name = "idSolicitante")
    private Solicitante solicitante;
    @ManyToOne(cascade = CascadeType.DETACH)
    @JoinColumn(name = "idUsuario")
    private Usuario usuario;
    @ManyToMany(cascade = CascadeType.DETACH)
    private List<Veiculo> veiculos;

    public Pedido(Usuario usuario, List<Veiculo> veiculos) throws PedidoSemSolicitanteException, PedidoSemVeiculoException {

        if(usuario == null) {
            throw new PedidoSemSolicitanteException("Não existe nenhum solicitante associado ao pedido!");
        }

        if(veiculos == null) {
            throw new PedidoSemVeiculoException("Não existe nenhum veiculo associado ao pedido!");
        }

        this.usuario = usuario;
        this.veiculos = veiculos;

        data = LocalDate.now();
    }

    public void imprimir(){
        System.out.println("Pedido: " + this);
        System.out.println("Solicitante: " + usuario);
        System.out.println("Qtde Veiculos: " + veiculos.size());
        System.out.println("Veiculos: ");
        for(Veiculo p : veiculos) {
            System.out.println("- " + p.getNome());
        }
    }

    public String obterLinha() {
        DateTimeFormatter formato = DateTimeFormatter.ofPattern("dd/MM/yyyy");

        return this.getData().format(formato)+";"+
                this.getDescricao()+";"+
                this.getUsuario()+";"+
                this.getVeiculos().size()+"\r\n";
    }

    public String toString() {

        DateTimeFormatter formato = DateTimeFormatter.ofPattern("dd/MM/yyyy HH:mm");

        return  String.format("%s;%s;%s",
                descricao,
                web ? "web" : "loja",
                data.format(formato)
        );
    }
}
