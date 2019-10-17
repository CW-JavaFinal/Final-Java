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
        int spacing = 10; //Space between each square
        int surround; //variable for the numbered squares

        Random rand = new Random();

        int mines[][] = new int[9][9]; //array for bomb placement
        int surroundingSquares[][] = new int[9][9]; //array for the squares around the bombs
        boolean flag[][] = new boolean[9][9]; //flag placement
        boolean revealed[][] = new boolean[9][9]; //to reveal

        public int moveX = -100; //Mouse Movement
        public int moveY = -100;

        public GUI() {
            this.setTitle("Easy Minesweeper"); //Title of GUI
            this.setSize(900, 900); //Size of GUI
            this.setVisible(true); //Shows GUI
            this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE); //Properly exits when closed


            for (int i = 0; i < 9; i++) {
                for (int j = 0; j < 9; j++) {
                    if (rand.nextInt(100) < 25) //25% chance of there being a bomb
                    {
                        mines[i][j] = 1; //bomb
                    } else {
                        mines[i][j] = 0; //no bomb
                    }
                    revealed[i][j] = false; //this will make it to where the bombs won't show until clicked
                    flag[i][j] = false;
                }
            }
            for (int i = 0; i < 9; i++) { //loop counter for square numbers
                for (int j = 0; j < 9; j++) {
                    surround = 0;
                    for (int m = 0; m < 9; m++) {
                        for (int n = 0; n < 9; n++) {
                            if (!(m == i && n == j)) {
                                if (isN(i, j, m, n) == true)
                                    surround++;
                            }
                        }
                    }
                    surroundingSquares[i][j] = surround; //puts it into an array to be displayed
                }
            }

            Field field = new Field(); //The minesweeping field appears
            this.setContentPane(field);

            Move move = new Move(); //reads mouse movement
            this.addMouseMotionListener(move);

            Click click = new Click(); //reads mouse clicks
            this.addMouseListener(click);

        }

        public class Field extends JPanel {
            public void paintComponent(Graphics g) {
                g.setColor(Color.DARK_GRAY); //Background color
                g.fillRect(0, 0, 920, 920); //Background filled
                for (int i = 0; i < 9; i++){
                    for (int j = 0; j < 9; j++) {
                        g.setColor(Color.lightGray); //Space color
                        if (revealed[i][j] == true)
                            g.setColor(Color.white);
                                if (mines[i][j] == 0) {
                                    g.setFont(new Font("Tahoma", Font.BOLD, 40)); //number display
                                    g.drawString(Integer.toString(surroundingSquares[i][j]), i * 80 + 27, j * 80 + 93); //placement of #'s
                                }
                                else
                                {
                                    g.setColor(Color.yellow);
                                }
                        if (moveX >= spacing + i * 80 && moveX < i * 80 + 80 - spacing) {
                            g.setColor(Color.red); //colors the square that mouse is hovering to be clicked
                        }
                        g.fillRect(spacing + i * 80, spacing + j * 80 + 80, 80 - spacing, 80 - spacing);
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
            }
        }

        public class Click implements MouseListener {

            @Override
            public void mouseClicked(MouseEvent mouseEvent) {
                if (inBoxX() != -1 && inBoxY() != -1) {
                    revealed[inBoxX()][inBoxY()] = true;
                }
                if (inBoxX() != -1 && inBoxY() != -1) {
                    System.out.println("Click is in box [" + inBoxX() + " , " + inBoxY() + "]");
                } else {
                    System.out.println("Not in box.");
                }

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

        public boolean isN(int moveX, int moveY, int clickX, int clickY) {
            for (int i = 0; i < 9; i++) {
                for (int j = 0; j < 9; j++) {
                    if (moveX - clickX < 2 && moveX - clickX > -2 && moveY - clickY < 2 && moveY - clickY > -2 && mines[clickX][clickY] == 1) {
                        return true;
                    }
                }
            }
            return false;
        }

    }

    @Override
    public void run() {

    }

}
