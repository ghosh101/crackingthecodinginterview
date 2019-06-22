package com.cracking.interview.oopdeign.parkinglot;

import java.util.ArrayList;

public abstract class Vehicle {

	protected String licensePlate;
	protected VehicleSize size;
	protected int spotsNeeded;
	protected ArrayList<ParkingSpot> parkingSpots = new ArrayList<>();
	
	public int getSpotsNeeded() {
		return spotsNeeded;
	}
	
	public VehicleSize getSize() {
		return size;
	}
	
	public void parkingSpot(ParkingSpot parkingSpot) {
		parkingSpots.add(parkingSpot);
	}

	public abstract boolean canFitInSpot(ParkingSpot spot);
}

class Bus extends Vehicle{
	public Bus(){
		size = VehicleSize.LARGE;
		spotsNeeded = 5;
	}

	@Override
	public boolean canFitInSpot(ParkingSpot spot) {
		return false;
	}
}

class Car extends Vehicle{
	public Car(){
		size = VehicleSize.COMPACT;
		spotsNeeded = 1;
	}

	@Override
	public boolean canFitInSpot(ParkingSpot spot) {
		return false;
	}
}

class Motorcycle extends Vehicle{
	public Motorcycle(){
		size = VehicleSize.MOTORCYCLE;
		spotsNeeded = 1;
	}

	@Override
	public boolean canFitInSpot(ParkingSpot spot) {
		return false;
	}
}
