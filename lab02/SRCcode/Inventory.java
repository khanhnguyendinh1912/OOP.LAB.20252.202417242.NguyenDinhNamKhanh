import java.util.ArrayList;
import java.util.List;

public class Inventory {
    private final List<String> dvdIds;
    private final List<Integer> quantities;
    private final List<Float> prices;

    public Inventory() {
        this.dvdIds = new ArrayList<>();
        this.quantities = new ArrayList<>();
        this.prices = new ArrayList<>();
    }

    public void addItem(String dvdId, int quantity, float price) {
        dvdIds.add(dvdId);
        quantities.add(quantity);
        prices.add(price);
    }

    public void removeItem(String dvdId) {
        int index = dvdIds.indexOf(dvdId);
        if (index != -1) {
            dvdIds.remove(index);
            quantities.remove(index);
            prices.remove(index);
        }
    }

    public void updateQuantity(String dvdId, int newQuantity) {
        int index = dvdIds.indexOf(dvdId);
        if (index != -1) {
            quantities.set(index, newQuantity);
        }
    }

    public int getQuantity(String dvdId) {
        int index = dvdIds.indexOf(dvdId);
        if (index != -1) {
            Integer qty = quantities.get(index);
            return qty != null ? qty : 0;
        }
        return 0;
    }

    public List<String> getDvdIds() {
        return dvdIds;
    }

    public List<Integer> getQuantities() {
        return quantities;
    }

    public List<Float> getPrices() {
        return prices;
    }

    public void displayInventory() {
        System.out.println("=== Inventory ===");
        for (int i = 0; i < dvdIds.size(); i++) {
            System.out.println("DVD ID: " + dvdIds.get(i) + ", Quantity: " + quantities.get(i) + ", Price: $" + prices.get(i));
        }
    }
}
