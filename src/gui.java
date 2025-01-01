//imports

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class gui
{
    //window dimensions
    int width = 1200;
    int length = 600;
    int cardWidth = 110;
    int cardHeight = 154;

    //player and dealer data
    private dealer dealer;
    private player player;
    private util util;


    //gui objects

    //main frame
    JFrame frame = new JFrame("BlackJack 1.0");

    //frame for buttons
    JPanel buttonPanel = new JPanel();

    //individual buttons
    JButton hitButton = new JButton("hit");
    JButton stayButton = new JButton("stand");

    //panel that draws cards
    JPanel panel = new JPanel()
    {
        @Override
        public void paintComponent(Graphics g)
        {
            super.paintComponent(g);

            try
            {
                //draw first card from dealers hand
                String card = "./cards/" + dealer.getHand(0) + ".png";
                Image cardImg = new ImageIcon(getClass().getResource(card)).getImage();
                g.drawImage(cardImg, 20, 20, cardWidth, cardHeight, null);

                //drawing hidden card to cover the first card of the dealers hand
                Image hiddenCardImg = new ImageIcon(getClass().getResource("./cards/BACK.png")).getImage();
                g.drawImage(hiddenCardImg, 20, 20, cardWidth, cardHeight, null);



                //drawing dealers hand
                for (int i = 1; i < dealer.getHand().size(); i++) //size should be 2
                {

                    String card1 = "./cards/" + dealer.getHand(i) + ".png";
                    Image cardImg1 = new ImageIcon(getClass().getResource(card1)).getImage();
                    g.drawImage(cardImg1,140 * i, 20, cardWidth, cardHeight, null);
                }

                //drawing players hand
                for (int i = 0; i < player.getHand().size(); i++) //size should be 2
                {

                    String card1 = "./cards/" + player.getHand(i) + ".png";
                    Image cardImg1 = new ImageIcon(getClass().getResource(card1)).getImage();
                    g.drawImage(cardImg1, 20 + (cardWidth + 5) * i ,320, cardWidth, cardHeight, null);
                }

            } catch(Exception e)
            {
                e.printStackTrace();
            }
        }
    };//background color & drawing cards by overRiding "paintComponents" method to output image of cards


    public gui(dealer dealer, player player, Cards deck)
    {
        //storing the dealers data from the main class
        this.dealer = dealer;
        this.player = player;

        frame.setSize(width, length);
        frame.setVisible(true); //makes the window visable
        frame.setLocationRelativeTo(null); //will set it to the middle of the screen
        frame.setResizable(false); //makes the size fixed and not dynamic
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

        panel.setBackground(new Color(1, 106, 84)); //sets to casino green (south of frame)
        buttonPanel.setBackground(new Color(78, 106, 84));

        frame.add(panel);//adds to the main frame

        //hit button
        hitButton.setPreferredSize(new Dimension(100, 50)); //changes the size of the button
        hitButton.setFocusable(false); //makes it unhighlightable
        hitButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                String card = deck.drawCard();
                player.hand.add(card);
                int score = util.calculateHand(player.hand);

                if (util.calculateHand(player.getHand()) > util.calculateHand(dealer.getHand()) && !player.getBust()) {
                    System.out.println("player WINS!");
                } else if (util.calculateHand(player.getHand()) < util.calculateHand(dealer.getHand()) && !dealer.getBust()) {
                    System.out.println("player LOSES!");

                } else if (util.calculateHand(player.getHand()) == util.calculateHand(dealer.getHand()) && !player.getBust() && !dealer.getBust()) {
                    System.out.println("player PUSHES!");

                }
                panel.repaint();
            }
        });

        //stay button
        stayButton.setPreferredSize(new Dimension(100, 50));
        stayButton.setFocusable(false);

        buttonPanel.add(hitButton); //adding stay & hit buttons to the button panel
        buttonPanel.add(stayButton);


        frame.add(buttonPanel, BorderLayout.SOUTH); //adding the buttonPanel (stores hit & stay button) into frame
        panel.repaint();
    }


}
