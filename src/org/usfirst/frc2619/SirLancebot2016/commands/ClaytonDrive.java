package org.usfirst.frc2619.SirLancebot2016.commands;

import org.usfirst.frc2619.MathUtil;
import org.usfirst.frc2619.SirLancebot2016.Robot;

import edu.wpi.first.wpilibj.command.Command;
import edu.wpi.first.wpilibj.smartdashboard.SmartDashboard;

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
    	int power = (int)SmartDashboard.getNumber("DelinPower");
    	double leftjoyvaly = MathUtil.delinearize(Robot.oi.leftJoystick.getY(), power);
    	double leftjoyvalz = MathUtil.delinearize(Robot.oi.leftJoystick.getZ(), power);
    	double leftspeed = MathUtil.deadbandCheck(leftjoyvaly * -1, super.deadbandY) 
    						- MathUtil.deadbandCheck(-1 * leftjoyvalz, super.deadbandZ);   	
    	return leftspeed;
    }
    
    protected double getRight(){
    	int power = (int)SmartDashboard.getNumber("DelinPower");
    	double rightjoyvaly = MathUtil.delinearize(Robot.oi.rightJoystick.getY(), power);
    	double rightjoyvalz = MathUtil.delinearize(Robot.oi.rightJoystick.getZ(), power);
    	double rightspeed = MathUtil.deadbandCheck(rightjoyvaly * -1, super.deadbandY) 
	    					+ MathUtil.deadbandCheck(-1 * rightjoyvalz, super.deadbandZ);    	
    	return rightspeed;
    }
}
