public class Media {
    private String mediaId;
    private String title;
    private String category;
    private float price;
    private String description;

    public Media(String mediaId, String title, String category, float price, String description) {
        this.mediaId = mediaId;
        this.title = title;
        this.category = category;
        this.price = price;
        this.description = description;
    }

    public Media() {
    }

    public String getMediaId() {
        return mediaId;
    }

    public void setMediaId(String mediaId) {
        this.mediaId = mediaId;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getCategory() {
        return category;
    }

    public void setCategory(String category) {
        this.category = category;
    }

    public float getPrice() {
        return price;
    }

    public void setPrice(float price) {
        this.price = price;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }
}
