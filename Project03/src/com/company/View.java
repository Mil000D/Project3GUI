
package com.company;

import java.awt.*;
import java.util.ArrayList;
import java.util.List;


import javax.swing.*;

public class View extends JPanel {

    private final JFrame frame = new JFrame();
    private Image character;
    private final Image platform1;
    private final Image platform2;
    private final Image platform3;
    private final Image platform4;
    private final Image platform5;
    private final Image platform6;
    private final Image platform7;
    private final Image platform8;
    private final Image ladder;
    private final Image ladder2;
    private final Image fire;
    private final Image heart;
    private final Image door;
    private final Image barrelelev;
    private final Image opendoorIm;
    private final Image pistonIm;

    private final int platform1x;
    private final int platform1y;
    private final int platform2x;
    private final int platform2y;
    private final int platform3x;
    private final int platform3y;
    private final int platform4x;
    private final int platform4y;
    private final int platform5x;
    private final int platform5y;
    private final int platform6x;
    private final int platform6y;
    private final int platform7x;
    private final int platform7y;
    private final int platform8x;
    private final int platform8y;
    private final int fire1x;
    private final int fire1y;
    private final int fire2x;
    private final int fire2y;
    private final int fire3x;
    private final int fire3y;
    private final int ladder2x;
    private final int ladder2y;
    private final int doorx;
    private final int doory;
    private final int barrelelevx;
    private final int barrelelevy;
    private final int frameWidth;
    private final int frameHeight;
    private final int pistonx;
    private int x;
    private int y;
    private int life;
    private boolean opendoor;
    private boolean piston;

    public List<BarrelView> blist;


    public View(int platform1x, int platform1y, int platform1width,
                int platform2x, int platform2y, int platform2width,
                int platform3x, int platform3y, int platform3width,
                int platform4x, int platform4y, int platform4width,
                int platform5x, int platform5y, int platform5width,
                int platform6x, int platform6y, int platform6width,
                int platform7x, int platform7y, int platform7width,
                int platform8x, int platform8y, int platform8width,
                int fire1x, int fire1y,
                int fire2x, int fire2y,
                int fire3x, int fire3y,
                int ladder2x, int ladder2y,
                int doorx, int doory,
                int barrelelevx, int barrelelevy,
                int width, int height,
                int pistonx) {
        this.platform1x = platform1x;
        this.platform1y = platform1y;
        this.platform2x = platform2x;
        this.platform2y = platform2y;
        this.platform3x = platform3x;
        this.platform3y = platform3y;
        this.platform4x = platform4x;
        this.platform4y = platform4y;
        this.platform5x = platform5x;
        this.platform5y = platform5y;
        this.platform6x = platform6x;
        this.platform6y = platform6y;
        this.platform7x = platform7x;
        this.platform7y = platform7y;
        this.platform8x = platform8x;
        this.platform8y = platform8y;
        this.fire1x = fire1x;
        this.fire1y = fire1y;
        this.fire2x = fire2x;
        this.fire2y = fire2y;
        this.fire3x = fire3x;
        this.fire3y = fire3y;
        this.ladder2x = ladder2x;
        this.ladder2y = ladder2y;
        this.barrelelevx = barrelelevx;
        this.barrelelevy = barrelelevy;
        this.doorx = doorx;
        this.doory = doory;
        this.frameWidth = width;
        this.frameHeight = height;
        this.pistonx = pistonx;


        this.blist = new ArrayList<>();


        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setSize(width, height);
        frame.setResizable(false);
        setVisible(true);
        setSize(width, height);
        setBackground(Color.white);
        setFocusable(true);

        ImageIcon i = new ImageIcon("Images/Standing - right.png");
        character = i.getImage();
        ImageIcon p1 = new ImageIcon("Images/platform.png");
        platform1 = p1.getImage().getScaledInstance(platform1width, 50, Image.SCALE_SMOOTH);
        ImageIcon p2 = new ImageIcon("Images/platform.png");
        platform2 = p2.getImage().getScaledInstance(platform2width, 50, Image.SCALE_SMOOTH);
        ImageIcon p3 = new ImageIcon("Images/platform.png");
        platform3 = p3.getImage().getScaledInstance(platform3width, 50, Image.SCALE_SMOOTH);
        ImageIcon p4 = new ImageIcon("Images/platform.png");
        platform4 = p4.getImage().getScaledInstance(platform4width, 50, Image.SCALE_SMOOTH);
        ImageIcon p5 = new ImageIcon("Images/platform.png");
        platform5 = p5.getImage().getScaledInstance(platform5width, 50, Image.SCALE_SMOOTH);
        ImageIcon p6 = new ImageIcon("Images/platform.png");
        platform6 = p6.getImage().getScaledInstance(platform6width, 50, Image.SCALE_SMOOTH);
        ImageIcon p7 = new ImageIcon("Images/platform.png");
        platform7 = p7.getImage().getScaledInstance(platform7width, 50, Image.SCALE_SMOOTH);
        ImageIcon l = new ImageIcon("Images/ladder.png");
        ladder = l.getImage();
        ImageIcon l2 = new ImageIcon("Images/ladder2.png");
        ladder2 = l2.getImage();
        ImageIcon f = new ImageIcon("Images/Fire.png");
        fire = f.getImage();
        ImageIcon h = new ImageIcon("Images/heart.png");
        heart = h.getImage();
        ImageIcon d = new ImageIcon("Images/door.png");
        door = d.getImage();
        ImageIcon op = new ImageIcon("Images/opendoor.png");
        opendoorIm = op.getImage();
        ImageIcon be = new ImageIcon("Images/barrelelev.png");
        barrelelev = be.getImage();
        ImageIcon p8 = new ImageIcon("Images/platform.png");
        platform8 = p8.getImage().getScaledInstance(platform8width, 50, Image.SCALE_SMOOTH);
        ImageIcon p = new ImageIcon("Images/piston.png");
        pistonIm = p.getImage();


        frame.add(this);
        frame.setVisible(true);
        frame.setLocationRelativeTo(null);


    }

    public void addBarrel(BarrelView barrelView) {
        this.blist.add(barrelView);
    }

    public void updateLife(int life) {
        this.life = life;
    }

    public void updateView(int x, int y) {
        this.x = x;
        this.y = y;
    }

    public void updatePiston(boolean piston) {
        this.piston = piston;
    }

    public void updateDoor(boolean opendoor) {
        this.opendoor = opendoor;
    }

    public void gameWon(long bestTime, long currentTime) {
        frame.dispose();
        JFrame framewon = new JFrame();
        JPanel panel = new JPanel() {
            @Override
            protected void paintComponent(Graphics g) {
                super.paintComponent(g);
                g.setFont(new Font("Serif", Font.PLAIN, 200));
                g.drawString("You won", 200, 400);
                g.setFont(new Font("Serif", Font.PLAIN, 100));
                g.drawString("Best time : " + bestTime + " seconds", 150, 550);
                g.drawString("New time : " + currentTime + " seconds", 150, 650);

            }
        };
        framewon.add(panel);
        framewon.setVisible(true);
        framewon.setSize(frameWidth, frameHeight);
        framewon.setResizable(false);
        framewon.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        framewon.setLocationRelativeTo(null);
    }

    public void gameLost() {
        frame.dispose();
        JFrame framewon = new JFrame();
        JPanel panel = new JPanel() {
            @Override
            protected void paintComponent(Graphics g) {
                super.paintComponent(g);
                g.setFont(new Font("Serif", Font.PLAIN, 200));
                g.drawString("You lost", 200, 500);

            }
        };
        framewon.add(panel);
        framewon.setVisible(true);
        framewon.setSize(frameWidth, frameHeight);
        framewon.setResizable(false);
        framewon.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        framewon.setLocationRelativeTo(null);
    }

    public void changeImage(Direction direction) {
        if (direction == Direction.LEFT_RUNNING) {
            ImageIcon i = new ImageIcon("Images/Running - left.png");
            character = i.getImage();
        }
        if (direction == Direction.RIGHT_RUNNING) {
            ImageIcon i = new ImageIcon("Images/Running - right.png");
            character = i.getImage();
        }
        if (direction == Direction.RIGHT_STANDING) {
            ImageIcon i = new ImageIcon("Images/Standing - right.png");
            character = i.getImage();
        }
        if (direction == Direction.LEFT_STANDING) {
            ImageIcon i = new ImageIcon("Images/Standing - left.png");
            character = i.getImage();
        }
        if (direction == Direction.UP_LEFT) {
            ImageIcon i = new ImageIcon("Images/Jumping - left.png");
            character = i.getImage();
        }
        if (direction == Direction.UP_RIGHT) {
            ImageIcon i = new ImageIcon("Images/Jumping - right.png");
            character = i.getImage();
        }
        if (direction == Direction.UP_LADDER_MOVING) {
            ImageIcon i = new ImageIcon("Images/up-ladder-left.png");
            character = i.getImage();
        }
        if (direction == Direction.DOWN_LADDER_MOVING) {
            ImageIcon i = new ImageIcon("Images/up-ladder-right.png");
            character = i.getImage();
        }


    }

    @Override
    protected void paintComponent(Graphics g) {
        super.paintComponent(g);
        draw(g);
        for (int i = 0; i < blist.size(); i++) {
            blist.get(i).draw(g);
        }


    }

    public void draw(Graphics g) {
        //1
        g.drawImage(platform1, platform1x, platform1y, this);
        //2
        g.drawImage(platform2, platform2x, platform2y, this);
        //3
        g.drawImage(platform3, platform3x, platform3y, this);
        //4
        g.drawImage(platform4, platform4x, platform4y, this);
        //5
        g.drawImage(platform5, platform5x, platform5y, this);
        //6
        g.drawImage(platform6, platform6x, platform6y, this);
        //7
        g.drawImage(platform7, platform7x, platform7y, this);
        //8
        g.drawImage(platform8, platform8x, platform8y, this);
        g.drawImage(fire, fire1x, fire1y, this);
        g.drawImage(fire, fire2x, fire2y, this);
        g.drawImage(fire, fire3x, fire3y, this);
        g.drawImage(ladder, platform3x, platform3y, this);
        g.drawImage(ladder2, ladder2x, ladder2y, this);
        g.drawImage(barrelelev, barrelelevx, barrelelevy, this);

        if (piston) {
            g.drawImage(pistonIm, pistonx, platform5y + 40, this);
        }
        if (!piston) {
            g.drawImage(pistonIm, pistonx + 200, platform4y + 40, this);
            g.drawImage(pistonIm, pistonx + 400, platform4y + 40, this);
            g.drawImage(pistonIm, pistonx + 600, platform4y + 40, this);
        }
        if (opendoor) {
            g.drawImage(opendoorIm, doorx, doory, this);
        }
        if (!opendoor) {
            g.drawImage(door, doorx, doory, this);
        }
        g.drawImage(character, x, y, this);
        for (int i = 0; i < life; i++) {
            g.drawImage(heart, x + 10 + i * 20, y - 20, this);
        }


    }


}
