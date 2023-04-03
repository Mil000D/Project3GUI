package com.company;


import java.io.*;

public class Model {
    int width = 1200;
    int height = 1000;
    private int x = 0;
    private int y = 830;
    private int dx;
    private int dy;
    private int jump = 180;
    private int ground = 830;
    private int highest = ground - jump;

    public int platform1x = 0;
    public int platform1y = 920;
    public int platform1width = 1200;
    public int platform2x = 0;
    public int platform2y = 770;
    public int platform2width = 1100;
    public int platform3x = 0;
    public int platform3y = 570;
    public int platform3width = 400;
    public int platform4x = 600;
    public int platform4y = 500;
    public int platform4width = 600;
    public int platform5x = 0;
    public int platform5y = 300;
    public int platform5width = 700;
    public int platform6x = 600;
    public int platform6y = 150;
    public int platform6width = 600;
    public int platform7x = 200;
    public int platform7y = 165;
    public int platform7width = 200;
    public int platform8x = 150;
    public int platform8y = 0;
    public int platform8width = 1050;
    public int ladder2x = 1050;
    public int ladder2y = 150;
    public int fire1x = 500;
    public int fire1y = 690;
    public int fire2x = 850;
    public int fire2y = 425;
    public int fire3x = 25;
    public int fire3y = 225;
    public int doorx = 200;
    public int doory = 50;
    public int barrelelevx = 0;
    public int barrelelevy = 0;
    public int pistonx = 400;

    private boolean win = false;
    private boolean ladder = false;
    public boolean right = true;
    public boolean left = false;
    public boolean up = false;
    public int life = 4;
    public int piston = 0;
    public boolean pistonBool = false;
    public long startOfGame = System.currentTimeMillis();
    public long timeOfGame;
    public long bestTime;
    public boolean running = false;
    public boolean dooropen = false;


    public void move() {
        x += dx;
        y += dy;
    }

    public void updateDirection(Direction direction) {
        if (direction == Direction.UP_RIGHT || direction == Direction.UP_LEFT) {
            if (y == ground) {
                dy = -5;
            }
        }
        if (direction == Direction.UP_LADDER_MOVING) {
            dy = -2;
        }
        if (direction == Direction.UP_LADDER_STANDING) {
            dy = 0;
        }
        if (direction == Direction.DOWN_LADDER_MOVING) {
            dy = 2;
        }
        if (direction == Direction.DOWN) {
            if (x <= 50 && ground == platform3y - 90 && y == platform3y - 90) {
                dy = 2;
                ground = platform2y - 90;
            } else if (x >= platform6x + platform6width - 200 && ground == platform6y - 90) {
                dy = 2;
                ground = platform4y - 90;
            }
        }
        if (direction == Direction.DOWN_LADDER_STANDING) {
            dy = 0;
        }
        if (direction == Direction.LEFT_RUNNING) {
            if (x > 0) {
                dx = -5;
            }
        }
        if (direction == Direction.RIGHT_RUNNING) {
            if (x < 1100) {
                dx = 5;
            }
        }
        if (direction == Direction.LEFT_STANDING) {
            dx = 0;
        }
        if (direction == Direction.RIGHT_STANDING) {
            dx = 0;
        }
    }

    public void Platform2() {
        if (x >= platform2x + 50 && x <= platform2width - 30 && y >= platform2y - 90 && y <= platform2y - 80) {
            jump = 180;
            dy = 0;
            ground = platform2y - 90;
            y = ground;
            highest = ground - jump;
        }
        if (x < platform2x + 50 && y >= platform2y - 90 && y <= platform2y - 80) {
            jump = 0;
            dy = 0;
            ground = platform2y - 90;
            y = ground;
            highest = ground - jump;
        }
        if (ground == 830 && x <= platform2width - 30 && y == platform2y + 40) {
            dy = 5;
        }
        if (ground == platform2y - 90 && x >= platform2width - 30 && y >= platform2y - 90 && y <= platform2y - 80) {
            dy = 5;
        }
        if (x >= platform2width - 100 && x <= platform2width - 30 && y > platform2y - 90 && y < platform2y + 40) {
            fall();
        }

    }

    public void Platform3() {
        if (x >= platform3x + 50 && x <= platform3width - 30 && y >= platform3y - 90 && y <= platform3y - 80) {
            jump = 180;
            dy = 0;
            ground = platform3y - 90;
            y = ground;
            highest = ground - jump;

        }
        if (x < platform3x + 50 && y == platform3y - 90) {
            jump = 180;
            dy = 0;
            ground = platform3y - 90;
            y = ground;
            highest = ground - jump;
        }
        if (ground == platform2y - 90 && x >= platform3x + 50 && x <= platform3width - 30 && y == platform3y + 40) {
            dy = 5;
        }
        if (ground == platform3y - 90 && x >= platform3width - 30 && y >= platform3y - 90 && y <= platform3y - 80) {
            dy = 5;
        }

        if (x >= platform3width - 100 && x <= platform3width - 30 && y > platform3y - 90 && y < platform3y + 40) {
            fall();
        }

    }

    public void Platform4() {
        if (x >= platform4x - 70 && x <= platform4x + platform4width - 200 && y >= platform4y - 90 && y <= platform4y - 80) {
            jump = 180;
            dy = 0;
            ground = platform4y - 90;
            y = ground;
            highest = ground - jump;
        }
        if (x > platform4x + platform4width - 200 && y >= platform4y - 90 && y <= platform4y - 80) {
            jump = 0;
            dy = 0;
            ground = platform4y - 90;
            y = ground;
            highest = ground - jump;
        }
        if (x >= platform4x - 70 && y == platform4y + 40) {
            dy = 5;
        }
        if (ground == platform4y - 90 && x < platform4x - 70 && y >= platform4y - 90 && y <= platform4y - 80) {
            dy = 5;
        }
        if (x >= platform4x - 70 && x <= platform4x - 30 && y > platform4y - 90 && y < platform4y + 40) {
            fall();
        }

    }

    public void Platform5() {
        if (x >= platform5x && x <= platform5width - 30 && y >= platform5y - 90 && y <= platform5y - 80) {
            jump = 180;
            dy = 0;
            ground = platform5y - 90;
            y = ground;
            highest = ground - jump;
        }
        if (x <= platform5width - 30 && y == platform5y + 40) {
            dy = 5;
        }
        if (ground == platform5y - 90 && x > platform5width - 30 && y >= platform5y - 90 && y <= platform5y - 80) {
            dy = 5;
        }
        if (x >= platform5width - 100 && x <= platform5width - 30 && y > platform5y - 90 && y < platform5y + 40) {
            fall();
        }
    }

    public void Platform6() {
        if (x >= platform6x - 70 && x <= platform6x + platform4width - 200 && y >= platform6y - 90 && y <= platform6y - 80) {
            jump = 180;
            dy = 0;
            ground = platform6y - 90;
            y = ground;
            highest = ground - jump;
        }
        if (x > platform6x + platform6width - 200 && y >= platform6y - 90 && y <= platform6y - 89) {
            jump = 180;
            dy = 0;
            ground = platform6y - 90;
            y = ground;
            highest = ground - jump;
        }
        if (x >= platform6x - 70 && x <= platform6x + platform6width - 200 && y == platform6y + 40) {
            dy = 5;
        }
        if (x < platform6x - 70 && y >= platform6y - 90 && y <= platform6y - 80) {
            dy = 5;
        }
        if (x >= platform6x - 70 && x <= platform6x - 30 && y > platform6y - 90 && y < platform6y + 40) {
            fall();
        }
    }

    public void Platform7() {
        if (x >= platform7x - 60 && x <= platform7x + platform7width - 30 && y >= platform7y - 90 && y <= platform7y - 80) {
            jump = 0;
            dy = 0;
            ground = platform7y - 90;
            y = ground;
            highest = ground - jump;
        }
        if (ground == platform5y - 90 && x >= platform7x - 60 && x <= platform7x + platform7width - 30 && y == platform7y + 40) {
            dy = 5;
        }
        if (ground == platform7y - 90 && (x < platform7x - 60 || x > platform7x + platform7width - 30) && y >= platform7y - 90 && y <= platform7y - 80) {
            dy = 5;
        }
        if (((x >= platform7x + platform7width - 70 && x <= platform7x + platform7width - 30) || (x >= platform7x - 60 && x <= platform7x - 30)) && y > platform7y - 90 && y < platform7y + 40) {
            fall();
        }
        if (ground == platform7y - 90) {
            dooropen = true;
        }
        if (ground != platform7y - 90) {
            dooropen = false;
        }
        if (x >= platform7x - 60 && x <= platform7x + 40 && y >= platform7y - 90 && y <= platform7y - 80) {
            win = true;
            long endOfGame = System.currentTimeMillis();
            timeOfGame = (endOfGame - startOfGame) / 1000;
            bestTime = timeOfGame;

            try {
                BufferedReader bestTimeReader = new BufferedReader(new FileReader("BestTime/BestTime"));
                String line = bestTimeReader.readLine();
                while (line != null) {
                    try {
                        long time = Long.parseLong(line);
                        if (bestTime > time) {
                            bestTime = time;
                        }
                    } catch (Exception e) {
                        System.out.println("ERROR");
                    }
                    line = bestTimeReader.readLine();
                }
                bestTimeReader.close();


            } catch (Exception ex) {
                System.out.println("ERROR");

            }
            try {
                BufferedWriter bestTimeWriter = new BufferedWriter(new FileWriter("BestTime/BestTime", true));
                bestTimeWriter.newLine();
                bestTimeWriter.append(Long.toString(timeOfGame));
                bestTimeWriter.close();

            } catch (Exception ex) {
                System.out.println("ERROR");
            }
        }

    }

    public void Ladder() {
        if (y <= highest && !ladder) {
            dy = 5;
        }
        if ((ground == platform2y - 90 && x <= 50) || (ground == platform4y - 90 && x >= 1000)) {
            ladder = true;
        }
        if (((ground != platform2y - 90) && x > 50) && ((ground != platform4y - 90) && x < 1000)) {
            ladder = false;
        }
        if ((ladder && x > 50 && y != ground) && x < 1000) {
            dy = 5;
            ladder = false;
        }
        if ((y <= platform3y - 90 && x <= 50) || (y <= platform6y - 90 && x >= 1000)) {
            ladder = false;
        }
    }

    public void Collision() {
        if (y >= 830) {
            jump = 180;
            dy = 0;
            ground = 830;
            y = 830;
            highest = ground - jump;
        }
        if (x <= 0) {
            dx = 0;
        }
        if (x >= 1100) {
            dx = 0;
        }
        if (y <= 40) {
            dy = 5;
        }
        if (x >= fire1x - 40 && x <= fire1x + 40 && y >= fire1y - 80 && y <= fire1y) {
            startingPos();
            life--;
        }
        if (x >= fire2x - 40 && x <= fire2x + 40 && y >= fire2y - 80 && y <= fire2y) {
            startingPos();
            life--;
        }
        if (x >= fire3x - 40 && x <= fire3x + 40 && y >= fire3y - 80 && y <= fire3y) {
            startingPos();
            life--;
        }
        if (y < ground) {
            up = true;
        }
        if (!pistonBool && ((x >= pistonx + 200 - 75 && x <= pistonx + 200 + 75 && y >= platform4y + 40 && y <= platform4y + 140)
                || (x >= pistonx + 400 - 75 && x <= pistonx + 400 + 75 && y >= platform4y + 40 && y <= platform4y + 140) || (x >= pistonx + 600 - 75 && x <= pistonx + 600 + 75 && y >= platform4y + 40 && y <= platform4y + 140))) {
            fall();
        }
        if (pistonBool && x >= pistonx - 75 && x <= pistonx + 75 && y >= platform5y + 40 && y <= platform5y + 140) {
            fall();
        }


        Platform2();
        Platform3();
        Platform4();
        Platform5();
        Platform6();
        Platform7();
        Ladder();
    }

    public void fall() {
        dx = 0;
        dy = 5;
    }

    public int getX() {
        return x;
    }

    public int getY() {
        return y;
    }


    public boolean getLadder() {
        return ladder;
    }

    public void startingPos() {
        x = 0;
        y = 830;
        jump = 180;
        ground = 830;
        highest = ground - jump;
    }

    public boolean getWin() {
        return win;
    }

    public int getGround() {
        return ground;
    }
}