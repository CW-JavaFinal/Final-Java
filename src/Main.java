import javax.swing.*;
import javax.swing.UIManager;

import java.awt.*;

import static javafx.application.Platform.exit;

public class Main
{
    public static void main(String[] args)
    {
        {
            GameOptions.main(null); // Calls GameOptions Main
        }
    }
    public static void win()
    {
        JOptionPane.showMessageDialog(null, "You won!!!");
        playAgain();
    }
    public static void lose()
    {
        JOptionPane.showMessageDialog(null, "You lost...");
        playAgain();
    }
    public static void playAgain()
    {
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
            GameOptions.main(null);
        }
        // Exits the program if user types no
        else if(answer.equalsIgnoreCase("No"))
        {
            exit();
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
                GameOptions.main(null);
            }
            else if(answer.equalsIgnoreCase("No"))
            {
                wrong = false;
                exit();
            }
        }
    }
}
