package com.masai;

public class Address {
	private String localAddress;
	private String collageAddress;
	
	public Address() {
		// TODO Auto-generated constructor stub
	}

	public Address(String localAddress, String collageAddress) {
		this.localAddress = localAddress;
		this.collageAddress = collageAddress;
	}

	public String getLocalAddress() {
		return localAddress;
	}

	public void setLocalAddress(String localAddress) {
		this.localAddress = localAddress;
	}

	public String getCollageAddress() {
		return collageAddress;
	}

	public void setCollageAddress(String collageAddress) {
		this.collageAddress = collageAddress;
	}
	
	
	
}
