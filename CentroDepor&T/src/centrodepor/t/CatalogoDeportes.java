package centrodepor.t;

public class CatalogoDeportes {
    private String nombre;
    private String caracteristicas;
    private String estado;

    public CatalogoDeportes() {
        this.nombre = "";
        this.caracteristicas = "";
        this.estado = "Activo";
    }

    // Métodos
    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public String getCaracteristicas() {
        return caracteristicas;
    }

    public void setCaracteristicas(String caracteristicas) {
        this.caracteristicas = caracteristicas;
    }

    public String getEstado() {
        return estado;
    }

    public void setEstado(String estado) {
        this.estado = estado;
    }
}
