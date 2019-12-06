package com.es2.Armazenamento;

import java.time.LocalDateTime;
import java.time.LocalTime;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.LinkedHashMap;

import com.es2.Armazenamento.ColecaoAlimentos;
import sun.awt.SunHints;

public class Refeicao {
    String nome; // Pequeno-almoço, meio-manhã, lanche, etc. etc
    LocalTime hora;
    ArrayList<Produto> produtos = new ArrayList<>();

    ColecaoAlimentos colAlimentos;




    public Refeicao(String nome, LocalTime hora, ColecaoAlimentos colAlimentos) {
        this.nome = nome;
        this.hora = hora;
        this.colAlimentos = colAlimentos;
    }



    public void addProduto(String codProd, Double qt, String un ){
//        LinkedHashMap<String,Double> somaValorNutricional = new LinkedHashMap<>();
//
//        colAlimentos.getData().get(codProd).forEach((key, value) -> somaValorNutricional.put(key,Double.parseDouble(value)));
        ArrayList<String> valueAux=new ArrayList<>();
        int cont=0;
        Double man;
        HashMap<String, String> temp= colAlimentos.getProdbyCodigo(codProd);
        for (Object value : temp.values()) {
            if (cont>0){
                man = Double.parseDouble(value.toString().replace(",","."))*qt/100;
                valueAux.add(man.toString());
            }
            cont++;
        }
        Produto p=new Produto(codProd,colAlimentos.getProdNamebyCodigo(codProd),qt,un,valueAux);
        produtos.add(p);

//        System.out.println();
    }

    public ArrayList<Produto> getProdutos()
    {
        return produtos;
    }

    public  void mostraProdutos(){
        System.out.println();
        System.out.println();
        System.out.println("========================================");
        System.out.println(" --------------> "+nome+" <---------------");
        System.out.println("========================================");
        System.out.println();
        System.out.println(" -> "+hora);
        System.out.println();
        for (Produto prod:produtos){
            System.out.print(" -> "+prod.getCodigo());
            System.out.print(" -> "+prod.getQuantidade());
            System.out.print(" -> "+prod.getUnidade());
        }

    }

    public String getNome() {
        return nome;
    }

}
