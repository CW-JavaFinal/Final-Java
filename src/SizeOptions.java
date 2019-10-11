import javax.swing.*;
import java.awt.*;
import java.awt.event.*;

public class SizeOptions extends JFrame implements ActionListener
{
    public int gridSize;
    private JButton smallButton = new JButton("Small");
    private JButton mediumButton = new JButton("Medium");
    private JButton largeButton = new JButton("Large");
    private Container con = getContentPane();
    private FlowLayout layout = new FlowLayout();
    public SizeOptions()
    {
        con.setLayout(layout);
        con.add(smallButton);
        con.add(mediumButton);
        con.add(largeButton);
        smallButton.addActionListener(this);
        mediumButton.addActionListener(this);
        largeButton.addActionListener(this);
        setSize(250, 100);
    }
    @Override
    public void actionPerformed(ActionEvent event)
    {
        Object source = event.getSource();
        if (source == smallButton)
        {
            gridSize = 9;
            DifficultyOptions.main(null);
        }
        else if(source == mediumButton)
        {
            gridSize = 16;
            DifficultyOptions.main(null);
        }
        else
            {
                gridSize = 25;
                DifficultyOptions.main(null);
            }
        con.invalidate();
        con.validate();
    }
    public static void main(String[] args)
    {
        SizeOptions frame = new SizeOptions();
        frame.setVisible(true);
    }
}
