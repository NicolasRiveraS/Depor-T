package centrodepor.t;
import java.util.LinkedList;

public class EjecCatalogo {
     public static void main(String[] args) {
        LinkedList<CatalogoDeportes> deportes = new LinkedList<>();
        LinkedList<CatalogoRutinas> rutinas = new LinkedList<>();

        // Agregar un deporte
        CatalogoDeportes futbol = new CatalogoDeportes();
        futbol.setNombre("Fútbol");
        futbol.setCaracteristicas("Deporte de equipo");
        deportes.add(futbol);

        // Agregar una rutina para el deporte "Fútbol"
        CatalogoRutinas rutina1 = new CatalogoRutinas();
        rutina1.setDescripcion("Entrenamiento de resistencia");
        rutina1.setDeporte("Fútbol");
        rutina1.setDuracion(60);
        rutinas.add(rutina1);

        // Mostrar información
        for (CatalogoDeportes deporte : deportes) {
            System.out.println("Deporte: " + deporte.getNombre() + ", Características: " + deporte.getCaracteristicas());
        }
        for (CatalogoRutinas rutina : rutinas) {
            System.out.println("Rutina: " + rutina.getDescripcion() + ", Deporte: " + rutina.getDeporte() + ", Duración: " + rutina.getDuracion() + " minutos");
        }
    }
}
    
