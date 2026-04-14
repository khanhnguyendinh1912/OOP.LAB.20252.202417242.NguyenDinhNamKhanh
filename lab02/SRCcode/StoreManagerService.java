import java.util.ArrayList;
import java.util.List;

public class StoreManagerService {

    public boolean loginManager(String username, String password) {
        return username != null && !username.isEmpty() && password != null && !password.isEmpty();
    }

    public boolean addDVD(DVD dvd) {
        if (dvd != null && dvd.getTitleValue() != null && !dvd.getTitleValue().isEmpty()) {
            System.out.println("DVD added: " + dvd.getTitleValue());
            return true;
        }
        return false;
    }

    public boolean removeDVD(String dvdId) {
        if (dvdId != null && !dvdId.isEmpty()) {
            System.out.println("DVD removed: " + dvdId);
            return true;
        }
        return false;
    }

    public boolean updateDVD(DVD dvd) {
        if (dvd != null && dvd.getTitleValue() != null && !dvd.getTitleValue().isEmpty()) {
            System.out.println("DVD updated: " + dvd.getTitleValue());
            return true;
        }
        return false;
    }

    public Inventory reviewInventory() {
        Inventory inventory = new Inventory();
        inventory.addItem("DVD001", 10, 9.99f);
        inventory.addItem("DVD002", 5, 12.99f);
        inventory.addItem("DVD003", 8, 14.99f);
        return inventory;
    }

    public List<Orders> viewOrders() {
        List<Orders> orders = new ArrayList<>();
        orders.add(new Orders("ORD001", "USER001", 25.99f, "Delivered", "123 Main St", "2026-04-10"));
        orders.add(new Orders("ORD002", "USER002", 35.50f, "Pending", "456 Oak Ave", "2026-04-12"));
        return orders;
    }

    public boolean updateOrderStatus(String orderId, String newStatus) {
        if (orderId != null && !orderId.isEmpty() && newStatus != null && !newStatus.isEmpty()) {
            System.out.println("Order " + orderId + " status updated to: " + newStatus);
            return true;
        }
        return false;
    }
}
