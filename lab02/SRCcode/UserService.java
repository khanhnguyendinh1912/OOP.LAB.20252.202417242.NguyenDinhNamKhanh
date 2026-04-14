import java.util.ArrayList;
import java.util.List;

public class UserService {

    public boolean loginUser(String username, String password) {
        return username != null && !username.isEmpty() && password != null && !password.isEmpty() && password.length() >= 6;
    }

    public boolean register(String userDetails) {
        if (userDetails != null && !userDetails.isEmpty()) {
            System.out.println("User registered successfully: " + userDetails);
            return true;
        }
        return false;
    }

    public List<Media> searchMedia(String keyword) {
        List<Media> results = new ArrayList<>();
        if (keyword != null && !keyword.isEmpty()) {
            results.add(new Media("M001", "Action Movie", "Action", 9.99f, "An exciting action film"));
            results.add(new Media("M002", "Drama Series", "Drama", 12.99f, "An engaging drama series"));
        }
        return results;
    }

    public Media viewMedia(String mediaId) {
        if (mediaId != null && !mediaId.isEmpty()) {
            return new Media(mediaId, "Sample Media", "General", 9.99f, "Media details here");
        }
        return null;
    }

    public boolean addToCart(String mediaId) {
        if (mediaId != null && !mediaId.isEmpty()) {
            System.out.println("Item " + mediaId + " added to cart");
            return true;
        }
        return false;
    }

    public Cart viewCart() {
        return new Cart();
    }

    public boolean updateCart(Cart updatedCart) {
        if (updatedCart != null && updatedCart.getQuantityOrder() > 0) {
            System.out.println("Cart updated with " + updatedCart.getQuantityOrder() + " items");
            return true;
        }
        return false;
    }

    public Orders placeOrder(Cart cart) {
        boolean shippingEntered = enterShippingInfo("123 Main St...");
        boolean paymentProcessed = processPayment(cart.getCalculateCost());

        if (shippingEntered && paymentProcessed) {
            return new Orders("ORD001", "USER001", cart.getCalculateCost(), "Pending", "123 Main St", "2026-04-14");
        }
        return null;
    }

    public Orders trackOrders(String orderId) {
        if (orderId != null && !orderId.isEmpty()) {
            return new Orders(orderId, "USER001", 25.99f, "Shipped", "123 Main St", "2026-04-12");
        }
        return null;
    }

    private boolean processPayment(double amount) {
        if (amount > 0) {
            System.out.println("Processing payment of $" + amount);
            return true;
        }
        return false;
    }

    private boolean enterShippingInfo(String shippingDetails) {
        if (shippingDetails != null && !shippingDetails.isEmpty()) {
            System.out.println("Shipping address saved: " + shippingDetails);
            return true;
        }
        return false;
    }
}
