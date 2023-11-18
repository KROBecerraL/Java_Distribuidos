import java.rmi.Remote;
import java.rmi.RemoteException;
import java.util.List;

public interface CancionService extends Remote {
    List<Cancion> getSongsByGenre(String genre) throws RemoteException;
}
