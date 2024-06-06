package IF;

import Curso.Cursos;
import MisExcepciones.MiExcepcion;
import com.google.gson.internal.bind.ObjectTypeAdapter;

public interface Repository <T> {

    void crear(T t) throws MiExcepcion ;

    T actualizar(T t, T u) throws MiExcepcion;

    void eliminar(T t ,T u) throws MiExcepcion;

    T buscar ( Object u) throws MiExcepcion;

    void verLista ();
}
