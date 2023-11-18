import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

public class Hilos {

    public static void main(String[] args) {

        // URLs
        String[] urls = { "https://www.google.com",
                "https://www.facebook.com", "https://www.youtube.com" };

        // Cuantos hilos va a tener? 3
        int numThreads = 3;
        ExecutorService executor = Executors.newFixedThreadPool(numThreads);

        // Ejecutar conversion para todas las url
        for (String url : urls) {
            executor.execute(new Conversion(url));
        }

        executor.shutdown();
    }

}