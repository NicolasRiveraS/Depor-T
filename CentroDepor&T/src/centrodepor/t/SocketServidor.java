package centrodepor.t;

import java.io.*;
import java.net.*;
import java.sql.*;
import java.util.*;
import javax.swing.JOptionPane;

public class SocketServidor {
    // Atributos
        // Comunicación Servidor-Cliente
    private Socket sc;
    private ServerSocket ss;
    private DataInputStream entrada;
    private DataOutputStream salida;
    
        // Base de Datos
    private static final String URL = "jdbc:mysql://localhost:3306/BaseDeDatos?zeroDateTimeBehavior=CONVERT_TO_NULL";
    private static final String usuario = "root";
    private static final String clave = "Fidelitasw2!";
    private Statement st;
    private Connection conn;
        // Atributos necesarios para almacenar temporalmente la información
    private String nombre, apellidos, fecha;
    private double monto;
    private ArrayList<SocketServidor> arregloDatos = new ArrayList<>();
    
    // Constructor
    public SocketServidor () {
        // Comunicación Servidor-Cliente
        this.ss = null;
        // Base de Datos
        this.conn = null;
        this.st = null;
    }
    
    // Métodos
        // Comunicación Servidor-Cliente
    /*
        Este método se encarga de recibir los datos relevantes y guardarlos en la base de datos mediante
        el llamado del método "agregarBaseDatos()".
    */
    public void recibirInformacion(int puerto) {
        try {
            ss = new ServerSocket(puerto);
            sc = ss.accept();
            entrada = new DataInputStream(sc.getInputStream());
            
            String nombre = entrada.readUTF();
            String apellidos = entrada.readUTF();
            double monto = entrada.readDouble();
            String fecha = entrada.readUTF();
            
            agregarBaseDatos(nombre, apellidos, monto, fecha);
            
            ss.close();
            sc.close();
            
        } 
        catch (IOException e) {
            JOptionPane.showMessageDialog(null, "Error al recibir datos", "Error", JOptionPane.ERROR_MESSAGE);
        }
    }
    /*
        Este método recibe los datos leídos de la Base y los envía al Cliente.
    */
    private void enviarInformacion (int puerto, String nombre, String apellidos, double precio, String fecha) {
        try {
            ss = new ServerSocket(puerto);
            sc = ss.accept();
            salida = new DataOutputStream(sc.getOutputStream());
            
            salida.writeUTF(nombre);
            salida.writeUTF(apellidos);
            salida.writeDouble(precio);
            salida.writeUTF(fecha);
            
            ss.close();
            sc.close();
        }
        catch (IOException e) {
            JOptionPane.showMessageDialog(null, "Error al conectar\n" + e.getMessage(), "Error", JOptionPane.ERROR_MESSAGE);
        }
    }
    
    
        // Base de Datos
    /*
        Este método recibe los datos relevantes, conecta con la Base de Datos 
        y almacena la información en una tabla.
    */
    private void agregarBaseDatos (String nombre, String apellidos, double monto, String fecha) {
        try {
            conectar();
            
            Statement s = conn.createStatement();
            ResultSet rs = s.executeQuery("SELECT * FROM Cajas WHERE nombre = '" + nombre + "' AND apellidos = '" + apellidos + "'");
            boolean existe = false;
            
            // Recorre la base de datos en busca del valor que se desea agregar
            while (rs.next()) {                
                if (nombre.equals(rs.getString(1)) && apellidos.equals(rs.getString(2))) {
                    existe = true;
                }
            }
                           
            // Si el dato no existe en la base de datos, lo agrega. De lo contrario, no agrega el dato.
            if (!existe) {
                st = conn.createStatement();
                String SQL = "INSERT INTO Cajas (nombre, apellidos, monto, fecha) "
                        + "VALUES ('" + nombre + "', '" + apellidos + "', " + monto + ", '" + fecha + "')";
                int execute = st.executeUpdate(SQL);
            }
            
            desconectar();
        } 
        catch (Exception e) {
            System.out.println("Error al agregar datos\nError: " + e.getMessage());
        }
    }
    
    public void consultarYEnviarBaseDatos () {
        try {
            conectar();
            
            Statement s = conn.createStatement();
            ResultSet rs = s.executeQuery("SELECT * FROM Cajas");
            
            // Almacena los datos leídos de la base de datos en un arreglo de objetos
            while (rs.next()) {                
                SocketServidor dato = new SocketServidor();
                dato.setNombre(rs.getString(1));
                dato.setApellidos(rs.getString(2));
                dato.setMonto(Double.parseDouble(rs.getString(3)));
                dato.setFecha(rs.getString(4));
                
                this.arregloDatos.add(dato);
            }
            desconectar();
            
            // Recorre el arreglo
            for (int i = 0; i < arregloDatos.size(); i++) {
                // Por cada objeto, inicializa un hilo para ejecutar el cliente
                // Y se cambia el número de puerto en cada vuelta para que funcione paralelamente
                HiloCliente hiloCliente = new HiloCliente((5432 + i));
                hiloCliente.start();
                
                // Llama al método encargado de enviar los datos
                // Y se cambia el número de puerto en cada vuelta para que funcione paralelamente
                enviarInformacion((5432 + i), arregloDatos.get(i).getNombre(), arregloDatos.get(i).getApellidos(), arregloDatos.get(i).getMonto(), arregloDatos.get(i).getFecha());
            }
        }
        catch (Exception e) {
        }
    }
     
    // Conectar con la Base de Datos
    private void conectar() {
        try {
            conn = DriverManager.getConnection(URL, usuario, clave);
            System.out.println("¡Conectado!");

        } catch (Exception ex) {
            System.out.println("Error al conectar\nError: " + ex.getMessage());
        }
    }
    
    // Desconectar con la Base de Datos
    private void desconectar() {
        try {
            if (!conn.isClosed()) {
                conn.close();
                System.out.println("¡Desconectado!");
            }
        } catch (Exception ex) {
            System.out.println("Error al desconectar\nError: " + ex.getMessage());
        }
    }
    
    
    // Getters y setters para datos relevantes

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