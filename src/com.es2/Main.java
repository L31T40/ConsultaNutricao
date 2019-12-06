package com.es2;
import com.es2.Armazenamento.*;
import com.es2.Escrita.EscreveCSV;

import com.es2.Armazenamento.ColecaoAlimentos;

import com.es2.Leitura.*;

import java.io.IOException;

import static java.lang.System.exit;


public class Main {

    public static void main(String[] args) throws IOException {



       //Carregar os dados do paciente
        System.out.println("Carregar dados do Paciente");
        Paciente p = null;
        try {
            p = new Paciente(LerCSV.lerCSVQuestionario("Files/consultanutricao.csv"));
        } catch (CaracteresIncorrectosExcepcao caracteresIncorrectosExcepcao) {
            caracteresIncorrectosExcepcao.printStackTrace();
        } catch (ForadeLimitesExcepcao foradeLimitesExcepcao) {
            foradeLimitesExcepcao.printStackTrace();
        } catch (StringVaziaExcepcao stringVaziaExcepcao) {
            System.out.println("Erro de String vazia. Parâmetro: " + stringVaziaExcepcao.getMessage());
        } catch (NullExcepcao nullExcepcao) {
            nullExcepcao.printStackTrace();
        } catch (ParametroAusenteExcepcao parametroAusenteExcepcao){
            parametroAusenteExcepcao.printStackTrace();}


        if(p == null) {
            System.out.println("Nao foi possivel ler os dados do Paciente");
            exit(1);
        }

        System.out.println("---Dados Paciente carregados---");

        //Carregar a tabela de alimentos
        ColecaoAlimentos c1= LerCSV.lerCSVTabela("Files/tabela.csv");
        if(c1 == null) {
            System.out.println("Nao foi possivel ler os dados dos alimentos");
            exit(1);
        }


        System.out.println("Carregar Tabela de Alimentos");
        LerCSV.lerCSVTabela("Files/tabela.csv");
        System.out.println("---Tabela Alimentos carregada---");


        System.out.println("#####################################################################################");
        System.out.println("LER Plano Alimentar");

        LerCSV.lerPlanoAlimentar("Files/PlanoAlimentarAtual.csv",c1,"atual");

        LerCSV.lerPlanoAlimentar("Files/PlanoAlimentarPrescrito.csv",c1,"prescrito");

        EscreveCSV x=new EscreveCSV();
        x.geraPlanoAlimentarSumario(p,c1);

        }

}
