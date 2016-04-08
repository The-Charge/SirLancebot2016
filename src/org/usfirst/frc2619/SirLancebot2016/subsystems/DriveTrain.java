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
import org.usfirst.frc2619.SirLancebot2016.Robot;
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
    private final CANTalon leftRearMotor = RobotMap.driveTrainLeftRearMotor;
    private final CANTalon rightFrontMotor = RobotMap.driveTrainRightFrontMotor;
    private final CANTalon rightRearMotor = RobotMap.driveTrainRightRearMotor;

    // END AUTOGENERATED CODE, SOURCE=ROBOTBUILDER ID=DECLARATIONS

	public final static double DRIVETRAIN_SPEED_P_CONSTANT = .2;
	private final static double DRIVETRAIN_SPEED_I_CONSTANT = .001;
	private final static double DRIVETRAIN_SPEED_D_CONSTANT = 0;
	private final static double DRIVETRAIN_SPEED_F_CONSTANT = .1;

	public final static double DRIVETRAIN_POSITION_P_CONSTANT = 1.1;
	private final static double DRIVETRAIN_POSITION_I_CONSTANT = .0001;
	private final static double DRIVETRAIN_POSITION_D_CONSTANT = 0;

	private final static double DRIVETRAIN_SPEED_DEADBAND_CONSTANT = 50;
	private final static double DRIVETRAIN_POSITION_DEADBAND_CONSTANT = 300;

	private final static int PID_PROFILE_SPEED = 0;
	private final static int PID_PROFILE_POSITION = 1;

	private final static double TICKSPERFOOT = 4314.5;
	private final static double MAX_TICKS_PER_SECOND = 8300;

	private final double DEFAULT_DEADBANDX = .15;
	private final double DEFAULT_DEADBANDY = .15;
	private final double DEFAULT_DEADBANDZ = .15;
	private final double DEFAULT_DELIN_POWER = 3;

	private final static double DEFAULT_AIM_DISTANCE_SPEED = .03;
	private final static double DEFAULT_AIM_ANGLE_SPEED = .05;
	private final static double DISTANCE_GAIN = .03;
	private final static double ANGLE_GAIN = .004
			;

	// Put methods for controlling this subsystem
	// here. Call these from Commands.

	public DriveTrain() {
		writeDefaultDashboardValues();

		// Needed for Competition Bot,  comment out for plybot 
//		leftFrontMotor.reverseSensor(true);
//		rightFrontMotor.reverseSensor(true);
	}

	private void writeDefaultDashboardValues() {
		// put PID numbers on smart dashboard

		TheChargeDashboard.putNumber("DriveTrainSpeedP",
				DRIVETRAIN_SPEED_P_CONSTANT);
		TheChargeDashboard.putNumber("DriveTrainSpeedI",
				DRIVETRAIN_SPEED_I_CONSTANT);
		TheChargeDashboard.putNumber("DriveTrainSpeedD",
				DRIVETRAIN_SPEED_D_CONSTANT);
		TheChargeDashboard.putNumber("DriveTrainSpeedF",
				DRIVETRAIN_SPEED_F_CONSTANT);

		TheChargeDashboard.putNumber("DriveTrainSpeedDeadband",
				DRIVETRAIN_SPEED_DEADBAND_CONSTANT);

		TheChargeDashboard.putNumber("DriveTrainPositionP",
				DRIVETRAIN_POSITION_P_CONSTANT);
		TheChargeDashboard.putNumber("DriveTrainPositionI",
				DRIVETRAIN_POSITION_I_CONSTANT);
		TheChargeDashboard.putNumber("DriveTrainPositionD",
				DRIVETRAIN_POSITION_D_CONSTANT);

		TheChargeDashboard.putNumber("DriveTrainPositionDeadband",
				DRIVETRAIN_POSITION_DEADBAND_CONSTANT);

		// Joystick Deadband Values
		TheChargeDashboard.putNumber("DeadbandY", DEFAULT_DEADBANDY);
		TheChargeDashboard.putNumber("DeadbandX", DEFAULT_DEADBANDX);
		TheChargeDashboard.putNumber("DeadbandZ", DEFAULT_DEADBANDZ);
		TheChargeDashboard.putNumber("DelinPower", DEFAULT_DELIN_POWER);

		TheChargeDashboard.putNumber("AutonDistance", 3);
		TheChargeDashboard.putNumber("AutonSpeed", .5);
		TheChargeDashboard.putNumber("AutonDegrees", 54);
	}

	public void initDefaultCommand() {
		// BEGIN AUTOGENERATED CODE, SOURCE=ROBOTBUILDER ID=DEFAULT_COMMAND

        setDefaultCommand(new DriveCG());

    // END AUTOGENERATED CODE, SOURCE=ROBOTBUILDER ID=DEFAULT_COMMAND

		// Set the default command for a subsystem here.
		// setDefaultCommand(new MySpecialCommand());
	}

	public void setLeftPercentVBus(double percentvbus) {
		leftFrontMotor.set(percentvbus);
	}

	public void setRightPercentVBus(double percentvbus) {
		rightFrontMotor.set(percentvbus);
	}

	public void setLeftSpeedPercentage(double percentspeed) {
		leftFrontMotor.set(percentspeed * MAX_TICKS_PER_SECOND);
	}

	public void setRightSpeedPercentage(double percentspeed) {
		rightFrontMotor.set(percentspeed * MAX_TICKS_PER_SECOND);
	}

	public void initSpeedPercentageMode() {
		setControlMode(TalonControlMode.Speed.getValue());
		readDashboardControlValues();
		setProfile(PID_PROFILE_SPEED);

		leftFrontMotor.configMaxOutputVoltage(12);
		rightFrontMotor.configMaxOutputVoltage(12);
	}

	public void initPercentVBusMode() {
		setControlMode(TalonControlMode.PercentVbus.getValue());
		readDashboardControlValues();

		leftFrontMotor.configMaxOutputVoltage(12);
		rightFrontMotor.configMaxOutputVoltage(12);
	}

	public void initPositionMode() {
		setControlMode(TalonControlMode.Position.getValue());
		readDashboardControlValues();
		setProfile(PID_PROFILE_POSITION);

		// clear the accumulated I value in the PIDs
		leftFrontMotor.ClearIaccum();
		rightFrontMotor.ClearIaccum();

		leftFrontMotor.configMaxOutputVoltage(SmartDashboard
				.getNumber("AutonSpeed") * 12);
		rightFrontMotor.configMaxOutputVoltage(SmartDashboard
				.getNumber("AutonSpeed") * 12);
	}

	public void setLeftPostionFeet(double feet) {
		leftFrontMotor.set(feet);
	}

	public void setRightPostionFeet(double feet) {
		rightFrontMotor.set(feet);
	}

	private void setProfile(int profile) {
		leftFrontMotor.setProfile(profile);
		rightFrontMotor.setProfile(profile);
	}

	private void setControlMode(int controlmode) {
		// setContronlMode
		leftFrontMotor.setControlMode(controlmode);
		rightFrontMotor.setControlMode(controlmode);
	}

	private void zeroEncoders() {
		// zero encoders
		leftFrontMotor.setPosition(0);
		rightFrontMotor.setPosition(0);
	}

	/**
	 * if send true, turns on brake mode if send false, turns off brake mode
	 * 
	 * @param brakeMode
	 */
	public void brakeModeOn(boolean brakeMode) {
		// .enableBrakeMode(true) = brake mode on
		// .enableBrakeMode(false) = brake mode off
		leftFrontMotor.enableBrakeMode(brakeMode);
		rightFrontMotor.enableBrakeMode(brakeMode);
	}

	// ---------------------methods for DriveXFeet
	// command------------------------------------
	public void setDistanceTarget(double distanceInFeet) {
		zeroEncoders();

		double distanceInTicks = distanceInFeet * TICKSPERFOOT;

		// set distance
		leftFrontMotor.set(distanceInTicks);
		rightFrontMotor.set(-1 * distanceInTicks);
	}

	private void readDashboardControlValues() {

		setProfile(PID_PROFILE_POSITION);

		// set PID variables
		double driveTrainPositionP = SmartDashboard.getNumber(
				"DriveTrainPositionP", DRIVETRAIN_POSITION_P_CONSTANT);
		double driveTrainPositionI = SmartDashboard.getNumber(
				"DriveTrainPositionI", DRIVETRAIN_POSITION_I_CONSTANT);
		double driveTrainPositionD = SmartDashboard.getNumber(
				"DriveTrainPositionD", DRIVETRAIN_POSITION_D_CONSTANT);

		// set CANTalon PIDs
		leftFrontMotor.setPID(driveTrainPositionP, driveTrainPositionI,
				driveTrainPositionD);
		rightFrontMotor.setPID(driveTrainPositionP, driveTrainPositionI,
				driveTrainPositionD);

		setProfile(PID_PROFILE_SPEED);

		// set PID variables
		double driveTrainSpeedP = SmartDashboard.getNumber("DriveTrainSpeedP",
				DRIVETRAIN_SPEED_P_CONSTANT);
		double driveTrainSpeedI = SmartDashboard.getNumber("DriveTrainSpeedI",
				DRIVETRAIN_SPEED_I_CONSTANT);
		double driveTrainSpeedD = SmartDashboard.getNumber("DriveTrainSpeedD",
				DRIVETRAIN_SPEED_D_CONSTANT);
		double driveTrainSpeedF = SmartDashboard.getNumber("DriveTrainSpeedF",
				DRIVETRAIN_SPEED_F_CONSTANT);

		// set CANTalon PIDs
		leftFrontMotor.setPID(driveTrainSpeedP, driveTrainSpeedI,
				driveTrainSpeedD, driveTrainSpeedF, 0, 0, PID_PROFILE_SPEED);
		rightFrontMotor.setPID(driveTrainSpeedP, driveTrainSpeedI,
				driveTrainSpeedD, driveTrainSpeedF, 0, 0, PID_PROFILE_SPEED);
	}

	public void writeDashboardDebugValues() {
		// Output of Current Encoder Values:
		TheChargeDashboard.putNumber("LeftFrontEncoder",
				leftFrontMotor.pidGet());
		TheChargeDashboard.putNumber("RightFrontEncoder",
				rightFrontMotor.pidGet());

		// Output of Desired Setpoint
		TheChargeDashboard.putNumber("LeftFrontSetDist",
				leftFrontMotor.getSetpoint());
		TheChargeDashboard.putNumber("RightFrontSetDist",
				leftFrontMotor.getSetpoint());

		// Output Speed of Encoders
		TheChargeDashboard.putNumber("LeftFrontSpeed",
				leftFrontMotor.getEncVelocity());
		TheChargeDashboard.putNumber("RightFrontSpeed",
				rightFrontMotor.getEncVelocity());
	}

	public boolean atTarget() {
		// setting variables to determine atTarget-ness
		double leftFrontCurrentValue = leftFrontMotor.pidGet();
		double leftFrontDesiredValue = leftFrontMotor.getSetpoint();
		double leftFrontError = Math.abs(leftFrontDesiredValue
				- leftFrontCurrentValue); // all these are in ticks
		double rightFrontCurrentValue = rightFrontMotor.pidGet();
		double rightFrontDesiredValue = rightFrontMotor.getSetpoint();
		double rightFrontError = Math.abs(rightFrontDesiredValue
				- rightFrontCurrentValue);

		double acceptableError = 250; // in ticks

		// check if any of the PIDs in the CANTalons are close enough to the
		// acceptableError

		if ((leftFrontError < acceptableError) || (rightFrontError < acceptableError))
			return true;
		else
			return false;
	}

	public void disablePID() {
		setControlMode(TalonControlMode.PercentVbus.getValue());
	}

	public void autoPosition() // For AutoAimHorizontal
	{
		setLeftSpeedPercentage(motorSpeedCalcDis() + motorSpeedCalcAng());
		setRightSpeedPercentage(motorSpeedCalcDis() - motorSpeedCalcAng());
		//setRightSpeedPercentage(motorSpeedCalcDis());
	}

	double motorSpeedCalcDis() {
		if (!Robot.cameraSubsystem.onDistanceTarget()) // not on target
			if (Robot.cameraSubsystem.getDistance() > Robot.cameraSubsystem.OPTIMAL_DISTANCE) // too far away
				return ((Robot.cameraSubsystem.getDistance() - Robot.cameraSubsystem.OPTIMAL_DISTANCE) * DISTANCE_GAIN)
						+ DEFAULT_AIM_DISTANCE_SPEED;
			else  // too close
				return ((Robot.cameraSubsystem.getDistance() - Robot.cameraSubsystem.OPTIMAL_DISTANCE) * DISTANCE_GAIN)
						- DEFAULT_AIM_DISTANCE_SPEED;
		else  // on target
			return 0.0;
	}

	double motorSpeedCalcAng() {
		if (!Robot.cameraSubsystem.onAngleTarget()) // not on target
			if (Robot.cameraSubsystem.getTargetXRotation() > 0.0) // turn right
				return (Robot.cameraSubsystem.getTargetXRotation() * ANGLE_GAIN) *
						((Robot.cameraSubsystem.OPTIMAL_DISTANCE*Robot.cameraSubsystem.OPTIMAL_DISTANCE) / 
						(Robot.cameraSubsystem.getDistance()*Robot.cameraSubsystem.getDistance()))
						+ DEFAULT_AIM_ANGLE_SPEED;
			else  // turn left
				return (Robot.cameraSubsystem.getTargetXRotation() * ANGLE_GAIN) *
						((Robot.cameraSubsystem.OPTIMAL_DISTANCE*Robot.cameraSubsystem.OPTIMAL_DISTANCE) / 
						(Robot.cameraSubsystem.getDistance()*Robot.cameraSubsystem.getDistance()))
						- DEFAULT_AIM_ANGLE_SPEED;
		else  // on target
			return 0.0;
	}

}
