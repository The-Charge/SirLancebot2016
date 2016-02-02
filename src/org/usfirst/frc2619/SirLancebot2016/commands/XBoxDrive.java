package org.usfirst.frc2619.SirLancebot2016.commands;

import org.usfirst.frc2619.MathUtil;
import org.usfirst.frc2619.SirLancebot2016.Robot;

import edu.wpi.first.wpilibj.command.Command;

/**
 * 
 *
 */
public class XBoxDrive extends DriveBase {

    public XBoxDrive() {
    	super();
        // Use requires() here to declare subsystem dependencies
        // eg. requires(chassis);
    }

    protected boolean isFinished() {
    	boolean enabled = Robot.oi.driveMode.getSelected().equals("xbox");
    	
        return !enabled || super.isFinished();
    }

    protected double getLeft(){
    	double leftspeed = MathUtil.deadbandCheck(Robot.oi.leftJoystick.getY(), super.deadbandY);
    	
    	leftspeed *= -1;
    	
    	return leftspeed;
    }
    
    protected double getRight(){
    	double rightspeed = MathUtil.deadbandCheck(Robot.oi.leftJoystick.getRawAxis(5), super.deadbandY);
    	
    	return rightspeed;
    }
}
