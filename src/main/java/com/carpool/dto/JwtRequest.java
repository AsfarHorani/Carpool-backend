package com.carpool.dto;

import java.io.Serializable;

public class JwtRequest implements Serializable {

	private static final long serialVersionUID = 5926468583005150707L;
	
	private String address;
	private String signedMessage;
	
	//default constructor for JSON Parsing
	public JwtRequest()
	{
	}

   

	public JwtRequest(String address, String signedMessage) {
		super();
		this.address = address;
		this.signedMessage = signedMessage;
	}




	public String getAddress() {
		return address;
	}

	public void setAddress(String address) {
		this.address = address;
	}

	public String getSignedMessage() {
		return signedMessage;
	}

	public void setSignedMessage(String signedMessage) {
		this.signedMessage = signedMessage;
	}

	
}