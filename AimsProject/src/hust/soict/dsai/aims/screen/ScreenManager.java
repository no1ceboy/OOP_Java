package hust.soict.dsai.aims.screen;

import java.awt.Dimension;

import javax.swing.JFrame;
import javax.swing.SwingUtilities;

import hust.soict.dsai.aims.cart.Cart;
import hust.soict.dsai.aims.store.Store;

public class ScreenManager {
	private static JFrame currentScreen;
	
	public static JFrame storeScreen;
	public static JFrame cartScreen;
	public static JFrame updateScreen;
	private Cart cart;
	private Store store;
	
	public ScreenManager() {
		cart = new Cart();
		store = new Store();
		
		storeScreen = new StoreScreen(store);	
		storeScreen.setTitle("Store");
		
		cartScreen = new CartScreen(cart);
		cartScreen.setTitle("Cart");

		showStoreScreen();
	}
	public static void main(String args[]) {
		new ScreenManager();
	}

    public void showScreen(JFrame screen) {
        if (currentScreen != null) {
            currentScreen.setVisible(false);
        }
        currentScreen = screen;
        currentScreen.setVisible(true);
    }

    public void showStoreScreen() {
		SwingUtilities.updateComponentTreeUI(storeScreen);
		storeScreen.dispose();
		storeScreen= new StoreScreen(store);
		showScreen(storeScreen);
    }

    public void showCartScreen() {
		showScreen(cartScreen);
    }

    public void showUpdateScreen() {
		showScreen(updateScreen);
    }
}