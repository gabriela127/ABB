package model;

public class ABB {
    private NodoABB raiz;

    public void insertar(int valor) {
        raiz = insertarRec(raiz, valor);
    }

    private NodoABB insertarRec(NodoABB nodo, int valor) {
        if (nodo == null) return new NodoABB(valor);
        if (valor < nodo.valor) nodo.izquierda = insertarRec(nodo.izquierda, valor);
        else if (valor > nodo.valor) nodo.derecha = insertarRec(nodo.derecha, valor);
        return nodo;
    }

    public boolean buscar(int valor) {
        return buscarRec(raiz, valor);
    }

    private boolean buscarRec(NodoABB nodo, int valor) {
        if (nodo == null) return false;
        if (valor == nodo.valor) return true;
        return valor < nodo.valor ? buscarRec(nodo.izquierda, valor) : buscarRec(nodo.derecha, valor);
    }

    public void eliminar(int valor) {
        raiz = eliminarRec(raiz, valor);
    }

    private NodoABB eliminarRec(NodoABB nodo, int valor) {
        if (nodo == null) return null;
        if (valor < nodo.valor) nodo.izquierda = eliminarRec(nodo.izquierda, valor);
        else if (valor > nodo.valor) nodo.derecha = eliminarRec(nodo.derecha, valor);
        else {
            if (nodo.izquierda == null) return nodo.derecha;
            if (nodo.derecha == null) return nodo.izquierda;
            nodo.valor = valorMinimo(nodo.derecha);
            nodo.derecha = eliminarRec(nodo.derecha, nodo.valor);
        }
        return nodo;
    }

    private int valorMinimo(NodoABB nodo) {
        while (nodo.izquierda != null)
            nodo = nodo.izquierda;
        return nodo.valor;
    }

    public String inorden() {
        StringBuilder sb = new StringBuilder();
        inordenRec(raiz, sb);
        return sb.toString().trim();
    }

    private void inordenRec(NodoABB nodo, StringBuilder sb) {
        if (nodo != null) {
            inordenRec(nodo.izquierda, sb);
            sb.append(nodo.valor).append(" ");
            inordenRec(nodo.derecha, sb);
        }
    }

}
