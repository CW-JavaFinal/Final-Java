import javax.swing.*;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.awt.event.MouseMotionListener;
import java.util.*;
import java.awt.*;


public class Easy implements Runnable {
    public static void main(String[] args) {

        GUI gui = new GUI();
    }

    public static class GUI extends JFrame {
        int spacing = 5; //Space between each square

        Random rand = new Random();

        int mines[][] = new int[9][9]; //array for bomb placement
        int surroundingSquares[][] = new int[9][9]; //array for the squares around the bombs
        boolean flag[][] = new boolean[9][9]; //flag placement
        boolean revealed[][] = new boolean[9][9]; //to reveal

        public int moveX = -100; //Mouse Movement
        public int moveY = -100;

        public GUI() {
            this.setTitle("Easy Minesweeper"); //Title of GUI
            this.setSize(735, 850); //Size of GUI
            this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE); //Properly exits when closed
            this.setVisible(true); //Shows GUI
            this.setResizable(false); //Can't resize GUI

            Field field = new Field(); //The minesweeping field appears
            this.setContentPane(field);

            Move move = new Move();
            this.addMouseMotionListener(move);

            Click click = new Click();
            this.addMouseListener(click);

        }

        public class Field extends JPanel {
            public void paintComponent(Graphics g) {
                g.setColor(Color.DARK_GRAY); //Background color
                g.fillRect(0, 0, 750, 820); //Background filled
                for (int i = 0; i < 9; i++) {
                    for (int j = 0; j < 9; j++) {
                        if (rand.nextInt(100) < 25) //25% chance of there being a bomb
                        {
                            mines[i][j] = 1; //bomb
                        } else {
                            mines[i][j] = 0; //no bomb
                        }
                        revealed[i][j] = false; //this will make it to where the bombs won't show until clicked
                    }
                }

                for (int i = 0; i < 9; i++) {
                    for (int j = 0; j < 9; j++) {
                        g.setColor(Color.white); //Space color
                        if (moveX >= spacing + i * 80 && moveX < i * 80 + 80 - spacing) {
                            g.setColor(Color.red); //colors the square that mouse is hovering to be clicked
                        }
                        if (mines[i][j] == 1) {
                            g.setColor(Color.YELLOW); //mine color
                        }
                        g.fillRect(spacing + i * 80, spacing + j * 80 + 80, 80 - 2 * spacing, 80 - 2 * spacing);
                        //creating each square

                    }
                }

            }
        }

        public class Move implements MouseMotionListener {

            @Override
            public void mouseDragged(MouseEvent mouseEvent) {

            }

            @Override
            public void mouseMoved(MouseEvent mouseEvent) {
                moveX = mouseEvent.getX(); //Mouse location on both the x and y axis
                moveY = mouseEvent.getY();
                System.out.println("X " + moveX + " Y " + moveY);
            }
        }

        public class Click implements MouseListener {

            @Override
            public void mouseClicked(MouseEvent mouseEvent) {

            }

            @Override
            public void mousePressed(MouseEvent mouseEvent) {

            }

            @Override
            public void mouseReleased(MouseEvent mouseEvent) {

            }

            @Override
            public void mouseEntered(MouseEvent mouseEvent) {

            }

            @Override
            public void mouseExited(MouseEvent mouseEvent) {

            }

            public int inBoxX() {
                for (int i = 0; i < 9; i++) {
                    for (int j = 0; j < 9; j++) {
                        if (moveX >= spacing + i * 80 && moveX < i * 80 + 80 - spacing && moveY >= spacing + j * 80 + 106 && moveY < j * 80 + 186 - spacing) {
                            return i;
                        }
                    }
                }
                return -1;
            }
        }

        public int inBoxY() {
            for (int i = 0; i < 9; i++) {
                for (int j = 0; j < 9; j++) {
                    if (moveX >= spacing + i * 80 && moveX < i * 80 + 80 - spacing && moveY >= spacing + j * 80 + 106 && moveY < j * 80 + 186 - spacing) {
                        return j;
                    }
                }
            }
            return -1;
        }

    }

        @Override
        public void run() {

        }
    }

