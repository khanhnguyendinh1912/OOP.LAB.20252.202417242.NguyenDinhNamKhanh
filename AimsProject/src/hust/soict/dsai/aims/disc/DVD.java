package hust.soict.dsai.aims.disc;

public class DVD {

    private final String title;
    private final String categories;
    private final String director;
    private final float cost;
    private final int length;
    private final String warranty;

    public DVD(String title, String categories, String director,
               float cost, int length, String warranty) {
        this.title = title;
        this.categories = categories;
        this.director = director;
        this.cost = cost;
        this.length = length;
        this.warranty = warranty;
    }

    public void getTitle() {
        System.out.println("Title: " + title);
    }

    public void DVDdesc() {
        System.out.println("Title: " + title);
        System.out.println("Categories: " + categories);
        System.out.println("Director: " + director);
        System.out.println("Cost: " + cost);
        System.out.println("Length: " + length);
        System.out.println("Warranty: " + warranty);
    }

    public float getCost() {
        return cost;
    }

    public String getTitleValue() {
        return title;
    }

    public String getCategories() {
        return categories;
    }

    public String getDirector() {
        return director;
    }

    public int getLength() {
        return length;
    }

    public String getWarranty() {
        return warranty;
    }
}
