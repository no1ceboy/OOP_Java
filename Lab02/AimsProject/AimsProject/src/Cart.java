import java.util.Arrays;

public class Cart {

    public static final int MAX_NUMBERS_ORDERED = 20;
    private DigitalVideoDisc itemsOrdered[] = new DigitalVideoDisc[MAX_NUMBERS_ORDERED];

    private int qtyOrdered = 0;

    public void addDigitalVideoDisc(DigitalVideoDisc disc) {
        if (qtyOrdered < MAX_NUMBERS_ORDERED) {
            itemsOrdered[qtyOrdered] = disc;
            qtyOrdered += 1;
            System.out.println("DVD added");
        } else {
            System.out.println("Maximum capacity reached");
        }
    }

    public void removeDigitalVideoDisc(DigitalVideoDisc disc) {
        boolean founded = false;
        for (int i = 0; i < qtyOrdered; i++) {
            if (itemsOrdered[i].equals(disc)) {
                itemsOrdered[i] = null;
                founded = true;
                for (int j = i; j < qtyOrdered; j++) {
                    itemsOrdered[j] = itemsOrdered[j + 1];
                } 
                qtyOrdered -= 1;
                System.out.println("DVD deleted");
            }
        }
        if (founded == false) {
            System.out.println("No DVD founded"); 
        }
    }
    
    public float totalCost() {
        float cost = 0;
        for (int i = 0; i < qtyOrdered; i++) {
			cost += itemsOrdered[i].getCost();
		}
		return cost;
    }
}
