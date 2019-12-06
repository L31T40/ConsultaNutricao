import com.es2.Leitura.LerCSV;
import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.assertEquals;

import java.io.IOException;

public class CheckFicheiros {
    @Test
    public void LerCSVQuestionarioFileTest()
    {
        /* Quando o ficheiro n�o existe, devolve null */
        try {
            assertEquals(LerCSV.lerCSVQuestionario("ficheironaoexiste.txt"),null);
        } catch (IOException e) {

        }


    }

    @Test
    public void LerCSVTabela()
    {
        /* Quando o ficheiro n�o existe, devolve null */
        try {
            assertEquals(LerCSV.lerCSVTabela("ficheironaoexiste.txt"),null);
        } catch (IOException e) {

        }


    }
}
