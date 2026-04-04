import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;
import prog2.model.*;
import prog2.vista.ExcepcioCamping;

public class LlistaAllotjamentsTest {
    private LlistaAllotjaments llista;
    private Parcela parcela;
    private Bungalow bungalow;

    @BeforeEach
    public void setUp() throws ExcepcioCamping {
        llista = new LlistaAllotjaments();
        parcela = new Parcela("Parcel·la Nord", "ALL1", true, "100%", 64, true);
        bungalow = new Bungalow("Bungalow Nord", "ALL3", true, "100%", 22, 2, 4, 1, true, true, true);
        llista.afegirAllotjament(parcela);
    }

    @Test
    public void testAfegirAllotjament() throws ExcepcioCamping {
        llista.afegirAllotjament(bungalow);
        assertEquals(bungalow, llista.getAllotjament("ALL3"));
    }

    @Test
    public void testAfegirAllotjamentDuplicat() {
        assertThrows(ExcepcioCamping.class, () -> {
            llista.afegirAllotjament(parcela);
        });
    }

    @Test
    public void testGetAllotjament() throws ExcepcioCamping {
        assertEquals(parcela, llista.getAllotjament("ALL1"));
    }

    @Test
    public void testGetAllotjamentNoExisteix() {
        assertThrows(ExcepcioCamping.class, () -> {
            llista.getAllotjament("ALL99");
        });
    }

    @Test
    public void testLlistarTots() throws ExcepcioCamping {
        String result = llista.llistarAllotjaments("tots");
        assertNotNull(result);
        assertFalse(result.isEmpty());
    }

    @Test
    public void testLlistarOperatius() throws ExcepcioCamping {
        String result = llista.llistarAllotjaments("operatiu");
        assertNotNull(result);
        assertFalse(result.isEmpty());
    }

    @Test
    public void testLlistarNoOperatius() {
        assertThrows(ExcepcioCamping.class, () -> {
            llista.llistarAllotjaments("no operatiu");
        });
    }

    @Test
    public void testLlistarBuit() {
        llista.buidar();
        assertThrows(ExcepcioCamping.class, () -> {
            llista.llistarAllotjaments("tots");
        });
    }

    @Test
    public void testContainsAllotjamentOperatiu() {
        assertTrue(llista.containsAllotjamentOperatiu());
    }

    @Test
    public void testContains() {
        assertTrue(llista.contains(parcela));
    }

    @Test
    public void testBuidar() {
        llista.buidar();
        assertThrows(ExcepcioCamping.class, () -> {
            llista.getAllotjament("ALL1");
        });
    }
}