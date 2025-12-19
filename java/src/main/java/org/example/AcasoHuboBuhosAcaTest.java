import org.junit.jupiter.api.Test;
import proyecto.AcasoHuboBuhosAca;

import static org.junit.jupiter.api.Assertions.*;

class AcasoHuboBuhosAcaTest {

    @Test
     void ValidarYLimpiar() {
        String input = "Acaso Hubo Buhos Aca";
        String expected = "acasohubobuhosaca";
        String result = AcasoHuboBuhosAca.validarYLimpiar(input);
        assertEquals(expected, result, "La frase no se limpió correctamente.");
    }

    @Test
    void RecorrerPalindromo() {
        String palindromo = "acasohubobuhosaca";
        assertTrue(AcasoHuboBuhosAca.recorrerPalindromo(palindromo), "Debe ser un palíndromo.");
        String noPalindromo = "hola mundo";
        assertFalse(AcasoHuboBuhosAca.recorrerPalindromo(noPalindromo), "No debe ser un palíndromo.");
    }
}