package com.es2.Armazenamento;

import java.util.ArrayList;

public abstract class PlanoAlimentar {
    private String[] ordemHeader = {"descricao","horario","cod","qt","un"};

    public ArrayList<Refeicao> getRefeicoes() {
        return refeicoes;
    }

    private ArrayList<Refeicao> refeicoes = new ArrayList<Refeicao>();




    public void addRefeicao(Refeicao r) {
        refeicoes.add(r);
    }



    public String[] getOrdemHeader() {
        return ordemHeader;
    }


    public  void mostraRefeicao(){

        for (Refeicao r:refeicoes)
            r.mostraProdutos();
    }


}
