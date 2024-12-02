package hust.soict.dsai.test.polymorphism;

import hust.soict.dsai.aims.media.Book;
import hust.soict.dsai.aims.media.CompactDisc;
import hust.soict.dsai.aims.media.DigitalVideoDisc;
import hust.soict.dsai.aims.media.Media;
import hust.soict.dsai.aims.media.Track;
import java.util.ArrayList;
import java.util.List;

public class PolymorphismTest {
    public static void main(String[] args) {
        List<Media> media = new ArrayList<>();

        Track track1 = new Track("Gosia", 3);
        Track track2 = new Track("David", 4);
        CompactDisc cd = new CompactDisc("Low Roar","Indie",80,5.5f,"Ryan");
        cd.addTrack(track1);
        cd.addTrack(track2);

        DigitalVideoDisc dvd = new DigitalVideoDisc("Spider Man");

        Book book = new Book("Mein Kampf", "History", 4.2f);
        
        media.add(cd);
        media.add(dvd);
        media.add(book);

        for (Media m : media) {
            System.out.println(m.toString());
        }
    }
}
