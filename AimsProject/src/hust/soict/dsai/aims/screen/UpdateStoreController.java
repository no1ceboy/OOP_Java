package hust.soict.dsai.aims.screen;

import hust.soict.dsai.aims.media.DigitalVideoDisc;
import hust.soict.dsai.aims.media.Media;
import hust.soict.dsai.aims.store.Store;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Alert;
import javafx.scene.control.ButtonType;
import javafx.scene.control.ComboBox;
import javafx.scene.control.TextField;
import java.net.URL;
import java.util.ResourceBundle;


public class UpdateStoreController implements Initializable {
    private Store store;

    public UpdateStoreController() {
        super();
    }

    public UpdateStoreController(Store store) {
        // TODO Auto-generated constructor stub
        super();
        this.store = store;
    }
    @FXML
    private TextField category;

    @FXML
    private TextField cost;

    @FXML
    private TextField director;

    @FXML
    private TextField length;

    @FXML
    private TextField title;

    @FXML
    private ComboBox<String> listMedia = new ComboBox<String>();

    @FXML
    void btAddPressed(ActionEvent event) {
        try {
            String mediaTitle = title.getText();
            String mediaCategory = category.getText();
            String mediaDirector = director.getText();
            String mediaCostText = cost.getText();
            String mediaLengthText = length.getText();

            if (mediaTitle.isEmpty() || mediaCategory.isEmpty() || mediaCostText.isEmpty()) {
                showAlert("Error", "Title, Category, and Cost are required fields!", Alert.AlertType.ERROR);
                return;
            }

            float mediaCost = Float.parseFloat(mediaCostText); 
            int mediaLength = mediaLengthText.isEmpty() ? 0 : Integer.parseInt(mediaLengthText);

            Media media = new DigitalVideoDisc(mediaTitle, mediaCategory, mediaDirector, mediaLength, mediaCost);

            store.addMedia(media);

            showAlert("Success", "Media added successfully!", Alert.AlertType.INFORMATION);

            clearInputFields();

        } catch (NumberFormatException e) {
            showAlert("Error", "Cost and Length must be valid numbers.", Alert.AlertType.ERROR);
        } catch (Exception e) {
            showAlert("Error", "An unexpected error occurred: " + e.getMessage(), Alert.AlertType.ERROR);
        }
    }

    private void showAlert(String title, String message, Alert.AlertType type) {
        Alert alert = new Alert(type);
        alert.setTitle(title);
        alert.setHeaderText(null);
        alert.setContentText(message);
        alert.showAndWait();
    }

    private void clearInputFields() {
        title.clear();
        category.clear();
        director.clear();
        cost.clear();
        length.clear();
    }

    @Override
    public void initialize(URL arg0, ResourceBundle arg1) {

    }

}