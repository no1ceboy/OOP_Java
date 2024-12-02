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

    public Disc(String title, String category, String director, int length, float cost) {
        super(title, category, cost);
        this.director = director;
        this.length = length;
    }

    @Override
    public String toString() {
        return "Disc" + "-" + this.getTitle() + "-" + this.getCategory() + "-" + this.getDirector() + "-" + String.valueOf(this.getLength()) + ": " + String.valueOf(this.getCost()) + "$";
    }
}
