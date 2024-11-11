package com.Are;

public class Prod implements Comparable<Prod> {
	String pName;
	int pid;
	int cost;
	public int compareTo(Prod o) {
		if(cost==o.cost)return 0;
		else if(cost>o.cost)return 1;
		else return -1;
	}
	public Prod(String pName, int pid, int cost) {
		
		this.pName = pName;
		this.pid = pid;
		this.cost = cost;     
	}
	public String getpName() {
		return pName;
	}
	public void setpName(String pName) {
		this.pName = pName;
	}
	public int getPid() {
		return pid;
	}
	public void setPid(int pid) {
		this.pid = pid;
	}
	public int getCost() {
		return cost;
	}
	public void setCost(int cost) {
		this.cost = cost;
		
	}
	@Override
	public String toString() {
		
		return "Prod{"+"pid="+pid+"pName="+pName+"cost="+cost+"}";
	}
}
	