package com.es2.Armazenamento;

import org.apache.commons.lang3.ObjectUtils;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.LinkedHashMap;

public class ColecaoAlimentos {
    private  HashMap<String,HashMap<String,String>> tabelaNutricional = new HashMap<String,HashMap<String,String>>();
    private LinkedHashMap<String,String> dataTabela = null;
    private  ArrayList<String> headerTabela = null;

    public ColecaoAlimentos(){}

    public HashMap<String, HashMap<String, String>> getTabelaNutricional() {
        return tabelaNutricional;
    }

    public void setTabelaNutricional(HashMap<String, HashMap<String, String>> tabelaNutricional) {
        this.tabelaNutricional = tabelaNutricional;
    }

    public  HashMap<String, String> getDataTabela() {
        return dataTabela;
    }

    public void setDataTabela(LinkedHashMap<String, String> dataTabela) {
        this.dataTabela = dataTabela;
    }

    public  ArrayList<String> getHeaderTabela() {
        return headerTabela;
    }

    public void setHeaderTabela(ArrayList<String> headerTabela) {
        this.headerTabela = headerTabela;
    }

    /**
     * Escrever em ficheiro informa??o obtida de dicionario e array.
     * @param linha String[], cabe?alho do ficheiro a escrever .
     */
    private void verificarElemento(String[] linha) throws StringVaziaExcepcao, NullExcepcao, ForadeLimitesExcepcao, CodigoNaoValido {
        for(int i = 0; i<linha.length; i++)
        {
            if(linha[i] == null)
                throw new NullExcepcao(linha[i]);
            else {
                if (headerTabela.get(i).equals("Código") || headerTabela.get(i).equals("PRODUTO")) {
                    if (linha[i].equals(""))
                        throw new StringVaziaExcepcao(linha[i]);
                    else if(headerTabela.get(i).equals("Código") && (!linha[i].substring(0,2).equals("IS") || Integer.parseInt(linha[i].substring(2,linha[i].length())) < 0 || Integer.parseInt(linha[i].substring(2,linha[i].length())) > 1000))
                        throw new CodigoNaoValido();
                } else {
                    if(linha[i].equals(""))
                        throw new StringVaziaExcepcao(linha[i]);
                    if(headerTabela.get(i).equals("Energia (kJ)") || headerTabela.get(i).equals("K    (mg)") ||  headerTabela.get(i).equals("Vit A total (equivalentes retinol) (mg)") || headerTabela.get(i).contains("Folatos") || headerTabela.get(i).equals("P (mg)"))
                    {
                        if (Double.parseDouble(linha[i].replace(",", ".")) > 15000 || Double.parseDouble(linha[i].replace(",", ".")) < 0)
                            throw new ForadeLimitesExcepcao(/*linha[i]*/);
                    }
                    else if(headerTabela.get(i).equals("Caroteno (mg)") || headerTabela.get(i).equals("Na (mg)"))
                    {
                        if (Double.parseDouble(linha[i].replace(",", ".")) > 40000 || Double.parseDouble(linha[i].replace(",", ".")) < 0)
                            throw new ForadeLimitesExcepcao(/*linha[i]*/);
                    }
                    else if (Double.parseDouble(linha[i].replace(",", ".")) > 1500 || Double.parseDouble(linha[i].replace(",", ".")) < 0)
                        throw new ForadeLimitesExcepcao(/*linha[i]*/);
                }
            }
        }
    }

    public void addHeaderTabela(String[] linha){

        headerTabela = new ArrayList<String>();
        for (String e : linha)
            headerTabela.add(e);
    }

    /**
     * Colocxa informaçao da tabela nuticional no hashmape
     * @param linha String[], valores nutricionais.
     */

    public void addElemento(String[] linha) throws StringVaziaExcepcao, NullExcepcao, ForadeLimitesExcepcao, CodigoNaoValido
    {
        String k = null;
        dataTabela = new LinkedHashMap<String,String>();

        verificarElemento(linha);
        for (int i = 0; i < linha.length; i++) {
            if (i == 0)
                k = linha[i];
            else {
                dataTabela.put(headerTabela.get(i), linha[i]);
                tabelaNutricional.put(k, dataTabela);
            }
        }


    }

    /**
     * Mostrar header da tabela nutricional
     */
    public  void mostraHeaderTabela(){

        System.out.println(getHeaderTabela());
    }

    /**
     * Mostrar dados da tabela nutricional
     */
    public  void mostraDataTabela(){

        tabelaNutricional.forEach((key, value) -> System.out.println(key + " -> " + value));


    }


//     Adiciona um HashMap com vários elementos.
//    ATENÇÃO! Vai rescrever os que já se encontram com a mesma chave.
    public void addVariosElementos(HashMap<String,HashMap<String,String>> hm)
    {
        tabelaNutricional.putAll(hm);
    }

    // testar tabela nutricional
    public HashMap<String,HashMap<String,String>> getData(){
        return this.tabelaNutricional;
    }

    public  String getProdNamebyCodigo(String codigo){
        return tabelaNutricional.get(codigo).get("PRODUTO");
    }

    public  HashMap<String, String> getProdbyCodigo(String codigo){
        return tabelaNutricional.get(codigo);
    }


}
