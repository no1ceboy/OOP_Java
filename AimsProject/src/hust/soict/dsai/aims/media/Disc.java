package hust.soict.dsai.aims.media;

public class Disc extends Media {
    private String director;
    private int length;

    public String getDirector() {
        return director;
    }
    
    public int getLength() {
        return length;
    }

    public void setDirector(String director) {
        this.director = director;
    }
    
    public void setLength(int length) {
        this.length =  length;
    }

    public Disc() {
        super();
        this.director = "None";
        this.length = 0;
    }
}
