import javax.swing.*;
import java.awt.*;
import java.awt.event.*;

public class GridIdea {

    public static class JBorderLayout extends JFrame implements ActionListener {
        private JButton button1 = new JButton();
        private JButton button2 = new JButton();
        private JButton button3 = new JButton();
        private JButton button4 = new JButton();
        private JButton button5 = new JButton();
        private JButton button6 = new JButton();
        private JButton button7 = new JButton();
        private JButton button8 = new JButton();
        private JButton button9 = new JButton();
        private JButton button10 = new JButton();
        private JButton button11 = new JButton();
        private JButton button12 = new JButton();
        GridLayout gridLayout = new GridLayout(4,4,2,4);
        public JBorderLayout() {
            setLayout(gridLayout);

            add("1",button1);
            add("2",button2);
            add("3",button3);
            add("4",button4);
            add("5",button5);
            add("6",button6);
            add("1",button7);
            add("2",button8);
            add("3",button9);
            add("4",button10);
            add("5",button11);
            add("6",button12);
            button1.addActionListener( this);
            button2.addActionListener( this);
            button3.addActionListener( this);
            button4.addActionListener( this);
            button5.addActionListener( this);
            button6.addActionListener( this);
            button7.addActionListener( this);
            button8.addActionListener( this);
            button9.addActionListener( this);
            button10.addActionListener( this);
            button11.addActionListener( this);
            button12.addActionListener( this);
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
