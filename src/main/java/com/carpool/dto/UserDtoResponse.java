package com.carpool.dto;

public class UserDtoResponse {
    private String address;
    private long id;
    
    public long getId() {
		return id;
	}

	public void setId(long id) {
		this.id = id;
	}

	public String getAddress() {
        return address;
    }
    
    public void setAddress(String username) {
        this.address = username;
    }
}
