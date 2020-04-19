import java.net.Inet4Address;
import java.net.UnknownHostException;
import java.rmi.registry.LocateRegistry;
import java.rmi.registry.Registry;
import java.util.List;

public class StevensClassClient {

    private StevensClassClient() {}

    public static void main(String[] args) {
		if (!checkArgs(args))
		 			return;
	    String host = args[0];
	    String type = args[1];
		try {
		    Registry registry = LocateRegistry.getRegistry(host);
		    ClassIDs stub = (ClassIDs) registry.lookup("ClassIDs");
		    List<ClassInfo> response = stub.searchClass(type);
		    for(ClassInfo classes : response){
				System.out.println("Class id: " + classes.getClassId());
				System.out.println("Number of Credits: " + classes.getClassCredits());
				System.out.println("Class Schedule: " + classes.getClassDays());
				System.out.println("Professor: " + classes.getClassTeacher());
				System.out.println();
			}
		} catch (Exception e) {
		    System.err.println("Client exception: " + e.toString());
		    e.printStackTrace();
		}
    }
	private static boolean checkArgs(String[] args) {
		int numArgs = 1;
		if( args == null || numArgs > args.length ){
			System.out.println("Error: Invalid call. " + "Expected " + numArgs + " arguments.");
		}
		else{
			try {
				Inet4Address.getByName(args[0]);
				return true;
			}
			catch (UnknownHostException e) {
				System.out.println("Error: Invalid IP address.");
			}
		}
		System.out.println("\nProper Call:" + "    java StevensClassClient [policy file] [host:port] [type]\n" + "Example Call:"
				+ "    java StevensClassClient ..\\client.policy 127.0.0.1 CPE \n");
		return false;
	}
}
