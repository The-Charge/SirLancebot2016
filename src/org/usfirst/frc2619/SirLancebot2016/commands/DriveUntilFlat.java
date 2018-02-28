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

import edu.wpi.first.wpilibj.Timer;
import edu.wpi.first.wpilibj.command.Command;

import org.usfirst.frc2619.SirLancebot2016.Robot;

/**
 *
 */
public class DriveUntilFlat extends Command {

	Timer buildSpeed = new Timer();
	Timer isForRealFlat = new Timer();

	double m_speed;

	// BEGIN AUTOGENERATED CODE, SOURCE=ROBOTBUILDER ID=VARIABLE_DECLARATIONS

	// END AUTOGENERATED CODE, SOURCE=ROBOTBUILDER ID=VARIABLE_DECLARATIONS

	public DriveUntilFlat() {
		this(.95);
	}

	// BEGIN AUTOGENERATED CODE, SOURCE=ROBOTBUILDER ID=CONSTRUCTOR
	public DriveUntilFlat(double speed) {

		// END AUTOGENERATED CODE, SOURCE=ROBOTBUILDER ID=CONSTRUCTOR
		// BEGIN AUTOGENERATED CODE, SOURCE=ROBOTBUILDER ID=VARIABLE_SETTING

		// END AUTOGENERATED CODE, SOURCE=ROBOTBUILDER ID=VARIABLE_SETTING
		m_speed = speed;
		// BEGIN AUTOGENERATED CODE, SOURCE=ROBOTBUILDER ID=REQUIRES
		requires(Robot.driveTrain);

		// END AUTOGENERATED CODE, SOURCE=ROBOTBUILDER ID=REQUIRES
	}

	// Called just before this Command runs the first time
	protected void initialize() {
		buildSpeed.start();
		this.setTimeout(2);
	}

	// Called repeatedly when this Command is scheduled to run
	protected void execute() {
		if (buildSpeed.get() < 0.5) {
			Robot.driveTrain.setLeftSpeedPercentage(m_speed);
			Robot.driveTrain.setRightSpeedPercentage(m_speed);
		} else if (Robot.gyroSubsystem.isFlat()) {
			isForRealFlat.start();
		} else {
			Robot.driveTrain.setLeftSpeedPercentage(m_speed);
			Robot.driveTrain.setRightSpeedPercentage(m_speed);

			isForRealFlat.stop();
		}
		//Robot.driveTrain.writeDashboardDebugValues();
	}

	// Make this return true when this Command no longer needs to run execute()
	protected boolean isFinished() {
		if (buildSpeed.get() < 0.5)
			return false;

		if (this.isTimedOut())
			return this.isTimedOut();

		return Robot.gyroSubsystem.isFlat()
				&& isForRealFlat.hasPeriodPassed(.2);
	}

	// Called once after isFinished returns true
	protected void end() {
		Robot.driveTrain.setLeftSpeedPercentage(0);
		Robot.driveTrain.setRightSpeedPercentage(0);
	}

	// Called when another command which requires one or more of the same
	// subsystems is scheduled to run
	protected void interrupted() {
		end();
	}
}
