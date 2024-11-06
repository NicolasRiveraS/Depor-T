package centrodepor.t;

public class CatalogoRutinas {
    private String descripcion;
    private String deporte;
    private int duracion;
    private String estado;

    public CatalogoRutinas() {
        this.descripcion = "";
        this.deporte = "";
        this.duracion = 0;
        this.estado = "Activo";
    }

    // Métodos
    public String getDescripcion() {
        return descripcion;
    }

    public void setDescripcion(String descripcion) {
        this.descripcion = descripcion;
    }

    public String getDeporte() {
        return deporte;
    }

    public void setDeporte(String deporte) {
        this.deporte = deporte;
    }

    public int getDuracion() {
        return duracion;
    }

    public void setDuracion(int duracion) {
        this.duracion = duracion;
    }

    public String getEstado() {
        return estado;
    }

    public void setEstado(String estado) {
        this.estado = estado;
    }
}
