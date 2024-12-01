package hust.soict.dsai.aims.media;

public abstract class Media extends java.lang.Object {
    private int id;
    private String title;
    private String category;
    private float cost;

    public Media() {
        // TODO Auto-generated constructor stub
        this.id = 0;
        this.title = "None";
        this.category = "None";
        this.cost = 0.0f;
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
        
    }
}
