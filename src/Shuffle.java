import java.util.ArrayList;
import java.util.Random;

/**
 * Simple shuffle function that is purely random
 * (something spotify should be able to do)
 * @author John Sweet
 *
 * NOTE: not optimized yet
 */
public class Shuffle {
    
    private ArrayList<Song> songs;
    
    /**
     * Constructor
     * @param songs list of songs set in main
     */
    public Shuffle (ArrayList<Song> songs) {
        this.songs = songs;
    }
    
    /**
     * Shuffle array list of song objects
     * @return shuffled array list of song objects
     */
    public ArrayList<Song> shuffle() {
        ArrayList<Song> shuffled = new ArrayList<Song>(songs.size());
        ArrayList<Integer> notShuffled = new ArrayList<Integer>(songs.size());
        int count = 0;
        Random random = new Random();
        
        // create array list from 0 to number of songs - 1
        for(int i = 0; i < songs.size(); i++) {
            notShuffled.add(i, count);
            count++;
        }
        
        int tries = 0;
        
        // add songs to shuffled list in random order and remove them from
        // numbers list so they are not repeated until numbers list is empty
        while(notShuffled.size() != 0) {
            int song = random.nextInt(songs.size());
            if(notShuffled.contains(song)) {
                shuffled.add(songs.get(song));
                notShuffled.remove(new Integer(song));
            }
//            else {
//                tries++;
//                // after 3 attempts of adding a song that is already in the shuffled
//                // list 
//                if(tries == 3) {
//                    int newRandom = random.nextInt(notShuffled.size());
//                    shuffled.add(songs.get(newRandom));
//                    notShuffled.remove(new Integer(newRandom));
//                    tries = 0;
//                }
//            }
            
        }
        songs = shuffled;
        return songs;
    }
    
    /**
     * Getter
     * @return song list
     */
    public ArrayList<Song> getSongs() {
        return this.songs;
    }
    
    /**
     * Creates string for each song in the format:
     * Title: [Title], Artist: [Artist] new line
     */
    public String toString() {
        String str = "";
        for(int i = 0; i < songs.size(); i++) {
            str += getSongs().get(i).toString() + "\n"; // toString from Song class
        }
        return str;
    }
    
    /**
     * main
     * @param args
     */
    public static void main(String[] args) {
        Song song1 = new Song("Hello", "Adele");
        Song song2 = new Song("Lost", "Illenium");
        Song song3 = new Song("Believe", "Yellowcard");
        Song song4 = new Song("I am", "Hands Like Houses");
        Song song5 = new Song("Home", "Our Last Night");
        Song song6 = new Song("Congratualions", "Post Malone");
        Song song7 = new Song("Hundred Beanie Dreams", "Someone");
        
        ArrayList<Song> songs = new ArrayList<Song>();
        songs.add(song1);
        songs.add(song2);
        songs.add(song3);
        songs.add(song4);
        songs.add(song5);
        songs.add(song6);
        songs.add(song7);
        
        Shuffle shuffle = new Shuffle(songs);
        shuffle.shuffle();
        
        System.out.println(shuffle.toString());
    }
}
