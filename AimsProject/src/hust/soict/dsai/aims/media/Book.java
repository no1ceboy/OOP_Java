package hust.soict.dsai.aims.media;

import java.util.ArrayList;
import java.util.List;

public class Book extends Media { 

    private List<String> authors = new ArrayList<>();

    public List<String> getAuthors() {
		return authors;
	}

    public Book() {
        // TODO Auto-generated constructor stub
    }

    public Book(String title, String category, float cost) {
        super(title,category,cost);
    }

    public void addAuthor(String authorName) {
        if (!authors.contains(authorName)) {
			authors.add(authorName);
		}
        else {
			System.out.println("Author already exist!");
		}
    }

    public void removeAuthor(String authorName) {
        if (!authors.contains(authorName)) {
			authors.remove(authorName);
		}
        else {
			System.out.println("No author found!");
		}
    }

    @Override
    public String toString() {
        return "Book" + " - " + this.getTitle() + " - " + this.getCategory() + " - " + this.getAuthors() + ": " + String.valueOf(this.getCost()) + "$";
    }
}

