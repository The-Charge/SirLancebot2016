package org.usfirst.frc2619.SirLancebot2016.commands;

import org.usfirst.frc2619.MathUtil;
import org.usfirst.frc2619.SirLancebot2016.Robot;

import edu.wpi.first.wpilibj.command.Command;
import edu.wpi.first.wpilibj.smartdashboard.SmartDashboard;

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
    	int power = (int)SmartDashboard.getNumber("DelinPower");
    	double leftjoyvaly = MathUtil.delinearize(Robot.oi.leftJoystick.getY(), power);
    	double leftspeed = MathUtil.deadbandCheck(leftjoyvaly, super.deadbandY);
    	
    	leftspeed *= -1;
    	
    	return leftspeed;
    }
    
    protected double getRight(){
    	int power = (int)SmartDashboard.getNumber("DelinPower");
    	double leftjoyvalraw = MathUtil.delinearize(Robot.oi.leftJoystick.getRawAxis(5), power);
    	double rightspeed = MathUtil.deadbandCheck(leftjoyvalraw, super.deadbandY);
    	
    	return rightspeed;
    }
}
