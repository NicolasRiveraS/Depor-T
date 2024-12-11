/*
    Clase creada para que el Cliente se ejecute en un Hilo y corra al mismo tiempo que el Servidor
 */
package centrodepor.t;

public class HiloCliente extends Thread {
    // Atributos
    int puerto;
    
    // Constructor
    public HiloCliente (int puerto) {
        this.puerto = puerto;
    }
    
    // Métodos
    @Override
    public void run () {
        SocketCliente cliente = new SocketCliente();
        cliente.recibirInformacion(puerto);
    }
}