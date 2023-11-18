import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.net.ServerSocket;
import java.net.Socket;
import java.util.ArrayList;

public class Servidor {

    public static void main(String[] args) {
        try {
            // Crear el socket en el puerto 12345
            ServerSocket serverSocket = new ServerSocket(12345);
            System.out.println("Servidor listo, esperando conexiones...");

            Cancion[] canciones = {
                    new Cancion("Stairway to Heaven", "Rock", 1971),
                    new Cancion("She Wolf", "Pop", 2009),
                    new Cancion("Nobody", "Alternativo/Indie", 2018),
                    new Cancion("Bohemian Rhapsody", "Rock", 1975)
            };

            while (true) {
                Socket clientSocket = serverSocket.accept();
                System.out.println("Cliente conectado.");

                ObjectInputStream in = new ObjectInputStream(clientSocket.getInputStream());
                ObjectOutputStream out = new ObjectOutputStream(clientSocket.getOutputStream());

                String requestedGenre = in.readUTF();

                ArrayList<Cancion> matchingCanciones = new ArrayList<>();
                for (Cancion cancion : canciones) {
                    if (cancion.getGenre().equalsIgnoreCase(requestedGenre)) {
                        matchingCanciones.add(cancion);
                    }
                }

                // Return las canciones del género enviado por el cliente
                out.writeObject(matchingCanciones);

                in.close();
                out.close();
                clientSocket.close();
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
