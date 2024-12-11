package centrodepor.t;
import java.util.*;

public class Main {
    // Atributos
        // Se declaran Static para poder ser accesados y modificados desde los JFrame Forms.
    public static ArrayList<Usuario> usuarios = new ArrayList<>();
    public static LinkedList<CatalogoDeportistas> catDeportistas = new LinkedList<>();
    public static LinkedList<CatalogoPadresFamilia> catPadres = new LinkedList<>();
    public static LinkedList<CatalogoDeportes> catDeportes = new LinkedList<>();
    public static LinkedList<CatalogoRutinas> catRutinas = new LinkedList<>();
    
    // Constructor Main
    public static void main(String[] args) {
        // Crea el menú principal y lo hace visible
        MenuPrincipal.main(args);
        MenuPrincipal menu = new MenuPrincipal();
        menu.setVisible(true);
    }
}