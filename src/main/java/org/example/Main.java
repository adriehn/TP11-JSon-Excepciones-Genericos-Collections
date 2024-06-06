package org.example;

import Curso.CursosRepositorio;
import Curso.GestionCursos;
import Estudiante.EstudianteController;
import Estudiante.Estudiantes;
import Estudiante.EstudiantesRepositorio;
import MisExcepciones.MiExcepcion;
import Vista.consola;

public class Main {
    public static void main(String[] args) throws MiExcepcion {
        consola vista = new consola();
        CursosRepositorio repo = new CursosRepositorio();
        EstudiantesRepositorio repoestu = new EstudiantesRepositorio();

        repoestu.cargarId();
        repo.cargarCursos();
        vista.verCursos();

        //vista.crearAlumno();
        vista.mensajeactualizar();
        //vista.mensajeActualizarCurso();

        vista.verCursos();
        repo.guardarCursos();
        repoestu.guardarId();


    }

}