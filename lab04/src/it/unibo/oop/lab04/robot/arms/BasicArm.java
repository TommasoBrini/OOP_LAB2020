package it.unibo.oop.lab04.robot.arms;

public class BasicArm {

	private static final double ENERGY_REQUIRED_TO_MOVE = 0.2;
    private static final double ENERGY_REQUIRED_TO_GRAB = 0.1;
    private boolean grabbing;
	private String name;
	
	public BasicArm(String name) {
		this.name = name;
	}
	
	boolean isGrabbing() {
		return grabbing;
	}
	
	void pickUp() {
		grabbing = true;
	}
	
	void dropDown() {
		grabbing = false;
	}
	
	double getConsuptionForPickUp() {
		return ENERGY_REQUIRED_TO_GRAB + ENERGY_REQUIRED_TO_MOVE;
	}
	
	double getConsuptionForDropDown() {
		return ENERGY_REQUIRED_TO_MOVE;
	}

	public String toString() {
		return name;
	}	
}
