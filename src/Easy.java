import javax.swing.*;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.awt.event.MouseMotionListener;
import java.util.*;
import java.awt.*;
import java.util.Timer;


public class Easy implements Runnable {
    public static void main(String[] args) {
        new GUI();
    }

    public static class GUI extends JFrame {
        int spacing = 10; //Space between each square
        int surround; //variable for the numbered squares
        int seconds = 0;
        int minutes = 0;
        Random rand = new Random();
        Timer timer = new Timer();
        TimerTask task = new TimerTask() {
            @Override
            public void run() {
                seconds++;
                if(seconds == 60)
                {
                    seconds = 0;
                    minutes = minutes + 1;
                }
            }
        };

        int mines[][] = new int[9][9]; //array for bomb placement
        int surroundingSquares[][] = new int[9][9]; //array for the squares around the bombs
        boolean flag[][] = new boolean[9][9]; //array for flag placement
        boolean revealed[][] = new boolean[9][9]; //array to reveal


        public int moveX = -100; //Mouse Movement
        public int moveY = -100;

        public GUI() {
            this.setTitle("Easy Minesweeper"); //Title of GUI
            this.setSize(1286, 836); //Size of GUI
            this.setVisible(true); //Shows GUI
            this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE); //Properly exits when closed
            timer.scheduleAtFixedRate(task,1000,1000);
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
                g.fillRect(0, 0, 1280, 800); //Background filled
                g.setColor(Color.white);
                g.setFont(new Font("Tahoma", Font.BOLD, 40));
                g.drawString("Easy Minesweeper", 160, 60); //Title
                g.setFont(new Font("Tahoma", Font.BOLD, 20));
                g.drawString("Left click to reveal squares!", 720, 100);
                g.drawString("Right Click to flag squares!", 720, 140);
                g.setFont(new Font("Tahoma", Font.BOLD, 40)); //Shows timer
                if(seconds < 10 && minutes < 10) //adds 0 in front of seconds and minutes if they're both below 10
                    g.drawString( "0" + minutes + ":0" + seconds, 750, 60);
                else if(seconds < 10 && minutes >= 10) //adds 0 in front of seconds it's below 10
                    g.drawString(minutes +":0" + seconds, 750, 60);
                else if(seconds >= 10 && minutes < 10)//adds 0 in front of minutes if it's below 10
                    g.drawString("0" + minutes +":" + seconds, 750, 60);
                else if(seconds >= 10 && minutes >= 10) //if both sec and mins are over 10
                    g.drawString(minutes +":" + seconds, 750, 60); //adds no 0's
                for (int i = 0; i < 9; i++) {
                    for (int j = 0; j < 9; j++) {
                        g.setColor(Color.lightGray); //Space color
                        if(flag[i][j] == true)
                        {
                            g.setColor(Color.green); //flagged spaces becomes green

                        }
                        if (revealed[i][j] == true) {
                            g.setColor(Color.white); //changes when clicked
                            if (mines[i][j] == 1) {
                                g.setColor(Color.red);
                                Main.lose();
                            }
                        }
                        g.fillRect(spacing + i * 80, spacing + j * 80 + 80, 80 - 2*spacing, 80 - 2* spacing);
                        //creating each square
                        if(revealed[i][j] == true)
                        {
                            if (mines[i][j] == 0) {
                                if(surroundingSquares[i][j] != 0)
                                g.setColor(Color.black); //numbers for figuring out where bombs are
                                g.setFont(new Font("Tahoma", Font.BOLD, 40)); //number display
                                g.drawString(Integer.toString(surroundingSquares[i][j]), i * 80 + 27, j * 80 + 135); //placement of #'s
                            }
                        }

                    }
                }
                if(totalRevealed() >= 81 - totalMines())
                {
                    Main.win(); //shows "You Win" JOptionPane
                }
                this.setVisible(false); //refreshes page to show clicks
                this.setVisible(true);
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
            public void mouseClicked(MouseEvent e) {
                if(e.getButton() == MouseEvent.BUTTON1) //when mouse is left clicked
                if (inBoxX() != -1 && inBoxY() != -1) {
                    revealed[inBoxX()][inBoxY()] = true; //causes the reveal of square to be true
                    System.out.println("Click is in box [" + inBoxX() + " , " + inBoxY() + "]");
                } else {
                    System.out.println("Not in box.");
                }
                if(e.getButton() == MouseEvent.BUTTON3) //when mouse is right clicked
                {
                    if(inBoxX() != -1 && inBoxY() != -1)
                    {
                        flag[inBoxX()][inBoxY()] = true; //flags that square
                    }
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
        }

        public int inBoxX() {//this is to find the x coordinate for which square is being revealed and flagged
            for (int i = 0; i < 9; i++) {
                for (int j = 0; j < 9; j++) {
                    if (moveX >= spacing + i * 80 && moveX < i * 80 + 80 - spacing && moveY >= spacing + j * 80 + 106 && moveY < j * 80 + 186 - spacing) {
                        return i;
                    }
                }
            }
            return -1;
        }


        public int inBoxY() {//this is to find the y coordinate for which square is being revealed and flagged
            for (int i = 0; i < 9; i++) {
                for (int j = 0; j < 9; j++) {
                    if (moveX >= spacing + i * 80 && moveX < i * 80 + 80 - spacing && moveY >= spacing + j * 80 + 106 && moveY < j * 80 + 186 - spacing) {
                        return j;
                    }
                }
            }
            return -1;
        }

        public boolean isN(int moveX, int moveY, int clickX, int clickY) {//this is to read the click within the square
            for (int i = 0; i < 9; i++) {
                for (int j = 0; j < 9; j++) {
                    if (moveX - clickX < 2 && moveX - clickX > -2 && moveY - clickY < 2 && moveY - clickY > -2 && mines[clickX][clickY] == 1) {
                        return true;
                    }
                }
            }
            return false;
        }
        public int totalMines()
        {
            int mineCounter = 0;
            for (int i = 0; i < 9; i++) {
                for (int j = 0; j < 9; j++) {
                    if(mines[i][j] == 1)
                    {
                        mineCounter++;
                    }
                }
            }
            return mineCounter;
        }
        public int totalRevealed()
        {
            int revealCounter = 0;
            for (int i = 0; i < 9; i++) {
                for (int j = 0; j < 9; j++) {
                    if(revealed[i][j] == true)
                    {
                        revealCounter++;
                    }
                }
            }
            return revealCounter;
        }
    }
    @Override
    public void run() {

    }
}

