//imports

import javax.swing.*;
import javax.swing.border.Border;
import java.awt.*;

public class gui
{
    //window dimensions
    int width = 600;
    int length = 600;

    JFrame frame = new JFrame("BlackJack 1.0");

    JPanel panel = new JPanel(); //background color

    JPanel buttonPanel = new JPanel();
    JButton hitButton = new JButton("hit");
    JButton stayButton = new JButton("stay");





    public gui()
    {
        frame.setSize(width, length);
        frame.setVisible(true); //makes the window visable
        frame.setLocationRelativeTo(null); //will set it to the middle of the screen
        frame.setResizable(false); //makes the size fixed and not dynamic
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

        panel.setLayout(new BorderLayout()); //changes background color
        panel.setBackground(new Color(78, 106, 84)); //sets to green

        frame.add(panel);

        hitButton.setFocusable(false); //makes it unhighlightable
        stayButton.setFocusable(false);

        buttonPanel.add(hitButton);
        buttonPanel.add(stayButton);

        frame.add(buttonPanel, BorderLayout.SOUTH);
    }


}
