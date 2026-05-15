package hust.soict.dsai.aims.media;

public class Track implements Playable {
    private String title;
    private int length;

    @Override
    public boolean equals(Object obj) {
        if (this == obj) return true;
        if (obj == null || getClass() != obj.getClass()) return false;

        Track other = (Track) obj;

        if (this.title == null) {
            if (other.title != null) return false;
        } else if (!this.title.equals(other.title)) {
            return false;
        }
        return this.length == other.length;
    }


    public Track() {
    }

    public Track(String title, int length) {
        this.title = title;
        this.length = length;
    }

    public String getTitle() {
        return title;
    }

    public int getLength() {
        return length;
    }

    // Kept for compatibility with CD.play() in this project
    public void play() {
        if (length <= 0) {
            System.out.println("ERROR: Cannot play track '" + title + "' - invalid length!");
        } else {
            System.out.println("Playing track: " + title);
            System.out.println("Track length: " + length);
        }
    }
}

