//imports

import javax.swing.*;

public class gui
{
    //window dimensions
    int width = 600;
    int length = 600;

    JFrame frame = new JFrame("BlackJack 1.0");

    public gui()
    {
        frame.setSize(width, length);
        frame.setVisible(true); //makes the window visable
        frame.setLocationRelativeTo(null); //will set it to the middle of the screen
        frame.setResizable(false); //makes the size fixed and not dynamic
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
    }


}
