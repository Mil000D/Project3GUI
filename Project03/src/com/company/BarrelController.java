package com.company;

public class BarrelController extends Thread {
    private BarrelView barrelView;
    private BarrelModel barrelModel;
    private View view;
    private Model model;

    public BarrelController(View view, Model model) {
        this.model = model;
        this.view = view;
        this.barrelModel = new BarrelModel();
        this.barrelView = new BarrelView();
        start();
    }

    public void changeParameters() {

        if (barrelModel.getY() == model.platform5y - 70) {
            barrelView.changeImageBarrel(Direction.FIRE_RIGHT);
        }
        if (barrelModel.getY() == model.platform5y - 70 && barrelModel.getX() == model.platform5width - 30) {
            barrelView.changeImageBarrel(Direction.BARREL_RIGHT);
        }
        if (barrelModel.getY() == model.platform4y - 70 && barrelModel.getX() == model.fire2x) {
            barrelView.changeImageBarrel(Direction.FIRE_LEFT);
        }
        if (barrelModel.getY() == model.platform4y - 70 && barrelModel.getX() == model.platform4x - 90) {
            barrelView.changeImageBarrel(Direction.BARREL_LEFT);
        }
        if (barrelModel.getY() == model.platform2y - 70) {
            barrelView.changeImageBarrel(Direction.FIRE_RIGHT);
        }
        if (barrelModel.getY() == model.platform2y - 70 && barrelModel.getX() == model.platform2width - 30) {
            barrelView.changeImageBarrel(Direction.BARREL_RIGHT);
        }
    }

    private boolean collision() {
        int x = 0;
        if (barrelModel.getFire()) {
            x = 60;
        } else if (!barrelModel.getFire()) {
            x = 30;
        }
        return model.getX() >= barrelModel.getX() - x && model.getX() <= barrelModel.getX() + x && model.getY() >= barrelModel.getY() - x && model.getY() <= barrelModel.getY() + x;
    }

    public void collisionWithModel() {
        if (collision() && barrelModel.getFire()) {
            model.startingPos();
            model.life -= 2;
        } else if (collision() && !barrelModel.getFire()) {
            model.startingPos();
            model.life--;
        }
    }

    public void run() {
        synchronized (view.blist) {
            view.addBarrel(this.barrelView);
        }
        while (!Thread.currentThread().isInterrupted()) {
            barrelModel.move();
            barrelModel.CollisionBarrel(this.model);
            collisionWithModel();
            changeParameters();
            barrelView.updateBarrel(barrelModel.getX(), barrelModel.getY());
            if (barrelModel.getX() >= 1200) {
                view.blist.remove(0);
                Thread.currentThread().interrupt();
            }
            if (model.life <= 0) {
                Thread.currentThread().interrupt();
            }
            if (model.getWin()) {
                Thread.currentThread().interrupt();
            }
            try {
                Thread.sleep(1000 / 60);
            } catch (InterruptedException e) {
                Thread.currentThread().interrupt();
            }
        }
    }
}
