package com.company;

import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;


public class Controller extends Thread {

    private View View;
    private Model Model;


    public Controller() {
        this.Model = new Model();
        this.View = new View(Model.platform1x, Model.platform1y, Model.platform1width,
                Model.platform2x, Model.platform2y, Model.platform2width,
                Model.platform3x, Model.platform3y, Model.platform3width,
                Model.platform4x, Model.platform4y, Model.platform4width,
                Model.platform5x, Model.platform5y, Model.platform5width,
                Model.platform6x, Model.platform6y, Model.platform6width,
                Model.platform7x, Model.platform7y, Model.platform7width,
                Model.platform8x, Model.platform8y, Model.platform8width,
                Model.fire1x, Model.fire1y,
                Model.fire2x, Model.fire2y,
                Model.fire3x, Model.fire3y,
                Model.ladder2x, Model.ladder2y,
                Model.doorx, Model.doory,
                Model.barrelelevx, Model.barrelelevy,
                Model.width, Model.height, Model.pistonx);

        this.View.addKeyListener(new KeyListener() {
            @Override
            public void keyTyped(KeyEvent e) {
            }

            @Override
            public void keyPressed(KeyEvent e) {
                int key = e.getKeyCode();


                if (key == KeyEvent.VK_LEFT) {
                    if (!Model.getLadder() && Model.getY() != Model.getGround()) {
                        View.changeImage(Direction.UP_LEFT);
                    }
                    Model.updateDirection(Direction.LEFT_RUNNING);
                    Model.right = false;
                    Model.left = true;
                    Model.running = true;

                }

                if (key == KeyEvent.VK_RIGHT) {
                    if (!Model.getLadder() && Model.getY() != Model.getGround()) {
                        View.changeImage(Direction.UP_RIGHT);
                    }
                    Model.updateDirection(Direction.RIGHT_RUNNING);
                    Model.right = true;
                    Model.left = false;
                    Model.running = true;
                }

                if (key == KeyEvent.VK_UP && Model.left) {
                    Model.updateDirection(Direction.UP_LEFT);

                    View.changeImage(Direction.UP_LEFT);


                }
                if (key == KeyEvent.VK_UP && Model.right) {
                    Model.updateDirection(Direction.UP_RIGHT);

                    View.changeImage(Direction.UP_RIGHT);

                }
                if (key == KeyEvent.VK_UP && Model.getLadder()) {
                    Model.updateDirection(Direction.UP_LADDER_MOVING);
                    View.changeImage(Direction.UP_LADDER_MOVING);

                }

                if (key == KeyEvent.VK_DOWN && Model.getLadder()) {
                    Model.updateDirection(Direction.DOWN_LADDER_MOVING);
                    View.changeImage(Direction.DOWN_LADDER_MOVING);

                }
                if (key == KeyEvent.VK_DOWN && !Model.getLadder()) {
                    Model.updateDirection(Direction.DOWN);

                }
            }

            @Override
            public void keyReleased(KeyEvent e) {
                int key = e.getKeyCode();
                if (key == KeyEvent.VK_LEFT) {
                    if (!Model.getLadder() && Model.getY() != Model.getGround()) {
                        View.changeImage(Direction.UP_LEFT);
                    }
                    Model.updateDirection(Direction.LEFT_STANDING);
                    Model.right = false;
                    Model.left = true;
                    Model.running = false;
                }

                if (key == KeyEvent.VK_RIGHT) {

                    if (!Model.getLadder() && Model.getY() != Model.getGround()) {
                        View.changeImage(Direction.UP_RIGHT);
                    }
                    Model.updateDirection(Direction.RIGHT_STANDING);
                    Model.right = true;
                    Model.left = false;
                    Model.running = false;

                }

                if (key == KeyEvent.VK_UP && Model.getLadder()) {
                    Model.updateDirection(Direction.UP_LADDER_STANDING);
                    View.changeImage(Direction.UP_LADDER_STANDING);

                }

                if (key == KeyEvent.VK_DOWN && Model.getLadder()) {
                    Model.updateDirection(Direction.DOWN_LADDER_STANDING);
                    View.changeImage(Direction.DOWN_LADDER_STANDING);
                }
                if (key == KeyEvent.VK_UP && !Model.getLadder() && Model.right) {
                    View.changeImage(Direction.UP_RIGHT);
                }
                if (key == KeyEvent.VK_UP && !Model.getLadder() && Model.left) {
                    View.changeImage(Direction.UP_LEFT);
                }


            }
        });
        Thread barrelcontroller = new Thread(new Runnable() {
            @Override
            public void run() {
                while (!Thread.currentThread().isInterrupted()) {
                    new BarrelController(View, Model);
                    if (Model.getWin()) {
                        Thread.currentThread().interrupt();
                    }
                    if (Model.life <= 0) {
                        Thread.currentThread().interrupt();
                    }
                    try {
                        Thread.sleep(2500);
                    } catch (InterruptedException e) {
                        Thread.currentThread().interrupt();
                    }
                }
            }
        });
        barrelcontroller.start();
        this.start();

    }

    public void run() {
        while (!Thread.currentThread().isInterrupted()) {
            Model.move();
            Model.Collision();
            Model.piston++;
            onGround();
            View.updatePiston(Model.pistonBool);
            View.updateDoor(Model.dooropen);
            if (Model.piston == 600) {
                Model.piston = 0;
                Model.pistonBool = false;
            }
            if (Model.piston == 300) {
                Model.pistonBool = true;
            }

            View.updateView(Model.getX(), Model.getY());
            View.updateLife(Model.life);
            View.repaint();
            if (Model.getWin()) {
                View.gameWon(Model.bestTime, Model.timeOfGame);
                Thread.currentThread().interrupt();
            }
            if (Model.life <= 0) {
                View.gameLost();
                Thread.currentThread().interrupt();
            }
            try {
                Thread.sleep(1000 / 60);
            } catch (InterruptedException e) {
                Thread.currentThread().interrupt();
            }
        }
    }

    public void onGround() {
        if (Model.getGround() == Model.getY() && Model.left && !Model.running) {
            View.changeImage(Direction.LEFT_STANDING);
        }
        if (Model.getGround() == Model.getY() && Model.right && !Model.running) {
            View.changeImage(Direction.RIGHT_STANDING);
        }
        if (Model.getGround() == Model.getY() && Model.left && Model.running) {
            View.changeImage(Direction.LEFT_RUNNING);
        }
        if (Model.getGround() == Model.getY() && Model.right && Model.running) {
            View.changeImage(Direction.RIGHT_RUNNING);
        }
    }


}