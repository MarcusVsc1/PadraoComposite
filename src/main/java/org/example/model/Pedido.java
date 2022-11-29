package org.example.model;

import lombok.Getter;

import java.util.ArrayList;
import java.util.List;

@Getter
public abstract class Pedido {

    protected String responsavelCompra;

    protected List<Produto> produtos = new ArrayList<>();

    public Pedido(String responsavelCompra) {
        this.responsavelCompra = responsavelCompra;
    }

    public void adicionarProduto(Produto produto) {
        this.produtos.add(produto);
    }

    public abstract String retornarDescricao();

    public abstract Double retornarValorTotal();

    public Double retornarValorProdutos() {
        return this.produtos.stream().mapToDouble(Produto::getValor).sum();
    }

}
