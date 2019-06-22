package com.cracking.interview.oopdeign.parkinglot;

public class Level {

	private ParkingSpot[] spots;
	private static final int SPOTS_PER_ROW = 10;
	private int availableSpots;
	private int floor;
	
	public Level(int flr, int numberOfSpots) {
		this.floor = flr;
		this.availableSpots = numberOfSpots;
	}
	
	public int availableSpots() {
		return availableSpots;
	}
	
	public boolean parkVehicle() {
		return false;
	}
	
	private int findAvailableSpots(Vehicle vehicle) {
		return -1;
	}
	
	public void spotFreed() {
		availableSpots++;
	}
}
