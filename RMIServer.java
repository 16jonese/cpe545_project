import java.rmi.registry.Registry;
import java.rmi.registry.LocateRegistry;
import java.rmi.RemoteException;
import java.rmi.server.UnicastRemoteObject;
import java.util.ArrayList;
import java.util.List;

public class RMIServer implements Name
{
    static ArrayList<String> studentNameList;

    public RMIServer() {}

    public List<String> search(String prefix) {
        prefix = prefix.toLowerCase();
		List<String> list = new ArrayList<>();
		for (String name : studentNameList) {
			if (name.toLowerCase().startsWith(prefix)){
				list.add(name);
			}
		}
		return list;
    }

    public static void main(String args[]) {
        studentNameList = getList();
        try {
            RMIServer obj = new RMIServer();
            Name stub = (Name) UnicastRemoteObject.exportObject(obj, 0);

            // Bind the remote object's stub in the registry
            Registry registry = LocateRegistry.getRegistry();
            registry.rebind("Name", stub);

            System.err.println("Server ready");
        } catch (Exception e) {
            System.err.println("Server exception: " + e.toString());
            e.printStackTrace();
        }
    }
    private static ArrayList<String> getList() {
		ArrayList<String> list = new ArrayList<>();
		list.add("Susan Hart");
		list.add("Kent Ward");
		list.add("Delbert Maldonado");
		list.add("Delia Phillips");
		list.add("Herbert Blair");
		list.add("Ada Cunningham");
		list.add("Alfredo Mccormick");
		list.add("Wendell Weaver");
		list.add("Marianne Matthews");
		list.add("Saul Frazier");
		list.add("Betty Morgan");
		list.add("Alexandra Harrington");
		list.add("Darla Gardner");
		list.add("Hannah Mathis");
		list.add("Marian Hansen");
		list.add("Tracy Barrett");
		list.add("Sharon Carson");
		list.add("Karen Douglas");
		list.add("Shirley Bennett");
		list.add("Kristopher Brown");
		list.add("Courtney Allison");
		list.add("Helen Bradley");
		list.add("Sonia Hines");
		list.add("Ann Stephens");
		list.add("Vera Love");
		list.add("Gary Mclaughlin");
		list.add("Alberto Abbott");
		list.add("Jeffrey Hodges");
		list.add("Clayton Porter");
		list.add("Mildred Bass");
		list.add("Ruby Phelps");
		list.add("Santos Scott");
		list.add("Enrique Franklin");
		list.add("Madeline Arnold");
		list.add("Martha Young");
		list.add("Anita Stanley");
		list.add("Louise Collins");
		list.add("Antonio Richards");
		list.add("Sonja Harmon");
		list.add("Alfred Lewis");
		list.add("Doyle Frazier");
		list.add("Anthony Wells");
		return list;
	}
}
