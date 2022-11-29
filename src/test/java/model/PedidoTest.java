package model;

import org.example.model.PedidoComum;
import org.example.model.PedidoPresente;
import org.example.model.Produto;
import org.junit.Test;

import static org.junit.Assert.assertEquals;


public class PedidoTest {

    @Test
    public void pedidoComPedidoPresenteTest() {
        Produto produto1 = new Produto("Açucar Demerara", 6D);
        Produto produto2 = new Produto("Açucar Cristal", 4D);
        Produto presente = new Produto("Par de meias Rainha", 10.5D);

        PedidoComum pedidoComum1 = new PedidoComum("José da Silva");
        PedidoComum pedidoComum2 = new PedidoComum("Mefistófeles");
        PedidoPresente pedidoPresente = new PedidoPresente("Mefistófeles","Gata Hiyori");
        pedidoComum1.adicionarProduto(produto1);
        pedidoComum2.adicionarProduto(produto2);
        pedidoPresente.adicionarProduto(presente);
        pedidoComum2.adicionarSubPedido(pedidoPresente);
        pedidoComum1.adicionarSubPedido(pedidoComum2);

        String resultado = """
                {Pedido Comum}:
                >Responsável: José da Silva
                -Produtos: [Açucar Demerara R$6.0]
                *Subpedidos:
                {Pedido Comum}:
                >Responsável: Mefistófeles
                -Produtos: [Açucar Cristal R$4.0]
                *Subpedidos:
                {Pedido Presente}:
                -Produtos: [Par de meias Rainha R$10.5]
                De: Mefistófeles
                Para: Gata Hiyori""";

        assertEquals(resultado, pedidoComum1.retornarDescricao());
    }

    @Test
    public void pedidoSemProdutoTest() {
        PedidoComum pedidoComum1 = new PedidoComum("José da Silva");
        PedidoPresente pedidoPresente = new PedidoPresente("Mefistófeles","Gata Hiyori");
        pedidoComum1.adicionarSubPedido(pedidoPresente);

        String resultado = """
                {Pedido Comum}:
                >Responsável: José da Silva
                *Subpedidos:
                {Pedido Presente}:
                De: Mefistófeles
                Para: Gata Hiyori""";

        assertEquals(resultado, pedidoComum1.retornarDescricao());
    }

    @Test
    public void pedidoSemSubPedidoTest() {
        PedidoComum pedidoComum1 = new PedidoComum("José da Silva");

        String resultado = """
                {Pedido Comum}:
                >Responsável: José da Silva
                """;

        assertEquals(resultado, pedidoComum1.retornarDescricao());
    }

    @Test
    public void valorTotalTest(){
        PedidoComum pedidoComum1 = new PedidoComum("José da Silva");
        PedidoPresente pedidoPresente = new PedidoPresente("Mefistófeles","Gata Hiyori");
        Produto produto1 = new Produto("Açucar Cristal", 4D);
        Produto presente = new Produto("Par de meias Rainha", 10.5D);
        pedidoComum1.adicionarProduto(produto1);
        pedidoPresente.adicionarProduto(presente);
        pedidoComum1.adicionarSubPedido(pedidoPresente);

        Double resultado = 14.5D;

        assertEquals(resultado, pedidoComum1.retornarValorTotal());

    }
}
