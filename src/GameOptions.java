import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class GameOptions extends JFrame implements ActionListener // creates buttons for difficulty and size options
{
    int gridSize;
    private double bombCount;
    private JButton small = new JButton("Small (9x9)");
    private JButton medium = new JButton("Medium (16x16)");
    private JButton large = new JButton("Large (25x25)");
    private JButton easyButton = new JButton("Easy (25% bombs)");
    private JButton intermediateButton = new JButton("Intermediate (35% bombs)");
    private JButton hardButton = new JButton("Hard (50% bombs)");
    private Container con = getContentPane();
    private FlowLayout layout = new FlowLayout();
    private FlowLayout layoutDifficulty = new FlowLayout();
    public GameOptions()
    {
        this.setTitle("Game Options"); //Title of GUI
        this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE); //Properly exits when closed
        this.setVisible(true); //Shows GUI
        this.setResizable(false); //Can't resize GUI
        con.setLayout(layout);
        con.add(small);
        con.add(medium);
        con.add(large);
        small.addActionListener(this);
        medium.addActionListener(this);
        large.addActionListener(this);
        con.setLayout(layoutDifficulty);
        con.add(easyButton);
        con.add(intermediateButton);
        con.add(hardButton);
        easyButton.addActionListener(this);
        intermediateButton.addActionListener(this);
        hardButton.addActionListener(this);
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
        Object source = event.getSource(); // checks to see what gets clicked and sets size
        if (source == small)
        {
            gridSize = 9;
            if (bombCount == 0.25 || bombCount == 0.35|| bombCount == 0.50) // checks to see if bomb count has already been clicked in order to hide the GUI box
                setVisible(false);
        }
        else if(source == medium)
        {
            gridSize = 16;
            if (bombCount == 0.25 || bombCount == 0.35|| bombCount == 0.50)
                setVisible(false);
        }
        else if(source == large)
        {
            gridSize = 25;
            if (bombCount == 0.25 || bombCount == 0.35|| bombCount == 0.50)
                setVisible(false);
        }
        if (source == easyButton) // checks to see what gets clicked and sets difficulty
        {
            bombCount = 0.25;
            if (gridSize == 9 || gridSize == 16|| gridSize == 25)
                setVisible(false); // checks to see if Size has already been selected in order to hide the GUI box
                Easy.main(null);
        }
        else if(source == intermediateButton)
        {
            bombCount = 0.35;
            if (gridSize == 9 || gridSize == 16|| gridSize == 25)
                setVisible(false);
        }
        else if(source == hardButton)
        {
            bombCount = 0.50;
            if (gridSize == 9 || gridSize == 16|| gridSize == 25)
                setVisible(false);
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
