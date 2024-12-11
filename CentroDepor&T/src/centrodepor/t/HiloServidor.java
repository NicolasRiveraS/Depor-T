/*
    Clase creada para que el Servidor se ejecute en un Hilo y corra al mismo tiempo que el Cliente
 */
package centrodepor.t;

public class HiloServidor extends Thread {
    // Atributos
    int puerto;
    
    // Constructor
    public HiloServidor (int puerto) {
        this.puerto = puerto;
    }
    
    // Métodos
    @Override
    public void run () {
        SocketServidor servidor = new SocketServidor();
        servidor.recibirInformacion(puerto);
    }
}