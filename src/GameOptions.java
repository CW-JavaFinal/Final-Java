import javax.swing.*;
import java.awt.*;
import java.awt.event.*;

public class GameOptions extends JFrame // creates buttons for difficulty and size options
{
    public GameOptions()
    {
        initFrame(); // sets up frame details
        sizeOptions(); // opens Size Options Panel
        setVisible(true); // allows user to see sizeOptions()
    }
    private void initFrame()
    {
        // Configures settings for JFrame
        setSize(400, 500);
        setFocusable(true);
        setResizable(false);
        setLocationRelativeTo(null);
        setFocusTraversalKeysEnabled(false);
        setTitle("GameOptions");
        setDefaultCloseOperation(EXIT_ON_CLOSE);
        // uses Windows UI
        try { UIManager.setLookAndFeel(UIManager.getSystemLookAndFeelClassName()); }
        catch (Exception e) { System.out.println(e); }
    }
    private void sizeOptions()
    {
        // Creates Panel and layout for buttons
        JPanel panel = new JPanel();
        GridBagConstraints Grid = new GridBagConstraints();
        // adds small, medium and large buttons
        JButton small = new JButton("Small");
        JButton medium = new JButton("Medium");
        JButton large = new JButton("Large");

        panel.setLayout(new GridBagLayout());

        Grid.gridwidth = GridBagConstraints.REMAINDER;
        Grid.anchor = GridBagConstraints.CENTER;
        Grid.fill = GridBagConstraints.VERTICAL;
        Grid.insets = new Insets(5, 0, 5, 0);
        // sets size of buttons
        small.setSize(150, 50);
        medium.setSize(150, 50);
        large.setSize(150, 50);
        // adds Buttons to panel
        panel.add(small, Grid);
        panel.add(medium, Grid);
        panel.add(large, Grid);
        // shows this JPanel
        setContentPane(panel);

        small.addMouseListener(new MouseAdapter()
        {
            @Override
            public void mouseClicked(MouseEvent e)
            {
                panel.setVisible(false);
                difficultyOptions();
            }
        });

        medium.addMouseListener(new MouseAdapter()
        {
            @Override
            public void mouseClicked(MouseEvent e)
            {
                panel.setVisible(false);
                difficultyOptions();
            }
        });

        large.addMouseListener(new MouseAdapter()
        {
            @Override
            public void mouseClicked(MouseEvent e)
            {
                panel.setVisible(false);
                difficultyOptions();
            }
        });
    }
    private void difficultyOptions() {
        JPanel panel = new JPanel();
        GridBagConstraints Grid = new GridBagConstraints();

        JButton easy = new JButton("Easy");
        JButton intermediate = new JButton("Intermediate");
        JButton hard = new JButton("Hard");

        panel.setLayout(new GridBagLayout());

        Grid.gridwidth = GridBagConstraints.REMAINDER;
        Grid.anchor = GridBagConstraints.CENTER;
        Grid.fill = GridBagConstraints.VERTICAL;
        Grid.insets = new Insets(5, 0, 5, 0);

        easy.setSize(150, 50);
        intermediate.setSize(150, 50);
        hard.setSize(150, 50);

        panel.add(easy, Grid);
        panel.add(intermediate, Grid);
        panel.add(hard, Grid);

        setContentPane(panel);

        easy.addMouseListener(new MouseAdapter() {
            @Override
            public void mouseClicked(MouseEvent e) {
                setVisible(false);
                Easy.main(null);
            }
        });;

        intermediate.addMouseListener(new MouseAdapter() {
            @Override
            public void mouseClicked(MouseEvent e) {

                setVisible(false);
            }
        });

        hard.addMouseListener(new MouseAdapter() {
            @Override
            public void mouseClicked(MouseEvent e) {
                setVisible(false);

            }
        });
    }
}
