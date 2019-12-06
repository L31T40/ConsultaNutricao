package com.es2.Escrita;

import com.es2.Armazenamento.*;

import com.es2.Armazenamento.Refeicao;
import com.es2.Leitura.*;
import com.opencsv.CSVWriter;
import org.apache.commons.lang3.ArrayUtils;

import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.math.BigDecimal;
import java.math.RoundingMode;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class EscreveCSV {

    /**
     * Escrever em ficheiro informação obtida de dicionario e array.
     * @param header String, cabeçalho do ficheiro a escrever .
     * @param dados String, dados a escrever no ficheiro.
     * @param filePath String, path para guardar o ficheiro de output.
     */
    public boolean escreveCSV(String[] header, Map<Integer, String[]> dados, String filePath) {
        File file = new File(filePath);
        try {
            // create FileWriter object with file as parameter
            FileWriter outputfile = new FileWriter(file);


            // create CSVWriter object filewriter object as parameter
            CSVWriter writer = new CSVWriter(outputfile,';');

            // adding header to csv
            writer.writeNext(header);

            // add data to csv
            writer.writeAll(dados.values());

            // closing writer connection
            writer.close();
            return true;
        } catch (IOException e) {

            e.printStackTrace();
            return false;
        }


    }

    /**
     * Arredondamento de numero double
     * @param valor Double, cvalor a arredondar.
     * @param places int , numero de casas decimais
     */
    public static double round(double valor, int places) {
        if (places < 0) throw new IllegalArgumentException();

        BigDecimal bd = new BigDecimal(valor);
        bd = bd.setScale(places, RoundingMode.HALF_UP);
        return bd.doubleValue();
    }


    /**
     * Calculo do somatorio de valores nutricionais por refeiçao, Devolve Arrays com somatorio
     * @param valoresNutricionais ArrayList<String[]> , Valores nutricionais.
     */

   public static  ArrayList<Double> calculaSomatorio(ArrayList<String[]> valoresNutricionais)
    {
        ArrayList<Double> auxT = new ArrayList<>();
        ArrayList<Double> aux = new ArrayList<>();
        int iA = 0;
        for(String[] value : valoresNutricionais)
        {
            for(int i = 0;i < value.length; i ++)
            {
                if(iA  == 0)
                    aux.add(round(Double.parseDouble(value[i]),2));
                else
                    aux.set(i, round((aux.get(i) + Double.parseDouble(value[i])),2));
            }
            iA++;
        }
        for(Double ax : aux)
        {
            auxT.add(ax);
        }
        return auxT;
    }

    /**
     * Calculo do TOTAL de valores nutricionais por Nutriente, Devolve Arrays com somatorio
     * @param valoresNutricionais ArrayList<String[]> , Valores nutricionais.
     */
    public static ArrayList<Double> calcularTotal(ArrayList<ArrayList<Double>>  valoresNutricionais)
    {
        ArrayList<Double> aux = new ArrayList<>();
        int iA = 0 ;
        valoresNutricionais.size();int i =0;
        int iB;
        for(ArrayList<Double> valD : valoresNutricionais)
        {
            if(i!=0){
                iB = 0;
                for(Double value : valD)
                {
                    if(iA  == 0)
                        aux.add(round(value,2));
                    else
                        aux.set(iB, round((aux.get(iB) + value),2));
                    iB++;
                }
                iA++;

            }
            i++;

        }
        return aux;
    }

    /**
     * Criação de ficheiro CSV com o Sumário
     * @param paciente Paciente , Informação do paciente
     * @param alimentos ColecaoAlimentos, Hassmap com os dados dos alimentos/produtos
     */
    public void geraPlanoAlimentarSumario(Paciente paciente, ColecaoAlimentos alimentos){

    int nLinha=0;
    String[] headerA = null;
    Double totalPrescrito=null;
    Double totalAtual=null;

    Map<Integer, String[]> dados = new HashMap< >();
    Map<String, String[]> somaRefeicao = new HashMap< >();

    ArrayList<String> header = alimentos.getHeaderTabela();
    ArrayList<String> linha = new ArrayList<>();

    PlanoAlimentar planoAtual=PlanoAlimentarAtual.getInstance();
    PlanoAlimentar planoPrescrito=PlanoAlimentarPrescrito.getInstance();

    ArrayList<Refeicao>  planoatual = planoAtual.getRefeicoes();
    ArrayList<Refeicao>  planoprescrito = planoPrescrito.getRefeicoes();

    ArrayList<String[]> somaAux=new ArrayList<String[]>();
    ArrayList<String[]> somaAuxPrescrito=new ArrayList<String[]>();
    ArrayList<ArrayList <Double> > somaLinha=new ArrayList<ArrayList <Double> >();
    ArrayList<ArrayList <Double> > somaLinhaPrescrito=new ArrayList<ArrayList <Double> >();

    if (paciente !=null) {
        header.remove(0);// remove  primeira e segunda posicao do array do header
        header.remove(0);

        linha.add("Refeição");
        linha.addAll(header);
        for(int i=2;i<linha.size();i++){ //colocar espaço entre os valores nutricionais
            linha.add(i," ");
            i++;
        }
        dados.put(nLinha, linha.toArray(new String[0]));
        linha.clear();
        nLinha++;

        linha.add(" ");
        for(int i=2;i<header.size();i++){ //Coloca segundo header do csv
            linha.add("Hábitos");
            linha.add("Plano");
        }
        dados.put(nLinha, linha.toArray(new String[0]));
        linha.clear();
        nLinha++;

    //Somatorio dos Valores Nutricionais plano atual
        for(Refeicao ref: planoatual)
        {
            for( Produto prod: ref.getProdutos() )
            {
                prod.getValoresNutricionais();
                somaAux.add(prod.getValoresNutricionais().toArray(new String[0]));

            }
            somaLinha.add(calculaSomatorio(somaAux));
            somaAux.clear();
        }

//Somatorio dos Valores Nutricionais plano Prescrito
        for(Refeicao refPrescrito: planoprescrito)
        {
            for( Produto prodprescrito: refPrescrito.getProdutos() )
            {
                somaAuxPrescrito.add(prodprescrito.getValoresNutricionais().toArray(new String[0]));
            }
            somaLinhaPrescrito.add(calculaSomatorio(somaAuxPrescrito));
            somaAuxPrescrito.clear();
        }

        int j=0;

        for(int i=1;i<planoAtual.getRefeicoes().size();i++){
            linha.add(planoAtual.getRefeicoes().get(i).getNome());
            for(Double temp:somaLinha.get(i)){
                linha.add(temp.toString());
                linha.add(somaLinhaPrescrito.get(i).get(j).toString());
                j++;

            }
            j=0;

            dados.put(nLinha, linha.toArray(new String[0]));
            linha.clear();
            nLinha++;
        }
        j=0;
        // colocar linha vazia
        linha.clear();
        dados.put(nLinha, linha.toArray(new String[0]));
        linha.clear();
        nLinha++;


        //adiciona linha dos totais
        linha.add("TOTAL: ");
        for(Double soma: calcularTotal(somaLinha)){
            linha.add(soma.toString());
            linha.add(calcularTotal(somaLinhaPrescrito).get(j).toString());
            totalPrescrito=soma;
            totalAtual=calcularTotal(somaLinhaPrescrito).get(j);
            j++;
        }
//        System.out.println(linha);
        dados.put(nLinha, linha.toArray(new String[0]));
        linha.clear();
        nLinha++;

        // colocar linha vazia
        linha.clear();
        dados.put(nLinha, linha.toArray(new String[0]));
        linha.clear();
        nLinha++;



        // Gasto Energético Total:
        linha.add("GASTO ENERGÉTICO TOTAL");
        linha.add(paciente.getCalorias().toString());
        dados.put(nLinha, linha.toArray(new String[0]));
        linha.clear();
        nLinha++;

        // Gasto Energético Total:
        linha.add("GASTO ENERGÉTICO PARA MANTER O PESO");
        Double somaprescrito=round(paciente.getTMB()/totalPrescrito,2);
        Double somaatual=round(paciente.getCalorias()/totalAtual,2);
        linha.add(somaprescrito.toString()+" %");
        linha.add(somaatual.toString()+" %");
        dados.put(nLinha, linha.toArray(new String[0]));
        linha.clear();
        nLinha++;

        // colocar linha vazia
        linha.clear();
        dados.put(nLinha, linha.toArray(new String[0]));
        linha.clear();
        nLinha++;

        // Dados do paciente
        linha.add("###### PACIENTE ##########");
        dados.put(nLinha, linha.toArray(new String[0]));
        linha.clear();
        nLinha++;


        // Dados do paciente
        linha.add("NOME");
        linha.add(paciente.getNome());
        dados.put(nLinha, linha.toArray(new String[0]));
        linha.clear();
        nLinha++;

        // Dados do paciente
        linha.add("IDADE");
        linha.add(paciente.getIdade());
        dados.put(nLinha, linha.toArray(new String[0]));
        linha.clear();
        nLinha++;

        // Dados do paciente
        linha.add("IMC");
        Double altura= paciente.getAlturaCm()/100;
        Double imc=round(paciente.getPesoKg()/(altura*altura),2);
        linha.add(imc.toString());
        dados.put(nLinha, linha.toArray(new String[0]));
        linha.clear();
        nLinha++;


        // gravaçao de ficheiro CSV com Sumario dos habitos
        this.escreveCSV(headerA, dados,"Files/PlanoAlimentarAtualSumario.csv");

    }

    }

}
