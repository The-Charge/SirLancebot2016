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

import org.usfirst.frc2619.SirLancebot2016.RobotMap;

import org.usfirst.frc2619.SirLancebot2016.commands.*;

import edu.wpi.first.wpilibj.command.Subsystem;
import edu.wpi.first.wpilibj.smartdashboard.SmartDashboard;

import com.kauailabs.navx.frc.AHRS;

import edu.wpi.first.wpilibj.SPI;


/**
 *
 */
public class GyroSubsystem extends Subsystem {

    // BEGIN AUTOGENERATED CODE, SOURCE=ROBOTBUILDER ID=CONSTANTS

    // END AUTOGENERATED CODE, SOURCE=ROBOTBUILDER ID=CONSTANTS

    // BEGIN AUTOGENERATED CODE, SOURCE=ROBOTBUILDER ID=DECLARATIONS

    // END AUTOGENERATED CODE, SOURCE=ROBOTBUILDER ID=DECLARATIONS


    // Put methods for controlling this subsystem
    // here. Call these from Commands.
	
	AHRS ahrs;
	
	public GyroSubsystem(){
		ahrs = new AHRS(SPI.Port.kMXP);
	}

    public void initDefaultCommand() {
        // BEGIN AUTOGENERATED CODE, SOURCE=ROBOTBUILDER ID=DEFAULT_COMMAND

        setDefaultCommand(new GyroDebug());

    // END AUTOGENERATED CODE, SOURCE=ROBOTBUILDER ID=DEFAULT_COMMAND

        // Set the default command for a subsystem here.
        // setDefaultCommand(new MySpecialCommand());
    }
    
    public void writeDashboardDebugValues(){
    	
    	SmartDashboard.putBoolean("IMU_Connected", ahrs.isConnected());
    	SmartDashboard.putBoolean("IMU_IsCalibrating", ahrs.isCalibrating());
    	SmartDashboard.putNumber("IMU_Yaw",ahrs.getYaw());
    	SmartDashboard.putNumber("IMU_Pitch", ahrs.getPitch());
    	SmartDashboard.putNumber("IMU_Roll", ahrs.getRoll());
    	
    	SmartDashboard.putNumber("IMU_CompassHeading", ahrs.getCompassHeading());
    	
    	SmartDashboard.putNumber("IMU_TotalYaw", ahrs.getAngle());
    	SmartDashboard.putNumber("IMU_YawRateDPS", ahrs.getRate());
    	
    	SmartDashboard.putNumber("IMU_Accel_X", ahrs.getWorldLinearAccelX());
    	SmartDashboard.putNumber("IMU_Accel_Y", ahrs.getWorldLinearAccelY());
    	SmartDashboard.putBoolean("IMU_IsMoving", ahrs.isMoving());
    	SmartDashboard.putBoolean("IMU_IsRotating", ahrs.isRotating());
    	
    	SmartDashboard.putNumber("Velocity_X", ahrs.getVelocityX());
    	SmartDashboard.putNumber("Velocity_Y", ahrs.getVelocityY());
    	SmartDashboard.putNumber("Displacement_X", ahrs.getDisplacementX());
    	SmartDashboard.putNumber("Displacement_Y", ahrs.getDisplacementY());
    	
    	SmartDashboard.putNumber("RawGyro_X", ahrs.getRawGyroX());
    	SmartDashboard.putNumber("RawGyro_Y", ahrs.getRawGyroY());
    	SmartDashboard.putNumber("RawGyro_Z", ahrs.getRawGyroZ());
    	SmartDashboard.putNumber("RawAccel_X", ahrs.getRawAccelX());
    	SmartDashboard.putNumber("RawAccel_Y", ahrs.getRawAccelY());
    	SmartDashboard.putNumber("RawAccel_Z", ahrs.getRawAccelZ());
    	SmartDashboard.putNumber("RawMag_X", ahrs.getRawMagX());
    	SmartDashboard.putNumber("RawMag_Y", ahrs.getRawMagY());
    	SmartDashboard.putNumber("RawMag_Z", ahrs.getRawMagZ());
    	SmartDashboard.putNumber("IMU_Temp_C", ahrs.getTempC());
    	
    	AHRS.BoardYawAxis yaw_axis = ahrs.getBoardYawAxis();
    	SmartDashboard.putString("YawAxisDirection", yaw_axis.up ? "Up" : "Down");
    	SmartDashboard.putNumber("YawAxis",yaw_axis.board_axis.getValue());
    	
    	SmartDashboard.putString("FirmwareVersion", ahrs.getFirmwareVersion());
    	
    	SmartDashboard.putNumber("QuaternionW", ahrs.getQuaternionW());
    	SmartDashboard.putNumber("QuaternationX", ahrs.getQuaternionX());
    	SmartDashboard.putNumber("QuaternionY", ahrs.getQuaternionY());
    	SmartDashboard.putNumber("QuaternionZ", ahrs.getQuaternionZ());
    	
    	SmartDashboard.putNumber("IMU_Byte_Count",ahrs.getByteCount());
    	SmartDashboard.putNumber("IMU_Updaate_Count", ahrs.getUpdateCount());
    }
}

