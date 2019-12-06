package com.es2.Armazenamento;

public class PlanoAlimentarAtual extends PlanoAlimentar{


    private PlanoAlimentarAtual() {
    }

    private static PlanoAlimentarAtual single_instance=null;

    public static PlanoAlimentarAtual getInstance()
    {
        if (single_instance == null)
        {
            single_instance = new PlanoAlimentarAtual();
        }
        return single_instance;
    }


}
