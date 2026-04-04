package prog2.vista;

import prog2.model.Camping;
import prog2.model.Menu;

import java.util.Scanner;

public class VistaCamping {
    private Camping camping;
    private Scanner sc;

    public VistaCamping(String nomCamping) {
        this.camping = new Camping(nomCamping);
        this.sc = new Scanner(System.in);
        this.camping.inicialitzaDadesCamping();
    }

    public void gestioCamping() {
        enum OpcionsMenu {
            LLISTAR_TOTS_ALLOTJAMENTS,
            LLISTAR_OPERATIUS,
            LLISTAR_NO_OPERATIUS,
            LLISTAR_ACCESSOS_OBERTS,
            LLISTAR_ACCESSOS_TANCATS,
            LLISTAR_TASQUES,
            AFEGIR_TASCA,
            COMPLETAR_TASCA,
            CALCULAR_ACCESSOS_NO_ACCESSIBLES,
            CALCULAR_METRES_TERRA,
            GUARDAR_CAMPING,
            CARREGAR_CAMPING,
            SORTIR
        }

        String[] descripcions = {
                "Llistar la informació de tots els allotjaments",
                "Llistar la informació dels allotjaments operatius",
                "Llistar la informació dels allotjaments no operatius",
                "Llistar la informació dels accessos oberts",
                "Llistar la informació dels accessos tancats",
                "Llistar la informació de les tasques de manteniments actives",
                "Afegir una tasca de manteniment",
                "Completar una tasca de manteniment",
                "Calcular i mostrar el número total d'accessos que NO proporcionen accessibilitat amb vehicle",
                "Calcular i mostrar el número total de metres dels accessos de terra",
                "Guardar càmping",
                "Recuperar càmping",
                "Sortir de l'aplicació"
        };

        Menu<OpcionsMenu> menu = new Menu<>("Camping Green", OpcionsMenu.values());
        menu.setDescripcions(descripcions);

        OpcionsMenu opcio;
        do {
            menu.mostrarMenu();
            opcio = menu.getOpcio(sc);

            switch (opcio) {
                case LLISTAR_TOTS_ALLOTJAMENTS:
                    try {
                        System.out.println(camping.llistarAllotjaments("tots"));
                    } catch (ExcepcioCamping e) {
                        System.out.println("Error: " + e.getMessage());
                    }
                    break;

                case LLISTAR_OPERATIUS:
                    try {
                        System.out.println(camping.llistarAllotjaments("operatiu"));
                    } catch (ExcepcioCamping e) {
                        System.out.println("Error: " + e.getMessage());
                    }
                    break;

                case LLISTAR_NO_OPERATIUS:
                    try {
                        System.out.println(camping.llistarAllotjaments("no operatiu"));
                    } catch (ExcepcioCamping e) {
                        System.out.println("Error: " + e.getMessage());
                    }
                    break;

                case LLISTAR_ACCESSOS_OBERTS:
                    try {
                        System.out.println(camping.llistarAccessos("obert"));
                    } catch (ExcepcioCamping e) {
                        System.out.println("Error: " + e.getMessage());
                    }
                    break;

                case LLISTAR_ACCESSOS_TANCATS:
                    try {
                        System.out.println(camping.llistarAccessos("tancat"));
                    } catch (ExcepcioCamping e) {
                        System.out.println("Error: " + e.getMessage());
                    }
                    break;

                case LLISTAR_TASQUES:
                    try {
                        System.out.println(camping.llistarTasquesManteniment());
                    } catch (ExcepcioCamping e) {
                        System.out.println("Error: " + e.getMessage());
                    }
                    break;

                case AFEGIR_TASCA:
                    try {
                        System.out.print("Número de la tasca: ");
                        int num = sc.nextInt();
                        sc.nextLine();
                        System.out.print("Nom de l'allotjament (id): ");
                        String id = sc.nextLine();
                        System.out.print("Tipus de tasca (Reparacio, Neteja, RevisioTecnica, Desinfeccio): ");
                        String tipus = sc.nextLine();
                        System.out.print("Data: ");
                        String data = sc.nextLine();
                        System.out.print("Dies esperats: ");
                        int dies = sc.nextInt();
                        sc.nextLine();
                        camping.afegirTascaManteniment(num, tipus, id, data, dies);
                        System.out.println("Tasca afegida correctament.");
                    } catch (ExcepcioCamping e) {
                        System.out.println("Error: " + e.getMessage());
                    }
                    break;

                case COMPLETAR_TASCA:
                    try {
                        System.out.println(camping.llistarTasquesManteniment());
                        System.out.print("Número de la tasca a completar: ");
                        int num = sc.nextInt();
                        sc.nextLine();
                        camping.completarTascaManteniment(num);
                        System.out.println("Tasca completada correctament.");
                    } catch (ExcepcioCamping e) {
                        System.out.println("Error: " + e.getMessage());
                    }
                    break;

                case CALCULAR_ACCESSOS_NO_ACCESSIBLES:
                    int noAccessibles = camping.calculaAccessosNoAccessibles();
                    System.out.println("Accessos sense accessibilitat amb vehicle: " + noAccessibles);
                    break;

                case CALCULAR_METRES_TERRA:
                    float metres = camping.calculaMetresTerra();
                    System.out.println("Total metres d'accessos de terra: " + metres);
                    break;

                case GUARDAR_CAMPING:
                    try {
                        System.out.print("Ruta del fitxer per guardar: ");
                        String ruta = sc.nextLine();
                        camping.save(ruta);
                        System.out.println("Càmping guardat correctament.");
                    } catch (ExcepcioCamping e) {
                        System.out.println("Error: " + e.getMessage());
                    }
                    break;

                case CARREGAR_CAMPING:
                    try {
                        System.out.print("Ruta del fitxer per carregar: ");
                        String ruta = sc.nextLine();
                        camping = Camping.carregar(ruta);
                        System.out.println("Càmping carregat correctament.");
                    } catch (ExcepcioCamping e) {
                        System.out.println("Error: " + e.getMessage());
                    }
                    break;

                case SORTIR:
                    System.out.println("Fins aviat!");
                    break;
            }
        } while (opcio != OpcionsMenu.SORTIR);
    }
}
