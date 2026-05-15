package hust.soict.dsai.aims.disc;

public class DigitalVideoDisc {
    private static int nbDigitalVideoDiscs = 0;
    private int id;
    private String title;
    private String categories;
    private String director;
    private float cost;
    private int length;
    private String warranty;

    public DigitalVideoDisc(String title) {
        this.id = ++nbDigitalVideoDiscs;
        this.title = title;
        this.categories = "Unknown";
        this.director = "Unknown";
        this.cost = 0.0f;
        this.length = 0;
        this.warranty = "No warranty";
    }

    public DigitalVideoDisc(String title, String categories, String director,
                           float cost, int length, String warranty) {
        this.id = ++nbDigitalVideoDiscs;
        this.title = title;
        this.categories = categories;
        this.director = director;
        this.cost = cost;
        this.length = length;
        this.warranty = warranty;
    }

    public DigitalVideoDisc(String title, String categories, String director,
                           int length, float cost) {
        this.id = ++nbDigitalVideoDiscs;
        this.title = title;
        this.categories = categories;
        this.director = director;
        this.cost = cost;
        this.length = length;
        this.warranty = "No warranty";
    }

    public DigitalVideoDisc(String title, String categories, float cost) {
        this.id = ++nbDigitalVideoDiscs;
        this.title = title;
        this.categories = categories;
        this.director = "Unknown";
        this.cost = cost;
        this.length = 0;
        this.warranty = "No warranty";
    }

    public String getTitle() {
        return title;
    }

    public int getId() {
        return id;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getCategories() {
        return categories;
    }

    public void setCategories(String categories) {
        this.categories = categories;
    }

    public String getDirector() {
        return director;
    }

    public void setDirector(String director) {
        this.director = director;
    }

    public float getCost() {
        return cost;
    }

    public void setCost(float cost) {
        this.cost = cost;
    }

    public int getLength() {
        return length;
    }

    public void setLength(int length) {
        this.length = length;
    }

    public String getWarranty() {
        return warranty;
    }

    public void setWarranty(String warranty) {
        this.warranty = warranty;
    }

    public void displayInfo() {
        System.out.println("Title: " + title + " | Director: " + director + 
                         " | Category: " + categories + " | Price: $" + cost);
    }

    @Override
    public String toString() {
        return "DVD - " + title + " - " + categories + " - " + director + 
               " - " + length + ": " + cost + " $";
    }

    public boolean isMatch(String searchTitle) {
        return title.toLowerCase().contains(searchTitle.toLowerCase());
    }
}
