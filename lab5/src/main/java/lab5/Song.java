package lab5;

public class Song {
    public String genre;
    public String title;

    public Song(String genre, String title) {
        this.genre = genre;
        this.title = title;
    }

    public String getGenre() {
        return genre;
    }

    public String getTitle() {
        return title;
    }
}