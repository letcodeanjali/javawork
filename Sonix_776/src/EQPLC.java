
public class EQPLC implements Comparable<EQPLC> {
	
	
	
	int eid;
	String band;
	String eName;
	int pid;
	String pName;
	double basic;
	double q1;
	double q2;
	double q3;
	double q4;
	double rate;
	double bonus;
	double net;
	double tax;
	double salary;
	@Override
	public int compareTo(EQPLC o) {
		
        double rat = (q1 + q2 + q3 + q4);
        double or = (o.q1+ o.q2 + o.q3 + o.q4);
        
        	 if (rat < or) {
 	            return -1;
 	        } else if (rat > or) {
 	            return 1;
 	        }
 	        return 0;}
 	        public EQPLC(int eid, String band, String eName, int pid, String pName, double basic, double q1, double q2,
 	   			double q3, double q4) {
 	        	this.eid = eid;
 	   		this.band = band;
 	   		this.eName = eName;
 	   		this.pid = pid;
 	   		this.pName = pName;
 	   this.rate=rate;
 	   		this.basic = basic;
 	   		this.q1 = q1;
 	   		this.q2 = q2;
 	   		this.q3 = q3;
 	   		this.q4 = q4;
 	   this.bonus = bonus;
 	   this.net = net;
 	   this.tax = tax;
 	        
	
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
	 * @return the band
	 */
	public String getBand() {
		if(band.equals("U1"))
			return "Software Engineer";
		else if(band.equals("U2"))
			return "Sr. Software Engineer";
		else if(band.equals("P1"))
			return "Project Lead";
		else if(band.equals("EP1"))
			return "Executive Project manager";
		else
		return "Please give job Role";
		
	}
	/**
	 * @param band the band to set
	 */
	public void setBand(String band) {
		this.band = band;
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
	 * @return the pName
	 */
	public String getpName() {
		return pName;
	}
	/**
	 * @param pName the pName to set
	 */
	public void setpName(String pName) {
		this.pName = pName;
	}
	/**
	 * @return the basic
	 */
	public double getBasic() {
		basic=basic*12;
		return basic;
	}
	/**
	 * @param basic the basic to set
	 */
	public void setBasic(double basic) {
		this.basic = basic;
	}
	/**
	 * @return the q1
	 */
	public double getQ1() {
		return q1;
	}
	/**
	 * @param q1 the q1 to set
	 */
	public void setQ1(double q1) {
		this.q1 = q1;
	}
	/**
	 * @return the q2
	 */
	public double getQ2() {
		return q2;
	}
	/**
	 * @param q2 the q2 to set
	 */
	public void setQ2(double q2) {
		this.q2 = q2;
	}
	/**
	 * @return the q3
	 */
	public double getQ3() {
		return q3;
	}
	/**
	 * @param q3 the q3 to set
	 */
	public void setQ3(double q3) {
		this.q3 = q3;
	}
	/**
	 * @return the q4
	 */
	public double getQ4() {
		return q4;
	}
	/**
	 * @param q4 the q4 to set
	 */
	public void setQ4(double q4) {
		this.q4 = q4;
	}
	/**
	 * @return the rate
	 */
	public double getRate() {
		rate=q1+q2+q3+q4;
		return rate;
	}
	/**
	 * @param rate the rate to set
	 */
	public void setRate(double rate) {
		this.rate = rate;
	}
	/**
	 * @return the bonus
	 */
	public double getBonus() {
		if(rate>15)
			bonus=basic*0.3809;
			
			else if(rate>=10)
				bonus=basic*0.2371;
			
			else if(rate>6)
				bonus=basic*(-0.3915);
			
			else
				bonus=basic*(-0.4369);
			
			return bonus;

		
	}
	/**
	 * @param bonus the bonus to set
	 */
	public void setBonus(double bonus) {
		this.bonus = bonus;
	}
	/**
	 * @return the net
	 */
	public double getNet() {
		net=basic+bonus;
		return net;
	}
	/**
	 * @param net the net to set
	 */
	public void setNet(double net) {
		this.net = net;
	}
	/**
	 * @return the tax
	 */
	public double gettax() {
		if(net>1500000.00)
			tax=net*0.4719;
			
		else if(net>750000.00)
		tax=net*0.2168;
				
		else if(net>500000.00)
		tax=net*0.1840;
		
		else tax=0.0;
		
		return tax;
	}
	/**
	 * @param tax the tax to set
	 */
	public void settax(double tax) {
		this.tax = tax;
	}
	/**
	 * @return the salary
	 */
	public double getSalary() {
		salary=net-tax;
		
		return salary;
	}
	/**
	 * @param salary the salary to set
	 */
	public void setSalary(double salary) {
		this.salary = salary;
	}
	
	

}
