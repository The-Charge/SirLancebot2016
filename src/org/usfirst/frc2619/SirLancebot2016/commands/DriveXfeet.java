// RobotBuilder Version: 2.0
//
// This file was generated by RobotBuilder. It contains sections of
// code that are automatically generated and assigned by robotbuilder.
// These sections will be updated in the future when you export to
// Java from RobotBuilder. Do not put any code or make any change in
// the blocks indicating autogenerated code or it will be lost on an
// update. Deleting the comments indicating the section will prevent
// it from being updated in the future.

package org.usfirst.frc2619.SirLancebot2016.commands;

import edu.wpi.first.wpilibj.command.Command;
import org.usfirst.frc2619.SirLancebot2016.Robot;

/**
 *
 */
public class DriveXfeet extends Command {

	// BEGIN AUTOGENERATED CODE, SOURCE=ROBOTBUILDER ID=VARIABLE_DECLARATIONS
	private double m_distance;

	// END AUTOGENERATED CODE, SOURCE=ROBOTBUILDER ID=VARIABLE_DECLARATIONS

	// BEGIN AUTOGENERATED CODE, SOURCE=ROBOTBUILDER ID=CONSTRUCTOR
	public DriveXfeet(double distance) {

		// END AUTOGENERATED CODE, SOURCE=ROBOTBUILDER ID=CONSTRUCTOR
		// BEGIN AUTOGENERATED CODE, SOURCE=ROBOTBUILDER ID=VARIABLE_SETTING
		m_distance = distance;

		// END AUTOGENERATED CODE, SOURCE=ROBOTBUILDER ID=VARIABLE_SETTING
		// BEGIN AUTOGENERATED CODE, SOURCE=ROBOTBUILDER ID=REQUIRES
        requires(Robot.driveTrain);

    // END AUTOGENERATED CODE, SOURCE=ROBOTBUILDER ID=REQUIRES
	}

	// Called just before this Command runs the first time
	protected void initialize() {
		// Robot.driveTrain.init
		// Robot.driveTrain.setLeftPostionFeet(0);
		// Robot.driveTrain.setRightPostionFeet(0);

		Robot.driveTrain.initPositionMode();
		Robot.driveTrain.setDistanceTarget(m_distance); // call setDistanceTarget method
		Robot.driveTrain.brakeModeOn(true);
	}

	// Called repeatedly when this Command is scheduled to run
	protected void execute() {
		Robot.driveTrain.writeDashboardDebugValues();
	}

	// Make this return true when this Command no longer needs to run execute()
	protected boolean isFinished() {
		return Robot.driveTrain.atTarget(); // this method calculates if the
											// robot is close enough to target
											// to stop
	}

	// Called once after isFinished returns true
	protected void end() {
		Robot.driveTrain.disablePID();
		Robot.driveTrain.setLeftPostionFeet(0);
		Robot.driveTrain.setRightPostionFeet(0);
		Robot.driveTrain.brakeModeOn(false);
	}

	// Called when another command which requires one or more of the same
	// subsystems is scheduled to run
	protected void interrupted() {
		end();
	}
}
