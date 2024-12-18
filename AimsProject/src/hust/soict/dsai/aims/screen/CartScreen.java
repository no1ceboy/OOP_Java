package hust.soict.dsai.aims.screen;

import hust.soict.dsai.aims.cart.Cart;
import hust.soict.dsai.aims.media.Book;
import hust.soict.dsai.aims.media.DigitalVideoDisc;
import javafx.application.Platform;
import javafx.embed.swing.JFXPanel;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;

import javax.naming.LimitExceededException;
import javax.swing.*;
import java.awt.*;
import java.io.IOException;

public class CartScreen extends JFrame {
    private Cart cart;

    public CartScreen(Cart cart) {
        super();
        this.cart = cart;
        JFXPanel fxPanel = new JFXPanel();
        this.add(fxPanel);
        this.setTitle("Cart");
        this.setVisible(true);
        this.setSize(new Dimension(1024, 768));
        this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        Platform.runLater(new Runnable() {

            @Override
            public void run() {
                // TODO Auto-generated method stub
                try {
                    FXMLLoader loader = new FXMLLoader(getClass().getResource("/hust/soict/dsai/aims/screen/cart.fxml"));
                    CartScreenController controller = new CartScreenController(cart);
                    loader.setController(controller);
                    Parent root = loader.load();
                    Scene scene = new Scene(root);
                    fxPanel.setScene(scene);
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }
        });
    }

    public static void main(String[] args) throws LimitExceededException {
        Cart cart = new Cart();
        Book initBook = new Book("The Great Novel", "Book", 100.00f);
        initBook.addAuthor( "Jane Smith");
        initBook.addAuthor("John D");
        // Book
        Book initBook2 = new Book("OOP", "Book", 100.00f);
        initBook.addAuthor( "Walpole");

        // DVD
        DigitalVideoDisc initDVD = new DigitalVideoDisc("Inception", "DVD",
                "Christopher Nolan", 150, 35.88f);
        cart.addMedia(initDVD);
        cart.addMedia(initBook);
        cart.addMedia(initBook2);
        new CartScreen(cart);
	}
}
