package hust.soict.dsai.aims.media;

import java.util.ArrayList;
import java.util.List;

public class CD extends Media {
    private String artist;
    private String director;
    private List<Track> tracks;

    public CD(int id, String title, String category, float cost, String artist, String director) {
        this.setId(id);
        this.setTitle(title);
        this.setCategory(category);
        this.setCost(cost);
        this.artist = artist;
        this.director = director;
        this.tracks = new ArrayList<>();
    }

    public String getArtist() {
        return artist;
    }

    public String getDirector() {
        return director;
    }

    public void addTrack(Track track) {
        if (track != null && !tracks.contains(track)) {
            tracks.add(track);
        }
    }

    public void removeTrack(Track track) {
        tracks.remove(track);
    }

    public List<Track> getTracks() {
        return new ArrayList<>(tracks);
    }

    public int getLength() {
        int totalLength = 0;
        for (Track track : tracks) {
            totalLength += track.getLength();
        }
        return totalLength;
    }

    public void displayInfo() {
        System.out.println("========== CD ==========");
        System.out.println("ID: " + this.getId());
        System.out.println("Title: " + this.getTitle());
        System.out.println("Category: " + this.getCategory());
        System.out.println("Artist: " + artist);
        System.out.println("Director: " + director);
        System.out.println("CD Length: " + getLength() + " seconds");
        System.out.println("Cost: $" + this.getCost());
        System.out.println("Tracks (" + tracks.size() + "):");
        if (tracks.isEmpty()) {
            System.out.println("  (No tracks)");
        } else {
            for (int i = 0; i < tracks.size(); i++) {
                Track track = tracks.get(i);
                System.out.println("  " + (i + 1) + ". " + track.getTitle() + " (" + track.getLength() + "s)");
            }
        }
        System.out.println("========================");
    }

    public void play() {
        System.out.println("========== NOW PLAYING CD ==========");
        System.out.println("CD Title: " + this.getTitle());
        System.out.println("CD Length: " + getLength() + " seconds");
        System.out.println("====================================");

        if (getLength() <= 0) {
            System.out.println("ERROR: CD has invalid length! Cannot play.");
            return;
        }

        System.out.println("\nTracks:");
        for (Track track : tracks) {
            if (track.getLength() <= 0) {
                System.out.println("ERROR: Cannot play track '" + track.getTitle() + "' - invalid length!");
            } else {
                track.play();
            }
        }
    }
}
