package hust.soict.dsai.aims.screen;

import hust.soict.dsai.aims.cart.Cart;
import hust.soict.dsai.aims.media.*;
import hust.soict.dsai.aims.store.Store;
import javafx.collections.ObservableList;
import javax.swing.*;
import java.awt.*;

public class StoreScreen extends JFrame{
    private Store store;
    private ScreenManager manager;
    private Cart cart;

    JPanel createNorth() {
        JPanel north = new JPanel();
        north.setLayout(new BoxLayout(north, BoxLayout.Y_AXIS));
        north.add(createMenuBar());
        north.add(createHeader());
        return north;
    }

    JMenuBar createMenuBar() {
		JMenu menu = new JMenu("Option");
		JMenu smUpdateStore = new JMenu("Update Store");

		JMenuItem addBookMenu= new JMenuItem("Add Book");
		addBookMenu.addActionListener(e->{
			manager.showUpdateScreen();
		});
		smUpdateStore.add(addBookMenu);

		JMenuItem addCDMenu=new JMenuItem("Add CD");
		addCDMenu.addActionListener(e->{
			manager.showUpdateScreen();
		});
		smUpdateStore.add(addCDMenu);

		JMenuItem addDVDMenu= new JMenuItem("Add DVD");
		addDVDMenu.addActionListener(e->{
			manager.showUpdateScreen();
		});
		smUpdateStore.add(addDVDMenu);

		menu.add(smUpdateStore);

		JMenuItem viewStoreMenu= new JMenuItem("View store");
		viewStoreMenu.addActionListener(e->{
			manager.showStoreScreen();
		});

		menu.add(viewStoreMenu);

		JMenuItem viewCartMenu= new JMenuItem("View cart");
		viewCartMenu.addActionListener(e->{
			manager.showCartScreen();
		});
        
		menu.add(viewCartMenu);

		JMenuBar menuBar = new JMenuBar();
		menuBar.setLayout(new FlowLayout(FlowLayout.LEFT));
		menuBar.add(menu);

		return menuBar;
	}

    JPanel createHeader() {
        JPanel header = new JPanel();
        header.setLayout(new BoxLayout(header, BoxLayout.X_AXIS));

        JLabel title = new JLabel("AIMS");
        title.setFont(new Font(title.getFont().getName(), Font.PLAIN, 50));
        title.setForeground(Color.CYAN);

        header.add(Box.createRigidArea(new Dimension(10, 10)));
        header.add(title);
        header.add(Box.createHorizontalGlue());
        header.add(Box.createRigidArea(new Dimension(10, 10)));

        return header;
    }

    JPanel createCenter() {
        JPanel center = new JPanel();
        center.setLayout(new GridLayout(3, 3, 2, 2));

        ObservableList<Media> mediaInStore = store.getItemsInStore();
        for(Media m: mediaInStore) {
            MediaStore cell = new MediaStore(m,cart);
            center.add(cell);
        }
        return center;
    }

    public StoreScreen(Store store,Cart cart, ScreenManager manager) {
        this.store = store;
        this.manager = manager;
        this.cart = cart;

        Container cp = getContentPane();
        cp.setLayout(new BorderLayout());

        cp.add(createNorth(), BorderLayout.NORTH);
        cp.add(createCenter(), BorderLayout.CENTER);

        setVisible(true);
        setTitle("Store");
        setSize(1024, 768);
    }
}