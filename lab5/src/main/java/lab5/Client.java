package lab5;

import java.util.Scanner;
import javax.xml.namespace.QName;
import javax.xml.ws.Service;
import java.net.URL;

public class Client {
    public static void main(String[] args) throws Exception {
        URL url = new URL("http://localhost:1234/soap?wsdl");
        QName qname = new QName("http://lab5/", "SongServiceImplService");

        // Crear una instancia del servidor
        Service service = Service.create(url, qname);

        // Importar la interfaz del servidor
        SongService songService = service.getPort(SongService.class);

        // Dejar que el usuario digite un género
        Scanner scanner = new Scanner(System.in);
        System.out.print("Por favor digite un género musical: ");
        String genre = scanner.nextLine();

        // Enviar la petición al servidor
        Response response = songService.getSongsByGenre(genre);
        System.out.println("Respuesta del servidor: " + response.details);
        if (response.statusCode==200) {
            System.out.println(response.json);
        }
    }
}
