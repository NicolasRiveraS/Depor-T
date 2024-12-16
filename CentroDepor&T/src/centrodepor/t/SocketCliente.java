package centrodepor.t;

import java.io.*;
import java.net.*;
import java.util.*;
import javax.swing.JOptionPane;

public class SocketCliente {
    // Atributos
        // Comunicación Cliente-Servidor
    private Socket sc;
    private DataInputStream entrada;
    private DataOutputStream salida;
        // Archivos
    private String nombre, apellidos, fecha;
    private double monto;
    private ArrayList<SocketCliente> arregloDatos = new ArrayList<>();
    
    // Constructor
    public SocketCliente () {
        // Comunicación Cliente-Servidor
        this.sc = null;
    }
    
    // Métodos
        // Comunicación Cliente-Servidor
    /*
        Este método se encarga de recibir los datos leídos del archivo y enviarlos al servidor.
    */
    private void enviarInformacion (int puerto, String nombre, String apellidos, double precio, String fecha) {
        try {
            sc = new Socket("127.0.0.1", puerto);
            salida = new DataOutputStream(sc.getOutputStream());

            salida.writeUTF(nombre);
            salida.writeUTF(apellidos);
            salida.writeDouble(precio);
            salida.writeUTF(fecha);

            sc.close();
        }
        catch (IOException e) {
            JOptionPane.showMessageDialog(null, "Error al conectar con el servidor\n" + e.getMessage(), "Error", JOptionPane.ERROR_MESSAGE);
        }
    }
    
    public void recibirInformacion (int puerto) {
        while (true) {            
            try {
                sc = new Socket("127.0.0.1", puerto);
                entrada = new DataInputStream(sc.getInputStream());
                
                // Almacena los datos recibidos en un Archivo, para luego poder ser leído en el módulo de Cajas
                DataOutputStream salidaArchivo = new DataOutputStream(new FileOutputStream("tablaCajas.dat", true));
                salidaArchivo.writeUTF(entrada.readUTF());
                salidaArchivo.writeUTF(entrada.readUTF());
                salidaArchivo.writeDouble(entrada.readDouble());
                salidaArchivo.writeUTF(entrada.readUTF());
                
                salidaArchivo.close();
                
                sc.close();
            } 
            catch (IOException e) {
            }
        }
    }
    
        // Archivo
    /* 
        Este método lee el archivo "facturacion.dat" y almacena los atributos relevantes en un arreglo de objetos.
        Luego, mediante el llamado de varios métodos, inicializa sockets para la transferencia de los datos del arreglo hacia el servidor.
    */
    public void leerYEnviarArchivo() {
        try {
            DataInputStream entradaArchivo = new DataInputStream(new FileInputStream("facturacion.dat"));
            while (true) {
                try {
                    // Lee el archivo
                    String nombre = entradaArchivo.readUTF();
                    String apellidos = entradaArchivo.readUTF();
                    String deporte = entradaArchivo.readUTF();          // Ambos valores se almacenan únicamente para \\
                    String descripcion = entradaArchivo.readUTF();     //  seguir el orden de lectura de los archivos. \\
                    double monto = Double.parseDouble(entradaArchivo.readUTF());
                    String fecha = entradaArchivo.readUTF();

                    // Guarda los datos en un arreglo de objetos
                    SocketCliente dato = new SocketCliente();
                    dato.setNombre(nombre);
                    dato.setApellidos(apellidos);
                    dato.setMonto(monto);
                    dato.setFecha(fecha);
                    this.arregloDatos.add(dato);         
                } 
                catch (EOFException e) {
                    entradaArchivo.close();
                    break;
                }
            }
            // Recorre el arreglo
            for (int i = 0; i < arregloDatos.size(); i++) {
                // Por cada objeto, inicializa un hilo para ejecutar el servidor
                // Y se cambia el número de puerto en cada vuelta para que funcione paralelamente
                HiloServidor hiloServidor = new HiloServidor((5432 + i));
                hiloServidor.start();
                // Hace una pequeña pausa para asegurarse que el servidor inicializa por completo
                try {
                    Thread.sleep(1000);
                } 
                catch (InterruptedException ex) {
                }
                // Llama al método encargado de enviar los datos
                // Y se cambia el número de puerto en cada vuelta para que funcione paralelamente
                enviarInformacion((5432 + i), arregloDatos.get(i).getNombre(), arregloDatos.get(i).getApellidos(), arregloDatos.get(i).getMonto(), arregloDatos.get(i).getFecha());
            }
        } catch (FileNotFoundException e) {
        } catch (IOException e) {
        }
    }
    
    // Getters y Setters para atributos relevantes
    public String getNombre() {
        return nombre;
    }
    public void setNombre(String nombre) {
        this.nombre = nombre;
    }
    public String getApellidos() {
        return apellidos;
    }
    public void setApellidos(String apellidos) {
        this.apellidos = apellidos;
    }
    public String getFecha() {
        return fecha;
    }
    public void setFecha(String fecha) {
        this.fecha = fecha;
    }
    public double getMonto() {
        return monto;
    }
    public void setMonto(double monto) {
        this.monto = monto;
    }
}
