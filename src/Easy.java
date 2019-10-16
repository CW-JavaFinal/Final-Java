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

    public static class GUI extends JFrame
    {
        final int SPACING = 5; //Space between each square
        public int moveX = -100; //Mouse Movement
        public int moveY = -100;

        public GUI(){
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
        public class Field extends JPanel{
            public void paintComponent(Graphics g)
            {
                g.setColor(Color.DARK_GRAY); //Background color
                g.fillRect(0, 0, 750,820); //Background filled
                for(int i = 0; i < 9; i++)
                {
                    for(int j = 0; j < 9; j++)
                    {
                        g.setColor(Color.white); //Space color
                        if(moveX >= SPACING+i*80 && moveX < i* 80 + 80-SPACING)
                        {
                            g.setColor(Color.red);
                        }
                        g.fillRect(SPACING + i* 80, SPACING + j* 80 + 80, 80-2*SPACING, 80-2*SPACING);
                        //creating each square
                    }
                }
            }
        }
        public class Move implements MouseMotionListener{

            @Override
            public void mouseDragged(MouseEvent mouseEvent) {

            }

            @Override
            public void mouseMoved(MouseEvent mouseEvent) {
               moveX = mouseEvent.getX();
               moveY = mouseEvent.getY();
               System.out.println("X " + moveX + " Y " + moveY);
            }
        }
        public class Click implements MouseListener{

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
        }

    }
    @Override
    public void run()
    {

    }
}
