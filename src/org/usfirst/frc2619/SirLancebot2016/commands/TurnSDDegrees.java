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
import edu.wpi.first.wpilibj.smartdashboard.SmartDashboard;

import org.usfirst.frc2619.MathUtil;
import org.usfirst.frc2619.SirLancebot2016.Robot;

/**
 *
 */
public class TurnSDDegrees extends Command {

    // BEGIN AUTOGENERATED CODE, SOURCE=ROBOTBUILDER ID=VARIABLE_DECLARATIONS
 
    // END AUTOGENERATED CODE, SOURCE=ROBOTBUILDER ID=VARIABLE_DECLARATIONS

	private double current_position;
	private final double ACCEPTABLE_ERROR = 2;
	private double speed;
	private double degrees;
	
    // BEGIN AUTOGENERATED CODE, SOURCE=ROBOTBUILDER ID=CONSTRUCTOR
    public TurnSDDegrees() {

    // END AUTOGENERATED CODE, SOURCE=ROBOTBUILDER ID=CONSTRUCTOR
        // BEGIN AUTOGENERATED CODE, SOURCE=ROBOTBUILDER ID=VARIABLE_SETTING

        // END AUTOGENERATED CODE, SOURCE=ROBOTBUILDER ID=VARIABLE_SETTING
        degrees = SmartDashboard.getNumber("AutonDegrees", 54);
    	
    	// BEGIN AUTOGENERATED CODE, SOURCE=ROBOTBUILDER ID=REQUIRES
        requires(Robot.driveTrain);

        // END AUTOGENERATED CODE, SOURCE=ROBOTBUILDER ID=REQUIRES
    }

    // Called just before this Command runs the first time
    protected void initialize() {
    	current_position = (Robot.gyroSubsystem.ahrs.getAngle());
		while (degrees < 0) {
			degrees += 360;
		}
		while (degrees >= 360) {
			degrees -= 360;
		}
		speed = .4;
    }

    // Called repeatedly when this Command is scheduled to run
    protected void execute() {
    	if (MathUtil.calcDirection(current_position, degrees) > 0) // shortest
			// way
			// clockwise
		{
		Robot.driveTrain.setLeftPercentVBus(speed);
		Robot.driveTrain.setRightPercentVBus(-speed);
		} else {
		Robot.driveTrain.setLeftPercentVBus(-speed);
		Robot.driveTrain.setRightPercentVBus(speed);
		}
		
		current_position = (Robot.gyroSubsystem.ahrs.getAngle());
		
		// change speed once it gets close
		if (Math.abs(degrees - current_position) <= 20) {
		speed = .3;
		}
		    }

    // Make this return true when this Command no longer needs to run execute()
    protected boolean isFinished() {
    	if ((Math.abs(Robot.gyroSubsystem.ahrs.getAngle() - degrees)) <= ACCEPTABLE_ERROR) {
			return true;
		} else
			return false;
    }

    // Called once after isFinished returns true
    protected void end() {
    	Robot.driveTrain.setLeftPercentVBus(0);
		Robot.driveTrain.setRightPercentVBus(0);
	}

    // Called when another command which requires one or more of the same
    // subsystems is scheduled to run
    protected void interrupted() {
    }
}
