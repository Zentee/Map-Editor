package org.academiadecodigo.bootcamp.pointer;

import org.academiadecodigo.bootcamp.canvas.Canvas;
import org.academiadecodigo.simplegraphics.keyboard.Keyboard;
import org.academiadecodigo.simplegraphics.keyboard.KeyboardEvent;
import org.academiadecodigo.simplegraphics.keyboard.KeyboardEventType;
import org.academiadecodigo.simplegraphics.keyboard.KeyboardHandler;

public class Controler implements KeyboardHandler {

    private Keyboard keyboard;
    private Pointer pointer;
    private Canvas canvas;
    private Boolean statusSpace = true;

    public Controler(Canvas canvas) {
        keyboard = new Keyboard(this);
        pointer = new Pointer();
        this.canvas = canvas;
    }

    public void init() {
        KeyboardEvent moveRightEvent = new KeyboardEvent();
        moveRightEvent.setKey(KeyboardEvent.KEY_RIGHT);
        moveRightEvent.setKeyboardEventType(KeyboardEventType.KEY_PRESSED);
        keyboard.addEventListener(moveRightEvent);

        KeyboardEvent moveLeftEvent = new KeyboardEvent();
        moveLeftEvent.setKey(KeyboardEvent.KEY_LEFT);
        moveLeftEvent.setKeyboardEventType(KeyboardEventType.KEY_PRESSED);
        keyboard.addEventListener(moveLeftEvent);

        KeyboardEvent moveUpEvent = new KeyboardEvent();
        moveUpEvent.setKey(KeyboardEvent.KEY_UP);
        moveUpEvent.setKeyboardEventType(KeyboardEventType.KEY_PRESSED);
        keyboard.addEventListener(moveUpEvent);

        KeyboardEvent moveDownEvent = new KeyboardEvent();
        moveDownEvent.setKey(KeyboardEvent.KEY_DOWN);
        moveDownEvent.setKeyboardEventType(KeyboardEventType.KEY_PRESSED);
        keyboard.addEventListener(moveDownEvent);

        KeyboardEvent spaceEvent = new KeyboardEvent();
        spaceEvent.setKey(KeyboardEvent.KEY_SPACE);
        spaceEvent.setKeyboardEventType(KeyboardEventType.KEY_PRESSED);
        keyboard.addEventListener(spaceEvent);

        KeyboardEvent spaceContinueEvent = new KeyboardEvent();
        spaceContinueEvent.setKey(KeyboardEvent.KEY_C);
        spaceContinueEvent.setKeyboardEventType(KeyboardEventType.KEY_RELEASED);
        keyboard.addEventListener(spaceContinueEvent);

        KeyboardEvent resetEvent = new KeyboardEvent();
        resetEvent.setKey(KeyboardEvent.KEY_R);
        resetEvent.setKeyboardEventType(KeyboardEventType.KEY_RELEASED);
        keyboard.addEventListener(resetEvent);
    }

    @Override
    public void keyPressed(KeyboardEvent keyboardEvent) {
        if (keyboardEvent.getKey() == KeyboardEvent.KEY_RIGHT) {
            pointer.pointerMoveRigth();
            if(!statusSpace){
                canvas.paint(pointer.getPointRow(), pointer.getPointCollum());
            }
        } else if (keyboardEvent.getKey() == KeyboardEvent.KEY_LEFT) {
            pointer.pointerMoveLeft();
            if(!statusSpace){
                canvas.paint(pointer.getPointRow(), pointer.getPointCollum());
            }
        } else if (keyboardEvent.getKey() == KeyboardEvent.KEY_UP) {
            pointer.pointerMoveUp();
            if(!statusSpace){
                canvas.paint(pointer.getPointRow(), pointer.getPointCollum());
            }
        } else if (keyboardEvent.getKey() == KeyboardEvent.KEY_DOWN) {
            pointer.pointerMoveDown();
            if(!statusSpace){
                canvas.paint(pointer.getPointRow(), pointer.getPointCollum());
            }
        } else if (keyboardEvent.getKey() == KeyboardEvent.KEY_SPACE) {
            canvas.paint(pointer.getPointRow(), pointer.getPointCollum());
        }
    }

    @Override
    public void keyReleased(KeyboardEvent keyboardEvent) {
        if (keyboardEvent.getKey() == KeyboardEvent.KEY_C) {
            if (statusSpace) {
                statusSpace = false;
            } else {
                statusSpace = true;
            }
        } else if (keyboardEvent.getKey() == KeyboardEvent.KEY_R){
            canvas.reset();
        }
    }
}