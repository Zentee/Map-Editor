package org.academiadecodigo.bootcamp;

import org.academiadecodigo.bootcamp.canvas.Canvas;
import org.academiadecodigo.bootcamp.pointer.Controler;

public class Main {
    public static void main(String[] args) {
        Canvas canvas = new Canvas();
        Controler controler = new Controler(canvas);
        controler.init();
    }
}
