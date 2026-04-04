import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;
import prog2.model.*;
import prog2.vista.ExcepcioCamping;

public class LlistaTasquesMantenimentTest {
    private LlistaTasquesManteniment llista;
    private Parcela parcela;
    private Bungalow bungalow;

    @BeforeEach
    public void setUp() {
        llista = new LlistaTasquesManteniment();
        parcela = new Parcela("Parcel·la Nord", "ALL1", true, "100%", 64, true);
        bungalow = new Bungalow("Bungalow Nord", "ALL3", true, "100%", 22, 2, 4, 1, true, true, true);
    }

    @Test
    public void testAfegirTasca() throws ExcepcioCamping {
        llista.afegirTascaManteniment(1, "Reparacio", parcela, "2024-03-25", 4);
        TascaManteniment tasca = llista.getTascaManteniment(1);
        assertEquals(1, tasca.getNum());
    }

    @Test
    public void testAfegirTascaDuplicada() throws ExcepcioCamping {
        llista.afegirTascaManteniment(1, "Reparacio", parcela, "2024-03-25", 4);
        assertThrows(ExcepcioCamping.class, () -> {
            llista.afegirTascaManteniment(2, "Neteja", parcela, "2024-03-26", 2);
        });
    }

    @Test
    public void testAfegirTascaTipusInvalid() {
        assertThrows(ExcepcioCamping.class, () -> {
            llista.afegirTascaManteniment(1, "TipusInvalid", parcela, "2024-03-25", 4);
        });
    }

    @Test
    public void testAllotjamentNoOperatiuEnAfegir() throws ExcepcioCamping {
        llista.afegirTascaManteniment(1, "Reparacio", parcela, "2024-03-25", 4);
        assertFalse(parcela.isOperatiu());
    }

    @Test
    public void testIluminacioEnAfegir() throws ExcepcioCamping {
        llista.afegirTascaManteniment(1, "Reparacio", parcela, "2024-03-25", 4);
        assertEquals("50%", parcela.getIluminacio());
    }

    @Test
    public void testCompletarTasca() throws ExcepcioCamping {
        llista.afegirTascaManteniment(1, "Reparacio", parcela, "2024-03-25", 4);
        TascaManteniment tasca = llista.getTascaManteniment(1);
        llista.completarTascaManteniment(tasca);
        assertTrue(parcela.isOperatiu());
    }

    @Test
    public void testAllotjamentOperatiuEnCompletar() throws ExcepcioCamping {
        llista.afegirTascaManteniment(1, "Reparacio", parcela, "2024-03-25", 4);
        TascaManteniment tasca = llista.getTascaManteniment(1);
        llista.completarTascaManteniment(tasca);
        assertEquals("100%", parcela.getIluminacio());
    }

    @Test
    public void testGetTascaNoExisteix() {
        assertThrows(ExcepcioCamping.class, () -> {
            llista.getTascaManteniment(99);
        });
    }

    @Test
    public void testLlistarTasquesBuit() {
        assertThrows(ExcepcioCamping.class, () -> {
            llista.llistarTasquesManteniment();
        });
    }
}