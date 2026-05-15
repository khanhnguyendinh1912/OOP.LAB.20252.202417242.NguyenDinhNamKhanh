package hust.soict.dsai.aims.media;

public class DigitalVideoDisc extends Disc implements Playable {

    @Override
    public void play() {
        System.out.println("Playing DVD: " + this.getTitle());
        System.out.println("DVD length: " + this.getLength());
    }

    private static int nbDigitalVideoDiscs = 0;
    private String warranty;

    public DigitalVideoDisc(String title) {
        super(++nbDigitalVideoDiscs, title, "Unknown", 0.0f, 0, "Unknown");
        this.warranty = "No warranty";
    }

    public DigitalVideoDisc(String title, String category, String director,
                           float cost, int length, String warranty) {
        super(++nbDigitalVideoDiscs, title, category, cost, length, director);
        this.warranty = warranty;
    }

    public DigitalVideoDisc(String title, String category, String director,
                           int length, float cost) {
        super(++nbDigitalVideoDiscs, title, category, cost, length, director);
        this.warranty = "No warranty";
    }

    public DigitalVideoDisc(String title, String category, float cost) {
        super(++nbDigitalVideoDiscs, title, category, cost, 0, "Unknown");
        this.warranty = "No warranty";
    }

    public String getWarranty() {
        return warranty;
    }

    public void setWarranty(String warranty) {
        this.warranty = warranty;
    }

    public void displayInfo() {
        System.out.println("Title: " + this.getTitle() + " | Director: " + this.getDirector() + 
                         " | Category: " + this.getCategory() + " | Price: $" + this.getCost());
    }

    @Override
    public String toString() {
        return "DVD - " + this.getTitle() + " - " + this.getCategory() + " - " + this.getDirector() + 
               " - " + this.getLength() + ": " + this.getCost() + " $";
    }

    public boolean isMatch(String searchTitle) {
        return this.getTitle().toLowerCase().contains(searchTitle.toLowerCase());
    }
}
