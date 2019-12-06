package com.es2.Leitura;
import com.es2.Armazenamento.*;
import com.opencsv.CSVParser;
import com.opencsv.CSVParserBuilder;
import com.opencsv.CSVReader;
import com.opencsv.CSVReaderBuilder;

import java.io.BufferedReader;
import java.io.File;
import java.io.IOException;
import java.nio.charset.StandardCharsets;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.time.LocalTime;
import java.time.format.DateTimeFormatter;
import java.util.List;
import java.util.Arrays;




public class LerCSV {





    /**
     * Ler informaçao de ficheiro CSV e coloca num array e devolve
     * @param ficheiro String, nome do ficheiro a ler .
     */
    //Leitura do ficheiro CSV  passado por parametro coloca numa lista e devolve
    public static List<String[]> lerCSV(String ficheiro) throws IOException  {
        List<String[]> linhas=null;

        Path myPath = Paths.get(ficheiro);

        CSVParser parser = new CSVParserBuilder().withSeparator(';').build();
        try {

            BufferedReader br = Files.newBufferedReader(myPath, StandardCharsets.UTF_8);
            CSVReader leitura = new CSVReaderBuilder(br).withCSVParser(parser)
                    .build();
            linhas = leitura.readAll();
        }
        catch (IOException e)
        {
            e.printStackTrace();
        }
        for (String[] coluna : linhas) {
            if (!coluna[0].contains(Utils.UTF8_BOM)) {
                String s=Utils.removeUTF8BOM(coluna[0]);
                coluna[0]=s;
            }
        }

        return linhas;
    }



    /**
     * Ler informaçao de ficheiro CSV do questionario e coloca no hashmap e devolve
     * @param ficheiro String, nome do ficheiro a ler .
     */
    public static RawDataPaciente lerCSVQuestionario(String ficheiro) throws IOException  {
        RawDataPaciente paciente = new RawDataPaciente();
        File f = new File(ficheiro);
        if(f.exists() && !f.isDirectory()) {
            List<String[]> linhas = lerCSV(ficheiro);
            for (String[] coluna : linhas) {
                if (!coluna[0].contains("####")) {
                    if( !coluna[0].contains("Paciente") ){
                        if (!coluna[1].equals("")){
                            paciente.addElemento(coluna[0], coluna[1]);
//                            System.out.println(coluna[0]+" --> "+coluna[1]);

                        }

                    }

                }
            }
        }else
        {
            return null;
        }
        return paciente;
    }

    /**
     * Ler informa??o de ficheiro CSV da tabela e coloca no hashmap e devolve
     * @param ficheiro String, nome do ficheiro a ler .
     */
    public static ColecaoAlimentos lerCSVTabela(String ficheiro) throws IOException  {

        ColecaoAlimentos tbl = new ColecaoAlimentos();

        File f = new File(ficheiro);
        if(f.exists() && !f.isDirectory()) {
            List<String[]> linhas = lerCSV(ficheiro);
            for (String[] linha : linhas) {
                if (linha[0].equals("Código")) {

                    tbl.addHeaderTabela(linha);
                } else if (linha[0].contains("IS")) {

                    try {
                        tbl.addElemento(linha);
                    } catch (StringVaziaExcepcao stringVaziaExcepcao) {
                        System.out.println("Foi encontrada uma string vazia. A execucao nao vai prosseguir.");
                        System.exit(1);
                    } catch (NullExcepcao nullExcepcao) {
                        System.out.println("Foi encontrado um valor null. A execucao nao vai prosseguir.");
                        System.exit(1);
                    } catch (ForadeLimitesExcepcao foradeLimitesExcepcao) {
                        System.out.println("Foi encontrado um valor fora dos limites. A execucao nao vai prosseguir.");
                        System.exit(1);
                    } catch (CodigoNaoValido codigoNaoValido) {
                        System.out.println("Foi encontrado um código não válido. A execucao nao vai prosseguir.");
                        System.exit(1);
                    }

                }
            }
        }else
        {return null;}
        return tbl;
    }



    /**
     * Ler informação de ficheiro CSV do plano alimentar atual
     * @param ficheiro String, nome do ficheiro a ler .
     * @param colAlimentos ColecaoAlimentos, informação nutricional dos alimentos
     * @param tipo String, tipo de plano alimentar
     */
    public static void lerPlanoAlimentar(String ficheiro,ColecaoAlimentos colAlimentos,String tipo) throws IOException {
        PlanoAlimentar planoAlimentar = null;
        LocalTime horaRef = null;
        Refeicao ref = null;
        String nomeref="";
        DateTimeFormatter parser = DateTimeFormatter.ofPattern("HH:mm:ss");

        if(tipo.equals("atual")){
           planoAlimentar = PlanoAlimentarAtual.getInstance();
        } else if(tipo.equals("prescrito")){
           planoAlimentar = PlanoAlimentarPrescrito.getInstance();}

        File f = new File(ficheiro);
        if (f.exists() && !f.isDirectory()) {
            List<String[]> linhas = lerCSV(ficheiro);

            if (!Arrays.equals(linhas.get(0), planoAlimentar.getOrdemHeader())) {
                System.out.println("Formato do ficheiro incorreto");
                System.exit(1);
            } else {
                System.out.println("Formato do ficheiro correto");
            }
            for (int linha = 1; linha < linhas.size(); linha++) {//percorre as linhas do ficheiro

                if (!linhas.get(linha)[0].equals("")&&!linhas.get(linha)[0].equals("#")) {
                    nomeref=linhas.get(linha)[0];
                    horaRef = LocalTime.parse(linhas.get(linha)[1] + ":00", parser);
                }

                ref = new Refeicao(nomeref, horaRef, colAlimentos);
                while (linha<linhas.size() && !linhas.get(linha)[0].equals("#")) {
                    if (linhas.get(linha)[2].contains("IS")) {
                        if (Utils.validaUnid(linhas.get(linha)[4])) {

                            try{
                               // ref.addProduto("IS025", 4.00, "ml");
                                ref.addProduto(linhas.get(linha)[2], Double.parseDouble( linhas.get(linha)[3].replace(",",".")), linhas.get(linha)[4]);

                            } catch (IllegalArgumentException e)
                            { if(e.getMessage().equals("Produto Inválido"))
                                throw new IllegalArgumentException("O produto "+linhas.get(linha)[2]+" não é válido");}

                            linha++;
                        } else {
                            throw new IllegalArgumentException("Unidade do Produto "+ linhas.get(linha)[2]+" inválida");

                        }

                    } else {
                        linha++;
                    }

                }
                try{
                    planoAlimentar.addRefeicao(ref);
                } catch (IllegalArgumentException e)
                { if(e.getMessage().equals("Refeição Inválida"))
                    throw new IllegalArgumentException("A Refeição "+ nomeref+" não é válida");} // significa que o texto da refeicao nao é valido
                catch(NullPointerException e){
                    if(e.getMessage().equals("Sem Produtos"))
                        throw new NullPointerException("Sem Produtos na refeição");}
                catch(Exception e){System.out.println(e.getMessage());}
            }
        }

    }


}
