package be;

public class Song {

    private static int id;
    private static String name;
    private static String artist;
    private static String category;
    private static int duration;
    private static String filePath;

    public Song(int id, String name, String artist, String category, int duration,String filePath) {
        this.id = id;
        this.name = name;
        this.artist = artist;
        this.category = category;
        this.duration = duration;
        this.filePath = filePath;
    }

    public static String getFilePath() {
        return filePath;
    }

    public static void setFilePath(String filePath) {
        Song.filePath = filePath;
    }

    public static int getId() {
        return id;
    }

    public static void setId(int id) {
        Song.id = id;
    }

    public static String getName() {
        return name;
    }

    public static void setName(String name) {
        Song.name = name;
    }

    public static String getArtist() {
        return artist;
    }

    public static void setArtist(String artist) {
        Song.artist = artist;
    }

    public static String getCategory() {
        return category;
    }

    public static void setCategory(String category) {
        Song.category = category;
    }

    public static int getDuration() {
        return duration;
    }

    public static void setDuration(int duration) {
        Song.duration = duration;
    }

    @Override
    public String toString() {
        return id + "  " +
                name + "  " +
                artist + "  " +
                category + "  " +
                duration + "  " +
                filePath;
    }
}
