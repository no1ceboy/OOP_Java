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
}
