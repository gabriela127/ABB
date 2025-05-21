package model;

import org.junit.Before;
import org.junit.Test;

import static org.junit.Assert.*;

public class ABBTest {
    private ABB arbol;

    @Before
    public void setUp() throws Exception {
        arbol = new ABB();
        arbol.insertar(50);
        arbol.insertar(30);
        arbol.insertar(70);
        arbol.insertar(20);
        arbol.insertar(40);
        arbol.insertar(60);
        arbol.insertar(80);
    }

    @Test
    public void testInsertarYBuscar() {
        assertTrue(arbol.buscar(50));
        assertTrue(arbol.buscar(30));
        assertTrue(arbol.buscar(80));
        assertFalse(arbol.buscar(100));
    }

    @Test
    public void testEliminarHoja() {
        arbol.eliminar(20); // hoja
        assertFalse(arbol.buscar(20));
    }

    @Test
    public void testEliminarNodoConUnHijo() {
        arbol.eliminar(30); // tiene hijo izquierdo (20) y derecho (40)
        assertFalse(arbol.buscar(30));
        assertTrue(arbol.buscar(20));
        assertTrue(arbol.buscar(40));
    }

    @Test
    public void testEliminarNodoConDosHijos() {
        arbol.eliminar(50); // raíz con dos hijos
        assertFalse(arbol.buscar(50));
    }

    @Test
    public void testInorden() {
        String esperado = "20 30 40 50 60 70 80";
        assertEquals(esperado, arbol.inorden());
    }
}