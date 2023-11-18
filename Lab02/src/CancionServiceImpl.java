import java.rmi.RemoteException;
import java.rmi.server.UnicastRemoteObject;
import java.util.ArrayList;
import java.util.List;

public class CancionServiceImpl extends UnicastRemoteObject implements CancionService {
    private List<Cancion> songs;

    public CancionServiceImpl(List<Cancion> songs) throws RemoteException {
        this.songs = songs;
    }

    @Override
    public List<Cancion> getSongsByGenre(String genre) throws RemoteException {
        List<Cancion> matchingSongs = new ArrayList<>();
        for (Cancion song : songs) {
            try {
                if (song.getGenre().equalsIgnoreCase(genre)) {
                    matchingSongs.add(song);
                }
            } catch (RemoteException e) {
                e.printStackTrace();
            }
        }
        return matchingSongs;
    }
}
