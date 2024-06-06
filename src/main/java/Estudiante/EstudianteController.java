package Estudiante;

import Curso.Cursos;
import Curso.GestionCursos;
import MisExcepciones.MiExcepcion;
import Vista.consola;

public class EstudianteController {
    EstudiantesRepositorio estudiantesRepositorio = new EstudiantesRepositorio();
    GestionCursos gestionCursos = new GestionCursos();
    Cursos cursos = new Cursos();

    public boolean trycatch(String atributo) {
        boolean check = false;
        try {
            check = cadenaVacia(atributo);
        } catch (MiExcepcion e) {
            System.err.println("Error: " + e.getMessage());
        }
        return check;
    }

    public boolean cadenaVacia(String dato) throws MiExcepcion {
        if (dato.trim().isEmpty() || dato == null) {
            throw new MiExcepcion("Por favor, ingrese un dato, no pueden haber datos en blanco.");
        }
        return true;
    }

    public void crearAlumno(consola view) throws MiExcepcion {
        String key = view.pedirCurso();
        boolean existe = gestionCursos.buscarCurso(key);
        if (!existe) {
            System.out.println("El curso no existe, vamos a crearlo.");
            try {
                gestionCursos.crearCurso(key, view);
            }
            catch (MiExcepcion excepcion)
            {
                System.out.println(excepcion.getMessage());
            }
        }
        String nombre = view.pedirNombre();
        String email = view.pedirEmail();
        Estudiantes e = new Estudiantes(nombre, email);
        Cursos cursoEncontrado = gestionCursos.getCurso(key);
        cursoEncontrado.agregarEstudiante(e);

    }

    public void listar() {
        estudiantesRepositorio.verLista();
    }

    public void ActualizarAlumno(consola view) throws MiExcepcion {
         estudiantesRepositorio.buscar(view);
    }


}
