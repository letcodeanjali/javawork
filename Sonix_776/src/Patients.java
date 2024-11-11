import java.util.Comparator;

public class Patients implements Comparator<Patients>{
	String pname;
	int pid;
	String location;
	int age;
	public Patients(String pname, int pid, String location, int age) {
		super();
		this.pname = pname;
		this.pid = pid;
		this.location = location;
		this.age = age;
	}
	/**
	 * @return the pname
	 */
	public String getPname() { 
		return pname;
	}
	/**
	 * @param pname the pname to set 
	 */
	public void setPname(String pname) {
		this.pname = pname;
	}
	/**
	 * @return the pid
	 */
	public int getPid() {
		return pid;
	}
	/**
	 * @param pid the pid to set
	 */
	public void setPid(int pid) {
		this.pid = pid;
	}
	/**
	 * @return the location
	 */
	public String getLocation() {
		return location;
	}
	/**
	 * @param location the location to set
	 */
	public void setLocation(String location) {
		this.location = location;
	}
	/**
	 * @return the age
	 */
	public int getAge() {
		return age;
	}
	/**
	 * @param age the age to set
	 */
	public void setAge(int age) {
		this.age = age;
	}
	@Override
	public int compare(Patients o1, Patients o2) {
		int name=o1.getPname().compareTo(o2.getLocation());
		return name;
	}
	

}
