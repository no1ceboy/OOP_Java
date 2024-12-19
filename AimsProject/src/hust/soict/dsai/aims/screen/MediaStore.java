package hust.soict.dsai.aims.screen;

import java.awt.*;
import java.awt.event.ActionListener;

import javax.naming.LimitExceededException;
import javax.swing.*;

import hust.soict.dsai.aims.cart.Cart;
import hust.soict.dsai.aims.media.*;
import java.awt.event.ActionEvent;

public class MediaStore extends JPanel {
    private Media media;
    private Cart cart;
    private ButtonListener btnListener = new ButtonListener();
    private JButton btnAddToCart, btnPlay;

    public class ButtonListener implements ActionListener {
        public void actionPerformed(ActionEvent e) {
            String button = e.getActionCommand();
            if(button.charAt(0) == 'A') {
                JFrame frame = new JFrame("JOptionPane ");
                JOptionPane.showMessageDialog(frame,
                        "The media has been added",
                        "Add To Cart",
                        JOptionPane.INFORMATION_MESSAGE);
            }
            else if (button.charAt(0) == 'P') {
                JFrame frame = new JFrame("JOptionPane ");
                JOptionPane.showMessageDialog(frame,
                        "Play The Media",
                        "Play",
                        JOptionPane.INFORMATION_MESSAGE);
            }
        }
    }

    public MediaStore(Media media, Cart cart) {
        this.media = media;
        this.cart = cart;

        this.setLayout(new BoxLayout(this, BoxLayout.Y_AXIS));

        JLabel title = new JLabel(media.getTitle());
        title.setFont(new Font(title.getFont().getName(), Font.PLAIN, 20));
        title.setAlignmentX(CENTER_ALIGNMENT);

        JLabel cost = new JLabel("" + media.getCost() + " $");
        cost.setAlignmentX(CENTER_ALIGNMENT);

        JPanel container = new JPanel();
        container.setLayout(new FlowLayout(FlowLayout.CENTER));

        btnAddToCart = new JButton("Add to cart");
        btnAddToCart.addActionListener(e -> addToCartAction());
        container.add(btnAddToCart);
        btnAddToCart.addActionListener(btnListener);
        if(media instanceof Playable) {
            btnPlay = new JButton("Play");
            container.add(btnPlay);
            btnPlay.addActionListener(btnListener);
        }

        
        this.add(Box.createVerticalGlue());
        this.add(title);
        this.add(cost);
        this.add(Box.createVerticalGlue());
        this.add(container);

        this.setBorder(BorderFactory.createLineBorder(Color.BLACK));
    }

    private void addToCartAction() {
        try {
            cart.addMedia(media);
        } catch (LimitExceededException e) {
            JOptionPane.showMessageDialog(this, "Cart is full! Cannot add more items.", "Error", JOptionPane.ERROR_MESSAGE);
        }
    }
}
