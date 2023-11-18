import java.rmi.NotBoundException;
import java.rmi.RemoteException;
import java.rmi.registry.LocateRegistry;
import java.rmi.registry.Registry;
import java.util.List;
import java.util.Scanner;

public class Client {

    public static void main(String[] args) {
        try {
            Registry registry = LocateRegistry.getRegistry("localhost", 1099);
            CancionService service = (CancionService) registry.lookup("CancionService");

            Scanner scanner = new Scanner(System.in);
            System.out.print("Digite el género musical a buscar: ");
            String genre = scanner.nextLine();

            List<Cancion> matchingSongs = service.getSongsByGenre(genre);
            if (!matchingSongs.isEmpty()) {
                System.out.println("Canciones con el género '" + genre + "':");
                for (Cancion song : matchingSongs) {
                    System.out.println(song.getName() + " (" + song.getYear() + ")");
                }
            } else {
                System.out.println("El servidor no contiene canciones con el género '" + genre + "'.");
            }
        } catch (RemoteException | NotBoundException e) {
            e.printStackTrace();
        }
    }
}
