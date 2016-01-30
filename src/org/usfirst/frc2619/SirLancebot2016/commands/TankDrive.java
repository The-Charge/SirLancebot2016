package org.usfirst.frc2619.SirLancebot2016.commands;

import org.usfirst.frc2619.SirLancebot2016.Robot;

import edu.wpi.first.wpilibj.command.Command;

/**
 *
 */
public class TankDrive extends DriveBase {

    public TankDrive() {
    	super();
        // Use requires() here to declare subsystem dependencies
        // eg. requires(chassis);
    }

    // Make this return true when this Command no longer needs to run execute()
    protected boolean isFinished() {
    	boolean enabled = Robot.oi.driveMode.getSelected().equals("tank");
    	
        return !enabled || super.isFinished();
    }

    protected double getLeft(){
    	double leftspeed = Robot.oi.leftJoystick.getY();
    	
    	leftspeed *= -1;
    	
    	return leftspeed;
    }
    
    protected double getRight(){
    	double rightspeed = Robot.oi.rightJoystick.getY();
    	
    	rightspeed *= -1;
    	
    	return rightspeed;
    }
}
