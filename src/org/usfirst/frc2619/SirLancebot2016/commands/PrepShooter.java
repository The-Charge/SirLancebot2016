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

import org.usfirst.frc2619.MathUtil;
import org.usfirst.frc2619.TheChargeDashboard;
import org.usfirst.frc2619.SirLancebot2016.Robot;

/**
 *
 */
public class PrepShooter extends Command {

    // BEGIN AUTOGENERATED CODE, SOURCE=ROBOTBUILDER ID=VARIABLE_DECLARATIONS
 
    // END AUTOGENERATED CODE, SOURCE=ROBOTBUILDER ID=VARIABLE_DECLARATIONS

    // BEGIN AUTOGENERATED CODE, SOURCE=ROBOTBUILDER ID=CONSTRUCTOR
    public PrepShooter() {

    // END AUTOGENERATED CODE, SOURCE=ROBOTBUILDER ID=CONSTRUCTOR
        // BEGIN AUTOGENERATED CODE, SOURCE=ROBOTBUILDER ID=VARIABLE_SETTING

        // END AUTOGENERATED CODE, SOURCE=ROBOTBUILDER ID=VARIABLE_SETTING
        // BEGIN AUTOGENERATED CODE, SOURCE=ROBOTBUILDER ID=REQUIRES

    // END AUTOGENERATED CODE, SOURCE=ROBOTBUILDER ID=REQUIRES
    }

    // Called just before this Command runs the first time
    protected void initialize() {
    	Robot.shooterMotors.readDashboardControlValues();
    	Robot.shooterMotors.initSpeedMode();
    }

    // Called repeatedly when this Command is scheduled to run
    protected void execute() {
    	Robot.shooterMotors.writeDashboardDebugValues();

    	if(Robot.cameraSubsystem.isVisionRunning() && Robot.cameraSubsystem.isTargetVisible() && !Robot.oi.buttonBox.getRawButton(11))
    	{

    		Robot.shooterMotors.prepShooter(Robot.shooterMotors.
    				convertDistanceToSpeed(Robot.cameraSubsystem.getDistance()));
    	}
    	else
    	{
    		Robot.shooterMotors.prepShooter(MathUtil.shooterSpeedFormat(Robot.oi.buttonBox.getZ())); 
    	  //account for the pot being like a regular joystick, only want 0 to 1
    		//TODO: Add delinearization code to the Speed pot of the shooter
    	}
    }

    // Make this return true when this Command no longer needs to run execute()
    protected boolean isFinished() {
        return false;
    }

    // Called once after isFinished returns true
    protected void end() {
    	Robot.shooterMotors.stop();
    }

    // Called when another command which requires one or more of the same
    // subsystems is scheduled to run
    protected void interrupted() {
    	end();
    }
}
