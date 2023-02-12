package br.edu.infnet.appcar.model.domain;

import br.edu.infnet.appcar.model.exceptions.PedidoSemVeiculoException;
import br.edu.infnet.appcar.model.exceptions.PedidoSemSolicitanteException;
import lombok.Getter;
import lombok.Setter;

import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.List;

@Getter
@Setter
public class Pedido {

    private String descricao;
    private boolean web;
    private LocalDateTime data;
    private Usuario usuario;
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

        data = LocalDateTime.now();
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
