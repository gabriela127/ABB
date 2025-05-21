package controller;

import model.ABB;
import view.ABBView;

public class ABBController {
    private final ABB model;
    private final ABBView view;

    public ABBController(ABB model, ABBView view) {
        this.model = model;
        this.view = view;
    }

    public void iniciar() {
        int opcion;
        do {
            opcion = view.mostrarMenuYObtenerOpcion();
            switch (opcion) {
                case 1 -> {
                    int valor = view.pedirValor("Ingrese el valor a insertar: ");
                    model.insertar(valor);
                }
                case 2 -> {
                    int valor = view.pedirValor("Ingrese el valor a buscar: ");
                    boolean encontrado = model.buscar(valor);
                    view.mostrarMensaje(encontrado ? "Encontrado" : "No encontrado");
                }
                case 3 -> {
                    int valor = view.pedirValor("Ingrese el valor a eliminar: ");
                    model.eliminar(valor);
                }
                case 4 -> view.mostrarInorden(model.inorden());
                case 0 -> view.mostrarMensaje("Saliendo...");
                default -> view.mostrarMensaje("Opción inválida");
            }
        } while (opcion != 0);
    }

}
