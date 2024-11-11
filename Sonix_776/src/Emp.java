
public  class Emp implements Comparable<Emp>{
	int eid;
	String eName;
	int age;
	
	
	
	@Override
	public int compareTo(Emp o)  {
		
		if (age==o.age)
			return 0;
		else if (age<=o.age)
			return 1;
		else
			return -1;
		
	}
	
	

	public Emp() {
		
	}
	public Emp(int eid, String eName, int age) {
		super();
		this.eid = eid;
		this.eName = eName;
		this.age = age;
	}
	/**
	 * @return the eid
	 */
	public int getEid() {
		return eid;
	}
	/**
	 * @param eid the eid to set
	 */
	public void setEid(int eid) {
		this.eid = eid;
	}
	/**
	 * @return the eName
	 */
	public String geteName() {
		return eName;
	}
	/**
	 * @param eName the eName to set
	 */
	public void seteName(String eName) {
		this.eName = eName;
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
	public String toString() {
		
		return "Emp{" +"Eid=" +eid+ "Ename="+eName+"age="+age+"}";
	}
	

}
