package org.usfirst.frc2619.SirLancebot2016.commands;

import org.usfirst.frc2619.SirLancebot2016.Robot;

import edu.wpi.first.wpilibj.command.Command;

/**
 *
 */
public class HaloDrive extends DriveBase {

    public HaloDrive() {
    	super();
        // Use requires() here to declare subsystem dependencies
        // eg. requires(chassis);
    }

    protected boolean isFinished() {
    	boolean enabled = Robot.oi.driveMode.getSelected().equals("halo");
    	
        return !enabled || super.isFinished();
    }

    protected double getLeft(){
    	double leftspeed = Robot.oi.leftJoystick.getY() * -1 - Robot.oi.leftJoystick.getRawAxis(4);
    	
    	return leftspeed;
    }
    
    protected double getRight(){
    	double rightspeed = Robot.oi.rightJoystick.getY() * -1 + Robot.oi.leftJoystick.getRawAxis(4);
    	
    	return rightspeed;
    }
}
