import java.util.ArrayList;
import java.util.List;

public class DVDList {
    private List<DVD> dvdList;

    public DVDList() {
        this.dvdList = new ArrayList<>();
    }

    // Add a DVD to the list
    public void addDVD(DVD dvd) {
        if (dvd != null) {
            dvdList.add(dvd);
            System.out.println("DVD added: " + dvd.getTitleValue());
        }
    }

    // Remove a DVD from the list by index
    public void removeDVDByIndex(int index) {
        if (index >= 0 && index < dvdList.size()) {
            DVD removed = dvdList.remove(index);
            System.out.println("DVD removed: " + removed.getTitleValue());
        } else {
            System.out.println("Invalid index!");
        }
    }

    // Remove a DVD from the list by title
    public void removeDVDByTitle(String title) {
        for (int i = 0; i < dvdList.size(); i++) {
            if (dvdList.get(i).getTitleValue().equalsIgnoreCase(title)) {
                DVD removed = dvdList.remove(i);
                System.out.println("DVD removed: " + removed.getTitleValue());
                return;
            }
        }
        System.out.println("DVD not found: " + title);
    }

    // Get a DVD by index
    public DVD getDVDByIndex(int index) {
        if (index >= 0 && index < dvdList.size()) {
            return dvdList.get(index);
        }
        System.out.println("Invalid index!");
        return null;
    }

    // Get a DVD by title
    public DVD getDVDByTitle(String title) {
        for (DVD dvd : dvdList) {
            if (dvd.getTitleValue().equalsIgnoreCase(title)) {
                return dvd;
            }
        }
        System.out.println("DVD not found: " + title);
        return null;
    }

    // Set (update) a DVD at a specific index
    public void setDVD(int index, DVD dvd) {
        if (index >= 0 && index < dvdList.size() && dvd != null) {
            DVD old = dvdList.set(index, dvd);
            System.out.println("DVD updated: " + old.getTitleValue() + " -> " + dvd.getTitleValue());
        } else {
            System.out.println("Invalid index or DVD!");
        }
    }

    // Get the entire list
    public List<DVD> getDVDList() {
        return new ArrayList<>(dvdList);
    }

    // Set the entire list
    public void setDVDList(List<DVD> newList) {
        if (newList != null) {
            this.dvdList = new ArrayList<>(newList);
            System.out.println("DVD list updated with " + dvdList.size() + " items");
        }
    }

    // Get the size of the list
    public int getSize() {
        return dvdList.size();
    }

    // Check if a DVD exists in the list
    public boolean containsDVD(String title) {
        for (DVD dvd : dvdList) {
            if (dvd.getTitleValue().equalsIgnoreCase(title)) {
                return true;
            }
        }
        return false;
    }

    // Display all DVDs in the list
    public void displayAllDVDs() {
        if (dvdList.isEmpty()) {
            System.out.println("DVD list is empty!");
            return;
        }
        System.out.println("=== DVD List (" + dvdList.size() + " items) ===");
        for (int i = 0; i < dvdList.size(); i++) {
            DVD dvd = dvdList.get(i);
            System.out.println((i + 1) + ". " + dvd.getTitleValue() + " | Director: " + dvd.getDirector() 
                    + " | Category: " + dvd.getCategories() + " | Price: $" + dvd.getCost() 
                    + " | Length: " + dvd.getLength() + " min | Warranty: " + dvd.getWarranty());
        }
    }

    // Clear the entire list
    public void clearList() {
        dvdList.clear();
        System.out.println("DVD list cleared!");
    }
}
