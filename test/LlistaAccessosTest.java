import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;
import prog2.model.*;
import prog2.vista.ExcepcioCamping;

public class LlistaAccessosTest {
    private LlistaAccessos llista;
    private CamiAsfaltat camiAsfalt;
    private CarreteraAsfaltada carreteraAsfalt;
    private CamiTerra camiTerra;
    private CarreteraTerra carreteraTerra;
    private Parcela parcela;

    @BeforeEach
    public void setUp() throws ExcepcioCamping {
        llista = new LlistaAccessos();
        camiAsfalt = new CamiAsfaltat("A1", true, 200);
        carreteraAsfalt = new CarreteraAsfaltada("A2", true, 800, 10000);
        camiTerra = new CamiTerra("A3", true, 100);
        carreteraTerra = new CarreteraTerra("A4", true, 200, 3);
        parcela = new Parcela("Parcel·la Nord", "ALL1", true, "100%", 64, true);

        llista.afegirAcces(camiAsfalt);
        llista.afegirAcces(carreteraAsfalt);
        llista.afegirAcces(camiTerra);
        llista.afegirAcces(carreteraTerra);
    }

    @Test
    public void testLlistarAccessosOberts() throws ExcepcioCamping {
        String result = llista.llistarAccessos(true);
        assertNotNull(result);
        assertFalse(result.isEmpty());
    }

    @Test
    public void testLlistarAccessosTancats() {
        assertThrows(ExcepcioCamping.class, () -> {
            llista.llistarAccessos(false);
        });
    }

    @Test
    public void testCalculaAccessosNoAccessibles() throws ExcepcioCamping {
        // CamiAsfalt i CamiTerra no son accessibles = 2
        assertEquals(2, llista.calculaAccessosNoAccessibles());
    }

    @Test
    public void testCalculaMetresTerra() throws ExcepcioCamping {
        // CamiTerra 100 + CarreteraTerra 200 = 300
        assertEquals(300, llista.calculaMetresTerra());
    }

    @Test
    public void testActualitzaEstatAccessos() throws ExcepcioCamping {
        camiAsfalt.afegirAllotjament(parcela);
        TascaManteniment tasca = new TascaManteniment(1,
                TascaManteniment.TipusTascaManteniment.Reparacio, parcela, "2024-03-25", 4);
        parcela.tancarAllotjament(tasca);
    }

    @Test
    public void testBuidar() {
        llista.buidar();
        assertThrows(ExcepcioCamping.class, () -> {
            llista.llistarAccessos(true);
        });
    }
}
