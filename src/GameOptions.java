import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class GameOptions extends JFrame implements ActionListener
{
    public int gridSize;
    public double bombCount;
    private JButton small = new JButton("Small (9x9)");
    private JButton medium = new JButton("Medium (16x16)");
    private JButton large = new JButton("Large (25x25)");
    private JButton easyButton = new JButton("Easy (25% bombs)");
    private JButton intermediateButton = new JButton("Intermediate (35% bombs)");
    private JButton hardButton = new JButton("Hard (50% bombs)");
    private Container con = getContentPane();
    private FlowLayout layout = new FlowLayout();
    public GameOptions()
    {
        con.setLayout(layout);
        con.add(easyButton);
        con.add(intermediateButton);
        con.add(hardButton);
        con.add(small);
        con.add(medium);
        con.add(large);
        easyButton.addActionListener(this);
        intermediateButton.addActionListener(this);
        hardButton.addActionListener(this);
        small.addActionListener(this);
        medium.addActionListener(this);
        large.addActionListener(this);
        easyButton.setPreferredSize(new Dimension(500, 150));
        intermediateButton.setPreferredSize(new Dimension(500, 150));
        hardButton.setPreferredSize(new Dimension(500, 150));
        small.setPreferredSize(new Dimension(500, 150));
        medium.setPreferredSize(new Dimension(500, 150));
        large.setPreferredSize(new Dimension(500, 150));
        setSize(700, 1000);
    }
    @Override
    public void actionPerformed(ActionEvent event)
    {
        Object source = event.getSource();
        if (source == small)
        {
            gridSize = 9;
        }
        else if(source == medium)
        {
            gridSize = 16;
        }
        else if(source == large)
        {
            gridSize = 25;
        }
        if (source == easyButton)
        {
            bombCount = 0.25;
        }
        else if(source == intermediateButton)
        {
            bombCount = 0.35;
        }
        else if(source == hardButton)
        {
            bombCount = 0.50;
        }

        con.invalidate();
        con.validate();

    }
    public static void main(String[] args)
    {
        GameOptions frame = new GameOptions();
        frame.setVisible(true);

    }
}
