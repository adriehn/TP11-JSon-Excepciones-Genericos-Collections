package Estudiante;

import Curso.Cursos;
import Curso.CursosRepositorio;
import IF.Repository;
import MisExcepciones.MiExcepcion;
import Vista.consola;
import com.google.gson.Gson;

import java.io.*;
public class EstudiantesRepositorio implements Repository {
    Cursos cursos = new Cursos();
    CursosRepositorio cursosRepositorio = new CursosRepositorio();
    private static final String PATH = "src/main/resources/id.json";
    private final Gson gson = new Gson();

    @Override
    public void crear(Object o) throws MiExcepcion {

        cursos.listaEstudiantes.add((Estudiantes) o);
    }

    @Override
    public Object actualizar(Object o, Object u) throws MiExcepcion {
        if (u instanceof consola) {
            if (o instanceof Estudiantes) {

                Integer opcion = ((consola) u).actualizarEstudiante();
                switch (opcion) {
                    case 1:
                        ((Estudiantes) o).setNombre(((consola) u).pedirNombre());
                        break;
                    case 2:
                        ((Estudiantes) o).setEmail(((consola) u).pedirEmail());
                        break;
                }
            }
        }
        return o;
    }

    @Override
    public void eliminar(Object o, Object u) throws MiExcepcion {
        if (o instanceof Cursos)
        {
            if(((Cursos) o).getListaEstudiantes().remove(u))
            {
                System.out.println("Eliminado con exito.");
            }

        }
    }


    @Override
    public Object buscar(Object u) throws MiExcepcion {
        if (u instanceof consola) {
            String key = ((consola) u).pedirCurso();
            Cursos curso = (Cursos) cursosRepositorio.buscar(key);
            Integer id = ((consola) u).pedirID();
            for (Estudiantes estudiante : curso.listaEstudiantes) {
                if (estudiante.getIdAlumno().equals(id)) {
                    Integer opcion = ((consola) u).eliminarActualizar();
                    switch (opcion) {
                        case 1:
                            estudiante = (Estudiantes) actualizar(estudiante, u);
                            break;
                        case 2:
                            eliminar(curso,estudiante);
                            return null;
                    }
                    return estudiante;
                }
            }
        }

        throw new MiExcepcion("No se encontro el Alumno.");
    }

    @Override
    public void verLista() {

    }

    public void guardarId() throws MiExcepcion {
        try (Writer writer = new FileWriter(PATH)) {
            gson.toJson(Estudiantes.getId(), writer);
        } catch (IOException e) {
            throw new MiExcepcion("No pudo guardarse el ulitmo id.");
        }
    }

    public void cargarId() {
        try (Reader reader = new FileReader(PATH)) {
            Integer id = (gson.fromJson(reader, Integer.class));
            if (id == null) {
                id = 0;
            }
            Estudiantes.setId(id);
        } catch (FileNotFoundException e) {
            System.err.println("Error: archivo no encontrado. " + e.getMessage());
        } catch (IOException e) {
            System.err.println("Error: problema de E/S. " + e.getMessage());
        }
    }
}
