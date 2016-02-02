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
import edu.wpi.first.wpilibj.CANTalon;
import edu.wpi.first.wpilibj.CANTalon.TalonControlMode;
import edu.wpi.first.wpilibj.command.Subsystem;
import edu.wpi.first.wpilibj.smartdashboard.SmartDashboard;


/**
 *
 */
public class DriveTrain extends Subsystem {

    // BEGIN AUTOGENERATED CODE, SOURCE=ROBOTBUILDER ID=CONSTANTS

    // END AUTOGENERATED CODE, SOURCE=ROBOTBUILDER ID=CONSTANTS

    // BEGIN AUTOGENERATED CODE, SOURCE=ROBOTBUILDER ID=DECLARATIONS
    private final CANTalon leftFrontMotor = RobotMap.driveTrainLeftFrontMotor;
    private final CANTalon leftMidMotor = RobotMap.driveTrainLeftMidMotor;
    private final CANTalon leftRearMotor = RobotMap.driveTrainLeftRearMotor;
    private final CANTalon rightFrontMotor = RobotMap.driveTrainRightFrontMotor;
    private final CANTalon rightMidMotor = RobotMap.driveTrainRightMidMotor;
    private final CANTalon rightRearMotor = RobotMap.driveTrainRightRearMotor;

    // END AUTOGENERATED CODE, SOURCE=ROBOTBUILDER ID=DECLARATIONS
    
    private final static double TICKSPERFOOT = 360; // ticks per revolution is ~1225
    private final static double MAX_TICKS_PER_SECOND = 800;
    
    private final static int PID_PROFILE_SPEED = 0;
    private final static int PID_PROFILE_POSITION = 1;
    
    private int driveTrainPositionDeadband;
    private int driveTrainSpeedDeadband;
    // Put methods for controlling this subsystem
    // here. Call these from Commands.

    public void initDefaultCommand() {
        // BEGIN AUTOGENERATED CODE, SOURCE=ROBOTBUILDER ID=DEFAULT_COMMAND

        setDefaultCommand(new DriveCG());

    // END AUTOGENERATED CODE, SOURCE=ROBOTBUILDER ID=DEFAULT_COMMAND

        // Set the default command for a subsystem here.
        // setDefaultCommand(new MySpecialCommand());
    }
    
    public void setLeftVbus(double speed)
    {
    	if(speed > 1)
    		speed = 1;
    	else if(speed < -1)
    		speed = -1;
    	
    	leftFrontMotor.set(speed);
    	leftMidMotor.set(speed);
    	leftRearMotor.set(speed);
    }
    public void setRightVbus(double speed)
    {
    	if(speed > 1)
    		speed = 1;
    	else if(speed < -1)
    		speed = -1;
    	
    	rightFrontMotor.set(speed);
    	rightMidMotor.set(speed);
    	rightRearMotor.set(speed);
    }
    
    public void setLeftPostionFeet(double feet){
    	leftFrontMotor.set(feet);
    }
    
    public void setRightPostionFeet(double feet){
    	rightFrontMotor.set(feet);
    }
    
    private void setProfile(int profile)
    {
    	leftFrontMotor.setProfile(profile);
    	rightFrontMotor.setProfile(profile);
    }
    
    private void setControlMode(int controlmode) {
		//setContronlMode
    	leftFrontMotor.setControlMode(controlmode);
    	rightFrontMotor.setControlMode(controlmode);
	}
    
    private void zeroEncoders() {
		//zero encoders
    	leftFrontMotor.setPosition(0);
    	rightFrontMotor.setPosition(0);
	}
  //---------------------methods for DriveXFeet command------------------------------------
    public void setDistanceTarget(double distanceInFeet){
    	
    	readDashboardControlValues();    	
    	setControlMode(TalonControlMode.Position.getValue());    	
    	zeroEncoders();
    	
    	double distanceInTicks = distanceInFeet * TICKSPERFOOT;
    	
    	//set distance
    	leftFrontMotor.set(distanceInTicks);
    	rightFrontMotor.set(-1*distanceInTicks);
    }	

	private void readDashboardControlValues() {
		
		setProfile(PID_PROFILE_POSITION);
		
		//set PID variables
    	double driveTrainPositionP = SmartDashboard.getNumber("DriveTrainPositionP");
    	double driveTrainPositionI = SmartDashboard.getNumber("DriveTrainPositionI");
    	double driveTrainPositionD = SmartDashboard.getNumber("DriveTrainPositionD");
    	
    	driveTrainPositionDeadband = (int)(SmartDashboard.getNumber("DriveTrainPositionDeadband"));
    	
    	//set CANTalon PIDs
    	leftFrontMotor.setPID(driveTrainPositionP, driveTrainPositionI, driveTrainPositionD);
    	rightFrontMotor.setPID(driveTrainPositionP, driveTrainPositionI, driveTrainPositionD);
    	
    	
    	//set CANTalon Deadbands
    	/*frontLeftTalon.setAllowableClosedLoopErr(0);
    	frontRightTalon.setAllowableClosedLoopErr(0);
    	rearLeftTalon.setAllowableClosedLoopErr(0);
    	rearRightTalon.setAllowableClosedLoopErr(0);
    	*/
    	
    	setProfile(PID_PROFILE_SPEED);
		
		//set PID variables
    	double driveTrainSpeedP = SmartDashboard.getNumber("DriveTrainSpeedP");
    	double driveTrainSpeedI = SmartDashboard.getNumber("DriveTrainSpeedI");
    	double driveTrainSpeedD = SmartDashboard.getNumber("DriveTrainSpeedD");
    	
    	driveTrainSpeedDeadband = (int)(SmartDashboard.getNumber("DriveTrainSpeedDeadband"));
    	
    	//set CANTalon PIDs
    	leftFrontMotor.setPID(driveTrainSpeedP, driveTrainSpeedI, driveTrainSpeedD);
    	rightFrontMotor.setPID(driveTrainSpeedP, driveTrainSpeedI, driveTrainSpeedD);
    	
    	//set CANTalon Speed Deadband
    	/*frontLeftTalon.setAllowableClosedLoopErr(0);
    	frontRightTalon.setAllowableClosedLoopErr(0);
    	rearLeftTalon.setAllowableClosedLoopErr(0);
    	rearRightTalon.setAllowableClosedLoopErr(0);
		*/
	}
	
	public void writeDashboardDebugValues()
	{
		// Output of Current Encoder Values:
		SmartDashboard.putNumber("LeftFrontEncoder", leftFrontMotor.pidGet());
		SmartDashboard.putNumber("RightFrontEncoder", rightFrontMotor.pidGet());
		
		// Output of Desired Setpoint
		SmartDashboard.putNumber("LeftFrontSetDist", leftFrontMotor.getSetpoint());
		SmartDashboard.putNumber("RightFrontSetDist", leftFrontMotor.getSetpoint());
		
		//Output Speed of Encoders
		SmartDashboard.putNumber("LeftFrontSpeed",leftFrontMotor.getEncVelocity());
		SmartDashboard.putNumber("RightFrontSpeed",rightFrontMotor.getEncVelocity());
	}
    
    public boolean atTarget(){
    	//setting variables to determine atTarget-ness
    	double leftFrontCurrentValue = leftFrontMotor.pidGet();
    	double leftFrontDesiredValue = leftFrontMotor.getSetpoint();
    	double leftFrontError = Math.abs(leftFrontDesiredValue - leftFrontCurrentValue);  //all these are in ticks
    	
    	double rightFrontCurrentValue = rightFrontMotor.pidGet();
    	double rightFrontDesiredValue = rightFrontMotor.getSetpoint();
    	double rightFrontError = Math.abs(rightFrontDesiredValue - rightFrontCurrentValue);
    	
    	double acceptableError = 15;  //in ticks
    	
    	//check if any of the PIDs in the CANTalons are close enough to the acceptableError
    	boolean atTargetFlag = false;
    	
    	if(leftFrontError < acceptableError)
    		atTargetFlag = true;
    	else if(rightFrontError < acceptableError)
    		atTargetFlag = true;
    	return atTargetFlag;
    }
    
    public void disablePID()
    {
    	setControlMode(TalonControlMode.PercentVbus.getValue());
    }
}

