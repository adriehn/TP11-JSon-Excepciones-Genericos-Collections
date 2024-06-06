package IF;

import MisExcepciones.MiExcepcion;

public interface Repository <T> {

    void crear(T t) throws MiExcepcion ;

    T actualizar(T t, T u) throws MiExcepcion;

    void eliminar(T t ,T u) throws MiExcepcion;

    T buscar ( Object u) throws MiExcepcion;

    void verLista ();
}
