package com.es2.Leitura;
import java.util.HashMap;

public class RawDataPaciente {
    private static HashMap<String,String> data = new HashMap<String, String>();

    public RawDataPaciente() {}


//    String tipo; //infopaciente ou alimento ou ...
//
//    public RawDataPaciente(String tipo) {
//        this.tipo = tipo;
//    }
//
//    public String getTipo()
//    {
//        return this.tipo;
//    }

    public void addElemento(String key, String valor)
    {
        data.put(key,valor);
    }

    /* Adiciona um HashMap com vários elementos.
    ATENÇÃO! Vai rescrever os que já se encontram com a mesma chave. */
    public void addVariosElementos(HashMap<String,String> hm)
    {
        data.putAll(hm);
    }

    public void substituirElementos(String key, String novoValor)
    {
        this.data.put(key, novoValor);
    }

    public HashMap<String,String> getData(){
        return this.data;
    }

    public static void mostraPaciente(){
        data.forEach((key, value) -> System.out.println(key + " -> " + value));
    }
}
