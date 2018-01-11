/**
 * Song object that contains title and artist
 * @author John
 *
 */
public class Song {
    
    private String title;
    private String artist;
    
    /**
     * Constructor
     * @param title song title
     * @param artist song artist
     */
    public Song(String title, String artist) {
        this.title = title;
        this.artist = artist;
    }
    
    /**
     * Set object to string format
     */
    public String toString() {
        String str ="";
        str = "Title: " + getTitle() + ", Artist: " + getArtist();
        return str;
    }
    
    /**
     * Getter for title
     * @return title of song
     */
    public String getTitle() {
        return this.title;
    }
    
    /**
     * Getter for artist
     * @return song artist
     */
    public String getArtist() {
        return this.artist;
    }

}
