import java.rmi.registry.LocateRegistry;
import java.rmi.registry.Registry;
import java.util.List;

public class RMIClient {

    private RMIClient() {}

    public static void main(String[] args) {

	//String host = (args.length < 1) ? null : args[0];
    String prefix = args[0];
	try {
	    Registry registry = LocateRegistry.getRegistry(null);
	    Name stub = (Name) registry.lookup("Name");
	    List<String> response = stub.search(prefix);
	    System.out.println("response: " + response);
	} catch (Exception e) {
	    System.err.println("Client exception: " + e.toString());
	    e.printStackTrace();
	}
    }
}
