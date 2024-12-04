package centrodepor.t;

public class CatalogoRutinas extends CatalogoDeportes {
    private String descripcionRutina;
    private String duracion;

    public CatalogoRutinas() {
        super();
        this.descripcionRutina = "";
        this.duracion = "";
    }

    // Métodos
    public String getDescripcionRutina() {
        return descripcionRutina;
    }

    public void setDescripcionRutina(String descripcionRutina) {
        this.descripcionRutina = descripcionRutina;
    }

    @Override
    public String getNombreDeporte() {
        return nombreDeporte;
    }

    @Override
    public void setNombreDeporte(String nombreDeporte) {
        this.nombreDeporte = nombreDeporte;
    }

    public String getDuracion() {
        return duracion;
    }

    public void setDuracion(String duracion) {
        this.duracion = duracion;
    }

    @Override
    public String getEstado() {
        return estado;
    }

    @Override
    public void setEstado(String estado) {
        this.estado = estado;
    }
}
