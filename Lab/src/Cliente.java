import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.net.Socket;
import java.util.ArrayList;
import java.util.Scanner;

public class Cliente {

    public static void main(String[] args) {
        try {
            // Connect to the server on port 12345
            Socket clientSocket = new Socket("localhost", 12345);

            ObjectOutputStream out = new ObjectOutputStream(clientSocket.getOutputStream());
            ObjectInputStream in = new ObjectInputStream(clientSocket.getInputStream());

            Scanner scanner = new Scanner(System.in);
            System.out.print("Digite el género de la canción: ");
            String requestedGenre = scanner.nextLine();

            out.writeUTF(requestedGenre);
            out.flush();

            // Recibir el array de canciones que tienen el género enviado
            @SuppressWarnings("unchecked")
            ArrayList<Cancion> matchingCanciones = (ArrayList<Cancion>) in.readObject();
            if (!matchingCanciones.isEmpty()) {
                System.out.println("Canciones con el género '" + requestedGenre + "':");
                for (Cancion cancion : matchingCanciones) {
                    System.out.println(cancion);
                }
            } else {
                System.out.println("No se encontraron canciones con el género '" + requestedGenre + "'.");
            }

            scanner.close();
            in.close();
            out.close();
            clientSocket.close();
        } catch (IOException | ClassNotFoundException e) {
            e.printStackTrace();
        }
    }
}
