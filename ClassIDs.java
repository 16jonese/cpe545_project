import java.rmi.Remote;
import java.rmi.RemoteException;
import java.io.Serializable;
import java.util.List;

public interface ClassIDs extends Remote {
	List<ClassInfo> searchClass(String prefix) throws RemoteException;
}

class ClassInfo implements Serializable{

	private String id;
	private int credits;
	private String days;
	private String teacher;
	public ClassInfo(String id, int credits, String days, String teacher){
		this.id = id;
		this.credits = credits;
		this.days = days;
		this.teacher = teacher;
	}

	public String getClassId(){
		return this.id;
	}
	public int getClassCredits(){
		return this.credits;
	}
	public String getClassDays(){
		return this.days;
	}
	public String getClassTeacher(){
		return this.teacher;
	}
	public void setClassId(String id){
		this.id = id;
	}
	public void setClassCredits(int credits){
		this.credits = credits;
	}
	public void setClassDays(String days){
		this.days = days;
	}
	public void setClassTeacher(String teacher){
		this.teacher = teacher;
	}
}
