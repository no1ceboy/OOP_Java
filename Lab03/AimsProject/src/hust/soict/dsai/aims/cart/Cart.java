package hust.soict.dsai.aims.cart;
import hust.soict.dsai.aims.disc.DigitalVideoDisc;

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

    public void addDigitalVideoDisc(DigitalVideoDisc [] dvdList) {
        for (DigitalVideoDisc disc : dvdList) {
            if (qtyOrdered < MAX_NUMBERS_ORDERED) {
                itemsOrdered[qtyOrdered] = disc;
                qtyOrdered += 1;
                System.out.println("DVD list added");
            } else {
                System.out.println("Maximum capacity reached");
            }
        }
    }

    public void addDigitalVideoDisc(DigitalVideoDisc dvd1,DigitalVideoDisc dvd2) {
        
        if (qtyOrdered + 1 < MAX_NUMBERS_ORDERED) {
            itemsOrdered[qtyOrdered] = dvd1;
            itemsOrdered[qtyOrdered + 1] = dvd2;
            qtyOrdered += 2;
            System.out.println("2 DVD added");
        } else {
            System.out.println("Maximum capacity reached");
        }
    }

    public void removeDigitalVideoDisc(DigitalVideoDisc disc) {

        boolean found = false;

        for (int i = 0; i < qtyOrdered; i++) {

            if (itemsOrdered[i].equals(disc)) {
                itemsOrdered[i] = null;
                found = true;
                for (int j = i; j < qtyOrdered; j++) {
                    itemsOrdered[j] = itemsOrdered[j + 1];
                } 
                qtyOrdered -= 1;
                System.out.println("DVD deleted");
            }
        }

        if (found == false) {
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

    public void print() {
        System.out.println("***********************CART************************");
        System.out.println("Ordered Items:");

        for (int i = 0; i < qtyOrdered; i++) {

            System.out.print((i + 1) + ". DVD - ");

            if (itemsOrdered[i].getTitle() != null) {
                System.out.print(itemsOrdered[i].getTitle() + " - ");
            }
            if (itemsOrdered[i].getCategory() != null) {
                System.out.print(itemsOrdered[i].getCategory() + " - ");
            }
            if (itemsOrdered[i].getDirector() != null) {
                System.out.print(itemsOrdered[i].getDirector() + " - ");
            }
            if (itemsOrdered[i].getLength() != 0) {
                System.out.print(itemsOrdered[i].getLength() + ": ");
            }
            if (itemsOrdered[i].getCost() != 0) {
                System.out.println(itemsOrdered[i].getCost() + " $");
            }
        }
 
        System.out.println("Total cost: " + this.totalCost() + " $");

        System.out.println("***************************************************");
    }

    public void search(int id) {

        boolean found = false;

        for (int i = 0; i < qtyOrdered; i++) {

            if (itemsOrdered[i].isMatch(id)) {

                System.out.print("Found: " + (i + 1) + ". DVD - ");

                if (itemsOrdered[i].getTitle() != null) {
                    System.out.print(itemsOrdered[i].getTitle() + " - ");
                }
                if (itemsOrdered[i].getCategory() != null) {
                    System.out.print(itemsOrdered[i].getCategory() + " - ");
                }
                if (itemsOrdered[i].getDirector() != null) {
                    System.out.print(itemsOrdered[i].getDirector() + " - ");
                }
                if (itemsOrdered[i].getLength() != 0) {
                    System.out.print(itemsOrdered[i].getLength() + ": ");
                }
                if (itemsOrdered[i].getCost() != 0) {
                    System.out.println(itemsOrdered[i].getCost() + " $");
                }

                found = true;
            }
        } 
        if (found == false) {
            System.out.println("No match is found");
        }
    }

    public void search(String title) {

        boolean found = false;

        for (int i = 0; i < qtyOrdered; i++) {

            if (itemsOrdered[i].isMatch(title)) {

                System.out.print("Found: " + (i + 1) + ". DVD - ");

                if (itemsOrdered[i].getTitle() != null) {
                    System.out.print(itemsOrdered[i].getTitle() + " - ");
                }
                if (itemsOrdered[i].getCategory() != null) {
                    System.out.print(itemsOrdered[i].getCategory() + " - ");
                }
                if (itemsOrdered[i].getDirector() != null) {
                    System.out.print(itemsOrdered[i].getDirector() + " - ");
                }
                if (itemsOrdered[i].getLength() != 0) {
                    System.out.print(itemsOrdered[i].getLength() + ": ");
                }
                if (itemsOrdered[i].getCost() != 0) {
                    System.out.println(itemsOrdered[i].getCost() + " $");
                }

                found = true;
            }
        } 
        if (found == false) {
            System.out.println("No match is found");
        }
    }
}
