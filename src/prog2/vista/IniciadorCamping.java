package prog2.vista;

/**
 *
 * @author lauraigual
 */

// borrar comentari -->

/* Aquesta classe té com a responsabilitat llançar el bucle principal de l’aplicació.
La classe de la vista IniciadorCamping té un mètode estàtic main() on es crea un
objecte de tipus VistaCamping anomenat vistaCamping. Desprès crida el mètode
gestioCamping() de l’objecte vistaCamping, on es troba el bucle principal de
l’aplicació.
 */

public class IniciadorCamping {
    
    /**
     * @param args the command line arguments
     */
        public static void main(String[] args) {
        // Definim el nom del càmping
        String nomCamping = "Green";

        // Creem un objecte de la vista i li passem el nom del càmping
        VistaCamping vistaCamping = new VistaCamping(nomCamping);
     
        // Inicialitzem l'execució de la vista
        vistaCamping.gestioCamping();
    }
}
