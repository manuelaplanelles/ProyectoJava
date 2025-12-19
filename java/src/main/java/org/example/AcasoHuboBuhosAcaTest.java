import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

class AcasoHuboBuhosAcaTest {

    @Test
    void ValidarYLimpiar() {
        String input = "Acaso Hubo Buhos Aca";
        String expected = "acasohubobuhosaca";
        String result = AcasoHuboBuhosAca.ValidarYLimpiar(input);
        assertEquals(expected, result, "La frase no se limpió correctamente.");
    }

    @Test
    void RecorrerPalindromo() {
        String palindromo = "acasohubobuhosaca";
        assertTrue(AcasoHuboBuhosAca.RecorrerPalindromo(palindromo), "Debe ser un palíndromo.");
        String noPalindromo = "hola mundo";
        assertFalse(AcasoHuboBuhosAca.RecorrerPalindromo(noPalindromo), "No debe ser un palíndromo.");
    }
}