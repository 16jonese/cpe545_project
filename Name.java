import java.rmi.Remote;
import java.rmi.RemoteException;
import java.util.List;

public interface Name extends Remote {
	List<String> search(String prefix) throws RemoteException;
}
