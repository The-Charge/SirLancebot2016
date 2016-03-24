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

import org.usfirst.frc2619.Constants;
import org.usfirst.frc2619.SirLancebot2016.Robot;

/**
 *
 */
public class AutoAimHorizontal extends Command {
	
	private boolean isVisible;
	private double startingangle;
	private double endangle;
	private final static double DEADBAND = .25;

    // BEGIN AUTOGENERATED CODE, SOURCE=ROBOTBUILDER ID=VARIABLE_DECLARATIONS
 
    // END AUTOGENERATED CODE, SOURCE=ROBOTBUILDER ID=VARIABLE_DECLARATIONS

    // BEGIN AUTOGENERATED CODE, SOURCE=ROBOTBUILDER ID=CONSTRUCTOR
    public AutoAimHorizontal() {

    // END AUTOGENERATED CODE, SOURCE=ROBOTBUILDER ID=CONSTRUCTOR
        // BEGIN AUTOGENERATED CODE, SOURCE=ROBOTBUILDER ID=VARIABLE_SETTING

        // END AUTOGENERATED CODE, SOURCE=ROBOTBUILDER ID=VARIABLE_SETTING
        // BEGIN AUTOGENERATED CODE, SOURCE=ROBOTBUILDER ID=REQUIRES
        requires(Robot.driveTrain);

    // END AUTOGENERATED CODE, SOURCE=ROBOTBUILDER ID=REQUIRES
    }

    // Called just before this Command runs the first time
    protected void initialize() {    	
    	Robot.driveTrain.initSpeedPercentageMode();   	
    	Robot.driveTrain.setLeftSpeedPercentage(0);
    	Robot.driveTrain.setRightSpeedPercentage(0);
    	this.setTimeout(5);
    }

    // Called repeatedly when this Command is scheduled to run
    protected void execute() { // NOTE: may need to change code to have robot turn in place instead of backing up
    	isVisible = Robot.cameraSubsystem.isTargetVisible(); 
    	double driveSpeed = .05;
    	if(isVisible && Constants.visionSwitchOn)
    	{
    		if(Robot.cameraSubsystem.getTargetXRotation() > 0)
    		{
    			Robot.driveTrain.setRightSpeedPercentage(-1*driveSpeed);
    			Robot.driveTrain.setLeftSpeedPercentage(driveSpeed);
    		}
    		else if(Robot.cameraSubsystem.getTargetXRotation() < 0)
    		{
    			Robot.driveTrain.setLeftSpeedPercentage(-1*driveSpeed);
    	    	Robot.driveTrain.setRightSpeedPercentage(driveSpeed);
    		}
    		else // if it's 0
    		{
    			Robot.driveTrain.setLeftSpeedPercentage(0);
    	    	Robot.driveTrain.setRightSpeedPercentage(0);
    		}
    	}
    	else
    	{
    		//"do nothing" code
    		Robot.driveTrain.setLeftSpeedPercentage(0);
	    	Robot.driveTrain.setRightSpeedPercentage(0);
    	}
    }

    // Make this return true when this Command no longer needs to run execute()
    protected boolean isFinished() {
    	//deadband
    	if(Robot.cameraSubsystem.onTarget() || this.isTimedOut())
    		return true;
    	else if(!Robot.cameraSubsystem.isVisionRunning())
    	{ return true; }
    	
        return false;
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
