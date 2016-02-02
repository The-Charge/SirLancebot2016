package org.usfirst.frc2619.SirLancebot2016.commands;

import org.usfirst.frc2619.MathUtil;
import org.usfirst.frc2619.SirLancebot2016.Robot;

import edu.wpi.first.wpilibj.command.Command;

/**
 *
 */
public class ArcadeDrive extends DriveBase {

    public ArcadeDrive() {
    	super();
        // Use requires() here to declare subsystem dependencies
        // eg. requires(chassis);
    }

    protected boolean isFinished() {
    	boolean enabled = Robot.oi.driveMode.getSelected().equals("arcade");
    	
        return !enabled || super.isFinished();
    }

    protected double getLeft(){
    	double leftspeed = MathUtil.deadbandCheck(Robot.oi.leftJoystick.getY() * -1 - -1 * Robot.oi.leftJoystick.getX(), 
    																										super.deadband);
    	return leftspeed;
    }
    
    protected double getRight(){
    	double rightspeed = MathUtil.deadbandCheck(Robot.oi.rightJoystick.getY() * -1 + -1 * Robot.oi.leftJoystick.getX(), 
    																										super.deadband);
    	return rightspeed;
    }
}
