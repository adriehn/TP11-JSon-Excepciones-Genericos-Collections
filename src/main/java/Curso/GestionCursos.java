package Curso;

import Estudiante.Estudiantes;
import MisExcepciones.MiExcepcion;
import Vista.consola;

import java.util.HashMap;
import java.util.Map;

public class GestionCursos {

    public static Map<String, Cursos> mapaCursos = new HashMap<>();

    CursosRepositorio cursosRepositorio = new CursosRepositorio();

    public void crearCurso(String key, consola view) throws MiExcepcion {
        String codigo = key;
        String nombre = view.pedirNombre();
        Cursos c = new Cursos(codigo, nombre);
        cursosRepositorio.crear(c);

    }

    public boolean buscarCurso(String key ) throws MiExcepcion {

        return mapaCursos.containsKey(key);

    }


    public Cursos getCurso(String key) {
        return mapaCursos.get(key);
    }

    public void listar() {
        cursosRepositorio.verLista();
    }

    public void actualizarCurso (consola view) throws MiExcepcion {
        cursosRepositorio.actualizar(null,view);
    }
}
