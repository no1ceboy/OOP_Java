package hust.soict.dsai.aims.screen;

import javax.swing.JFrame;
import hust.soict.dsai.aims.cart.Cart;
import hust.soict.dsai.aims.media.Book;
import hust.soict.dsai.aims.media.CompactDisc;
import hust.soict.dsai.aims.media.DigitalVideoDisc;
import hust.soict.dsai.aims.media.Track;
import hust.soict.dsai.aims.store.Store;

public class ScreenManager {
    private static JFrame currentScreen;

    private static JFrame storeScreen;
    private static JFrame cartScreen;

    private Cart cart;
    private Store store;

    public ScreenManager(Cart cart, Store store) {
		this.cart = cart;
		this.store = store;

        showStoreScreen();
    }

    public void showStoreScreen() {
        if (storeScreen == null) {
            storeScreen = new StoreScreen(this.store,this.cart,this);
        }
        showScreen(storeScreen);
    }

    public void showCartScreen() {
        if (cartScreen == null) {
            cartScreen = new CartScreen(this.cart, this);
        }
        showScreen(cartScreen);
    }

	public void showUpdateScreen() {
		new UpdateStoreScreen(this.store,this);
	}

    private void showScreen(JFrame screen) {
        if (currentScreen != null) {
            currentScreen.setVisible(false);
        }
        currentScreen = screen;
        currentScreen.setVisible(true);
    }

    public static void main(String[] args) {
		Store store = new Store();
		Cart cart = new Cart();
        // Book
        Book initBook = new Book("The Great Novel", "Book", 100.00f);
        initBook.addAuthor( "Jane Smith");
        initBook.addAuthor("John D");
        // Book
        Book initBook2 = new Book("OOP", "Book", 100.00f);
        initBook.addAuthor( "Walpole");

        // DVD
        DigitalVideoDisc initDVD = new DigitalVideoDisc("Inception", "DVD",
                "Christopher Nolan", 150, 35.88f);

        // CD
        Track track1 = new Track("Song 1", 3);
        Track track2 = new Track("Song 2", 4);
        CompactDisc initCD = new CompactDisc("The Best Hits", "CD", 30,
                90.00f, "Many Composers");
        initCD.addTrack(track1);
        initCD.addTrack(track2);

        store.addMedia(initBook);
        store.addMedia(initBook2);
        store.addMedia(initCD);
        store.addMedia(initDVD);

        new ScreenManager(cart, store);
    }
}
