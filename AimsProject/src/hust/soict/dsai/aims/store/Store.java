package hust.soict.dsai.aims.store;

import hust.soict.dsai.aims.disc.DVD;
import hust.soict.dsai.aims.media.Media;
import java.util.ArrayList;
import java.util.List;



public class Store {
    private final List<Media> itemsInStore;

    public Store() {
        this.itemsInStore = new ArrayList<>();
    }

    public Store(int capacity) {
        this.itemsInStore = new ArrayList<>();
    }

    public boolean addMedia(Media media) {
        if (media == null) {
            return false;
        }
        itemsInStore.add(media);
        return true;
    }

    public boolean removeMedia(Media media) {
        if (media == null) {
            return false;
        }
        return itemsInStore.remove(media);
    }

    public void displayStore() {
        System.out.println("\n=== STORE INVENTORY ===");
        System.out.println("Total items: " + itemsInStore.size());
        if (itemsInStore.isEmpty()) {
            System.out.println("Store is empty");
        } else {
            for (int i = 0; i < itemsInStore.size(); i++) {
                System.out.println((i + 1) + ". " + itemsInStore.get(i).getTitle() + 
                                 " - " + itemsInStore.get(i).getCategory() + 
                                 " - $" + itemsInStore.get(i).getCost());
            }
        }
        System.out.println("=======================\n");
    }

    public void displayStoreDetails() {
        System.out.println("\n========== STORE DETAILS ==========");
        System.out.println("Total items: " + itemsInStore.size());
        if (itemsInStore.isEmpty()) {
            System.out.println("Store is empty");
        } else {
            for (int i = 0; i < itemsInStore.size(); i++) {
                System.out.println("\n[" + (i + 1) + "]");
                Media media = itemsInStore.get(i);
                System.out.println("Title: " + media.getTitle() + " | Category: " + media.getCategory() + " | Cost: $" + media.getCost());
            }
        }
        System.out.println("====================================\n");
    }

    public int getItemCount() {
        return itemsInStore.size();
    }

    public List<Media> getItemsInStore() {
        return new ArrayList<>(itemsInStore);
    }

    public Media getMedia(int index) {
        if (index >= 0 && index < itemsInStore.size()) {
            return itemsInStore.get(index);
        }
        return null;
    }

    public void playMedia(int index) {
        Media media = getMedia(index);
        if (media != null) {
            System.out.println("Playing: " + media.getTitle());
        } else {
            System.out.println("Invalid media index!");
        }
    }

    // --- Compatibility/adapters for legacy aims.disc.DVD ---
    // Keep addDVD/removeDVD to support existing DVD-based test classes.
    public boolean addDVD(DVD dvd) {
        return addMedia(legacyToMedia(dvd));
    }


    public boolean removeDVD(DVD dvd) {
        if (dvd == null) return false;
        // remove by matching title
        for (Media m : new ArrayList<>(itemsInStore)) {
            if (m.getTitle() != null && m.getTitle().equals(dvd.getTitleValue())) {
                return removeMedia(m);
            }
        }
        return false;
    }

    private Media legacyToMedia(DVD dvd) {
        if (dvd == null) return null;
        return new hust.soict.dsai.aims.media.DigitalVideoDisc(
                dvd.getTitleValue(),
                dvd.getCategories(),
                dvd.getDirector(),
                dvd.getCost(),
                dvd.getLength(),
                dvd.getWarranty()
        );
    }
}


