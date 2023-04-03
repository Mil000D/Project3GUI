package com.company;

public class BarrelModel {
    private int x = 30;
    private int y = 0;
    private int dx = 0;
    private int dy = 10;
    private boolean fire = false;

    public void move() {
        x += dx;
        y += dy;
    }

    public int getX() {
        return x;
    }

    public int getY() {
        return y;
    }

    public void CollisionBarrel(Model model) {
        if (y == model.platform5y - 70) {
            dx = 5;
            dy = 0;
            fire = true;
        }
        if (y == model.platform5y - 70 && x == model.platform5width - 30) {
            dx = 0;
            dy = 10;
            fire = false;
        }
        if (y == model.platform4y - 70 && x == model.platform5width - 30 && !fire) {
            dx = 5;
            dy = 0;
        }
        if (y == model.platform4y - 70 && x == model.fire2x) {
            dx = -5;
            dy = 0;
            fire = true;
        }
        if (y == model.platform4y - 70 && x == model.platform4x - 90) {
            dx = 0;
            dy = 10;
            fire = false;
        }
        if (y == model.platform2y - 70) {
            dx = 5;
            dy = 0;
            fire = true;
        }
        if (y == model.platform2y - 70 && x == model.platform2width - 30) {
            dx = 0;
            dy = 10;
            fire = false;
        }
        if (y == model.platform1y - 70) {
            dx = 5;
            dy = 0;
        }
    }

    public boolean getFire() {
        return fire;
    }
}
