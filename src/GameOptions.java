import javax.swing.*;
import java.awt.*;
import java.awt.event.*;

public class GameOptions extends JFrame // creates buttons for difficulty and size options
{
    public GameOptions() {
        initFrame(); // sets up frame details
        Play(); // opens Size Options Panel
        setVisible(true); // allows user to see sizeOptions()
    }

    private void initFrame() {
        // Configures settings for JFrame
        setSize(400, 500);
        setFocusable(true);
        setResizable(false);
        setLocationRelativeTo(null);
        setFocusTraversalKeysEnabled(false);
        setTitle("GameOptions");
        setDefaultCloseOperation(EXIT_ON_CLOSE);
        // uses Windows UI
        try {
            UIManager.setLookAndFeel(UIManager.getSystemLookAndFeelClassName());
        } catch (Exception e) {
            System.out.println(e);
        }
    }

    private void Play() {
        // Creates Panel and layout for the button
        JPanel panel = new JPanel();
        GridBagConstraints Grid = new GridBagConstraints();
        // adds play button
        JButton play = new JButton("Play");

        panel.setLayout(new GridBagLayout());

        Grid.gridwidth = GridBagConstraints.REMAINDER;
        Grid.anchor = GridBagConstraints.CENTER;
        Grid.fill = GridBagConstraints.VERTICAL;

        // sets size of buttons
        play.setSize(150, 50);
        // adds Button to panel
        panel.add(play, Grid);
        // shows this JPanel
        setContentPane(panel);


        play.addMouseListener(new MouseAdapter() {
            @Override
            public void mouseClicked(MouseEvent e) {
                setVisible(false);
                Easy.main(null);
            }
        });
    }
}
