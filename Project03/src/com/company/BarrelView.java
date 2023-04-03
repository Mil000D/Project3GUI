package com.company;

import javax.swing.*;
import java.awt.*;


public class BarrelView extends JComponent {
    private int x;
    private int y;
    Image barrel;

    public BarrelView() {
        ImageIcon b = new ImageIcon("Images/barrelstart.png");
        barrel = b.getImage();
    }

    public void updateBarrel(int x, int y) {
        this.x = x;
        this.y = y;
    }

    public void changeImageBarrel(Direction direction) {
        if (direction == Direction.FIRE_RIGHT) {
            ImageIcon b = new ImageIcon("Images/firebarrel - right.png");
            barrel = b.getImage();
        }
        if (direction == Direction.BARREL_RIGHT) {
            ImageIcon b = new ImageIcon("Images/barrel - right.png");
            barrel = b.getImage();
        }
        if (direction == Direction.FIRE_LEFT) {
            ImageIcon b = new ImageIcon("Images/firebarrel - left.png");
            barrel = b.getImage();
        }
        if (direction == Direction.BARREL_LEFT) {
            ImageIcon b = new ImageIcon("Images/barrel - left.png");
            barrel = b.getImage();
        }
    }


    public void draw(Graphics g) {
        g.setColor(Color.cyan);
        g.drawImage(barrel, x, y, this);
    }

}
