package ru.job4j.threads;

import javafx.scene.shape.Rectangle;

public class RectangleMove implements Runnable {
    private final Rectangle rect;

    public RectangleMove(Rectangle rect) {
        this.rect = rect;
    }

//    @Override
//    public void run() {
//        while (true) {
//            this.rect.setX(this.rect.getX() + 1);
//            try {
//                Thread.sleep(50);
//            } catch (InterruptedException e) {
//                e.printStackTrace();
//            }
//        }
//    }


    @Override
    public void run() {
        int x = 5;
        int y = 2;
        while (!Thread.currentThread().isInterrupted()) {
            this.rect.setX(this.rect.getX() + x);
            if (this.rect.getX() == 300 || this.rect.getX() == 0) {
                x *= -1;
            }
            this.rect.setY(this.rect.getY() + y);
            if (this.rect.getY() == 300 || this.rect.getY() == 0) {
                y *= -1;
            }
            try {
                Thread.sleep(50);
            } catch (InterruptedException e) {
                Thread.currentThread().interrupt();
            }
        }
    }
}