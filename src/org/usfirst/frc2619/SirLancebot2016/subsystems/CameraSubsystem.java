// RobotBuilder Version: 2.0
//
// This file was generated by RobotBuilder. It contains sections of
// code that are automatically generated and assigned by robotbuilder.
// These sections will be updated in the future when you export to
// Java from RobotBuilder. Do not put any code or make any change in
// the blocks indicating autogenerated code or it will be lost on an
// update. Deleting the comments indicating the section will prevent
// it from being updated in the future.

package org.usfirst.frc2619.SirLancebot2016.subsystems;

import org.usfirst.frc2619.Constants;
import org.usfirst.frc2619.TheChargeDashboard;
import org.usfirst.frc2619.SirLancebot2016.commands.*;

import edu.wpi.first.wpilibj.Timer;
import edu.wpi.first.wpilibj.command.Subsystem;
import edu.wpi.first.wpilibj.networktables.NetworkTable;

/**
 *
 */
public class CameraSubsystem extends Subsystem {

	static NetworkTable cameraTable;
	Timer networkTimeoutTimer;
	double lastKnownCountValue = -1;
	private final static double ANGLE_DEADBAND = .25;
	private final static double DISTANCE_DEADBAND = .5;
	public final double OPTIMAL_DISTANCE = 14;

	// BEGIN AUTOGENERATED CODE, SOURCE=ROBOTBUILDER ID=CONSTANTS

    // END AUTOGENERATED CODE, SOURCE=ROBOTBUILDER ID=CONSTANTS

	// BEGIN AUTOGENERATED CODE, SOURCE=ROBOTBUILDER ID=DECLARATIONS

    // END AUTOGENERATED CODE, SOURCE=ROBOTBUILDER ID=DECLARATIONS
	public CameraSubsystem() {
		cameraTable = NetworkTable.getTable("Vision");
		networkTimeoutTimer = new Timer();
		networkTimeoutTimer.start();
	}

	// Put methods for controlling this subsystem
	// here. Call these from Commands.

	public void initDefaultCommand() {

		// BEGIN AUTOGENERATED CODE, SOURCE=ROBOTBUILDER ID=DEFAULT_COMMAND

        setDefaultCommand(new CameraDebug());

    // END AUTOGENERATED CODE, SOURCE=ROBOTBUILDER ID=DEFAULT_COMMAND
		// Set the default command for a subsystem here.
		// setDefaultCommand(new MySpecialCommand());
	}

	public void writeDashboardDebugValues() {
		TheChargeDashboard.putNumber("Distance",
				cameraTable.getNumber("Distance", 0));
		TheChargeDashboard.putNumber("xRotationAngle",
				cameraTable.getNumber("xRotationAngle", 0));
		TheChargeDashboard.putNumber("BLOB_COUNT",
				cameraTable.getNumber("BLOB_COUNT", 0));
		TheChargeDashboard.putNumber("IMAGE_COUNT",
				cameraTable.getNumber("IMAGE_COUNT", 0));
		TheChargeDashboard.putBoolean("IS_VISION_RUNNING", isVisionRunning());
		TheChargeDashboard.putBoolean("onDistanceTarget", onDistanceTarget());
		TheChargeDashboard.putBoolean("onAngleTarget", onAngleTarget());
		TheChargeDashboard.putBoolean("onTarget", onTarget());
		TheChargeDashboard.putNumber("OptimalDistance", OPTIMAL_DISTANCE);
		TheChargeDashboard.putNumber("DistanceDeadband", DISTANCE_DEADBAND);
		
		
		
	}

	public boolean isVisionRunning() {
		double currentCountValue = cameraTable.getNumber("IMAGE_COUNT", -1);
		if (currentCountValue != -1 && currentCountValue != lastKnownCountValue) {
			networkTimeoutTimer.reset();
			networkTimeoutTimer.start();
			lastKnownCountValue = currentCountValue;
		}
		return networkTimeoutTimer.get() < 1;
	}

	public double getTargetXRotation() {
		return cameraTable.getNumber("xRotationAngle", 0);
	}

	public double getDistance() {
		return cameraTable.getNumber("Distance", 0);
	}

	public boolean isTargetVisible() {
		return cameraTable.getNumber("BLOB_COUNT", 0) > 0;
	}

	public void turnToOriginalTargetDirection() {
		new TurnNDegreesAbsolute(Constants.TOWER_ROTATION_FROM_STARTPOINT);
	}

	public boolean onDistanceTarget() {
	return ((getDistance() < (OPTIMAL_DISTANCE + DISTANCE_DEADBAND)) && (getDistance() > (OPTIMAL_DISTANCE
				- DISTANCE_DEADBAND)));

	}

	public boolean onAngleTarget() {
		return ((Math.abs(getTargetXRotation()) < ANGLE_DEADBAND));
	}

	public boolean onTarget() {
		return (onDistanceTarget() && onAngleTarget());
	}

}
