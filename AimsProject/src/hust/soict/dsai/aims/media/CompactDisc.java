package hust.soict.dsai.aims.media;

import java.util.ArrayList;
import java.util.List;

public class CompactDisc extends Disc implements Playable {

    @Override
    public void play() {
        System.out.println("Playing Compact Disc: " + this.getTitle());
        System.out.println("CD length: " + getLength());
        for (Track track : tracks) {
            if (track != null) {
                track.play();
            }
        }
    }


    private String artist;
    private ArrayList<Track> tracks;

    public CompactDisc() {
        super();
        this.tracks = new ArrayList<>();
    }


    public CompactDisc(int id, String title, String category, float cost,
                         int length, String director,
                         String artist) {
        super(id, title, category, cost, length, director);
        this.artist = artist;
        this.tracks = new ArrayList<>();
    }


    public CompactDisc(int id, String title, String category, float cost,
                         int length, String director,
                         String artist,
                         List<Track> tracks) {
        super(id, title, category, cost, length, director);
        this.artist = artist;
        this.tracks = (tracks == null) ? new ArrayList<>() : new ArrayList<>(tracks);
    }

    public String getArtist() {
        return artist;
    }

    public void setArtist(String artist) {
        this.artist = artist;
    }

    public List<Track> getTracks() {
        return new ArrayList<>(tracks);
    }

    public void addTrack(Track track) {
        if (track != null && !tracks.contains(track)) {
            tracks.add(track);
        }
    }

    public void removeTrack(Track track) {
        tracks.remove(track);
    }
}

