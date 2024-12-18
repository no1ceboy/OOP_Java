package hust.soict.dsai.aims.screen;

import hust.soict.dsai.aims.cart.Cart;
import hust.soict.dsai.aims.media.*;
import hust.soict.dsai.aims.store.Store;
import javafx.collections.ObservableList;

import javax.naming.LimitExceededException;
import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;
import java.util.Arrays;

public class StoreScreen extends JFrame{
    private Store store;
    private JButton btnAddToCart, btnPlay;

    JPanel createNorth() {
        JPanel north = new JPanel();
        north.setLayout(new BoxLayout(north, BoxLayout.Y_AXIS));
        north.add(createMenuBar());
        north.add(createHeader());
        return north;
    }

    JMenuBar createMenuBar() {
        JMenu menu = new JMenu("Options");

        // Update Store Submenu
        JMenu smUpdateStore = new JMenu("Update Store");
        JMenuItem addBook = new JMenuItem("Add Book");
        JMenuItem addCD = new JMenuItem("Add CD");
        JMenuItem addDVD = new JMenuItem("Add DVD");

        smUpdateStore.add(addBook);
        smUpdateStore.add(addCD);
        smUpdateStore.add(addDVD);

        // Menu Items for navigation
        JMenuItem viewStore = new JMenuItem("View Store");
        JMenuItem viewCart = new JMenuItem("View Cart");

        menu.add(smUpdateStore);
        menu.add(viewStore);
        menu.add(viewCart);

        JMenuBar menuBar = new JMenuBar();
        menuBar.add(menu);

        // --- Action Listeners for Menu Items ---
        addBook.addActionListener(e -> openUpdateStore());
        addCD.addActionListener(e -> openUpdateStore());
        addDVD.addActionListener(e -> openUpdateStore());

        viewCart.addActionListener(e -> openCartScreen());

        return menuBar;
    }

    JPanel createHeader() {
        JPanel header = new JPanel();
        header.setLayout(new BoxLayout(header, BoxLayout.X_AXIS));

        JLabel title = new JLabel("AIMS");
        title.setFont(new Font(title.getFont().getName(), Font.PLAIN, 50));
        title.setForeground(Color.CYAN);

        JButton cart = new JButton("View cart");
        cart.setPreferredSize(new Dimension(100, 50));
        cart.setMaximumSize(new Dimension(100, 50));

        header.add(Box.createRigidArea(new Dimension(10, 10)));
        header.add(title);
        header.add(Box.createHorizontalGlue());
        header.add(cart);
        header.add(Box.createRigidArea(new Dimension(10, 10)));

        return header;
    }

    JPanel createCenter() {
        JPanel center = new JPanel();
        center.setLayout(new GridLayout(3, 3, 2, 2));

        ObservableList<Media> mediaInStore = store.getItemsInStore();
        for(Media m: mediaInStore) {
            MediaStore cell = new MediaStore(m);
            center.add(cell);
        }

        return center;
    }

    public class MediaStore extends JPanel {
        private Media media;
        ButtonListener btnListener = new ButtonListener();

        public MediaStore(Media media) {
            this.media = media;
            this.setLayout(new BoxLayout(this, BoxLayout.Y_AXIS));

            JLabel title = new JLabel(media.getTitle());
            title.setFont(new Font(title.getFont().getName(), Font.PLAIN, 20));
            title.setAlignmentX(CENTER_ALIGNMENT);

            JLabel cost = new JLabel("" + media.getCost() + " $");
            cost.setAlignmentX(CENTER_ALIGNMENT);

            JPanel container = new JPanel();
            container.setLayout(new FlowLayout(FlowLayout.CENTER));

            btnAddToCart = new JButton("Add to cart");
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
    }

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

    private void openCartScreen() {
        dispose();
        Cart cart = new Cart();
        new CartScreen(cart);
    }

    private void openUpdateStore() {
        dispose();
        SwingUtilities.invokeLater(() -> new UpdateStoreScreen(store));
    }

    public StoreScreen(Store store) {
        this.store = store;
        Container cp = getContentPane();
        cp.setLayout(new BorderLayout());

        cp.add(createNorth(), BorderLayout.NORTH);
        cp.add(createCenter(), BorderLayout.CENTER);

        setVisible(true);
        setTitle("Store");
        setSize(1024, 768);
        
    }

    public static void main(String[] args) throws LimitExceededException {
        Store store = new Store();
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

        new StoreScreen(store);
    }
}