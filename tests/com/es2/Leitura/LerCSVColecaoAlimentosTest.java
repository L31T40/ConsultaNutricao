package com.es2.Leitura;

import com.es2.Armazenamento.*;
import com.opencsv.CSVParser;
import com.opencsv.CSVParserBuilder;
import com.opencsv.CSVReader;
import com.opencsv.CSVReaderBuilder;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.TestInstance;
import org.junit.jupiter.api.TestInstance.Lifecycle;

import java.io.BufferedReader;
import java.io.IOException;
import java.nio.charset.StandardCharsets;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.List;

import static org.junit.jupiter.api.Assertions.*;


class LerCSVColecaoAlimentosTest {



    @Test
    public void testEnergiakcalNaoAceitarAbaixovalorInferior() {
        ColecaoAlimentos c = new ColecaoAlimentos();
        c.addHeaderTabela(new String[]{"Código", "PRODUTO", "Energia (kcal)", "Energia (kJ)", "Água (g)", "Proteína (g)", "Gordura total (g)", "Total HC disponíveis (g)", "Total HC expresso em monossacáridos (g)", "Mono + dissacáridos (g)", "Ácidos orgânicos (g)", "Álcool (g)", "Amido (g)", "Oligossacáridos (g)", "Fibra alimentar (g)", "Ácidos gordos saturados (g)", "Ácidos gordos monoinsaturados (g)", "Ácidos gordos polinsaturados  (g)", "Ácidos gordos trans (g)", "Ácido linoleico (g)", "Colesterol (mg)", "Retinol (vit. A total) (mg)", "Vit A total (equivalentes retinol) (mg)", "Caroteno (mg)", "vit. D (µg)", "a-tocoferol (mg)", "Tiamina (mg)", "Riboflavina (mg)", "Equivalentes de niacina (mg)", "Niacina (mg)", "Triptofano/60(mg)", "vit B6 (mg)", "Vit. B12 (µg)", "vit. C (mg)", "Folatos (µg)", "Cinza (g)", "Na (mg)", "K    (mg)", "Ca (mg)", "P (mg)", "Mg (mg)", "Fe (mg)", "Zn (mg)"});
        assertThrows(ForadeLimitesExcepcao.class, () -> c.addElemento(new String[]{"IS019", "Leite Cabra cru", "-0.1", "290", "86,9", "3,8", "4", "4,6", "4,8", "4,6", "0", "0", "0", "0", "0", "2,6", "1,1", "0,1", "0,1", "0,1", "11", "0,053", "53", "0", "0,05", "0,03", "0,05", "0,1", "1", "0,3", "0,7", "0,04", "0,08", "3", "1", "0,85", "40", "181", "153", "120", "20", "0,2", "0,3"}));
    }

    @Test
    public void testEnergiakJNaoAceitarAbaixovalorInferior
            () {
        ColecaoAlimentos c = new ColecaoAlimentos();
        c.addHeaderTabela(new String[]{"Código", "PRODUTO", "Energia (kcal)", "Energia (kJ)", "Água (g)", "Proteína (g)", "Gordura total (g)", "Total HC disponíveis (g)", "Total HC expresso em monossacáridos (g)", "Mono + dissacáridos (g)", "Ácidos orgânicos (g)", "Álcool (g)", "Amido (g)", "Oligossacáridos (g)", "Fibra alimentar (g)", "Ácidos gordos saturados (g)", "Ácidos gordos monoinsaturados (g)", "Ácidos gordos polinsaturados  (g)", "Ácidos gordos trans (g)", "Ácido linoleico (g)", "Colesterol (mg)", "Retinol (vit. A total) (mg)", "Vit A total (equivalentes retinol) (mg)", "Caroteno (mg)", "vit. D (µg)", "a-tocoferol (mg)", "Tiamina (mg)", "Riboflavina (mg)", "Equivalentes de niacina (mg)", "Niacina (mg)", "Triptofano/60(mg)", "vit B6 (mg)", "Vit. B12 (µg)", "vit. C (mg)", "Folatos (µg)", "Cinza (g)", "Na (mg)", "K    (mg)", "Ca (mg)", "P (mg)", "Mg (mg)", "Fe (mg)", "Zn (mg)"});
        assertThrows(ForadeLimitesExcepcao.class, () -> c.addElemento(new String[]{"IS019", "Leite Cabra cru", "2", "-0.1", "86,9", "3,8", "4", "4,6", "4,8", "4,6", "0", "0", "0", "0", "0", "2,6", "1,1", "0,1", "0,1", "0,1", "11", "0,053", "53", "0", "0,05", "0,03", "0,05", "0,1", "1", "0,3", "0,7", "0,04", "0,08", "3", "1", "0,85", "40", "181", "153", "120", "20", "0,2", "0,3"}));
    }

    @Test
    public void testaguagNaoAceitarAbaixovalorInferior
            () {
        ColecaoAlimentos c = new ColecaoAlimentos();
        c.addHeaderTabela(new String[]{"Código", "PRODUTO", "Energia (kcal)", "Energia (kJ)", "Água (g)", "Proteína (g)", "Gordura total (g)", "Total HC disponíveis (g)", "Total HC expresso em monossacáridos (g)", "Mono + dissacáridos (g)", "Ácidos orgânicos (g)", "Álcool (g)", "Amido (g)", "Oligossacáridos (g)", "Fibra alimentar (g)", "Ácidos gordos saturados (g)", "Ácidos gordos monoinsaturados (g)", "Ácidos gordos polinsaturados  (g)", "Ácidos gordos trans (g)", "Ácido linoleico (g)", "Colesterol (mg)", "Retinol (vit. A total) (mg)", "Vit A total (equivalentes retinol) (mg)", "Caroteno (mg)", "vit. D (µg)", "a-tocoferol (mg)", "Tiamina (mg)", "Riboflavina (mg)", "Equivalentes de niacina (mg)", "Niacina (mg)", "Triptofano/60(mg)", "vit B6 (mg)", "Vit. B12 (µg)", "vit. C (mg)", "Folatos (µg)", "Cinza (g)", "Na (mg)", "K    (mg)", "Ca (mg)", "P (mg)", "Mg (mg)", "Fe (mg)", "Zn (mg)"});
        assertThrows(ForadeLimitesExcepcao.class, () -> c.addElemento(new String[]{"IS019", "Leite Cabra cru", "2", "290", "-0.1", "3,8", "4", "4,6", "4,8", "4,6", "0", "0", "0", "0", "0", "2,6", "1,1", "0,1", "0,1", "0,1", "11", "0,053", "53", "0", "0,05", "0,03", "0,05", "0,1", "1", "0,3", "0,7", "0,04", "0,08", "3", "1", "0,85", "40", "181", "153", "120", "20", "0,2", "0,3"}));
    }

    @Test
    public void testProteínagNaoAceitarAbaixovalorInferior
            () {
        ColecaoAlimentos c = new ColecaoAlimentos();
        c.addHeaderTabela(new String[]{"Código", "PRODUTO", "Energia (kcal)", "Energia (kJ)", "Água (g)", "Proteína (g)", "Gordura total (g)", "Total HC disponíveis (g)", "Total HC expresso em monossacáridos (g)", "Mono + dissacáridos (g)", "Ácidos orgânicos (g)", "Álcool (g)", "Amido (g)", "Oligossacáridos (g)", "Fibra alimentar (g)", "Ácidos gordos saturados (g)", "Ácidos gordos monoinsaturados (g)", "Ácidos gordos polinsaturados  (g)", "Ácidos gordos trans (g)", "Ácido linoleico (g)", "Colesterol (mg)", "Retinol (vit. A total) (mg)", "Vit A total (equivalentes retinol) (mg)", "Caroteno (mg)", "vit. D (µg)", "a-tocoferol (mg)", "Tiamina (mg)", "Riboflavina (mg)", "Equivalentes de niacina (mg)", "Niacina (mg)", "Triptofano/60(mg)", "vit B6 (mg)", "Vit. B12 (µg)", "vit. C (mg)", "Folatos (µg)", "Cinza (g)", "Na (mg)", "K    (mg)", "Ca (mg)", "P (mg)", "Mg (mg)", "Fe (mg)", "Zn (mg)"});
        assertThrows(ForadeLimitesExcepcao.class, () -> c.addElemento(new String[]{"IS019", "Leite Cabra cru", "2", "290", "86,9", "-0.1", "4", "4,6", "4,8", "4,6", "0", "0", "0", "0", "0", "2,6", "1,1", "0,1", "0,1", "0,1", "11", "0,053", "53", "0", "0,05", "0,03", "0,05", "0,1", "1", "0,3", "0,7", "0,04", "0,08", "3", "1", "0,85", "40", "181", "153", "120", "20", "0,2", "0,3"}));
    }

    @Test
    public void testGorduratotalgNaoAceitarAbaixovalorInferior
            () {
        ColecaoAlimentos c = new ColecaoAlimentos();
        c.addHeaderTabela(new String[]{"Código", "PRODUTO", "Energia (kcal)", "Energia (kJ)", "Água (g)", "Proteína (g)", "Gordura total (g)", "Total HC disponíveis (g)", "Total HC expresso em monossacáridos (g)", "Mono + dissacáridos (g)", "Ácidos orgânicos (g)", "Álcool (g)", "Amido (g)", "Oligossacáridos (g)", "Fibra alimentar (g)", "Ácidos gordos saturados (g)", "Ácidos gordos monoinsaturados (g)", "Ácidos gordos polinsaturados  (g)", "Ácidos gordos trans (g)", "Ácido linoleico (g)", "Colesterol (mg)", "Retinol (vit. A total) (mg)", "Vit A total (equivalentes retinol) (mg)", "Caroteno (mg)", "vit. D (µg)", "a-tocoferol (mg)", "Tiamina (mg)", "Riboflavina (mg)", "Equivalentes de niacina (mg)", "Niacina (mg)", "Triptofano/60(mg)", "vit B6 (mg)", "Vit. B12 (µg)", "vit. C (mg)", "Folatos (µg)", "Cinza (g)", "Na (mg)", "K    (mg)", "Ca (mg)", "P (mg)", "Mg (mg)", "Fe (mg)", "Zn (mg)"});
        assertThrows(ForadeLimitesExcepcao.class, () -> c.addElemento(new String[]{"IS019", "Leite Cabra cru", "2", "290", "86,9", "3,8", "-0.1", "4,6", "4,8", "4,6", "0", "0", "0", "0", "0", "2,6", "1,1", "0,1", "0,1", "0,1", "11", "0,053", "53", "0", "0,05", "0,03", "0,05", "0,1", "1", "0,3", "0,7", "0,04", "0,08", "3", "1", "0,85", "40", "181", "153", "120", "20", "0,2", "0,3"}));
    }

    @Test
    public void testTotalHCdisponíveisgNaoAceitarAbaixovalorInferior
            () {
        ColecaoAlimentos c = new ColecaoAlimentos();
        c.addHeaderTabela(new String[]{"Código", "PRODUTO", "Energia (kcal)", "Energia (kJ)", "Água (g)", "Proteína (g)", "Gordura total (g)", "Total HC disponíveis (g)", "Total HC expresso em monossacáridos (g)", "Mono + dissacáridos (g)", "Ácidos orgânicos (g)", "Álcool (g)", "Amido (g)", "Oligossacáridos (g)", "Fibra alimentar (g)", "Ácidos gordos saturados (g)", "Ácidos gordos monoinsaturados (g)", "Ácidos gordos polinsaturados  (g)", "Ácidos gordos trans (g)", "Ácido linoleico (g)", "Colesterol (mg)", "Retinol (vit. A total) (mg)", "Vit A total (equivalentes retinol) (mg)", "Caroteno (mg)", "vit. D (µg)", "a-tocoferol (mg)", "Tiamina (mg)", "Riboflavina (mg)", "Equivalentes de niacina (mg)", "Niacina (mg)", "Triptofano/60(mg)", "vit B6 (mg)", "Vit. B12 (µg)", "vit. C (mg)", "Folatos (µg)", "Cinza (g)", "Na (mg)", "K    (mg)", "Ca (mg)", "P (mg)", "Mg (mg)", "Fe (mg)", "Zn (mg)"});
        assertThrows(ForadeLimitesExcepcao.class, () -> c.addElemento(new String[]{"IS019", "Leite Cabra cru", "2", "290", "86,9", "3,8", "4", "-0.1", "4,8", "4,6", "0", "0", "0", "0", "0", "2,6", "1,1", "0,1", "0,1", "0,1", "11", "0,053", "53", "0", "0,05", "0,03", "0,05", "0,1", "1", "0,3", "0,7", "0,04", "0,08", "3", "1", "0,85", "40", "181", "153", "120", "20", "0,2", "0,3"}));
    }

    @Test
    public void testTotalHCexpressoemmonossacaridosgNaoAceitarAbaixovalorInferior
            () {
        ColecaoAlimentos c = new ColecaoAlimentos();
        c.addHeaderTabela(new String[]{"Código", "PRODUTO", "Energia (kcal)", "Energia (kJ)", "Água (g)", "Proteína (g)", "Gordura total (g)", "Total HC disponíveis (g)", "Total HC expresso em monossacáridos (g)", "Mono + dissacáridos (g)", "Ácidos orgânicos (g)", "Álcool (g)", "Amido (g)", "Oligossacáridos (g)", "Fibra alimentar (g)", "Ácidos gordos saturados (g)", "Ácidos gordos monoinsaturados (g)", "Ácidos gordos polinsaturados  (g)", "Ácidos gordos trans (g)", "Ácido linoleico (g)", "Colesterol (mg)", "Retinol (vit. A total) (mg)", "Vit A total (equivalentes retinol) (mg)", "Caroteno (mg)", "vit. D (µg)", "a-tocoferol (mg)", "Tiamina (mg)", "Riboflavina (mg)", "Equivalentes de niacina (mg)", "Niacina (mg)", "Triptofano/60(mg)", "vit B6 (mg)", "Vit. B12 (µg)", "vit. C (mg)", "Folatos (µg)", "Cinza (g)", "Na (mg)", "K    (mg)", "Ca (mg)", "P (mg)", "Mg (mg)", "Fe (mg)", "Zn (mg)"});
        assertThrows(ForadeLimitesExcepcao.class, () -> c.addElemento(new String[]{"IS019", "Leite Cabra cru", "2", "290", "86,9", "3,8", "4", "4,6", "-0.1", "4,6", "0", "0", "0", "0", "0", "2,6", "1,1", "0,1", "0,1", "0,1", "11", "0,053", "53", "0", "0,05", "0,03", "0,05", "0,1", "1", "0,3", "0,7", "0,04", "0,08", "3", "1", "0,85", "40", "181", "153", "120", "20", "0,2", "0,3"}));
    }

    @Test
    public void testMonodissacaridosgNaoAceitarAbaixovalorInferior
            () {
        ColecaoAlimentos c = new ColecaoAlimentos();
        c.addHeaderTabela(new String[]{"Código", "PRODUTO", "Energia (kcal)", "Energia (kJ)", "Água (g)", "Proteína (g)", "Gordura total (g)", "Total HC disponíveis (g)", "Total HC expresso em monossacáridos (g)", "Mono + dissacáridos (g)", "Ácidos orgânicos (g)", "Álcool (g)", "Amido (g)", "Oligossacáridos (g)", "Fibra alimentar (g)", "Ácidos gordos saturados (g)", "Ácidos gordos monoinsaturados (g)", "Ácidos gordos polinsaturados  (g)", "Ácidos gordos trans (g)", "Ácido linoleico (g)", "Colesterol (mg)", "Retinol (vit. A total) (mg)", "Vit A total (equivalentes retinol) (mg)", "Caroteno (mg)", "vit. D (µg)", "a-tocoferol (mg)", "Tiamina (mg)", "Riboflavina (mg)", "Equivalentes de niacina (mg)", "Niacina (mg)", "Triptofano/60(mg)", "vit B6 (mg)", "Vit. B12 (µg)", "vit. C (mg)", "Folatos (µg)", "Cinza (g)", "Na (mg)", "K    (mg)", "Ca (mg)", "P (mg)", "Mg (mg)", "Fe (mg)", "Zn (mg)"});
        assertThrows(ForadeLimitesExcepcao.class, () -> c.addElemento(new String[]{"IS019", "Leite Cabra cru", "2", "290", "86,9", "3,8", "4", "4,6", "4,8", "-0.1", "0", "0", "0", "0", "0", "2,6", "1,1", "0,1", "0,1", "0,1", "11", "0,053", "53", "0", "0,05", "0,03", "0,05", "0,1", "1", "0,3", "0,7", "0,04", "0,08", "3", "1", "0,85", "40", "181", "153", "120", "20", "0,2", "0,3"}));
    }

    @Test
    public void testacidosorgânicosgNaoAceitarAbaixovalorInferior
            () {
        ColecaoAlimentos c = new ColecaoAlimentos();
        c.addHeaderTabela(new String[]{"Código", "PRODUTO", "Energia (kcal)", "Energia (kJ)", "Água (g)", "Proteína (g)", "Gordura total (g)", "Total HC disponíveis (g)", "Total HC expresso em monossacáridos (g)", "Mono + dissacáridos (g)", "Ácidos orgânicos (g)", "Álcool (g)", "Amido (g)", "Oligossacáridos (g)", "Fibra alimentar (g)", "Ácidos gordos saturados (g)", "Ácidos gordos monoinsaturados (g)", "Ácidos gordos polinsaturados  (g)", "Ácidos gordos trans (g)", "Ácido linoleico (g)", "Colesterol (mg)", "Retinol (vit. A total) (mg)", "Vit A total (equivalentes retinol) (mg)", "Caroteno (mg)", "vit. D (µg)", "a-tocoferol (mg)", "Tiamina (mg)", "Riboflavina (mg)", "Equivalentes de niacina (mg)", "Niacina (mg)", "Triptofano/60(mg)", "vit B6 (mg)", "Vit. B12 (µg)", "vit. C (mg)", "Folatos (µg)", "Cinza (g)", "Na (mg)", "K    (mg)", "Ca (mg)", "P (mg)", "Mg (mg)", "Fe (mg)", "Zn (mg)"});
        assertThrows(ForadeLimitesExcepcao.class, () -> c.addElemento(new String[]{"IS019", "Leite Cabra cru", "2", "290", "86,9", "3,8", "4", "4,6", "4,8", "4,6", "-0.1", "0", "0", "0", "0", "2,6", "1,1", "0,1", "0,1", "0,1", "11", "0,053", "53", "0", "0,05", "0,03", "0,05", "0,1", "1", "0,3", "0,7", "0,04", "0,08", "3", "1", "0,85", "40", "181", "153", "120", "20", "0,2", "0,3"}));
    }

    @Test
    public void testalcoolgNaoAceitarAbaixovalorInferior
            () {
        ColecaoAlimentos c = new ColecaoAlimentos();
        c.addHeaderTabela(new String[]{"Código", "PRODUTO", "Energia (kcal)", "Energia (kJ)", "Água (g)", "Proteína (g)", "Gordura total (g)", "Total HC disponíveis (g)", "Total HC expresso em monossacáridos (g)", "Mono + dissacáridos (g)", "Ácidos orgânicos (g)", "Álcool (g)", "Amido (g)", "Oligossacáridos (g)", "Fibra alimentar (g)", "Ácidos gordos saturados (g)", "Ácidos gordos monoinsaturados (g)", "Ácidos gordos polinsaturados  (g)", "Ácidos gordos trans (g)", "Ácido linoleico (g)", "Colesterol (mg)", "Retinol (vit. A total) (mg)", "Vit A total (equivalentes retinol) (mg)", "Caroteno (mg)", "vit. D (µg)", "a-tocoferol (mg)", "Tiamina (mg)", "Riboflavina (mg)", "Equivalentes de niacina (mg)", "Niacina (mg)", "Triptofano/60(mg)", "vit B6 (mg)", "Vit. B12 (µg)", "vit. C (mg)", "Folatos (µg)", "Cinza (g)", "Na (mg)", "K    (mg)", "Ca (mg)", "P (mg)", "Mg (mg)", "Fe (mg)", "Zn (mg)"});
        assertThrows(ForadeLimitesExcepcao.class, () -> c.addElemento(new String[]{"IS019", "Leite Cabra cru", "2", "290", "86,9", "3,8", "4", "4,6", "4,8", "4,6", "0", "-0.1", "0", "0", "0", "2,6", "1,1", "0,1", "0,1", "0,1", "11", "0,053", "53", "0", "0,05", "0,03", "0,05", "0,1", "1", "0,3", "0,7", "0,04", "0,08", "3", "1", "0,85", "40", "181", "153", "120", "20", "0,2", "0,3"}));
    }

    @Test
    public void testAmidogNaoAceitarAbaixovalorInferior
            () {
        ColecaoAlimentos c = new ColecaoAlimentos();
        c.addHeaderTabela(new String[]{"Código", "PRODUTO", "Energia (kcal)", "Energia (kJ)", "Água (g)", "Proteína (g)", "Gordura total (g)", "Total HC disponíveis (g)", "Total HC expresso em monossacáridos (g)", "Mono + dissacáridos (g)", "Ácidos orgânicos (g)", "Álcool (g)", "Amido (g)", "Oligossacáridos (g)", "Fibra alimentar (g)", "Ácidos gordos saturados (g)", "Ácidos gordos monoinsaturados (g)", "Ácidos gordos polinsaturados  (g)", "Ácidos gordos trans (g)", "Ácido linoleico (g)", "Colesterol (mg)", "Retinol (vit. A total) (mg)", "Vit A total (equivalentes retinol) (mg)", "Caroteno (mg)", "vit. D (µg)", "a-tocoferol (mg)", "Tiamina (mg)", "Riboflavina (mg)", "Equivalentes de niacina (mg)", "Niacina (mg)", "Triptofano/60(mg)", "vit B6 (mg)", "Vit. B12 (µg)", "vit. C (mg)", "Folatos (µg)", "Cinza (g)", "Na (mg)", "K    (mg)", "Ca (mg)", "P (mg)", "Mg (mg)", "Fe (mg)", "Zn (mg)"});
        assertThrows(ForadeLimitesExcepcao.class, () -> c.addElemento(new String[]{"IS019", "Leite Cabra cru", "2", "290", "86,9", "3,8", "4", "4,6", "4,8", "4,6", "0", "0", "-0.1", "0", "0", "2,6", "1,1", "0,1", "0,1", "0,1", "11", "0,053", "53", "0", "0,05", "0,03", "0,05", "0,1", "1", "0,3", "0,7", "0,04", "0,08", "3", "1", "0,85", "40", "181", "153", "120", "20", "0,2", "0,3"}));
    }

    @Test
    public void testOligossacaridosgNaoAceitarAbaixovalorInferior
            () {
        ColecaoAlimentos c = new ColecaoAlimentos();
        c.addHeaderTabela(new String[]{"Código", "PRODUTO", "Energia (kcal)", "Energia (kJ)", "Água (g)", "Proteína (g)", "Gordura total (g)", "Total HC disponíveis (g)", "Total HC expresso em monossacáridos (g)", "Mono + dissacáridos (g)", "Ácidos orgânicos (g)", "Álcool (g)", "Amido (g)", "Oligossacáridos (g)", "Fibra alimentar (g)", "Ácidos gordos saturados (g)", "Ácidos gordos monoinsaturados (g)", "Ácidos gordos polinsaturados  (g)", "Ácidos gordos trans (g)", "Ácido linoleico (g)", "Colesterol (mg)", "Retinol (vit. A total) (mg)", "Vit A total (equivalentes retinol) (mg)", "Caroteno (mg)", "vit. D (µg)", "a-tocoferol (mg)", "Tiamina (mg)", "Riboflavina (mg)", "Equivalentes de niacina (mg)", "Niacina (mg)", "Triptofano/60(mg)", "vit B6 (mg)", "Vit. B12 (µg)", "vit. C (mg)", "Folatos (µg)", "Cinza (g)", "Na (mg)", "K    (mg)", "Ca (mg)", "P (mg)", "Mg (mg)", "Fe (mg)", "Zn (mg)"});
        assertThrows(ForadeLimitesExcepcao.class, () -> c.addElemento(new String[]{"IS019", "Leite Cabra cru", "2", "290", "86,9", "3,8", "4", "4,6", "4,8", "4,6", "0", "0", "0", "-0.1", "0", "2,6", "1,1", "0,1", "0,1", "0,1", "11", "0,053", "53", "0", "0,05", "0,03", "0,05", "0,1", "1", "0,3", "0,7", "0,04", "0,08", "3", "1", "0,85", "40", "181", "153", "120", "20", "0,2", "0,3"}));
    }

    @Test
    public void testFibraalimentargNaoAceitarAbaixovalorInferior
            () {
        ColecaoAlimentos c = new ColecaoAlimentos();
        c.addHeaderTabela(new String[]{"Código", "PRODUTO", "Energia (kcal)", "Energia (kJ)", "Água (g)", "Proteína (g)", "Gordura total (g)", "Total HC disponíveis (g)", "Total HC expresso em monossacáridos (g)", "Mono + dissacáridos (g)", "Ácidos orgânicos (g)", "Álcool (g)", "Amido (g)", "Oligossacáridos (g)", "Fibra alimentar (g)", "Ácidos gordos saturados (g)", "Ácidos gordos monoinsaturados (g)", "Ácidos gordos polinsaturados  (g)", "Ácidos gordos trans (g)", "Ácido linoleico (g)", "Colesterol (mg)", "Retinol (vit. A total) (mg)", "Vit A total (equivalentes retinol) (mg)", "Caroteno (mg)", "vit. D (µg)", "a-tocoferol (mg)", "Tiamina (mg)", "Riboflavina (mg)", "Equivalentes de niacina (mg)", "Niacina (mg)", "Triptofano/60(mg)", "vit B6 (mg)", "Vit. B12 (µg)", "vit. C (mg)", "Folatos (µg)", "Cinza (g)", "Na (mg)", "K    (mg)", "Ca (mg)", "P (mg)", "Mg (mg)", "Fe (mg)", "Zn (mg)"});
        assertThrows(ForadeLimitesExcepcao.class, () -> c.addElemento(new String[]{"IS019", "Leite Cabra cru", "2", "290", "86,9", "3,8", "4", "4,6", "4,8", "4,6", "0", "0", "0", "0", "-0.1", "2,6", "1,1", "0,1", "0,1", "0,1", "11", "0,053", "53", "0", "0,05", "0,03", "0,05", "0,1", "1", "0,3", "0,7", "0,04", "0,08", "3", "1", "0,85", "40", "181", "153", "120", "20", "0,2", "0,3"}));
    }

    @Test
    public void testacidosgordossaturadosgNaoAceitarAbaixovalorInferior
            () {
        ColecaoAlimentos c = new ColecaoAlimentos();
        c.addHeaderTabela(new String[]{"Código", "PRODUTO", "Energia (kcal)", "Energia (kJ)", "Água (g)", "Proteína (g)", "Gordura total (g)", "Total HC disponíveis (g)", "Total HC expresso em monossacáridos (g)", "Mono + dissacáridos (g)", "Ácidos orgânicos (g)", "Álcool (g)", "Amido (g)", "Oligossacáridos (g)", "Fibra alimentar (g)", "Ácidos gordos saturados (g)", "Ácidos gordos monoinsaturados (g)", "Ácidos gordos polinsaturados  (g)", "Ácidos gordos trans (g)", "Ácido linoleico (g)", "Colesterol (mg)", "Retinol (vit. A total) (mg)", "Vit A total (equivalentes retinol) (mg)", "Caroteno (mg)", "vit. D (µg)", "a-tocoferol (mg)", "Tiamina (mg)", "Riboflavina (mg)", "Equivalentes de niacina (mg)", "Niacina (mg)", "Triptofano/60(mg)", "vit B6 (mg)", "Vit. B12 (µg)", "vit. C (mg)", "Folatos (µg)", "Cinza (g)", "Na (mg)", "K    (mg)", "Ca (mg)", "P (mg)", "Mg (mg)", "Fe (mg)", "Zn (mg)"});
        assertThrows(ForadeLimitesExcepcao.class, () -> c.addElemento(new String[]{"IS019", "Leite Cabra cru", "2", "290", "86,9", "3,8", "4", "4,6", "4,8", "4,6", "0", "0", "0", "0", "0", "-0.1", "1,1", "0,1", "0,1", "0,1", "11", "0,053", "53", "0", "0,05", "0,03", "0,05", "0,1", "1", "0,3", "0,7", "0,04", "0,08", "3", "1", "0,85", "40", "181", "153", "120", "20", "0,2", "0,3"}));
    }

    @Test
    public void testacidosgordosmonoinsaturadosgNaoAceitarAbaixovalorInferior
            () {
        ColecaoAlimentos c = new ColecaoAlimentos();
        c.addHeaderTabela(new String[]{"Código", "PRODUTO", "Energia (kcal)", "Energia (kJ)", "Água (g)", "Proteína (g)", "Gordura total (g)", "Total HC disponíveis (g)", "Total HC expresso em monossacáridos (g)", "Mono + dissacáridos (g)", "Ácidos orgânicos (g)", "Álcool (g)", "Amido (g)", "Oligossacáridos (g)", "Fibra alimentar (g)", "Ácidos gordos saturados (g)", "Ácidos gordos monoinsaturados (g)", "Ácidos gordos polinsaturados  (g)", "Ácidos gordos trans (g)", "Ácido linoleico (g)", "Colesterol (mg)", "Retinol (vit. A total) (mg)", "Vit A total (equivalentes retinol) (mg)", "Caroteno (mg)", "vit. D (µg)", "a-tocoferol (mg)", "Tiamina (mg)", "Riboflavina (mg)", "Equivalentes de niacina (mg)", "Niacina (mg)", "Triptofano/60(mg)", "vit B6 (mg)", "Vit. B12 (µg)", "vit. C (mg)", "Folatos (µg)", "Cinza (g)", "Na (mg)", "K    (mg)", "Ca (mg)", "P (mg)", "Mg (mg)", "Fe (mg)", "Zn (mg)"});
        assertThrows(ForadeLimitesExcepcao.class, () -> c.addElemento(new String[]{"IS019", "Leite Cabra cru", "2", "290", "86,9", "3,8", "4", "4,6", "4,8", "4,6", "0", "0", "0", "0", "0", "2,6", "-0.1", "0,1", "0,1", "0,1", "11", "0,053", "53", "0", "0,05", "0,03", "0,05", "0,1", "1", "0,3", "0,7", "0,04", "0,08", "3", "1", "0,85", "40", "181", "153", "120", "20", "0,2", "0,3"}));
    }

    @Test
    public void testacidosgordospolinsaturadosgNaoAceitarAbaixovalorInferior
            () {
        ColecaoAlimentos c = new ColecaoAlimentos();
        c.addHeaderTabela(new String[]{"Código", "PRODUTO", "Energia (kcal)", "Energia (kJ)", "Água (g)", "Proteína (g)", "Gordura total (g)", "Total HC disponíveis (g)", "Total HC expresso em monossacáridos (g)", "Mono + dissacáridos (g)", "Ácidos orgânicos (g)", "Álcool (g)", "Amido (g)", "Oligossacáridos (g)", "Fibra alimentar (g)", "Ácidos gordos saturados (g)", "Ácidos gordos monoinsaturados (g)", "Ácidos gordos polinsaturados  (g)", "Ácidos gordos trans (g)", "Ácido linoleico (g)", "Colesterol (mg)", "Retinol (vit. A total) (mg)", "Vit A total (equivalentes retinol) (mg)", "Caroteno (mg)", "vit. D (µg)", "a-tocoferol (mg)", "Tiamina (mg)", "Riboflavina (mg)", "Equivalentes de niacina (mg)", "Niacina (mg)", "Triptofano/60(mg)", "vit B6 (mg)", "Vit. B12 (µg)", "vit. C (mg)", "Folatos (µg)", "Cinza (g)", "Na (mg)", "K    (mg)", "Ca (mg)", "P (mg)", "Mg (mg)", "Fe (mg)", "Zn (mg)"});
        assertThrows(ForadeLimitesExcepcao.class, () -> c.addElemento(new String[]{"IS019", "Leite Cabra cru", "2", "290", "86,9", "3,8", "4", "4,6", "4,8", "4,6", "0", "0", "0", "0", "0", "2,6", "1,1", "-0.1", "0,1", "0,1", "11", "0,053", "53", "0", "0,05", "0,03", "0,05", "0,1", "1", "0,3", "0,7", "0,04", "0,08", "3", "1", "0,85", "40", "181", "153", "120", "20", "0,2", "0,3"}));
    }

    @Test
    public void testacidosgordostransgNaoAceitarAbaixovalorInferior
            () {
        ColecaoAlimentos c = new ColecaoAlimentos();
        c.addHeaderTabela(new String[]{"Código", "PRODUTO", "Energia (kcal)", "Energia (kJ)", "Água (g)", "Proteína (g)", "Gordura total (g)", "Total HC disponíveis (g)", "Total HC expresso em monossacáridos (g)", "Mono + dissacáridos (g)", "Ácidos orgânicos (g)", "Álcool (g)", "Amido (g)", "Oligossacáridos (g)", "Fibra alimentar (g)", "Ácidos gordos saturados (g)", "Ácidos gordos monoinsaturados (g)", "Ácidos gordos polinsaturados  (g)", "Ácidos gordos trans (g)", "Ácido linoleico (g)", "Colesterol (mg)", "Retinol (vit. A total) (mg)", "Vit A total (equivalentes retinol) (mg)", "Caroteno (mg)", "vit. D (µg)", "a-tocoferol (mg)", "Tiamina (mg)", "Riboflavina (mg)", "Equivalentes de niacina (mg)", "Niacina (mg)", "Triptofano/60(mg)", "vit B6 (mg)", "Vit. B12 (µg)", "vit. C (mg)", "Folatos (µg)", "Cinza (g)", "Na (mg)", "K    (mg)", "Ca (mg)", "P (mg)", "Mg (mg)", "Fe (mg)", "Zn (mg)"});
        assertThrows(ForadeLimitesExcepcao.class, () -> c.addElemento(new String[]{"IS019", "Leite Cabra cru", "2", "290", "86,9", "3,8", "4", "4,6", "4,8", "4,6", "0", "0", "0", "0", "0", "2,6", "1,1", "0,1", "-0.1", "0,1", "11", "0,053", "53", "0", "0,05", "0,03", "0,05", "0,1", "1", "0,3", "0,7", "0,04", "0,08", "3", "1", "0,85", "40", "181", "153", "120", "20", "0,2", "0,3"}));
    }

    @Test
    public void testacidolinoleicogNaoAceitarAbaixovalorInferior
            () {
        ColecaoAlimentos c = new ColecaoAlimentos();
        c.addHeaderTabela(new String[]{"Código", "PRODUTO", "Energia (kcal)", "Energia (kJ)", "Água (g)", "Proteína (g)", "Gordura total (g)", "Total HC disponíveis (g)", "Total HC expresso em monossacáridos (g)", "Mono + dissacáridos (g)", "Ácidos orgânicos (g)", "Álcool (g)", "Amido (g)", "Oligossacáridos (g)", "Fibra alimentar (g)", "Ácidos gordos saturados (g)", "Ácidos gordos monoinsaturados (g)", "Ácidos gordos polinsaturados  (g)", "Ácidos gordos trans (g)", "Ácido linoleico (g)", "Colesterol (mg)", "Retinol (vit. A total) (mg)", "Vit A total (equivalentes retinol) (mg)", "Caroteno (mg)", "vit. D (µg)", "a-tocoferol (mg)", "Tiamina (mg)", "Riboflavina (mg)", "Equivalentes de niacina (mg)", "Niacina (mg)", "Triptofano/60(mg)", "vit B6 (mg)", "Vit. B12 (µg)", "vit. C (mg)", "Folatos (µg)", "Cinza (g)", "Na (mg)", "K    (mg)", "Ca (mg)", "P (mg)", "Mg (mg)", "Fe (mg)", "Zn (mg)"});
        assertThrows(ForadeLimitesExcepcao.class, () -> c.addElemento(new String[]{"IS019", "Leite Cabra cru", "2", "290", "86,9", "3,8", "4", "4,6", "4,8", "4,6", "0", "0", "0", "0", "0", "2,6", "1,1", "0,1", "0,1", "-0.1", "11", "0,053", "53", "0", "0,05", "0,03", "0,05", "0,1", "1", "0,3", "0,7", "0,04", "0,08", "3", "1", "0,85", "40", "181", "153", "120", "20", "0,2", "0,3"}));
    }

    @Test
    public void testColesterolmgNaoAceitarAbaixovalorInferior
            () {
        ColecaoAlimentos c = new ColecaoAlimentos();
        c.addHeaderTabela(new String[]{"Código", "PRODUTO", "Energia (kcal)", "Energia (kJ)", "Água (g)", "Proteína (g)", "Gordura total (g)", "Total HC disponíveis (g)", "Total HC expresso em monossacáridos (g)", "Mono + dissacáridos (g)", "Ácidos orgânicos (g)", "Álcool (g)", "Amido (g)", "Oligossacáridos (g)", "Fibra alimentar (g)", "Ácidos gordos saturados (g)", "Ácidos gordos monoinsaturados (g)", "Ácidos gordos polinsaturados  (g)", "Ácidos gordos trans (g)", "Ácido linoleico (g)", "Colesterol (mg)", "Retinol (vit. A total) (mg)", "Vit A total (equivalentes retinol) (mg)", "Caroteno (mg)", "vit. D (µg)", "a-tocoferol (mg)", "Tiamina (mg)", "Riboflavina (mg)", "Equivalentes de niacina (mg)", "Niacina (mg)", "Triptofano/60(mg)", "vit B6 (mg)", "Vit. B12 (µg)", "vit. C (mg)", "Folatos (µg)", "Cinza (g)", "Na (mg)", "K    (mg)", "Ca (mg)", "P (mg)", "Mg (mg)", "Fe (mg)", "Zn (mg)"});
        assertThrows(ForadeLimitesExcepcao.class, () -> c.addElemento(new String[]{"IS019", "Leite Cabra cru", "2", "290", "86,9", "3,8", "4", "4,6", "4,8", "4,6", "0", "0", "0", "0", "0", "2,6", "1,1", "0,1", "0,1", "0,1", "-0.1", "0,053", "53", "0", "0,05", "0,03", "0,05", "0,1", "1", "0,3", "0,7", "0,04", "0,08", "3", "1", "0,85", "40", "181", "153", "120", "20", "0,2", "0,3"}));
    }

    @Test
    public void testRetinolvitAtotalmgNaoAceitarAbaixovalorInferior
            () {
        ColecaoAlimentos c = new ColecaoAlimentos();
        c.addHeaderTabela(new String[]{"Código", "PRODUTO", "Energia (kcal)", "Energia (kJ)", "Água (g)", "Proteína (g)", "Gordura total (g)", "Total HC disponíveis (g)", "Total HC expresso em monossacáridos (g)", "Mono + dissacáridos (g)", "Ácidos orgânicos (g)", "Álcool (g)", "Amido (g)", "Oligossacáridos (g)", "Fibra alimentar (g)", "Ácidos gordos saturados (g)", "Ácidos gordos monoinsaturados (g)", "Ácidos gordos polinsaturados  (g)", "Ácidos gordos trans (g)", "Ácido linoleico (g)", "Colesterol (mg)", "Retinol (vit. A total) (mg)", "Vit A total (equivalentes retinol) (mg)", "Caroteno (mg)", "vit. D (µg)", "a-tocoferol (mg)", "Tiamina (mg)", "Riboflavina (mg)", "Equivalentes de niacina (mg)", "Niacina (mg)", "Triptofano/60(mg)", "vit B6 (mg)", "Vit. B12 (µg)", "vit. C (mg)", "Folatos (µg)", "Cinza (g)", "Na (mg)", "K    (mg)", "Ca (mg)", "P (mg)", "Mg (mg)", "Fe (mg)", "Zn (mg)"});
        assertThrows(ForadeLimitesExcepcao.class, () -> c.addElemento(new String[]{"IS019", "Leite Cabra cru", "2", "290", "86,9", "3,8", "4", "4,6", "4,8", "4,6", "0", "0", "0", "0", "0", "2,6", "1,1", "0,1", "0,1", "0,1", "11", "-0.1", "53", "0", "0,05", "0,03", "0,05", "0,1", "1", "0,3", "0,7", "0,04", "0,08", "3", "1", "0,85", "40", "181", "153", "120", "20", "0,2", "0,3"}));
    }

    @Test
    public void testVitAtotalequivalentesretinolmgNaoAceitarAbaixovalorInferior
            () {
        ColecaoAlimentos c = new ColecaoAlimentos();
        c.addHeaderTabela(new String[]{"Código", "PRODUTO", "Energia (kcal)", "Energia (kJ)", "Água (g)", "Proteína (g)", "Gordura total (g)", "Total HC disponíveis (g)", "Total HC expresso em monossacáridos (g)", "Mono + dissacáridos (g)", "Ácidos orgânicos (g)", "Álcool (g)", "Amido (g)", "Oligossacáridos (g)", "Fibra alimentar (g)", "Ácidos gordos saturados (g)", "Ácidos gordos monoinsaturados (g)", "Ácidos gordos polinsaturados  (g)", "Ácidos gordos trans (g)", "Ácido linoleico (g)", "Colesterol (mg)", "Retinol (vit. A total) (mg)", "Vit A total (equivalentes retinol) (mg)", "Caroteno (mg)", "vit. D (µg)", "a-tocoferol (mg)", "Tiamina (mg)", "Riboflavina (mg)", "Equivalentes de niacina (mg)", "Niacina (mg)", "Triptofano/60(mg)", "vit B6 (mg)", "Vit. B12 (µg)", "vit. C (mg)", "Folatos (µg)", "Cinza (g)", "Na (mg)", "K    (mg)", "Ca (mg)", "P (mg)", "Mg (mg)", "Fe (mg)", "Zn (mg)"});
        assertThrows(ForadeLimitesExcepcao.class, () -> c.addElemento(new String[]{"IS019", "Leite Cabra cru", "2", "290", "86,9", "3,8", "4", "4,6", "4,8", "4,6", "0", "0", "0", "0", "0", "2,6", "1,1", "0,1", "0,1", "0,1", "11", "0,053", "-0.1", "0", "0,05", "0,03", "0,05", "0,1", "1", "0,3", "0,7", "0,04", "0,08", "3", "1", "0,85", "40", "181", "153", "120", "20", "0,2", "0,3"}));
    }

    @Test
    public void testCarotenomgNaoAceitarAbaixovalorInferior
            () {
        ColecaoAlimentos c = new ColecaoAlimentos();
        c.addHeaderTabela(new String[]{"Código", "PRODUTO", "Energia (kcal)", "Energia (kJ)", "Água (g)", "Proteína (g)", "Gordura total (g)", "Total HC disponíveis (g)", "Total HC expresso em monossacáridos (g)", "Mono + dissacáridos (g)", "Ácidos orgânicos (g)", "Álcool (g)", "Amido (g)", "Oligossacáridos (g)", "Fibra alimentar (g)", "Ácidos gordos saturados (g)", "Ácidos gordos monoinsaturados (g)", "Ácidos gordos polinsaturados  (g)", "Ácidos gordos trans (g)", "Ácido linoleico (g)", "Colesterol (mg)", "Retinol (vit. A total) (mg)", "Vit A total (equivalentes retinol) (mg)", "Caroteno (mg)", "vit. D (µg)", "a-tocoferol (mg)", "Tiamina (mg)", "Riboflavina (mg)", "Equivalentes de niacina (mg)", "Niacina (mg)", "Triptofano/60(mg)", "vit B6 (mg)", "Vit. B12 (µg)", "vit. C (mg)", "Folatos (µg)", "Cinza (g)", "Na (mg)", "K    (mg)", "Ca (mg)", "P (mg)", "Mg (mg)", "Fe (mg)", "Zn (mg)"});
        assertThrows(ForadeLimitesExcepcao.class, () -> c.addElemento(new String[]{"IS019", "Leite Cabra cru", "2", "290", "86,9", "3,8", "4", "4,6", "4,8", "4,6", "0", "0", "0", "0", "0", "2,6", "1,1", "0,1", "0,1", "0,1", "11", "0,053", "53", "-0.1", "0,05", "0,03", "0,05", "0,1", "1", "0,3", "0,7", "0,04", "0,08", "3", "1", "0,85", "40", "181", "153", "120", "20", "0,2", "0,3"}));
    }

    @Test
    public void testvitDµgNaoAceitarAbaixovalorInferior
            () {
        ColecaoAlimentos c = new ColecaoAlimentos();
        c.addHeaderTabela(new String[]{"Código", "PRODUTO", "Energia (kcal)", "Energia (kJ)", "Água (g)", "Proteína (g)", "Gordura total (g)", "Total HC disponíveis (g)", "Total HC expresso em monossacáridos (g)", "Mono + dissacáridos (g)", "Ácidos orgânicos (g)", "Álcool (g)", "Amido (g)", "Oligossacáridos (g)", "Fibra alimentar (g)", "Ácidos gordos saturados (g)", "Ácidos gordos monoinsaturados (g)", "Ácidos gordos polinsaturados  (g)", "Ácidos gordos trans (g)", "Ácido linoleico (g)", "Colesterol (mg)", "Retinol (vit. A total) (mg)", "Vit A total (equivalentes retinol) (mg)", "Caroteno (mg)", "vit. D (µg)", "a-tocoferol (mg)", "Tiamina (mg)", "Riboflavina (mg)", "Equivalentes de niacina (mg)", "Niacina (mg)", "Triptofano/60(mg)", "vit B6 (mg)", "Vit. B12 (µg)", "vit. C (mg)", "Folatos (µg)", "Cinza (g)", "Na (mg)", "K    (mg)", "Ca (mg)", "P (mg)", "Mg (mg)", "Fe (mg)", "Zn (mg)"});
        assertThrows(ForadeLimitesExcepcao.class, () -> c.addElemento(new String[]{"IS019", "Leite Cabra cru", "2", "290", "86,9", "3,8", "4", "4,6", "4,8", "4,6", "0", "0", "0", "0", "0", "2,6", "1,1", "0,1", "0,1", "0,1", "11", "0,053", "53", "0", "-0.1", "0,03", "0,05", "0,1", "1", "0,3", "0,7", "0,04", "0,08", "3", "1", "0,85", "40", "181", "153", "120", "20", "0,2", "0,3"}));
    }

    @Test
    public void testatocoferolmgNaoAceitarAbaixovalorInferior
            () {
        ColecaoAlimentos c = new ColecaoAlimentos();
        c.addHeaderTabela(new String[]{"Código", "PRODUTO", "Energia (kcal)", "Energia (kJ)", "Água (g)", "Proteína (g)", "Gordura total (g)", "Total HC disponíveis (g)", "Total HC expresso em monossacáridos (g)", "Mono + dissacáridos (g)", "Ácidos orgânicos (g)", "Álcool (g)", "Amido (g)", "Oligossacáridos (g)", "Fibra alimentar (g)", "Ácidos gordos saturados (g)", "Ácidos gordos monoinsaturados (g)", "Ácidos gordos polinsaturados  (g)", "Ácidos gordos trans (g)", "Ácido linoleico (g)", "Colesterol (mg)", "Retinol (vit. A total) (mg)", "Vit A total (equivalentes retinol) (mg)", "Caroteno (mg)", "vit. D (µg)", "a-tocoferol (mg)", "Tiamina (mg)", "Riboflavina (mg)", "Equivalentes de niacina (mg)", "Niacina (mg)", "Triptofano/60(mg)", "vit B6 (mg)", "Vit. B12 (µg)", "vit. C (mg)", "Folatos (µg)", "Cinza (g)", "Na (mg)", "K    (mg)", "Ca (mg)", "P (mg)", "Mg (mg)", "Fe (mg)", "Zn (mg)"});
        assertThrows(ForadeLimitesExcepcao.class, () -> c.addElemento(new String[]{"IS019", "Leite Cabra cru", "2", "290", "86,9", "3,8", "4", "4,6", "4,8", "4,6", "0", "0", "0", "0", "0", "2,6", "1,1", "0,1", "0,1", "0,1", "11", "0,053", "53", "0", "0,05", "-0.1", "0,05", "0,1", "1", "0,3", "0,7", "0,04", "0,08", "3", "1", "0,85", "40", "181", "153", "120", "20", "0,2", "0,3"}));
    }

    @Test
    public void testTiaminamgNaoAceitarAbaixovalorInferior
            () {
        ColecaoAlimentos c = new ColecaoAlimentos();
        c.addHeaderTabela(new String[]{"Código", "PRODUTO", "Energia (kcal)", "Energia (kJ)", "Água (g)", "Proteína (g)", "Gordura total (g)", "Total HC disponíveis (g)", "Total HC expresso em monossacáridos (g)", "Mono + dissacáridos (g)", "Ácidos orgânicos (g)", "Álcool (g)", "Amido (g)", "Oligossacáridos (g)", "Fibra alimentar (g)", "Ácidos gordos saturados (g)", "Ácidos gordos monoinsaturados (g)", "Ácidos gordos polinsaturados  (g)", "Ácidos gordos trans (g)", "Ácido linoleico (g)", "Colesterol (mg)", "Retinol (vit. A total) (mg)", "Vit A total (equivalentes retinol) (mg)", "Caroteno (mg)", "vit. D (µg)", "a-tocoferol (mg)", "Tiamina (mg)", "Riboflavina (mg)", "Equivalentes de niacina (mg)", "Niacina (mg)", "Triptofano/60(mg)", "vit B6 (mg)", "Vit. B12 (µg)", "vit. C (mg)", "Folatos (µg)", "Cinza (g)", "Na (mg)", "K    (mg)", "Ca (mg)", "P (mg)", "Mg (mg)", "Fe (mg)", "Zn (mg)"});
        assertThrows(ForadeLimitesExcepcao.class, () -> c.addElemento(new String[]{"IS019", "Leite Cabra cru", "2", "290", "86,9", "3,8", "4", "4,6", "4,8", "4,6", "0", "0", "0", "0", "0", "2,6", "1,1", "0,1", "0,1", "0,1", "11", "0,053", "53", "0", "0,05", "0,03", "-0.1", "0,1", "1", "0,3", "0,7", "0,04", "0,08", "3", "1", "0,85", "40", "181", "153", "120", "20", "0,2", "0,3"}));
    }

    @Test
    public void testRiboflavinamgNaoAceitarAbaixovalorInferior
            () {
        ColecaoAlimentos c = new ColecaoAlimentos();
        c.addHeaderTabela(new String[]{"Código", "PRODUTO", "Energia (kcal)", "Energia (kJ)", "Água (g)", "Proteína (g)", "Gordura total (g)", "Total HC disponíveis (g)", "Total HC expresso em monossacáridos (g)", "Mono + dissacáridos (g)", "Ácidos orgânicos (g)", "Álcool (g)", "Amido (g)", "Oligossacáridos (g)", "Fibra alimentar (g)", "Ácidos gordos saturados (g)", "Ácidos gordos monoinsaturados (g)", "Ácidos gordos polinsaturados  (g)", "Ácidos gordos trans (g)", "Ácido linoleico (g)", "Colesterol (mg)", "Retinol (vit. A total) (mg)", "Vit A total (equivalentes retinol) (mg)", "Caroteno (mg)", "vit. D (µg)", "a-tocoferol (mg)", "Tiamina (mg)", "Riboflavina (mg)", "Equivalentes de niacina (mg)", "Niacina (mg)", "Triptofano/60(mg)", "vit B6 (mg)", "Vit. B12 (µg)", "vit. C (mg)", "Folatos (µg)", "Cinza (g)", "Na (mg)", "K    (mg)", "Ca (mg)", "P (mg)", "Mg (mg)", "Fe (mg)", "Zn (mg)"});
        assertThrows(ForadeLimitesExcepcao.class, () -> c.addElemento(new String[]{"IS019", "Leite Cabra cru", "2", "290", "86,9", "3,8", "4", "4,6", "4,8", "4,6", "0", "0", "0", "0", "0", "2,6", "1,1", "0,1", "0,1", "0,1", "11", "0,053", "53", "0", "0,05", "0,03", "0,05", "-0.1", "1", "0,3", "0,7", "0,04", "0,08", "3", "1", "0,85", "40", "181", "153", "120", "20", "0,2", "0,3"}));
    }

    @Test
    public void testEquivalentesdeniacinamgNaoAceitarAbaixovalorInferior
            () {
        ColecaoAlimentos c = new ColecaoAlimentos();
        c.addHeaderTabela(new String[]{"Código", "PRODUTO", "Energia (kcal)", "Energia (kJ)", "Água (g)", "Proteína (g)", "Gordura total (g)", "Total HC disponíveis (g)", "Total HC expresso em monossacáridos (g)", "Mono + dissacáridos (g)", "Ácidos orgânicos (g)", "Álcool (g)", "Amido (g)", "Oligossacáridos (g)", "Fibra alimentar (g)", "Ácidos gordos saturados (g)", "Ácidos gordos monoinsaturados (g)", "Ácidos gordos polinsaturados  (g)", "Ácidos gordos trans (g)", "Ácido linoleico (g)", "Colesterol (mg)", "Retinol (vit. A total) (mg)", "Vit A total (equivalentes retinol) (mg)", "Caroteno (mg)", "vit. D (µg)", "a-tocoferol (mg)", "Tiamina (mg)", "Riboflavina (mg)", "Equivalentes de niacina (mg)", "Niacina (mg)", "Triptofano/60(mg)", "vit B6 (mg)", "Vit. B12 (µg)", "vit. C (mg)", "Folatos (µg)", "Cinza (g)", "Na (mg)", "K    (mg)", "Ca (mg)", "P (mg)", "Mg (mg)", "Fe (mg)", "Zn (mg)"});
        assertThrows(ForadeLimitesExcepcao.class, () -> c.addElemento(new String[]{"IS019", "Leite Cabra cru", "2", "290", "86,9", "3,8", "4", "4,6", "4,8", "4,6", "0", "0", "0", "0", "0", "2,6", "1,1", "0,1", "0,1", "0,1", "11", "0,053", "53", "0", "0,05", "0,03", "0,05", "0,1", "-0.1", "0,3", "0,7", "0,04", "0,08", "3", "1", "0,85", "40", "181", "153", "120", "20", "0,2", "0,3"}));
    }

    @Test
    public void testNiacinamgNaoAceitarAbaixovalorInferior
            () {
        ColecaoAlimentos c = new ColecaoAlimentos();
        c.addHeaderTabela(new String[]{"Código", "PRODUTO", "Energia (kcal)", "Energia (kJ)", "Água (g)", "Proteína (g)", "Gordura total (g)", "Total HC disponíveis (g)", "Total HC expresso em monossacáridos (g)", "Mono + dissacáridos (g)", "Ácidos orgânicos (g)", "Álcool (g)", "Amido (g)", "Oligossacáridos (g)", "Fibra alimentar (g)", "Ácidos gordos saturados (g)", "Ácidos gordos monoinsaturados (g)", "Ácidos gordos polinsaturados  (g)", "Ácidos gordos trans (g)", "Ácido linoleico (g)", "Colesterol (mg)", "Retinol (vit. A total) (mg)", "Vit A total (equivalentes retinol) (mg)", "Caroteno (mg)", "vit. D (µg)", "a-tocoferol (mg)", "Tiamina (mg)", "Riboflavina (mg)", "Equivalentes de niacina (mg)", "Niacina (mg)", "Triptofano/60(mg)", "vit B6 (mg)", "Vit. B12 (µg)", "vit. C (mg)", "Folatos (µg)", "Cinza (g)", "Na (mg)", "K    (mg)", "Ca (mg)", "P (mg)", "Mg (mg)", "Fe (mg)", "Zn (mg)"});
        assertThrows(ForadeLimitesExcepcao.class, () -> c.addElemento(new String[]{"IS019", "Leite Cabra cru", "2", "290", "86,9", "3,8", "4", "4,6", "4,8", "4,6", "0", "0", "0", "0", "0", "2,6", "1,1", "0,1", "0,1", "0,1", "11", "0,053", "53", "0", "0,05", "0,03", "0,05", "0,1", "1", "-0.1", "0,7", "0,04", "0,08", "3", "1", "0,85", "40", "181", "153", "120", "20", "0,2", "0,3"}));
    }

    @Test
    public void testTriptofanoNaoAceitarAbaixovalorInferior
            () {
        ColecaoAlimentos c = new ColecaoAlimentos();
        c.addHeaderTabela(new String[]{"Código", "PRODUTO", "Energia (kcal)", "Energia (kJ)", "Água (g)", "Proteína (g)", "Gordura total (g)", "Total HC disponíveis (g)", "Total HC expresso em monossacáridos (g)", "Mono + dissacáridos (g)", "Ácidos orgânicos (g)", "Álcool (g)", "Amido (g)", "Oligossacáridos (g)", "Fibra alimentar (g)", "Ácidos gordos saturados (g)", "Ácidos gordos monoinsaturados (g)", "Ácidos gordos polinsaturados  (g)", "Ácidos gordos trans (g)", "Ácido linoleico (g)", "Colesterol (mg)", "Retinol (vit. A total) (mg)", "Vit A total (equivalentes retinol) (mg)", "Caroteno (mg)", "vit. D (µg)", "a-tocoferol (mg)", "Tiamina (mg)", "Riboflavina (mg)", "Equivalentes de niacina (mg)", "Niacina (mg)", "Triptofano/60(mg)", "vit B6 (mg)", "Vit. B12 (µg)", "vit. C (mg)", "Folatos (µg)", "Cinza (g)", "Na (mg)", "K    (mg)", "Ca (mg)", "P (mg)", "Mg (mg)", "Fe (mg)", "Zn (mg)"});
        assertThrows(ForadeLimitesExcepcao.class, () -> c.addElemento(new String[]{"IS019", "Leite Cabra cru", "2", "290", "86,9", "3,8", "4", "4,6", "4,8", "4,6", "0", "0", "0", "0", "0", "2,6", "1,1", "0,1", "0,1", "0,1", "11", "0,053", "53", "0", "0,05", "0,03", "0,05", "0,1", "1", "0,3", "-0.1", "0,04", "0,08", "3", "1", "0,85", "40", "181", "153", "120", "20", "0,2", "0,3"}));
    }

    @Test
    public void testvitB6mgNaoAceitarAbaixovalorInferior
            () {
        ColecaoAlimentos c = new ColecaoAlimentos();
        c.addHeaderTabela(new String[]{"Código", "PRODUTO", "Energia (kcal)", "Energia (kJ)", "Água (g)", "Proteína (g)", "Gordura total (g)", "Total HC disponíveis (g)", "Total HC expresso em monossacáridos (g)", "Mono + dissacáridos (g)", "Ácidos orgânicos (g)", "Álcool (g)", "Amido (g)", "Oligossacáridos (g)", "Fibra alimentar (g)", "Ácidos gordos saturados (g)", "Ácidos gordos monoinsaturados (g)", "Ácidos gordos polinsaturados  (g)", "Ácidos gordos trans (g)", "Ácido linoleico (g)", "Colesterol (mg)", "Retinol (vit. A total) (mg)", "Vit A total (equivalentes retinol) (mg)", "Caroteno (mg)", "vit. D (µg)", "a-tocoferol (mg)", "Tiamina (mg)", "Riboflavina (mg)", "Equivalentes de niacina (mg)", "Niacina (mg)", "Triptofano/60(mg)", "vit B6 (mg)", "Vit. B12 (µg)", "vit. C (mg)", "Folatos (µg)", "Cinza (g)", "Na (mg)", "K    (mg)", "Ca (mg)", "P (mg)", "Mg (mg)", "Fe (mg)", "Zn (mg)"});
        assertThrows(ForadeLimitesExcepcao.class, () -> c.addElemento(new String[]{"IS019", "Leite Cabra cru", "2", "290", "86,9", "3,8", "4", "4,6", "4,8", "4,6", "0", "0", "0", "0", "0", "2,6", "1,1", "0,1", "0,1", "0,1", "11", "0,053", "53", "0", "0,05", "0,03", "0,05", "0,1", "1", "0,3", "0,7", "-0.1", "0,08", "3", "1", "0,85", "40", "181", "153", "120", "20", "0,2", "0,3"}));
    }

    @Test
    public void testVitB12µgNaoAceitarAbaixovalorInferior
            () {
        ColecaoAlimentos c = new ColecaoAlimentos();
        c.addHeaderTabela(new String[]{"Código", "PRODUTO", "Energia (kcal)", "Energia (kJ)", "Água (g)", "Proteína (g)", "Gordura total (g)", "Total HC disponíveis (g)", "Total HC expresso em monossacáridos (g)", "Mono + dissacáridos (g)", "Ácidos orgânicos (g)", "Álcool (g)", "Amido (g)", "Oligossacáridos (g)", "Fibra alimentar (g)", "Ácidos gordos saturados (g)", "Ácidos gordos monoinsaturados (g)", "Ácidos gordos polinsaturados  (g)", "Ácidos gordos trans (g)", "Ácido linoleico (g)", "Colesterol (mg)", "Retinol (vit. A total) (mg)", "Vit A total (equivalentes retinol) (mg)", "Caroteno (mg)", "vit. D (µg)", "a-tocoferol (mg)", "Tiamina (mg)", "Riboflavina (mg)", "Equivalentes de niacina (mg)", "Niacina (mg)", "Triptofano/60(mg)", "vit B6 (mg)", "Vit. B12 (µg)", "vit. C (mg)", "Folatos (µg)", "Cinza (g)", "Na (mg)", "K    (mg)", "Ca (mg)", "P (mg)", "Mg (mg)", "Fe (mg)", "Zn (mg)"});
        assertThrows(ForadeLimitesExcepcao.class, () -> c.addElemento(new String[]{"IS019", "Leite Cabra cru", "2", "290", "86,9", "3,8", "4", "4,6", "4,8", "4,6", "0", "0", "0", "0", "0", "2,6", "1,1", "0,1", "0,1", "0,1", "11", "0,053", "53", "0", "0,05", "0,03", "0,05", "0,1", "1", "0,3", "0,7", "0,04", "-0.1", "3", "1", "0,85", "40", "181", "153", "120", "20", "0,2", "0,3"}));
    }

    @Test
    public void testvitCmgNaoAceitarAbaixovalorInferior() {
        ColecaoAlimentos c = new ColecaoAlimentos();
        c.addHeaderTabela(new String[]{"Código", "PRODUTO", "Energia (kcal)", "Energia (kJ)", "Água (g)", "Proteína (g)", "Gordura total (g)", "Total HC disponíveis (g)", "Total HC expresso em monossacáridos (g)", "Mono + dissacáridos (g)", "Ácidos orgânicos (g)", "Álcool (g)", "Amido (g)", "Oligossacáridos (g)", "Fibra alimentar (g)", "Ácidos gordos saturados (g)", "Ácidos gordos monoinsaturados (g)", "Ácidos gordos polinsaturados  (g)", "Ácidos gordos trans (g)", "Ácido linoleico (g)", "Colesterol (mg)", "Retinol (vit. A total) (mg)", "Vit A total (equivalentes retinol) (mg)", "Caroteno (mg)", "vit. D (µg)", "a-tocoferol (mg)", "Tiamina (mg)", "Riboflavina (mg)", "Equivalentes de niacina (mg)", "Niacina (mg)", "Triptofano/60(mg)", "vit B6 (mg)", "Vit. B12 (µg)", "vit. C (mg)", "Folatos (µg)", "Cinza (g)", "Na (mg)", "K    (mg)", "Ca (mg)", "P (mg)", "Mg (mg)", "Fe (mg)", "Zn (mg)"});
        assertThrows(ForadeLimitesExcepcao.class, () -> c.addElemento(new String[]{"IS019", "Leite Cabra cru", "2", "290", "86,9", "3,8", "4", "4,6", "4,8", "4,6", "0", "0", "0", "0", "0", "2,6", "1,1", "0,1", "0,1", "0,1", "11", "0,053", "53", "0", "0,05", "0,03", "0,05", "0,1", "1", "0,3", "0,7", "0,04", "0,08", "-0.1", "1", "0,85", "40", "181", "153", "120", "20", "0,2", "0,3"}));
    }

    @Test
    public void testFolatosµgNaoAceitarAbaixovalorInferior() {
        ColecaoAlimentos c = new ColecaoAlimentos();
        c.addHeaderTabela(new String[]{"Código", "PRODUTO", "Energia (kcal)", "Energia (kJ)", "Água (g)", "Proteína (g)", "Gordura total (g)", "Total HC disponíveis (g)", "Total HC expresso em monossacáridos (g)", "Mono + dissacáridos (g)", "Ácidos orgânicos (g)", "Álcool (g)", "Amido (g)", "Oligossacáridos (g)", "Fibra alimentar (g)", "Ácidos gordos saturados (g)", "Ácidos gordos monoinsaturados (g)", "Ácidos gordos polinsaturados  (g)", "Ácidos gordos trans (g)", "Ácido linoleico (g)", "Colesterol (mg)", "Retinol (vit. A total) (mg)", "Vit A total (equivalentes retinol) (mg)", "Caroteno (mg)", "vit. D (µg)", "a-tocoferol (mg)", "Tiamina (mg)", "Riboflavina (mg)", "Equivalentes de niacina (mg)", "Niacina (mg)", "Triptofano/60(mg)", "vit B6 (mg)", "Vit. B12 (µg)", "vit. C (mg)", "Folatos (µg)", "Cinza (g)", "Na (mg)", "K    (mg)", "Ca (mg)", "P (mg)", "Mg (mg)", "Fe (mg)", "Zn (mg)"});
        assertThrows(ForadeLimitesExcepcao.class, () -> c.addElemento(new String[]{"IS019", "Leite Cabra cru", "2", "290", "86,9", "3,8", "4", "4,6", "4,8", "4,6", "0", "0", "0", "0", "0", "2,6", "1,1", "0,1", "0,1", "0,1", "11", "0,053", "53", "0", "0,05", "0,03", "0,05", "0,1", "1", "0,3", "0,7", "0,04", "0,08", "3", "-0.1", "0,85", "40", "181", "153", "120", "20", "0,2", "0,3"}));
    }

    @Test
    public void testCinzagNaoAceitarAbaixovalorInferior() {
        ColecaoAlimentos c = new ColecaoAlimentos();
        c.addHeaderTabela(new String[]{"Código", "PRODUTO", "Energia (kcal)", "Energia (kJ)", "Água (g)", "Proteína (g)", "Gordura total (g)", "Total HC disponíveis (g)", "Total HC expresso em monossacáridos (g)", "Mono + dissacáridos (g)", "Ácidos orgânicos (g)", "Álcool (g)", "Amido (g)", "Oligossacáridos (g)", "Fibra alimentar (g)", "Ácidos gordos saturados (g)", "Ácidos gordos monoinsaturados (g)", "Ácidos gordos polinsaturados  (g)", "Ácidos gordos trans (g)", "Ácido linoleico (g)", "Colesterol (mg)", "Retinol (vit. A total) (mg)", "Vit A total (equivalentes retinol) (mg)", "Caroteno (mg)", "vit. D (µg)", "a-tocoferol (mg)", "Tiamina (mg)", "Riboflavina (mg)", "Equivalentes de niacina (mg)", "Niacina (mg)", "Triptofano/60(mg)", "vit B6 (mg)", "Vit. B12 (µg)", "vit. C (mg)", "Folatos (µg)", "Cinza (g)", "Na (mg)", "K    (mg)", "Ca (mg)", "P (mg)", "Mg (mg)", "Fe (mg)", "Zn (mg)"});
        assertThrows(ForadeLimitesExcepcao.class, () -> c.addElemento(new String[]{"IS019", "Leite Cabra cru", "2", "290", "86,9", "3,8", "4", "4,6", "4,8", "4,6", "0", "0", "0", "0", "0", "2,6", "1,1", "0,1", "0,1", "0,1", "11", "0,053", "53", "0", "0,05", "0,03", "0,05", "0,1", "1", "0,3", "0,7", "0,04", "0,08", "3", "1", "-0.1", "40", "181", "153", "120", "20", "0,2", "0,3"}));
    }

    @Test
    public void testNamgNaoAceitarAbaixovalorInferior() {
        ColecaoAlimentos c = new ColecaoAlimentos();
        c.addHeaderTabela(new String[]{"Código", "PRODUTO", "Energia (kcal)", "Energia (kJ)", "Água (g)", "Proteína (g)", "Gordura total (g)", "Total HC disponíveis (g)", "Total HC expresso em monossacáridos (g)", "Mono + dissacáridos (g)", "Ácidos orgânicos (g)", "Álcool (g)", "Amido (g)", "Oligossacáridos (g)", "Fibra alimentar (g)", "Ácidos gordos saturados (g)", "Ácidos gordos monoinsaturados (g)", "Ácidos gordos polinsaturados  (g)", "Ácidos gordos trans (g)", "Ácido linoleico (g)", "Colesterol (mg)", "Retinol (vit. A total) (mg)", "Vit A total (equivalentes retinol) (mg)", "Caroteno (mg)", "vit. D (µg)", "a-tocoferol (mg)", "Tiamina (mg)", "Riboflavina (mg)", "Equivalentes de niacina (mg)", "Niacina (mg)", "Triptofano/60(mg)", "vit B6 (mg)", "Vit. B12 (µg)", "vit. C (mg)", "Folatos (µg)", "Cinza (g)", "Na (mg)", "K    (mg)", "Ca (mg)", "P (mg)", "Mg (mg)", "Fe (mg)", "Zn (mg)"});
        assertThrows(ForadeLimitesExcepcao.class, () -> c.addElemento(new String[]{"IS019", "Leite Cabra cru", "2", "290", "86,9", "3,8", "4", "4,6", "4,8", "4,6", "0", "0", "0", "0", "0", "2,6", "1,1", "0,1", "0,1", "0,1", "11", "0,053", "53", "0", "0,05", "0,03", "0,05", "0,1", "1", "0,3", "0,7", "0,04", "0,08", "3", "1", "0,85", "-0.1", "181", "153", "120", "20", "0,2", "0,3"}));
    }

    @Test
    public void testKmgNaoAceitarAbaixovalorInferior() {
        ColecaoAlimentos c = new ColecaoAlimentos();
        c.addHeaderTabela(new String[]{"Código", "PRODUTO", "Energia (kcal)", "Energia (kJ)", "Água (g)", "Proteína (g)", "Gordura total (g)", "Total HC disponíveis (g)", "Total HC expresso em monossacáridos (g)", "Mono + dissacáridos (g)", "Ácidos orgânicos (g)", "Álcool (g)", "Amido (g)", "Oligossacáridos (g)", "Fibra alimentar (g)", "Ácidos gordos saturados (g)", "Ácidos gordos monoinsaturados (g)", "Ácidos gordos polinsaturados  (g)", "Ácidos gordos trans (g)", "Ácido linoleico (g)", "Colesterol (mg)", "Retinol (vit. A total) (mg)", "Vit A total (equivalentes retinol) (mg)", "Caroteno (mg)", "vit. D (µg)", "a-tocoferol (mg)", "Tiamina (mg)", "Riboflavina (mg)", "Equivalentes de niacina (mg)", "Niacina (mg)", "Triptofano/60(mg)", "vit B6 (mg)", "Vit. B12 (µg)", "vit. C (mg)", "Folatos (µg)", "Cinza (g)", "Na (mg)", "K    (mg)", "Ca (mg)", "P (mg)", "Mg (mg)", "Fe (mg)", "Zn (mg)"});
        assertThrows(ForadeLimitesExcepcao.class, () -> c.addElemento(new String[]{"IS019", "Leite Cabra cru", "2", "290", "86,9", "3,8", "4", "4,6", "4,8", "4,6", "0", "0", "0", "0", "0", "2,6", "1,1", "0,1", "0,1", "0,1", "11", "0,053", "53", "0", "0,05", "0,03", "0,05", "0,1", "1", "0,3", "0,7", "0,04", "0,08", "3", "1", "0,85", "40", "-0.1", "153", "120", "20", "0,2", "0,3"}));
    }

    @Test
    public void testCamgNaoAceitarAbaixovalorInferior() {
        ColecaoAlimentos c = new ColecaoAlimentos();
        c.addHeaderTabela(new String[]{"Código", "PRODUTO", "Energia (kcal)", "Energia (kJ)", "Água (g)", "Proteína (g)", "Gordura total (g)", "Total HC disponíveis (g)", "Total HC expresso em monossacáridos (g)", "Mono + dissacáridos (g)", "Ácidos orgânicos (g)", "Álcool (g)", "Amido (g)", "Oligossacáridos (g)", "Fibra alimentar (g)", "Ácidos gordos saturados (g)", "Ácidos gordos monoinsaturados (g)", "Ácidos gordos polinsaturados  (g)", "Ácidos gordos trans (g)", "Ácido linoleico (g)", "Colesterol (mg)", "Retinol (vit. A total) (mg)", "Vit A total (equivalentes retinol) (mg)", "Caroteno (mg)", "vit. D (µg)", "a-tocoferol (mg)", "Tiamina (mg)", "Riboflavina (mg)", "Equivalentes de niacina (mg)", "Niacina (mg)", "Triptofano/60(mg)", "vit B6 (mg)", "Vit. B12 (µg)", "vit. C (mg)", "Folatos (µg)", "Cinza (g)", "Na (mg)", "K    (mg)", "Ca (mg)", "P (mg)", "Mg (mg)", "Fe (mg)", "Zn (mg)"});
        assertThrows(ForadeLimitesExcepcao.class, () -> c.addElemento(new String[]{"IS019", "Leite Cabra cru", "2", "290", "86,9", "3,8", "4", "4,6", "4,8", "4,6", "0", "0", "0", "0", "0", "2,6", "1,1", "0,1", "0,1", "0,1", "11", "0,053", "53", "0", "0,05", "0,03", "0,05", "0,1", "1", "0,3", "0,7", "0,04", "0,08", "3", "1", "0,85", "40", "181", "-0.1", "120", "20", "0,2", "0,3"}));
    }

    @Test
    public void testPmgNaoAceitarAbaixovalorInferior() {
        ColecaoAlimentos c = new ColecaoAlimentos();
        c.addHeaderTabela(new String[]{"Código", "PRODUTO", "Energia (kcal)", "Energia (kJ)", "Água (g)", "Proteína (g)", "Gordura total (g)", "Total HC disponíveis (g)", "Total HC expresso em monossacáridos (g)", "Mono + dissacáridos (g)", "Ácidos orgânicos (g)", "Álcool (g)", "Amido (g)", "Oligossacáridos (g)", "Fibra alimentar (g)", "Ácidos gordos saturados (g)", "Ácidos gordos monoinsaturados (g)", "Ácidos gordos polinsaturados  (g)", "Ácidos gordos trans (g)", "Ácido linoleico (g)", "Colesterol (mg)", "Retinol (vit. A total) (mg)", "Vit A total (equivalentes retinol) (mg)", "Caroteno (mg)", "vit. D (µg)", "a-tocoferol (mg)", "Tiamina (mg)", "Riboflavina (mg)", "Equivalentes de niacina (mg)", "Niacina (mg)", "Triptofano/60(mg)", "vit B6 (mg)", "Vit. B12 (µg)", "vit. C (mg)", "Folatos (µg)", "Cinza (g)", "Na (mg)", "K    (mg)", "Ca (mg)", "P (mg)", "Mg (mg)", "Fe (mg)", "Zn (mg)"});
        assertThrows(ForadeLimitesExcepcao.class, () -> c.addElemento(new String[]{"IS019", "Leite Cabra cru", "2", "290", "86,9", "3,8", "4", "4,6", "4,8", "4,6", "0", "0", "0", "0", "0", "2,6", "1,1", "0,1", "0,1", "0,1", "11", "0,053", "53", "0", "0,05", "0,03", "0,05", "0,1", "1", "0,3", "0,7", "0,04", "0,08", "3", "1", "0,85", "40", "181", "153", "-0.1", "20", "0,2", "0,3"}));
    }

    @Test
    public void testMgmgNaoAceitarAbaixovalorInferior() {
        ColecaoAlimentos c = new ColecaoAlimentos();
        c.addHeaderTabela(new String[]{"Código", "PRODUTO", "Energia (kcal)", "Energia (kJ)", "Água (g)", "Proteína (g)", "Gordura total (g)", "Total HC disponíveis (g)", "Total HC expresso em monossacáridos (g)", "Mono + dissacáridos (g)", "Ácidos orgânicos (g)", "Álcool (g)", "Amido (g)", "Oligossacáridos (g)", "Fibra alimentar (g)", "Ácidos gordos saturados (g)", "Ácidos gordos monoinsaturados (g)", "Ácidos gordos polinsaturados  (g)", "Ácidos gordos trans (g)", "Ácido linoleico (g)", "Colesterol (mg)", "Retinol (vit. A total) (mg)", "Vit A total (equivalentes retinol) (mg)", "Caroteno (mg)", "vit. D (µg)", "a-tocoferol (mg)", "Tiamina (mg)", "Riboflavina (mg)", "Equivalentes de niacina (mg)", "Niacina (mg)", "Triptofano/60(mg)", "vit B6 (mg)", "Vit. B12 (µg)", "vit. C (mg)", "Folatos (µg)", "Cinza (g)", "Na (mg)", "K    (mg)", "Ca (mg)", "P (mg)", "Mg (mg)", "Fe (mg)", "Zn (mg)"});
        assertThrows(ForadeLimitesExcepcao.class, () -> c.addElemento(new String[]{"IS019", "Leite Cabra cru", "2", "290", "86,9", "3,8", "4", "4,6", "4,8", "4,6", "0", "0", "0", "0", "0", "2,6", "1,1", "0,1", "0,1", "0,1", "11", "0,053", "53", "0", "0,05", "0,03", "0,05", "0,1", "1", "0,3", "0,7", "0,04", "0,08", "3", "1", "0,85", "40", "181", "153", "120", "-0.1", "0,2", "0,3"}));
    }

    @Test
    public void testFemgNaoAceitarAbaixovalorInferior() {
        ColecaoAlimentos c = new ColecaoAlimentos();
        c.addHeaderTabela(new String[]{"Código", "PRODUTO", "Energia (kcal)", "Energia (kJ)", "Água (g)", "Proteína (g)", "Gordura total (g)", "Total HC disponíveis (g)", "Total HC expresso em monossacáridos (g)", "Mono + dissacáridos (g)", "Ácidos orgânicos (g)", "Álcool (g)", "Amido (g)", "Oligossacáridos (g)", "Fibra alimentar (g)", "Ácidos gordos saturados (g)", "Ácidos gordos monoinsaturados (g)", "Ácidos gordos polinsaturados  (g)", "Ácidos gordos trans (g)", "Ácido linoleico (g)", "Colesterol (mg)", "Retinol (vit. A total) (mg)", "Vit A total (equivalentes retinol) (mg)", "Caroteno (mg)", "vit. D (µg)", "a-tocoferol (mg)", "Tiamina (mg)", "Riboflavina (mg)", "Equivalentes de niacina (mg)", "Niacina (mg)", "Triptofano/60(mg)", "vit B6 (mg)", "Vit. B12 (µg)", "vit. C (mg)", "Folatos (µg)", "Cinza (g)", "Na (mg)", "K    (mg)", "Ca (mg)", "P (mg)", "Mg (mg)", "Fe (mg)", "Zn (mg)"});
        assertThrows(ForadeLimitesExcepcao.class, () -> c.addElemento(new String[]{"IS019", "Leite Cabra cru", "2", "290", "86,9", "3,8", "4", "4,6", "4,8", "4,6", "0", "0", "0", "0", "0", "2,6", "1,1", "0,1", "0,1", "0,1", "11", "0,053", "53", "0", "0,05", "0,03", "0,05", "0,1", "1", "0,3", "0,7", "0,04", "0,08", "3", "1", "0,85", "40", "181", "153", "120", "20", "-0.1", "0,3"}));
    }

    @Test
    public void testZnmgNaoAceitarAbaixovalorInferior() {
        ColecaoAlimentos c = new ColecaoAlimentos();
        c.addHeaderTabela(new String[]{"Código", "PRODUTO", "Energia (kcal)", "Energia (kJ)", "Água (g)", "Proteína (g)", "Gordura total (g)", "Total HC disponíveis (g)", "Total HC expresso em monossacáridos (g)", "Mono + dissacáridos (g)", "Ácidos orgânicos (g)", "Álcool (g)", "Amido (g)", "Oligossacáridos (g)", "Fibra alimentar (g)", "Ácidos gordos saturados (g)", "Ácidos gordos monoinsaturados (g)", "Ácidos gordos polinsaturados  (g)", "Ácidos gordos trans (g)", "Ácido linoleico (g)", "Colesterol (mg)", "Retinol (vit. A total) (mg)", "Vit A total (equivalentes retinol) (mg)", "Caroteno (mg)", "vit. D (µg)", "a-tocoferol (mg)", "Tiamina (mg)", "Riboflavina (mg)", "Equivalentes de niacina (mg)", "Niacina (mg)", "Triptofano/60(mg)", "vit B6 (mg)", "Vit. B12 (µg)", "vit. C (mg)", "Folatos (µg)", "Cinza (g)", "Na (mg)", "K    (mg)", "Ca (mg)", "P (mg)", "Mg (mg)", "Fe (mg)", "Zn (mg)"});
        assertThrows(ForadeLimitesExcepcao.class, () -> c.addElemento(new String[]{"IS019", "Leite Cabra cru", "2", "290", "86,9", "3,8", "4", "4,6", "4,8", "4,6", "0", "0", "0", "0", "0", "2,6", "1,1", "0,1", "0,1", "0,1", "11", "0,053", "53", "0", "0,05", "0,03", "0,05", "0,1", "1", "0,3", "0,7", "0,04", "0,08", "3", "1", "0,85", "40", "181", "153", "120", "20", "0,2", "-0.1"}));
    }
    @Test
    public void testEnergiakcalNaoAceitarAcimavalorSuperior() {
        ColecaoAlimentos c = new ColecaoAlimentos();
        c.addHeaderTabela(new String[]{"Código", "PRODUTO", "Energia (kcal)", "Energia (kJ)", "Água (g)", "Proteína (g)", "Gordura total (g)", "Total HC disponíveis (g)", "Total HC expresso em monossacáridos (g)", "Mono + dissacáridos (g)", "Ácidos orgânicos (g)", "Álcool (g)", "Amido (g)", "Oligossacáridos (g)", "Fibra alimentar (g)", "Ácidos gordos saturados (g)", "Ácidos gordos monoinsaturados (g)", "Ácidos gordos polinsaturados  (g)", "Ácidos gordos trans (g)", "Ácido linoleico (g)", "Colesterol (mg)", "Retinol (vit. A total) (mg)", "Vit A total (equivalentes retinol) (mg)", "Caroteno (mg)", "vit. D (µg)", "a-tocoferol (mg)", "Tiamina (mg)", "Riboflavina (mg)", "Equivalentes de niacina (mg)", "Niacina (mg)", "Triptofano/60(mg)", "vit B6 (mg)", "Vit. B12 (µg)", "vit. C (mg)", "Folatos (µg)", "Cinza (g)", "Na (mg)", "K    (mg)", "Ca (mg)", "P (mg)", "Mg (mg)", "Fe (mg)", "Zn (mg)"});
        assertThrows(ForadeLimitesExcepcao.class, () -> c.addElemento(new String[]{"IS019", "Leite Cabra cru", "1500.1", "290", "86,9", "3,8", "4", "4,6", "4,8", "4,6", "0", "0", "0", "0", "0", "2,6", "1,1", "0,1", "0,1", "0,1", "11", "0,053", "53", "0", "0,05", "0,03", "0,05", "0,1", "1", "0,3", "0,7", "0,04", "0,08", "3", "1", "0,85", "40", "181", "153", "120", "20", "0,2", "0,3"}));
    }

    @Test
    public void testEnergiakJNaoAceitarAcimavalorSuperior() {
        ColecaoAlimentos c = new ColecaoAlimentos();
        c.addHeaderTabela(new String[]{"Código", "PRODUTO", "Energia (kcal)", "Energia (kJ)", "Água (g)", "Proteína (g)", "Gordura total (g)", "Total HC disponíveis (g)", "Total HC expresso em monossacáridos (g)", "Mono + dissacáridos (g)", "Ácidos orgânicos (g)", "Álcool (g)", "Amido (g)", "Oligossacáridos (g)", "Fibra alimentar (g)", "Ácidos gordos saturados (g)", "Ácidos gordos monoinsaturados (g)", "Ácidos gordos polinsaturados  (g)", "Ácidos gordos trans (g)", "Ácido linoleico (g)", "Colesterol (mg)", "Retinol (vit. A total) (mg)", "Vit A total (equivalentes retinol) (mg)", "Caroteno (mg)", "vit. D (µg)", "a-tocoferol (mg)", "Tiamina (mg)", "Riboflavina (mg)", "Equivalentes de niacina (mg)", "Niacina (mg)", "Triptofano/60(mg)", "vit B6 (mg)", "Vit. B12 (µg)", "vit. C (mg)", "Folatos (µg)", "Cinza (g)", "Na (mg)", "K    (mg)", "Ca (mg)", "P (mg)", "Mg (mg)", "Fe (mg)", "Zn (mg)"});
        assertThrows(ForadeLimitesExcepcao.class, () -> c.addElemento(new String[]{"IS019", "Leite Cabra cru", "2", "15000.1", "86,9", "3,8", "4", "4,6", "4,8", "4,6", "0", "0", "0", "0", "0", "2,6", "1,1", "0,1", "0,1", "0,1", "11", "0,053", "53", "0", "0,05", "0,03", "0,05", "0,1", "1", "0,3", "0,7", "0,04", "0,08", "3", "1", "0,85", "40", "181", "153", "120", "20", "0,2", "0,3"}));
    }

    @Test
    public void testaguagNaoAceitarAcimavalorSuperior() {
        ColecaoAlimentos c = new ColecaoAlimentos();
        c.addHeaderTabela(new String[]{"Código", "PRODUTO", "Energia (kcal)", "Energia (kJ)", "Água (g)", "Proteína (g)", "Gordura total (g)", "Total HC disponíveis (g)", "Total HC expresso em monossacáridos (g)", "Mono + dissacáridos (g)", "Ácidos orgânicos (g)", "Álcool (g)", "Amido (g)", "Oligossacáridos (g)", "Fibra alimentar (g)", "Ácidos gordos saturados (g)", "Ácidos gordos monoinsaturados (g)", "Ácidos gordos polinsaturados  (g)", "Ácidos gordos trans (g)", "Ácido linoleico (g)", "Colesterol (mg)", "Retinol (vit. A total) (mg)", "Vit A total (equivalentes retinol) (mg)", "Caroteno (mg)", "vit. D (µg)", "a-tocoferol (mg)", "Tiamina (mg)", "Riboflavina (mg)", "Equivalentes de niacina (mg)", "Niacina (mg)", "Triptofano/60(mg)", "vit B6 (mg)", "Vit. B12 (µg)", "vit. C (mg)", "Folatos (µg)", "Cinza (g)", "Na (mg)", "K    (mg)", "Ca (mg)", "P (mg)", "Mg (mg)", "Fe (mg)", "Zn (mg)"});
        assertThrows(ForadeLimitesExcepcao.class, () -> c.addElemento(new String[]{"IS019", "Leite Cabra cru", "2", "290", "1500.1", "3,8", "4", "4,6", "4,8", "4,6", "0", "0", "0", "0", "0", "2,6", "1,1", "0,1", "0,1", "0,1", "11", "0,053", "53", "0", "0,05", "0,03", "0,05", "0,1", "1", "0,3", "0,7", "0,04", "0,08", "3", "1", "0,85", "40", "181", "153", "120", "20", "0,2", "0,3"}));
    }

    @Test
    public void testProteínagNaoAceitarAcimavalorSuperior() {
        ColecaoAlimentos c = new ColecaoAlimentos();
        c.addHeaderTabela(new String[]{"Código", "PRODUTO", "Energia (kcal)", "Energia (kJ)", "Água (g)", "Proteína (g)", "Gordura total (g)", "Total HC disponíveis (g)", "Total HC expresso em monossacáridos (g)", "Mono + dissacáridos (g)", "Ácidos orgânicos (g)", "Álcool (g)", "Amido (g)", "Oligossacáridos (g)", "Fibra alimentar (g)", "Ácidos gordos saturados (g)", "Ácidos gordos monoinsaturados (g)", "Ácidos gordos polinsaturados  (g)", "Ácidos gordos trans (g)", "Ácido linoleico (g)", "Colesterol (mg)", "Retinol (vit. A total) (mg)", "Vit A total (equivalentes retinol) (mg)", "Caroteno (mg)", "vit. D (µg)", "a-tocoferol (mg)", "Tiamina (mg)", "Riboflavina (mg)", "Equivalentes de niacina (mg)", "Niacina (mg)", "Triptofano/60(mg)", "vit B6 (mg)", "Vit. B12 (µg)", "vit. C (mg)", "Folatos (µg)", "Cinza (g)", "Na (mg)", "K    (mg)", "Ca (mg)", "P (mg)", "Mg (mg)", "Fe (mg)", "Zn (mg)"});
        assertThrows(ForadeLimitesExcepcao.class, () -> c.addElemento(new String[]{"IS019", "Leite Cabra cru", "2", "290", "86,9", "1500.1", "4", "4,6", "4,8", "4,6", "0", "0", "0", "0", "0", "2,6", "1,1", "0,1", "0,1", "0,1", "11", "0,053", "53", "0", "0,05", "0,03", "0,05", "0,1", "1", "0,3", "0,7", "0,04", "0,08", "3", "1", "0,85", "40", "181", "153", "120", "20", "0,2", "0,3"}));
    }

    @Test
    public void testGorduratotalgNaoAceitarAcimavalorSuperior() {
        ColecaoAlimentos c = new ColecaoAlimentos();
        c.addHeaderTabela(new String[]{"Código", "PRODUTO", "Energia (kcal)", "Energia (kJ)", "Água (g)", "Proteína (g)", "Gordura total (g)", "Total HC disponíveis (g)", "Total HC expresso em monossacáridos (g)", "Mono + dissacáridos (g)", "Ácidos orgânicos (g)", "Álcool (g)", "Amido (g)", "Oligossacáridos (g)", "Fibra alimentar (g)", "Ácidos gordos saturados (g)", "Ácidos gordos monoinsaturados (g)", "Ácidos gordos polinsaturados  (g)", "Ácidos gordos trans (g)", "Ácido linoleico (g)", "Colesterol (mg)", "Retinol (vit. A total) (mg)", "Vit A total (equivalentes retinol) (mg)", "Caroteno (mg)", "vit. D (µg)", "a-tocoferol (mg)", "Tiamina (mg)", "Riboflavina (mg)", "Equivalentes de niacina (mg)", "Niacina (mg)", "Triptofano/60(mg)", "vit B6 (mg)", "Vit. B12 (µg)", "vit. C (mg)", "Folatos (µg)", "Cinza (g)", "Na (mg)", "K    (mg)", "Ca (mg)", "P (mg)", "Mg (mg)", "Fe (mg)", "Zn (mg)"});
        assertThrows(ForadeLimitesExcepcao.class, () -> c.addElemento(new String[]{"IS019", "Leite Cabra cru", "2", "290", "86,9", "3,8", "1500.1", "4,6", "4,8", "4,6", "0", "0", "0", "0", "0", "2,6", "1,1", "0,1", "0,1", "0,1", "11", "0,053", "53", "0", "0,05", "0,03", "0,05", "0,1", "1", "0,3", "0,7", "0,04", "0,08", "3", "1", "0,85", "40", "181", "153", "120", "20", "0,2", "0,3"}));
    }

    @Test
    public void testTotalHCdisponíveisgNaoAceitarAcimavalorSuperior() {
        ColecaoAlimentos c = new ColecaoAlimentos();
        c.addHeaderTabela(new String[]{"Código", "PRODUTO", "Energia (kcal)", "Energia (kJ)", "Água (g)", "Proteína (g)", "Gordura total (g)", "Total HC disponíveis (g)", "Total HC expresso em monossacáridos (g)", "Mono + dissacáridos (g)", "Ácidos orgânicos (g)", "Álcool (g)", "Amido (g)", "Oligossacáridos (g)", "Fibra alimentar (g)", "Ácidos gordos saturados (g)", "Ácidos gordos monoinsaturados (g)", "Ácidos gordos polinsaturados  (g)", "Ácidos gordos trans (g)", "Ácido linoleico (g)", "Colesterol (mg)", "Retinol (vit. A total) (mg)", "Vit A total (equivalentes retinol) (mg)", "Caroteno (mg)", "vit. D (µg)", "a-tocoferol (mg)", "Tiamina (mg)", "Riboflavina (mg)", "Equivalentes de niacina (mg)", "Niacina (mg)", "Triptofano/60(mg)", "vit B6 (mg)", "Vit. B12 (µg)", "vit. C (mg)", "Folatos (µg)", "Cinza (g)", "Na (mg)", "K    (mg)", "Ca (mg)", "P (mg)", "Mg (mg)", "Fe (mg)", "Zn (mg)"});
        assertThrows(ForadeLimitesExcepcao.class, () -> c.addElemento(new String[]{"IS019", "Leite Cabra cru", "2", "290", "86,9", "3,8", "4", "1500.1", "4,8", "4,6", "0", "0", "0", "0", "0", "2,6", "1,1", "0,1", "0,1", "0,1", "11", "0,053", "53", "0", "0,05", "0,03", "0,05", "0,1", "1", "0,3", "0,7", "0,04", "0,08", "3", "1", "0,85", "40", "181", "153", "120", "20", "0,2", "0,3"}));
    }

    @Test
    public void testTotalHCexpressoemmonossacaridosgNaoAceitarAcimavalorSuperior() {
        ColecaoAlimentos c = new ColecaoAlimentos();
        c.addHeaderTabela(new String[]{"Código", "PRODUTO", "Energia (kcal)", "Energia (kJ)", "Água (g)", "Proteína (g)", "Gordura total (g)", "Total HC disponíveis (g)", "Total HC expresso em monossacáridos (g)", "Mono + dissacáridos (g)", "Ácidos orgânicos (g)", "Álcool (g)", "Amido (g)", "Oligossacáridos (g)", "Fibra alimentar (g)", "Ácidos gordos saturados (g)", "Ácidos gordos monoinsaturados (g)", "Ácidos gordos polinsaturados  (g)", "Ácidos gordos trans (g)", "Ácido linoleico (g)", "Colesterol (mg)", "Retinol (vit. A total) (mg)", "Vit A total (equivalentes retinol) (mg)", "Caroteno (mg)", "vit. D (µg)", "a-tocoferol (mg)", "Tiamina (mg)", "Riboflavina (mg)", "Equivalentes de niacina (mg)", "Niacina (mg)", "Triptofano/60(mg)", "vit B6 (mg)", "Vit. B12 (µg)", "vit. C (mg)", "Folatos (µg)", "Cinza (g)", "Na (mg)", "K    (mg)", "Ca (mg)", "P (mg)", "Mg (mg)", "Fe (mg)", "Zn (mg)"});
        assertThrows(ForadeLimitesExcepcao.class, () -> c.addElemento(new String[]{"IS019", "Leite Cabra cru", "2", "290", "86,9", "3,8", "4", "4,6", "1500.1", "4,6", "0", "0", "0", "0", "0", "2,6", "1,1", "0,1", "0,1", "0,1", "11", "0,053", "53", "0", "0,05", "0,03", "0,05", "0,1", "1", "0,3", "0,7", "0,04", "0,08", "3", "1", "0,85", "40", "181", "153", "120", "20", "0,2", "0,3"}));
    }

    @Test
    public void testMonodissacaridosgNaoAceitarAcimavalorSuperior() {
        ColecaoAlimentos c = new ColecaoAlimentos();
        c.addHeaderTabela(new String[]{"Código", "PRODUTO", "Energia (kcal)", "Energia (kJ)", "Água (g)", "Proteína (g)", "Gordura total (g)", "Total HC disponíveis (g)", "Total HC expresso em monossacáridos (g)", "Mono + dissacáridos (g)", "Ácidos orgânicos (g)", "Álcool (g)", "Amido (g)", "Oligossacáridos (g)", "Fibra alimentar (g)", "Ácidos gordos saturados (g)", "Ácidos gordos monoinsaturados (g)", "Ácidos gordos polinsaturados  (g)", "Ácidos gordos trans (g)", "Ácido linoleico (g)", "Colesterol (mg)", "Retinol (vit. A total) (mg)", "Vit A total (equivalentes retinol) (mg)", "Caroteno (mg)", "vit. D (µg)", "a-tocoferol (mg)", "Tiamina (mg)", "Riboflavina (mg)", "Equivalentes de niacina (mg)", "Niacina (mg)", "Triptofano/60(mg)", "vit B6 (mg)", "Vit. B12 (µg)", "vit. C (mg)", "Folatos (µg)", "Cinza (g)", "Na (mg)", "K    (mg)", "Ca (mg)", "P (mg)", "Mg (mg)", "Fe (mg)", "Zn (mg)"});
        assertThrows(ForadeLimitesExcepcao.class, () -> c.addElemento(new String[]{"IS019", "Leite Cabra cru", "2", "290", "86,9", "3,8", "4", "4,6", "4,8", "1500.1", "0", "0", "0", "0", "0", "2,6", "1,1", "0,1", "0,1", "0,1", "11", "0,053", "53", "0", "0,05", "0,03", "0,05", "0,1", "1", "0,3", "0,7", "0,04", "0,08", "3", "1", "0,85", "40", "181", "153", "120", "20", "0,2", "0,3"}));
    }

    @Test
    public void testacidosorgânicosgNaoAceitarAcimavalorSuperior() {
        ColecaoAlimentos c = new ColecaoAlimentos();
        c.addHeaderTabela(new String[]{"Código", "PRODUTO", "Energia (kcal)", "Energia (kJ)", "Água (g)", "Proteína (g)", "Gordura total (g)", "Total HC disponíveis (g)", "Total HC expresso em monossacáridos (g)", "Mono + dissacáridos (g)", "Ácidos orgânicos (g)", "Álcool (g)", "Amido (g)", "Oligossacáridos (g)", "Fibra alimentar (g)", "Ácidos gordos saturados (g)", "Ácidos gordos monoinsaturados (g)", "Ácidos gordos polinsaturados  (g)", "Ácidos gordos trans (g)", "Ácido linoleico (g)", "Colesterol (mg)", "Retinol (vit. A total) (mg)", "Vit A total (equivalentes retinol) (mg)", "Caroteno (mg)", "vit. D (µg)", "a-tocoferol (mg)", "Tiamina (mg)", "Riboflavina (mg)", "Equivalentes de niacina (mg)", "Niacina (mg)", "Triptofano/60(mg)", "vit B6 (mg)", "Vit. B12 (µg)", "vit. C (mg)", "Folatos (µg)", "Cinza (g)", "Na (mg)", "K    (mg)", "Ca (mg)", "P (mg)", "Mg (mg)", "Fe (mg)", "Zn (mg)"});
        assertThrows(ForadeLimitesExcepcao.class, () -> c.addElemento(new String[]{"IS019", "Leite Cabra cru", "2", "290", "86,9", "3,8", "4", "4,6", "4,8", "4,6", "1500.1", "0", "0", "0", "0", "2,6", "1,1", "0,1", "0,1", "0,1", "11", "0,053", "53", "0", "0,05", "0,03", "0,05", "0,1", "1", "0,3", "0,7", "0,04", "0,08", "3", "1", "0,85", "40", "181", "153", "120", "20", "0,2", "0,3"}));
    }

    @Test
    public void testalcoolgNaoAceitarAcimavalorSuperior() {
        ColecaoAlimentos c = new ColecaoAlimentos();
        c.addHeaderTabela(new String[]{"Código", "PRODUTO", "Energia (kcal)", "Energia (kJ)", "Água (g)", "Proteína (g)", "Gordura total (g)", "Total HC disponíveis (g)", "Total HC expresso em monossacáridos (g)", "Mono + dissacáridos (g)", "Ácidos orgânicos (g)", "Álcool (g)", "Amido (g)", "Oligossacáridos (g)", "Fibra alimentar (g)", "Ácidos gordos saturados (g)", "Ácidos gordos monoinsaturados (g)", "Ácidos gordos polinsaturados  (g)", "Ácidos gordos trans (g)", "Ácido linoleico (g)", "Colesterol (mg)", "Retinol (vit. A total) (mg)", "Vit A total (equivalentes retinol) (mg)", "Caroteno (mg)", "vit. D (µg)", "a-tocoferol (mg)", "Tiamina (mg)", "Riboflavina (mg)", "Equivalentes de niacina (mg)", "Niacina (mg)", "Triptofano/60(mg)", "vit B6 (mg)", "Vit. B12 (µg)", "vit. C (mg)", "Folatos (µg)", "Cinza (g)", "Na (mg)", "K    (mg)", "Ca (mg)", "P (mg)", "Mg (mg)", "Fe (mg)", "Zn (mg)"});
        assertThrows(ForadeLimitesExcepcao.class, () -> c.addElemento(new String[]{"IS019", "Leite Cabra cru", "2", "290", "86,9", "3,8", "4", "4,6", "4,8", "4,6", "0", "1500.1", "0", "0", "0", "2,6", "1,1", "0,1", "0,1", "0,1", "11", "0,053", "53", "0", "0,05", "0,03", "0,05", "0,1", "1", "0,3", "0,7", "0,04", "0,08", "3", "1", "0,85", "40", "181", "153", "120", "20", "0,2", "0,3"}));
    }

    @Test
    public void testAmidogNaoAceitarAcimavalorSuperior() {
        ColecaoAlimentos c = new ColecaoAlimentos();
        c.addHeaderTabela(new String[]{"Código", "PRODUTO", "Energia (kcal)", "Energia (kJ)", "Água (g)", "Proteína (g)", "Gordura total (g)", "Total HC disponíveis (g)", "Total HC expresso em monossacáridos (g)", "Mono + dissacáridos (g)", "Ácidos orgânicos (g)", "Álcool (g)", "Amido (g)", "Oligossacáridos (g)", "Fibra alimentar (g)", "Ácidos gordos saturados (g)", "Ácidos gordos monoinsaturados (g)", "Ácidos gordos polinsaturados  (g)", "Ácidos gordos trans (g)", "Ácido linoleico (g)", "Colesterol (mg)", "Retinol (vit. A total) (mg)", "Vit A total (equivalentes retinol) (mg)", "Caroteno (mg)", "vit. D (µg)", "a-tocoferol (mg)", "Tiamina (mg)", "Riboflavina (mg)", "Equivalentes de niacina (mg)", "Niacina (mg)", "Triptofano/60(mg)", "vit B6 (mg)", "Vit. B12 (µg)", "vit. C (mg)", "Folatos (µg)", "Cinza (g)", "Na (mg)", "K    (mg)", "Ca (mg)", "P (mg)", "Mg (mg)", "Fe (mg)", "Zn (mg)"});
        assertThrows(ForadeLimitesExcepcao.class, () -> c.addElemento(new String[]{"IS019", "Leite Cabra cru", "2", "290", "86,9", "3,8", "4", "4,6", "4,8", "4,6", "0", "0", "1500.1", "0", "0", "2,6", "1,1", "0,1", "0,1", "0,1", "11", "0,053", "53", "0", "0,05", "0,03", "0,05", "0,1", "1", "0,3", "0,7", "0,04", "0,08", "3", "1", "0,85", "40", "181", "153", "120", "20", "0,2", "0,3"}));
    }

    @Test
    public void testOligossacaridosgNaoAceitarAcimavalorSuperior() {
        ColecaoAlimentos c = new ColecaoAlimentos();
        c.addHeaderTabela(new String[]{"Código", "PRODUTO", "Energia (kcal)", "Energia (kJ)", "Água (g)", "Proteína (g)", "Gordura total (g)", "Total HC disponíveis (g)", "Total HC expresso em monossacáridos (g)", "Mono + dissacáridos (g)", "Ácidos orgânicos (g)", "Álcool (g)", "Amido (g)", "Oligossacáridos (g)", "Fibra alimentar (g)", "Ácidos gordos saturados (g)", "Ácidos gordos monoinsaturados (g)", "Ácidos gordos polinsaturados  (g)", "Ácidos gordos trans (g)", "Ácido linoleico (g)", "Colesterol (mg)", "Retinol (vit. A total) (mg)", "Vit A total (equivalentes retinol) (mg)", "Caroteno (mg)", "vit. D (µg)", "a-tocoferol (mg)", "Tiamina (mg)", "Riboflavina (mg)", "Equivalentes de niacina (mg)", "Niacina (mg)", "Triptofano/60(mg)", "vit B6 (mg)", "Vit. B12 (µg)", "vit. C (mg)", "Folatos (µg)", "Cinza (g)", "Na (mg)", "K    (mg)", "Ca (mg)", "P (mg)", "Mg (mg)", "Fe (mg)", "Zn (mg)"});
        assertThrows(ForadeLimitesExcepcao.class, () -> c.addElemento(new String[]{"IS019", "Leite Cabra cru", "2", "290", "86,9", "3,8", "4", "4,6", "4,8", "4,6", "0", "0", "0", "1500.1", "0", "2,6", "1,1", "0,1", "0,1", "0,1", "11", "0,053", "53", "0", "0,05", "0,03", "0,05", "0,1", "1", "0,3", "0,7", "0,04", "0,08", "3", "1", "0,85", "40", "181", "153", "120", "20", "0,2", "0,3"}));
    }

    @Test
    public void testFibraalimentargNaoAceitarAcimavalorSuperior() {
        ColecaoAlimentos c = new ColecaoAlimentos();
        c.addHeaderTabela(new String[]{"Código", "PRODUTO", "Energia (kcal)", "Energia (kJ)", "Água (g)", "Proteína (g)", "Gordura total (g)", "Total HC disponíveis (g)", "Total HC expresso em monossacáridos (g)", "Mono + dissacáridos (g)", "Ácidos orgânicos (g)", "Álcool (g)", "Amido (g)", "Oligossacáridos (g)", "Fibra alimentar (g)", "Ácidos gordos saturados (g)", "Ácidos gordos monoinsaturados (g)", "Ácidos gordos polinsaturados  (g)", "Ácidos gordos trans (g)", "Ácido linoleico (g)", "Colesterol (mg)", "Retinol (vit. A total) (mg)", "Vit A total (equivalentes retinol) (mg)", "Caroteno (mg)", "vit. D (µg)", "a-tocoferol (mg)", "Tiamina (mg)", "Riboflavina (mg)", "Equivalentes de niacina (mg)", "Niacina (mg)", "Triptofano/60(mg)", "vit B6 (mg)", "Vit. B12 (µg)", "vit. C (mg)", "Folatos (µg)", "Cinza (g)", "Na (mg)", "K    (mg)", "Ca (mg)", "P (mg)", "Mg (mg)", "Fe (mg)", "Zn (mg)"});
        assertThrows(ForadeLimitesExcepcao.class, () -> c.addElemento(new String[]{"IS019", "Leite Cabra cru", "2", "290", "86,9", "3,8", "4", "4,6", "4,8", "4,6", "0", "0", "0", "0", "1500.1", "2,6", "1,1", "0,1", "0,1", "0,1", "11", "0,053", "53", "0", "0,05", "0,03", "0,05", "0,1", "1", "0,3", "0,7", "0,04", "0,08", "3", "1", "0,85", "40", "181", "153", "120", "20", "0,2", "0,3"}));
    }

    @Test
    public void testacidosgordossaturadosgNaoAceitarAcimavalorSuperior() {
        ColecaoAlimentos c = new ColecaoAlimentos();
        c.addHeaderTabela(new String[]{"Código", "PRODUTO", "Energia (kcal)", "Energia (kJ)", "Água (g)", "Proteína (g)", "Gordura total (g)", "Total HC disponíveis (g)", "Total HC expresso em monossacáridos (g)", "Mono + dissacáridos (g)", "Ácidos orgânicos (g)", "Álcool (g)", "Amido (g)", "Oligossacáridos (g)", "Fibra alimentar (g)", "Ácidos gordos saturados (g)", "Ácidos gordos monoinsaturados (g)", "Ácidos gordos polinsaturados  (g)", "Ácidos gordos trans (g)", "Ácido linoleico (g)", "Colesterol (mg)", "Retinol (vit. A total) (mg)", "Vit A total (equivalentes retinol) (mg)", "Caroteno (mg)", "vit. D (µg)", "a-tocoferol (mg)", "Tiamina (mg)", "Riboflavina (mg)", "Equivalentes de niacina (mg)", "Niacina (mg)", "Triptofano/60(mg)", "vit B6 (mg)", "Vit. B12 (µg)", "vit. C (mg)", "Folatos (µg)", "Cinza (g)", "Na (mg)", "K    (mg)", "Ca (mg)", "P (mg)", "Mg (mg)", "Fe (mg)", "Zn (mg)"});
        assertThrows(ForadeLimitesExcepcao.class, () -> c.addElemento(new String[]{"IS019", "Leite Cabra cru", "2", "290", "86,9", "3,8", "4", "4,6", "4,8", "4,6", "0", "0", "0", "0", "0", "1500.1", "1,1", "0,1", "0,1", "0,1", "11", "0,053", "53", "0", "0,05", "0,03", "0,05", "0,1", "1", "0,3", "0,7", "0,04", "0,08", "3", "1", "0,85", "40", "181", "153", "120", "20", "0,2", "0,3"}));
    }

    @Test
    public void testacidosgordosmonoinsaturadosgNaoAceitarAcimavalorSuperior() {
        ColecaoAlimentos c = new ColecaoAlimentos();
        c.addHeaderTabela(new String[]{"Código", "PRODUTO", "Energia (kcal)", "Energia (kJ)", "Água (g)", "Proteína (g)", "Gordura total (g)", "Total HC disponíveis (g)", "Total HC expresso em monossacáridos (g)", "Mono + dissacáridos (g)", "Ácidos orgânicos (g)", "Álcool (g)", "Amido (g)", "Oligossacáridos (g)", "Fibra alimentar (g)", "Ácidos gordos saturados (g)", "Ácidos gordos monoinsaturados (g)", "Ácidos gordos polinsaturados  (g)", "Ácidos gordos trans (g)", "Ácido linoleico (g)", "Colesterol (mg)", "Retinol (vit. A total) (mg)", "Vit A total (equivalentes retinol) (mg)", "Caroteno (mg)", "vit. D (µg)", "a-tocoferol (mg)", "Tiamina (mg)", "Riboflavina (mg)", "Equivalentes de niacina (mg)", "Niacina (mg)", "Triptofano/60(mg)", "vit B6 (mg)", "Vit. B12 (µg)", "vit. C (mg)", "Folatos (µg)", "Cinza (g)", "Na (mg)", "K    (mg)", "Ca (mg)", "P (mg)", "Mg (mg)", "Fe (mg)", "Zn (mg)"});
        assertThrows(ForadeLimitesExcepcao.class, () -> c.addElemento(new String[]{"IS019", "Leite Cabra cru", "2", "290", "86,9", "3,8", "4", "4,6", "4,8", "4,6", "0", "0", "0", "0", "0", "2,6", "1500.1", "0,1", "0,1", "0,1", "11", "0,053", "53", "0", "0,05", "0,03", "0,05", "0,1", "1", "0,3", "0,7", "0,04", "0,08", "3", "1", "0,85", "40", "181", "153", "120", "20", "0,2", "0,3"}));
    }

    @Test
    public void testacidosgordospolinsaturadosgNaoAceitarAcimavalorSuperior() {
        ColecaoAlimentos c = new ColecaoAlimentos();
        c.addHeaderTabela(new String[]{"Código", "PRODUTO", "Energia (kcal)", "Energia (kJ)", "Água (g)", "Proteína (g)", "Gordura total (g)", "Total HC disponíveis (g)", "Total HC expresso em monossacáridos (g)", "Mono + dissacáridos (g)", "Ácidos orgânicos (g)", "Álcool (g)", "Amido (g)", "Oligossacáridos (g)", "Fibra alimentar (g)", "Ácidos gordos saturados (g)", "Ácidos gordos monoinsaturados (g)", "Ácidos gordos polinsaturados  (g)", "Ácidos gordos trans (g)", "Ácido linoleico (g)", "Colesterol (mg)", "Retinol (vit. A total) (mg)", "Vit A total (equivalentes retinol) (mg)", "Caroteno (mg)", "vit. D (µg)", "a-tocoferol (mg)", "Tiamina (mg)", "Riboflavina (mg)", "Equivalentes de niacina (mg)", "Niacina (mg)", "Triptofano/60(mg)", "vit B6 (mg)", "Vit. B12 (µg)", "vit. C (mg)", "Folatos (µg)", "Cinza (g)", "Na (mg)", "K    (mg)", "Ca (mg)", "P (mg)", "Mg (mg)", "Fe (mg)", "Zn (mg)"});
        assertThrows(ForadeLimitesExcepcao.class, () -> c.addElemento(new String[]{"IS019", "Leite Cabra cru", "2", "290", "86,9", "3,8", "4", "4,6", "4,8", "4,6", "0", "0", "0", "0", "0", "2,6", "1,1", "1500.1", "0,1", "0,1", "11", "0,053", "53", "0", "0,05", "0,03", "0,05", "0,1", "1", "0,3", "0,7", "0,04", "0,08", "3", "1", "0,85", "40", "181", "153", "120", "20", "0,2", "0,3"}));
    }

    @Test
    public void testacidosgordostransgNaoAceitarAcimavalorSuperior() {
        ColecaoAlimentos c = new ColecaoAlimentos();
        c.addHeaderTabela(new String[]{"Código", "PRODUTO", "Energia (kcal)", "Energia (kJ)", "Água (g)", "Proteína (g)", "Gordura total (g)", "Total HC disponíveis (g)", "Total HC expresso em monossacáridos (g)", "Mono + dissacáridos (g)", "Ácidos orgânicos (g)", "Álcool (g)", "Amido (g)", "Oligossacáridos (g)", "Fibra alimentar (g)", "Ácidos gordos saturados (g)", "Ácidos gordos monoinsaturados (g)", "Ácidos gordos polinsaturados  (g)", "Ácidos gordos trans (g)", "Ácido linoleico (g)", "Colesterol (mg)", "Retinol (vit. A total) (mg)", "Vit A total (equivalentes retinol) (mg)", "Caroteno (mg)", "vit. D (µg)", "a-tocoferol (mg)", "Tiamina (mg)", "Riboflavina (mg)", "Equivalentes de niacina (mg)", "Niacina (mg)", "Triptofano/60(mg)", "vit B6 (mg)", "Vit. B12 (µg)", "vit. C (mg)", "Folatos (µg)", "Cinza (g)", "Na (mg)", "K    (mg)", "Ca (mg)", "P (mg)", "Mg (mg)", "Fe (mg)", "Zn (mg)"});
        assertThrows(ForadeLimitesExcepcao.class, () -> c.addElemento(new String[]{"IS019", "Leite Cabra cru", "2", "290", "86,9", "3,8", "4", "4,6", "4,8", "4,6", "0", "0", "0", "0", "0", "2,6", "1,1", "0,1", "1500.1", "0,1", "11", "0,053", "53", "0", "0,05", "0,03", "0,05", "0,1", "1", "0,3", "0,7", "0,04", "0,08", "3", "1", "0,85", "40", "181", "153", "120", "20", "0,2", "0,3"}));
    }

    @Test
    public void testacidolinoleicogNaoAceitarAcimavalorSuperior() {
        ColecaoAlimentos c = new ColecaoAlimentos();
        c.addHeaderTabela(new String[]{"Código", "PRODUTO", "Energia (kcal)", "Energia (kJ)", "Água (g)", "Proteína (g)", "Gordura total (g)", "Total HC disponíveis (g)", "Total HC expresso em monossacáridos (g)", "Mono + dissacáridos (g)", "Ácidos orgânicos (g)", "Álcool (g)", "Amido (g)", "Oligossacáridos (g)", "Fibra alimentar (g)", "Ácidos gordos saturados (g)", "Ácidos gordos monoinsaturados (g)", "Ácidos gordos polinsaturados  (g)", "Ácidos gordos trans (g)", "Ácido linoleico (g)", "Colesterol (mg)", "Retinol (vit. A total) (mg)", "Vit A total (equivalentes retinol) (mg)", "Caroteno (mg)", "vit. D (µg)", "a-tocoferol (mg)", "Tiamina (mg)", "Riboflavina (mg)", "Equivalentes de niacina (mg)", "Niacina (mg)", "Triptofano/60(mg)", "vit B6 (mg)", "Vit. B12 (µg)", "vit. C (mg)", "Folatos (µg)", "Cinza (g)", "Na (mg)", "K    (mg)", "Ca (mg)", "P (mg)", "Mg (mg)", "Fe (mg)", "Zn (mg)"});
        assertThrows(ForadeLimitesExcepcao.class, () -> c.addElemento(new String[]{"IS019", "Leite Cabra cru", "2", "290", "86,9", "3,8", "4", "4,6", "4,8", "4,6", "0", "0", "0", "0", "0", "2,6", "1,1", "0,1", "0,1", "1500.1", "11", "0,053", "53", "0", "0,05", "0,03", "0,05", "0,1", "1", "0,3", "0,7", "0,04", "0,08", "3", "1", "0,85", "40", "181", "153", "120", "20", "0,2", "0,3"}));
    }

    @Test
    public void testColesterolmgNaoAceitarAcimavalorSuperior() {
        ColecaoAlimentos c = new ColecaoAlimentos();
        c.addHeaderTabela(new String[]{"Código", "PRODUTO", "Energia (kcal)", "Energia (kJ)", "Água (g)", "Proteína (g)", "Gordura total (g)", "Total HC disponíveis (g)", "Total HC expresso em monossacáridos (g)", "Mono + dissacáridos (g)", "Ácidos orgânicos (g)", "Álcool (g)", "Amido (g)", "Oligossacáridos (g)", "Fibra alimentar (g)", "Ácidos gordos saturados (g)", "Ácidos gordos monoinsaturados (g)", "Ácidos gordos polinsaturados  (g)", "Ácidos gordos trans (g)", "Ácido linoleico (g)", "Colesterol (mg)", "Retinol (vit. A total) (mg)", "Vit A total (equivalentes retinol) (mg)", "Caroteno (mg)", "vit. D (µg)", "a-tocoferol (mg)", "Tiamina (mg)", "Riboflavina (mg)", "Equivalentes de niacina (mg)", "Niacina (mg)", "Triptofano/60(mg)", "vit B6 (mg)", "Vit. B12 (µg)", "vit. C (mg)", "Folatos (µg)", "Cinza (g)", "Na (mg)", "K    (mg)", "Ca (mg)", "P (mg)", "Mg (mg)", "Fe (mg)", "Zn (mg)"});
        assertThrows(ForadeLimitesExcepcao.class, () -> c.addElemento(new String[]{"IS019", "Leite Cabra cru", "2", "290", "86,9", "3,8", "4", "4,6", "4,8", "4,6", "0", "0", "0", "0", "0", "2,6", "1,1", "0,1", "0,1", "0,1", "1500.1", "0,053", "53", "0", "0,05", "0,03", "0,05", "0,1", "1", "0,3", "0,7", "0,04", "0,08", "3", "1", "0,85", "40", "181", "153", "120", "20", "0,2", "0,3"}));
    }

    @Test
    public void testRetinolvitAtotalmgNaoAceitarAcimavalorSuperior() {
        ColecaoAlimentos c = new ColecaoAlimentos();
        c.addHeaderTabela(new String[]{"Código", "PRODUTO", "Energia (kcal)", "Energia (kJ)", "Água (g)", "Proteína (g)", "Gordura total (g)", "Total HC disponíveis (g)", "Total HC expresso em monossacáridos (g)", "Mono + dissacáridos (g)", "Ácidos orgânicos (g)", "Álcool (g)", "Amido (g)", "Oligossacáridos (g)", "Fibra alimentar (g)", "Ácidos gordos saturados (g)", "Ácidos gordos monoinsaturados (g)", "Ácidos gordos polinsaturados  (g)", "Ácidos gordos trans (g)", "Ácido linoleico (g)", "Colesterol (mg)", "Retinol (vit. A total) (mg)", "Vit A total (equivalentes retinol) (mg)", "Caroteno (mg)", "vit. D (µg)", "a-tocoferol (mg)", "Tiamina (mg)", "Riboflavina (mg)", "Equivalentes de niacina (mg)", "Niacina (mg)", "Triptofano/60(mg)", "vit B6 (mg)", "Vit. B12 (µg)", "vit. C (mg)", "Folatos (µg)", "Cinza (g)", "Na (mg)", "K    (mg)", "Ca (mg)", "P (mg)", "Mg (mg)", "Fe (mg)", "Zn (mg)"});
        assertThrows(ForadeLimitesExcepcao.class, () -> c.addElemento(new String[]{"IS019", "Leite Cabra cru", "2", "290", "86,9", "3,8", "4", "4,6", "4,8", "4,6", "0", "0", "0", "0", "0", "2,6", "1,1", "0,1", "0,1", "0,1", "11", "1500.1", "53", "0", "0,05", "0,03", "0,05", "0,1", "1", "0,3", "0,7", "0,04", "0,08", "3", "1", "0,85", "40", "181", "153", "120", "20", "0,2", "0,3"}));
    }

    @Test
    public void testVitAtotalequivalentesretinolmgNaoAceitarAcimavalorSuperior() {
        ColecaoAlimentos c = new ColecaoAlimentos();
        c.addHeaderTabela(new String[]{"Código", "PRODUTO", "Energia (kcal)", "Energia (kJ)", "Água (g)", "Proteína (g)", "Gordura total (g)", "Total HC disponíveis (g)", "Total HC expresso em monossacáridos (g)", "Mono + dissacáridos (g)", "Ácidos orgânicos (g)", "Álcool (g)", "Amido (g)", "Oligossacáridos (g)", "Fibra alimentar (g)", "Ácidos gordos saturados (g)", "Ácidos gordos monoinsaturados (g)", "Ácidos gordos polinsaturados  (g)", "Ácidos gordos trans (g)", "Ácido linoleico (g)", "Colesterol (mg)", "Retinol (vit. A total) (mg)", "Vit A total (equivalentes retinol) (mg)", "Caroteno (mg)", "vit. D (µg)", "a-tocoferol (mg)", "Tiamina (mg)", "Riboflavina (mg)", "Equivalentes de niacina (mg)", "Niacina (mg)", "Triptofano/60(mg)", "vit B6 (mg)", "Vit. B12 (µg)", "vit. C (mg)", "Folatos (µg)", "Cinza (g)", "Na (mg)", "K    (mg)", "Ca (mg)", "P (mg)", "Mg (mg)", "Fe (mg)", "Zn (mg)"});
        assertThrows(ForadeLimitesExcepcao.class, () -> c.addElemento(new String[]{"IS019", "Leite Cabra cru", "2", "290", "86,9", "3,8", "4", "4,6", "4,8", "4,6", "0", "0", "0", "0", "0", "2,6", "1,1", "0,1", "0,1", "0,1", "11", "0,053", "15000.1", "0", "0,05", "0,03", "0,05", "0,1", "1", "0,3", "0,7", "0,04", "0,08", "3", "1", "0,85", "40", "181", "153", "120", "20", "0,2", "0,3"}));
    }

    @Test
    public void testCarotenomgNaoAceitarAcimavalorSuperior() {
        ColecaoAlimentos c = new ColecaoAlimentos();
        c.addHeaderTabela(new String[]{"Código", "PRODUTO", "Energia (kcal)", "Energia (kJ)", "Água (g)", "Proteína (g)", "Gordura total (g)", "Total HC disponíveis (g)", "Total HC expresso em monossacáridos (g)", "Mono + dissacáridos (g)", "Ácidos orgânicos (g)", "Álcool (g)", "Amido (g)", "Oligossacáridos (g)", "Fibra alimentar (g)", "Ácidos gordos saturados (g)", "Ácidos gordos monoinsaturados (g)", "Ácidos gordos polinsaturados  (g)", "Ácidos gordos trans (g)", "Ácido linoleico (g)", "Colesterol (mg)", "Retinol (vit. A total) (mg)", "Vit A total (equivalentes retinol) (mg)", "Caroteno (mg)", "vit. D (µg)", "a-tocoferol (mg)", "Tiamina (mg)", "Riboflavina (mg)", "Equivalentes de niacina (mg)", "Niacina (mg)", "Triptofano/60(mg)", "vit B6 (mg)", "Vit. B12 (µg)", "vit. C (mg)", "Folatos (µg)", "Cinza (g)", "Na (mg)", "K    (mg)", "Ca (mg)", "P (mg)", "Mg (mg)", "Fe (mg)", "Zn (mg)"});
        assertThrows(ForadeLimitesExcepcao.class, () -> c.addElemento(new String[]{"IS019", "Leite Cabra cru", "2", "290", "86,9", "3,8", "4", "4,6", "4,8", "4,6", "0", "0", "0", "0", "0", "2,6", "1,1", "0,1", "0,1", "0,1", "11", "0,053", "53", "40000.1", "0,05", "0,03", "0,05", "0,1", "1", "0,3", "0,7", "0,04", "0,08", "3", "1", "0,85", "40", "181", "153", "120", "20", "0,2", "0,3"}));
    }

    @Test
    public void testvitDµgNaoAceitarAcimavalorSuperior() {
        ColecaoAlimentos c = new ColecaoAlimentos();
        c.addHeaderTabela(new String[]{"Código", "PRODUTO", "Energia (kcal)", "Energia (kJ)", "Água (g)", "Proteína (g)", "Gordura total (g)", "Total HC disponíveis (g)", "Total HC expresso em monossacáridos (g)", "Mono + dissacáridos (g)", "Ácidos orgânicos (g)", "Álcool (g)", "Amido (g)", "Oligossacáridos (g)", "Fibra alimentar (g)", "Ácidos gordos saturados (g)", "Ácidos gordos monoinsaturados (g)", "Ácidos gordos polinsaturados  (g)", "Ácidos gordos trans (g)", "Ácido linoleico (g)", "Colesterol (mg)", "Retinol (vit. A total) (mg)", "Vit A total (equivalentes retinol) (mg)", "Caroteno (mg)", "vit. D (µg)", "a-tocoferol (mg)", "Tiamina (mg)", "Riboflavina (mg)", "Equivalentes de niacina (mg)", "Niacina (mg)", "Triptofano/60(mg)", "vit B6 (mg)", "Vit. B12 (µg)", "vit. C (mg)", "Folatos (µg)", "Cinza (g)", "Na (mg)", "K    (mg)", "Ca (mg)", "P (mg)", "Mg (mg)", "Fe (mg)", "Zn (mg)"});
        assertThrows(ForadeLimitesExcepcao.class, () -> c.addElemento(new String[]{"IS019", "Leite Cabra cru", "2", "290", "86,9", "3,8", "4", "4,6", "4,8", "4,6", "0", "0", "0", "0", "0", "2,6", "1,1", "0,1", "0,1", "0,1", "11", "0,053", "53", "0", "1500.1", "0,03", "0,05", "0,1", "1", "0,3", "0,7", "0,04", "0,08", "3", "1", "0,85", "40", "181", "153", "120", "20", "0,2", "0,3"}));
    }

    @Test
    public void testatocoferolmgNaoAceitarAcimavalorSuperior() {
        ColecaoAlimentos c = new ColecaoAlimentos();
        c.addHeaderTabela(new String[]{"Código", "PRODUTO", "Energia (kcal)", "Energia (kJ)", "Água (g)", "Proteína (g)", "Gordura total (g)", "Total HC disponíveis (g)", "Total HC expresso em monossacáridos (g)", "Mono + dissacáridos (g)", "Ácidos orgânicos (g)", "Álcool (g)", "Amido (g)", "Oligossacáridos (g)", "Fibra alimentar (g)", "Ácidos gordos saturados (g)", "Ácidos gordos monoinsaturados (g)", "Ácidos gordos polinsaturados  (g)", "Ácidos gordos trans (g)", "Ácido linoleico (g)", "Colesterol (mg)", "Retinol (vit. A total) (mg)", "Vit A total (equivalentes retinol) (mg)", "Caroteno (mg)", "vit. D (µg)", "a-tocoferol (mg)", "Tiamina (mg)", "Riboflavina (mg)", "Equivalentes de niacina (mg)", "Niacina (mg)", "Triptofano/60(mg)", "vit B6 (mg)", "Vit. B12 (µg)", "vit. C (mg)", "Folatos (µg)", "Cinza (g)", "Na (mg)", "K    (mg)", "Ca (mg)", "P (mg)", "Mg (mg)", "Fe (mg)", "Zn (mg)"});
        assertThrows(ForadeLimitesExcepcao.class, () -> c.addElemento(new String[]{"IS019", "Leite Cabra cru", "2", "290", "86,9", "3,8", "4", "4,6", "4,8", "4,6", "0", "0", "0", "0", "0", "2,6", "1,1", "0,1", "0,1", "0,1", "11", "0,053", "53", "0", "0,05", "1500.1", "0,05", "0,1", "1", "0,3", "0,7", "0,04", "0,08", "3", "1", "0,85", "40", "181", "153", "120", "20", "0,2", "0,3"}));
    }

    @Test
    public void testTiaminamgNaoAceitarAcimavalorSuperior() {
        ColecaoAlimentos c = new ColecaoAlimentos();
        c.addHeaderTabela(new String[]{"Código", "PRODUTO", "Energia (kcal)", "Energia (kJ)", "Água (g)", "Proteína (g)", "Gordura total (g)", "Total HC disponíveis (g)", "Total HC expresso em monossacáridos (g)", "Mono + dissacáridos (g)", "Ácidos orgânicos (g)", "Álcool (g)", "Amido (g)", "Oligossacáridos (g)", "Fibra alimentar (g)", "Ácidos gordos saturados (g)", "Ácidos gordos monoinsaturados (g)", "Ácidos gordos polinsaturados  (g)", "Ácidos gordos trans (g)", "Ácido linoleico (g)", "Colesterol (mg)", "Retinol (vit. A total) (mg)", "Vit A total (equivalentes retinol) (mg)", "Caroteno (mg)", "vit. D (µg)", "a-tocoferol (mg)", "Tiamina (mg)", "Riboflavina (mg)", "Equivalentes de niacina (mg)", "Niacina (mg)", "Triptofano/60(mg)", "vit B6 (mg)", "Vit. B12 (µg)", "vit. C (mg)", "Folatos (µg)", "Cinza (g)", "Na (mg)", "K    (mg)", "Ca (mg)", "P (mg)", "Mg (mg)", "Fe (mg)", "Zn (mg)"});
        assertThrows(ForadeLimitesExcepcao.class, () -> c.addElemento(new String[]{"IS019", "Leite Cabra cru", "2", "290", "86,9", "3,8", "4", "4,6", "4,8", "4,6", "0", "0", "0", "0", "0", "2,6", "1,1", "0,1", "0,1", "0,1", "11", "0,053", "53", "0", "0,05", "0,03", "1500.1", "0,1", "1", "0,3", "0,7", "0,04", "0,08", "3", "1", "0,85", "40", "181", "153", "120", "20", "0,2", "0,3"}));
    }

    @Test
    public void testRiboflavinamgNaoAceitarAcimavalorSuperior() {
        ColecaoAlimentos c = new ColecaoAlimentos();
        c.addHeaderTabela(new String[]{"Código", "PRODUTO", "Energia (kcal)", "Energia (kJ)", "Água (g)", "Proteína (g)", "Gordura total (g)", "Total HC disponíveis (g)", "Total HC expresso em monossacáridos (g)", "Mono + dissacáridos (g)", "Ácidos orgânicos (g)", "Álcool (g)", "Amido (g)", "Oligossacáridos (g)", "Fibra alimentar (g)", "Ácidos gordos saturados (g)", "Ácidos gordos monoinsaturados (g)", "Ácidos gordos polinsaturados  (g)", "Ácidos gordos trans (g)", "Ácido linoleico (g)", "Colesterol (mg)", "Retinol (vit. A total) (mg)", "Vit A total (equivalentes retinol) (mg)", "Caroteno (mg)", "vit. D (µg)", "a-tocoferol (mg)", "Tiamina (mg)", "Riboflavina (mg)", "Equivalentes de niacina (mg)", "Niacina (mg)", "Triptofano/60(mg)", "vit B6 (mg)", "Vit. B12 (µg)", "vit. C (mg)", "Folatos (µg)", "Cinza (g)", "Na (mg)", "K    (mg)", "Ca (mg)", "P (mg)", "Mg (mg)", "Fe (mg)", "Zn (mg)"});
        assertThrows(ForadeLimitesExcepcao.class, () -> c.addElemento(new String[]{"IS019", "Leite Cabra cru", "2", "290", "86,9", "3,8", "4", "4,6", "4,8", "4,6", "0", "0", "0", "0", "0", "2,6", "1,1", "0,1", "0,1", "0,1", "11", "0,053", "53", "0", "0,05", "0,03", "0,05", "1500.1", "1", "0,3", "0,7", "0,04", "0,08", "3", "1", "0,85", "40", "181", "153", "120", "20", "0,2", "0,3"}));
    }

    @Test
    public void testEquivalentesdeniacinamgNaoAceitarAcimavalorSuperior() {
        ColecaoAlimentos c = new ColecaoAlimentos();
        c.addHeaderTabela(new String[]{"Código", "PRODUTO", "Energia (kcal)", "Energia (kJ)", "Água (g)", "Proteína (g)", "Gordura total (g)", "Total HC disponíveis (g)", "Total HC expresso em monossacáridos (g)", "Mono + dissacáridos (g)", "Ácidos orgânicos (g)", "Álcool (g)", "Amido (g)", "Oligossacáridos (g)", "Fibra alimentar (g)", "Ácidos gordos saturados (g)", "Ácidos gordos monoinsaturados (g)", "Ácidos gordos polinsaturados  (g)", "Ácidos gordos trans (g)", "Ácido linoleico (g)", "Colesterol (mg)", "Retinol (vit. A total) (mg)", "Vit A total (equivalentes retinol) (mg)", "Caroteno (mg)", "vit. D (µg)", "a-tocoferol (mg)", "Tiamina (mg)", "Riboflavina (mg)", "Equivalentes de niacina (mg)", "Niacina (mg)", "Triptofano/60(mg)", "vit B6 (mg)", "Vit. B12 (µg)", "vit. C (mg)", "Folatos (µg)", "Cinza (g)", "Na (mg)", "K    (mg)", "Ca (mg)", "P (mg)", "Mg (mg)", "Fe (mg)", "Zn (mg)"});
        assertThrows(ForadeLimitesExcepcao.class, () -> c.addElemento(new String[]{"IS019", "Leite Cabra cru", "2", "290", "86,9", "3,8", "4", "4,6", "4,8", "4,6", "0", "0", "0", "0", "0", "2,6", "1,1", "0,1", "0,1", "0,1", "11", "0,053", "53", "0", "0,05", "0,03", "0,05", "0,1", "1500.1", "0,3", "0,7", "0,04", "0,08", "3", "1", "0,85", "40", "181", "153", "120", "20", "0,2", "0,3"}));
    }

    @Test
    public void testNiacinamgNaoAceitarAcimavalorSuperior() {
        ColecaoAlimentos c = new ColecaoAlimentos();
        c.addHeaderTabela(new String[]{"Código", "PRODUTO", "Energia (kcal)", "Energia (kJ)", "Água (g)", "Proteína (g)", "Gordura total (g)", "Total HC disponíveis (g)", "Total HC expresso em monossacáridos (g)", "Mono + dissacáridos (g)", "Ácidos orgânicos (g)", "Álcool (g)", "Amido (g)", "Oligossacáridos (g)", "Fibra alimentar (g)", "Ácidos gordos saturados (g)", "Ácidos gordos monoinsaturados (g)", "Ácidos gordos polinsaturados  (g)", "Ácidos gordos trans (g)", "Ácido linoleico (g)", "Colesterol (mg)", "Retinol (vit. A total) (mg)", "Vit A total (equivalentes retinol) (mg)", "Caroteno (mg)", "vit. D (µg)", "a-tocoferol (mg)", "Tiamina (mg)", "Riboflavina (mg)", "Equivalentes de niacina (mg)", "Niacina (mg)", "Triptofano/60(mg)", "vit B6 (mg)", "Vit. B12 (µg)", "vit. C (mg)", "Folatos (µg)", "Cinza (g)", "Na (mg)", "K    (mg)", "Ca (mg)", "P (mg)", "Mg (mg)", "Fe (mg)", "Zn (mg)"});
        assertThrows(ForadeLimitesExcepcao.class, () -> c.addElemento(new String[]{"IS019", "Leite Cabra cru", "2", "290", "86,9", "3,8", "4", "4,6", "4,8", "4,6", "0", "0", "0", "0", "0", "2,6", "1,1", "0,1", "0,1", "0,1", "11", "0,053", "53", "0", "0,05", "0,03", "0,05", "0,1", "1", "1500.1", "0,7", "0,04", "0,08", "3", "1", "0,85", "40", "181", "153", "120", "20", "0,2", "0,3"}));
    }

    @Test
    public void testTriptofanoNaoAceitarAcimavalorSuperior() {
        ColecaoAlimentos c = new ColecaoAlimentos();
        c.addHeaderTabela(new String[]{"Código", "PRODUTO", "Energia (kcal)", "Energia (kJ)", "Água (g)", "Proteína (g)", "Gordura total (g)", "Total HC disponíveis (g)", "Total HC expresso em monossacáridos (g)", "Mono + dissacáridos (g)", "Ácidos orgânicos (g)", "Álcool (g)", "Amido (g)", "Oligossacáridos (g)", "Fibra alimentar (g)", "Ácidos gordos saturados (g)", "Ácidos gordos monoinsaturados (g)", "Ácidos gordos polinsaturados  (g)", "Ácidos gordos trans (g)", "Ácido linoleico (g)", "Colesterol (mg)", "Retinol (vit. A total) (mg)", "Vit A total (equivalentes retinol) (mg)", "Caroteno (mg)", "vit. D (µg)", "a-tocoferol (mg)", "Tiamina (mg)", "Riboflavina (mg)", "Equivalentes de niacina (mg)", "Niacina (mg)", "Triptofano/60(mg)", "vit B6 (mg)", "Vit. B12 (µg)", "vit. C (mg)", "Folatos (µg)", "Cinza (g)", "Na (mg)", "K    (mg)", "Ca (mg)", "P (mg)", "Mg (mg)", "Fe (mg)", "Zn (mg)"});
        assertThrows(ForadeLimitesExcepcao.class, () -> c.addElemento(new String[]{"IS019", "Leite Cabra cru", "2", "290", "86,9", "3,8", "4", "4,6", "4,8", "4,6", "0", "0", "0", "0", "0", "2,6", "1,1", "0,1", "0,1", "0,1", "11", "0,053", "53", "0", "0,05", "0,03", "0,05", "0,1", "1", "0,3", "1500.1", "0,04", "0,08", "3", "1", "0,85", "40", "181", "153", "120", "20", "0,2", "0,3"}));
    }

    @Test
    public void testvitB6mgNaoAceitarAcimavalorSuperior() {
        ColecaoAlimentos c = new ColecaoAlimentos();
        c.addHeaderTabela(new String[]{"Código", "PRODUTO", "Energia (kcal)", "Energia (kJ)", "Água (g)", "Proteína (g)", "Gordura total (g)", "Total HC disponíveis (g)", "Total HC expresso em monossacáridos (g)", "Mono + dissacáridos (g)", "Ácidos orgânicos (g)", "Álcool (g)", "Amido (g)", "Oligossacáridos (g)", "Fibra alimentar (g)", "Ácidos gordos saturados (g)", "Ácidos gordos monoinsaturados (g)", "Ácidos gordos polinsaturados  (g)", "Ácidos gordos trans (g)", "Ácido linoleico (g)", "Colesterol (mg)", "Retinol (vit. A total) (mg)", "Vit A total (equivalentes retinol) (mg)", "Caroteno (mg)", "vit. D (µg)", "a-tocoferol (mg)", "Tiamina (mg)", "Riboflavina (mg)", "Equivalentes de niacina (mg)", "Niacina (mg)", "Triptofano/60(mg)", "vit B6 (mg)", "Vit. B12 (µg)", "vit. C (mg)", "Folatos (µg)", "Cinza (g)", "Na (mg)", "K    (mg)", "Ca (mg)", "P (mg)", "Mg (mg)", "Fe (mg)", "Zn (mg)"});
        assertThrows(ForadeLimitesExcepcao.class, () -> c.addElemento(new String[]{"IS019", "Leite Cabra cru", "2", "290", "86,9", "3,8", "4", "4,6", "4,8", "4,6", "0", "0", "0", "0", "0", "2,6", "1,1", "0,1", "0,1", "0,1", "11", "0,053", "53", "0", "0,05", "0,03", "0,05", "0,1", "1", "0,3", "1500.1", "0,04", "0,08", "3", "1", "0,85", "40", "181", "153", "120", "20", "0,2", "0,3"}));
    }

    @Test
    public void testVitB12µgNaoAceitarAcimavalorSuperior() {
        ColecaoAlimentos c = new ColecaoAlimentos();
        c.addHeaderTabela(new String[]{"Código", "PRODUTO", "Energia (kcal)", "Energia (kJ)", "Água (g)", "Proteína (g)", "Gordura total (g)", "Total HC disponíveis (g)", "Total HC expresso em monossacáridos (g)", "Mono + dissacáridos (g)", "Ácidos orgânicos (g)", "Álcool (g)", "Amido (g)", "Oligossacáridos (g)", "Fibra alimentar (g)", "Ácidos gordos saturados (g)", "Ácidos gordos monoinsaturados (g)", "Ácidos gordos polinsaturados  (g)", "Ácidos gordos trans (g)", "Ácido linoleico (g)", "Colesterol (mg)", "Retinol (vit. A total) (mg)", "Vit A total (equivalentes retinol) (mg)", "Caroteno (mg)", "vit. D (µg)", "a-tocoferol (mg)", "Tiamina (mg)", "Riboflavina (mg)", "Equivalentes de niacina (mg)", "Niacina (mg)", "Triptofano/60(mg)", "vit B6 (mg)", "Vit. B12 (µg)", "vit. C (mg)", "Folatos (µg)", "Cinza (g)", "Na (mg)", "K    (mg)", "Ca (mg)", "P (mg)", "Mg (mg)", "Fe (mg)", "Zn (mg)"});
        assertThrows(ForadeLimitesExcepcao.class, () -> c.addElemento(new String[]{"IS019", "Leite Cabra cru", "2", "290", "86,9", "3,8", "4", "4,6", "4,8", "4,6", "0", "0", "0", "0", "0", "2,6", "1,1", "0,1", "0,1", "0,1", "11", "0,053", "53", "0", "0,05", "0,03", "0,05", "0,1", "1", "0,3", "0,7", "1500.1", "0,08", "3", "1", "0,85", "40", "181", "153", "120", "20", "0,2", "0,3"}));
    }

    @Test
    public void testvitCmgNaoAceitarAcimavalorSuperior() {
        ColecaoAlimentos c = new ColecaoAlimentos();
        c.addHeaderTabela(new String[]{"Código", "PRODUTO", "Energia (kcal)", "Energia (kJ)", "Água (g)", "Proteína (g)", "Gordura total (g)", "Total HC disponíveis (g)", "Total HC expresso em monossacáridos (g)", "Mono + dissacáridos (g)", "Ácidos orgânicos (g)", "Álcool (g)", "Amido (g)", "Oligossacáridos (g)", "Fibra alimentar (g)", "Ácidos gordos saturados (g)", "Ácidos gordos monoinsaturados (g)", "Ácidos gordos polinsaturados  (g)", "Ácidos gordos trans (g)", "Ácido linoleico (g)", "Colesterol (mg)", "Retinol (vit. A total) (mg)", "Vit A total (equivalentes retinol) (mg)", "Caroteno (mg)", "vit. D (µg)", "a-tocoferol (mg)", "Tiamina (mg)", "Riboflavina (mg)", "Equivalentes de niacina (mg)", "Niacina (mg)", "Triptofano/60(mg)", "vit B6 (mg)", "Vit. B12 (µg)", "vit. C (mg)", "Folatos (µg)", "Cinza (g)", "Na (mg)", "K    (mg)", "Ca (mg)", "P (mg)", "Mg (mg)", "Fe (mg)", "Zn (mg)"});
        assertThrows(ForadeLimitesExcepcao.class, () -> c.addElemento(new String[]{"IS019", "Leite Cabra cru", "2", "290", "86,9", "3,8", "4", "4,6", "4,8", "4,6", "0", "0", "0", "0", "0", "2,6", "1,1", "0,1", "0,1", "0,1", "11", "0,053", "53", "0", "0,05", "0,03", "0,05", "0,1", "1", "0,3", "0,7", "0,04", "1500.1", "3", "1", "0,85", "40", "181", "153", "120", "20", "0,2", "0,3"}));
    }

    @Test
    public void testFolatosµgNaoAceitarAcimavalorSuperior() {
        ColecaoAlimentos c = new ColecaoAlimentos();
        c.addHeaderTabela(new String[]{"Código", "PRODUTO", "Energia (kcal)", "Energia (kJ)", "Água (g)", "Proteína (g)", "Gordura total (g)", "Total HC disponíveis (g)", "Total HC expresso em monossacáridos (g)", "Mono + dissacáridos (g)", "Ácidos orgânicos (g)", "Álcool (g)", "Amido (g)", "Oligossacáridos (g)", "Fibra alimentar (g)", "Ácidos gordos saturados (g)", "Ácidos gordos monoinsaturados (g)", "Ácidos gordos polinsaturados  (g)", "Ácidos gordos trans (g)", "Ácido linoleico (g)", "Colesterol (mg)", "Retinol (vit. A total) (mg)", "Vit A total (equivalentes retinol) (mg)", "Caroteno (mg)", "vit. D (µg)", "a-tocoferol (mg)", "Tiamina (mg)", "Riboflavina (mg)", "Equivalentes de niacina (mg)", "Niacina (mg)", "Triptofano/60(mg)", "vit B6 (mg)", "Vit. B12 (µg)", "vit. C (mg)", "Folatos (µg)", "Cinza (g)", "Na (mg)", "K    (mg)", "Ca (mg)", "P (mg)", "Mg (mg)", "Fe (mg)", "Zn (mg)"});
        assertThrows(ForadeLimitesExcepcao.class, () -> c.addElemento(new String[]{"IS019", "Leite Cabra cru", "2", "290", "86,9", "3,8", "4", "4,6", "4,8", "4,6", "0", "0", "0", "0", "0", "2,6", "1,1", "0,1", "0,1", "0,1", "11", "0,053", "53", "0", "0,05", "0,03", "0,05", "0,1", "1", "0,3", "0,7", "0,04", "0,08", "3", "15000.1", "0,85", "40", "181", "153", "120", "20", "0,2", "0,3"}));
    }

    @Test
    public void testCinzagNaoAceitarAcimavalorSuperior() {
        ColecaoAlimentos c = new ColecaoAlimentos();
        c.addHeaderTabela(new String[]{"Código", "PRODUTO", "Energia (kcal)", "Energia (kJ)", "Água (g)", "Proteína (g)", "Gordura total (g)", "Total HC disponíveis (g)", "Total HC expresso em monossacáridos (g)", "Mono + dissacáridos (g)", "Ácidos orgânicos (g)", "Álcool (g)", "Amido (g)", "Oligossacáridos (g)", "Fibra alimentar (g)", "Ácidos gordos saturados (g)", "Ácidos gordos monoinsaturados (g)", "Ácidos gordos polinsaturados  (g)", "Ácidos gordos trans (g)", "Ácido linoleico (g)", "Colesterol (mg)", "Retinol (vit. A total) (mg)", "Vit A total (equivalentes retinol) (mg)", "Caroteno (mg)", "vit. D (µg)", "a-tocoferol (mg)", "Tiamina (mg)", "Riboflavina (mg)", "Equivalentes de niacina (mg)", "Niacina (mg)", "Triptofano/60(mg)", "vit B6 (mg)", "Vit. B12 (µg)", "vit. C (mg)", "Folatos (µg)", "Cinza (g)", "Na (mg)", "K    (mg)", "Ca (mg)", "P (mg)", "Mg (mg)", "Fe (mg)", "Zn (mg)"});
        assertThrows(ForadeLimitesExcepcao.class, () -> c.addElemento(new String[]{"IS019", "Leite Cabra cru", "2", "290", "86,9", "3,8", "4", "4,6", "4,8", "4,6", "0", "0", "0", "0", "0", "2,6", "1,1", "0,1", "0,1", "0,1", "11", "0,053", "53", "0", "0,05", "0,03", "0,05", "0,1", "1", "0,3", "0,7", "0,04", "0,08", "3", "1", "1500.1", "40", "181", "153", "120", "20", "0,2", "0,3"}));
    }

    @Test
    public void testNamgNaoAceitarAcimavalorSuperior() {
        ColecaoAlimentos c = new ColecaoAlimentos();
        c.addHeaderTabela(new String[]{"Código", "PRODUTO", "Energia (kcal)", "Energia (kJ)", "Água (g)", "Proteína (g)", "Gordura total (g)", "Total HC disponíveis (g)", "Total HC expresso em monossacáridos (g)", "Mono + dissacáridos (g)", "Ácidos orgânicos (g)", "Álcool (g)", "Amido (g)", "Oligossacáridos (g)", "Fibra alimentar (g)", "Ácidos gordos saturados (g)", "Ácidos gordos monoinsaturados (g)", "Ácidos gordos polinsaturados  (g)", "Ácidos gordos trans (g)", "Ácido linoleico (g)", "Colesterol (mg)", "Retinol (vit. A total) (mg)", "Vit A total (equivalentes retinol) (mg)", "Caroteno (mg)", "vit. D (µg)", "a-tocoferol (mg)", "Tiamina (mg)", "Riboflavina (mg)", "Equivalentes de niacina (mg)", "Niacina (mg)", "Triptofano/60(mg)", "vit B6 (mg)", "Vit. B12 (µg)", "vit. C (mg)", "Folatos (µg)", "Cinza (g)", "Na (mg)", "K    (mg)", "Ca (mg)", "P (mg)", "Mg (mg)", "Fe (mg)", "Zn (mg)"});
        assertThrows(ForadeLimitesExcepcao.class, () -> c.addElemento(new String[]{"IS019", "Leite Cabra cru", "2", "290", "86,9", "3,8", "4", "4,6", "4,8", "4,6", "0", "0", "0", "0", "0", "2,6", "1,1", "0,1", "0,1", "0,1", "11", "0,053", "53", "0", "0,05", "0,03", "0,05", "0,1", "1", "0,3", "0,7", "0,04", "0,08", "3", "1", "40", "40000.1", "181", "153", "120", "20", "0,2", "0,3"}));
    }

    @Test
    public void testKmgNaoAceitarAcimavalorSuperior() {
        ColecaoAlimentos c = new ColecaoAlimentos();
        c.addHeaderTabela(new String[]{"Código", "PRODUTO", "Energia (kcal)", "Energia (kJ)", "Água (g)", "Proteína (g)", "Gordura total (g)", "Total HC disponíveis (g)", "Total HC expresso em monossacáridos (g)", "Mono + dissacáridos (g)", "Ácidos orgânicos (g)", "Álcool (g)", "Amido (g)", "Oligossacáridos (g)", "Fibra alimentar (g)", "Ácidos gordos saturados (g)", "Ácidos gordos monoinsaturados (g)", "Ácidos gordos polinsaturados  (g)", "Ácidos gordos trans (g)", "Ácido linoleico (g)", "Colesterol (mg)", "Retinol (vit. A total) (mg)", "Vit A total (equivalentes retinol) (mg)", "Caroteno (mg)", "vit. D (µg)", "a-tocoferol (mg)", "Tiamina (mg)", "Riboflavina (mg)", "Equivalentes de niacina (mg)", "Niacina (mg)", "Triptofano/60(mg)", "vit B6 (mg)", "Vit. B12 (µg)", "vit. C (mg)", "Folatos (µg)", "Cinza (g)", "Na (mg)", "K    (mg)", "Ca (mg)", "P (mg)", "Mg (mg)", "Fe (mg)", "Zn (mg)"});
        assertThrows(ForadeLimitesExcepcao.class, () -> c.addElemento(new String[]{"IS019", "Leite Cabra cru", "2", "290", "86,9", "3,8", "4", "4,6", "4,8", "4,6", "0", "0", "0", "0", "0", "2,6", "1,1", "0,1", "0,1", "0,1", "11", "0,053", "53", "0", "0,05", "0,03", "0,05", "0,1", "1", "0,3", "0,7", "0,04", "0,08", "3", "1", "0,85", "40", "15000.1", "153", "120", "20", "0,2", "0,3"}));
    }

    @Test
    public void testCamgNaoAceitarAcimavalorSuperior() {
        ColecaoAlimentos c = new ColecaoAlimentos();
        c.addHeaderTabela(new String[]{"Código", "PRODUTO", "Energia (kcal)", "Energia (kJ)", "Água (g)", "Proteína (g)", "Gordura total (g)", "Total HC disponíveis (g)", "Total HC expresso em monossacáridos (g)", "Mono + dissacáridos (g)", "Ácidos orgânicos (g)", "Álcool (g)", "Amido (g)", "Oligossacáridos (g)", "Fibra alimentar (g)", "Ácidos gordos saturados (g)", "Ácidos gordos monoinsaturados (g)", "Ácidos gordos polinsaturados  (g)", "Ácidos gordos trans (g)", "Ácido linoleico (g)", "Colesterol (mg)", "Retinol (vit. A total) (mg)", "Vit A total (equivalentes retinol) (mg)", "Caroteno (mg)", "vit. D (µg)", "a-tocoferol (mg)", "Tiamina (mg)", "Riboflavina (mg)", "Equivalentes de niacina (mg)", "Niacina (mg)", "Triptofano/60(mg)", "vit B6 (mg)", "Vit. B12 (µg)", "vit. C (mg)", "Folatos (µg)", "Cinza (g)", "Na (mg)", "K    (mg)", "Ca (mg)", "P (mg)", "Mg (mg)", "Fe (mg)", "Zn (mg)"});
        assertThrows(ForadeLimitesExcepcao.class, () -> c.addElemento(new String[]{"IS019", "Leite Cabra cru", "2", "290", "86,9", "3,8", "4", "4,6", "4,8", "4,6", "0", "0", "0", "0", "0", "2,6", "1,1", "0,1", "0,1", "0,1", "11", "0,053", "53", "0", "0,05", "0,03", "0,05", "0,1", "1", "0,3", "0,7", "0,04", "0,08", "3", "1", "0,85", "40", "181", "1500.1", "120", "20", "0,2", "0,3"}));
    }

    @Test
    public void testPmgNaoAceitarAcimavalorSuperior() {
        ColecaoAlimentos c = new ColecaoAlimentos();
        c.addHeaderTabela(new String[]{"Código", "PRODUTO", "Energia (kcal)", "Energia (kJ)", "Água (g)", "Proteína (g)", "Gordura total (g)", "Total HC disponíveis (g)", "Total HC expresso em monossacáridos (g)", "Mono + dissacáridos (g)", "Ácidos orgânicos (g)", "Álcool (g)", "Amido (g)", "Oligossacáridos (g)", "Fibra alimentar (g)", "Ácidos gordos saturados (g)", "Ácidos gordos monoinsaturados (g)", "Ácidos gordos polinsaturados  (g)", "Ácidos gordos trans (g)", "Ácido linoleico (g)", "Colesterol (mg)", "Retinol (vit. A total) (mg)", "Vit A total (equivalentes retinol) (mg)", "Caroteno (mg)", "vit. D (µg)", "a-tocoferol (mg)", "Tiamina (mg)", "Riboflavina (mg)", "Equivalentes de niacina (mg)", "Niacina (mg)", "Triptofano/60(mg)", "vit B6 (mg)", "Vit. B12 (µg)", "vit. C (mg)", "Folatos (µg)", "Cinza (g)", "Na (mg)", "K    (mg)", "Ca (mg)", "P (mg)", "Mg (mg)", "Fe (mg)", "Zn (mg)"});
        assertThrows(ForadeLimitesExcepcao.class, () -> c.addElemento(new String[]{"IS019", "Leite Cabra cru", "2", "290", "86,9", "3,8", "4", "4,6", "4,8", "4,6", "0", "0", "0", "0", "0", "2,6", "1,1", "0,1", "0,1", "0,1", "11", "0,053", "53", "0", "0,05", "0,03", "0,05", "0,1", "1", "0,3", "0,7", "0,04", "0,08", "3", "1", "0,85", "40", "181", "153", "15000.1", "20", "0,2", "0,3"}));
    }

    @Test
    public void testMgmgNaoAceitarAcimavalorSuperior() {
        ColecaoAlimentos c = new ColecaoAlimentos();
        c.addHeaderTabela(new String[]{"Código", "PRODUTO", "Energia (kcal)", "Energia (kJ)", "Água (g)", "Proteína (g)", "Gordura total (g)", "Total HC disponíveis (g)", "Total HC expresso em monossacáridos (g)", "Mono + dissacáridos (g)", "Ácidos orgânicos (g)", "Álcool (g)", "Amido (g)", "Oligossacáridos (g)", "Fibra alimentar (g)", "Ácidos gordos saturados (g)", "Ácidos gordos monoinsaturados (g)", "Ácidos gordos polinsaturados  (g)", "Ácidos gordos trans (g)", "Ácido linoleico (g)", "Colesterol (mg)", "Retinol (vit. A total) (mg)", "Vit A total (equivalentes retinol) (mg)", "Caroteno (mg)", "vit. D (µg)", "a-tocoferol (mg)", "Tiamina (mg)", "Riboflavina (mg)", "Equivalentes de niacina (mg)", "Niacina (mg)", "Triptofano/60(mg)", "vit B6 (mg)", "Vit. B12 (µg)", "vit. C (mg)", "Folatos (µg)", "Cinza (g)", "Na (mg)", "K    (mg)", "Ca (mg)", "P (mg)", "Mg (mg)", "Fe (mg)", "Zn (mg)"});
        assertThrows(ForadeLimitesExcepcao.class, () -> c.addElemento(new String[]{"IS019", "Leite Cabra cru", "2", "290", "86,9", "3,8", "4", "4,6", "4,8", "4,6", "0", "0", "0", "0", "0", "2,6", "1,1", "0,1", "0,1", "0,1", "11", "0,053", "53", "0", "0,05", "0,03", "0,05", "0,1", "1", "0,3", "0,7", "0,04", "0,08", "3", "1", "0,85", "40", "181", "153", "1500.1", "1500.1", "0,2", "0,3"}));
    }

    @Test
    public void testFemgNaoAceitarAcimavalorSuperior() {
        ColecaoAlimentos c = new ColecaoAlimentos();
        c.addHeaderTabela(new String[]{"Código", "PRODUTO", "Energia (kcal)", "Energia (kJ)", "Água (g)", "Proteína (g)", "Gordura total (g)", "Total HC disponíveis (g)", "Total HC expresso em monossacáridos (g)", "Mono + dissacáridos (g)", "Ácidos orgânicos (g)", "Álcool (g)", "Amido (g)", "Oligossacáridos (g)", "Fibra alimentar (g)", "Ácidos gordos saturados (g)", "Ácidos gordos monoinsaturados (g)", "Ácidos gordos polinsaturados  (g)", "Ácidos gordos trans (g)", "Ácido linoleico (g)", "Colesterol (mg)", "Retinol (vit. A total) (mg)", "Vit A total (equivalentes retinol) (mg)", "Caroteno (mg)", "vit. D (µg)", "a-tocoferol (mg)", "Tiamina (mg)", "Riboflavina (mg)", "Equivalentes de niacina (mg)", "Niacina (mg)", "Triptofano/60(mg)", "vit B6 (mg)", "Vit. B12 (µg)", "vit. C (mg)", "Folatos (µg)", "Cinza (g)", "Na (mg)", "K    (mg)", "Ca (mg)", "P (mg)", "Mg (mg)", "Fe (mg)", "Zn (mg)"});
        assertThrows(ForadeLimitesExcepcao.class, () -> c.addElemento(new String[]{"IS019", "Leite Cabra cru", "2", "290", "86,9", "3,8", "4", "4,6", "4,8", "4,6", "0", "0", "0", "0", "0", "2,6", "1,1", "0,1", "0,1", "0,1", "11", "0,053", "53", "0", "0,05", "0,03", "0,05", "0,1", "1", "0,3", "0,7", "0,04", "0,08", "3", "1", "0,85", "40", "181", "153", "120", "20", "1500.1", "0,3"}));
    }

    @Test
    public void testZnmgNaoAceitarAcimavalorSuperior() {
        ColecaoAlimentos c = new ColecaoAlimentos();
        c.addHeaderTabela(new String[]{"Código", "PRODUTO", "Energia (kcal)", "Energia (kJ)", "Água (g)", "Proteína (g)", "Gordura total (g)", "Total HC disponíveis (g)", "Total HC expresso em monossacáridos (g)", "Mono + dissacáridos (g)", "Ácidos orgânicos (g)", "Álcool (g)", "Amido (g)", "Oligossacáridos (g)", "Fibra alimentar (g)", "Ácidos gordos saturados (g)", "Ácidos gordos monoinsaturados (g)", "Ácidos gordos polinsaturados  (g)", "Ácidos gordos trans (g)", "Ácido linoleico (g)", "Colesterol (mg)", "Retinol (vit. A total) (mg)", "Vit A total (equivalentes retinol) (mg)", "Caroteno (mg)", "vit. D (µg)", "a-tocoferol (mg)", "Tiamina (mg)", "Riboflavina (mg)", "Equivalentes de niacina (mg)", "Niacina (mg)", "Triptofano/60(mg)", "vit B6 (mg)", "Vit. B12 (µg)", "vit. C (mg)", "Folatos (µg)", "Cinza (g)", "Na (mg)", "K    (mg)", "Ca (mg)", "P (mg)", "Mg (mg)", "Fe (mg)", "Zn (mg)"});
        assertThrows(ForadeLimitesExcepcao.class, () -> c.addElemento(new String[]{"IS019", "Leite Cabra cru", "2", "290", "86,9", "3,8", "4", "4,6", "4,8", "4,6", "0", "0", "0", "0", "0", "2,6", "1,1", "0,1", "0,1", "0,1", "11", "0,053", "53", "0", "0,05", "0,03", "0,05", "0,1", "1", "0,3", "0,7", "0,04", "0,08", "3", "1", "0,85", "40", "181", "153", "120", "20", "0,2", "1500.1"}));
    }



    @Test
    public void testCodigoNaoAceitarVazios() {
        ColecaoAlimentos c = new ColecaoAlimentos();
        c.addHeaderTabela(new String[]{"Código", "PRODUTO", "Energia (kcal)", "Energia (kJ)", "Água (g)", "Proteína (g)", "Gordura total (g)", "Total HC disponíveis (g)", "Total HC expresso em monossacáridos (g)", "Mono + dissacáridos (g)", "Ácidos orgânicos (g)", "Álcool (g)", "Amido (g)", "Oligossacáridos (g)", "Fibra alimentar (g)", "Ácidos gordos saturados (g)", "Ácidos gordos monoinsaturados (g)", "Ácidos gordos polinsaturados  (g)", "Ácidos gordos trans (g)", "Ácido linoleico (g)", "Colesterol (mg)", "Retinol (vit. A total) (mg)", "Vit A total (equivalentes retinol) (mg)", "Caroteno (mg)", "vit. D (µg)", "a-tocoferol (mg)", "Tiamina (mg)", "Riboflavina (mg)", "Equivalentes de niacina (mg)", "Niacina (mg)", "Triptofano/60(mg)", "vit B6 (mg)", "Vit. B12 (µg)", "vit. C (mg)", "Folatos (µg)", "Cinza (g)", "Na (mg)", "K    (mg)", "Ca (mg)", "P (mg)", "Mg (mg)", "Fe (mg)", "Zn (mg)"});
        assertThrows(StringVaziaExcepcao.class, () -> c.addElemento(new String[]{"", "Leite Cabra cru", "2", "290", "86,9", "3,8", "4", "4,6", "4,8", "4,6", "0", "0", "0", "0", "0", "2,6", "1,1", "0,1", "0,1", "0,1", "11", "0,053", "53", "0", "0,05", "0,03", "0,05", "0,1", "1", "0,3", "0,7", "0,04", "0,08", "3", "1", "0,85", "40", "181", "153", "120", "20", "0,2", "0,3"}));
    }

    @Test
    public void testProdutoNaoAceitarVazios() {
        ColecaoAlimentos c = new ColecaoAlimentos();
        c.addHeaderTabela(new String[]{"Código", "PRODUTO", "Energia (kcal)", "Energia (kJ)", "Água (g)", "Proteína (g)", "Gordura total (g)", "Total HC disponíveis (g)", "Total HC expresso em monossacáridos (g)", "Mono + dissacáridos (g)", "Ácidos orgânicos (g)", "Álcool (g)", "Amido (g)", "Oligossacáridos (g)", "Fibra alimentar (g)", "Ácidos gordos saturados (g)", "Ácidos gordos monoinsaturados (g)", "Ácidos gordos polinsaturados  (g)", "Ácidos gordos trans (g)", "Ácido linoleico (g)", "Colesterol (mg)", "Retinol (vit. A total) (mg)", "Vit A total (equivalentes retinol) (mg)", "Caroteno (mg)", "vit. D (µg)", "a-tocoferol (mg)", "Tiamina (mg)", "Riboflavina (mg)", "Equivalentes de niacina (mg)", "Niacina (mg)", "Triptofano/60(mg)", "vit B6 (mg)", "Vit. B12 (µg)", "vit. C (mg)", "Folatos (µg)", "Cinza (g)", "Na (mg)", "K    (mg)", "Ca (mg)", "P (mg)", "Mg (mg)", "Fe (mg)", "Zn (mg)"});
        assertThrows(StringVaziaExcepcao.class, () -> c.addElemento(new String[]{"IS019", "", "2", "290", "86,9", "3,8", "4", "4,6", "4,8", "4,6", "0", "0", "0", "0", "0", "2,6", "1,1", "0,1", "0,1", "0,1", "11", "0,053", "53", "0", "0,05", "0,03", "0,05", "0,1", "1", "0,3", "0,7", "0,04", "0,08", "3", "1", "0,85", "40", "181", "153", "120", "20", "0,2", "0,3"}));
    }

    

    @Test
    public void testEnergiakcalNaoAceitarVazios() {
        ColecaoAlimentos c = new ColecaoAlimentos();
        c.addHeaderTabela(new String[]{"Código", "PRODUTO", "Energia (kcal)", "Energia (kJ)", "Água (g)", "Proteína (g)", "Gordura total (g)", "Total HC disponíveis (g)", "Total HC expresso em monossacáridos (g)", "Mono + dissacáridos (g)", "Ácidos orgânicos (g)", "Álcool (g)", "Amido (g)", "Oligossacáridos (g)", "Fibra alimentar (g)", "Ácidos gordos saturados (g)", "Ácidos gordos monoinsaturados (g)", "Ácidos gordos polinsaturados  (g)", "Ácidos gordos trans (g)", "Ácido linoleico (g)", "Colesterol (mg)", "Retinol (vit. A total) (mg)", "Vit A total (equivalentes retinol) (mg)", "Caroteno (mg)", "vit. D (µg)", "a-tocoferol (mg)", "Tiamina (mg)", "Riboflavina (mg)", "Equivalentes de niacina (mg)", "Niacina (mg)", "Triptofano/60(mg)", "vit B6 (mg)", "Vit. B12 (µg)", "vit. C (mg)", "Folatos (µg)", "Cinza (g)", "Na (mg)", "K    (mg)", "Ca (mg)", "P (mg)", "Mg (mg)", "Fe (mg)", "Zn (mg)"});
        assertThrows(StringVaziaExcepcao.class, () -> c.addElemento(new String[]{"IS019", "Leite Cabra cru", "", "290", "86,9", "3,8", "4", "4,6", "4,8", "4,6", "0", "0", "0", "0", "0", "2,6", "1,1", "0,1", "0,1", "0,1", "11", "0,053", "53", "0", "0,05", "0,03", "0,05", "0,1", "1", "0,3", "0,7", "0,04", "0,08", "3", "1", "0,85", "40", "181", "153", "120", "20", "0,2", "0,3"}));
    }

    @Test
    public void testEnergiakJNaoAceitarVazios() {
        ColecaoAlimentos c = new ColecaoAlimentos();
        c.addHeaderTabela(new String[]{"Código", "PRODUTO", "Energia (kcal)", "Energia (kJ)", "Água (g)", "Proteína (g)", "Gordura total (g)", "Total HC disponíveis (g)", "Total HC expresso em monossacáridos (g)", "Mono + dissacáridos (g)", "Ácidos orgânicos (g)", "Álcool (g)", "Amido (g)", "Oligossacáridos (g)", "Fibra alimentar (g)", "Ácidos gordos saturados (g)", "Ácidos gordos monoinsaturados (g)", "Ácidos gordos polinsaturados  (g)", "Ácidos gordos trans (g)", "Ácido linoleico (g)", "Colesterol (mg)", "Retinol (vit. A total) (mg)", "Vit A total (equivalentes retinol) (mg)", "Caroteno (mg)", "vit. D (µg)", "a-tocoferol (mg)", "Tiamina (mg)", "Riboflavina (mg)", "Equivalentes de niacina (mg)", "Niacina (mg)", "Triptofano/60(mg)", "vit B6 (mg)", "Vit. B12 (µg)", "vit. C (mg)", "Folatos (µg)", "Cinza (g)", "Na (mg)", "K    (mg)", "Ca (mg)", "P (mg)", "Mg (mg)", "Fe (mg)", "Zn (mg)"});
        assertThrows(StringVaziaExcepcao.class, () -> c.addElemento(new String[]{"IS019", "Leite Cabra cru", "2", "", "86,9", "3,8", "4", "4,6", "4,8", "4,6", "0", "0", "0", "0", "0", "2,6", "1,1", "0,1", "0,1", "0,1", "11", "0,053", "53", "0", "0,05", "0,03", "0,05", "0,1", "1", "0,3", "0,7", "0,04", "0,08", "3", "1", "0,85", "40", "181", "153", "120", "20", "0,2", "0,3"}));
    }

    @Test
    public void testaguagNaoAceitarVazios() {
        ColecaoAlimentos c = new ColecaoAlimentos();
        c.addHeaderTabela(new String[]{"Código", "PRODUTO", "Energia (kcal)", "Energia (kJ)", "Água (g)", "Proteína (g)", "Gordura total (g)", "Total HC disponíveis (g)", "Total HC expresso em monossacáridos (g)", "Mono + dissacáridos (g)", "Ácidos orgânicos (g)", "Álcool (g)", "Amido (g)", "Oligossacáridos (g)", "Fibra alimentar (g)", "Ácidos gordos saturados (g)", "Ácidos gordos monoinsaturados (g)", "Ácidos gordos polinsaturados  (g)", "Ácidos gordos trans (g)", "Ácido linoleico (g)", "Colesterol (mg)", "Retinol (vit. A total) (mg)", "Vit A total (equivalentes retinol) (mg)", "Caroteno (mg)", "vit. D (µg)", "a-tocoferol (mg)", "Tiamina (mg)", "Riboflavina (mg)", "Equivalentes de niacina (mg)", "Niacina (mg)", "Triptofano/60(mg)", "vit B6 (mg)", "Vit. B12 (µg)", "vit. C (mg)", "Folatos (µg)", "Cinza (g)", "Na (mg)", "K    (mg)", "Ca (mg)", "P (mg)", "Mg (mg)", "Fe (mg)", "Zn (mg)"});
        assertThrows(StringVaziaExcepcao.class, () -> c.addElemento(new String[]{"IS019", "Leite Cabra cru", "2", "290", "", "3,8", "4", "4,6", "4,8", "4,6", "0", "0", "0", "0", "0", "2,6", "1,1", "0,1", "0,1", "0,1", "11", "0,053", "53", "0", "0,05", "0,03", "0,05", "0,1", "1", "0,3", "0,7", "0,04", "0,08", "3", "1", "0,85", "40", "181", "153", "120", "20", "0,2", "0,3"}));
    }

    @Test
    public void testProteínagNaoAceitarVazios() {
        ColecaoAlimentos c = new ColecaoAlimentos();
        c.addHeaderTabela(new String[]{"Código", "PRODUTO", "Energia (kcal)", "Energia (kJ)", "Água (g)", "Proteína (g)", "Gordura total (g)", "Total HC disponíveis (g)", "Total HC expresso em monossacáridos (g)", "Mono + dissacáridos (g)", "Ácidos orgânicos (g)", "Álcool (g)", "Amido (g)", "Oligossacáridos (g)", "Fibra alimentar (g)", "Ácidos gordos saturados (g)", "Ácidos gordos monoinsaturados (g)", "Ácidos gordos polinsaturados  (g)", "Ácidos gordos trans (g)", "Ácido linoleico (g)", "Colesterol (mg)", "Retinol (vit. A total) (mg)", "Vit A total (equivalentes retinol) (mg)", "Caroteno (mg)", "vit. D (µg)", "a-tocoferol (mg)", "Tiamina (mg)", "Riboflavina (mg)", "Equivalentes de niacina (mg)", "Niacina (mg)", "Triptofano/60(mg)", "vit B6 (mg)", "Vit. B12 (µg)", "vit. C (mg)", "Folatos (µg)", "Cinza (g)", "Na (mg)", "K    (mg)", "Ca (mg)", "P (mg)", "Mg (mg)", "Fe (mg)", "Zn (mg)"});
        assertThrows(StringVaziaExcepcao.class, () -> c.addElemento(new String[]{"IS019", "Leite Cabra cru", "2", "290", "86,9", "", "4", "4,6", "4,8", "4,6", "0", "0", "0", "0", "0", "2,6", "1,1", "0,1", "0,1", "0,1", "11", "0,053", "53", "0", "0,05", "0,03", "0,05", "0,1", "1", "0,3", "0,7", "0,04", "0,08", "3", "1", "0,85", "40", "181", "153", "120", "20", "0,2", "0,3"}));
    }

    @Test
    public void testGorduratotalgNaoAceitarVazios() {
        ColecaoAlimentos c = new ColecaoAlimentos();
        c.addHeaderTabela(new String[]{"Código", "PRODUTO", "Energia (kcal)", "Energia (kJ)", "Água (g)", "Proteína (g)", "Gordura total (g)", "Total HC disponíveis (g)", "Total HC expresso em monossacáridos (g)", "Mono + dissacáridos (g)", "Ácidos orgânicos (g)", "Álcool (g)", "Amido (g)", "Oligossacáridos (g)", "Fibra alimentar (g)", "Ácidos gordos saturados (g)", "Ácidos gordos monoinsaturados (g)", "Ácidos gordos polinsaturados  (g)", "Ácidos gordos trans (g)", "Ácido linoleico (g)", "Colesterol (mg)", "Retinol (vit. A total) (mg)", "Vit A total (equivalentes retinol) (mg)", "Caroteno (mg)", "vit. D (µg)", "a-tocoferol (mg)", "Tiamina (mg)", "Riboflavina (mg)", "Equivalentes de niacina (mg)", "Niacina (mg)", "Triptofano/60(mg)", "vit B6 (mg)", "Vit. B12 (µg)", "vit. C (mg)", "Folatos (µg)", "Cinza (g)", "Na (mg)", "K    (mg)", "Ca (mg)", "P (mg)", "Mg (mg)", "Fe (mg)", "Zn (mg)"});
        assertThrows(StringVaziaExcepcao.class, () -> c.addElemento(new String[]{"IS019", "Leite Cabra cru", "2", "290", "86,9", "3,8", "", "4,6", "4,8", "4,6", "0", "0", "0", "0", "0", "2,6", "1,1", "0,1", "0,1", "0,1", "11", "0,053", "53", "0", "0,05", "0,03", "0,05", "0,1", "1", "0,3", "0,7", "0,04", "0,08", "3", "1", "0,85", "40", "181", "153", "120", "20", "0,2", "0,3"}));
    }

    @Test
    public void testTotalHCdisponíveisgNaoAceitarVazios() {
        ColecaoAlimentos c = new ColecaoAlimentos();
        c.addHeaderTabela(new String[]{"Código", "PRODUTO", "Energia (kcal)", "Energia (kJ)", "Água (g)", "Proteína (g)", "Gordura total (g)", "Total HC disponíveis (g)", "Total HC expresso em monossacáridos (g)", "Mono + dissacáridos (g)", "Ácidos orgânicos (g)", "Álcool (g)", "Amido (g)", "Oligossacáridos (g)", "Fibra alimentar (g)", "Ácidos gordos saturados (g)", "Ácidos gordos monoinsaturados (g)", "Ácidos gordos polinsaturados  (g)", "Ácidos gordos trans (g)", "Ácido linoleico (g)", "Colesterol (mg)", "Retinol (vit. A total) (mg)", "Vit A total (equivalentes retinol) (mg)", "Caroteno (mg)", "vit. D (µg)", "a-tocoferol (mg)", "Tiamina (mg)", "Riboflavina (mg)", "Equivalentes de niacina (mg)", "Niacina (mg)", "Triptofano/60(mg)", "vit B6 (mg)", "Vit. B12 (µg)", "vit. C (mg)", "Folatos (µg)", "Cinza (g)", "Na (mg)", "K    (mg)", "Ca (mg)", "P (mg)", "Mg (mg)", "Fe (mg)", "Zn (mg)"});
        assertThrows(StringVaziaExcepcao.class, () -> c.addElemento(new String[]{"IS019", "Leite Cabra cru", "2", "290", "86,9", "3,8", "4", "", "4,8", "4,6", "0", "0", "0", "0", "0", "2,6", "1,1", "0,1", "0,1", "0,1", "11", "0,053", "53", "0", "0,05", "0,03", "0,05", "0,1", "1", "0,3", "0,7", "0,04", "0,08", "3", "1", "0,85", "40", "181", "153", "120", "20", "0,2", "0,3"}));
    }

    @Test
    public void testTotalHCexpressoemmonossacaridosgNaoAceitarVazios() {
        ColecaoAlimentos c = new ColecaoAlimentos();
        c.addHeaderTabela(new String[]{"Código", "PRODUTO", "Energia (kcal)", "Energia (kJ)", "Água (g)", "Proteína (g)", "Gordura total (g)", "Total HC disponíveis (g)", "Total HC expresso em monossacáridos (g)", "Mono + dissacáridos (g)", "Ácidos orgânicos (g)", "Álcool (g)", "Amido (g)", "Oligossacáridos (g)", "Fibra alimentar (g)", "Ácidos gordos saturados (g)", "Ácidos gordos monoinsaturados (g)", "Ácidos gordos polinsaturados  (g)", "Ácidos gordos trans (g)", "Ácido linoleico (g)", "Colesterol (mg)", "Retinol (vit. A total) (mg)", "Vit A total (equivalentes retinol) (mg)", "Caroteno (mg)", "vit. D (µg)", "a-tocoferol (mg)", "Tiamina (mg)", "Riboflavina (mg)", "Equivalentes de niacina (mg)", "Niacina (mg)", "Triptofano/60(mg)", "vit B6 (mg)", "Vit. B12 (µg)", "vit. C (mg)", "Folatos (µg)", "Cinza (g)", "Na (mg)", "K    (mg)", "Ca (mg)", "P (mg)", "Mg (mg)", "Fe (mg)", "Zn (mg)"});
        assertThrows(StringVaziaExcepcao.class, () -> c.addElemento(new String[]{"IS019", "Leite Cabra cru", "2", "290", "86,9", "3,8", "4", "4,6", "", "4,6", "0", "0", "0", "0", "0", "2,6", "1,1", "0,1", "0,1", "0,1", "11", "0,053", "53", "0", "0,05", "0,03", "0,05", "0,1", "1", "0,3", "0,7", "0,04", "0,08", "3", "1", "0,85", "40", "181", "153", "120", "20", "0,2", "0,3"}));
    }

    @Test
    public void testMonodissacaridosgNaoAceitarVazios() {
        ColecaoAlimentos c = new ColecaoAlimentos();
        c.addHeaderTabela(new String[]{"Código", "PRODUTO", "Energia (kcal)", "Energia (kJ)", "Água (g)", "Proteína (g)", "Gordura total (g)", "Total HC disponíveis (g)", "Total HC expresso em monossacáridos (g)", "Mono + dissacáridos (g)", "Ácidos orgânicos (g)", "Álcool (g)", "Amido (g)", "Oligossacáridos (g)", "Fibra alimentar (g)", "Ácidos gordos saturados (g)", "Ácidos gordos monoinsaturados (g)", "Ácidos gordos polinsaturados  (g)", "Ácidos gordos trans (g)", "Ácido linoleico (g)", "Colesterol (mg)", "Retinol (vit. A total) (mg)", "Vit A total (equivalentes retinol) (mg)", "Caroteno (mg)", "vit. D (µg)", "a-tocoferol (mg)", "Tiamina (mg)", "Riboflavina (mg)", "Equivalentes de niacina (mg)", "Niacina (mg)", "Triptofano/60(mg)", "vit B6 (mg)", "Vit. B12 (µg)", "vit. C (mg)", "Folatos (µg)", "Cinza (g)", "Na (mg)", "K    (mg)", "Ca (mg)", "P (mg)", "Mg (mg)", "Fe (mg)", "Zn (mg)"});
        assertThrows(StringVaziaExcepcao.class, () -> c.addElemento(new String[]{"IS019", "Leite Cabra cru", "2", "290", "86,9", "3,8", "4", "4,6", "4,8", "", "0", "0", "0", "0", "0", "2,6", "1,1", "0,1", "0,1", "0,1", "11", "0,053", "53", "0", "0,05", "0,03", "0,05", "0,1", "1", "0,3", "0,7", "0,04", "0,08", "3", "1", "0,85", "40", "181", "153", "120", "20", "0,2", "0,3"}));
    }

    @Test
    public void testacidosorgânicosgNaoAceitarVazios() {
        ColecaoAlimentos c = new ColecaoAlimentos();
        c.addHeaderTabela(new String[]{"Código", "PRODUTO", "Energia (kcal)", "Energia (kJ)", "Água (g)", "Proteína (g)", "Gordura total (g)", "Total HC disponíveis (g)", "Total HC expresso em monossacáridos (g)", "Mono + dissacáridos (g)", "Ácidos orgânicos (g)", "Álcool (g)", "Amido (g)", "Oligossacáridos (g)", "Fibra alimentar (g)", "Ácidos gordos saturados (g)", "Ácidos gordos monoinsaturados (g)", "Ácidos gordos polinsaturados  (g)", "Ácidos gordos trans (g)", "Ácido linoleico (g)", "Colesterol (mg)", "Retinol (vit. A total) (mg)", "Vit A total (equivalentes retinol) (mg)", "Caroteno (mg)", "vit. D (µg)", "a-tocoferol (mg)", "Tiamina (mg)", "Riboflavina (mg)", "Equivalentes de niacina (mg)", "Niacina (mg)", "Triptofano/60(mg)", "vit B6 (mg)", "Vit. B12 (µg)", "vit. C (mg)", "Folatos (µg)", "Cinza (g)", "Na (mg)", "K    (mg)", "Ca (mg)", "P (mg)", "Mg (mg)", "Fe (mg)", "Zn (mg)"});
        assertThrows(StringVaziaExcepcao.class, () -> c.addElemento(new String[]{"IS019", "Leite Cabra cru", "2", "290", "86,9", "3,8", "4", "4,6", "4,8", "4,6", "", "0", "0", "0", "0", "2,6", "1,1", "0,1", "0,1", "0,1", "11", "0,053", "53", "0", "0,05", "0,03", "0,05", "0,1", "1", "0,3", "0,7", "0,04", "0,08", "3", "1", "0,85", "40", "181", "153", "120", "20", "0,2", "0,3"}));
    }

    @Test
    public void testalcoolgNaoAceitarVazios() {
        ColecaoAlimentos c = new ColecaoAlimentos();
        c.addHeaderTabela(new String[]{"Código", "PRODUTO", "Energia (kcal)", "Energia (kJ)", "Água (g)", "Proteína (g)", "Gordura total (g)", "Total HC disponíveis (g)", "Total HC expresso em monossacáridos (g)", "Mono + dissacáridos (g)", "Ácidos orgânicos (g)", "Álcool (g)", "Amido (g)", "Oligossacáridos (g)", "Fibra alimentar (g)", "Ácidos gordos saturados (g)", "Ácidos gordos monoinsaturados (g)", "Ácidos gordos polinsaturados  (g)", "Ácidos gordos trans (g)", "Ácido linoleico (g)", "Colesterol (mg)", "Retinol (vit. A total) (mg)", "Vit A total (equivalentes retinol) (mg)", "Caroteno (mg)", "vit. D (µg)", "a-tocoferol (mg)", "Tiamina (mg)", "Riboflavina (mg)", "Equivalentes de niacina (mg)", "Niacina (mg)", "Triptofano/60(mg)", "vit B6 (mg)", "Vit. B12 (µg)", "vit. C (mg)", "Folatos (µg)", "Cinza (g)", "Na (mg)", "K    (mg)", "Ca (mg)", "P (mg)", "Mg (mg)", "Fe (mg)", "Zn (mg)"});
        assertThrows(StringVaziaExcepcao.class, () -> c.addElemento(new String[]{"IS019", "Leite Cabra cru", "2", "290", "86,9", "3,8", "4", "4,6", "4,8", "4,6", "0", "", "0", "0", "0", "2,6", "1,1", "0,1", "0,1", "0,1", "11", "0,053", "53", "0", "0,05", "0,03", "0,05", "0,1", "1", "0,3", "0,7", "0,04", "0,08", "3", "1", "0,85", "40", "181", "153", "120", "20", "0,2", "0,3"}));
    }

    @Test
    public void testAmidogNaoAceitarVazios() {
        ColecaoAlimentos c = new ColecaoAlimentos();
        c.addHeaderTabela(new String[]{"Código", "PRODUTO", "Energia (kcal)", "Energia (kJ)", "Água (g)", "Proteína (g)", "Gordura total (g)", "Total HC disponíveis (g)", "Total HC expresso em monossacáridos (g)", "Mono + dissacáridos (g)", "Ácidos orgânicos (g)", "Álcool (g)", "Amido (g)", "Oligossacáridos (g)", "Fibra alimentar (g)", "Ácidos gordos saturados (g)", "Ácidos gordos monoinsaturados (g)", "Ácidos gordos polinsaturados  (g)", "Ácidos gordos trans (g)", "Ácido linoleico (g)", "Colesterol (mg)", "Retinol (vit. A total) (mg)", "Vit A total (equivalentes retinol) (mg)", "Caroteno (mg)", "vit. D (µg)", "a-tocoferol (mg)", "Tiamina (mg)", "Riboflavina (mg)", "Equivalentes de niacina (mg)", "Niacina (mg)", "Triptofano/60(mg)", "vit B6 (mg)", "Vit. B12 (µg)", "vit. C (mg)", "Folatos (µg)", "Cinza (g)", "Na (mg)", "K    (mg)", "Ca (mg)", "P (mg)", "Mg (mg)", "Fe (mg)", "Zn (mg)"});
        assertThrows(StringVaziaExcepcao.class, () -> c.addElemento(new String[]{"IS019", "Leite Cabra cru", "2", "290", "86,9", "3,8", "4", "4,6", "4,8", "4,6", "0", "0", "", "0", "0", "2,6", "1,1", "0,1", "0,1", "0,1", "11", "0,053", "53", "0", "0,05", "0,03", "0,05", "0,1", "1", "0,3", "0,7", "0,04", "0,08", "3", "1", "0,85", "40", "181", "153", "120", "20", "0,2", "0,3"}));
    }

    @Test
    public void testOligossacaridosgNaoAceitarVazios() {
        ColecaoAlimentos c = new ColecaoAlimentos();
        c.addHeaderTabela(new String[]{"Código", "PRODUTO", "Energia (kcal)", "Energia (kJ)", "Água (g)", "Proteína (g)", "Gordura total (g)", "Total HC disponíveis (g)", "Total HC expresso em monossacáridos (g)", "Mono + dissacáridos (g)", "Ácidos orgânicos (g)", "Álcool (g)", "Amido (g)", "Oligossacáridos (g)", "Fibra alimentar (g)", "Ácidos gordos saturados (g)", "Ácidos gordos monoinsaturados (g)", "Ácidos gordos polinsaturados  (g)", "Ácidos gordos trans (g)", "Ácido linoleico (g)", "Colesterol (mg)", "Retinol (vit. A total) (mg)", "Vit A total (equivalentes retinol) (mg)", "Caroteno (mg)", "vit. D (µg)", "a-tocoferol (mg)", "Tiamina (mg)", "Riboflavina (mg)", "Equivalentes de niacina (mg)", "Niacina (mg)", "Triptofano/60(mg)", "vit B6 (mg)", "Vit. B12 (µg)", "vit. C (mg)", "Folatos (µg)", "Cinza (g)", "Na (mg)", "K    (mg)", "Ca (mg)", "P (mg)", "Mg (mg)", "Fe (mg)", "Zn (mg)"});
        assertThrows(StringVaziaExcepcao.class, () -> c.addElemento(new String[]{"IS019", "Leite Cabra cru", "2", "290", "86,9", "3,8", "4", "4,6", "4,8", "4,6", "0", "0", "0", "", "0", "2,6", "1,1", "0,1", "0,1", "0,1", "11", "0,053", "53", "0", "0,05", "0,03", "0,05", "0,1", "1", "0,3", "0,7", "0,04", "0,08", "3", "1", "0,85", "40", "181", "153", "120", "20", "0,2", "0,3"}));
    }

    @Test
    public void testFibraalimentargNaoAceitarVazios() {
        ColecaoAlimentos c = new ColecaoAlimentos();
        c.addHeaderTabela(new String[]{"Código", "PRODUTO", "Energia (kcal)", "Energia (kJ)", "Água (g)", "Proteína (g)", "Gordura total (g)", "Total HC disponíveis (g)", "Total HC expresso em monossacáridos (g)", "Mono + dissacáridos (g)", "Ácidos orgânicos (g)", "Álcool (g)", "Amido (g)", "Oligossacáridos (g)", "Fibra alimentar (g)", "Ácidos gordos saturados (g)", "Ácidos gordos monoinsaturados (g)", "Ácidos gordos polinsaturados  (g)", "Ácidos gordos trans (g)", "Ácido linoleico (g)", "Colesterol (mg)", "Retinol (vit. A total) (mg)", "Vit A total (equivalentes retinol) (mg)", "Caroteno (mg)", "vit. D (µg)", "a-tocoferol (mg)", "Tiamina (mg)", "Riboflavina (mg)", "Equivalentes de niacina (mg)", "Niacina (mg)", "Triptofano/60(mg)", "vit B6 (mg)", "Vit. B12 (µg)", "vit. C (mg)", "Folatos (µg)", "Cinza (g)", "Na (mg)", "K    (mg)", "Ca (mg)", "P (mg)", "Mg (mg)", "Fe (mg)", "Zn (mg)"});
        assertThrows(StringVaziaExcepcao.class, () -> c.addElemento(new String[]{"IS019", "Leite Cabra cru", "2", "290", "86,9", "3,8", "4", "4,6", "4,8", "4,6", "0", "0", "0", "0", "", "2,6", "1,1", "0,1", "0,1", "0,1", "11", "0,053", "53", "0", "0,05", "0,03", "0,05", "0,1", "1", "0,3", "0,7", "0,04", "0,08", "3", "1", "0,85", "40", "181", "153", "120", "20", "0,2", "0,3"}));
    }

    @Test
    public void testacidosgordossaturadosgNaoAceitarVazios() {
        ColecaoAlimentos c = new ColecaoAlimentos();
        c.addHeaderTabela(new String[]{"Código", "PRODUTO", "Energia (kcal)", "Energia (kJ)", "Água (g)", "Proteína (g)", "Gordura total (g)", "Total HC disponíveis (g)", "Total HC expresso em monossacáridos (g)", "Mono + dissacáridos (g)", "Ácidos orgânicos (g)", "Álcool (g)", "Amido (g)", "Oligossacáridos (g)", "Fibra alimentar (g)", "Ácidos gordos saturados (g)", "Ácidos gordos monoinsaturados (g)", "Ácidos gordos polinsaturados  (g)", "Ácidos gordos trans (g)", "Ácido linoleico (g)", "Colesterol (mg)", "Retinol (vit. A total) (mg)", "Vit A total (equivalentes retinol) (mg)", "Caroteno (mg)", "vit. D (µg)", "a-tocoferol (mg)", "Tiamina (mg)", "Riboflavina (mg)", "Equivalentes de niacina (mg)", "Niacina (mg)", "Triptofano/60(mg)", "vit B6 (mg)", "Vit. B12 (µg)", "vit. C (mg)", "Folatos (µg)", "Cinza (g)", "Na (mg)", "K    (mg)", "Ca (mg)", "P (mg)", "Mg (mg)", "Fe (mg)", "Zn (mg)"});
        assertThrows(StringVaziaExcepcao.class, () -> c.addElemento(new String[]{"IS019", "Leite Cabra cru", "2", "290", "86,9", "3,8", "4", "4,6", "4,8", "4,6", "0", "0", "0", "0", "0", "", "1,1", "0,1", "0,1", "0,1", "11", "0,053", "53", "0", "0,05", "0,03", "0,05", "0,1", "1", "0,3", "0,7", "0,04", "0,08", "3", "1", "0,85", "40", "181", "153", "120", "20", "0,2", "0,3"}));
    }

    @Test
    public void testacidosgordosmonoinsaturadosgNaoAceitarVazios() {
        ColecaoAlimentos c = new ColecaoAlimentos();
        c.addHeaderTabela(new String[]{"Código", "PRODUTO", "Energia (kcal)", "Energia (kJ)", "Água (g)", "Proteína (g)", "Gordura total (g)", "Total HC disponíveis (g)", "Total HC expresso em monossacáridos (g)", "Mono + dissacáridos (g)", "Ácidos orgânicos (g)", "Álcool (g)", "Amido (g)", "Oligossacáridos (g)", "Fibra alimentar (g)", "Ácidos gordos saturados (g)", "Ácidos gordos monoinsaturados (g)", "Ácidos gordos polinsaturados  (g)", "Ácidos gordos trans (g)", "Ácido linoleico (g)", "Colesterol (mg)", "Retinol (vit. A total) (mg)", "Vit A total (equivalentes retinol) (mg)", "Caroteno (mg)", "vit. D (µg)", "a-tocoferol (mg)", "Tiamina (mg)", "Riboflavina (mg)", "Equivalentes de niacina (mg)", "Niacina (mg)", "Triptofano/60(mg)", "vit B6 (mg)", "Vit. B12 (µg)", "vit. C (mg)", "Folatos (µg)", "Cinza (g)", "Na (mg)", "K    (mg)", "Ca (mg)", "P (mg)", "Mg (mg)", "Fe (mg)", "Zn (mg)"});
        assertThrows(StringVaziaExcepcao.class, () -> c.addElemento(new String[]{"IS019", "Leite Cabra cru", "2", "290", "86,9", "3,8", "4", "4,6", "4,8", "4,6", "0", "0", "0", "0", "0", "2,6", "", "0,1", "0,1", "0,1", "11", "0,053", "53", "0", "0,05", "0,03", "0,05", "0,1", "1", "0,3", "0,7", "0,04", "0,08", "3", "1", "0,85", "40", "181", "153", "120", "20", "0,2", "0,3"}));
    }

    @Test
    public void testacidosgordospolinsaturadosgNaoAceitarVazios() {
        ColecaoAlimentos c = new ColecaoAlimentos();
        c.addHeaderTabela(new String[]{"Código", "PRODUTO", "Energia (kcal)", "Energia (kJ)", "Água (g)", "Proteína (g)", "Gordura total (g)", "Total HC disponíveis (g)", "Total HC expresso em monossacáridos (g)", "Mono + dissacáridos (g)", "Ácidos orgânicos (g)", "Álcool (g)", "Amido (g)", "Oligossacáridos (g)", "Fibra alimentar (g)", "Ácidos gordos saturados (g)", "Ácidos gordos monoinsaturados (g)", "Ácidos gordos polinsaturados  (g)", "Ácidos gordos trans (g)", "Ácido linoleico (g)", "Colesterol (mg)", "Retinol (vit. A total) (mg)", "Vit A total (equivalentes retinol) (mg)", "Caroteno (mg)", "vit. D (µg)", "a-tocoferol (mg)", "Tiamina (mg)", "Riboflavina (mg)", "Equivalentes de niacina (mg)", "Niacina (mg)", "Triptofano/60(mg)", "vit B6 (mg)", "Vit. B12 (µg)", "vit. C (mg)", "Folatos (µg)", "Cinza (g)", "Na (mg)", "K    (mg)", "Ca (mg)", "P (mg)", "Mg (mg)", "Fe (mg)", "Zn (mg)"});
        assertThrows(StringVaziaExcepcao.class, () -> c.addElemento(new String[]{"IS019", "Leite Cabra cru", "2", "290", "86,9", "3,8", "4", "4,6", "4,8", "4,6", "0", "0", "0", "0", "0", "2,6", "1,1", "", "0,1", "0,1", "11", "0,053", "53", "0", "0,05", "0,03", "0,05", "0,1", "1", "0,3", "0,7", "0,04", "0,08", "3", "1", "0,85", "40", "181", "153", "120", "20", "0,2", "0,3"}));
    }

    @Test
    public void testacidosgordostransgNaoAceitarVazios() {
        ColecaoAlimentos c = new ColecaoAlimentos();
        c.addHeaderTabela(new String[]{"Código", "PRODUTO", "Energia (kcal)", "Energia (kJ)", "Água (g)", "Proteína (g)", "Gordura total (g)", "Total HC disponíveis (g)", "Total HC expresso em monossacáridos (g)", "Mono + dissacáridos (g)", "Ácidos orgânicos (g)", "Álcool (g)", "Amido (g)", "Oligossacáridos (g)", "Fibra alimentar (g)", "Ácidos gordos saturados (g)", "Ácidos gordos monoinsaturados (g)", "Ácidos gordos polinsaturados  (g)", "Ácidos gordos trans (g)", "Ácido linoleico (g)", "Colesterol (mg)", "Retinol (vit. A total) (mg)", "Vit A total (equivalentes retinol) (mg)", "Caroteno (mg)", "vit. D (µg)", "a-tocoferol (mg)", "Tiamina (mg)", "Riboflavina (mg)", "Equivalentes de niacina (mg)", "Niacina (mg)", "Triptofano/60(mg)", "vit B6 (mg)", "Vit. B12 (µg)", "vit. C (mg)", "Folatos (µg)", "Cinza (g)", "Na (mg)", "K    (mg)", "Ca (mg)", "P (mg)", "Mg (mg)", "Fe (mg)", "Zn (mg)"});
        assertThrows(StringVaziaExcepcao.class, () -> c.addElemento(new String[]{"IS019", "Leite Cabra cru", "2", "290", "86,9", "3,8", "4", "4,6", "4,8", "4,6", "0", "0", "0", "0", "0", "2,6", "1,1", "0,1", "", "0,1", "11", "0,053", "53", "0", "0,05", "0,03", "0,05", "0,1", "1", "0,3", "0,7", "0,04", "0,08", "3", "1", "0,85", "40", "181", "153", "120", "20", "0,2", "0,3"}));
    }

    @Test
    public void testacidolinoleicogNaoAceitarVazios() {
        ColecaoAlimentos c = new ColecaoAlimentos();
        c.addHeaderTabela(new String[]{"Código", "PRODUTO", "Energia (kcal)", "Energia (kJ)", "Água (g)", "Proteína (g)", "Gordura total (g)", "Total HC disponíveis (g)", "Total HC expresso em monossacáridos (g)", "Mono + dissacáridos (g)", "Ácidos orgânicos (g)", "Álcool (g)", "Amido (g)", "Oligossacáridos (g)", "Fibra alimentar (g)", "Ácidos gordos saturados (g)", "Ácidos gordos monoinsaturados (g)", "Ácidos gordos polinsaturados  (g)", "Ácidos gordos trans (g)", "Ácido linoleico (g)", "Colesterol (mg)", "Retinol (vit. A total) (mg)", "Vit A total (equivalentes retinol) (mg)", "Caroteno (mg)", "vit. D (µg)", "a-tocoferol (mg)", "Tiamina (mg)", "Riboflavina (mg)", "Equivalentes de niacina (mg)", "Niacina (mg)", "Triptofano/60(mg)", "vit B6 (mg)", "Vit. B12 (µg)", "vit. C (mg)", "Folatos (µg)", "Cinza (g)", "Na (mg)", "K    (mg)", "Ca (mg)", "P (mg)", "Mg (mg)", "Fe (mg)", "Zn (mg)"});
        assertThrows(StringVaziaExcepcao.class, () -> c.addElemento(new String[]{"IS019", "Leite Cabra cru", "2", "290", "86,9", "3,8", "4", "4,6", "4,8", "4,6", "0", "0", "0", "0", "0", "2,6", "1,1", "0,1", "0,1", "", "11", "0,053", "53", "0", "0,05", "0,03", "0,05", "0,1", "1", "0,3", "0,7", "0,04", "0,08", "3", "1", "0,85", "40", "181", "153", "120", "20", "0,2", "0,3"}));
    }

    @Test
    public void testColesterolmgNaoAceitarVazios() {
        ColecaoAlimentos c = new ColecaoAlimentos();
        c.addHeaderTabela(new String[]{"Código", "PRODUTO", "Energia (kcal)", "Energia (kJ)", "Água (g)", "Proteína (g)", "Gordura total (g)", "Total HC disponíveis (g)", "Total HC expresso em monossacáridos (g)", "Mono + dissacáridos (g)", "Ácidos orgânicos (g)", "Álcool (g)", "Amido (g)", "Oligossacáridos (g)", "Fibra alimentar (g)", "Ácidos gordos saturados (g)", "Ácidos gordos monoinsaturados (g)", "Ácidos gordos polinsaturados  (g)", "Ácidos gordos trans (g)", "Ácido linoleico (g)", "Colesterol (mg)", "Retinol (vit. A total) (mg)", "Vit A total (equivalentes retinol) (mg)", "Caroteno (mg)", "vit. D (µg)", "a-tocoferol (mg)", "Tiamina (mg)", "Riboflavina (mg)", "Equivalentes de niacina (mg)", "Niacina (mg)", "Triptofano/60(mg)", "vit B6 (mg)", "Vit. B12 (µg)", "vit. C (mg)", "Folatos (µg)", "Cinza (g)", "Na (mg)", "K    (mg)", "Ca (mg)", "P (mg)", "Mg (mg)", "Fe (mg)", "Zn (mg)"});
        assertThrows(StringVaziaExcepcao.class, () -> c.addElemento(new String[]{"IS019", "Leite Cabra cru", "2", "290", "86,9", "3,8", "4", "4,6", "4,8", "4,6", "0", "0", "0", "0", "0", "2,6", "1,1", "0,1", "0,1", "0,1", "", "0,053", "53", "0", "0,05", "0,03", "0,05", "0,1", "1", "0,3", "0,7", "0,04", "0,08", "3", "1", "0,85", "40", "181", "153", "120", "20", "0,2", "0,3"}));
    }

    @Test
    public void testRetinolvitAtotalmgNaoAceitarVazios() {
        ColecaoAlimentos c = new ColecaoAlimentos();
        c.addHeaderTabela(new String[]{"Código", "PRODUTO", "Energia (kcal)", "Energia (kJ)", "Água (g)", "Proteína (g)", "Gordura total (g)", "Total HC disponíveis (g)", "Total HC expresso em monossacáridos (g)", "Mono + dissacáridos (g)", "Ácidos orgânicos (g)", "Álcool (g)", "Amido (g)", "Oligossacáridos (g)", "Fibra alimentar (g)", "Ácidos gordos saturados (g)", "Ácidos gordos monoinsaturados (g)", "Ácidos gordos polinsaturados  (g)", "Ácidos gordos trans (g)", "Ácido linoleico (g)", "Colesterol (mg)", "Retinol (vit. A total) (mg)", "Vit A total (equivalentes retinol) (mg)", "Caroteno (mg)", "vit. D (µg)", "a-tocoferol (mg)", "Tiamina (mg)", "Riboflavina (mg)", "Equivalentes de niacina (mg)", "Niacina (mg)", "Triptofano/60(mg)", "vit B6 (mg)", "Vit. B12 (µg)", "vit. C (mg)", "Folatos (µg)", "Cinza (g)", "Na (mg)", "K    (mg)", "Ca (mg)", "P (mg)", "Mg (mg)", "Fe (mg)", "Zn (mg)"});
        assertThrows(StringVaziaExcepcao.class, () -> c.addElemento(new String[]{"IS019", "Leite Cabra cru", "2", "290", "86,9", "3,8", "4", "4,6", "4,8", "4,6", "0", "0", "0", "0", "0", "2,6", "1,1", "0,1", "0,1", "0,1", "11", "", "53", "0", "0,05", "0,03", "0,05", "0,1", "1", "0,3", "0,7", "0,04", "0,08", "3", "1", "0,85", "40", "181", "153", "120", "20", "0,2", "0,3"}));
    }

    @Test
    public void testVitAtotalequivalentesretinolmgNaoAceitarVazios() {
        ColecaoAlimentos c = new ColecaoAlimentos();
        c.addHeaderTabela(new String[]{"Código", "PRODUTO", "Energia (kcal)", "Energia (kJ)", "Água (g)", "Proteína (g)", "Gordura total (g)", "Total HC disponíveis (g)", "Total HC expresso em monossacáridos (g)", "Mono + dissacáridos (g)", "Ácidos orgânicos (g)", "Álcool (g)", "Amido (g)", "Oligossacáridos (g)", "Fibra alimentar (g)", "Ácidos gordos saturados (g)", "Ácidos gordos monoinsaturados (g)", "Ácidos gordos polinsaturados  (g)", "Ácidos gordos trans (g)", "Ácido linoleico (g)", "Colesterol (mg)", "Retinol (vit. A total) (mg)", "Vit A total (equivalentes retinol) (mg)", "Caroteno (mg)", "vit. D (µg)", "a-tocoferol (mg)", "Tiamina (mg)", "Riboflavina (mg)", "Equivalentes de niacina (mg)", "Niacina (mg)", "Triptofano/60(mg)", "vit B6 (mg)", "Vit. B12 (µg)", "vit. C (mg)", "Folatos (µg)", "Cinza (g)", "Na (mg)", "K    (mg)", "Ca (mg)", "P (mg)", "Mg (mg)", "Fe (mg)", "Zn (mg)"});
        assertThrows(StringVaziaExcepcao.class, () -> c.addElemento(new String[]{"IS019", "Leite Cabra cru", "2", "290", "86,9", "3,8", "4", "4,6", "4,8", "4,6", "0", "0", "0", "0", "0", "2,6", "1,1", "0,1", "0,1", "0,1", "11", "0,053", "", "0", "0,05", "0,03", "0,05", "0,1", "1", "0,3", "0,7", "0,04", "0,08", "3", "1", "0,85", "40", "181", "153", "120", "20", "0,2", "0,3"}));
    }

    @Test
    public void testCarotenomgNaoAceitarVazios() {
        ColecaoAlimentos c = new ColecaoAlimentos();
        c.addHeaderTabela(new String[]{"Código", "PRODUTO", "Energia (kcal)", "Energia (kJ)", "Água (g)", "Proteína (g)", "Gordura total (g)", "Total HC disponíveis (g)", "Total HC expresso em monossacáridos (g)", "Mono + dissacáridos (g)", "Ácidos orgânicos (g)", "Álcool (g)", "Amido (g)", "Oligossacáridos (g)", "Fibra alimentar (g)", "Ácidos gordos saturados (g)", "Ácidos gordos monoinsaturados (g)", "Ácidos gordos polinsaturados  (g)", "Ácidos gordos trans (g)", "Ácido linoleico (g)", "Colesterol (mg)", "Retinol (vit. A total) (mg)", "Vit A total (equivalentes retinol) (mg)", "Caroteno (mg)", "vit. D (µg)", "a-tocoferol (mg)", "Tiamina (mg)", "Riboflavina (mg)", "Equivalentes de niacina (mg)", "Niacina (mg)", "Triptofano/60(mg)", "vit B6 (mg)", "Vit. B12 (µg)", "vit. C (mg)", "Folatos (µg)", "Cinza (g)", "Na (mg)", "K    (mg)", "Ca (mg)", "P (mg)", "Mg (mg)", "Fe (mg)", "Zn (mg)"});
        assertThrows(StringVaziaExcepcao.class, () -> c.addElemento(new String[]{"IS019", "Leite Cabra cru", "2", "290", "86,9", "3,8", "4", "4,6", "4,8", "4,6", "0", "0", "0", "0", "0", "2,6", "1,1", "0,1", "0,1", "0,1", "11", "0,053", "53", "", "0,05", "0,03", "0,05", "0,1", "1", "0,3", "0,7", "0,04", "0,08", "3", "1", "0,85", "40", "181", "153", "120", "20", "0,2", "0,3"}));
    }

    @Test
    public void testvitDµgNaoAceitarVazios() {
        ColecaoAlimentos c = new ColecaoAlimentos();
        c.addHeaderTabela(new String[]{"Código", "PRODUTO", "Energia (kcal)", "Energia (kJ)", "Água (g)", "Proteína (g)", "Gordura total (g)", "Total HC disponíveis (g)", "Total HC expresso em monossacáridos (g)", "Mono + dissacáridos (g)", "Ácidos orgânicos (g)", "Álcool (g)", "Amido (g)", "Oligossacáridos (g)", "Fibra alimentar (g)", "Ácidos gordos saturados (g)", "Ácidos gordos monoinsaturados (g)", "Ácidos gordos polinsaturados  (g)", "Ácidos gordos trans (g)", "Ácido linoleico (g)", "Colesterol (mg)", "Retinol (vit. A total) (mg)", "Vit A total (equivalentes retinol) (mg)", "Caroteno (mg)", "vit. D (µg)", "a-tocoferol (mg)", "Tiamina (mg)", "Riboflavina (mg)", "Equivalentes de niacina (mg)", "Niacina (mg)", "Triptofano/60(mg)", "vit B6 (mg)", "Vit. B12 (µg)", "vit. C (mg)", "Folatos (µg)", "Cinza (g)", "Na (mg)", "K    (mg)", "Ca (mg)", "P (mg)", "Mg (mg)", "Fe (mg)", "Zn (mg)"});
        assertThrows(StringVaziaExcepcao.class, () -> c.addElemento(new String[]{"IS019", "Leite Cabra cru", "2", "290", "86,9", "3,8", "4", "4,6", "4,8", "4,6", "0", "0", "0", "0", "0", "2,6", "1,1", "0,1", "0,1", "0,1", "11", "0,053", "53", "0", "", "0,03", "0,05", "0,1", "1", "0,3", "0,7", "0,04", "0,08", "3", "1", "0,85", "40", "181", "153", "120", "20", "0,2", "0,3"}));
    }

    @Test
    public void testatocoferolmgNaoAceitarVazios() {
        ColecaoAlimentos c = new ColecaoAlimentos();
        c.addHeaderTabela(new String[]{"Código", "PRODUTO", "Energia (kcal)", "Energia (kJ)", "Água (g)", "Proteína (g)", "Gordura total (g)", "Total HC disponíveis (g)", "Total HC expresso em monossacáridos (g)", "Mono + dissacáridos (g)", "Ácidos orgânicos (g)", "Álcool (g)", "Amido (g)", "Oligossacáridos (g)", "Fibra alimentar (g)", "Ácidos gordos saturados (g)", "Ácidos gordos monoinsaturados (g)", "Ácidos gordos polinsaturados  (g)", "Ácidos gordos trans (g)", "Ácido linoleico (g)", "Colesterol (mg)", "Retinol (vit. A total) (mg)", "Vit A total (equivalentes retinol) (mg)", "Caroteno (mg)", "vit. D (µg)", "a-tocoferol (mg)", "Tiamina (mg)", "Riboflavina (mg)", "Equivalentes de niacina (mg)", "Niacina (mg)", "Triptofano/60(mg)", "vit B6 (mg)", "Vit. B12 (µg)", "vit. C (mg)", "Folatos (µg)", "Cinza (g)", "Na (mg)", "K    (mg)", "Ca (mg)", "P (mg)", "Mg (mg)", "Fe (mg)", "Zn (mg)"});
        assertThrows(StringVaziaExcepcao.class, () -> c.addElemento(new String[]{"IS019", "Leite Cabra cru", "2", "290", "86,9", "3,8", "4", "4,6", "4,8", "4,6", "0", "0", "0", "0", "0", "2,6", "1,1", "0,1", "0,1", "0,1", "11", "0,053", "53", "0", "0,05", "", "0,05", "0,1", "1", "0,3", "0,7", "0,04", "0,08", "3", "1", "0,85", "40", "181", "153", "120", "20", "0,2", "0,3"}));
    }

    @Test
    public void testTiaminamgNaoAceitarVazios() {
        ColecaoAlimentos c = new ColecaoAlimentos();
        c.addHeaderTabela(new String[]{"Código", "PRODUTO", "Energia (kcal)", "Energia (kJ)", "Água (g)", "Proteína (g)", "Gordura total (g)", "Total HC disponíveis (g)", "Total HC expresso em monossacáridos (g)", "Mono + dissacáridos (g)", "Ácidos orgânicos (g)", "Álcool (g)", "Amido (g)", "Oligossacáridos (g)", "Fibra alimentar (g)", "Ácidos gordos saturados (g)", "Ácidos gordos monoinsaturados (g)", "Ácidos gordos polinsaturados  (g)", "Ácidos gordos trans (g)", "Ácido linoleico (g)", "Colesterol (mg)", "Retinol (vit. A total) (mg)", "Vit A total (equivalentes retinol) (mg)", "Caroteno (mg)", "vit. D (µg)", "a-tocoferol (mg)", "Tiamina (mg)", "Riboflavina (mg)", "Equivalentes de niacina (mg)", "Niacina (mg)", "Triptofano/60(mg)", "vit B6 (mg)", "Vit. B12 (µg)", "vit. C (mg)", "Folatos (µg)", "Cinza (g)", "Na (mg)", "K    (mg)", "Ca (mg)", "P (mg)", "Mg (mg)", "Fe (mg)", "Zn (mg)"});
        assertThrows(StringVaziaExcepcao.class, () -> c.addElemento(new String[]{"IS019", "Leite Cabra cru", "2", "290", "86,9", "3,8", "4", "4,6", "4,8", "4,6", "0", "0", "0", "0", "0", "2,6", "1,1", "0,1", "0,1", "0,1", "11", "0,053", "53", "0", "0,05", "0,03", "", "0,1", "1", "0,3", "0,7", "0,04", "0,08", "3", "1", "0,85", "40", "181", "153", "120", "20", "0,2", "0,3"}));
    }

    @Test
    public void testRiboflavinamgNaoAceitarVazios() {
        ColecaoAlimentos c = new ColecaoAlimentos();
        c.addHeaderTabela(new String[]{"Código", "PRODUTO", "Energia (kcal)", "Energia (kJ)", "Água (g)", "Proteína (g)", "Gordura total (g)", "Total HC disponíveis (g)", "Total HC expresso em monossacáridos (g)", "Mono + dissacáridos (g)", "Ácidos orgânicos (g)", "Álcool (g)", "Amido (g)", "Oligossacáridos (g)", "Fibra alimentar (g)", "Ácidos gordos saturados (g)", "Ácidos gordos monoinsaturados (g)", "Ácidos gordos polinsaturados  (g)", "Ácidos gordos trans (g)", "Ácido linoleico (g)", "Colesterol (mg)", "Retinol (vit. A total) (mg)", "Vit A total (equivalentes retinol) (mg)", "Caroteno (mg)", "vit. D (µg)", "a-tocoferol (mg)", "Tiamina (mg)", "Riboflavina (mg)", "Equivalentes de niacina (mg)", "Niacina (mg)", "Triptofano/60(mg)", "vit B6 (mg)", "Vit. B12 (µg)", "vit. C (mg)", "Folatos (µg)", "Cinza (g)", "Na (mg)", "K    (mg)", "Ca (mg)", "P (mg)", "Mg (mg)", "Fe (mg)", "Zn (mg)"});
        assertThrows(StringVaziaExcepcao.class, () -> c.addElemento(new String[]{"IS019", "Leite Cabra cru", "2", "290", "86,9", "3,8", "4", "4,6", "4,8", "4,6", "0", "0", "0", "0", "0", "2,6", "1,1", "0,1", "0,1", "0,1", "11", "0,053", "53", "0", "0,05", "0,03", "0,05", "", "1", "0,3", "0,7", "0,04", "0,08", "3", "1", "0,85", "40", "181", "153", "120", "20", "0,2", "0,3"}));
    }

    @Test
    public void testEquivalentesdeniacinamgNaoAceitarVazios() {
        ColecaoAlimentos c = new ColecaoAlimentos();
        c.addHeaderTabela(new String[]{"Código", "PRODUTO", "Energia (kcal)", "Energia (kJ)", "Água (g)", "Proteína (g)", "Gordura total (g)", "Total HC disponíveis (g)", "Total HC expresso em monossacáridos (g)", "Mono + dissacáridos (g)", "Ácidos orgânicos (g)", "Álcool (g)", "Amido (g)", "Oligossacáridos (g)", "Fibra alimentar (g)", "Ácidos gordos saturados (g)", "Ácidos gordos monoinsaturados (g)", "Ácidos gordos polinsaturados  (g)", "Ácidos gordos trans (g)", "Ácido linoleico (g)", "Colesterol (mg)", "Retinol (vit. A total) (mg)", "Vit A total (equivalentes retinol) (mg)", "Caroteno (mg)", "vit. D (µg)", "a-tocoferol (mg)", "Tiamina (mg)", "Riboflavina (mg)", "Equivalentes de niacina (mg)", "Niacina (mg)", "Triptofano/60(mg)", "vit B6 (mg)", "Vit. B12 (µg)", "vit. C (mg)", "Folatos (µg)", "Cinza (g)", "Na (mg)", "K    (mg)", "Ca (mg)", "P (mg)", "Mg (mg)", "Fe (mg)", "Zn (mg)"});
        assertThrows(StringVaziaExcepcao.class, () -> c.addElemento(new String[]{"IS019", "Leite Cabra cru", "2", "290", "86,9", "3,8", "4", "4,6", "4,8", "4,6", "0", "0", "0", "0", "0", "2,6", "1,1", "0,1", "0,1", "0,1", "11", "0,053", "53", "0", "0,05", "0,03", "0,05", "0,1", "", "0,3", "0,7", "0,04", "0,08", "3", "1", "0,85", "40", "181", "153", "120", "20", "0,2", "0,3"}));
    }

    @Test
    public void testNiacinamgNaoAceitarVazios() {
        ColecaoAlimentos c = new ColecaoAlimentos();
        c.addHeaderTabela(new String[]{"Código", "PRODUTO", "Energia (kcal)", "Energia (kJ)", "Água (g)", "Proteína (g)", "Gordura total (g)", "Total HC disponíveis (g)", "Total HC expresso em monossacáridos (g)", "Mono + dissacáridos (g)", "Ácidos orgânicos (g)", "Álcool (g)", "Amido (g)", "Oligossacáridos (g)", "Fibra alimentar (g)", "Ácidos gordos saturados (g)", "Ácidos gordos monoinsaturados (g)", "Ácidos gordos polinsaturados  (g)", "Ácidos gordos trans (g)", "Ácido linoleico (g)", "Colesterol (mg)", "Retinol (vit. A total) (mg)", "Vit A total (equivalentes retinol) (mg)", "Caroteno (mg)", "vit. D (µg)", "a-tocoferol (mg)", "Tiamina (mg)", "Riboflavina (mg)", "Equivalentes de niacina (mg)", "Niacina (mg)", "Triptofano/60(mg)", "vit B6 (mg)", "Vit. B12 (µg)", "vit. C (mg)", "Folatos (µg)", "Cinza (g)", "Na (mg)", "K    (mg)", "Ca (mg)", "P (mg)", "Mg (mg)", "Fe (mg)", "Zn (mg)"});
        assertThrows(StringVaziaExcepcao.class, () -> c.addElemento(new String[]{"IS019", "Leite Cabra cru", "2", "290", "86,9", "3,8", "4", "4,6", "4,8", "4,6", "0", "0", "0", "0", "0", "2,6", "1,1", "0,1", "0,1", "0,1", "11", "0,053", "53", "0", "0,05", "0,03", "0,05", "0,1", "1", "", "0,7", "0,04", "0,08", "3", "1", "0,85", "40", "181", "153", "120", "20", "0,2", "0,3"}));
    }

    @Test
    public void testTriptofanoNaoAceitarVazios() {
        ColecaoAlimentos c = new ColecaoAlimentos();
        c.addHeaderTabela(new String[]{"Código", "PRODUTO", "Energia (kcal)", "Energia (kJ)", "Água (g)", "Proteína (g)", "Gordura total (g)", "Total HC disponíveis (g)", "Total HC expresso em monossacáridos (g)", "Mono + dissacáridos (g)", "Ácidos orgânicos (g)", "Álcool (g)", "Amido (g)", "Oligossacáridos (g)", "Fibra alimentar (g)", "Ácidos gordos saturados (g)", "Ácidos gordos monoinsaturados (g)", "Ácidos gordos polinsaturados  (g)", "Ácidos gordos trans (g)", "Ácido linoleico (g)", "Colesterol (mg)", "Retinol (vit. A total) (mg)", "Vit A total (equivalentes retinol) (mg)", "Caroteno (mg)", "vit. D (µg)", "a-tocoferol (mg)", "Tiamina (mg)", "Riboflavina (mg)", "Equivalentes de niacina (mg)", "Niacina (mg)", "Triptofano/60(mg)", "vit B6 (mg)", "Vit. B12 (µg)", "vit. C (mg)", "Folatos (µg)", "Cinza (g)", "Na (mg)", "K    (mg)", "Ca (mg)", "P (mg)", "Mg (mg)", "Fe (mg)", "Zn (mg)"});
        assertThrows(StringVaziaExcepcao.class, () -> c.addElemento(new String[]{"IS019", "Leite Cabra cru", "2", "290", "86,9", "3,8", "4", "4,6", "4,8", "4,6", "0", "0", "0", "0", "0", "2,6", "1,1", "0,1", "0,1", "0,1", "11", "0,053", "53", "0", "0,05", "0,03", "0,05", "0,1", "1", "0,3", "", "0,04", "0,08", "3", "1", "0,85", "40", "181", "153", "120", "20", "0,2", "0,3"}));
    }

    @Test
    public void testvitB6mgNaoAceitarVazios() {
        ColecaoAlimentos c = new ColecaoAlimentos();
        c.addHeaderTabela(new String[]{"Código", "PRODUTO", "Energia (kcal)", "Energia (kJ)", "Água (g)", "Proteína (g)", "Gordura total (g)", "Total HC disponíveis (g)", "Total HC expresso em monossacáridos (g)", "Mono + dissacáridos (g)", "Ácidos orgânicos (g)", "Álcool (g)", "Amido (g)", "Oligossacáridos (g)", "Fibra alimentar (g)", "Ácidos gordos saturados (g)", "Ácidos gordos monoinsaturados (g)", "Ácidos gordos polinsaturados  (g)", "Ácidos gordos trans (g)", "Ácido linoleico (g)", "Colesterol (mg)", "Retinol (vit. A total) (mg)", "Vit A total (equivalentes retinol) (mg)", "Caroteno (mg)", "vit. D (µg)", "a-tocoferol (mg)", "Tiamina (mg)", "Riboflavina (mg)", "Equivalentes de niacina (mg)", "Niacina (mg)", "Triptofano/60(mg)", "vit B6 (mg)", "Vit. B12 (µg)", "vit. C (mg)", "Folatos (µg)", "Cinza (g)", "Na (mg)", "K    (mg)", "Ca (mg)", "P (mg)", "Mg (mg)", "Fe (mg)", "Zn (mg)"});
        assertThrows(StringVaziaExcepcao.class, () -> c.addElemento(new String[]{"IS019", "Leite Cabra cru", "2", "290", "86,9", "3,8", "4", "4,6", "4,8", "4,6", "0", "0", "0", "0", "0", "2,6", "1,1", "0,1", "0,1", "0,1", "11", "0,053", "53", "0", "0,05", "0,03", "0,05", "0,1", "1", "0,3", "0,7", "", "0,08", "3", "1", "0,85", "40", "181", "153", "120", "20", "0,2", "0,3"}));
    }

    @Test
    public void testVitB12µgNaoAceitarVazios() {
        ColecaoAlimentos c = new ColecaoAlimentos();
        c.addHeaderTabela(new String[]{"Código", "PRODUTO", "Energia (kcal)", "Energia (kJ)", "Água (g)", "Proteína (g)", "Gordura total (g)", "Total HC disponíveis (g)", "Total HC expresso em monossacáridos (g)", "Mono + dissacáridos (g)", "Ácidos orgânicos (g)", "Álcool (g)", "Amido (g)", "Oligossacáridos (g)", "Fibra alimentar (g)", "Ácidos gordos saturados (g)", "Ácidos gordos monoinsaturados (g)", "Ácidos gordos polinsaturados  (g)", "Ácidos gordos trans (g)", "Ácido linoleico (g)", "Colesterol (mg)", "Retinol (vit. A total) (mg)", "Vit A total (equivalentes retinol) (mg)", "Caroteno (mg)", "vit. D (µg)", "a-tocoferol (mg)", "Tiamina (mg)", "Riboflavina (mg)", "Equivalentes de niacina (mg)", "Niacina (mg)", "Triptofano/60(mg)", "vit B6 (mg)", "Vit. B12 (µg)", "vit. C (mg)", "Folatos (µg)", "Cinza (g)", "Na (mg)", "K    (mg)", "Ca (mg)", "P (mg)", "Mg (mg)", "Fe (mg)", "Zn (mg)"});
        assertThrows(StringVaziaExcepcao.class, () -> c.addElemento(new String[]{"IS019", "Leite Cabra cru", "2", "290", "86,9", "3,8", "4", "4,6", "4,8", "4,6", "0", "0", "0", "0", "0", "2,6", "1,1", "0,1", "0,1", "0,1", "11", "0,053", "53", "0", "0,05", "0,03", "0,05", "0,1", "1", "0,3", "0,7", "0,04", "", "3", "1", "0,85", "40", "181", "153", "120", "20", "0,2", "0,3"}));
    }

    @Test
    public void testvitCmgNaoAceitarVazios() {
        ColecaoAlimentos c = new ColecaoAlimentos();
        c.addHeaderTabela(new String[]{"Código", "PRODUTO", "Energia (kcal)", "Energia (kJ)", "Água (g)", "Proteína (g)", "Gordura total (g)", "Total HC disponíveis (g)", "Total HC expresso em monossacáridos (g)", "Mono + dissacáridos (g)", "Ácidos orgânicos (g)", "Álcool (g)", "Amido (g)", "Oligossacáridos (g)", "Fibra alimentar (g)", "Ácidos gordos saturados (g)", "Ácidos gordos monoinsaturados (g)", "Ácidos gordos polinsaturados  (g)", "Ácidos gordos trans (g)", "Ácido linoleico (g)", "Colesterol (mg)", "Retinol (vit. A total) (mg)", "Vit A total (equivalentes retinol) (mg)", "Caroteno (mg)", "vit. D (µg)", "a-tocoferol (mg)", "Tiamina (mg)", "Riboflavina (mg)", "Equivalentes de niacina (mg)", "Niacina (mg)", "Triptofano/60(mg)", "vit B6 (mg)", "Vit. B12 (µg)", "vit. C (mg)", "Folatos (µg)", "Cinza (g)", "Na (mg)", "K    (mg)", "Ca (mg)", "P (mg)", "Mg (mg)", "Fe (mg)", "Zn (mg)"});
        assertThrows(StringVaziaExcepcao.class, () -> c.addElemento(new String[]{"IS019", "Leite Cabra cru", "2", "290", "86,9", "3,8", "4", "4,6", "4,8", "4,6", "0", "0", "0", "0", "0", "2,6", "1,1", "0,1", "0,1", "0,1", "11", "0,053", "53", "0", "0,05", "0,03", "0,05", "0,1", "1", "0,3", "0,7", "0,04", "0,08", "", "1", "0,85", "40", "181", "153", "120", "20", "0,2", "0,3"}));
    }

    @Test
    public void testFolatosµgNaoAceitarVazios() {
        ColecaoAlimentos c = new ColecaoAlimentos();
        c.addHeaderTabela(new String[]{"Código", "PRODUTO", "Energia (kcal)", "Energia (kJ)", "Água (g)", "Proteína (g)", "Gordura total (g)", "Total HC disponíveis (g)", "Total HC expresso em monossacáridos (g)", "Mono + dissacáridos (g)", "Ácidos orgânicos (g)", "Álcool (g)", "Amido (g)", "Oligossacáridos (g)", "Fibra alimentar (g)", "Ácidos gordos saturados (g)", "Ácidos gordos monoinsaturados (g)", "Ácidos gordos polinsaturados  (g)", "Ácidos gordos trans (g)", "Ácido linoleico (g)", "Colesterol (mg)", "Retinol (vit. A total) (mg)", "Vit A total (equivalentes retinol) (mg)", "Caroteno (mg)", "vit. D (µg)", "a-tocoferol (mg)", "Tiamina (mg)", "Riboflavina (mg)", "Equivalentes de niacina (mg)", "Niacina (mg)", "Triptofano/60(mg)", "vit B6 (mg)", "Vit. B12 (µg)", "vit. C (mg)", "Folatos (µg)", "Cinza (g)", "Na (mg)", "K    (mg)", "Ca (mg)", "P (mg)", "Mg (mg)", "Fe (mg)", "Zn (mg)"});
        assertThrows(StringVaziaExcepcao.class, () -> c.addElemento(new String[]{"IS019", "Leite Cabra cru", "2", "290", "86,9", "3,8", "4", "4,6", "4,8", "4,6", "0", "0", "0", "0", "0", "2,6", "1,1", "0,1", "0,1", "0,1", "11", "0,053", "53", "0", "0,05", "0,03", "0,05", "0,1", "1", "0,3", "0,7", "0,04", "0,08", "3", "", "0,85", "40", "181", "153", "120", "20", "0,2", "0,3"}));
    }

    @Test
    public void testCinzagNaoAceitarVazios() {
        ColecaoAlimentos c = new ColecaoAlimentos();
        c.addHeaderTabela(new String[]{"Código", "PRODUTO", "Energia (kcal)", "Energia (kJ)", "Água (g)", "Proteína (g)", "Gordura total (g)", "Total HC disponíveis (g)", "Total HC expresso em monossacáridos (g)", "Mono + dissacáridos (g)", "Ácidos orgânicos (g)", "Álcool (g)", "Amido (g)", "Oligossacáridos (g)", "Fibra alimentar (g)", "Ácidos gordos saturados (g)", "Ácidos gordos monoinsaturados (g)", "Ácidos gordos polinsaturados  (g)", "Ácidos gordos trans (g)", "Ácido linoleico (g)", "Colesterol (mg)", "Retinol (vit. A total) (mg)", "Vit A total (equivalentes retinol) (mg)", "Caroteno (mg)", "vit. D (µg)", "a-tocoferol (mg)", "Tiamina (mg)", "Riboflavina (mg)", "Equivalentes de niacina (mg)", "Niacina (mg)", "Triptofano/60(mg)", "vit B6 (mg)", "Vit. B12 (µg)", "vit. C (mg)", "Folatos (µg)", "Cinza (g)", "Na (mg)", "K    (mg)", "Ca (mg)", "P (mg)", "Mg (mg)", "Fe (mg)", "Zn (mg)"});
        assertThrows(StringVaziaExcepcao.class, () -> c.addElemento(new String[]{"IS019", "Leite Cabra cru", "2", "290", "86,9", "3,8", "4", "4,6", "4,8", "4,6", "0", "0", "0", "0", "0", "2,6", "1,1", "0,1", "0,1", "0,1", "11", "0,053", "53", "0", "0,05", "0,03", "0,05", "0,1", "1", "0,3", "0,7", "0,04", "0,08", "3", "1", "", "40", "181", "153", "120", "20", "0,2", "0,3"}));
    }

    @Test
    public void testNamgNaoAceitarVazios() {
        ColecaoAlimentos c = new ColecaoAlimentos();
        c.addHeaderTabela(new String[]{"Código", "PRODUTO", "Energia (kcal)", "Energia (kJ)", "Água (g)", "Proteína (g)", "Gordura total (g)", "Total HC disponíveis (g)", "Total HC expresso em monossacáridos (g)", "Mono + dissacáridos (g)", "Ácidos orgânicos (g)", "Álcool (g)", "Amido (g)", "Oligossacáridos (g)", "Fibra alimentar (g)", "Ácidos gordos saturados (g)", "Ácidos gordos monoinsaturados (g)", "Ácidos gordos polinsaturados  (g)", "Ácidos gordos trans (g)", "Ácido linoleico (g)", "Colesterol (mg)", "Retinol (vit. A total) (mg)", "Vit A total (equivalentes retinol) (mg)", "Caroteno (mg)", "vit. D (µg)", "a-tocoferol (mg)", "Tiamina (mg)", "Riboflavina (mg)", "Equivalentes de niacina (mg)", "Niacina (mg)", "Triptofano/60(mg)", "vit B6 (mg)", "Vit. B12 (µg)", "vit. C (mg)", "Folatos (µg)", "Cinza (g)", "Na (mg)", "K    (mg)", "Ca (mg)", "P (mg)", "Mg (mg)", "Fe (mg)", "Zn (mg)"});
        assertThrows(StringVaziaExcepcao.class, () -> c.addElemento(new String[]{"IS019", "Leite Cabra cru", "2", "290", "86,9", "3,8", "4", "4,6", "4,8", "4,6", "0", "0", "0", "0", "0", "2,6", "1,1", "0,1", "0,1", "0,1", "11", "0,053", "53", "0", "0,05", "0,03", "0,05", "0,1", "1", "0,3", "0,7", "0,04", "0,08", "3", "1", "0,85", "", "181", "153", "120", "20", "0,2", "0,3"}));
    }

    @Test
    public void testKmgNaoAceitarVazios() {
        ColecaoAlimentos c = new ColecaoAlimentos();
        c.addHeaderTabela(new String[]{"Código", "PRODUTO", "Energia (kcal)", "Energia (kJ)", "Água (g)", "Proteína (g)", "Gordura total (g)", "Total HC disponíveis (g)", "Total HC expresso em monossacáridos (g)", "Mono + dissacáridos (g)", "Ácidos orgânicos (g)", "Álcool (g)", "Amido (g)", "Oligossacáridos (g)", "Fibra alimentar (g)", "Ácidos gordos saturados (g)", "Ácidos gordos monoinsaturados (g)", "Ácidos gordos polinsaturados  (g)", "Ácidos gordos trans (g)", "Ácido linoleico (g)", "Colesterol (mg)", "Retinol (vit. A total) (mg)", "Vit A total (equivalentes retinol) (mg)", "Caroteno (mg)", "vit. D (µg)", "a-tocoferol (mg)", "Tiamina (mg)", "Riboflavina (mg)", "Equivalentes de niacina (mg)", "Niacina (mg)", "Triptofano/60(mg)", "vit B6 (mg)", "Vit. B12 (µg)", "vit. C (mg)", "Folatos (µg)", "Cinza (g)", "Na (mg)", "K    (mg)", "Ca (mg)", "P (mg)", "Mg (mg)", "Fe (mg)", "Zn (mg)"});
        assertThrows(StringVaziaExcepcao.class, () -> c.addElemento(new String[]{"IS019", "Leite Cabra cru", "2", "290", "86,9", "3,8", "4", "4,6", "4,8", "4,6", "0", "0", "0", "0", "0", "2,6", "1,1", "0,1", "0,1", "0,1", "11", "0,053", "53", "0", "0,05", "0,03", "0,05", "0,1", "1", "0,3", "0,7", "0,04", "0,08", "3", "1", "0,85", "40", "", "153", "120", "20", "0,2", "0,3"}));
    }

    @Test
    public void testCamgNaoAceitarVazios() {
        ColecaoAlimentos c = new ColecaoAlimentos();
        c.addHeaderTabela(new String[]{"Código", "PRODUTO", "Energia (kcal)", "Energia (kJ)", "Água (g)", "Proteína (g)", "Gordura total (g)", "Total HC disponíveis (g)", "Total HC expresso em monossacáridos (g)", "Mono + dissacáridos (g)", "Ácidos orgânicos (g)", "Álcool (g)", "Amido (g)", "Oligossacáridos (g)", "Fibra alimentar (g)", "Ácidos gordos saturados (g)", "Ácidos gordos monoinsaturados (g)", "Ácidos gordos polinsaturados  (g)", "Ácidos gordos trans (g)", "Ácido linoleico (g)", "Colesterol (mg)", "Retinol (vit. A total) (mg)", "Vit A total (equivalentes retinol) (mg)", "Caroteno (mg)", "vit. D (µg)", "a-tocoferol (mg)", "Tiamina (mg)", "Riboflavina (mg)", "Equivalentes de niacina (mg)", "Niacina (mg)", "Triptofano/60(mg)", "vit B6 (mg)", "Vit. B12 (µg)", "vit. C (mg)", "Folatos (µg)", "Cinza (g)", "Na (mg)", "K    (mg)", "Ca (mg)", "P (mg)", "Mg (mg)", "Fe (mg)", "Zn (mg)"});
        assertThrows(StringVaziaExcepcao.class, () -> c.addElemento(new String[]{"IS019", "Leite Cabra cru", "2", "290", "86,9", "3,8", "4", "4,6", "4,8", "4,6", "0", "0", "0", "0", "0", "2,6", "1,1", "0,1", "0,1", "0,1", "11", "0,053", "53", "0", "0,05", "0,03", "0,05", "0,1", "1", "0,3", "0,7", "0,04", "0,08", "3", "1", "0,85", "40", "181", "", "120", "20", "0,2", "0,3"}));
    }

    @Test
    public void testPmgNaoAceitarVazios() {
        ColecaoAlimentos c = new ColecaoAlimentos();
        c.addHeaderTabela(new String[]{"Código", "PRODUTO", "Energia (kcal)", "Energia (kJ)", "Água (g)", "Proteína (g)", "Gordura total (g)", "Total HC disponíveis (g)", "Total HC expresso em monossacáridos (g)", "Mono + dissacáridos (g)", "Ácidos orgânicos (g)", "Álcool (g)", "Amido (g)", "Oligossacáridos (g)", "Fibra alimentar (g)", "Ácidos gordos saturados (g)", "Ácidos gordos monoinsaturados (g)", "Ácidos gordos polinsaturados  (g)", "Ácidos gordos trans (g)", "Ácido linoleico (g)", "Colesterol (mg)", "Retinol (vit. A total) (mg)", "Vit A total (equivalentes retinol) (mg)", "Caroteno (mg)", "vit. D (µg)", "a-tocoferol (mg)", "Tiamina (mg)", "Riboflavina (mg)", "Equivalentes de niacina (mg)", "Niacina (mg)", "Triptofano/60(mg)", "vit B6 (mg)", "Vit. B12 (µg)", "vit. C (mg)", "Folatos (µg)", "Cinza (g)", "Na (mg)", "K    (mg)", "Ca (mg)", "P (mg)", "Mg (mg)", "Fe (mg)", "Zn (mg)"});
        assertThrows(StringVaziaExcepcao.class, () -> c.addElemento(new String[]{"IS019", "Leite Cabra cru", "2", "290", "86,9", "3,8", "4", "4,6", "4,8", "4,6", "0", "0", "0", "0", "0", "2,6", "1,1", "0,1", "0,1", "0,1", "11", "0,053", "53", "0", "0,05", "0,03", "0,05", "0,1", "1", "0,3", "0,7", "0,04", "0,08", "3", "1", "0,85", "40", "181", "153", "", "20", "0,2", "0,3"}));
    }

    @Test
    public void testMgmgNaoAceitarVazios() {
        ColecaoAlimentos c = new ColecaoAlimentos();
        c.addHeaderTabela(new String[]{"Código", "PRODUTO", "Energia (kcal)", "Energia (kJ)", "Água (g)", "Proteína (g)", "Gordura total (g)", "Total HC disponíveis (g)", "Total HC expresso em monossacáridos (g)", "Mono + dissacáridos (g)", "Ácidos orgânicos (g)", "Álcool (g)", "Amido (g)", "Oligossacáridos (g)", "Fibra alimentar (g)", "Ácidos gordos saturados (g)", "Ácidos gordos monoinsaturados (g)", "Ácidos gordos polinsaturados  (g)", "Ácidos gordos trans (g)", "Ácido linoleico (g)", "Colesterol (mg)", "Retinol (vit. A total) (mg)", "Vit A total (equivalentes retinol) (mg)", "Caroteno (mg)", "vit. D (µg)", "a-tocoferol (mg)", "Tiamina (mg)", "Riboflavina (mg)", "Equivalentes de niacina (mg)", "Niacina (mg)", "Triptofano/60(mg)", "vit B6 (mg)", "Vit. B12 (µg)", "vit. C (mg)", "Folatos (µg)", "Cinza (g)", "Na (mg)", "K    (mg)", "Ca (mg)", "P (mg)", "Mg (mg)", "Fe (mg)", "Zn (mg)"});
        assertThrows(StringVaziaExcepcao.class, () -> c.addElemento(new String[]{"IS019", "Leite Cabra cru", "2", "290", "86,9", "3,8", "4", "4,6", "4,8", "4,6", "0", "0", "0", "0", "0", "2,6", "1,1", "0,1", "0,1", "0,1", "11", "0,053", "53", "0", "0,05", "0,03", "0,05", "0,1", "1", "0,3", "0,7", "0,04", "0,08", "3", "1", "0,85", "40", "181", "153", "120", "", "0,2", "0,3"}));
    }

    @Test
    public void testFemgNaoAceitarVazios() {
        ColecaoAlimentos c = new ColecaoAlimentos();
        c.addHeaderTabela(new String[]{"Código", "PRODUTO", "Energia (kcal)", "Energia (kJ)", "Água (g)", "Proteína (g)", "Gordura total (g)", "Total HC disponíveis (g)", "Total HC expresso em monossacáridos (g)", "Mono + dissacáridos (g)", "Ácidos orgânicos (g)", "Álcool (g)", "Amido (g)", "Oligossacáridos (g)", "Fibra alimentar (g)", "Ácidos gordos saturados (g)", "Ácidos gordos monoinsaturados (g)", "Ácidos gordos polinsaturados  (g)", "Ácidos gordos trans (g)", "Ácido linoleico (g)", "Colesterol (mg)", "Retinol (vit. A total) (mg)", "Vit A total (equivalentes retinol) (mg)", "Caroteno (mg)", "vit. D (µg)", "a-tocoferol (mg)", "Tiamina (mg)", "Riboflavina (mg)", "Equivalentes de niacina (mg)", "Niacina (mg)", "Triptofano/60(mg)", "vit B6 (mg)", "Vit. B12 (µg)", "vit. C (mg)", "Folatos (µg)", "Cinza (g)", "Na (mg)", "K    (mg)", "Ca (mg)", "P (mg)", "Mg (mg)", "Fe (mg)", "Zn (mg)"});
        assertThrows(StringVaziaExcepcao.class, () -> c.addElemento(new String[]{"IS019", "Leite Cabra cru", "2", "290", "86,9", "3,8", "4", "4,6", "4,8", "4,6", "0", "0", "0", "0", "0", "2,6", "1,1", "0,1", "0,1", "0,1", "11", "0,053", "53", "0", "0,05", "0,03", "0,05", "0,1", "1", "0,3", "0,7", "0,04", "0,08", "3", "1", "0,85", "40", "181", "153", "120", "20", "", "0,3"}));
    }

    @Test
    public void testZnmgNaoAceitarVazios() {
        ColecaoAlimentos c = new ColecaoAlimentos();
        c.addHeaderTabela(new String[]{"Código", "PRODUTO", "Energia (kcal)", "Energia (kJ)", "Água (g)", "Proteína (g)", "Gordura total (g)", "Total HC disponíveis (g)", "Total HC expresso em monossacáridos (g)", "Mono + dissacáridos (g)", "Ácidos orgânicos (g)", "Álcool (g)", "Amido (g)", "Oligossacáridos (g)", "Fibra alimentar (g)", "Ácidos gordos saturados (g)", "Ácidos gordos monoinsaturados (g)", "Ácidos gordos polinsaturados  (g)", "Ácidos gordos trans (g)", "Ácido linoleico (g)", "Colesterol (mg)", "Retinol (vit. A total) (mg)", "Vit A total (equivalentes retinol) (mg)", "Caroteno (mg)", "vit. D (µg)", "a-tocoferol (mg)", "Tiamina (mg)", "Riboflavina (mg)", "Equivalentes de niacina (mg)", "Niacina (mg)", "Triptofano/60(mg)", "vit B6 (mg)", "Vit. B12 (µg)", "vit. C (mg)", "Folatos (µg)", "Cinza (g)", "Na (mg)", "K    (mg)", "Ca (mg)", "P (mg)", "Mg (mg)", "Fe (mg)", "Zn (mg)"});
        assertThrows(StringVaziaExcepcao.class, () -> c.addElemento(new String[]{"IS019", "Leite Cabra cru", "2", "290", "86,9", "3,8", "4", "4,6", "4,8", "4,6", "0", "0", "0", "0", "0", "2,6", "1,1", "0,1", "0,1", "0,1", "11", "0,053", "53", "0", "0,05", "0,03", "0,05", "0,1", "1", "0,3", "0,7", "0,04", "0,08", "3", "1", "0,85", "40", "181", "153", "120", "20", "0,2", ""}));
    }


    @Test
    public void testCodigoNaoAceitarNulos() {
        ColecaoAlimentos c = new ColecaoAlimentos();
        c.addHeaderTabela(new String[]{"Código", "PRODUTO", "Energia (kcal)", "Energia (kJ)", "Água (g)", "Proteína (g)", "Gordura total (g)", "Total HC disponíveis (g)", "Total HC expresso em monossacáridos (g)", "Mono + dissacáridos (g)", "Ácidos orgânicos (g)", "Álcool (g)", "Amido (g)", "Oligossacáridos (g)", "Fibra alimentar (g)", "Ácidos gordos saturados (g)", "Ácidos gordos monoinsaturados (g)", "Ácidos gordos polinsaturados  (g)", "Ácidos gordos trans (g)", "Ácido linoleico (g)", "Colesterol (mg)", "Retinol (vit. A total) (mg)", "Vit A total (equivalentes retinol) (mg)", "Caroteno (mg)", "vit. D (µg)", "a-tocoferol (mg)", "Tiamina (mg)", "Riboflavina (mg)", "Equivalentes de niacina (mg)", "Niacina (mg)", "Triptofano/60(mg)", "vit B6 (mg)", "Vit. B12 (µg)", "vit. C (mg)", "Folatos (µg)", "Cinza (g)", "Na (mg)", "K    (mg)", "Ca (mg)", "P (mg)", "Mg (mg)", "Fe (mg)", "Zn (mg)"});
        assertThrows(NullExcepcao.class, () -> c.addElemento(new String[]{null, "Leite Cabra cru", "2", "290", "86,9", "3,8", "4", "4,6", "4,8", "4,6", "0", "0", "0", "0", "0", "2,6", "1,1", "0,1", "0,1", "0,1", "11", "0,053", "53", "0", "0,05", "0,03", "0,05", "0,1", "1", "0,3", "0,7", "0,04", "0,08", "3", "1", "0,85", "40", "181", "153", "120", "20", "0,2", "0,3"}));
    }

    @Test
    public void testProdutoNaoAceitarNulos() {
        ColecaoAlimentos c = new ColecaoAlimentos();
        c.addHeaderTabela(new String[]{"Código", "PRODUTO", "Energia (kcal)", "Energia (kJ)", "Água (g)", "Proteína (g)", "Gordura total (g)", "Total HC disponíveis (g)", "Total HC expresso em monossacáridos (g)", "Mono + dissacáridos (g)", "Ácidos orgânicos (g)", "Álcool (g)", "Amido (g)", "Oligossacáridos (g)", "Fibra alimentar (g)", "Ácidos gordos saturados (g)", "Ácidos gordos monoinsaturados (g)", "Ácidos gordos polinsaturados  (g)", "Ácidos gordos trans (g)", "Ácido linoleico (g)", "Colesterol (mg)", "Retinol (vit. A total) (mg)", "Vit A total (equivalentes retinol) (mg)", "Caroteno (mg)", "vit. D (µg)", "a-tocoferol (mg)", "Tiamina (mg)", "Riboflavina (mg)", "Equivalentes de niacina (mg)", "Niacina (mg)", "Triptofano/60(mg)", "vit B6 (mg)", "Vit. B12 (µg)", "vit. C (mg)", "Folatos (µg)", "Cinza (g)", "Na (mg)", "K    (mg)", "Ca (mg)", "P (mg)", "Mg (mg)", "Fe (mg)", "Zn (mg)"});
        assertThrows(NullExcepcao.class, () -> c.addElemento(new String[]{"IS019", null, "2", "290", "86,9", "3,8", "4", "4,6", "4,8", "4,6", "0", "0", "0", "0", "0", "2,6", "1,1", "0,1", "0,1", "0,1", "11", "0,053", "53", "0", "0,05", "0,03", "0,05", "0,1", "1", "0,3", "0,7", "0,04", "0,08", "3", "1", "0,85", "40", "181", "153", "120", "20", "0,2", "0,3"}));
    }



    @Test
    public void testEnergiakcalNaoAceitarNulos() {
        ColecaoAlimentos c = new ColecaoAlimentos();
        c.addHeaderTabela(new String[]{"Código", "PRODUTO", "Energia (kcal)", "Energia (kJ)", "Água (g)", "Proteína (g)", "Gordura total (g)", "Total HC disponíveis (g)", "Total HC expresso em monossacáridos (g)", "Mono + dissacáridos (g)", "Ácidos orgânicos (g)", "Álcool (g)", "Amido (g)", "Oligossacáridos (g)", "Fibra alimentar (g)", "Ácidos gordos saturados (g)", "Ácidos gordos monoinsaturados (g)", "Ácidos gordos polinsaturados  (g)", "Ácidos gordos trans (g)", "Ácido linoleico (g)", "Colesterol (mg)", "Retinol (vit. A total) (mg)", "Vit A total (equivalentes retinol) (mg)", "Caroteno (mg)", "vit. D (µg)", "a-tocoferol (mg)", "Tiamina (mg)", "Riboflavina (mg)", "Equivalentes de niacina (mg)", "Niacina (mg)", "Triptofano/60(mg)", "vit B6 (mg)", "Vit. B12 (µg)", "vit. C (mg)", "Folatos (µg)", "Cinza (g)", "Na (mg)", "K    (mg)", "Ca (mg)", "P (mg)", "Mg (mg)", "Fe (mg)", "Zn (mg)"});
        assertThrows(NullExcepcao.class, () -> c.addElemento(new String[]{"IS019", "Leite Cabra cru", null, "290", "86,9", "3,8", "4", "4,6", "4,8", "4,6", "0", "0", "0", "0", "0", "2,6", "1,1", "0,1", "0,1", "0,1", "11", "0,053", "53", "0", "0,05", "0,03", "0,05", "0,1", "1", "0,3", "0,7", "0,04", "0,08", "3", "1", "0,85", "40", "181", "153", "120", "20", "0,2", "0,3"}));
    }

    @Test
    public void testEnergiakJNaoAceitarNulos() {
        ColecaoAlimentos c = new ColecaoAlimentos();
        c.addHeaderTabela(new String[]{"Código", "PRODUTO", "Energia (kcal)", "Energia (kJ)", "Água (g)", "Proteína (g)", "Gordura total (g)", "Total HC disponíveis (g)", "Total HC expresso em monossacáridos (g)", "Mono + dissacáridos (g)", "Ácidos orgânicos (g)", "Álcool (g)", "Amido (g)", "Oligossacáridos (g)", "Fibra alimentar (g)", "Ácidos gordos saturados (g)", "Ácidos gordos monoinsaturados (g)", "Ácidos gordos polinsaturados  (g)", "Ácidos gordos trans (g)", "Ácido linoleico (g)", "Colesterol (mg)", "Retinol (vit. A total) (mg)", "Vit A total (equivalentes retinol) (mg)", "Caroteno (mg)", "vit. D (µg)", "a-tocoferol (mg)", "Tiamina (mg)", "Riboflavina (mg)", "Equivalentes de niacina (mg)", "Niacina (mg)", "Triptofano/60(mg)", "vit B6 (mg)", "Vit. B12 (µg)", "vit. C (mg)", "Folatos (µg)", "Cinza (g)", "Na (mg)", "K    (mg)", "Ca (mg)", "P (mg)", "Mg (mg)", "Fe (mg)", "Zn (mg)"});
        assertThrows(NullExcepcao.class, () -> c.addElemento(new String[]{"IS019", "Leite Cabra cru", "2", null, "86,9", "3,8", "4", "4,6", "4,8", "4,6", "0", "0", "0", "0", "0", "2,6", "1,1", "0,1", "0,1", "0,1", "11", "0,053", "53", "0", "0,05", "0,03", "0,05", "0,1", "1", "0,3", "0,7", "0,04", "0,08", "3", "1", "0,85", "40", "181", "153", "120", "20", "0,2", "0,3"}));
    }

    @Test
    public void testaguagNaoAceitarNulos() {
        ColecaoAlimentos c = new ColecaoAlimentos();
        c.addHeaderTabela(new String[]{"Código", "PRODUTO", "Energia (kcal)", "Energia (kJ)", "Água (g)", "Proteína (g)", "Gordura total (g)", "Total HC disponíveis (g)", "Total HC expresso em monossacáridos (g)", "Mono + dissacáridos (g)", "Ácidos orgânicos (g)", "Álcool (g)", "Amido (g)", "Oligossacáridos (g)", "Fibra alimentar (g)", "Ácidos gordos saturados (g)", "Ácidos gordos monoinsaturados (g)", "Ácidos gordos polinsaturados  (g)", "Ácidos gordos trans (g)", "Ácido linoleico (g)", "Colesterol (mg)", "Retinol (vit. A total) (mg)", "Vit A total (equivalentes retinol) (mg)", "Caroteno (mg)", "vit. D (µg)", "a-tocoferol (mg)", "Tiamina (mg)", "Riboflavina (mg)", "Equivalentes de niacina (mg)", "Niacina (mg)", "Triptofano/60(mg)", "vit B6 (mg)", "Vit. B12 (µg)", "vit. C (mg)", "Folatos (µg)", "Cinza (g)", "Na (mg)", "K    (mg)", "Ca (mg)", "P (mg)", "Mg (mg)", "Fe (mg)", "Zn (mg)"});
        assertThrows(NullExcepcao.class, () -> c.addElemento(new String[]{"IS019", "Leite Cabra cru", "2", "290", null, "3,8", "4", "4,6", "4,8", "4,6", "0", "0", "0", "0", "0", "2,6", "1,1", "0,1", "0,1", "0,1", "11", "0,053", "53", "0", "0,05", "0,03", "0,05", "0,1", "1", "0,3", "0,7", "0,04", "0,08", "3", "1", "0,85", "40", "181", "153", "120", "20", "0,2", "0,3"}));
    }

    @Test
    public void testProteínagNaoAceitarNulos() {
        ColecaoAlimentos c = new ColecaoAlimentos();
        c.addHeaderTabela(new String[]{"Código", "PRODUTO", "Energia (kcal)", "Energia (kJ)", "Água (g)", "Proteína (g)", "Gordura total (g)", "Total HC disponíveis (g)", "Total HC expresso em monossacáridos (g)", "Mono + dissacáridos (g)", "Ácidos orgânicos (g)", "Álcool (g)", "Amido (g)", "Oligossacáridos (g)", "Fibra alimentar (g)", "Ácidos gordos saturados (g)", "Ácidos gordos monoinsaturados (g)", "Ácidos gordos polinsaturados  (g)", "Ácidos gordos trans (g)", "Ácido linoleico (g)", "Colesterol (mg)", "Retinol (vit. A total) (mg)", "Vit A total (equivalentes retinol) (mg)", "Caroteno (mg)", "vit. D (µg)", "a-tocoferol (mg)", "Tiamina (mg)", "Riboflavina (mg)", "Equivalentes de niacina (mg)", "Niacina (mg)", "Triptofano/60(mg)", "vit B6 (mg)", "Vit. B12 (µg)", "vit. C (mg)", "Folatos (µg)", "Cinza (g)", "Na (mg)", "K    (mg)", "Ca (mg)", "P (mg)", "Mg (mg)", "Fe (mg)", "Zn (mg)"});
        assertThrows(NullExcepcao.class, () -> c.addElemento(new String[]{"IS019", "Leite Cabra cru", "2", "290", "86,9", null, "4", "4,6", "4,8", "4,6", "0", "0", "0", "0", "0", "2,6", "1,1", "0,1", "0,1", "0,1", "11", "0,053", "53", "0", "0,05", "0,03", "0,05", "0,1", "1", "0,3", "0,7", "0,04", "0,08", "3", "1", "0,85", "40", "181", "153", "120", "20", "0,2", "0,3"}));
    }

    @Test
    public void testGorduratotalgNaoAceitarNulos() {
        ColecaoAlimentos c = new ColecaoAlimentos();
        c.addHeaderTabela(new String[]{"Código", "PRODUTO", "Energia (kcal)", "Energia (kJ)", "Água (g)", "Proteína (g)", "Gordura total (g)", "Total HC disponíveis (g)", "Total HC expresso em monossacáridos (g)", "Mono + dissacáridos (g)", "Ácidos orgânicos (g)", "Álcool (g)", "Amido (g)", "Oligossacáridos (g)", "Fibra alimentar (g)", "Ácidos gordos saturados (g)", "Ácidos gordos monoinsaturados (g)", "Ácidos gordos polinsaturados  (g)", "Ácidos gordos trans (g)", "Ácido linoleico (g)", "Colesterol (mg)", "Retinol (vit. A total) (mg)", "Vit A total (equivalentes retinol) (mg)", "Caroteno (mg)", "vit. D (µg)", "a-tocoferol (mg)", "Tiamina (mg)", "Riboflavina (mg)", "Equivalentes de niacina (mg)", "Niacina (mg)", "Triptofano/60(mg)", "vit B6 (mg)", "Vit. B12 (µg)", "vit. C (mg)", "Folatos (µg)", "Cinza (g)", "Na (mg)", "K    (mg)", "Ca (mg)", "P (mg)", "Mg (mg)", "Fe (mg)", "Zn (mg)"});
        assertThrows(NullExcepcao.class, () -> c.addElemento(new String[]{"IS019", "Leite Cabra cru", "2", "290", "86,9", "3,8", null, "4,6", "4,8", "4,6", "0", "0", "0", "0", "0", "2,6", "1,1", "0,1", "0,1", "0,1", "11", "0,053", "53", "0", "0,05", "0,03", "0,05", "0,1", "1", "0,3", "0,7", "0,04", "0,08", "3", "1", "0,85", "40", "181", "153", "120", "20", "0,2", "0,3"}));
    }

    @Test
    public void testTotalHCdisponíveisgNaoAceitarNulos() {
        ColecaoAlimentos c = new ColecaoAlimentos();
        c.addHeaderTabela(new String[]{"Código", "PRODUTO", "Energia (kcal)", "Energia (kJ)", "Água (g)", "Proteína (g)", "Gordura total (g)", "Total HC disponíveis (g)", "Total HC expresso em monossacáridos (g)", "Mono + dissacáridos (g)", "Ácidos orgânicos (g)", "Álcool (g)", "Amido (g)", "Oligossacáridos (g)", "Fibra alimentar (g)", "Ácidos gordos saturados (g)", "Ácidos gordos monoinsaturados (g)", "Ácidos gordos polinsaturados  (g)", "Ácidos gordos trans (g)", "Ácido linoleico (g)", "Colesterol (mg)", "Retinol (vit. A total) (mg)", "Vit A total (equivalentes retinol) (mg)", "Caroteno (mg)", "vit. D (µg)", "a-tocoferol (mg)", "Tiamina (mg)", "Riboflavina (mg)", "Equivalentes de niacina (mg)", "Niacina (mg)", "Triptofano/60(mg)", "vit B6 (mg)", "Vit. B12 (µg)", "vit. C (mg)", "Folatos (µg)", "Cinza (g)", "Na (mg)", "K    (mg)", "Ca (mg)", "P (mg)", "Mg (mg)", "Fe (mg)", "Zn (mg)"});
        assertThrows(NullExcepcao.class, () -> c.addElemento(new String[]{"IS019", "Leite Cabra cru", "2", "290", "86,9", "3,8", "4", null, "4,8", "4,6", "0", "0", "0", "0", "0", "2,6", "1,1", "0,1", "0,1", "0,1", "11", "0,053", "53", "0", "0,05", "0,03", "0,05", "0,1", "1", "0,3", "0,7", "0,04", "0,08", "3", "1", "0,85", "40", "181", "153", "120", "20", "0,2", "0,3"}));
    }

    @Test
    public void testTotalHCexpressoemmonossacaridosgNaoAceitarNulos() {
        ColecaoAlimentos c = new ColecaoAlimentos();
        c.addHeaderTabela(new String[]{"Código", "PRODUTO", "Energia (kcal)", "Energia (kJ)", "Água (g)", "Proteína (g)", "Gordura total (g)", "Total HC disponíveis (g)", "Total HC expresso em monossacáridos (g)", "Mono + dissacáridos (g)", "Ácidos orgânicos (g)", "Álcool (g)", "Amido (g)", "Oligossacáridos (g)", "Fibra alimentar (g)", "Ácidos gordos saturados (g)", "Ácidos gordos monoinsaturados (g)", "Ácidos gordos polinsaturados  (g)", "Ácidos gordos trans (g)", "Ácido linoleico (g)", "Colesterol (mg)", "Retinol (vit. A total) (mg)", "Vit A total (equivalentes retinol) (mg)", "Caroteno (mg)", "vit. D (µg)", "a-tocoferol (mg)", "Tiamina (mg)", "Riboflavina (mg)", "Equivalentes de niacina (mg)", "Niacina (mg)", "Triptofano/60(mg)", "vit B6 (mg)", "Vit. B12 (µg)", "vit. C (mg)", "Folatos (µg)", "Cinza (g)", "Na (mg)", "K    (mg)", "Ca (mg)", "P (mg)", "Mg (mg)", "Fe (mg)", "Zn (mg)"});
        assertThrows(NullExcepcao.class, () -> c.addElemento(new String[]{"IS019", "Leite Cabra cru", "2", "290", "86,9", "3,8", "4", "4,6", null, "4,6", "0", "0", "0", "0", "0", "2,6", "1,1", "0,1", "0,1", "0,1", "11", "0,053", "53", "0", "0,05", "0,03", "0,05", "0,1", "1", "0,3", "0,7", "0,04", "0,08", "3", "1", "0,85", "40", "181", "153", "120", "20", "0,2", "0,3"}));
    }

    @Test
    public void testMonodissacaridosgNaoAceitarNulos() {
        ColecaoAlimentos c = new ColecaoAlimentos();
        c.addHeaderTabela(new String[]{"Código", "PRODUTO", "Energia (kcal)", "Energia (kJ)", "Água (g)", "Proteína (g)", "Gordura total (g)", "Total HC disponíveis (g)", "Total HC expresso em monossacáridos (g)", "Mono + dissacáridos (g)", "Ácidos orgânicos (g)", "Álcool (g)", "Amido (g)", "Oligossacáridos (g)", "Fibra alimentar (g)", "Ácidos gordos saturados (g)", "Ácidos gordos monoinsaturados (g)", "Ácidos gordos polinsaturados  (g)", "Ácidos gordos trans (g)", "Ácido linoleico (g)", "Colesterol (mg)", "Retinol (vit. A total) (mg)", "Vit A total (equivalentes retinol) (mg)", "Caroteno (mg)", "vit. D (µg)", "a-tocoferol (mg)", "Tiamina (mg)", "Riboflavina (mg)", "Equivalentes de niacina (mg)", "Niacina (mg)", "Triptofano/60(mg)", "vit B6 (mg)", "Vit. B12 (µg)", "vit. C (mg)", "Folatos (µg)", "Cinza (g)", "Na (mg)", "K    (mg)", "Ca (mg)", "P (mg)", "Mg (mg)", "Fe (mg)", "Zn (mg)"});
        assertThrows(NullExcepcao.class, () -> c.addElemento(new String[]{"IS019", "Leite Cabra cru", "2", "290", "86,9", "3,8", "4", "4,6", "4,8", null, "0", "0", "0", "0", "0", "2,6", "1,1", "0,1", "0,1", "0,1", "11", "0,053", "53", "0", "0,05", "0,03", "0,05", "0,1", "1", "0,3", "0,7", "0,04", "0,08", "3", "1", "0,85", "40", "181", "153", "120", "20", "0,2", "0,3"}));
    }

    @Test
    public void testacidosorgânicosgNaoAceitarNulos() {
        ColecaoAlimentos c = new ColecaoAlimentos();
        c.addHeaderTabela(new String[]{"Código", "PRODUTO", "Energia (kcal)", "Energia (kJ)", "Água (g)", "Proteína (g)", "Gordura total (g)", "Total HC disponíveis (g)", "Total HC expresso em monossacáridos (g)", "Mono + dissacáridos (g)", "Ácidos orgânicos (g)", "Álcool (g)", "Amido (g)", "Oligossacáridos (g)", "Fibra alimentar (g)", "Ácidos gordos saturados (g)", "Ácidos gordos monoinsaturados (g)", "Ácidos gordos polinsaturados  (g)", "Ácidos gordos trans (g)", "Ácido linoleico (g)", "Colesterol (mg)", "Retinol (vit. A total) (mg)", "Vit A total (equivalentes retinol) (mg)", "Caroteno (mg)", "vit. D (µg)", "a-tocoferol (mg)", "Tiamina (mg)", "Riboflavina (mg)", "Equivalentes de niacina (mg)", "Niacina (mg)", "Triptofano/60(mg)", "vit B6 (mg)", "Vit. B12 (µg)", "vit. C (mg)", "Folatos (µg)", "Cinza (g)", "Na (mg)", "K    (mg)", "Ca (mg)", "P (mg)", "Mg (mg)", "Fe (mg)", "Zn (mg)"});
        assertThrows(NullExcepcao.class, () -> c.addElemento(new String[]{"IS019", "Leite Cabra cru", "2", "290", "86,9", "3,8", "4", "4,6", "4,8", "4,6", null, "0", "0", "0", "0", "2,6", "1,1", "0,1", "0,1", "0,1", "11", "0,053", "53", "0", "0,05", "0,03", "0,05", "0,1", "1", "0,3", "0,7", "0,04", "0,08", "3", "1", "0,85", "40", "181", "153", "120", "20", "0,2", "0,3"}));
    }

    @Test
    public void testalcoolgNaoAceitarNulos() {
        ColecaoAlimentos c = new ColecaoAlimentos();
        c.addHeaderTabela(new String[]{"Código", "PRODUTO", "Energia (kcal)", "Energia (kJ)", "Água (g)", "Proteína (g)", "Gordura total (g)", "Total HC disponíveis (g)", "Total HC expresso em monossacáridos (g)", "Mono + dissacáridos (g)", "Ácidos orgânicos (g)", "Álcool (g)", "Amido (g)", "Oligossacáridos (g)", "Fibra alimentar (g)", "Ácidos gordos saturados (g)", "Ácidos gordos monoinsaturados (g)", "Ácidos gordos polinsaturados  (g)", "Ácidos gordos trans (g)", "Ácido linoleico (g)", "Colesterol (mg)", "Retinol (vit. A total) (mg)", "Vit A total (equivalentes retinol) (mg)", "Caroteno (mg)", "vit. D (µg)", "a-tocoferol (mg)", "Tiamina (mg)", "Riboflavina (mg)", "Equivalentes de niacina (mg)", "Niacina (mg)", "Triptofano/60(mg)", "vit B6 (mg)", "Vit. B12 (µg)", "vit. C (mg)", "Folatos (µg)", "Cinza (g)", "Na (mg)", "K    (mg)", "Ca (mg)", "P (mg)", "Mg (mg)", "Fe (mg)", "Zn (mg)"});
        assertThrows(NullExcepcao.class, () -> c.addElemento(new String[]{"IS019", "Leite Cabra cru", "2", "290", "86,9", "3,8", "4", "4,6", "4,8", "4,6", "0", null, "0", "0", "0", "2,6", "1,1", "0,1", "0,1", "0,1", "11", "0,053", "53", "0", "0,05", "0,03", "0,05", "0,1", "1", "0,3", "0,7", "0,04", "0,08", "3", "1", "0,85", "40", "181", "153", "120", "20", "0,2", "0,3"}));
    }

    @Test
    public void testAmidogNaoAceitarNulos() {
        ColecaoAlimentos c = new ColecaoAlimentos();
        c.addHeaderTabela(new String[]{"Código", "PRODUTO", "Energia (kcal)", "Energia (kJ)", "Água (g)", "Proteína (g)", "Gordura total (g)", "Total HC disponíveis (g)", "Total HC expresso em monossacáridos (g)", "Mono + dissacáridos (g)", "Ácidos orgânicos (g)", "Álcool (g)", "Amido (g)", "Oligossacáridos (g)", "Fibra alimentar (g)", "Ácidos gordos saturados (g)", "Ácidos gordos monoinsaturados (g)", "Ácidos gordos polinsaturados  (g)", "Ácidos gordos trans (g)", "Ácido linoleico (g)", "Colesterol (mg)", "Retinol (vit. A total) (mg)", "Vit A total (equivalentes retinol) (mg)", "Caroteno (mg)", "vit. D (µg)", "a-tocoferol (mg)", "Tiamina (mg)", "Riboflavina (mg)", "Equivalentes de niacina (mg)", "Niacina (mg)", "Triptofano/60(mg)", "vit B6 (mg)", "Vit. B12 (µg)", "vit. C (mg)", "Folatos (µg)", "Cinza (g)", "Na (mg)", "K    (mg)", "Ca (mg)", "P (mg)", "Mg (mg)", "Fe (mg)", "Zn (mg)"});
        assertThrows(NullExcepcao.class, () -> c.addElemento(new String[]{"IS019", "Leite Cabra cru", "2", "290", "86,9", "3,8", "4", "4,6", "4,8", "4,6", "0", "0", null, "0", "0", "2,6", "1,1", "0,1", "0,1", "0,1", "11", "0,053", "53", "0", "0,05", "0,03", "0,05", "0,1", "1", "0,3", "0,7", "0,04", "0,08", "3", "1", "0,85", "40", "181", "153", "120", "20", "0,2", "0,3"}));
    }

    @Test
    public void testOligossacaridosgNaoAceitarNulos() {
        ColecaoAlimentos c = new ColecaoAlimentos();
        c.addHeaderTabela(new String[]{"Código", "PRODUTO", "Energia (kcal)", "Energia (kJ)", "Água (g)", "Proteína (g)", "Gordura total (g)", "Total HC disponíveis (g)", "Total HC expresso em monossacáridos (g)", "Mono + dissacáridos (g)", "Ácidos orgânicos (g)", "Álcool (g)", "Amido (g)", "Oligossacáridos (g)", "Fibra alimentar (g)", "Ácidos gordos saturados (g)", "Ácidos gordos monoinsaturados (g)", "Ácidos gordos polinsaturados  (g)", "Ácidos gordos trans (g)", "Ácido linoleico (g)", "Colesterol (mg)", "Retinol (vit. A total) (mg)", "Vit A total (equivalentes retinol) (mg)", "Caroteno (mg)", "vit. D (µg)", "a-tocoferol (mg)", "Tiamina (mg)", "Riboflavina (mg)", "Equivalentes de niacina (mg)", "Niacina (mg)", "Triptofano/60(mg)", "vit B6 (mg)", "Vit. B12 (µg)", "vit. C (mg)", "Folatos (µg)", "Cinza (g)", "Na (mg)", "K    (mg)", "Ca (mg)", "P (mg)", "Mg (mg)", "Fe (mg)", "Zn (mg)"});
        assertThrows(NullExcepcao.class, () -> c.addElemento(new String[]{"IS019", "Leite Cabra cru", "2", "290", "86,9", "3,8", "4", "4,6", "4,8", "4,6", "0", "0", "0", null, "0", "2,6", "1,1", "0,1", "0,1", "0,1", "11", "0,053", "53", "0", "0,05", "0,03", "0,05", "0,1", "1", "0,3", "0,7", "0,04", "0,08", "3", "1", "0,85", "40", "181", "153", "120", "20", "0,2", "0,3"}));
    }

    @Test
    public void testFibraalimentargNaoAceitarNulos() {
        ColecaoAlimentos c = new ColecaoAlimentos();
        c.addHeaderTabela(new String[]{"Código", "PRODUTO", "Energia (kcal)", "Energia (kJ)", "Água (g)", "Proteína (g)", "Gordura total (g)", "Total HC disponíveis (g)", "Total HC expresso em monossacáridos (g)", "Mono + dissacáridos (g)", "Ácidos orgânicos (g)", "Álcool (g)", "Amido (g)", "Oligossacáridos (g)", "Fibra alimentar (g)", "Ácidos gordos saturados (g)", "Ácidos gordos monoinsaturados (g)", "Ácidos gordos polinsaturados  (g)", "Ácidos gordos trans (g)", "Ácido linoleico (g)", "Colesterol (mg)", "Retinol (vit. A total) (mg)", "Vit A total (equivalentes retinol) (mg)", "Caroteno (mg)", "vit. D (µg)", "a-tocoferol (mg)", "Tiamina (mg)", "Riboflavina (mg)", "Equivalentes de niacina (mg)", "Niacina (mg)", "Triptofano/60(mg)", "vit B6 (mg)", "Vit. B12 (µg)", "vit. C (mg)", "Folatos (µg)", "Cinza (g)", "Na (mg)", "K    (mg)", "Ca (mg)", "P (mg)", "Mg (mg)", "Fe (mg)", "Zn (mg)"});
        assertThrows(NullExcepcao.class, () -> c.addElemento(new String[]{"IS019", "Leite Cabra cru", "2", "290", "86,9", "3,8", "4", "4,6", "4,8", "4,6", "0", "0", "0", "0", null, "2,6", "1,1", "0,1", "0,1", "0,1", "11", "0,053", "53", "0", "0,05", "0,03", "0,05", "0,1", "1", "0,3", "0,7", "0,04", "0,08", "3", "1", "0,85", "40", "181", "153", "120", "20", "0,2", "0,3"}));
    }

    @Test
    public void testacidosgordossaturadosgNaoAceitarNulos() {
        ColecaoAlimentos c = new ColecaoAlimentos();
        c.addHeaderTabela(new String[]{"Código", "PRODUTO", "Energia (kcal)", "Energia (kJ)", "Água (g)", "Proteína (g)", "Gordura total (g)", "Total HC disponíveis (g)", "Total HC expresso em monossacáridos (g)", "Mono + dissacáridos (g)", "Ácidos orgânicos (g)", "Álcool (g)", "Amido (g)", "Oligossacáridos (g)", "Fibra alimentar (g)", "Ácidos gordos saturados (g)", "Ácidos gordos monoinsaturados (g)", "Ácidos gordos polinsaturados  (g)", "Ácidos gordos trans (g)", "Ácido linoleico (g)", "Colesterol (mg)", "Retinol (vit. A total) (mg)", "Vit A total (equivalentes retinol) (mg)", "Caroteno (mg)", "vit. D (µg)", "a-tocoferol (mg)", "Tiamina (mg)", "Riboflavina (mg)", "Equivalentes de niacina (mg)", "Niacina (mg)", "Triptofano/60(mg)", "vit B6 (mg)", "Vit. B12 (µg)", "vit. C (mg)", "Folatos (µg)", "Cinza (g)", "Na (mg)", "K    (mg)", "Ca (mg)", "P (mg)", "Mg (mg)", "Fe (mg)", "Zn (mg)"});
        assertThrows(NullExcepcao.class, () -> c.addElemento(new String[]{"IS019", "Leite Cabra cru", "2", "290", "86,9", "3,8", "4", "4,6", "4,8", "4,6", "0", "0", "0", "0", "0", null, "1,1", "0,1", "0,1", "0,1", "11", "0,053", "53", "0", "0,05", "0,03", "0,05", "0,1", "1", "0,3", "0,7", "0,04", "0,08", "3", "1", "0,85", "40", "181", "153", "120", "20", "0,2", "0,3"}));
    }

    @Test
    public void testacidosgordosmonoinsaturadosgNaoAceitarNulos() {
        ColecaoAlimentos c = new ColecaoAlimentos();
        c.addHeaderTabela(new String[]{"Código", "PRODUTO", "Energia (kcal)", "Energia (kJ)", "Água (g)", "Proteína (g)", "Gordura total (g)", "Total HC disponíveis (g)", "Total HC expresso em monossacáridos (g)", "Mono + dissacáridos (g)", "Ácidos orgânicos (g)", "Álcool (g)", "Amido (g)", "Oligossacáridos (g)", "Fibra alimentar (g)", "Ácidos gordos saturados (g)", "Ácidos gordos monoinsaturados (g)", "Ácidos gordos polinsaturados  (g)", "Ácidos gordos trans (g)", "Ácido linoleico (g)", "Colesterol (mg)", "Retinol (vit. A total) (mg)", "Vit A total (equivalentes retinol) (mg)", "Caroteno (mg)", "vit. D (µg)", "a-tocoferol (mg)", "Tiamina (mg)", "Riboflavina (mg)", "Equivalentes de niacina (mg)", "Niacina (mg)", "Triptofano/60(mg)", "vit B6 (mg)", "Vit. B12 (µg)", "vit. C (mg)", "Folatos (µg)", "Cinza (g)", "Na (mg)", "K    (mg)", "Ca (mg)", "P (mg)", "Mg (mg)", "Fe (mg)", "Zn (mg)"});
        assertThrows(NullExcepcao.class, () -> c.addElemento(new String[]{"IS019", "Leite Cabra cru", "2", "290", "86,9", "3,8", "4", "4,6", "4,8", "4,6", "0", "0", "0", "0", "0", "2,6", null, "0,1", "0,1", "0,1", "11", "0,053", "53", "0", "0,05", "0,03", "0,05", "0,1", "1", "0,3", "0,7", "0,04", "0,08", "3", "1", "0,85", "40", "181", "153", "120", "20", "0,2", "0,3"}));
    }

    @Test
    public void testacidosgordospolinsaturadosgNaoAceitarNulos() {
        ColecaoAlimentos c = new ColecaoAlimentos();
        c.addHeaderTabela(new String[]{"Código", "PRODUTO", "Energia (kcal)", "Energia (kJ)", "Água (g)", "Proteína (g)", "Gordura total (g)", "Total HC disponíveis (g)", "Total HC expresso em monossacáridos (g)", "Mono + dissacáridos (g)", "Ácidos orgânicos (g)", "Álcool (g)", "Amido (g)", "Oligossacáridos (g)", "Fibra alimentar (g)", "Ácidos gordos saturados (g)", "Ácidos gordos monoinsaturados (g)", "Ácidos gordos polinsaturados  (g)", "Ácidos gordos trans (g)", "Ácido linoleico (g)", "Colesterol (mg)", "Retinol (vit. A total) (mg)", "Vit A total (equivalentes retinol) (mg)", "Caroteno (mg)", "vit. D (µg)", "a-tocoferol (mg)", "Tiamina (mg)", "Riboflavina (mg)", "Equivalentes de niacina (mg)", "Niacina (mg)", "Triptofano/60(mg)", "vit B6 (mg)", "Vit. B12 (µg)", "vit. C (mg)", "Folatos (µg)", "Cinza (g)", "Na (mg)", "K    (mg)", "Ca (mg)", "P (mg)", "Mg (mg)", "Fe (mg)", "Zn (mg)"});
        assertThrows(NullExcepcao.class, () -> c.addElemento(new String[]{"IS019", "Leite Cabra cru", "2", "290", "86,9", "3,8", "4", "4,6", "4,8", "4,6", "0", "0", "0", "0", "0", "2,6", "1,1", null, "0,1", "0,1", "11", "0,053", "53", "0", "0,05", "0,03", "0,05", "0,1", "1", "0,3", "0,7", "0,04", "0,08", "3", "1", "0,85", "40", "181", "153", "120", "20", "0,2", "0,3"}));
    }

    @Test
    public void testacidosgordostransgNaoAceitarNulos() {
        ColecaoAlimentos c = new ColecaoAlimentos();
        c.addHeaderTabela(new String[]{"Código", "PRODUTO", "Energia (kcal)", "Energia (kJ)", "Água (g)", "Proteína (g)", "Gordura total (g)", "Total HC disponíveis (g)", "Total HC expresso em monossacáridos (g)", "Mono + dissacáridos (g)", "Ácidos orgânicos (g)", "Álcool (g)", "Amido (g)", "Oligossacáridos (g)", "Fibra alimentar (g)", "Ácidos gordos saturados (g)", "Ácidos gordos monoinsaturados (g)", "Ácidos gordos polinsaturados  (g)", "Ácidos gordos trans (g)", "Ácido linoleico (g)", "Colesterol (mg)", "Retinol (vit. A total) (mg)", "Vit A total (equivalentes retinol) (mg)", "Caroteno (mg)", "vit. D (µg)", "a-tocoferol (mg)", "Tiamina (mg)", "Riboflavina (mg)", "Equivalentes de niacina (mg)", "Niacina (mg)", "Triptofano/60(mg)", "vit B6 (mg)", "Vit. B12 (µg)", "vit. C (mg)", "Folatos (µg)", "Cinza (g)", "Na (mg)", "K    (mg)", "Ca (mg)", "P (mg)", "Mg (mg)", "Fe (mg)", "Zn (mg)"});
        assertThrows(NullExcepcao.class, () -> c.addElemento(new String[]{"IS019", "Leite Cabra cru", "2", "290", "86,9", "3,8", "4", "4,6", "4,8", "4,6", "0", "0", "0", "0", "0", "2,6", "1,1", "0,1", null, "0,1", "11", "0,053", "53", "0", "0,05", "0,03", "0,05", "0,1", "1", "0,3", "0,7", "0,04", "0,08", "3", "1", "0,85", "40", "181", "153", "120", "20", "0,2", "0,3"}));
    }

    @Test
    public void testacidolinoleicogNaoAceitarNulos() {
        ColecaoAlimentos c = new ColecaoAlimentos();
        c.addHeaderTabela(new String[]{"Código", "PRODUTO", "Energia (kcal)", "Energia (kJ)", "Água (g)", "Proteína (g)", "Gordura total (g)", "Total HC disponíveis (g)", "Total HC expresso em monossacáridos (g)", "Mono + dissacáridos (g)", "Ácidos orgânicos (g)", "Álcool (g)", "Amido (g)", "Oligossacáridos (g)", "Fibra alimentar (g)", "Ácidos gordos saturados (g)", "Ácidos gordos monoinsaturados (g)", "Ácidos gordos polinsaturados  (g)", "Ácidos gordos trans (g)", "Ácido linoleico (g)", "Colesterol (mg)", "Retinol (vit. A total) (mg)", "Vit A total (equivalentes retinol) (mg)", "Caroteno (mg)", "vit. D (µg)", "a-tocoferol (mg)", "Tiamina (mg)", "Riboflavina (mg)", "Equivalentes de niacina (mg)", "Niacina (mg)", "Triptofano/60(mg)", "vit B6 (mg)", "Vit. B12 (µg)", "vit. C (mg)", "Folatos (µg)", "Cinza (g)", "Na (mg)", "K    (mg)", "Ca (mg)", "P (mg)", "Mg (mg)", "Fe (mg)", "Zn (mg)"});
        assertThrows(NullExcepcao.class, () -> c.addElemento(new String[]{"IS019", "Leite Cabra cru", "2", "290", "86,9", "3,8", "4", "4,6", "4,8", "4,6", "0", "0", "0", "0", "0", "2,6", "1,1", "0,1", "0,1", null, "11", "0,053", "53", "0", "0,05", "0,03", "0,05", "0,1", "1", "0,3", "0,7", "0,04", "0,08", "3", "1", "0,85", "40", "181", "153", "120", "20", "0,2", "0,3"}));
    }

    @Test
    public void testColesterolmgNaoAceitarNulos() {
        ColecaoAlimentos c = new ColecaoAlimentos();
        c.addHeaderTabela(new String[]{"Código", "PRODUTO", "Energia (kcal)", "Energia (kJ)", "Água (g)", "Proteína (g)", "Gordura total (g)", "Total HC disponíveis (g)", "Total HC expresso em monossacáridos (g)", "Mono + dissacáridos (g)", "Ácidos orgânicos (g)", "Álcool (g)", "Amido (g)", "Oligossacáridos (g)", "Fibra alimentar (g)", "Ácidos gordos saturados (g)", "Ácidos gordos monoinsaturados (g)", "Ácidos gordos polinsaturados  (g)", "Ácidos gordos trans (g)", "Ácido linoleico (g)", "Colesterol (mg)", "Retinol (vit. A total) (mg)", "Vit A total (equivalentes retinol) (mg)", "Caroteno (mg)", "vit. D (µg)", "a-tocoferol (mg)", "Tiamina (mg)", "Riboflavina (mg)", "Equivalentes de niacina (mg)", "Niacina (mg)", "Triptofano/60(mg)", "vit B6 (mg)", "Vit. B12 (µg)", "vit. C (mg)", "Folatos (µg)", "Cinza (g)", "Na (mg)", "K    (mg)", "Ca (mg)", "P (mg)", "Mg (mg)", "Fe (mg)", "Zn (mg)"});
        assertThrows(NullExcepcao.class, () -> c.addElemento(new String[]{"IS019", "Leite Cabra cru", "2", "290", "86,9", "3,8", "4", "4,6", "4,8", "4,6", "0", "0", "0", "0", "0", "2,6", "1,1", "0,1", "0,1", "0,1", null, "0,053", "53", "0", "0,05", "0,03", "0,05", "0,1", "1", "0,3", "0,7", "0,04", "0,08", "3", "1", "0,85", "40", "181", "153", "120", "20", "0,2", "0,3"}));
    }

    @Test
    public void testRetinolvitAtotalmgNaoAceitarNulos() {
        ColecaoAlimentos c = new ColecaoAlimentos();
        c.addHeaderTabela(new String[]{"Código", "PRODUTO", "Energia (kcal)", "Energia (kJ)", "Água (g)", "Proteína (g)", "Gordura total (g)", "Total HC disponíveis (g)", "Total HC expresso em monossacáridos (g)", "Mono + dissacáridos (g)", "Ácidos orgânicos (g)", "Álcool (g)", "Amido (g)", "Oligossacáridos (g)", "Fibra alimentar (g)", "Ácidos gordos saturados (g)", "Ácidos gordos monoinsaturados (g)", "Ácidos gordos polinsaturados  (g)", "Ácidos gordos trans (g)", "Ácido linoleico (g)", "Colesterol (mg)", "Retinol (vit. A total) (mg)", "Vit A total (equivalentes retinol) (mg)", "Caroteno (mg)", "vit. D (µg)", "a-tocoferol (mg)", "Tiamina (mg)", "Riboflavina (mg)", "Equivalentes de niacina (mg)", "Niacina (mg)", "Triptofano/60(mg)", "vit B6 (mg)", "Vit. B12 (µg)", "vit. C (mg)", "Folatos (µg)", "Cinza (g)", "Na (mg)", "K    (mg)", "Ca (mg)", "P (mg)", "Mg (mg)", "Fe (mg)", "Zn (mg)"});
        assertThrows(NullExcepcao.class, () -> c.addElemento(new String[]{"IS019", "Leite Cabra cru", "2", "290", "86,9", "3,8", "4", "4,6", "4,8", "4,6", "0", "0", "0", "0", "0", "2,6", "1,1", "0,1", "0,1", "0,1", "11", null, "53", "0", "0,05", "0,03", "0,05", "0,1", "1", "0,3", "0,7", "0,04", "0,08", "3", "1", "0,85", "40", "181", "153", "120", "20", "0,2", "0,3"}));
    }

    @Test
    public void testVitAtotalequivalentesretinolmgNaoAceitarNulos() {
        ColecaoAlimentos c = new ColecaoAlimentos();
        c.addHeaderTabela(new String[]{"Código", "PRODUTO", "Energia (kcal)", "Energia (kJ)", "Água (g)", "Proteína (g)", "Gordura total (g)", "Total HC disponíveis (g)", "Total HC expresso em monossacáridos (g)", "Mono + dissacáridos (g)", "Ácidos orgânicos (g)", "Álcool (g)", "Amido (g)", "Oligossacáridos (g)", "Fibra alimentar (g)", "Ácidos gordos saturados (g)", "Ácidos gordos monoinsaturados (g)", "Ácidos gordos polinsaturados  (g)", "Ácidos gordos trans (g)", "Ácido linoleico (g)", "Colesterol (mg)", "Retinol (vit. A total) (mg)", "Vit A total (equivalentes retinol) (mg)", "Caroteno (mg)", "vit. D (µg)", "a-tocoferol (mg)", "Tiamina (mg)", "Riboflavina (mg)", "Equivalentes de niacina (mg)", "Niacina (mg)", "Triptofano/60(mg)", "vit B6 (mg)", "Vit. B12 (µg)", "vit. C (mg)", "Folatos (µg)", "Cinza (g)", "Na (mg)", "K    (mg)", "Ca (mg)", "P (mg)", "Mg (mg)", "Fe (mg)", "Zn (mg)"});
        assertThrows(NullExcepcao.class, () -> c.addElemento(new String[]{"IS019", "Leite Cabra cru", "2", "290", "86,9", "3,8", "4", "4,6", "4,8", "4,6", "0", "0", "0", "0", "0", "2,6", "1,1", "0,1", "0,1", "0,1", "11", "0,053", null, "0", "0,05", "0,03", "0,05", "0,1", "1", "0,3", "0,7", "0,04", "0,08", "3", "1", "0,85", "40", "181", "153", "120", "20", "0,2", "0,3"}));
    }

    @Test
    public void testCarotenomgNaoAceitarNulos() {
        ColecaoAlimentos c = new ColecaoAlimentos();
        c.addHeaderTabela(new String[]{"Código", "PRODUTO", "Energia (kcal)", "Energia (kJ)", "Água (g)", "Proteína (g)", "Gordura total (g)", "Total HC disponíveis (g)", "Total HC expresso em monossacáridos (g)", "Mono + dissacáridos (g)", "Ácidos orgânicos (g)", "Álcool (g)", "Amido (g)", "Oligossacáridos (g)", "Fibra alimentar (g)", "Ácidos gordos saturados (g)", "Ácidos gordos monoinsaturados (g)", "Ácidos gordos polinsaturados  (g)", "Ácidos gordos trans (g)", "Ácido linoleico (g)", "Colesterol (mg)", "Retinol (vit. A total) (mg)", "Vit A total (equivalentes retinol) (mg)", "Caroteno (mg)", "vit. D (µg)", "a-tocoferol (mg)", "Tiamina (mg)", "Riboflavina (mg)", "Equivalentes de niacina (mg)", "Niacina (mg)", "Triptofano/60(mg)", "vit B6 (mg)", "Vit. B12 (µg)", "vit. C (mg)", "Folatos (µg)", "Cinza (g)", "Na (mg)", "K    (mg)", "Ca (mg)", "P (mg)", "Mg (mg)", "Fe (mg)", "Zn (mg)"});
        assertThrows(NullExcepcao.class, () -> c.addElemento(new String[]{"IS019", "Leite Cabra cru", "2", "290", "86,9", "3,8", "4", "4,6", "4,8", "4,6", "0", "0", "0", "0", "0", "2,6", "1,1", "0,1", "0,1", "0,1", "11", "0,053", "53", null, "0,05", "0,03", "0,05", "0,1", "1", "0,3", "0,7", "0,04", "0,08", "3", "1", "0,85", "40", "181", "153", "120", "20", "0,2", "0,3"}));
    }

    @Test
    public void testvitDµgNaoAceitarNulos() {
        ColecaoAlimentos c = new ColecaoAlimentos();
        c.addHeaderTabela(new String[]{"Código", "PRODUTO", "Energia (kcal)", "Energia (kJ)", "Água (g)", "Proteína (g)", "Gordura total (g)", "Total HC disponíveis (g)", "Total HC expresso em monossacáridos (g)", "Mono + dissacáridos (g)", "Ácidos orgânicos (g)", "Álcool (g)", "Amido (g)", "Oligossacáridos (g)", "Fibra alimentar (g)", "Ácidos gordos saturados (g)", "Ácidos gordos monoinsaturados (g)", "Ácidos gordos polinsaturados  (g)", "Ácidos gordos trans (g)", "Ácido linoleico (g)", "Colesterol (mg)", "Retinol (vit. A total) (mg)", "Vit A total (equivalentes retinol) (mg)", "Caroteno (mg)", "vit. D (µg)", "a-tocoferol (mg)", "Tiamina (mg)", "Riboflavina (mg)", "Equivalentes de niacina (mg)", "Niacina (mg)", "Triptofano/60(mg)", "vit B6 (mg)", "Vit. B12 (µg)", "vit. C (mg)", "Folatos (µg)", "Cinza (g)", "Na (mg)", "K    (mg)", "Ca (mg)", "P (mg)", "Mg (mg)", "Fe (mg)", "Zn (mg)"});
        assertThrows(NullExcepcao.class, () -> c.addElemento(new String[]{"IS019", "Leite Cabra cru", "2", "290", "86,9", "3,8", "4", "4,6", "4,8", "4,6", "0", "0", "0", "0", "0", "2,6", "1,1", "0,1", "0,1", "0,1", "11", "0,053", "53", "0", null, "0,03", "0,05", "0,1", "1", "0,3", "0,7", "0,04", "0,08", "3", "1", "0,85", "40", "181", "153", "120", "20", "0,2", "0,3"}));
    }

    @Test
    public void testatocoferolmgNaoAceitarNulos() {
        ColecaoAlimentos c = new ColecaoAlimentos();
        c.addHeaderTabela(new String[]{"Código", "PRODUTO", "Energia (kcal)", "Energia (kJ)", "Água (g)", "Proteína (g)", "Gordura total (g)", "Total HC disponíveis (g)", "Total HC expresso em monossacáridos (g)", "Mono + dissacáridos (g)", "Ácidos orgânicos (g)", "Álcool (g)", "Amido (g)", "Oligossacáridos (g)", "Fibra alimentar (g)", "Ácidos gordos saturados (g)", "Ácidos gordos monoinsaturados (g)", "Ácidos gordos polinsaturados  (g)", "Ácidos gordos trans (g)", "Ácido linoleico (g)", "Colesterol (mg)", "Retinol (vit. A total) (mg)", "Vit A total (equivalentes retinol) (mg)", "Caroteno (mg)", "vit. D (µg)", "a-tocoferol (mg)", "Tiamina (mg)", "Riboflavina (mg)", "Equivalentes de niacina (mg)", "Niacina (mg)", "Triptofano/60(mg)", "vit B6 (mg)", "Vit. B12 (µg)", "vit. C (mg)", "Folatos (µg)", "Cinza (g)", "Na (mg)", "K    (mg)", "Ca (mg)", "P (mg)", "Mg (mg)", "Fe (mg)", "Zn (mg)"});
        assertThrows(NullExcepcao.class, () -> c.addElemento(new String[]{"IS019", "Leite Cabra cru", "2", "290", "86,9", "3,8", "4", "4,6", "4,8", "4,6", "0", "0", "0", "0", "0", "2,6", "1,1", "0,1", "0,1", "0,1", "11", "0,053", "53", "0", "0,05", null, "0,05", "0,1", "1", "0,3", "0,7", "0,04", "0,08", "3", "1", "0,85", "40", "181", "153", "120", "20", "0,2", "0,3"}));
    }

    @Test
    public void testTiaminamgNaoAceitarNulos() {
        ColecaoAlimentos c = new ColecaoAlimentos();
        c.addHeaderTabela(new String[]{"Código", "PRODUTO", "Energia (kcal)", "Energia (kJ)", "Água (g)", "Proteína (g)", "Gordura total (g)", "Total HC disponíveis (g)", "Total HC expresso em monossacáridos (g)", "Mono + dissacáridos (g)", "Ácidos orgânicos (g)", "Álcool (g)", "Amido (g)", "Oligossacáridos (g)", "Fibra alimentar (g)", "Ácidos gordos saturados (g)", "Ácidos gordos monoinsaturados (g)", "Ácidos gordos polinsaturados  (g)", "Ácidos gordos trans (g)", "Ácido linoleico (g)", "Colesterol (mg)", "Retinol (vit. A total) (mg)", "Vit A total (equivalentes retinol) (mg)", "Caroteno (mg)", "vit. D (µg)", "a-tocoferol (mg)", "Tiamina (mg)", "Riboflavina (mg)", "Equivalentes de niacina (mg)", "Niacina (mg)", "Triptofano/60(mg)", "vit B6 (mg)", "Vit. B12 (µg)", "vit. C (mg)", "Folatos (µg)", "Cinza (g)", "Na (mg)", "K    (mg)", "Ca (mg)", "P (mg)", "Mg (mg)", "Fe (mg)", "Zn (mg)"});
        assertThrows(NullExcepcao.class, () -> c.addElemento(new String[]{"IS019", "Leite Cabra cru", "2", "290", "86,9", "3,8", "4", "4,6", "4,8", "4,6", "0", "0", "0", "0", "0", "2,6", "1,1", "0,1", "0,1", "0,1", "11", "0,053", "53", "0", "0,05", "0,03", null, "0,1", "1", "0,3", "0,7", "0,04", "0,08", "3", "1", "0,85", "40", "181", "153", "120", "20", "0,2", "0,3"}));
    }

    @Test
    public void testRiboflavinamgNaoAceitarNulos() {
        ColecaoAlimentos c = new ColecaoAlimentos();
        c.addHeaderTabela(new String[]{"Código", "PRODUTO", "Energia (kcal)", "Energia (kJ)", "Água (g)", "Proteína (g)", "Gordura total (g)", "Total HC disponíveis (g)", "Total HC expresso em monossacáridos (g)", "Mono + dissacáridos (g)", "Ácidos orgânicos (g)", "Álcool (g)", "Amido (g)", "Oligossacáridos (g)", "Fibra alimentar (g)", "Ácidos gordos saturados (g)", "Ácidos gordos monoinsaturados (g)", "Ácidos gordos polinsaturados  (g)", "Ácidos gordos trans (g)", "Ácido linoleico (g)", "Colesterol (mg)", "Retinol (vit. A total) (mg)", "Vit A total (equivalentes retinol) (mg)", "Caroteno (mg)", "vit. D (µg)", "a-tocoferol (mg)", "Tiamina (mg)", "Riboflavina (mg)", "Equivalentes de niacina (mg)", "Niacina (mg)", "Triptofano/60(mg)", "vit B6 (mg)", "Vit. B12 (µg)", "vit. C (mg)", "Folatos (µg)", "Cinza (g)", "Na (mg)", "K    (mg)", "Ca (mg)", "P (mg)", "Mg (mg)", "Fe (mg)", "Zn (mg)"});
        assertThrows(NullExcepcao.class, () -> c.addElemento(new String[]{"IS019", "Leite Cabra cru", "2", "290", "86,9", "3,8", "4", "4,6", "4,8", "4,6", "0", "0", "0", "0", "0", "2,6", "1,1", "0,1", "0,1", "0,1", "11", "0,053", "53", "0", "0,05", "0,03", "0,05", null, "1", "0,3", "0,7", "0,04", "0,08", "3", "1", "0,85", "40", "181", "153", "120", "20", "0,2", "0,3"}));
    }

    @Test
    public void testEquivalentesdeniacinamgNaoAceitarNulos() {
        ColecaoAlimentos c = new ColecaoAlimentos();
        c.addHeaderTabela(new String[]{"Código", "PRODUTO", "Energia (kcal)", "Energia (kJ)", "Água (g)", "Proteína (g)", "Gordura total (g)", "Total HC disponíveis (g)", "Total HC expresso em monossacáridos (g)", "Mono + dissacáridos (g)", "Ácidos orgânicos (g)", "Álcool (g)", "Amido (g)", "Oligossacáridos (g)", "Fibra alimentar (g)", "Ácidos gordos saturados (g)", "Ácidos gordos monoinsaturados (g)", "Ácidos gordos polinsaturados  (g)", "Ácidos gordos trans (g)", "Ácido linoleico (g)", "Colesterol (mg)", "Retinol (vit. A total) (mg)", "Vit A total (equivalentes retinol) (mg)", "Caroteno (mg)", "vit. D (µg)", "a-tocoferol (mg)", "Tiamina (mg)", "Riboflavina (mg)", "Equivalentes de niacina (mg)", "Niacina (mg)", "Triptofano/60(mg)", "vit B6 (mg)", "Vit. B12 (µg)", "vit. C (mg)", "Folatos (µg)", "Cinza (g)", "Na (mg)", "K    (mg)", "Ca (mg)", "P (mg)", "Mg (mg)", "Fe (mg)", "Zn (mg)"});
        assertThrows(NullExcepcao.class, () -> c.addElemento(new String[]{"IS019", "Leite Cabra cru", "2", "290", "86,9", "3,8", "4", "4,6", "4,8", "4,6", "0", "0", "0", "0", "0", "2,6", "1,1", "0,1", "0,1", "0,1", "11", "0,053", "53", "0", "0,05", "0,03", "0,05", "0,1", null, "0,3", "0,7", "0,04", "0,08", "3", "1", "0,85", "40", "181", "153", "120", "20", "0,2", "0,3"}));
    }

    @Test
    public void testNiacinamgNaoAceitarNulos() {
        ColecaoAlimentos c = new ColecaoAlimentos();
        c.addHeaderTabela(new String[]{"Código", "PRODUTO", "Energia (kcal)", "Energia (kJ)", "Água (g)", "Proteína (g)", "Gordura total (g)", "Total HC disponíveis (g)", "Total HC expresso em monossacáridos (g)", "Mono + dissacáridos (g)", "Ácidos orgânicos (g)", "Álcool (g)", "Amido (g)", "Oligossacáridos (g)", "Fibra alimentar (g)", "Ácidos gordos saturados (g)", "Ácidos gordos monoinsaturados (g)", "Ácidos gordos polinsaturados  (g)", "Ácidos gordos trans (g)", "Ácido linoleico (g)", "Colesterol (mg)", "Retinol (vit. A total) (mg)", "Vit A total (equivalentes retinol) (mg)", "Caroteno (mg)", "vit. D (µg)", "a-tocoferol (mg)", "Tiamina (mg)", "Riboflavina (mg)", "Equivalentes de niacina (mg)", "Niacina (mg)", "Triptofano/60(mg)", "vit B6 (mg)", "Vit. B12 (µg)", "vit. C (mg)", "Folatos (µg)", "Cinza (g)", "Na (mg)", "K    (mg)", "Ca (mg)", "P (mg)", "Mg (mg)", "Fe (mg)", "Zn (mg)"});
        assertThrows(NullExcepcao.class, () -> c.addElemento(new String[]{"IS019", "Leite Cabra cru", "2", "290", "86,9", "3,8", "4", "4,6", "4,8", "4,6", "0", "0", "0", "0", "0", "2,6", "1,1", "0,1", "0,1", "0,1", "11", "0,053", "53", "0", "0,05", "0,03", "0,05", "0,1", "1", null, "0,7", "0,04", "0,08", "3", "1", "0,85", "40", "181", "153", "120", "20", "0,2", "0,3"}));
    }

    @Test
    public void testTriptofanoNaoAceitarNulos() {
        ColecaoAlimentos c = new ColecaoAlimentos();
        c.addHeaderTabela(new String[]{"Código", "PRODUTO", "Energia (kcal)", "Energia (kJ)", "Água (g)", "Proteína (g)", "Gordura total (g)", "Total HC disponíveis (g)", "Total HC expresso em monossacáridos (g)", "Mono + dissacáridos (g)", "Ácidos orgânicos (g)", "Álcool (g)", "Amido (g)", "Oligossacáridos (g)", "Fibra alimentar (g)", "Ácidos gordos saturados (g)", "Ácidos gordos monoinsaturados (g)", "Ácidos gordos polinsaturados  (g)", "Ácidos gordos trans (g)", "Ácido linoleico (g)", "Colesterol (mg)", "Retinol (vit. A total) (mg)", "Vit A total (equivalentes retinol) (mg)", "Caroteno (mg)", "vit. D (µg)", "a-tocoferol (mg)", "Tiamina (mg)", "Riboflavina (mg)", "Equivalentes de niacina (mg)", "Niacina (mg)", "Triptofano/60(mg)", "vit B6 (mg)", "Vit. B12 (µg)", "vit. C (mg)", "Folatos (µg)", "Cinza (g)", "Na (mg)", "K    (mg)", "Ca (mg)", "P (mg)", "Mg (mg)", "Fe (mg)", "Zn (mg)"});
        assertThrows(NullExcepcao.class, () -> c.addElemento(new String[]{"IS019", "Leite Cabra cru", "2", "290", "86,9", "3,8", "4", "4,6", "4,8", "4,6", "0", "0", "0", "0", "0", "2,6", "1,1", "0,1", "0,1", "0,1", "11", "0,053", "53", "0", "0,05", "0,03", "0,05", "0,1", "1", "0,3", null, "0,04", "0,08", "3", "1", "0,85", "40", "181", "153", "120", "20", "0,2", "0,3"}));
    }

    @Test
    public void testvitB6mgNaoAceitarNulos() {
        ColecaoAlimentos c = new ColecaoAlimentos();
        c.addHeaderTabela(new String[]{"Código", "PRODUTO", "Energia (kcal)", "Energia (kJ)", "Água (g)", "Proteína (g)", "Gordura total (g)", "Total HC disponíveis (g)", "Total HC expresso em monossacáridos (g)", "Mono + dissacáridos (g)", "Ácidos orgânicos (g)", "Álcool (g)", "Amido (g)", "Oligossacáridos (g)", "Fibra alimentar (g)", "Ácidos gordos saturados (g)", "Ácidos gordos monoinsaturados (g)", "Ácidos gordos polinsaturados  (g)", "Ácidos gordos trans (g)", "Ácido linoleico (g)", "Colesterol (mg)", "Retinol (vit. A total) (mg)", "Vit A total (equivalentes retinol) (mg)", "Caroteno (mg)", "vit. D (µg)", "a-tocoferol (mg)", "Tiamina (mg)", "Riboflavina (mg)", "Equivalentes de niacina (mg)", "Niacina (mg)", "Triptofano/60(mg)", "vit B6 (mg)", "Vit. B12 (µg)", "vit. C (mg)", "Folatos (µg)", "Cinza (g)", "Na (mg)", "K    (mg)", "Ca (mg)", "P (mg)", "Mg (mg)", "Fe (mg)", "Zn (mg)"});
        assertThrows(NullExcepcao.class, () -> c.addElemento(new String[]{"IS019", "Leite Cabra cru", "2", "290", "86,9", "3,8", "4", "4,6", "4,8", "4,6", "0", "0", "0", "0", "0", "2,6", "1,1", "0,1", "0,1", "0,1", "11", "0,053", "53", "0", "0,05", "0,03", "0,05", "0,1", "1", "0,3", "0,7", null, "0,08", "3", "1", "0,85", "40", "181", "153", "120", "20", "0,2", "0,3"}));
    }

    @Test
    public void testVitB12µgNaoAceitarNulos() {
        ColecaoAlimentos c = new ColecaoAlimentos();
        c.addHeaderTabela(new String[]{"Código", "PRODUTO", "Energia (kcal)", "Energia (kJ)", "Água (g)", "Proteína (g)", "Gordura total (g)", "Total HC disponíveis (g)", "Total HC expresso em monossacáridos (g)", "Mono + dissacáridos (g)", "Ácidos orgânicos (g)", "Álcool (g)", "Amido (g)", "Oligossacáridos (g)", "Fibra alimentar (g)", "Ácidos gordos saturados (g)", "Ácidos gordos monoinsaturados (g)", "Ácidos gordos polinsaturados  (g)", "Ácidos gordos trans (g)", "Ácido linoleico (g)", "Colesterol (mg)", "Retinol (vit. A total) (mg)", "Vit A total (equivalentes retinol) (mg)", "Caroteno (mg)", "vit. D (µg)", "a-tocoferol (mg)", "Tiamina (mg)", "Riboflavina (mg)", "Equivalentes de niacina (mg)", "Niacina (mg)", "Triptofano/60(mg)", "vit B6 (mg)", "Vit. B12 (µg)", "vit. C (mg)", "Folatos (µg)", "Cinza (g)", "Na (mg)", "K    (mg)", "Ca (mg)", "P (mg)", "Mg (mg)", "Fe (mg)", "Zn (mg)"});
        assertThrows(NullExcepcao.class, () -> c.addElemento(new String[]{"IS019", "Leite Cabra cru", "2", "290", "86,9", "3,8", "4", "4,6", "4,8", "4,6", "0", "0", "0", "0", "0", "2,6", "1,1", "0,1", "0,1", "0,1", "11", "0,053", "53", "0", "0,05", "0,03", "0,05", "0,1", "1", "0,3", "0,7", "0,04", null, "3", "1", "0,85", "40", "181", "153", "120", "20", "0,2", "0,3"}));
    }

    @Test
    public void testvitCmgNaoAceitarNulos() {
        ColecaoAlimentos c = new ColecaoAlimentos();
        c.addHeaderTabela(new String[]{"Código", "PRODUTO", "Energia (kcal)", "Energia (kJ)", "Água (g)", "Proteína (g)", "Gordura total (g)", "Total HC disponíveis (g)", "Total HC expresso em monossacáridos (g)", "Mono + dissacáridos (g)", "Ácidos orgânicos (g)", "Álcool (g)", "Amido (g)", "Oligossacáridos (g)", "Fibra alimentar (g)", "Ácidos gordos saturados (g)", "Ácidos gordos monoinsaturados (g)", "Ácidos gordos polinsaturados  (g)", "Ácidos gordos trans (g)", "Ácido linoleico (g)", "Colesterol (mg)", "Retinol (vit. A total) (mg)", "Vit A total (equivalentes retinol) (mg)", "Caroteno (mg)", "vit. D (µg)", "a-tocoferol (mg)", "Tiamina (mg)", "Riboflavina (mg)", "Equivalentes de niacina (mg)", "Niacina (mg)", "Triptofano/60(mg)", "vit B6 (mg)", "Vit. B12 (µg)", "vit. C (mg)", "Folatos (µg)", "Cinza (g)", "Na (mg)", "K    (mg)", "Ca (mg)", "P (mg)", "Mg (mg)", "Fe (mg)", "Zn (mg)"});
        assertThrows(NullExcepcao.class, () -> c.addElemento(new String[]{"IS019", "Leite Cabra cru", "2", "290", "86,9", "3,8", "4", "4,6", "4,8", "4,6", "0", "0", "0", "0", "0", "2,6", "1,1", "0,1", "0,1", "0,1", "11", "0,053", "53", "0", "0,05", "0,03", "0,05", "0,1", "1", "0,3", "0,7", "0,04", "0,08", null, "1", "0,85", "40", "181", "153", "120", "20", "0,2", "0,3"}));
    }

    @Test
    public void testFolatosµgNaoAceitarNulos() {
        ColecaoAlimentos c = new ColecaoAlimentos();
        c.addHeaderTabela(new String[]{"Código", "PRODUTO", "Energia (kcal)", "Energia (kJ)", "Água (g)", "Proteína (g)", "Gordura total (g)", "Total HC disponíveis (g)", "Total HC expresso em monossacáridos (g)", "Mono + dissacáridos (g)", "Ácidos orgânicos (g)", "Álcool (g)", "Amido (g)", "Oligossacáridos (g)", "Fibra alimentar (g)", "Ácidos gordos saturados (g)", "Ácidos gordos monoinsaturados (g)", "Ácidos gordos polinsaturados  (g)", "Ácidos gordos trans (g)", "Ácido linoleico (g)", "Colesterol (mg)", "Retinol (vit. A total) (mg)", "Vit A total (equivalentes retinol) (mg)", "Caroteno (mg)", "vit. D (µg)", "a-tocoferol (mg)", "Tiamina (mg)", "Riboflavina (mg)", "Equivalentes de niacina (mg)", "Niacina (mg)", "Triptofano/60(mg)", "vit B6 (mg)", "Vit. B12 (µg)", "vit. C (mg)", "Folatos (µg)", "Cinza (g)", "Na (mg)", "K    (mg)", "Ca (mg)", "P (mg)", "Mg (mg)", "Fe (mg)", "Zn (mg)"});
        assertThrows(NullExcepcao.class, () -> c.addElemento(new String[]{"IS019", "Leite Cabra cru", "2", "290", "86,9", "3,8", "4", "4,6", "4,8", "4,6", "0", "0", "0", "0", "0", "2,6", "1,1", "0,1", "0,1", "0,1", "11", "0,053", "53", "0", "0,05", "0,03", "0,05", "0,1", "1", "0,3", "0,7", "0,04", "0,08", "3", null, "0,85", "40", "181", "153", "120", "20", "0,2", "0,3"}));
    }

    @Test
    public void testCinzagNaoAceitarNulos() {
        ColecaoAlimentos c = new ColecaoAlimentos();
        c.addHeaderTabela(new String[]{"Código", "PRODUTO", "Energia (kcal)", "Energia (kJ)", "Água (g)", "Proteína (g)", "Gordura total (g)", "Total HC disponíveis (g)", "Total HC expresso em monossacáridos (g)", "Mono + dissacáridos (g)", "Ácidos orgânicos (g)", "Álcool (g)", "Amido (g)", "Oligossacáridos (g)", "Fibra alimentar (g)", "Ácidos gordos saturados (g)", "Ácidos gordos monoinsaturados (g)", "Ácidos gordos polinsaturados  (g)", "Ácidos gordos trans (g)", "Ácido linoleico (g)", "Colesterol (mg)", "Retinol (vit. A total) (mg)", "Vit A total (equivalentes retinol) (mg)", "Caroteno (mg)", "vit. D (µg)", "a-tocoferol (mg)", "Tiamina (mg)", "Riboflavina (mg)", "Equivalentes de niacina (mg)", "Niacina (mg)", "Triptofano/60(mg)", "vit B6 (mg)", "Vit. B12 (µg)", "vit. C (mg)", "Folatos (µg)", "Cinza (g)", "Na (mg)", "K    (mg)", "Ca (mg)", "P (mg)", "Mg (mg)", "Fe (mg)", "Zn (mg)"});
        assertThrows(NullExcepcao.class, () -> c.addElemento(new String[]{"IS019", "Leite Cabra cru", "2", "290", "86,9", "3,8", "4", "4,6", "4,8", "4,6", "0", "0", "0", "0", "0", "2,6", "1,1", "0,1", "0,1", "0,1", "11", "0,053", "53", "0", "0,05", "0,03", "0,05", "0,1", "1", "0,3", "0,7", "0,04", "0,08", "3", "1", null, "40", "181", "153", "120", "20", "0,2", "0,3"}));
    }

    @Test
    public void testNamgNaoAceitarNulos() {
        ColecaoAlimentos c = new ColecaoAlimentos();
        c.addHeaderTabela(new String[]{"Código", "PRODUTO", "Energia (kcal)", "Energia (kJ)", "Água (g)", "Proteína (g)", "Gordura total (g)", "Total HC disponíveis (g)", "Total HC expresso em monossacáridos (g)", "Mono + dissacáridos (g)", "Ácidos orgânicos (g)", "Álcool (g)", "Amido (g)", "Oligossacáridos (g)", "Fibra alimentar (g)", "Ácidos gordos saturados (g)", "Ácidos gordos monoinsaturados (g)", "Ácidos gordos polinsaturados  (g)", "Ácidos gordos trans (g)", "Ácido linoleico (g)", "Colesterol (mg)", "Retinol (vit. A total) (mg)", "Vit A total (equivalentes retinol) (mg)", "Caroteno (mg)", "vit. D (µg)", "a-tocoferol (mg)", "Tiamina (mg)", "Riboflavina (mg)", "Equivalentes de niacina (mg)", "Niacina (mg)", "Triptofano/60(mg)", "vit B6 (mg)", "Vit. B12 (µg)", "vit. C (mg)", "Folatos (µg)", "Cinza (g)", "Na (mg)", "K    (mg)", "Ca (mg)", "P (mg)", "Mg (mg)", "Fe (mg)", "Zn (mg)"});
        assertThrows(NullExcepcao.class, () -> c.addElemento(new String[]{"IS019", "Leite Cabra cru", "2", "290", "86,9", "3,8", "4", "4,6", "4,8", "4,6", "0", "0", "0", "0", "0", "2,6", "1,1", "0,1", "0,1", "0,1", "11", "0,053", "53", "0", "0,05", "0,03", "0,05", "0,1", "1", "0,3", "0,7", "0,04", "0,08", "3", "1", "0,85", null, "181", "153", "120", "20", "0,2", "0,3"}));
    }

    @Test
    public void testKmgNaoAceitarNulos() {
        ColecaoAlimentos c = new ColecaoAlimentos();
        c.addHeaderTabela(new String[]{"Código", "PRODUTO", "Energia (kcal)", "Energia (kJ)", "Água (g)", "Proteína (g)", "Gordura total (g)", "Total HC disponíveis (g)", "Total HC expresso em monossacáridos (g)", "Mono + dissacáridos (g)", "Ácidos orgânicos (g)", "Álcool (g)", "Amido (g)", "Oligossacáridos (g)", "Fibra alimentar (g)", "Ácidos gordos saturados (g)", "Ácidos gordos monoinsaturados (g)", "Ácidos gordos polinsaturados  (g)", "Ácidos gordos trans (g)", "Ácido linoleico (g)", "Colesterol (mg)", "Retinol (vit. A total) (mg)", "Vit A total (equivalentes retinol) (mg)", "Caroteno (mg)", "vit. D (µg)", "a-tocoferol (mg)", "Tiamina (mg)", "Riboflavina (mg)", "Equivalentes de niacina (mg)", "Niacina (mg)", "Triptofano/60(mg)", "vit B6 (mg)", "Vit. B12 (µg)", "vit. C (mg)", "Folatos (µg)", "Cinza (g)", "Na (mg)", "K    (mg)", "Ca (mg)", "P (mg)", "Mg (mg)", "Fe (mg)", "Zn (mg)"});
        assertThrows(NullExcepcao.class, () -> c.addElemento(new String[]{"IS019", "Leite Cabra cru", "2", "290", "86,9", "3,8", "4", "4,6", "4,8", "4,6", "0", "0", "0", "0", "0", "2,6", "1,1", "0,1", "0,1", "0,1", "11", "0,053", "53", "0", "0,05", "0,03", "0,05", "0,1", "1", "0,3", "0,7", "0,04", "0,08", "3", "1", "0,85", "40", null, "153", "120", "20", "0,2", "0,3"}));
    }

    @Test
    public void testCamgNaoAceitarNulos() {
        ColecaoAlimentos c = new ColecaoAlimentos();
        c.addHeaderTabela(new String[]{"Código", "PRODUTO", "Energia (kcal)", "Energia (kJ)", "Água (g)", "Proteína (g)", "Gordura total (g)", "Total HC disponíveis (g)", "Total HC expresso em monossacáridos (g)", "Mono + dissacáridos (g)", "Ácidos orgânicos (g)", "Álcool (g)", "Amido (g)", "Oligossacáridos (g)", "Fibra alimentar (g)", "Ácidos gordos saturados (g)", "Ácidos gordos monoinsaturados (g)", "Ácidos gordos polinsaturados  (g)", "Ácidos gordos trans (g)", "Ácido linoleico (g)", "Colesterol (mg)", "Retinol (vit. A total) (mg)", "Vit A total (equivalentes retinol) (mg)", "Caroteno (mg)", "vit. D (µg)", "a-tocoferol (mg)", "Tiamina (mg)", "Riboflavina (mg)", "Equivalentes de niacina (mg)", "Niacina (mg)", "Triptofano/60(mg)", "vit B6 (mg)", "Vit. B12 (µg)", "vit. C (mg)", "Folatos (µg)", "Cinza (g)", "Na (mg)", "K    (mg)", "Ca (mg)", "P (mg)", "Mg (mg)", "Fe (mg)", "Zn (mg)"});
        assertThrows(NullExcepcao.class, () -> c.addElemento(new String[]{"IS019", "Leite Cabra cru", "2", "290", "86,9", "3,8", "4", "4,6", "4,8", "4,6", "0", "0", "0", "0", "0", "2,6", "1,1", "0,1", "0,1", "0,1", "11", "0,053", "53", "0", "0,05", "0,03", "0,05", "0,1", "1", "0,3", "0,7", "0,04", "0,08", "3", "1", "0,85", "40", "181", null, "120", "20", "0,2", "0,3"}));
    }

    @Test
    public void testPmgNaoAceitarNulos() {
        ColecaoAlimentos c = new ColecaoAlimentos();
        c.addHeaderTabela(new String[]{"Código", "PRODUTO", "Energia (kcal)", "Energia (kJ)", "Água (g)", "Proteína (g)", "Gordura total (g)", "Total HC disponíveis (g)", "Total HC expresso em monossacáridos (g)", "Mono + dissacáridos (g)", "Ácidos orgânicos (g)", "Álcool (g)", "Amido (g)", "Oligossacáridos (g)", "Fibra alimentar (g)", "Ácidos gordos saturados (g)", "Ácidos gordos monoinsaturados (g)", "Ácidos gordos polinsaturados  (g)", "Ácidos gordos trans (g)", "Ácido linoleico (g)", "Colesterol (mg)", "Retinol (vit. A total) (mg)", "Vit A total (equivalentes retinol) (mg)", "Caroteno (mg)", "vit. D (µg)", "a-tocoferol (mg)", "Tiamina (mg)", "Riboflavina (mg)", "Equivalentes de niacina (mg)", "Niacina (mg)", "Triptofano/60(mg)", "vit B6 (mg)", "Vit. B12 (µg)", "vit. C (mg)", "Folatos (µg)", "Cinza (g)", "Na (mg)", "K    (mg)", "Ca (mg)", "P (mg)", "Mg (mg)", "Fe (mg)", "Zn (mg)"});
        assertThrows(NullExcepcao.class, () -> c.addElemento(new String[]{"IS019", "Leite Cabra cru", "2", "290", "86,9", "3,8", "4", "4,6", "4,8", "4,6", "0", "0", "0", "0", "0", "2,6", "1,1", "0,1", "0,1", "0,1", "11", "0,053", "53", "0", "0,05", "0,03", "0,05", "0,1", "1", "0,3", "0,7", "0,04", "0,08", "3", "1", "0,85", "40", "181", "153", null, "20", "0,2", "0,3"}));
    }

    @Test
    public void testMgmgNaoAceitarNulos() {
        ColecaoAlimentos c = new ColecaoAlimentos();
        c.addHeaderTabela(new String[]{"Código", "PRODUTO", "Energia (kcal)", "Energia (kJ)", "Água (g)", "Proteína (g)", "Gordura total (g)", "Total HC disponíveis (g)", "Total HC expresso em monossacáridos (g)", "Mono + dissacáridos (g)", "Ácidos orgânicos (g)", "Álcool (g)", "Amido (g)", "Oligossacáridos (g)", "Fibra alimentar (g)", "Ácidos gordos saturados (g)", "Ácidos gordos monoinsaturados (g)", "Ácidos gordos polinsaturados  (g)", "Ácidos gordos trans (g)", "Ácido linoleico (g)", "Colesterol (mg)", "Retinol (vit. A total) (mg)", "Vit A total (equivalentes retinol) (mg)", "Caroteno (mg)", "vit. D (µg)", "a-tocoferol (mg)", "Tiamina (mg)", "Riboflavina (mg)", "Equivalentes de niacina (mg)", "Niacina (mg)", "Triptofano/60(mg)", "vit B6 (mg)", "Vit. B12 (µg)", "vit. C (mg)", "Folatos (µg)", "Cinza (g)", "Na (mg)", "K    (mg)", "Ca (mg)", "P (mg)", "Mg (mg)", "Fe (mg)", "Zn (mg)"});
        assertThrows(NullExcepcao.class, () -> c.addElemento(new String[]{"IS019", "Leite Cabra cru", "2", "290", "86,9", "3,8", "4", "4,6", "4,8", "4,6", "0", "0", "0", "0", "0", "2,6", "1,1", "0,1", "0,1", "0,1", "11", "0,053", "53", "0", "0,05", "0,03", "0,05", "0,1", "1", "0,3", "0,7", "0,04", "0,08", "3", "1", "0,85", "40", "181", "153", "120", null, "0,2", "0,3"}));
    }

    @Test
    public void testFemgNaoAceitarNulos() {
        ColecaoAlimentos c = new ColecaoAlimentos();
        c.addHeaderTabela(new String[]{"Código", "PRODUTO", "Energia (kcal)", "Energia (kJ)", "Água (g)", "Proteína (g)", "Gordura total (g)", "Total HC disponíveis (g)", "Total HC expresso em monossacáridos (g)", "Mono + dissacáridos (g)", "Ácidos orgânicos (g)", "Álcool (g)", "Amido (g)", "Oligossacáridos (g)", "Fibra alimentar (g)", "Ácidos gordos saturados (g)", "Ácidos gordos monoinsaturados (g)", "Ácidos gordos polinsaturados  (g)", "Ácidos gordos trans (g)", "Ácido linoleico (g)", "Colesterol (mg)", "Retinol (vit. A total) (mg)", "Vit A total (equivalentes retinol) (mg)", "Caroteno (mg)", "vit. D (µg)", "a-tocoferol (mg)", "Tiamina (mg)", "Riboflavina (mg)", "Equivalentes de niacina (mg)", "Niacina (mg)", "Triptofano/60(mg)", "vit B6 (mg)", "Vit. B12 (µg)", "vit. C (mg)", "Folatos (µg)", "Cinza (g)", "Na (mg)", "K    (mg)", "Ca (mg)", "P (mg)", "Mg (mg)", "Fe (mg)", "Zn (mg)"});
        assertThrows(NullExcepcao.class, () -> c.addElemento(new String[]{"IS019", "Leite Cabra cru", "2", "290", "86,9", "3,8", "4", "4,6", "4,8", "4,6", "0", "0", "0", "0", "0", "2,6", "1,1", "0,1", "0,1", "0,1", "11", "0,053", "53", "0", "0,05", "0,03", "0,05", "0,1", "1", "0,3", "0,7", "0,04", "0,08", "3", "1", "0,85", "40", "181", "153", "120", "20", null, "0,3"}));
    }

    @Test
    public void testZnmgNaoAceitarNulos() {
        ColecaoAlimentos c = new ColecaoAlimentos();
        c.addHeaderTabela(new String[]{"Código", "PRODUTO", "Energia (kcal)", "Energia (kJ)", "Água (g)", "Proteína (g)", "Gordura total (g)", "Total HC disponíveis (g)", "Total HC expresso em monossacáridos (g)", "Mono + dissacáridos (g)", "Ácidos orgânicos (g)", "Álcool (g)", "Amido (g)", "Oligossacáridos (g)", "Fibra alimentar (g)", "Ácidos gordos saturados (g)", "Ácidos gordos monoinsaturados (g)", "Ácidos gordos polinsaturados  (g)", "Ácidos gordos trans (g)", "Ácido linoleico (g)", "Colesterol (mg)", "Retinol (vit. A total) (mg)", "Vit A total (equivalentes retinol) (mg)", "Caroteno (mg)", "vit. D (µg)", "a-tocoferol (mg)", "Tiamina (mg)", "Riboflavina (mg)", "Equivalentes de niacina (mg)", "Niacina (mg)", "Triptofano/60(mg)", "vit B6 (mg)", "Vit. B12 (µg)", "vit. C (mg)", "Folatos (µg)", "Cinza (g)", "Na (mg)", "K    (mg)", "Ca (mg)", "P (mg)", "Mg (mg)", "Fe (mg)", "Zn (mg)"});
        assertThrows(NullExcepcao.class, () -> c.addElemento(new String[]{"IS019", "Leite Cabra cru", "2", "290", "86,9", "3,8", "4", "4,6", "4,8", "4,6", "0", "0", "0", "0", "0", "2,6", "1,1", "0,1", "0,1", "0,1", "11", "0,053", "53", "0", "0,05", "0,03", "0,05", "0,1", "1", "0,3", "0,7", "0,04", "0,08", "3", "1", "0,85", "40", "181", "153", "120", "20", "0,2", null}));
    }

    @Test
    public void testLerCodigoNaoAceitarInvalido(){
        ColecaoAlimentos c = new ColecaoAlimentos();
        c.addHeaderTabela(new String[]{"Código", "PRODUTO", "Energia (kcal)", "Energia (kJ)", "Água (g)", "Proteína (g)", "Gordura total (g)", "Total HC disponíveis (g)", "Total HC expresso em monossacáridos (g)", "Mono + dissacáridos (g)", "Ácidos orgânicos (g)", "Álcool (g)", "Amido (g)", "Oligossacáridos (g)", "Fibra alimentar (g)", "Ácidos gordos saturados (g)", "Ácidos gordos monoinsaturados (g)", "Ácidos gordos polinsaturados  (g)", "Ácidos gordos trans (g)", "Ácido linoleico (g)", "Colesterol (mg)", "Retinol (vit. A total) (mg)", "Vit A total (equivalentes retinol) (mg)", "Caroteno (mg)", "vit. D (µg)", "a-tocoferol (mg)", "Tiamina (mg)", "Riboflavina (mg)", "Equivalentes de niacina (mg)", "Niacina (mg)", "Triptofano/60(mg)", "vit B6 (mg)", "Vit. B12 (µg)", "vit. C (mg)", "Folatos (µg)", "Cinza (g)", "Na (mg)", "K    (mg)", "Ca (mg)", "P (mg)", "Mg (mg)", "Fe (mg)", "Zn (mg)"});
        assertThrows(CodigoNaoValido.class, () -> c.addElemento(new String[]{"S019", "Leite Cabra cru", "2", "290", "86,9", "3,8", "4", "4,6", "4,8", "4,6", "0", "0", "0", "0", "0", "2,6", "1,1", "0,1", "0,1", "0,1", "11", "0,053", "53", "0", "0,05", "0,03", "0,05", "0,1", "1", "0,3", "0,7", "0,04", "0,08", "3", "1", "0,85", "40", "181", "153", "120", "20", "0,2", "0,3"}));
    }
    
}