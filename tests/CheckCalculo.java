import com.es2.Armazenamento.*;
import com.es2.Leitura.RawDataPaciente;
import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.assertEquals;

import static com.es2.Escrita.EscreveCSV.round;

public class CheckCalculo {
    @Test
    public void calculoNecessidadesCaloricasDevolveValorCorrecto(){
        Double FA = 1D; Double FL = 1D; Double FT = 1.2D; Double PesoKG = 150D; Double altura = 168D; String idade = "29";

        Paciente p = null;

        RawDataPaciente rd = new RawDataPaciente();

        rd.addElemento("Nome","Gervásio Palha");
        rd.addElemento("Idade","29");
        rd.addElemento("Altura","1,68");
        rd.addElemento("Peso","150");
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

        try {
            p = new Paciente(rd);
        } catch (CaracteresIncorrectosExcepcao caracteresIncorrectosExcepcao) {

        } catch (ForadeLimitesExcepcao foradeLimitesExcepcao) {

        } catch (StringVaziaExcepcao stringVaziaExcepcao) {

        } catch (NullExcepcao nullExcepcao) {

        } catch (ParametroAusenteExcepcao parametroAusenteExcepcao) {

        }

        assertEquals(round(p.getCalorias(),2),3335.16);



    }
}
