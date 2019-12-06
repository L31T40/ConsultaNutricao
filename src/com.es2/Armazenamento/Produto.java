package com.es2.Armazenamento;

import java.util.ArrayList;

public class Produto {

    private String codigo;
    private String nome;
    private Double quantidade;
    private String unidade;
    private Double qttotal;

    public ArrayList<String> getValoresNutricionais() {
        return valoresNutricionais;
    }

    private ArrayList<String> valoresNutricionais;



    public Produto(String codigo, String produto, double quantidade, String unidade, ArrayList<String> valores) {
        this.valoresNutricionais=new ArrayList<>();
        this.valoresNutricionais=valores;
        this.codigo = codigo;
        this.nome = produto;
        this.quantidade = quantidade;
        this.unidade = unidade;

    }


    public String getCodigo() { return this.codigo;}

    public Double getQuantidade(){return this.quantidade;}

    public String getUnidade() {return this.unidade;}




}