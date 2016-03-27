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
import org.usfirst.frc2619.SirLancebot2016.commands.*;

import edu.wpi.first.wpilibj.command.Subsystem;

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

	private static final double DEADBAND = 5; //in degrees from -180 to 180
	
    // Put methods for controlling this subsystem
    // here. Call these from Commands.
	
	public AHRS ahrs;
	
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
    	
    	TheChargeDashboard.putBoolean("IMU_Connected", ahrs.isConnected());
    	TheChargeDashboard.putBoolean("IMU_IsCalibrating", ahrs.isCalibrating());
    	TheChargeDashboard.putNumber("IMU_Yaw",ahrs.getYaw());
    	TheChargeDashboard.putNumber("IMU_Pitch", ahrs.getPitch());
    	TheChargeDashboard.putNumber("IMU_Roll", ahrs.getRoll());
    	
    	TheChargeDashboard.putNumber("IMU_CompassHeading", ahrs.getCompassHeading());
    	
    	TheChargeDashboard.putNumber("IMU_TotalYaw", ahrs.getAngle());
    	TheChargeDashboard.putNumber("IMU_YawRateDPS", ahrs.getRate());
    	
    	TheChargeDashboard.putNumber("IMU_Accel_X", ahrs.getWorldLinearAccelX());
    	TheChargeDashboard.putNumber("IMU_Accel_Y", ahrs.getWorldLinearAccelY());
    	TheChargeDashboard.putBoolean("IMU_IsMoving", ahrs.isMoving());
    	TheChargeDashboard.putBoolean("IMU_IsRotating", ahrs.isRotating());
    	
    	TheChargeDashboard.putNumber("Velocity_X", ahrs.getVelocityX());
    	TheChargeDashboard.putNumber("Velocity_Y", ahrs.getVelocityY());
    	TheChargeDashboard.putNumber("Displacement_X", ahrs.getDisplacementX());
    	TheChargeDashboard.putNumber("Displacement_Y", ahrs.getDisplacementY());
    	
    	TheChargeDashboard.putNumber("RawGyro_X", ahrs.getRawGyroX());
    	TheChargeDashboard.putNumber("RawGyro_Y", ahrs.getRawGyroY());
    	TheChargeDashboard.putNumber("RawGyro_Z", ahrs.getRawGyroZ());
    	TheChargeDashboard.putNumber("RawAccel_X", ahrs.getRawAccelX());
    	TheChargeDashboard.putNumber("RawAccel_Y", ahrs.getRawAccelY());
    	TheChargeDashboard.putNumber("RawAccel_Z", ahrs.getRawAccelZ());
    	TheChargeDashboard.putNumber("RawMag_X", ahrs.getRawMagX());
    	TheChargeDashboard.putNumber("RawMag_Y", ahrs.getRawMagY());
    	TheChargeDashboard.putNumber("RawMag_Z", ahrs.getRawMagZ());
    	TheChargeDashboard.putNumber("IMU_Temp_C", ahrs.getTempC());
    	
    	AHRS.BoardYawAxis yaw_axis = ahrs.getBoardYawAxis();
    	TheChargeDashboard.putString("YawAxisDirection", yaw_axis.up ? "Up" : "Down");
    	TheChargeDashboard.putNumber("YawAxis",yaw_axis.board_axis.getValue());
    	
    	TheChargeDashboard.putString("FirmwareVersion", ahrs.getFirmwareVersion());
    	
    	TheChargeDashboard.putNumber("QuaternionW", ahrs.getQuaternionW());
    	TheChargeDashboard.putNumber("QuaternationX", ahrs.getQuaternionX());
    	TheChargeDashboard.putNumber("QuaternionY", ahrs.getQuaternionY());
    	TheChargeDashboard.putNumber("QuaternionZ", ahrs.getQuaternionZ());
    	
    	TheChargeDashboard.putNumber("IMU_Byte_Count",ahrs.getByteCount());
    	TheChargeDashboard.putNumber("IMU_Updaate_Count", ahrs.getUpdateCount());
    }
    
    public boolean isFlat()
    {
    	return ahrs.getPitch() < DEADBAND && ahrs.getRoll() < DEADBAND;
    }
}

