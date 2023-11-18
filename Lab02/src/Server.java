import java.rmi.RemoteException;
import java.rmi.registry.LocateRegistry;
import java.rmi.registry.Registry;
import java.util.ArrayList;
import java.util.List;

public class Server {

    public static void main(String[] args) {
        try {
            List<Cancion> songs = new ArrayList<>();
            songs.add(new CancionImpl("Stairway to Heaven", "Rock", 1971));
            songs.add(new CancionImpl("She Wolf", "Pop", 2009));
            songs.add(new CancionImpl("Nobody", "Alternativo/Indie", 2018));
            songs.add(new CancionImpl("Bohemian Rhapsody", "Rock", 1975));

            CancionService service = new CancionServiceImpl(songs);

            Registry registry = LocateRegistry.createRegistry(1099);
            registry.rebind("CancionService", service);

            System.out.println("El servidor está activo...");
        } catch (RemoteException e) {
            e.printStackTrace();
        }
    }
}
