package hust.soict.dsai.aims.store;

import hust.soict.dsai.aims.disc.DigitalVideoDisc;

public class Store {

    private final int storeCapacity = 1000;
    private DigitalVideoDisc itemsInStore[] = new DigitalVideoDisc[1000];

    private int qtyStore = 0;

    public void addDVD(DigitalVideoDisc disc) {

        if (qtyStore < storeCapacity) {
            itemsInStore[qtyStore] = disc;
            qtyStore += 1;
            System.out.println("DVD added");
        } else {
            System.out.println("Maximum capacity reached");
        }
    }

    public void removeDVD(DigitalVideoDisc disc) {

        boolean found = false;

        for (int i = 0; i < qtyStore; i++) {

            if (itemsInStore[i].equals(disc)) {
                itemsInStore[i] = null;
                found = true;
                for (int j = i; j < qtyStore; j++) {
                    itemsInStore[j] = itemsInStore[j + 1];
                } 
                qtyStore -= 1;
                System.out.println("DVD deleted");
            }
        }

        if (found == false) {
            System.out.println("No DVD founded"); 
        }
    }
}
