package hust.soict.dsai.aims.media;

import java.util.ArrayList;
import java.util.List;

public class CompactDisc extends Disc implements Playable {
    private String artist;
    private List<Track> tracks = new ArrayList<>();

    public String getArtist() {
        return artist;
    }

    public CompactDisc(String title, String category, int length, float cost, String artist) {
        super(title, category, "None", length, cost);
        this.artist = artist;
    }

    public void addTrack(Track track) {
        if (!tracks.contains(track)) {
			tracks.add(track);
		}
        else {
			System.out.println("Track already exist!");
		}
    }

    public void removeTrack(Track track) {
        if (!tracks.contains(track)) {
			tracks.remove(track);
		}
        else {
			System.out.println("No track found!");
		}
    }

    @Override
    public int getLength() {
        int totalLength = 0;
        for (int i = 0; i < tracks.size(); i++) {
            totalLength += tracks.get(i).getLength();
        }
        return totalLength;
    }

    @Override
    public String toString() {
        return "CD" + " - " + this.getTitle() + " - " + this.getCategory() + " - " + this.getArtist() + " - " + String.valueOf(this.getLength()) + ": " + String.valueOf(this.getCost()) + "$";
    }

    @Override
    public void play() { 
        System.out.println("Playing" + tracks.size() + "tracks: ");
        for (Track track: tracks) {
            track.play();
        }
    } 
}


