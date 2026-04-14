import java.util.ArrayList;
import java.util.List;

public class Cart {

    private float calculateCost;
    private int quantityOrder;
    private final List<DVD> dvdList;

    public Cart() {
        this.dvdList = new ArrayList<>();
        this.calculateCost = 0;
        this.quantityOrder = 0;
    }

    public void addProduct(DVD dvd) {
        dvdList.add(dvd);
        quantityOrder++;
        calculateCost += dvd.getCost();
    }

    public void removeProduct(DVD dvd) {
        dvdList.remove(dvd);
        quantityOrder--;
        calculateCost -= dvd.getCost();
    }

    public float getCalculateCost() {
        
        return calculateCost;
    }

    public int getQuantityOrder() {
        return quantityOrder;
    }

    public List<DVD> getDvdList() {
        return dvdList;
    }
}