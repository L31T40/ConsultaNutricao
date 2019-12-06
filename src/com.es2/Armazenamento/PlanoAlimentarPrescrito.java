package com.es2.Armazenamento;

import java.util.ArrayList;

public class PlanoAlimentarPrescrito extends PlanoAlimentar{

    private PlanoAlimentarPrescrito() {}

    private static PlanoAlimentarPrescrito single_instance=null;

    public static PlanoAlimentarPrescrito getInstance()
    {
        if (single_instance == null)
        {
            single_instance = new PlanoAlimentarPrescrito();
        }
        return single_instance;
    }

}
