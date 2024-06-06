package Curso;

import IF.Repository;
import MisExcepciones.MiExcepcion;
import Vista.consola;
import com.google.gson.Gson;
import com.google.gson.reflect.TypeToken;

import java.io.*;
import java.lang.reflect.Type;
import java.util.HashMap;

public class CursosRepositorio implements Repository {

    private static final String PATH = "src/main/resources/Cursos.json";
    private final Gson gson = new Gson();

    @Override
    public void crear(Object o) throws MiExcepcion {
        GestionCursos.mapaCursos.put(((Cursos) o).getCodigo(), ((Cursos) o));
    }

    @Override
    public Object actualizar(Object o, Object u) throws MiExcepcion {

        if (u instanceof consola) {
            String clave = ((consola) u).pedirCurso();
            Cursos curso = (Cursos) buscar(clave);
            curso.setNombre(((consola) u).pedirNombre());
            return curso;

        }
        throw new MiExcepcion("No se pudo actualizar, ya sea porque no existe el curso o se ingreso mal el dato.");
    }

    @Override
    public void eliminar(Object o, Object u) throws MiExcepcion {
        if (u instanceof Cursos)
        {
            if(GestionCursos.mapaCursos.remove(o) != null) {
                System.out.println("Eliminado con exito.");
            }
        }
    }


    @Override
    public Object buscar(Object u) throws MiExcepcion {
        if (u instanceof String) {
            Cursos curso = GestionCursos.mapaCursos.get(u);
            if (curso != null) {
                return curso;
            } else {
                throw new MiExcepcion("No se encontro el Curso.");
            }
        }
        throw new MiExcepcion("Tipo de objeto no válido.");

    }

    @Override
    public void verLista() {
        for (Cursos valor : GestionCursos.mapaCursos.values()) {
            System.out.println(valor);
        }
    }

    public void cargarCursos() {
        try (Reader reader = new FileReader(PATH)) {
            Type typelist = new TypeToken<HashMap<String, Cursos>>() {
            }.getType();
            GestionCursos.mapaCursos = gson.fromJson(reader, typelist);
            if (GestionCursos.mapaCursos == null) {
                GestionCursos.mapaCursos = new HashMap<>();
            }
        } catch (FileNotFoundException e) {
            throw new RuntimeException(e);
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }

    public void guardarCursos() {
        try (Writer writer = new FileWriter(PATH)) {
            gson.toJson(GestionCursos.mapaCursos, writer);

        } catch (IOException e) {
            System.out.println(e.getMessage());
        }
    }


}
