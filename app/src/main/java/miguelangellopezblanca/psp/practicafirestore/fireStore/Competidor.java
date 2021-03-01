package miguelangellopezblanca.psp.practicafirestore.fireStore;


public class Competidor {

    private String nombre, apellidos, imgCompetidor;
    private int edad;
    private String dni;

    public Competidor(String nombre, String apellidos, int edad, String imgCompetidor, String dni) {
        this.nombre = nombre;
        this.apellidos = apellidos;
        this.imgCompetidor = imgCompetidor;
        this.edad = edad;
        this.dni = dni;
    }

    public Competidor() {
    }

    public String getDni() {
        return dni;
    }

    public void setDni(String dni) {
        this.dni = dni;
    }

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

    public String getImgCompetidor() {
        return imgCompetidor;
    }

    public void setImgCompetidor(String imgCompetidor) {
        this.imgCompetidor = imgCompetidor;
    }

    public int getEdad() {
        return edad;
    }

    public void setEdad(int edad) {
        this.edad = edad;
    }

    @Override
    public String toString() {
        return "Competidor{" +
                "nombre='" + nombre + '\'' +
                ", apellidos='" + apellidos + '\'' +
                ", imgCompetidor='" + imgCompetidor + '\'' +
                ", edad=" + edad +
                ", dni='" + dni + '\'' +
                '}';
    }
}
