import java.rmi.Remote;
import java.rmi.RemoteException;
import java.util.List;

public interface INameSearch extends Remote {
	List<String> search(String prefix) throws RemoteException;
}
