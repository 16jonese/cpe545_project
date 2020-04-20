import java.net.Inet4Address;
import java.net.UnknownHostException;
import java.net.InetAddress;
import java.io.FileNotFoundException;
import java.util.Scanner;
import java.io.File;
import java.rmi.registry.Registry;
import java.rmi.registry.LocateRegistry;
import java.rmi.RemoteException;
import java.rmi.server.UnicastRemoteObject;
import java.util.ArrayList;
import java.util.List;

public class StevensClassServer implements ClassIDs
{
    static ArrayList<ClassInfo> classList;

    public StevensClassServer() {}

    public List<ClassInfo> searchClass(String id) {
        id = id.toLowerCase();
				List<ClassInfo> list = new ArrayList<>();
				for (ClassInfo classItem : classList) {
			if (classItem.getClassId().toLowerCase().startsWith(id)){
				list.add(classItem);
			}
		}
		return list;
    }
		
		private static ArrayList<ClassInfo> getList()throws FileNotFoundException{
			ArrayList<ClassInfo> list = new ArrayList<>();
			File classList = new File("ClassInfo.txt");
			Scanner s = new Scanner(classList);

			while(s.hasNext()){
				ClassInfo newClass = new ClassInfo(s.nextLine(), Integer.parseInt(s.nextLine()), s.nextLine(), s.nextLine());
				list.add(newClass);
			}
			s.close();
			return list;
		}

    public static void main(String args[]) throws UnknownHostException, FileNotFoundException{
        classList = getList();
        String addr = (Inet4Address.getLocalHost()).toString();
				System.out.println(addr);
        try {
            StevensClassServer obj = new StevensClassServer();
            ClassIDs stub = (ClassIDs) UnicastRemoteObject.exportObject(obj, 0);

<<<<<<< Updated upstream
						//System.setProperty("java.rmi.server.hostname","192.168.56.1");
            Registry registry = LocateRegistry.createRegistry(3232);
=======
            // Bind the remote object's stub in the registry
            Registry registry = LocateRegistry.createRegistry(30280);
>>>>>>> Stashed changes
            registry.rebind("ClassIDs", stub);

            System.err.println("Server Setup Complete.");
        } catch (Exception e) {
            System.err.println("Server exception: " + e.toString());
            e.printStackTrace();
        }
    }

}
