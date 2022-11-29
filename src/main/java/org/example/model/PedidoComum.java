package org.example.model;

import lombok.Setter;

import java.util.ArrayList;
import java.util.List;

@Setter
public class PedidoComum extends Pedido{

    public PedidoComum(String responsavelCompra) {
        super(responsavelCompra);
    }

    private List<Pedido> subPedidos = new ArrayList<>();

    public void adicionarSubPedido(Pedido subPedido) {
        this.subPedidos.add(subPedido);
    }


    @Override
    public String retornarDescricao() {
        StringBuilder saida = new StringBuilder("{Pedido Comum}:\n");
        saida.append(">Responsável: ").append(this.responsavelCompra).append("\n");
        if(produtos.size()>0) {
            saida.append("-Produtos: ").append(this.produtos).append("\n");
        }
        if(subPedidos.size()>0){
            saida.append("*Subpedidos:\n");
            for(Pedido sbp : subPedidos){
                saida.append(sbp.retornarDescricao());
            }
        }

        return saida.toString();

    }

    @Override
    public Double retornarValorTotal() {
        return this.retornarValorProdutos() +
                this.subPedidos.stream().mapToDouble(Pedido::retornarValorProdutos).sum();
    }

}
