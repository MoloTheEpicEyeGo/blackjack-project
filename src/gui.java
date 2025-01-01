//imports

import javax.smartcardio.Card;
import javax.swing.*;
import javax.swing.border.Border;
import java.awt.*;
import java.util.ArrayList;

public class gui
{
    //window dimensions
    int width = 600;
    int length = 600;
    int cardWidth = 110;
    int cardHeight = 154;


    //dealer&player objects&vars
    dealer dealer = new dealer();



    //gui objects
    JFrame frame = new JFrame("BlackJack 1.0");
    JPanel buttonPanel = new JPanel();
    JButton hitButton = new JButton("hit");
    JButton stayButton = new JButton("stay");
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
                /*
                    have to change whole card array to match card files so it can get correct name. Thats why its not printing
                */
                for (int i = 0; i < dealer.getHand().size(); i++)
                {
                    String card = dealer.getHand(i);
                    Image cardImg = new ImageIcon(getClass().getResource("./cards/" + card + ".png")).getImage();
                    g.drawImage(cardImg, 20 + (i * cardWidth), 200, cardWidth, cardHeight, null);

                }
            } catch(Exception e)
            {
                e.printStackTrace();
            }
        }
    };//background color & drawing cards by overRiding "paintComponents" method to output image of cards





    public gui(dealer dealer)
    {
        frame.setSize(width, length);
        frame.setVisible(true); //makes the window visable
        frame.setLocationRelativeTo(null); //will set it to the middle of the screen
        frame.setResizable(false); //makes the size fixed and not dynamic
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

        panel.setBackground(new Color(1, 106, 84)); //sets to casino green (south of frame)
        buttonPanel.setBackground(new Color(78, 106, 84));

        frame.add(panel);//adds to the main frame

        //hit button
        hitButton.setPreferredSize(new Dimension(100, 100)); //changes the size of the button
        hitButton.setFocusable(false); //makes it unhighlightable

        //stay button
        stayButton.setPreferredSize(new Dimension(100, 100));
        stayButton.setFocusable(false);

        buttonPanel.add(hitButton); //adding stay & hit buttons to the button panel
        buttonPanel.add(stayButton);


        frame.add(buttonPanel, BorderLayout.SOUTH); //adding the buttonPanel (stores hit & stay button) into frame
    }


}
