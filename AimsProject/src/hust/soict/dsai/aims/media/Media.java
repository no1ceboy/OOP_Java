package hust.soict.dsai.aims.media;

import java.util.Collections;
import java.util.Comparator;
import java.util.List;

public abstract class Media {

    public static final Comparator<Media> COMPARE_BY_TITLE_COST = new MediaComparatorByTitleCost();
    public static final Comparator<Media> COMPARE_BY_COST_TITLE = new MediaComparatorByCostTitle();
    
    private int id;
    private String title;
    private String category;
    private float cost;

    private static int mediaId = 0;

    public Media() {

	}

    public Media(String title, String category, float cost) {
		this.title = title;
		this.category = category;
		this.cost = cost;
        this.id = mediaId;
        mediaId += 1;
	}

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getCategory() {
        return category;
    }

    public void setCategory(String category) {
        this.category = category;
    }

    public float getCost() {
        return cost;
    }

    public void setCost(float cost) {
        this.cost = cost;
    }

    public boolean isMatch(String title) {
        return (title.equals(this.title));
    }

    public boolean isMatch(int id) {
        return (id == this.id);
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) {
            return true;
        }
        if (o == null || this.getClass() != o.getClass()) {
            return false;
        }
        Media media = (Media) o;
        return this.getTitle().equals(media.getTitle());
    }

    // Sorting methods
    public static void sortByTitleCost(List<Media> collection) {
        Collections.sort(collection, COMPARE_BY_TITLE_COST);
    }

    public static void sortByCostTitle(List<Media> collection) {
        Collections.sort(collection, COMPARE_BY_COST_TITLE);
    }
    
    @Override
    public abstract String toString();
}
