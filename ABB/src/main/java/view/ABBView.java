package view;

import java.util.Scanner;

public class ABBView {
    private final Scanner scanner = new Scanner(System.in);

    public int mostrarMenuYObtenerOpcion() {
        System.out.println("\n--- Menú Árbol Binario ---");
        System.out.println("1. Insertar");
        System.out.println("2. Buscar");
        System.out.println("3. Eliminar");
        System.out.println("4. Mostrar inorden");
        System.out.println("0. Salir");
        System.out.print("Opción: ");
        return scanner.nextInt();
    }

    public int pedirValor(String mensaje) {
        System.out.print(mensaje);
        return scanner.nextInt();
    }

    public void mostrarMensaje(String mensaje) {
        System.out.println(mensaje);
    }

    public void mostrarInorden(String recorrido) {
        System.out.println("Recorrido inorden: " + recorrido);
    }

}
