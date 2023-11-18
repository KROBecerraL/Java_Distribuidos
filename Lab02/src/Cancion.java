import java.rmi.Remote;
import java.rmi.RemoteException;

public interface Cancion extends Remote {
    String getName() throws RemoteException;
    String getGenre() throws RemoteException;
    int getYear() throws RemoteException;
}
