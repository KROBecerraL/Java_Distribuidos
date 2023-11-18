package lab5;

import java.util.ArrayList;
import javax.jws.WebService;

@WebService (endpointInterface = "lab5.SongService")
public class SongServiceImpl implements SongService {
    private ArrayList<Song> songList;

    public SongServiceImpl() {
        this.songList = new ArrayList<Song>();
        this.songList.add(new Song("Rock", "Hotel California"));
        this.songList.add(new Song("Pop", "Thriller"));
        this.songList.add(new Song("Rock", "Bohemian Rhapsody"));
        this.songList.add(new Song("Jazz", "Take Five"));
    }

    @Override
    public Response getSongsByGenre(String genre) {
        Response response = new Response();
        ArrayList<Song> matchingSongs = new ArrayList<Song>();

        for (Song song : this.songList) {
            if (song.getGenre().equalsIgnoreCase(genre)) {
                matchingSongs.add(song);
            }
        }

        if (!matchingSongs.isEmpty()) {
            response.statusCode = 200;
            response.details = "Canciones del género " + genre + ":";
            response.json = parseJSON(matchingSongs);
        } else {
            response.statusCode = 404;
            response.details = "No se encontraron canciones del género " + genre;
        }

        return response;
    }

    private static String parseJSON(ArrayList<Song> songs) {
        StringBuilder jsonBuilder = new StringBuilder();
        jsonBuilder.append("["); //Inicio del JSON

        for (int i = 0; i < songs.size(); i++) {
            Song song = songs.get(i);
            jsonBuilder.append("{"); // Start of JSON object
            jsonBuilder.append("\"genre\": \"" + song.getGenre() + "\", ");
            jsonBuilder.append("\"title\": \"" + song.getTitle() + "\"");
            jsonBuilder.append("}"); // End of JSON object

            if (i < songs.size() - 1) {
                jsonBuilder.append(", "); // Add a comma if not the last element
            }
        }

        jsonBuilder.append("]"); // Final del JSON
        return jsonBuilder.toString();
    }
}