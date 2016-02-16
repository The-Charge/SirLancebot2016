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

import org.usfirst.frc2619.Constants;
import org.usfirst.frc2619.TheChargeDashboard;
import org.usfirst.frc2619.SirLancebot2016.RobotMap;
import org.usfirst.frc2619.SirLancebot2016.commands.*;

import edu.wpi.first.wpilibj.command.Subsystem;
import edu.wpi.first.wpilibj.networktables.NetworkTable;
import edu.wpi.first.wpilibj.smartdashboard.SmartDashboard;


/**
 *
 */
public class CameraSubsystem extends Subsystem {
	NetworkTable cameraTable;

    // BEGIN AUTOGENERATED CODE, SOURCE=ROBOTBUILDER ID=CONSTANTS

    // END AUTOGENERATED CODE, SOURCE=ROBOTBUILDER ID=CONSTANTS

    // BEGIN AUTOGENERATED CODE, SOURCE=ROBOTBUILDER ID=DECLARATIONS

    // END AUTOGENERATED CODE, SOURCE=ROBOTBUILDER ID=DECLARATIONS
	public CameraSubsystem()
	{
		cameraTable = NetworkTable.getTable("Vision");
	}


    // Put methods for controlling this subsystem
    // here. Call these from Commands.

    public void initDefaultCommand() {
    	
        // BEGIN AUTOGENERATED CODE, SOURCE=ROBOTBUILDER ID=DEFAULT_COMMAND

        setDefaultCommand(new CameraDebug());

    // END AUTOGENERATED CODE, SOURCE=ROBOTBUILDER ID=DEFAULT_COMMAND
        // Set the default command for a subsystem here.
        // setDefaultCommand(new MySpecialCommand());
    }
    
    public void writeDashboardDebugValues()
    {    	
    	TheChargeDashboard.putNumber("Distance", cameraTable.getNumber("Distance", 0));
    	TheChargeDashboard.putNumber("xRotationAngle", cameraTable.getNumber("xRotationAngle", 0));
    	TheChargeDashboard.putNumber("yoffset", cameraTable.getNumber("yoffset", 0));
    	TheChargeDashboard.putNumber("xoffset", cameraTable.getNumber("xoffset", 0));
    	TheChargeDashboard.putNumber("yRotationAngle", cameraTable.getNumber("yRotationAngle", 0));
    	TheChargeDashboard.putNumber("BLOB_COUNT", cameraTable.getNumber("BLOB_COUNT", 0));
    }
    
    public double targetHorizontalOffset()
    {
    	return cameraTable.getNumber("xoffset", 0);
    }
    
    public double getTargetXRotation()
    {
    	return cameraTable.getNumber("xRotationAngle", 0);
    }
    
    public boolean isTargetVisible()
    {
    	return cameraTable.getNumber("BLOB_COUNT", 0) > 0;
    }
    
    public void turnToOriginalTargetDirection()
    {
    	new TurnNDegreesAbsolute(Constants.TOWER_ROTATION_FROM_STARTPOINT);
    }
}

