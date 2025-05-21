package org.example;

import controller.ABBController;
import model.ABB;
import view.ABBView;

public class Main {
    public static void main(String[] args) {
        ABB model = new ABB();
        ABBView view = new ABBView();
        ABBController controller = new ABBController(model, view);
        controller.iniciar();
    }
}
