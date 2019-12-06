package com.es2.Leitura;

import com.es2.Armazenamento.*;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertThrows;

public class LerCSVPacienteTest {

    RawDataPaciente rd = null;

    @BeforeEach
    private void construirRawDataDummy(){
        rd = new RawDataPaciente();

        rd.addElemento("Nome","Gervásio Palha");
        rd.addElemento("Idade","29");
        rd.addElemento("Altura","1,68");
        rd.addElemento("Peso","75");
        rd.addElemento("Profissão","Veterinário");
        rd.addElemento("Motivo da Consulta","Desconforto gástrico");
        rd.addElemento("Objectivos","Melhorar os sintomas, diminuir o peso e melhorar a qualidade geral de vida.");
        rd.addElemento("Patologias","N.d.");
        rd.addElemento("Medicação","Nenhuma");
        rd.addElemento("Antecedentes familiares","Mãe sofre muita azia ao fim de semana");
        rd.addElemento("Moderadamente Ativo","X");
        rd.addElemento("Normal","X");
        rd.addElemento("0.5L a 1L","X");
        rd.addElemento("IMC","26,57");
        rd.addElemento("B.F.","2");
        rd.addElemento("Gordura Visceral","14");
        rd.addElemento("Musculo","35");
        rd.addElemento("Idade Metabólica","30");
        rd.addElemento("H2O","15");
        rd.addElemento("Metabolismo Basal","21");
        rd.addElemento("Osso","23");
        rd.addElemento("Colesterol","224");
        rd.addElemento("Glicemia","91");
        rd.addElemento("Ureia","30");
        rd.addElemento("Creatinina","0,7");
        rd.addElemento("Proteina C Reactiva","0,1");
    }

    @Test
    public void leituraNomeNaoaceitavazios() {rd.substituirElementos("Nome",""); assertThrows(StringVaziaExcepcao.class, () -> new Paciente(rd));}

    @Test public void leituraIdadeNaoaceitavazios(){rd.substituirElementos("Idade",""); assertThrows(StringVaziaExcepcao.class, () -> new Paciente(rd));}
    @Test public void leituraAlturaNaoaceitavazios(){rd.substituirElementos("Altura",""); assertThrows(StringVaziaExcepcao.class, () -> new Paciente(rd));}
    @Test public void leituraPesoNaoaceitavazios(){rd.substituirElementos("Peso",""); assertThrows(StringVaziaExcepcao.class, () -> new Paciente(rd));}
    @Test public void leituraProfissaoNaoaceitavazios(){rd.substituirElementos("Profissão",""); assertThrows(StringVaziaExcepcao.class, () -> new Paciente(rd));}
    @Test public void leituraMotivoConsultaNaoaceitavazios(){rd.substituirElementos("Motivo da Consulta",""); assertThrows(StringVaziaExcepcao.class, () -> new Paciente(rd));}
    @Test public void leituraObjectivosNaoaceitavazios(){rd.substituirElementos("Objectivos",""); assertThrows(StringVaziaExcepcao.class, () -> new Paciente(rd));}
    @Test public void leituraPatologiasNaoaceitavazios(){rd.substituirElementos("Patologias",""); assertThrows(StringVaziaExcepcao.class, () -> new Paciente(rd));}
    @Test public void leituraMedicacaoNaoaceitavazios(){rd.substituirElementos("Medicação",""); assertThrows(StringVaziaExcepcao.class, () -> new Paciente(rd));}
    @Test public void leituraAntecedentesFamiliaresNaoaceitavazios(){rd.substituirElementos("Antecedentes familiares",""); assertThrows(StringVaziaExcepcao.class, () -> new Paciente(rd));}
    @Test public void leituraActividadeFisicaNaoaceitavazios(){rd.substituirElementos("Moderadamente Ativo",""); assertThrows(StringVaziaExcepcao.class, () -> new Paciente(rd));}
    @Test public void leituraConsumoaguaNaoaceitavazios(){rd.substituirElementos("0.5L a 1L",""); assertThrows(StringVaziaExcepcao.class, () -> new Paciente(rd));}
    @Test public void leituraIMCNaoaceitavazios(){rd.substituirElementos("IMC",""); assertThrows(StringVaziaExcepcao.class, () -> new Paciente(rd));}
    @Test public void leituraGorduraCorporalNaoaceitavazios(){rd.substituirElementos("B.F.",""); assertThrows(StringVaziaExcepcao.class, () -> new Paciente(rd));}
    @Test public void leituraGorduraVisceralNaoaceitavazios(){rd.substituirElementos("Gordura Visceral",""); assertThrows(StringVaziaExcepcao.class, () -> new Paciente(rd));}
    @Test public void leituraMusculoNaoaceitavazios(){rd.substituirElementos("Musculo",""); assertThrows(StringVaziaExcepcao.class, () -> new Paciente(rd));}
    @Test public void leituraIdadeMetabolicaNaoaceitavazios(){rd.substituirElementos("Idade Metabólica",""); assertThrows(StringVaziaExcepcao.class, () -> new Paciente(rd));}
    @Test public void leituraÁguaNaoaceitavazios(){rd.substituirElementos("H2O",""); assertThrows(StringVaziaExcepcao.class, () -> new Paciente(rd));}
    @Test public void leituraMetabolismoBasalNaoaceitavazios(){rd.substituirElementos("Metabolismo Basal",""); assertThrows(StringVaziaExcepcao.class, () -> new Paciente(rd));}
    @Test public void leituraOssoNaoaceitavazios(){rd.substituirElementos("Osso",""); assertThrows(StringVaziaExcepcao.class, () -> new Paciente(rd));}
    @Test public void leituraColesterolNaoaceitavazios(){rd.substituirElementos("Colesterol",""); assertThrows(StringVaziaExcepcao.class, () -> new Paciente(rd));}
    @Test public void leituraGlicemiaNaoaceitavazios(){rd.substituirElementos("Glicemia",""); assertThrows(StringVaziaExcepcao.class, () -> new Paciente(rd));}
    @Test public void leituraUreiaNaoaceitavazios(){rd.substituirElementos("Ureia",""); assertThrows(StringVaziaExcepcao.class, () -> new Paciente(rd));}
    @Test public void leituraCreatininaNaoaceitavazios(){rd.substituirElementos("Creatinina",""); assertThrows(StringVaziaExcepcao.class, () -> new Paciente(rd));}
    @Test public void leituraProteinaCReativaNaoaceitavazios(){rd.substituirElementos("Proteina C Reactiva",""); assertThrows(StringVaziaExcepcao.class, () -> new Paciente(rd));}


    @Test public void leituraIdadeNaoaceitanulls(){rd.substituirElementos("Idade",null); assertThrows(NullExcepcao.class, () -> new Paciente(rd));}
    @Test public void leituraAlturaNaoaceitanulls(){rd.substituirElementos("Altura",null); assertThrows(NullExcepcao.class, () -> new Paciente(rd));}
    @Test public void leituraPesoNaoaceitanulls(){rd.substituirElementos("Peso",null); assertThrows(NullExcepcao.class, () -> new Paciente(rd));}
    @Test public void leituraProfissaoNaoaceitanulls(){rd.substituirElementos("Profissão",null); assertThrows(NullExcepcao.class, () -> new Paciente(rd));}
    @Test public void leituraMotivoConsultaNaoaceitanulls(){rd.substituirElementos("Motivo da Consulta",null); assertThrows(NullExcepcao.class, () -> new Paciente(rd));}
    @Test public void leituraObjectivosNaoaceitanulls(){rd.substituirElementos("Objectivos",null); assertThrows(NullExcepcao.class, () -> new Paciente(rd));}
    @Test public void leituraPatologiasNaoaceitanulls(){rd.substituirElementos("Patologias",null); assertThrows(NullExcepcao.class, () -> new Paciente(rd));}
    @Test public void leituraMedicacaoNaoaceitanulls(){rd.substituirElementos("Medicação",null); assertThrows(NullExcepcao.class, () -> new Paciente(rd));}
    @Test public void leituraAntecedentesFamiliaresNaoaceitanulls(){rd.substituirElementos("Antecedentes familiares",null); assertThrows(NullExcepcao.class, () -> new Paciente(rd));}
    @Test public void leituraActividadeFisicaNaoaceitanulls(){rd.substituirElementos("Moderadamente Ativo",null); assertThrows(NullExcepcao.class, () -> new Paciente(rd));}
    @Test public void leituraConsumoaguaNaoaceitanulls(){rd.substituirElementos("0.5L a 1L",null); assertThrows(NullExcepcao.class, () -> new Paciente(rd));}
    @Test public void leituraIMCNaoaceitanulls(){rd.substituirElementos("IMC",null); assertThrows(NullExcepcao.class, () -> new Paciente(rd));}
    @Test public void leituraGorduraCorporalNaoaceitanulls(){rd.substituirElementos("B.F.",null); assertThrows(NullExcepcao.class, () -> new Paciente(rd));}
    @Test public void leituraGorduraVisceralNaoaceitanulls(){rd.substituirElementos("Gordura Visceral",null); assertThrows(NullExcepcao.class, () -> new Paciente(rd));}
    @Test public void leituraMusculoNaoaceitanulls(){rd.substituirElementos("Musculo",null); assertThrows(NullExcepcao.class, () -> new Paciente(rd));}
    @Test public void leituraIdadeMetabolicaNaoaceitanulls(){rd.substituirElementos("Idade Metabólica",null); assertThrows(NullExcepcao.class, () -> new Paciente(rd));}
    @Test public void leituraÁguaNaoaceitanulls(){rd.substituirElementos("H2O",null); assertThrows(NullExcepcao.class, () -> new Paciente(rd));}
    @Test public void leituraMetabolismoBasalNaoaceitanulls(){rd.substituirElementos("Metabolismo Basal",null); assertThrows(NullExcepcao.class, () -> new Paciente(rd));}
    @Test public void leituraOssoNaoaceitanulls(){rd.substituirElementos("Osso",null); assertThrows(NullExcepcao.class, () -> new Paciente(rd));}
    @Test public void leituraColesterolNaoaceitanulls(){rd.substituirElementos("Colesterol",null); assertThrows(NullExcepcao.class, () -> new Paciente(rd));}
    @Test public void leituraGlicemiaNaoaceitanulls(){rd.substituirElementos("Glicemia",null); assertThrows(NullExcepcao.class, () -> new Paciente(rd));}
    @Test public void leituraUreiaNaoaceitanulls(){rd.substituirElementos("Ureia",null); assertThrows(NullExcepcao.class, () -> new Paciente(rd));}
    @Test public void leituraCreatininaNaoaceitanulls(){rd.substituirElementos("Creatinina",null); assertThrows(NullExcepcao.class, () -> new Paciente(rd));}
    @Test public void leituraProteinaCReativaNaoaceitanulls(){rd.substituirElementos("Proteina C Reactiva",null); assertThrows(NullExcepcao.class, () -> new Paciente(rd));}

    @Test public void leituraNomeNaoaceitacaracteresnumericos(){rd.substituirElementos("Nome","a1c"); assertThrows(CaracteresIncorrectosExcepcao.class, () -> new Paciente(rd));}
    @Test public void leituraNomeAceitaStringSocomLetraseEspacos(){rd.substituirElementos("Nome","Antonio Fagundes");

        Paciente p = null;

        try {
            p = new Paciente(rd);
        } catch (CaracteresIncorrectosExcepcao caracteresIncorrectosExcepcao) {

        } catch (ForadeLimitesExcepcao foradeLimitesExcepcao) {

        } catch (StringVaziaExcepcao stringVaziaExcepcao) {

        } catch (NullExcepcao nullExcepcao) {

        } catch (ParametroAusenteExcepcao parametroAusenteExcepcao) {

        }

        assertEquals(p.getNome(),"Antonio Fagundes");
    }


    @Test public void leituraGorduraCorporalNaoAceitarAbaixodoValorInferior(){rd.substituirElementos("B.F.","-0.1"); assertThrows(ForadeLimitesExcepcao.class, () -> new Paciente(rd));}
    @Test public void leituraGorduraVisceralNaoAceitarAbaixodoValorInferior(){rd.substituirElementos("Gordura Visceral","-0.1"); assertThrows(ForadeLimitesExcepcao.class, () -> new Paciente(rd));}
    @Test public void leituraMusculoNaoAceitarAbaixodoValorInferior(){rd.substituirElementos("Musculo","-0.1"); assertThrows(ForadeLimitesExcepcao.class, () -> new Paciente(rd));}
    @Test public void leituraÁguaNaoAceitarAbaixodoValorInferior(){rd.substituirElementos("H2O","-0.1"); assertThrows(ForadeLimitesExcepcao.class, () -> new Paciente(rd));}
    @Test public void leituraMetabolismoBasalNaoAceitarAbaixodoValorInferior(){rd.substituirElementos("Metabolismo Basal","-0.1"); assertThrows(ForadeLimitesExcepcao.class, () -> new Paciente(rd));}
    @Test public void leituraOssoNaoAceitarAbaixodoValorInferior(){rd.substituirElementos("Osso","-0.1"); assertThrows(ForadeLimitesExcepcao.class, () -> new Paciente(rd));}
    @Test public void leituraColesterolNaoAceitarAbaixodoValorInferior(){rd.substituirElementos("Colesterol","-0.1"); assertThrows(ForadeLimitesExcepcao.class, () -> new Paciente(rd));}
    @Test public void leituraGlicemiaNaoAceitarAbaixodoValorInferior(){rd.substituirElementos("Glicemia","-0.1"); assertThrows(ForadeLimitesExcepcao.class, () -> new Paciente(rd));}
    @Test public void leituraUreiaNaoAceitarAbaixodoValorInferior(){rd.substituirElementos("Ureia","-0.1"); assertThrows(ForadeLimitesExcepcao.class, () -> new Paciente(rd));}
    @Test public void leituraCreatininaNaoAceitarAbaixodoValorInferior(){rd.substituirElementos("Creatinina","-0.1"); assertThrows(ForadeLimitesExcepcao.class, () -> new Paciente(rd));}
    @Test public void leituraProteinaCReativaNaoAceitarAbaixodoValorInferior(){rd.substituirElementos("Proteina C Reactiva","-0.1"); assertThrows(ForadeLimitesExcepcao.class, () -> new Paciente(rd));}


    @Test public void leituraGorduraCorporalNaoAceitarAcimadoValorSuperior(){rd.substituirElementos("B.F.","-0.1"); assertThrows(ForadeLimitesExcepcao.class, () -> new Paciente(rd));}
    @Test public void leituraGorduraVisceralNaoAceitarAcimadoValorSuperior(){rd.substituirElementos("Gordura Visceral","-0.1"); assertThrows(ForadeLimitesExcepcao.class, () -> new Paciente(rd));}
    @Test public void leituraMusculoNaoAceitarAcimadoValorSuperior(){rd.substituirElementos("Musculo","-0.1"); assertThrows(ForadeLimitesExcepcao.class, () -> new Paciente(rd));}
    @Test public void leituraÁguaNaoAceitarAcimadoValorSuperior(){rd.substituirElementos("H2O","-0.1"); assertThrows(ForadeLimitesExcepcao.class, () -> new Paciente(rd));}
    @Test public void leituraMetabolismoBasalNaoAceitarAcimadoValorSuperior(){rd.substituirElementos("Metabolismo Basal","-0.1"); assertThrows(ForadeLimitesExcepcao.class, () -> new Paciente(rd));}
    @Test public void leituraOssoNaoAceitarAcimadoValorSuperior(){rd.substituirElementos("Osso","-0.1"); assertThrows(ForadeLimitesExcepcao.class, () -> new Paciente(rd));}
    @Test public void leituraColesterolNaoAceitarAcimadoValorSuperior(){rd.substituirElementos("Colesterol","-0.1"); assertThrows(ForadeLimitesExcepcao.class, () -> new Paciente(rd));}
    @Test public void leituraGlicemiaNaoAceitarAcimadoValorSuperior(){rd.substituirElementos("Glicemia","-0.1"); assertThrows(ForadeLimitesExcepcao.class, () -> new Paciente(rd));}
    @Test public void leituraUreiaNaoAceitarAcimadoValorSuperior(){rd.substituirElementos("Ureia","-0.1"); assertThrows(ForadeLimitesExcepcao.class, () -> new Paciente(rd));}
    @Test public void leituraCreatininaNaoAceitarAcimadoValorSuperior(){rd.substituirElementos("Creatinina","-0.1"); assertThrows(ForadeLimitesExcepcao.class, () -> new Paciente(rd));}
    @Test public void leituraProteinaCReativaNaoAceitarAcimadoValorSuperior(){rd.substituirElementos("Proteina C Reactiva","-0.1"); assertThrows(ForadeLimitesExcepcao.class, () -> new Paciente(rd));}



}
