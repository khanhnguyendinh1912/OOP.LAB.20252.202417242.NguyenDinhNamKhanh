package hust.soict.dsai.aims.media;

public class DVD extends Media {

    private String director;
    private int length;
    private String warranty;

    public DVD() {
    }

    public String getDirector() {
        return director;
    }

    public void setDirector(String director) {
        this.director = director;
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
}
