package Vista;

import Curso.GestionCursos;
import Estudiante.EstudianteController;
import Estudiante.Estudiantes;
import MisExcepciones.MiExcepcion;

import java.util.Scanner;

public class consola {

    Scanner scanner = new Scanner(System.in);
    EstudianteController control = new EstudianteController();
    GestionCursos gestionCursos = new GestionCursos();

    public consola() {
    }

    public String pedirNombre() throws MiExcepcion {

        System.out.println("Ingrese el nombre: ");
        String nombre = scanner.nextLine();
        if (!control.trycatch(nombre)) {
            System.out.println("Reingrese el dato.");
            nombre = pedirNombre();
        }
        return nombre;
    }

    public String pedirEmail() throws MiExcepcion {

        System.out.println("Ingrese el Email: ");
        String email = scanner.nextLine();
        if (!control.trycatch(email)) {
            email = pedirEmail();
        }
        return email;
    }

    public String perdirCodigo() throws MiExcepcion {

        System.out.println("Ingrese el Codigo: ");
        String codigo = scanner.nextLine();
        if (!control.trycatch(codigo)) {
            codigo = perdirCodigo();
        }
        return codigo;
    }

    public void crearCurso() throws MiExcepcion {
        System.out.println("Ingrese los datos que se le solicitaran");
        gestionCursos.crearCurso(new String(), this);
    }

    public void crearAlumno() throws MiExcepcion {
        System.out.println("Ingrese los datos que se le solicitaran");
        control.crearAlumno(this);
    }

    public void verlista() {
        control.listar();
    }

    public void verCursos() {
        gestionCursos.listar();
    }

    public String pedirCurso()
    {
        System.out.println("Ingrese el codigo de su curso");
        return scanner.nextLine();
    }
    public Integer pedirID()
    {
        System.out.println("Ingrese su ID");
        return scanner.nextInt();
    }

    public Integer actualizarEstudiante()
    {
        System.out.println("Que desea modificar?");
        System.out.println("01. Nombre");
        System.out.println("02. Email");
Integer opcion = scanner.nextInt();
        scanner.nextLine();
        return opcion;
    }

    public Integer actualizarCurso()
    {
        System.out.println("Que desea modificar?");
        System.out.println("01. Nombre");
        Integer opcion = scanner.nextInt();
        scanner.nextLine();
        return opcion;
    }
    public void mensajeActualizarCurso () throws MiExcepcion {
        System.out.println("A continuacion se le pedira el codigo del Curso...");
        gestionCursos.actualizarCurso(this);
    }
    public void mensajeactualizar() throws MiExcepcion {
        System.out.println("A continuacion se le solicitaran datos del curso y del alumno..");
        control.ActualizarAlumno(this);
    }



    public Integer eliminarActualizar()
    {
        System.out.println("Que desea hacer?");
        System.out.println("01. Actualizar");
        System.out.println("02. Eliminar");
        Integer opcion = scanner.nextInt();
        scanner.nextLine();
        return opcion;
    }
}
