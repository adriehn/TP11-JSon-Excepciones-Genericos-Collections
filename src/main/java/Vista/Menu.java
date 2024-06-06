package Vista;

import MisExcepciones.MiExcepcion;

public class Menu {
    public static void main(String[] args) throws MiExcepcion {

        consola vista = new consola();
        vista.iniciandoPrograma();
        Integer opcion;
        while (true) {

            opcion = vista.MenuPrincipal();

            switch (opcion) {
                case 1:
                    vista.crearAlumno();
                    break;
                case 2:
                    vista.crearCurso();
                    break;
                case 3:
                    vista.mensajeactualizar();
                    break;
                case 4:
                    vista.mensajeActualizarCurso();
                    break;
                case 5:
                    vista.mensajeELiminarCurso();
                    break;
                case 6:
                    vista.verCursos();
                    break;
                case 7:
                    vista.finalizandoprograma();
                    return;
                default:
                    System.out.println("Ingrese una opcion valida");

            }
        }

    }
}
