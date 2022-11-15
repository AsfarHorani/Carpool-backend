package com.carpool.service;

import com.carpool.model.Rider;

public interface RiderService {
	public Rider addRider(Rider Rider);
	public Rider getRider(long riderId);
	public void deleteRider(long riderId);
}
