package org.academiadecodigo.bootcamp.canvas;

import org.academiadecodigo.simplegraphics.graphics.Color;
import org.academiadecodigo.simplegraphics.graphics.Rectangle;

public class Canvas {

    Rectangle[][] rectangles;
    private int SIZE = 30;
    private int SCALE = 800;
    private int PADDING = 10;

    public Canvas() {
        showAllRetangles();
    }

    public Canvas(int SIZE) {
        this.SIZE = SIZE;
    }

    public Canvas(int SCALE, int SIZE) {
        this.SIZE = SIZE;
        this.SCALE = SCALE;
        showAllRetangles();
    }

    private void createGrid() {
        rectangles = new Rectangle[SCALE / SIZE][SCALE / SIZE];
        for (int i = 0; i < rectangles.length; i++) {
            for (int j = 0; j < rectangles.length; j++) {
                rectangles[i][j] = new Rectangle(PADDING + (SIZE * i), PADDING + (SIZE * j), SIZE, SIZE);
            }
        }

    }

    private void showAllRetangles() {
        createGrid();
        for (int i = 0; i < rectangles.length; i++) {
            for (int j = 0; j < rectangles.length; j++) {
                rectangles[i][j].draw();
            }
        }
    }

    private Rectangle getRectangle(int row, int collum) {
        return rectangles[collum][row];
    }

    public void reset() {
        for (int i = 0; i < rectangles.length; i++) {
            for (int j = 0; j < rectangles.length; j++) {
                rectangles[i][j].setColor(Color.BLACK);
                rectangles[i][j].draw();
            }
        }
    }

    public void paint(int row, int collum) {
        Rectangle rectangle = getRectangle(row, collum);
        if (rectangle.getColor() == Color.BLACK) {
            rectangle.setColor(Color.DARK_GRAY);
            rectangle.fill();
        } else if (rectangle.getColor() == Color.DARK_GRAY) {
            rectangle.setColor(Color.BLACK);
            rectangle.draw();
        }
    }

    public void continuePaint(int row, int collum){
        Rectangle rectangle = getRectangle(row, collum);
        if (rectangle.getColor() == Color.BLACK) {
            rectangle.setColor(Color.DARK_GRAY);
            rectangle.fill();
        }
    }

    public int getSIZE() {
        return SIZE;
    }

    public int getSCALE() {
        return SCALE;
    }

    public int getPADDING() {
        return PADDING;
    }
}
