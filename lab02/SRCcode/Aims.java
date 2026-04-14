public class Aims {
    public static void main(String[] args) {        
        testStoreManager();
        System.out.println("\n" + "=".repeat(50) + "\n");
        
        testUserService();
        System.out.println("\n" + "=".repeat(50) + "\n");
        
        testCart();
        System.out.println("\n" + "=".repeat(50) + "\n");
        
        testDVDList();
    }

    public static void testStoreManager() {
        System.out.println(">>> TESTING STORE MANAGER SERVICE <<<\n");
        
        StoreManagerService manager = new StoreManagerService();
        
        // Test login
        System.out.println("1. Testing Manager Login:");
        boolean loginSuccess = manager.loginManager("admin", "password123");
        System.out.println("   Login result: " + (loginSuccess ? "SUCCESS" : "FAILED"));
        
        // Test inventory
        System.out.println("\n2. Reviewing Inventory:");
        Inventory inventory = manager.reviewInventory();
        inventory.displayInventory();
        
        // Test add DVD
        System.out.println("\n3. Adding DVD:");
        DVD newDvd = new DVD("The Matrix", "Sci-Fi", "The Wachowskis", 19.99f, 136, "2 years");
        boolean addResult = manager.addDVD(newDvd);
        System.out.println("   Add result: " + (addResult ? "SUCCESS" : "FAILED"));
        
        // Test view orders
        System.out.println("\n4. Viewing Orders:");
        var orders = manager.viewOrders();
        for (Orders order : orders) {
            order.displayOrderDetails();
            System.out.println();
        }
        
        // Test update order status
        System.out.println("5. Updating Order Status:");
        boolean updateResult = manager.updateOrderStatus("ORD001", "Shipped");
        System.out.println("   Update result: " + (updateResult ? "SUCCESS" : "FAILED"));
    }

    public static void testUserService() {
        System.out.println(">>> TESTING USER SERVICE <<<\n");
        
        UserService userService = new UserService();
        
        // Test user login
        System.out.println("1. Testing User Login:");
        boolean userLogin = userService.loginUser("john_doe", "password123");
        System.out.println("   Login result: " + (userLogin ? "SUCCESS" : "FAILED"));
        
        // Test registration
        System.out.println("\n2. Registering New User:");
        boolean registerResult = userService.register("Jane Smith, jane@example.com, 123 Main St");
        System.out.println("   Registration result: " + (registerResult ? "SUCCESS" : "FAILED"));
        
        // Test search media
        System.out.println("\n3. Searching for Media:");
        var searchResults = userService.searchMedia("Action");
        System.out.println("   Found " + searchResults.size() + " results:");
        for (Media media : searchResults) {
            System.out.println("   - " + media.getTitle() + " (" + media.getCategory() + ") - $" + media.getPrice());
        }
        
        // Test view media
        System.out.println("\n4. Viewing Specific Media:");
        Media media = userService.viewMedia("M001");
        if (media != null) {
            System.out.println("   Title: " + media.getTitle());
            System.out.println("   Category: " + media.getCategory());
            System.out.println("   Price: $" + media.getPrice());
            System.out.println("   Description: " + media.getDescription());
        }
        
        // Test add to cart
        System.out.println("\n5. Adding Item to Cart:");
        boolean addToCartResult = userService.addToCart("M001");
        System.out.println("   Add to cart result: " + (addToCartResult ? "SUCCESS" : "FAILED"));
        
        // Test track orders
        System.out.println("\n6. Tracking Orders:");
        Orders trackedOrder = userService.trackOrders("ORD001");
        if (trackedOrder != null) {
            trackedOrder.displayOrderDetails();
        }
    }

    public static void testCart() {
        System.out.println(">>> TESTING SHOPPING CART <<<\n");
        
        Cart cart = new Cart();
        
        // Add multiple DVDs
        System.out.println("1. Adding DVDs to Cart:");
        DVD dvd1 = new DVD("Inception", "Sci-Fi", "Christopher Nolan", 14.99f, 148, "2 years");
        DVD dvd2 = new DVD("The Dark Knight", "Action", "Christopher Nolan", 12.99f, 152, "2 years");
        DVD dvd3 = new DVD("Interstellar", "Sci-Fi", "Christopher Nolan", 16.99f, 169, "3 years");
        
        cart.addProduct(dvd1);
        System.out.println("   Added: " + dvd1.getTitleValue());
        cart.addProduct(dvd2);
        System.out.println("   Added: " + dvd2.getTitleValue());
        cart.addProduct(dvd3);
        System.out.println("   Added: " + dvd3.getTitleValue());
        
        // Display cart summary
        System.out.println("\n2. Cart Summary:");
        System.out.println("   Total Items: " + cart.getQuantityOrder());
        System.out.println("   Total Cost: $" + cart.getCalculateCost());
        
        // Display all items in cart
        System.out.println("\n3. Items in Cart:");
        var items = cart.getDvdList();
        for (int i = 0; i < items.size(); i++) {
            DVD dvd = items.get(i);
            System.out.println("   " + (i + 1) + ". " + dvd.getTitleValue() + " - $" + dvd.getCost());
        }
        
        // Test remove product
        System.out.println("\n4. Removing Item from Cart:");
        cart.removeProduct(dvd2);
        System.out.println("   Removed: " + dvd2.getTitleValue());
        System.out.println("   New Total Items: " + cart.getQuantityOrder());
        System.out.println("   New Total Cost: $" + cart.getCalculateCost());
        
        // Simulate checkout
        System.out.println("\n5. Simulating Checkout:");
        UserService userService = new UserService();
        Orders order = userService.placeOrder(cart);
        if (order != null) {
            System.out.println("   Order placed successfully!");
            order.displayOrderDetails();
        } else {
            System.out.println("   Order placement failed!");
        }
    }

    public static void testDVDList() {
        System.out.println(">>> TESTING DVD LIST <<<\n");
        
        DVDList dvdList = new DVDList();
        
        // Test adding DVDs
        System.out.println("1. Adding DVDs to List:");
        DVD dvd1 = new DVD("Inception", "Sci-Fi", "Christopher Nolan", 14.99f, 148, "2 years");
        DVD dvd2 = new DVD("The Dark Knight", "Action", "Christopher Nolan", 12.99f, 152, "2 years");
        DVD dvd3 = new DVD("Interstellar", "Sci-Fi", "Christopher Nolan", 16.99f, 169, "3 years");
        DVD dvd4 = new DVD("Pulp Fiction", "Crime", "Quentin Tarantino", 9.99f, 154, "2 years");
        
        dvdList.addDVD(dvd1);
        dvdList.addDVD(dvd2);
        dvdList.addDVD(dvd3);
        dvdList.addDVD(dvd4);
        
        // Test display all
        System.out.println("\n2. Displaying All DVDs:");
        dvdList.displayAllDVDs();
        
        // Test get by title
        System.out.println("\n3. Getting DVD by Title:");
        DVD retrieved = dvdList.getDVDByTitle("Inception");
        if (retrieved != null) {
            System.out.println("   Found: " + retrieved.getTitleValue() + " - Director: " + retrieved.getDirector());
        }
        
        // Test get by index
        System.out.println("\n4. Getting DVD by Index (index 1):");
        DVD byIndex = dvdList.getDVDByIndex(1);
        if (byIndex != null) {
            System.out.println("   Found: " + byIndex.getTitleValue());
        }
        
        // Test list size
        System.out.println("\n5. DVD List Size: " + dvdList.getSize());
        
        // Test contains
        System.out.println("\n6. Checking if DVD exists:");
        System.out.println("   'The Matrix' exists? " + dvdList.containsDVD("The Matrix"));
        System.out.println("   'Inception' exists? " + dvdList.containsDVD("Inception"));
        
        // Test set (update)
        System.out.println("\n7. Updating a DVD:");
        DVD updatedDVD = new DVD("Inception (Extended)", "Sci-Fi", "Christopher Nolan", 18.99f, 160, "3 years");
        dvdList.setDVD(0, updatedDVD);
        
        // Test remove by title
        System.out.println("\n8. Removing DVD by Title:");
        dvdList.removeDVDByTitle("Pulp Fiction");
        
        // Test display after modifications
        System.out.println("\n9. Displaying Updated DVD List:");
        dvdList.displayAllDVDs();
        
        // Test get list
        System.out.println("\n10. Getting entire DVD list as copy:");
        var list = dvdList.getDVDList();
        System.out.println("   Retrieved " + list.size() + " DVDs");
        
        // Test remove by index
        System.out.println("\n11. Removing DVD by Index (index 1):");
        dvdList.removeDVDByIndex(1);
        
        // Final display
        System.out.println("\n12. Final DVD List:");
        dvdList.displayAllDVDs();
    }
}
