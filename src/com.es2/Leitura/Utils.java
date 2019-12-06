package com.es2.Leitura;

import java.io.File;
import java.util.Arrays;

public class Utils {

    // FEFF because this is the Unicode char represented by the UTF-8 byte order mark (EF BB BF).
    public static final String UTF8_BOM = "\uFEFF";
    /**
     * * valida se o valor das unidades esta correto.
     * @param unid String, unidade a validar
     */
    public static boolean validaUnid(String unid)
    {
        String[] unidValidas = {"gr","l","mg","ml"};
        return Arrays.asList(unidValidas).contains(unid.toLowerCase());
    }


    /**
     * * Verifica a existencia do ficheiro a ler
     * @param filePath String, nome e caminho do ficheiro .
     */
    public static boolean validaFicheiro(String filePath)
    {
        File ficheiro = new File(filePath);
        return ficheiro.exists();
    }

    /**
     * Remove carater UTF 8 BOM de ficheiro CSV
     * @param s String, string a ler .
     */

    public static String removeUTF8BOM(String s){
        if(s.startsWith(UTF8_BOM)){
            s=s.substring(1);
        }
        return s;
    }




}
