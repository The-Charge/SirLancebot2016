package org.usfirst.frc2619.SirLancebot2016.commands;

import org.usfirst.frc2619.SirLancebot2016.Robot;

import edu.wpi.first.wpilibj.command.Command;

/**
 *
 */
public class ClaytonDrive extends DriveBase {

    public ClaytonDrive() {
    	super();
        // Use requires() here to declare subsystem dependencies
        // eg. requires(chassis);
    }

    protected boolean isFinished() {
    	boolean enabled = Robot.oi.driveMode.getSelected().equals("clayton");
    	
        return !enabled || super.isFinished();
    }

    protected double getLeft(){
    	double leftspeed = Robot.oi.leftJoystick.getY() * -1 - -1 * Robot.oi.leftJoystick.getZ();
    	
    	return leftspeed;
    }
    
    protected double getRight(){
    	double rightspeed = Robot.oi.leftJoystick.getY() * -1 + -1 * Robot.oi.leftJoystick.getZ();
    	
    	return rightspeed;
    }
}
