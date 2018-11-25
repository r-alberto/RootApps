package ado.edu.itla.sosapp.entidad;

public class Usuario {
    private int id;
    private String nombre;
    private String password;
    private String email;
    private String username;
    private int edad;

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public int getEdad() {
        return edad;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    @Override
    public String toString() {
        return "Usuario{" +
                "id=" + id +
                ", nombre='" + nombre + '\'' +
                ", password='" + password + '\'' +
                ", email='" + email + '\'' +
                ", username='" + username + '\'' +
                ", edad=" + edad +
                '}';
    }

    public void setEdad(int edad) throws Exception {

        if (edad<0 || edad>130) {

            throw new RuntimeException("Edad no permitida.");
        }

        this.edad = edad;



    }
}
