package org.usfirst.frc2619;

import java.util.*;

import edu.wpi.first.wpilibj.smartdashboard.SmartDashboard;

public class TheChargeDashboard {
	
	private static String[] whiteList = {
		/*DriveTrainSpeed*/ "DriveTrainSpeedP", "DriveTrainSpeedI", "DriveTrainSpeedD", "DriveTrainSpeedF", "DriveTrainSpeedDeadband",
		/*DriveTrainPosition*/ "DriveTrainPositionP", "DriveTrainPositionI", "DriveTrainPositionD", "DriveTrainPositionDeadband",
		/*DriveTrainEncoders*/ "LeftFrontEncoder", "RightFrontEncoder", "LeftFrontSpeed", "RightFrontSpeed",
		/*DriveTrainDeadband*/ "DeadbandY", "DeadbandX", "DeadbandZ",
		/*CamaraSubsystem*/ "Distance", "xRotationAngle", "BLOB_COUNT",
		/*GyroSubsystem*/ "IMU_TotalYaw",
		/*IntakeArms*/ "IntakeArmsSpeed",
		/*Shooter*/ "ShooterSpeedP", "ShooterSpeedI", "ShooterSpeedD", "ShooterSpeedF", "ShooterSpeedFromPot", "ShooterLeftSpeed", "ShooterRightSpeed"
		};
	
	public static void putNumber(String key, double value)
	{
		for(int x = 0; x < whiteList.length; x++)
		{
			if(key.equals(whiteList[x]))
			{
				SmartDashboard.putNumber(key,value);
			}
		}
	}
	public static void putBoolean(String key, boolean value){
		for(int x = 0; x < whiteList.length; x++)
		{
			if(key.equals(whiteList[x]))
			{
				SmartDashboard.putBoolean(key,value);
			}
		}
	}
	public static void putString(String key, String value)
	{
		for(int x = 0; x < whiteList.length; x++)
		{
			if(key.equals(whiteList[x]))
			{
				SmartDashboard.putString(key,value);
			}
		}
	}
}
