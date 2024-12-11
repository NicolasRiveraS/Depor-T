package centrodepor.t;

public class Usuario {
    // Atributos
    private String nombre;
    private String ape1;//primer apellido
    private String ape2;//segundo apellido
    private String nickname;//nombre usuario
    private String password;
    private String estado;//Activo o inactivo
    private String categ;//deportista, padres de familia o entrenador

    // Constructor
    public Usuario() {
        this.nombre = "";
        this.ape1 = "";
        this.ape2 = "";
        this.nickname = "";
        this.password = "";
        this.estado = "";
        this.categ = "";
    }
    
    // Métodos

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public String getApe1() {
        return ape1;
    }

    public void setApe1(String ape1) {
        this.ape1 = ape1;
    }

    public String getApe2() {
        return ape2;
    }

    public void setApe2(String ape2) {
        this.ape2 = ape2;
    }

    public String getNickname() {
        return nickname;
    }

    public void setNickname(String nickname) {
        this.nickname = nickname;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public String getEstado() {
        return estado;
    }

    public void setEstado(String estado) {
        this.estado = estado;
    }

    public String getCateg() {
        return categ;
    }

    public void setCateg(String categ) {
        this.categ = categ;
    }

    String getApellido() {
        throw new UnsupportedOperationException("Not supported yet."); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/GeneratedMethodBody
    }
    
}
