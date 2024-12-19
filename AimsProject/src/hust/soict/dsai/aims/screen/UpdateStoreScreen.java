package hust.soict.dsai.aims.screen;

import hust.soict.dsai.aims.store.Store;
import javafx.application.Platform;
import javafx.embed.swing.JFXPanel;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javax.swing.*;
import java.awt.*;
import java.io.IOException;

public class UpdateStoreScreen extends JFrame {
    private Store store;
    private ScreenManager manager;

    public UpdateStoreScreen(Store store, ScreenManager manager) {
        super();
        this.store = store;
        this.manager = manager;
        JFXPanel fxPanel = new JFXPanel();
        this.add(fxPanel);
        this.setTitle("Add");
        this.setVisible(true);
        this.setSize(new Dimension(1024, 768));
        this.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
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
}
