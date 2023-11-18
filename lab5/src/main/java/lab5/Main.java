package lab5;

import javax.xml.ws.Endpoint;

public class Main 
{
    public static void main( String[] args )
    {
        Endpoint.publish("http://localhost:1234/soap", new SongServiceImpl());
        System.out.println("Web server URL: http://localhost:1234/soap");
        SongServiceImpl servidor = new SongServiceImpl();
    }
}
