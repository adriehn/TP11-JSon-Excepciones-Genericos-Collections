package Curso;

import Estudiante.EstudiantesRepositorio;
import MisExcepciones.MiExcepcion;
import Vista.consola;

import java.util.HashMap;
import java.util.Map;

public class GestionCursos {

    public static Map<String, Cursos> mapaCursos = new HashMap<>();
    EstudiantesRepositorio estudiantesRepositorio = new EstudiantesRepositorio();
    CursosRepositorio cursosRepositorio = new CursosRepositorio();

    public void crearCurso(String key, consola view) throws MiExcepcion {
        String codigo = key;
        String nombre = view.pedirNombre();
        Cursos c = new Cursos(codigo, nombre);
        cursosRepositorio.crear(c);
    }

    public boolean buscarCurso(String key) throws MiExcepcion {
        return mapaCursos.containsKey(key);
    }

    public Cursos getCurso(String key) {
        return mapaCursos.get(key);
    }

    public void listar() {
        cursosRepositorio.verLista();
    }

    public void actualizarCurso(consola view) throws MiExcepcion {
        cursosRepositorio.actualizar(null, view);
    }

    public void eliminarCurso(consola view) throws MiExcepcion {
        String key = view.pedirCurso();
        if (buscarCurso(key)) {
            Cursos curso = getCurso(key);
            cursosRepositorio.eliminar(key, curso);
        }

    }

    public void prepararInicio() {
        cursosRepositorio.cargarCursos();
        estudiantesRepositorio.cargarId();
    }

    public void finalizacionDelPrograma() throws MiExcepcion {
        cursosRepositorio.guardarCursos();
        try {
            estudiantesRepositorio.guardarId();
        } catch (MiExcepcion e) {
            throw new RuntimeException(e);
        }
    }
}
