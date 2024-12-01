package hust.soict.dsai.aims.cart;
import hust.soict.dsai.aims.media.Media;
import java.util.ArrayList;
import java.util.List;

public class Cart {

    public static final int MAX_NUMBERS_ORDERED = 20;
    private List<Media> itemsOrdered = new ArrayList<>();

    public void addMedia(Media media) {

        if (itemsOrdered.size() < MAX_NUMBERS_ORDERED) {
            itemsOrdered.add(media);
            System.out.println("Media added");
        }
        else {
            System.out.println("Maximum amount reached!");
        }
    }

    public void removeMedia(Media media) {

        for (int i = 0; i < itemsOrdered.size(); i++) {
            if (itemsOrdered.get(i).equals(media)) {
                itemsOrdered.remove(i);
                System.out.println("Media deleted");
                return;
            }
        } 
        System.out.println("No media found!");

    }
    
    public float totalCost() {

        float cost = 0;
        for (int i = 0; i < itemsOrdered.size(); i++) {
			cost += itemsOrdered.get(i).getCost();
		}
		return cost;
    }

    public void print() {

        System.out.println("***********************CART************************");
        System.out.println("Ordered Items:");

        for (int i = 0; i < itemsOrdered.size(); i++) {
            System.out.print((i + 1) + ". ");
            System.out.println(itemsOrdered.get(i).toString());
        }
 
        System.out.println("Total cost: " + this.totalCost() + " $");
        System.out.println("***************************************************");
    }

    public void search(int id) {

        for (int i = 0; i < itemsOrdered.size(); i++) {
            if (itemsOrdered.get(i).isMatch(id)) {
                System.out.print("Found: " + (i + 1) + ". ");
                System.out.println(itemsOrdered.get(i).toString());
                return;
            }
        } 
        System.out.println("No match is found");
    }

    public void search(String title) {
        
        for (int i = 0; i < itemsOrdered.size(); i++) {
            if (itemsOrdered.get(i).isMatch(title)) {
                System.out.print("Found: " + (i + 1) + ". ");
                System.out.println(itemsOrdered.get(i).toString());
                return;
            }
        } 
        System.out.println("No match is found");  
    }
}
