package com.es2.Armazenamento;
import com.es2.Leitura.RawDataPaciente;

import javax.smartcardio.CardChannel;
import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;

public class Paciente {
    private String nome;
    private String idade;
    private Double alturaCm;
    private Double pesoKg;
    private String profissao;
    private String motivoConsulta;
    private String objectivos;
    private String patologias;
    private String medicacao;
    private String antecedentesFamiliares;
    private String actividadeFisica;
    private String funcaoIntestinal;
    private String consumoAgua;
    private Double imc;
    private Double gorduraCorporal;
    private Double gorduraVisceral;
    private Double musculo;
    private Double idadeMetabolica;
    private Double agua;
    private Double metabolismoBasal;
    private Double osso;
    private Double FA=null;
    private Double FL=null;
    private Double FT=null;

    DadosQuimicoseBiologicos qm = new DadosQuimicoseBiologicos();

    private void validarCampos(HashMap<String,String> hm) throws /*CaracteresIncorrectosExcepcao, */NumberFormatException,
            StringVaziaExcepcao, NullExcepcao, ForadeLimitesExcepcao, IllegalArgumentException, CaracteresIncorrectosExcepcao {

        int auxiliarparaValidarInteiros;
        Double auxiliarparaValidarDoubles;

        Iterator it = hm.entrySet().iterator();
        //Se descobrir um valor vazio, vai iterar para descobrir qual é. Assim, não vai iterar um HashMap em vão
        if(hm.containsValue("") == true)
        {
            while (it.hasNext()) {
                Map.Entry pair = (Map.Entry) it.next();
                if (pair.getValue() == "")
                    throw new StringVaziaExcepcao(pair.getKey().toString());
                it.remove();
            }
        }

        //Se descobrir um valor vazio, vai iterar para descobrir qual é. Assim, não vai iterar um HashMap em vão
        if(hm.containsValue(null) == true) {
            while (it.hasNext()) {
                Map.Entry pair = (Map.Entry) it.next();
                if (pair.getValue() == null)
                    throw new NullExcepcao(pair.getKey().toString());
                it.remove();
            }
        }

        /* Validar nome */

        if(!hm.get("Nome").matches("\\D*"))
                throw new CaracteresIncorrectosExcepcao("Nome");

        /* Validar idade */
        if(!hm.get("Idade").matches("^[0-9]*"))
                throw new CaracteresIncorrectosExcepcao("Idade");

        if(Integer.parseInt(hm.get("Idade")) < 0 || Integer.parseInt(hm.get("Idade")) > 120)
            throw new ForadeLimitesExcepcao();

        /* Validar altura */
        auxiliarparaValidarInteiros = Integer.parseInt(hm.get("Altura").replace(",","").replace(".",""));
        //caso não seja convertível, lanca uma excepcoao illegalargumentexception

        /* Peso */
        auxiliarparaValidarDoubles = Double.parseDouble(hm.get("Peso").replace(",","."));
        //caso não seja convertível, lanca uma excepcoao illegalargumentexception também

        /* Profissao */
        if(!hm.get("Profissão").matches("\\D*"))
            throw new CaracteresIncorrectosExcepcao("Profissão");

        auxiliarparaValidarDoubles = Double.parseDouble(hm.get("IMC").replace(",", "."));

        if(auxiliarparaValidarDoubles > 1500 || auxiliarparaValidarDoubles < 0)
            throw new ForadeLimitesExcepcao();

        auxiliarparaValidarDoubles = Double.parseDouble(hm.get("B.F.").replace(",", "."));

        if(auxiliarparaValidarDoubles > 1500 || auxiliarparaValidarDoubles < 0)
            throw new ForadeLimitesExcepcao();

        auxiliarparaValidarDoubles = Double.parseDouble(hm.get("Gordura Visceral").replace(",", "."));

        if(auxiliarparaValidarDoubles > 1500 || auxiliarparaValidarDoubles < 0)
            throw new ForadeLimitesExcepcao();

        auxiliarparaValidarDoubles = Double.parseDouble(hm.get("Musculo").replace(",", "."));

        if(auxiliarparaValidarDoubles > 1500 || auxiliarparaValidarDoubles < 0)
            throw new ForadeLimitesExcepcao();


        auxiliarparaValidarInteiros = Integer.parseInt(hm.get("Idade Metabólica").replace(",", "."));

        if(auxiliarparaValidarInteiros > 120 || auxiliarparaValidarInteiros < 0)
            throw new ForadeLimitesExcepcao();

        auxiliarparaValidarDoubles = Double.parseDouble(hm.get("H2O").replace(",", "."));

        if(auxiliarparaValidarDoubles > 120 || auxiliarparaValidarDoubles < 0)
            throw new ForadeLimitesExcepcao();

        auxiliarparaValidarDoubles = Double.parseDouble(hm.get("Metabolismo Basal").replace(",", "."));

        if(auxiliarparaValidarDoubles > 1500 || auxiliarparaValidarDoubles < 0)
            throw new ForadeLimitesExcepcao();

        auxiliarparaValidarDoubles = Double.parseDouble(hm.get("Osso").replace(",", "."));

        if(auxiliarparaValidarDoubles > 1500 || auxiliarparaValidarDoubles < 0)
            throw new ForadeLimitesExcepcao();




        /* Colesterol */
        auxiliarparaValidarDoubles = Double.parseDouble(hm.get("Colesterol").replace(",","."));


        if(auxiliarparaValidarDoubles > 1500 || auxiliarparaValidarDoubles < 0)
            throw new ForadeLimitesExcepcao();

        /* Glicemia */
        auxiliarparaValidarDoubles = Double.parseDouble(hm.get("Glicemia").replace(",","."));


        if(auxiliarparaValidarDoubles > 1500 || auxiliarparaValidarDoubles < 0)
            throw new ForadeLimitesExcepcao();

        /* Ureia */
        auxiliarparaValidarDoubles = Double.parseDouble(hm.get("Ureia").replace(",","."));

        if(auxiliarparaValidarDoubles > 1500 || auxiliarparaValidarDoubles < 0)
            throw new ForadeLimitesExcepcao();

        /* Creatinina */
        auxiliarparaValidarDoubles = Double.parseDouble(hm.get("Creatinina").replace(",","."));

        if(auxiliarparaValidarDoubles > 1500 || auxiliarparaValidarDoubles < 0)
            throw new ForadeLimitesExcepcao();

        /* Proteina C Reativa */
        auxiliarparaValidarDoubles = Double.parseDouble(hm.get("Proteina C Reactiva").replace(",", "."));

        if(auxiliarparaValidarDoubles > 1500 || auxiliarparaValidarDoubles < 0)
            throw new ForadeLimitesExcepcao();

    }




    public Paciente(RawDataPaciente up) throws CaracteresIncorrectosExcepcao, ForadeLimitesExcepcao, StringVaziaExcepcao, NullExcepcao, ParametroAusenteExcepcao {

        HashMap<String,String> hm = up.getData();

        //try {
             validarCampos(hm);

        /*} catch (NullExcepcao nullExcepcao) {
                nullExcepcao.printStackTrace();
            } catch (ForadeLimitesExcepcao foradeLimitesExcepcao) {
                foradeLimitesExcepcao.printStackTrace();
            } catch (StringVaziaExcepcao stringVaziaExcepcao) {
            stringVaziaExcepcao.printStackTrace();
            } catch (CaracteresIncorrectosExcepcao caracteresIncorrectosExcepcao) {
            caracteresIncorrectosExcepcao.printStackTrace();
        }*/


        nome = hm.get("Nome");
        idade = hm.get("Idade");


        try {
            alturaCm = Double.parseDouble(hm.get("Altura"));
        }
        catch(NumberFormatException e){
            try {
                /* Apesar das indicacoes, assumir que o utilizador colocou em metros. Retirar a vírgula ou o ponto, e fica em cm. */
                alturaCm = Double.parseDouble(hm.get("Altura").replace(",", "").replace(".", ""));
            }
            catch(NumberFormatException e1)
            {
                /* Caso mesmo assim nao dê para converter, terminar a execução */
                System.exit(1);
            }
        }

        pesoKg = Double.parseDouble(hm.get("Peso").replace(",", ".").replaceAll(" Kg",""));
        profissao = hm.get("Profissão");
        motivoConsulta = hm.get("Motivo da Consulta");
        objectivos = hm.get("Objectivos");
        patologias = hm.get("Patologias");
        medicacao = hm.get("Medicação");
        antecedentesFamiliares = hm.get("Antecedentes familiares");

        if(hm.containsKey("Moderadamente Ativo") && hm.get("Moderadamente Ativo").equals("X"))
            actividadeFisica = "Moderadamente Ativo";
        else if(hm.containsKey("Sedentário") && hm.get("Sedentário").equals("X"))
            actividadeFisica = "Sedentário";
        else if(hm.containsKey("Ativo") && hm.get("Ativo").equals("X"))
            actividadeFisica = "Ativo";
        else if(hm.containsKey("Muito Ativo") && hm.get("Muito Ativo").equals("X"))
            actividadeFisica = "Muito Ativo";
        else
            throw new ParametroAusenteExcepcao("actividadeFisica");



        if(hm.containsKey("Normal") && hm.get("Normal").equals("X"))
            funcaoIntestinal = "Normal";
        else if(hm.containsKey("Obstipado") && hm.get("Obstipado").equals("X"))
            funcaoIntestinal = "Obstipado";
        else if(hm.containsKey("Diarreias") && hm.get("Diarreias").equals("X"))
            funcaoIntestinal = "Diarreias";
        else
            throw new ParametroAusenteExcepcao("funcaoIntestinal");

        if(hm.containsKey("Menos de 0.5L") && hm.get("Menos de 0.5L").equals("X"))
            consumoAgua = "Menos de 0.5L";
        else if(hm.containsKey("0.5L a 1L") && hm.get("0.5L a 1L").equals("X"))
            consumoAgua = "0.5L a 1L";
        else if(hm.containsKey("1.5L a 2L") && hm.get("1.5L a 2L").equals("X"))
            consumoAgua = "1.5L a 2L";
        else if(hm.containsKey("Mais de 2L") && hm.get("Mais de 2L").equals("X"))
            consumoAgua = "Mais de 2L";
        else
            throw new ParametroAusenteExcepcao("actividadeFisica");

        imc = Double.parseDouble(hm.get("IMC").replace(",", "."));
        gorduraCorporal = Double.parseDouble(hm.get("B.F.").replace(",", "."));
        gorduraVisceral = Double.parseDouble(hm.get("Gordura Visceral").replace(",", "."));
        musculo = Double.parseDouble(hm.get("Musculo").replace(",", "."));
        idadeMetabolica = Double.parseDouble(hm.get("Idade Metabólica").replace(",", "."));
        agua = Double.parseDouble(hm.get("H2O").replace(",", "."));
        metabolismoBasal = Double.parseDouble(hm.get("Metabolismo Basal").replace(",", "."));
        osso = Double.parseDouble(hm.get("Osso").replace(",", "."));

        qm.setColesterol(Double.parseDouble(hm.get("Colesterol").replace(",", ".")));
        qm.setGlicemia(Double.parseDouble(hm.get("Glicemia").replace(",", ".")));
        qm.setUreia(Double.parseDouble(hm.get("Ureia").replace(",", ".")));
        qm.setCreatinina(Double.parseDouble(hm.get("Creatinina").replace(",", ".")));
        qm.setProteinaCReactiva(Double.parseDouble(hm.get("Proteina C Reactiva").replace(",", ".")));
    }

    public String getNome() {
        return nome;
    }

    public String getIdade() {
        return idade;
    }

    public Double getAlturaCm() {
        return alturaCm;
    }

    public Double getPesoKg() {
        return pesoKg;
    }

    public String getProfissao() {
        return profissao;
    }

    public String getMotivoConsulta() {
        return motivoConsulta;
    }

    public String getObjectivos() {
        return objectivos;
    }

    public String getPatologias() {
        return patologias;
    }

    public String getMedicacao() {
        return medicacao;
    }

    public String getAntecedentesFamiliares() {
        return antecedentesFamiliares;
    }

    public String getActividadeFisica() {
        return actividadeFisica;
    }

    public String getFuncaoIntestinal() {
        return funcaoIntestinal;
    }

    public String getConsumoAgua() {
        return consumoAgua;
    }

    public Double getImc() {
        return imc;
    }

    public Double getGorduraCorporal() {
        return gorduraCorporal;
    }

    public Double getGorduraVisceral() {
        return gorduraVisceral;
    }

    public Double getMusculo() {
        return musculo;
    }

    public Double getIdadeMetabolica() {
        return idadeMetabolica;
    }

    public Double getAgua() {
        return agua;
    }

    public Double getMetabolismoBasal() {
        return metabolismoBasal;
    }

    public Double getOsso() {
        return osso;
    }

    public Double getTMB(){
       return 66.5+13.8 * getPesoKg()+5 * getAlturaCm() - 6.8 * Double.parseDouble(getIdade());
    }

    public Double getCalorias(){
        FA=1.0;FL=1.0;FT=1.2;
        return getTMB()*FA*FL*FT;
    }
}
