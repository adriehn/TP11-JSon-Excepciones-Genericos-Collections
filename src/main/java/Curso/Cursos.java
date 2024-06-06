package Curso;

import Estudiante.Estudiantes;

import java.util.HashSet;
import java.util.Set;

public class Cursos {
    private String codigo;
    private String nombre;

    public  Set<Estudiantes> listaEstudiantes ;

    public Cursos(String codigo, String nombre) {
        this.codigo = codigo;
        this.nombre = nombre;
        this.listaEstudiantes  = new HashSet<>();
    }

    public Cursos() {
    }

    public Set<Estudiantes> getListaEstudiantes() {
        return listaEstudiantes;
    }

    public void setListaEstudiantes(Set<Estudiantes> listaEstudiantes) {
        this.listaEstudiantes = listaEstudiantes;
    }

    public String getCodigo() {
        return codigo;
    }

    public void setCodigo(String codigo) {
        this.codigo = codigo;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    @Override
    public String toString() {
        return "||| Codigo de Curso ||| " + codigo +" |||"+
                " - Nombre de Curso: " + nombre +"        "+
                " *|ListaEstudiantes: " + listaEstudiantes +
                '}';
    }
    public void agregarEstudiante(Estudiantes estudiante) {
        if (listaEstudiantes == null)
        {
            listaEstudiantes = new HashSet<>();
        }
        listaEstudiantes.add(estudiante);
    }



}
