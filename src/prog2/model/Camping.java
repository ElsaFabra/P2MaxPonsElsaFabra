package prog2.model;

import prog2.vista.ExcepcioCamping;
import java.io.*;

/**
 * Classe principal que representa el càmping Green.
 * Coordina les llistes d'allotjaments, accessos i tasques de manteniment.
 * Implementa la interfície {@link InCamping} i permet guardar i carregar l'estat del càmping.
 * @author FabraElsaPonsMax
 * @version 1.0
 */
public class Camping implements InCamping, Serializable {

    /** Nom del càmping. */
    private String nom;

    /** Llista d'allotjaments del càmping. */
    private LlistaAllotjaments llistaAllotjaments;

    /** Llista d'accessos del càmping. */
    private LlistaAccessos llistaAccessos;

    /** Llista de tasques de manteniment actives del càmping. */
    private LlistaTasquesManteniment llistaTasques;

    /**
     * Constructor de la classe Camping.
     * Inicialitza les tres llistes buides.
     * @param nom Nom del càmping.
     */
    public Camping(String nom) {
        this.nom = nom;
        this.llistaAllotjaments = new LlistaAllotjaments();
        this.llistaAccessos = new LlistaAccessos();
        this.llistaTasques = new LlistaTasquesManteniment();
    }

    /**
     * Retorna el nom del càmping.
     * @return Nom del càmping.
     */
    @Override
    public String getNomCamping() { return nom; }

    /**
     * Llista els allotjaments segons l'estat indicat.
     * @param estat Estat a filtrar: "tots", "operatiu" o "no operatiu".
     * @return String amb la informació dels allotjaments filtrats.
     * @throws ExcepcioCamping Si no hi ha allotjaments o amb l'estat indicat.
     */
    @Override
    public String llistarAllotjaments(String estat) throws ExcepcioCamping {
        return llistaAllotjaments.llistarAllotjaments(estat);
    }

    /**
     * Llista els accessos segons l'estat indicat.
     * @param infoEstat "obert" per llistar els oberts, qualsevol altre valor per llistar els tancats.
     * @return String amb la informació dels accessos filtrats.
     * @throws ExcepcioCamping Si no hi ha accessos amb l'estat indicat.
     */
    @Override
    public String llistarAccessos(String infoEstat) throws ExcepcioCamping {
        return llistaAccessos.llistarAccessos(infoEstat.equals("obert"));
    }

    /**
     * Llista totes les tasques de manteniment actives.
     * @return String amb la informació de totes les tasques actives.
     * @throws ExcepcioCamping Si no hi ha cap tasca activa.
     */
    @Override
    public String llistarTasquesManteniment() throws ExcepcioCamping {
        return llistaTasques.llistarTasquesManteniment();
    }

    /**
     * Afegeix una nova tasca de manteniment i actualitza l'estat dels accessos.
     * @param num Número identificador de la tasca.
     * @param tipus Tipus de tasca com a String.
     * @param idAllotjament Identificador de l'allotjament afectat.
     * @param data Data de registre de la tasca.
     * @param dies Nombre de dies esperats per completar la tasca.
     * @throws ExcepcioCamping Si l'allotjament no existeix, ja té una tasca activa o el tipus no existeix.
     */
    @Override
    public void afegirTascaManteniment(int num, String tipus, String idAllotjament,
                                       String data, int dies) throws ExcepcioCamping {
        Allotjament allotjament = llistaAllotjaments.getAllotjament(idAllotjament);
        llistaTasques.afegirTascaManteniment(num, tipus, allotjament, data, dies);
        llistaAccessos.actualitzaEstatAccessos();
    }

    /**
     * Completa una tasca de manteniment i actualitza l'estat dels accessos.
     * @param num Número identificador de la tasca a completar.
     * @throws ExcepcioCamping Si no existeix cap tasca amb el número indicat.
     */
    @Override
    public void completarTascaManteniment(int num) throws ExcepcioCamping {
        TascaManteniment tasca = llistaTasques.getTascaManteniment(num);
        llistaTasques.completarTascaManteniment(tasca);
        llistaAccessos.actualitzaEstatAccessos();
    }

    /**
     * Calcula el nombre total d'accessos que no proporcionen accessibilitat amb vehicle.
     * @return Nombre d'accessos no accessibles amb vehicle.
     */
    @Override
    public int calculaAccessosNoAccessibles() {
        try {
            return llistaAccessos.calculaAccessosNoAccessibles();
        } catch (ExcepcioCamping e) {
            return 0;
        }
    }

    /**
     * Calcula la suma total de metres de longitud dels accessos de terra.
     * @return Total de metres dels accessos de terra.
     */
    @Override
    public float calculaMetresTerra() {
        try {
            return llistaAccessos.calculaMetresTerra();
        } catch (ExcepcioCamping e) {
            return 0;
        }
    }

    /**
     * Guarda l'estat actual del càmping en un fitxer mitjançant serialització.
     * @param camiDesti Ruta del fitxer on es guardarà el càmping.
     * @throws ExcepcioCamping Si es produeix un error en guardar o tancar el fitxer.
     */
    @Override
    public void save(String camiDesti) throws ExcepcioCamping {
        File fitxer = new File(camiDesti);
        FileOutputStream fout = null;
        ObjectOutputStream oos = null;
        try {
            fout = new FileOutputStream(fitxer);
            oos = new ObjectOutputStream(fout);
            oos.writeObject(this);
        } catch (IOException e) {
            throw new ExcepcioCamping("Error al guardar el camping: " + e.getMessage());
        } finally {
            try {
                if (oos != null) oos.close();
                if (fout != null) fout.close();
            } catch (IOException e) {
                throw new ExcepcioCamping("Error al tancar el fitxer: " + e.getMessage());
            }
        }
    }

    /**
     * Carrega l'estat d'un càmping des d'un fitxer mitjançant deserialització.
     * @param camiOrigen Ruta del fitxer des del qual es carregarà el càmping.
     * @return Instància de {@link Camping} carregada des del fitxer.
     * @throws ExcepcioCamping Si no es troba el fitxer o es produeix un error en carregar.
     */
    public static Camping carregar(String camiOrigen) throws ExcepcioCamping {
        Camping camping = null;
        File fitxer = new File(camiOrigen);
        FileInputStream fin = null;
        ObjectInputStream ois = null;
        try {
            fin = new FileInputStream(fitxer);
            ois = new ObjectInputStream(fin);
            camping = (Camping) ois.readObject();
        } catch (FileNotFoundException e) {
            throw new ExcepcioCamping("No s'ha trobat el fitxer: " + e.getMessage());
        } catch (ClassNotFoundException e) {
            throw new ExcepcioCamping("Error al carregar la classe: " + e.getMessage());
        } catch (IOException e) {
            throw new ExcepcioCamping("Error al carregar el càmping: " + e.getMessage());
        } finally {
            try {
                if (ois != null) ois.close();
                if (fin != null) fin.close();
            } catch (IOException e) {
                throw new ExcepcioCamping("Error al tancar el fitxer: " + e.getMessage());
            }
        }
        return camping;
    }

    /**
     * Inicialitza les dades del càmping amb els valors predeterminats de les taules 1 i 2 de l'enunciat.
     * Crea els 12 accessos i els 6 allotjaments i els associa entre ells.
     */
    @Override
    public void inicialitzaDadesCamping() {

        llistaAccessos.buidar();

        float asfalt = 200;
        Acces Acc1 = new CamiAsfaltat("A1", true, asfalt);
        llistaAccessos.afegirAcces(Acc1);

        asfalt = 800;
        float pesMaxim = 10000;
        Acces Acc2 = new CarreteraAsfaltada("A2", true, asfalt, pesMaxim);
        llistaAccessos.afegirAcces(Acc2);

        float longitud = 100;
        Acces Acc3 = new CamiTerra("A3", true, longitud);
        llistaAccessos.afegirAcces(Acc3);

        longitud = 200;
        float amplada = 3;
        Acces Acc4 = new CarreteraTerra("A4", true, longitud, amplada);
        llistaAccessos.afegirAcces(Acc4);

        asfalt = 350;
        Acces Acc5 = new CamiAsfaltat("A5", true, asfalt);
        llistaAccessos.afegirAcces(Acc5);

        asfalt = 800;
        pesMaxim = 12000;
        Acces Acc6 = new CarreteraAsfaltada("A6", true, asfalt, pesMaxim);
        llistaAccessos.afegirAcces(Acc6);

        asfalt = 100;
        Acces Acc7 = new CamiAsfaltat("A7", true, asfalt);
        llistaAccessos.afegirAcces(Acc7);

        asfalt = 800;
        pesMaxim = 10000;
        Acces Acc8 = new CarreteraAsfaltada("A8", true, asfalt, pesMaxim);
        llistaAccessos.afegirAcces(Acc8);

        longitud = 50;
        Acces Acc9 = new CamiTerra("A9", true, longitud);
        llistaAccessos.afegirAcces(Acc9);

        longitud = 400;
        amplada = 4;
        Acces Acc10 = new CarreteraTerra("A10", true, longitud, amplada);
        llistaAccessos.afegirAcces(Acc10);

        longitud = 80;
        Acces Acc11 = new CamiTerra("A11", true, longitud);
        llistaAccessos.afegirAcces(Acc11);

        longitud = 800;
        amplada = 5;
        Acces Acc12 = new CarreteraTerra("A12", true, longitud, amplada);
        llistaAccessos.afegirAcces(Acc12);


        /* Pistes */
        llistaAllotjaments.buidar();


        // Afegir parcel·les:
        //------------------------------

        String nom = "Parcel·la Nord";
        String idAllotjament = "ALL1";
        float mida = 64.0f;
        boolean connexioElectrica = true;

        Parcela ALL1 = new Parcela(nom, idAllotjament, true, "100%", mida, connexioElectrica);
        llistaAllotjaments.afegirAllotjament(ALL1);

        nom = "Parcel·la Sud";
        idAllotjament = "ALL2";

        Parcela ALL2 = new Parcela(nom, idAllotjament, true, "100%", mida, connexioElectrica);
        llistaAllotjaments.afegirAllotjament(ALL2);

        // Afegir bungalows:
        //------------------------------

        nom = "Bungalow Nord";
        idAllotjament = "ALL3";
        mida = 22f;
        int habitacions =2;
        int placesPersones = 4;
        int placesParquing = 1;
        boolean terrassa = true;
        boolean tv= true;
        boolean aireFred = true;

        Bungalow ALL3 = new Bungalow(nom, idAllotjament, true, "100%", mida, habitacions, placesPersones, placesParquing, terrassa, tv, aireFred);
        llistaAllotjaments.afegirAllotjament(ALL3);


        // Afegir bungalows premium:
        //------------------------------
        nom = "Bungallow Sud";
        idAllotjament = "ALL4";
        mida = 27f;
        habitacions =2;
        placesPersones = 6;
        placesParquing = 1;
        terrassa = true;
        tv= true;
        aireFred = true;
        boolean serveisExtra = true;
        String codiWifi = "CampingDelMarBP1";

        BungalowPremium ALL4 = new BungalowPremium(nom, idAllotjament, true, "100%", mida, habitacions, placesPersones, placesParquing, terrassa, tv, aireFred, serveisExtra, codiWifi);
        llistaAllotjaments.afegirAllotjament(ALL4);

        // Afegir Glamping:
        //------------------------------

        nom = "Glamping Nord";
        idAllotjament = "ALL5";
        mida = 20f;
        habitacions =1;
        placesPersones = 2;
        String material = "Tela";
        boolean casaMascota = true;

        Glamping ALL5 = new Glamping(nom, idAllotjament, true, "100%", mida, habitacions, placesPersones, material, casaMascota);
        llistaAllotjaments.afegirAllotjament(ALL5);


        // Afegir Mobil-Home:
        //------------------------------

        nom = "Mobil-Home Sud";
        idAllotjament = "ALL6";
        mida = 20f;
        habitacions =  2;
        placesPersones = 4;
        boolean terrassaBarbacoa = true;

        MobilHome ALL6 = new MobilHome(nom, idAllotjament, true, "100%", mida, habitacions, placesPersones, terrassaBarbacoa);
        llistaAllotjaments.afegirAllotjament(ALL6);

        /* Accés */
        Acc1.afegirAllotjament(ALL1); Acc1.afegirAllotjament(ALL2);
        Acc2.afegirAllotjament(ALL1); Acc2.afegirAllotjament(ALL2);
        Acc3.afegirAllotjament(ALL3);
        Acc4.afegirAllotjament(ALL3);
        Acc5.afegirAllotjament(ALL4);
        Acc6.afegirAllotjament(ALL4);
        Acc7.afegirAllotjament(ALL5); Acc7.afegirAllotjament(ALL6);
        Acc8.afegirAllotjament(ALL5); Acc8.afegirAllotjament(ALL6);
        Acc9.afegirAllotjament(ALL2);
        Acc10.afegirAllotjament(ALL2);
        Acc11.afegirAllotjament(ALL6);
        Acc12.afegirAllotjament(ALL6);

    }
}