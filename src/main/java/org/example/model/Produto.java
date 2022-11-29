package org.example.model;

import lombok.*;

@Getter
@Setter
@AllArgsConstructor
public class Produto {

    private String nome;
    private Double valor;


    @Override
    public String toString(){
        return this.nome + " R$"+this.valor;
    }
}
