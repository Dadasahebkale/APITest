package com.dk.pojo;

public class Location {

	private double lat;
	private double lan;
	
	public double getLat() {
		return lat;
	}
	public void setLat(double lat) {
		this.lat = lat;
	}
	public double getLan() {
		return lan;
	}
	public void setLan(double lan) {
		this.lan = lan;
	}
	@Override
	public String toString() {
		return "Location [lat=" + lat + ", lan=" + lan + ", getLat()=" + getLat() + ", getLan()=" + getLan()
				+ ", getClass()=" + getClass() + ", hashCode()=" + hashCode() + ", toString()=" + super.toString()
				+ "]";
	}
	
}
