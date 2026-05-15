package hust.soict.dsai.aims.cart;

import hust.soict.dsai.aims.media.Media;
import java.util.ArrayList;
import java.util.List;

public class Cart {
    private ArrayList<Media> itemsOrdered = new ArrayList<>();

    public void clear() {
        itemsOrdered.clear();
    }


    public Cart() {
        this.itemsOrdered = new ArrayList<>();
    }

    public void addMedia(Media media) {
        if (media != null) {
            itemsOrdered.add(media);
        }
    }

    public void addMedia(Media[] mediaArray) {
        if (mediaArray != null && mediaArray.length > 0) {
            for (Media media : mediaArray) {
                if (media != null) {
                    itemsOrdered.add(media);
                }
            }
        }
    }

    public void addMedia(Media media1, Media media2) {
        if (media1 != null && media2 != null) {
            itemsOrdered.add(media1);
            itemsOrdered.add(media2);
        }
    }

    public void addMedia(Media media1, Media media2, Media media3) {
        if (media1 != null && media2 != null && media3 != null) {
            itemsOrdered.add(media1);
            itemsOrdered.add(media2);
            itemsOrdered.add(media3);
        }
    }

    public void removeMedia(Media media) {
        if (itemsOrdered.contains(media)) {
            itemsOrdered.remove(media);
        }
    }

    public float totalCost() {
        float total = 0;
        for (Media media : itemsOrdered) {
            total += media.getCost();
        }
        return total;
    }

    // Backward-compatible alias
    public float getTotalCost() {
        return totalCost();
    }


    public int getQuantityOrdered() {
        return itemsOrdered.size();
    }

    public List<Media> getItemsOrdered() {
        return new ArrayList<>(itemsOrdered);
    }

    public void sortByTitle() {
        java.util.Collections.sort(itemsOrdered, Media.COMPARE_BY_TITLE_COST);
    }

    public void sortByCost() {
        java.util.Collections.sort(itemsOrdered, Media.COMPARE_BY_COST_TITLE);
    }

    public void printCart() {
        System.out.println("\n***********************CART***********************");
        if (itemsOrdered.isEmpty()) {
            System.out.println("Cart is empty");
        } else {
            System.out.println("Ordered Items (" + itemsOrdered.size() + "):");
            int itemNumber = 1;
            for (Media media : itemsOrdered) {
                System.out.println(itemNumber + ". " + media.getTitle() +
                                 " - " + media.getCategory() +
                                 " - $" + media.getCost());
                itemNumber++;
            }
        }
        System.out.println("Total Cost: $" + totalCost());

        System.out.println("***************************************************\n");
    }

    public void searchCartByTitle(String title) {
        System.out.println("\nSearching for items with title: " + title);
        int resultNumber = 1;
        boolean found = false;
        for (Media media : itemsOrdered) {
            if (media.getTitle().toLowerCase().contains(title.toLowerCase())) {
                System.out.println(resultNumber + ". " + media.getTitle() + 
                                 " - " + media.getCategory() + 
                                 " - $" + media.getCost());
                found = true;
                resultNumber++;
            }
        }
        if (!found) {
            System.out.println("No item found with title: " + title);
        }
    }

    public void playMedia(int index) {
        if (index >= 0 && index < itemsOrdered.size()) {
            System.out.println("Playing: " + itemsOrdered.get(index).getTitle());
        } else {
            System.out.println("Invalid media index!");
        }
    }

    public void displayCart() {
        System.out.println("\n***********************CART DETAILS***********************");
        if (itemsOrdered.isEmpty()) {
            System.out.println("Cart is empty");
        } else {
            for (int i = 0; i < itemsOrdered.size(); i++) {
                System.out.println("\n[" + (i + 1) + "]");
                Media media = itemsOrdered.get(i);
                System.out.println("Title: " + media.getTitle() + " | Category: " + media.getCategory() + " | Cost: $" + media.getCost());
            }
        }
        System.out.println("***********************************************************\n");
    }

    // Adapter method for the legacy hierarchy (aims.disc.DVD)
    public void addDigitalVideoDisc(hust.soict.dsai.aims.disc.DVD dvd) {

        if (dvd == null) return;
        // Map legacy DVD -> aims.media.DigitalVideoDisc
        hust.soict.dsai.aims.media.DigitalVideoDisc mediaDvd =
                new hust.soict.dsai.aims.media.DigitalVideoDisc(
                        dvd.getTitleValue(),
                        dvd.getCategories(),
                        dvd.getDirector(),
                        dvd.getCost(),
                        dvd.getLength(),
                        dvd.getWarranty()
                );
        addMedia(mediaDvd);
    }


    public void addDigitalVideoDisc(Media dvd) {
        addMedia(dvd);
    }

    public void searchCartById(int id) {
        System.out.println("\nSearching for items with id: " + id);
        int resultNumber = 1;
        boolean found = false;
        for (Media media : itemsOrdered) {
            if (media.getId() == id) {
                System.out.println(resultNumber + ". " + media.getTitle() +
                        " - " + media.getCategory() +
                        " - $" + media.getCost());
                resultNumber++;
                found = true;
            }
        }
        if (!found) {
            System.out.println("No item found with id: " + id);
        }
    }
}

