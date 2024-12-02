package hust.soict.dsai.aims.store;

import hust.soict.dsai.aims.media.Media;
import java.util.ArrayList;
import java.util.List;

public class Store {

    private final int storeCapacity = 1000;
    private List<Media> itemsInStore = new ArrayList<>();

    public void addMedia(Media media) {

        if (itemsInStore.size() < storeCapacity) {
            itemsInStore.add(media);
            System.out.println("Media added");
        }
        else {
            System.out.println("Maximum capacity reached");
        }
    }

    public void removeMedia(Media media) {
        if (itemsInStore.contains(media)) {
            itemsInStore.remove(media);
        }
        else {
        System.out.println("No media found!");
        }
    }
    
    public void print() {
        for (Media media: itemsInStore) {
            System.out.println(media.toString());
        }
    }

    public Media searchById(int id) {
		boolean found = false;
		for (int i = 0; i < itemsInStore.size(); i++) {
			if (itemsInStore.get(i).getId() == id) {
				System.out.println("Media found: " + itemsInStore.get(i).toString());
				found = true;
				return itemsInStore.get(i);
			}
		}

		if (!found) {
			System.out.println("No Media found with ID: " + id);
		}
        return null;
	}

	public Media searchByTitle(String title) {
		boolean found = false;
		for (int i = 0; i < itemsInStore.size(); i++) {
			if (itemsInStore.get(i).getTitle().equals(title)) {
				System.out.println("Media found: " + itemsInStore.get(i).toString());
				found = true;
				return itemsInStore.get(i);
			}
		}

		if (!found) {
			System.out.println("No Media found with title: " + title);
		}
        return null;
    }
}
