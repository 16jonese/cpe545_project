import java.net.Inet4Address;
import java.net.UnknownHostException;
import java.rmi.registry.LocateRegistry;
import java.rmi.registry.Registry;
import java.util.List;

public class RMIClient {

	final static String CALL_EXAMPLE = "\nUsage:\n" + "    java RMIClient [policy file] [host:port] [prefix]\n" + "Example:\n"
			+ "    java RMIClient ..\\client.policy 127.0.0.1 \n";

    private RMIClient() {}

    public static void main(String[] args) {
		if (!validateArgs(args))
					return;
	    String host = args[0];
	    String prefix = args[1];
		try {
		    Registry registry = LocateRegistry.getRegistry(host);
		    Name stub = (Name) registry.lookup("Name");
		    List<String> response = stub.search(prefix);
		    System.out.println("response: " + response);
		} catch (Exception e) {
		    System.err.println("Client exception: " + e.toString());
		    e.printStackTrace();
		}
    }
	private static boolean validateArgs(String[] args) {
		int expectedNumberOfArgs = 1;
		if (args != null && args.length >= expectedNumberOfArgs) {
			try {
				Inet4Address.getByName(args[0]);
				return true;
			} catch (UnknownHostException e) {
				System.out.println("Invalid argument. You must provide a valid IP Address.");
			}
		} else {
			System.out.println("Incorrect call. " + "Expected " + expectedNumberOfArgs + " arguments.");
		}
		System.out.println(CALL_EXAMPLE);
		return false;
	}
}
