package org.usfirst.frc2619.SirLancebot2016.commands;

import org.usfirst.frc2619.MathUtil;
import org.usfirst.frc2619.SirLancebot2016.Robot;

import edu.wpi.first.wpilibj.command.Command;
import edu.wpi.first.wpilibj.smartdashboard.SmartDashboard;

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
    	int power = (int)SmartDashboard.getNumber("DelinPower");
    	double leftjoyvaly = MathUtil.delinearize(Robot.oi.leftJoystick.getY(), power);
    	double leftjoyvalraw = MathUtil.delinearize(Robot.oi.leftJoystick.getRawAxis(4), power);
    	double leftspeed = MathUtil.deadbandCheck(leftjoyvaly * -1 - leftjoyvalraw, super.deadbandX);
    	return leftspeed;
    }
    
    protected double getRight(){
    	int power = (int)SmartDashboard.getNumber("DelinPower");
    	double rightjoyvaly = MathUtil.delinearize(Robot.oi.rightJoystick.getY(), power);
    	double leftjoyvalraw = MathUtil.delinearize(Robot.oi.leftJoystick.getRawAxis(4), power);
    	double rightspeed = MathUtil.deadbandCheck(rightjoyvaly * -1, super.deadbandY) 
    			+ MathUtil.deadbandCheck(leftjoyvalraw, super.deadbandX);
    	return rightspeed;
    }
}
