package org.academiadecodigo.bootcamp.pointer;

import org.academiadecodigo.bootcamp.canvas.Canvas;
import org.academiadecodigo.simplegraphics.graphics.Color;
import org.academiadecodigo.simplegraphics.graphics.Rectangle;

public class Pointer {

    Canvas canvas;
    Rectangle pointer;
    int pointRow = 0;
    int pointCollum = 0;

    public Pointer(){
        canvas = new Canvas();
        pointer = new Rectangle(canvas.getPADDING(),canvas.getPADDING(),canvas.getSIZE(),canvas.getSIZE());
        pointer.fill();
        pointer.setColor(Color.GREEN);
    }

    protected void pointerMoveRigth(){
        if(pointer.getX() < (canvas.getSCALE() / canvas.getSIZE()) * (canvas.getSIZE()) - canvas.getSIZE()){
            pointer.translate(canvas.getSIZE(),0);
            pointCollum = pointCollum + 1;
        }
    }

    protected void pointerMoveLeft(){
        if(pointer.getX() > canvas.getPADDING()){
            pointer.translate(-canvas.getSIZE(),0);
            pointCollum = pointCollum - 1;
        }
    }

    protected void pointerMoveUp() {
        if (pointer.getY() > canvas.getPADDING()) {
            pointer.translate(0, -canvas.getSIZE());
            pointRow = pointRow + 1;
        }
    }

    protected void pointerMoveDown() {
        if (pointer.getY() < (canvas.getSCALE() / canvas.getSIZE()) * (canvas.getSIZE()) - canvas.getSIZE()) {
            pointer.translate(0, canvas.getSIZE());
            pointRow = pointRow - 1;
        }
    }

    protected int getPointRow(){
        return Math.abs(pointRow);
    }

    protected int getPointCollum(){
        return Math.abs(pointCollum);
    }

    protected int getX() {
        return pointer.getX();
    }

    protected int getY() {
        return pointer.getY();
    }

}
