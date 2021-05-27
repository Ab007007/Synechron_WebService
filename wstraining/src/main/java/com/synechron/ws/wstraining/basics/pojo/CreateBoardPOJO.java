package com.synechron.ws.wstraining.basics.pojo;

public class CreateBoardPOJO {
	
	private String name;
	private String id;
	private LabelNames lb;
	private Prefs ps;
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public String getId() {
		return id;
	}
	public void setId(String id) {
		this.id = id;
	}
	public LabelNames getLb() {
		return lb;
	}
	public void setLb(LabelNames lb) {
		this.lb = lb;
	}
	public Prefs getPs() {
		return ps;
	}
	public void setPs(Prefs ps) {
		this.ps = ps;
	}
	
	
	
}
