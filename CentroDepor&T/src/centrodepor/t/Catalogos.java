package centrodepor.t;

public abstract class Catalogos {
    // Atributos
    protected String nombre;
    protected String primerApellido;
    protected String segundoApellido;
    protected String ciudad;
    protected String direccion;
    protected String telefono;
    protected String correo;
    protected String estado;
    
    // Constructor
    public Catalogos() {
        this.nombre = "";
        this.primerApellido = "";
        this.segundoApellido = "";
        this.ciudad = "";
        this.direccion = "";
        this.telefono = "";
        this.correo = "";
        this.estado = "";
    }
}