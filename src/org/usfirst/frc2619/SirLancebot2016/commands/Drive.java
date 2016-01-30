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
import org.usfirst.frc2619.SirLancebot2016.Robot;

/**
 *
 */
public class Drive extends Command {
	private final double DEADBAND_VALUE = .15;
	private final int POWER = 3;

    // BEGIN AUTOGENERATED CODE, SOURCE=ROBOTBUILDER ID=VARIABLE_DECLARATIONS
 
    // END AUTOGENERATED CODE, SOURCE=ROBOTBUILDER ID=VARIABLE_DECLARATIONS

    // BEGIN AUTOGENERATED CODE, SOURCE=ROBOTBUILDER ID=CONSTRUCTOR
    public Drive() {

    // END AUTOGENERATED CODE, SOURCE=ROBOTBUILDER ID=CONSTRUCTOR
        // BEGIN AUTOGENERATED CODE, SOURCE=ROBOTBUILDER ID=VARIABLE_SETTING

        // END AUTOGENERATED CODE, SOURCE=ROBOTBUILDER ID=VARIABLE_SETTING
        // BEGIN AUTOGENERATED CODE, SOURCE=ROBOTBUILDER ID=REQUIRES
        requires(Robot.driveTrain);

        // END AUTOGENERATED CODE, SOURCE=ROBOTBUILDER ID=REQUIRES
    }

    // Called just before this Command runs the first time
    protected void initialize() {
    	Robot.driveTrain.setLeftVbus(0);
    	Robot.driveTrain.setRightVbus(0);
    }

    // Called repeatedly when this Command is scheduled to run
    protected void execute() {
    	
    	double speedleft = Robot.oi.leftJoystick.getY();
    	double speedright = Robot.oi.rightJoystick.getY();
    	
    	speedleft = deadband(speedleft);
    	speedright = deadband(speedright);
    	
    	speedleft = MathUtil.delinerize(speedleft, POWER);
    	speedright = MathUtil.delinerize(speedright, POWER);
    	
    	Robot.driveTrain.setLeftVbus(speedleft);
    	Robot.driveTrain.setRightVbus(speedright);
    }

    // Make this return true when this Command no longer needs to run execute()
    protected boolean isFinished() {
        return false;
    }

    // Called once after isFinished returns true
    protected void end() {
    	Robot.driveTrain.setLeftVbus(0);
    	Robot.driveTrain.setRightVbus(0);
    }

    // Called when another command which requires one or more of the same
    // subsystems is scheduled to run
    protected void interrupted() {
    	end();
    }
    
    private double deadband(double speed)
    {
    	if(Math.abs(speed)<DEADBAND_VALUE)
    	{
    		speed = 0;
    	}
    	
    	return speed;
    }
   
}
