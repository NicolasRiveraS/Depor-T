/*
    Clase creada para que el Servidor se ejecute en un Hilo y corra al mismo tiempo que el Cliente
 */
package centrodepor.t;

public class HiloServidor extends Thread {
    // Atributos
    int puerto;
    int direccion;  // Si es 0, es de entrada (hacia el servidor). Si es 1, es de salida (desde el servidor).
    
    // Constructor
    public HiloServidor (int puerto, int direccion) {
        this.puerto = puerto;
        this.direccion = direccion;
    }
    
    // Métodos
    @Override
    public void run () {
        SocketServidor servidor = new SocketServidor();
        switch (direccion) {
            case 0:
                servidor.recibirInformacion(puerto);
                break;
            case 1:
                servidor.consultarYEnviarBaseDatos();
                break;
            default:
                throw new AssertionError();
        }
    }
}