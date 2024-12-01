package hust.soict.dsai.aims.media;

import java.util.ArrayList;
import java.util.List;

public class CompactDisc extends Disc implements Playable {
    private String artist;
    private List<Track> tracks = new ArrayList<>();

    public String getArtist() {
        return artist;
    }

    public CompactDisc(String artist, List<Track> tracks) {
        super();
        this.artist = artist;
        this.tracks = tracks;
    }

    public void addTrack(Track track) {
        if (!tracks.contains(track)) {
			tracks.add(track);
		}
        else {
			System.out.println("track already exist!");
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
    public void play() { 
        System.out.println("Playing" + tracks.size() + "tracks: ");
        for (Track track: tracks) {
            track.play();
        }
    } 
}


