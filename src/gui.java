//imports

import javax.swing.*;
import javax.swing.border.Border;
import java.awt.*;

public class gui
{
    //window dimensions
    int width = 600;
    int length = 600;
    int cardWidth = 110;
    int cardHeight = 154;

    JFrame frame = new JFrame("BlackJack 1.0");

    JPanel panel = new JPanel()
    {
        @Override
        public void paintComponent(Graphics g)
        {
            super.paintComponent(g);

            try
            {
                //drawing hidden card
                Image hiddenCardImg = new ImageIcon(getClass().getResource("./cards/BACK.png")).getImage();
                g.drawImage(hiddenCardImg, 20, 20, cardWidth, cardHeight, null);

                //drawing dealers hand
                for (int i = 0; i < )
            } catch(Exception e)
            {
                e.printStackTrace();
            }
        }
    };//background color & drawing cards by overRiding "paintComponents" method to output image of cards

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
        buttonPanel.setBackground(new Color(50, 106, 84));

        frame.add(panel);//adds to the main frame

        hitButton.setFocusable(false); //makes it unhighlightable
        stayButton.setFocusable(false);

        buttonPanel.add(hitButton);
        buttonPanel.add(stayButton);

        frame.add(buttonPanel, BorderLayout.SOUTH);
    }


}
