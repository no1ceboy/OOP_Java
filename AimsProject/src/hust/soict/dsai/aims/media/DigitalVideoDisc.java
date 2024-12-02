package hust.soict.dsai.aims.media;

public class DigitalVideoDisc extends Disc implements Playable {

    public DigitalVideoDisc(String title) {
        super(title, "None", "None", 0, 0.0f);
    }

    public DigitalVideoDisc(String title, String category, float cost) {
		super(title, category,"None",0, cost);
	}

	public DigitalVideoDisc(String title, String category, String director, float cost) {
		super(title, category, director,0, cost);
    }

	public DigitalVideoDisc(String title, String category, String director, int length, float cost) {
		super(title, category, director, length, cost);
	}

    @Override
    public String toString() {
        return "DVD" + " - " + this.getTitle() + " - " + this.getCategory() + " - " + this.getDirector() + " - " + String.valueOf(this.getLength()) + ": " + String.valueOf(this.getCost()) + "$";
    }

    @Override
	public void play() { 
		System.out.println("Playing DVD: " + this.getTitle()); 
		System.out.println("DVD length: " + this.getLength()); 
	}
}   
