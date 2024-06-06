package Estudiante;
public class Estudiantes {

    private static Integer id = 0;
    private String nombre;
    private String email;
    private Integer idAlumno;

    @Override
    public String toString() {
        return " IdAlumno : " + idAlumno + "|Nombre: " + nombre + " "+
                " - Email: " + email;
    }

    public Estudiantes(String nombre, String email) {
        this.nombre = nombre;
        this.email = email;
        this.idAlumno = ++id;
    }

    public Estudiantes() {
    }


    public static Integer getId() {
        return id;
    }

    public static void setId(Integer id) {
        Estudiantes.id = id;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public Integer getIdAlumno() {
        return idAlumno;
    }

    public void setIdAlumno(Integer idAlumno) {
        this.idAlumno = idAlumno;
    }
}
