import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class DifficultyOptions extends JFrame implements ActionListener
{
    public double bombCount;
    private JButton easyButton = new JButton("Easy");
    private JButton intermediateButton = new JButton("Intermediate");
    private JButton hardButton = new JButton("Hard");
    private Container con = getContentPane();
    private FlowLayout layout = new FlowLayout();
    public DifficultyOptions()
    {
        con.setLayout(layout);
        con.add(easyButton);
        con.add(intermediateButton);
        con.add(hardButton);
        easyButton.addActionListener(this);
        intermediateButton.addActionListener(this);
        hardButton.addActionListener(this);
        setSize(300, 100);
    }
    @Override
    public void actionPerformed(ActionEvent event)
    {
        Object source = event.getSource();
        if (source == easyButton)
        {
            bombCount = 0.25;
            Easy.main(null);
        }
        else if(source == intermediateButton)
        {
            bombCount = 0.35;
        }
        else
        {
            bombCount = 0.5;
        }

        con.invalidate();
        con.validate();
    }
    public static void main(String[] args)
    {
        DifficultyOptions frame = new DifficultyOptions();
        frame.setVisible(true);
    }
}
