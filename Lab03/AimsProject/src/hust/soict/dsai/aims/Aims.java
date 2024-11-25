package hust.soict.dsai.aims;

import hust.soict.dsai.aims.cart.Cart;
import hust.soict.dsai.aims.disc.DigitalVideoDisc;

public class Aims {

    public static void main(String[] args) {

        Cart myOrder = new Cart();
    
        DigitalVideoDisc dvd1 = new DigitalVideoDisc("The Lion King", 
            "Animation", "Roger Allers", 87, 19.95f);
        myOrder.addDigitalVideoDisc(dvd1);
    
        DigitalVideoDisc dvd2 = new DigitalVideoDisc("Star Wars", 
            "Science Fiction", "George Lucas", 87, 24.95f);
        myOrder.addDigitalVideoDisc(dvd2);
    
        DigitalVideoDisc dvd3 = new DigitalVideoDisc("Aladin", 
            "Animation", 18.99f);
        myOrder.addDigitalVideoDisc(dvd3);
    
        System.out.println("Total Cost is: ");
        System.out.println(myOrder.totalCost());

        myOrder.removeDigitalVideoDisc(dvd2);
		System.out.println("Total cost: ");
		System.out.println(myOrder.totalCost());
    }
}
