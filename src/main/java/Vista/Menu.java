package Vista;

import Curso.Cursos;
import Curso.CursosRepositorio;
import Curso.GestionCursos;
import Estudiante.Estudiantes;
import Estudiante.EstudiantesRepositorio;
import MisExcepciones.MiExcepcion;

public class Menu {

    public static void main(String[] args) throws MiExcepcion {

        consola vista = new consola();
        CursosRepositorio repo = new CursosRepositorio();
        EstudiantesRepositorio repoestu = new EstudiantesRepositorio();


        vista.iniciandoPrograma();
        Integer opcion;
        while (true) {

            opcion = vista.MenuPrincipal();

            switch (opcion) {
                case 1:
                    vista.crearAlumno();
                    break;
                case 2:
                    vista.mensajeactualizar();
                    break;
                case 3:
                    vista.mensajeActualizarCurso();
                    break;
                case 4:
                    vista.mensajeELiminarCurso();
                    break;
                case 5:
                    vista.verCursos();
                    break;
                case 6:
                    vista.finalizandoprograma();
                    return;
                default:
                    System.out.println("Ingrese una opcion valida");

            }
        }

    }
}
