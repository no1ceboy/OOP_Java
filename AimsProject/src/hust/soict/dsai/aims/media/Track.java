package hust.soict.dsai.aims.media;

public class Track implements Playable {
    
    private String title;
    private int length;

    public Track(String title, int length) {
        this.title = title;
        this.length = length;
    }

    public String getTitle() {
        return title;
    }

    public int getLength() {    
        return length;
    }

    @Override
    public void play() { 
        System.out.println("Playing track: " + this.getTitle()); 
        System.out.println("Track length: " + this.getLength()); 
    }

    @Override
    public boolean equals(Object o) {
        Track track = (Track) o;
        return (this.getTitle() == null ? track.getTitle() == null : this.getTitle().equals(track.getTitle()) & 
                this.getLength() == null ? track.getLength() == null : this.getLength() == track.getLength());
    }
}