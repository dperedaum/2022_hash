import java.util.Objects;

public class Persona {

    private Long cedula;

    private String nombre;

    private String direccion;

    public Persona(Long cedula, String nombre, String direccion) {
        this.cedula = cedula;
        this.nombre = nombre;
        this.direccion = direccion;
    }

    public Long getCedula() {
        return cedula;
    }

    public String getNombre() {
        return nombre;
    }

    public String getDireccion() {
        return direccion;
    }

    @Override
    public int hashCode() {
        return cedula.hashCode() + nombre.hashCode();
    }
}
