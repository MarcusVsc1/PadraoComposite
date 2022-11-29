package org.example.model;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class PedidoPresente extends Pedido {

    private String destinatario;

    public PedidoPresente(String responsavelCompra, String destinatario) {
        super(responsavelCompra);
        this.destinatario = destinatario;
    }

    @Override
    public String retornarDescricao() {
        String saida = "{Pedido Presente}:\n";
        if(produtos.size()>0) {
            saida += "-Produtos: " + this.produtos + "\n";
        }
        saida+= "De: "+ this.responsavelCompra + "\nPara: " + this.destinatario;
        return saida;
    }

    @Override
    public Double retornarValorTotal() {
        return this.retornarValorProdutos();
    }

}
