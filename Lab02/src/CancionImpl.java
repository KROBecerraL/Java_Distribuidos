import java.rmi.RemoteException;
import java.rmi.server.UnicastRemoteObject;

public class CancionImpl extends UnicastRemoteObject implements Cancion {
    private String name;
    private String genre;
    private int year;

    public CancionImpl(String name, String genre, int year) throws RemoteException {
        this.name = name;
        this.genre = genre;
        this.year = year;
    }

    @Override
    public String getName() throws RemoteException {
        return name;
    }

    @Override
    public String getGenre() throws RemoteException {
        return genre;
    }

    @Override
    public int getYear() throws RemoteException {
        return year;
    }
}
