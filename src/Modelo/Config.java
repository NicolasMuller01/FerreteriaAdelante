
package Modelo;

public class Config {
    private int id;
    private int dni;
    private String nombre;
    private String telefono;
    private String direccion;
    private String RS;
    
    public Config(){}

    public Config(int id, int dni, String nombre, String telefono, String direccion, String RS) {
        this.id = id;
        this.dni = dni;
        this.nombre = nombre;
        this.telefono = telefono;
        this.direccion = direccion;
        this.RS = RS;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public int getDni() {
        return dni;
    }

    public void setDni(int dni) {
        this.dni = dni;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public String getTelefono() {
        return telefono;
    }

    public void setTelefono(String telefono) {
        this.telefono = telefono;
    }

    public String getDireccion() {
        return direccion;
    }

    public void setDireccion(String direccion) {
        this.direccion = direccion;
    }

    public String getRS() {
        return RS;
    }

    public void setRS(String RS) {
        this.RS = RS;
    }
    
    
}
