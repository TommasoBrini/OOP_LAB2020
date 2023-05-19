package it.unibo.oop.lab04.robot.arms;

import it.unibo.oop.lab04.robot.base.BaseRobot;

public class RobotWithTwoArms extends BaseRobot implements RobotWithArms {

	public static final double TRANSPORT_OBJECT_CONSUMPTION = 0.1;

    private final BasicArm left;
    private final BasicArm right;
	
	public RobotWithTwoArms(String robotName) {
		super(robotName);
		left = new BasicArm("left");
		right = new BasicArm("right");
	}

	protected double getBatteryRequirementForMovement() {
        return super.getBatteryRequirementForMovement() + getCarriedItemsCount() * TRANSPORT_OBJECT_CONSUMPTION;
    }
	
	private void doPick(final BasicArm arm) {
        if (isBatteryEnough(arm.getConsuptionForPickUp()) && !arm.isGrabbing()) {
            log(arm + " is picking an object");
            arm.pickUp();
            consumeBattery(arm.getConsuptionForPickUp());
        } else {
            log("Can not grab (battery=" + this.getBatteryLevel() + "," + arm + " isGrabbing=" + arm.isGrabbing() + ")");
        }
    }
	
	private void doRelease(final BasicArm arm) {
        if (isBatteryEnough(arm.getConsuptionForDropDown()) && arm.isGrabbing()) {
            this.log(arm + " is releasing an object");
            arm.dropDown();
            this.consumeBattery(arm.getConsuptionForDropDown());
        } else {
            log("Can not release (batteryLevel=" + this.getBatteryLevel() + "," + arm + " isGrabbing="
                    + arm.isGrabbing() + ")");
        }
    }

	public boolean pickUp() {
		if (right.isGrabbing()) {
			if (left.isGrabbing()) {
				return false;
			}
			doPick(left);
		} else {
			doPick(right);
		}
		return true;
	}

	public boolean dropDown() {
		if (left.isGrabbing()) {
			doRelease(left);
			return true;
		}
		if (right.isGrabbing()) {
			doRelease(right);
			return true;
		}
		return false;
	}

	public int getCarriedItemsCount() {
		return (left.isGrabbing() ? 1 : 0) + (right.isGrabbing() ? 1 : 0);
	}

}
