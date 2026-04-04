import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;
import prog2.model.*;
import prog2.vista.ExcepcioCamping;

public class CampingTest {
    private Camping camping;

    @BeforeEach
    public void setUp() {
        camping = new Camping("Green");
        camping.inicialitzaDadesCamping();
    }

    @Test
    public void testGetNomCamping() {
        assertEquals("Green", camping.getNomCamping());
    }

    @Test
    public void testLlistarTotsAllotjaments() throws ExcepcioCamping {
        String result = camping.llistarAllotjaments("tots");
        assertNotNull(result);
        assertFalse(result.isEmpty());
    }

    @Test
    public void testLlistarAllotjamentsOperatius() throws ExcepcioCamping {
        String result = camping.llistarAllotjaments("operatiu");
        assertNotNull(result);
        assertFalse(result.isEmpty());
    }

    @Test
    public void testLlistarAccessosOberts() throws ExcepcioCamping {
        String result = camping.llistarAccessos("obert");
        assertNotNull(result);
        assertFalse(result.isEmpty());
    }

    @Test
    public void testAfegirTasca() throws ExcepcioCamping {
        camping.afegirTascaManteniment(1, "Reparacio", "ALL1", "2024-03-25", 4);
        String result = camping.llistarTasquesManteniment();
        assertNotNull(result);
        assertFalse(result.isEmpty());
    }

    @Test
    public void testAfegirTascaAllotjamentNoExisteix() {
        assertThrows(ExcepcioCamping.class, () -> {
            camping.afegirTascaManteniment(1, "Reparacio", "ALL99", "2024-03-25", 4);
        });
    }

    @Test
    public void testCompletarTasca() throws ExcepcioCamping {
        camping.afegirTascaManteniment(1, "Reparacio", "ALL1", "2024-03-25", 4);
        camping.completarTascaManteniment(1);
        assertThrows(ExcepcioCamping.class, () -> {
            camping.llistarTasquesManteniment();
        });
    }

    @Test
    public void testCalculaAccessosNoAccessibles() {
        // A1, A3, A5, A7, A9, A11 son camins = 6
        assertEquals(6, camping.calculaAccessosNoAccessibles());
    }

    @Test
    public void testCalculaMetresTerra() {
        // A3(100) + A4(200) + A9(50) + A10(400) + A11(80) + A12(800) = 1630
        assertEquals(1630, camping.calculaMetresTerra());
    }
}