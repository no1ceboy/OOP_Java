package hust.soict.dsai.aims.screen;

import hust.soict.dsai.aims.cart.Cart;
import hust.soict.dsai.aims.media.CompactDisc;
import hust.soict.dsai.aims.media.DigitalVideoDisc;
import hust.soict.dsai.aims.media.Media;
import hust.soict.dsai.aims.media.Playable;
import javafx.beans.value.ChangeListener;
import javafx.beans.value.ObservableValue;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.*;
import javafx.scene.control.Alert.AlertType;
import javafx.scene.control.cell.PropertyValueFactory;
public class CartScreenController {
    private Cart cart;
    private ScreenManager manager;

    public CartScreenController(Cart cart, ScreenManager manager) {
        // TODO Auto-generated constructor stub
        super();
        this.cart = cart;
        this.manager = manager;
    }

    @FXML
    private Button btnPlay;

    @FXML
    private Button btnRemove;

    @FXML
    private TableView<Media> tblMedia;

    @FXML
    private TableColumn<Media, String> colMediaTitle;

    @FXML
    private TableColumn<Media, String> colMediacategory;

    @FXML
    private TableColumn<Media, Float> colMediaCost;

    @FXML
    private RadioButton radioBtnFilterId;

    @FXML
    private RadioButton radioBtnFilterTitle;

    @FXML
    private TextField tfFilter;

    @FXML
    private Label totalCost;

    @FXML
    private MenuItem viewStoreMenu;

    @FXML
    private MenuItem viewCartMenu;

    @FXML
    private MenuItem addBookMenu;

    @FXML
    private MenuItem addCDMenu;

    @FXML
    private MenuItem addDVDMenu;

    @FXML
    private void initialize() {
        // Show Cart in the Table
        colMediaTitle.setCellValueFactory(new PropertyValueFactory<Media, String>("title"));
        colMediacategory.setCellValueFactory(new PropertyValueFactory<Media, String>("category"));
        colMediaCost.setCellValueFactory(new PropertyValueFactory<Media, Float>("cost"));
        tblMedia.setItems(this.cart.getItemsOrdered());
        totalCost.setText(Float.toString(cart.totalCost()) + "$");

        // Set Default the button Play and Remove
        btnPlay.setVisible(false);
        btnRemove.setVisible(false);

        tblMedia.getSelectionModel().selectedItemProperty().addListener(new ChangeListener<Media>() {

            @Override
            public void changed(ObservableValue<? extends Media> observable, Media oldValue, Media newValue) {
                if (newValue != null) {
                    updateButtonBar(newValue);
                }
                totalCost.setText(Float.toString(cart.totalCost()) + "$");
            }
        });
        // Filter
        tfFilter.textProperty().addListener(new ChangeListener<String>() {
            @Override
            public void changed(ObservableValue<? extends String> arg0, String oldValue, String newValue) {
                showFilteredMedia(newValue);
            }

            private void showFilteredMedia(String newValue) {
                // TODO Auto-generated method stub
                cart.search(newValue);
                // Update Later
            }
        });
    }

    void updateButtonBar(Media media) {
        btnRemove.setVisible(true);
        if (media instanceof Playable) {
            btnPlay.setVisible(true);
        } else
            btnPlay.setVisible(false);
    }

    @FXML
    public void btnRemovePressed(ActionEvent actionEvent) {
        Media media = tblMedia.getSelectionModel().getSelectedItem();
        cart.removeMedia(media);
    }

    @FXML
    public void btnPlayPressed(ActionEvent actionEvent) {
        Media media = tblMedia.getSelectionModel().getSelectedItem();
        try {
            if(media instanceof DigitalVideoDisc )
                ((DigitalVideoDisc) media).play();
            else if(media instanceof CompactDisc)
                ((CompactDisc) media).play();
            Alert alert = new Alert(AlertType.NONE, "Play the Media", ButtonType.FINISH);
            alert.setTitle("Play");
            alert.show();
        } catch (Exception e) {
            Alert a = new Alert(AlertType.ERROR);
            a.setContentText(e.getMessage());
            a.show();
        }
    }

    @FXML
    void placeOrderBtn(ActionEvent event) {
        String total = "Order cost is: " + cart.totalCost() + " $";
        Alert alert = new Alert(AlertType.NONE, total, ButtonType.FINISH);
        alert.setTitle("Order");
        alert.show();
        cart.clear();
        totalCost.setText(Float.toString(cart.totalCost()) + "$");
    }

    @FXML
    public void viewStore(ActionEvent event) {
        manager.showStoreScreen();
    }

    @FXML
    public void viewCart(ActionEvent event) {
        manager.showCartScreen();
    }

    @FXML
    public void addMedia(ActionEvent event) {
        manager.showUpdateScreen();
    }
}