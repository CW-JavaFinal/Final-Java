import javax.swing.*;
import javax.swing.UIManager;

import java.awt.*;

import static javafx.application.Platform.exit;

public class Main
{
    public static void main(String[] args)
    {
        {
            new GameOptions(); // Calls GameOptions Main
        }
    }
    public static void win()
    {
        // Paints the JOptionPane green on "You won"
        UIManager UI = new UIManager();
        UI.put("OptionPane.background", Color.green);
        UI.put("Panel.background", Color.green);
        JOptionPane.showMessageDialog(null, "You won!!!");
        // Calls playAgain()
        playAgain();
    }
    public static void lose()
    {
        // Paints this JOptionPane red on "You lost..."
        UIManager UI = new UIManager();
        UI.put("OptionPane.background", Color.red);
        UI.put("Panel.background", Color.red);
        JOptionPane.showMessageDialog(null, "You lost...");
        // Calls playAgain()
        playAgain();
    }
    public static void playAgain()
    {
        // Paints this JOptionPane orange
        UIManager UI = new UIManager();
        UI.put("OptionPane.background", Color.orange);
        UI.put("Panel.background", Color.orange);
        // Boolean wrong is set to false
        boolean wrong = false;
        // Asks player if they want to play again my making them type yes or no
        String answer = JOptionPane.showInputDialog(null, "Would you like to play again? Type Yes or No.");
        // Calls GameOptions.Main if User types yes
        if (answer.equalsIgnoreCase("Yes"))
        {
            new GameOptions();
        }
        // Exits the program if user types no
        else if(answer.equalsIgnoreCase("No"))
        {
            System.exit(0);
        }
        //Sets wrong to true and puts user through while loop
        else
            {
                wrong = true;
            }
        while(wrong)
        {
            // Asks user to only type Yes or No and will not exit loop until either word is typed
            answer = JOptionPane.showInputDialog(null, "Invalid answer. Try again.\nWould you like to play again? Type yes or no.");
            if (answer.equalsIgnoreCase("Yes"))
            {
                wrong = false;
                new GameOptions();
            }
            else if(answer.equalsIgnoreCase("No"))
            {
                wrong = false;
                System.exit(0);
            }
        }
    }
}
