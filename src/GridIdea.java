import javax.swing.*;
import java.awt.*;
import java.awt.event.*;


public class GridIdea {

    public static class JBorderLayout extends JFrame implements ActionListener {

            JButton[][] buttons = new JButton[4][4]; //eventually needs to set to Game Options
        GridLayout gridLayout = new GridLayout(4,4,2,4);
        public JBorderLayout() {
            setLayout(gridLayout);

            for (int i = 0; i <buttons.length; i++)
                for(int j = 0; i < buttons.length; j++)
                {
                    buttons[i][j] = new JButton();
                }


            setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

        }

        @Override
        public void actionPerformed(ActionEvent e) {
        }
    }
    public static void main(String[] args)
    {
        JBorderLayout jbl = new JBorderLayout();
        jbl.setSize(400,400);
        jbl.setVisible(true);
    }

}
