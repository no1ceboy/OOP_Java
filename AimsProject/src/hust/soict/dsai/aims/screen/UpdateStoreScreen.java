package hust.soict.dsai.aims.screen;

import hust.soict.dsai.aims.cart.Cart;
import hust.soict.dsai.aims.media.Book;
import hust.soict.dsai.aims.media.DigitalVideoDisc;
import hust.soict.dsai.aims.store.Store;
import javafx.application.Platform;
import javafx.embed.swing.JFXPanel;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;

import javax.naming.LimitExceededException;
import javax.swing.*;
import java.awt.*;
import java.io.IOException;

public class UpdateStoreScreen extends JFrame {
    private static Store store;

    public UpdateStoreScreen(Store store) {
        super();
        this.store = store;
        JFXPanel fxPanel = new JFXPanel();
        this.add(fxPanel);
        this.setTitle("Add");
        this.setVisible(true);
        this.setSize(new Dimension(1024, 768));
        this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        Platform.runLater(new Runnable() {

            @Override
            public void run() {
                // TODO Auto-generated method stub
                try {
                    FXMLLoader loader = new FXMLLoader(getClass().getResource("/hust/soict/dsai/aims/screen/updateStore.fxml"));
                    UpdateStoreController controller = new UpdateStoreController(store);
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
        Store store = new Store();
        SwingUtilities.invokeLater(() -> new UpdateStoreScreen(store));
	}
}
