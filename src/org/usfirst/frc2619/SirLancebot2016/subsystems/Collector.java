// RobotBuilder Version: 2.0
//
// This file was generated by RobotBuilder. It contains sections of
// code that are automatically generated and assigned by robotbuilder.
// These sections will be updated in the future when you export to
// Java from RobotBuilder. Do not put any code or make any change in
// the blocks indicating autogenerated code or it will be lost on an
// update. Deleting the comments indicating the section will prevent
// it from being updated in the future.


package org.usfirst.frc2619.SirLancebot2016.subsystems;

import org.usfirst.frc2619.TheChargeDashboard;
import org.usfirst.frc2619.SirLancebot2016.RobotMap;
import org.usfirst.frc2619.SirLancebot2016.commands.*;

import edu.wpi.first.wpilibj.CANTalon;
import edu.wpi.first.wpilibj.DoubleSolenoid;
import edu.wpi.first.wpilibj.command.Subsystem;
import edu.wpi.first.wpilibj.smartdashboard.SmartDashboard;


/**
 *
 */
public class Collector extends Subsystem {

    // BEGIN AUTOGENERATED CODE, SOURCE=ROBOTBUILDER ID=CONSTANTS

    // END AUTOGENERATED CODE, SOURCE=ROBOTBUILDER ID=CONSTANTS

    // BEGIN AUTOGENERATED CODE, SOURCE=ROBOTBUILDER ID=DECLARATIONS
    private final DoubleSolenoid armLift = RobotMap.collectorarmLift;
    private final CANTalon feedRoller = RobotMap.collectorfeedRoller;
    private final CANTalon centerRoller = RobotMap.collectorcenterRoller;
    private final DoubleSolenoid wristJoint = RobotMap.collectorWristJoint;

    // END AUTOGENERATED CODE, SOURCE=ROBOTBUILDER ID=DECLARATIONS
    public static final double FORWARD_SPEED_FEED = .5;
    public static final double FORWARD_SPEED_CENTER = .5;
    public static final double REVERSE_SPEED_FEED = -.5;
    public static final double REVERSE_SPEED_CENTER = -.5;
    
    public double forwardSpeedFeed = FORWARD_SPEED_FEED;
    public double forwardSpeedCenter = FORWARD_SPEED_CENTER;
    public double reverseSpeedFeed = REVERSE_SPEED_FEED;
    public double reverseSpeedCenter = REVERSE_SPEED_CENTER;

    // Put methods for controlling this subsystem
    // here. Call these from Commands.

    public void initDefaultCommand() {
        // BEGIN AUTOGENERATED CODE, SOURCE=ROBOTBUILDER ID=DEFAULT_COMMAND


    // END AUTOGENERATED CODE, SOURCE=ROBOTBUILDER ID=DEFAULT_COMMAND

        // Set the default command for a subsystem here.
        // setDefaultCommand(new MySpecialCommand());
    	writeDashboardDefaultValues();
    }
    
    public void writeDashboardDefaultValues()
    {
    	TheChargeDashboard.putNumber("Feed Roller Forward Speed", FORWARD_SPEED_FEED);
    	TheChargeDashboard.putNumber("Feed Roller Reverse Speed", REVERSE_SPEED_FEED);
    	TheChargeDashboard.putNumber("Center Roller Forward Speed", FORWARD_SPEED_CENTER);
    	TheChargeDashboard.putNumber("Center Roller Reverse Speed", REVERSE_SPEED_CENTER);
    }
    
    public void readDashboardValues()
    {
    	forwardSpeedFeed = SmartDashboard.getNumber("Feed Roller Forward Speed");
        forwardSpeedCenter = SmartDashboard.getNumber("Center Roller Forward Speed");
        reverseSpeedFeed = SmartDashboard.getNumber("Feed Roller Reverse Speed");
        reverseSpeedCenter = SmartDashboard.getNumber("Center Roller Reverse Speed");
    }
    
    public void writeDashboardDebugValues()
    {
    	TheChargeDashboard.putNumber("Feed Roller Forward Speed", forwardSpeedFeed);
    	TheChargeDashboard.putNumber("Feed Roller Reverse Speed", reverseSpeedFeed);
    	TheChargeDashboard.putNumber("Center Roller Forward Speed", forwardSpeedCenter);
    	TheChargeDashboard.putNumber("Center Roller Reverse Speed", reverseSpeedCenter);
    }
    
    public void liftCollector()
    {
    	armLift.set(DoubleSolenoid.Value.kForward);
    }
    
    public void lowerCollector()
    {
    	armLift.set(DoubleSolenoid.Value.kReverse);
    }
    
    public void stopRollers()
    {
    	feedRoller.set(0);
    	centerRoller.set(0);
    }
    
    public void forwardRollers()
    {
    	feedRoller.set(FORWARD_SPEED_FEED);
    	centerRoller.set(FORWARD_SPEED_CENTER);
    }
    
    public void reverseRollers()
    {
    	feedRoller.set(REVERSE_SPEED_FEED);
    	centerRoller.set(REVERSE_SPEED_CENTER);
    }
    
    //wrist methods
    public void raiseWrist()
    {
    	wristJoint.set(DoubleSolenoid.Value.kForward);
    }
    
    public void lowerWrist()
    {
    	wristJoint.set(DoubleSolenoid.Value.kReverse);
    }
}

