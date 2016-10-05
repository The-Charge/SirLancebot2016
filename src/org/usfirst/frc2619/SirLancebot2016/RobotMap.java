// RobotBuilder Version: 2.0
//
// This file was generated by RobotBuilder. It contains sections of
// code that are automatically generated and assigned by robotbuilder.
// These sections will be updated in the future when you export to
// Java from RobotBuilder. Do not put any code or make any change in
// the blocks indicating autogenerated code or it will be lost on an
// update. Deleting the comments indicating the section will prevent
// it from being updated in the future.

package org.usfirst.frc2619.SirLancebot2016;

// BEGIN AUTOGENERATED CODE, SOURCE=ROBOTBUILDER ID=IMPORTS
import edu.wpi.first.wpilibj.CANTalon;
import edu.wpi.first.wpilibj.DigitalInput;
import edu.wpi.first.wpilibj.DoubleSolenoid;
import edu.wpi.first.wpilibj.Relay;
import edu.wpi.first.wpilibj.Solenoid;

    // END AUTOGENERATED CODE, SOURCE=ROBOTBUILDER ID=IMPORTS
import edu.wpi.first.wpilibj.livewindow.LiveWindow;

/**
 * The RobotMap is a mapping from the ports sensors and actuators are wired into
 * to a variable name. This provides flexibility changing wiring, makes checking
 * the wiring easier and significantly reduces the number of magic numbers
 * floating around.
 */
public class RobotMap {
	// BEGIN AUTOGENERATED CODE, SOURCE=ROBOTBUILDER ID=DECLARATIONS
    public static CANTalon driveTrainLeftFrontMotor;
    public static CANTalon driveTrainLeftRearMotor;
    public static CANTalon driveTrainRightFrontMotor;
    public static CANTalon driveTrainRightRearMotor;
    public static Solenoid gearShiftshifter;
    public static Solenoid plungerbopper;
    public static CANTalon shooterMotorsleftShooterMotor;
    public static CANTalon shooterMotorsrightShooterMotor;
    public static CANTalon collectorfeedRoller;
    public static CANTalon collectorcenterRoller;
    public static DoubleSolenoid armsarmLift;
    public static Solenoid wristwristJoint;
    public static DoubleSolenoid shooterPivotshooterLift;
    public static DigitalInput ballSensorballSensorIO;
    public static Relay ballSensorballSensorSpike;
    public static Relay visionLightsvisionSpike;

    // END AUTOGENERATED CODE, SOURCE=ROBOTBUILDER ID=DECLARATIONS

	public static void init() {
		// BEGIN AUTOGENERATED CODE, SOURCE=ROBOTBUILDER ID=CONSTRUCTORS
        driveTrainLeftFrontMotor = new CANTalon(11);
        LiveWindow.addActuator("DriveTrain", "LeftFrontMotor", driveTrainLeftFrontMotor);
        
        driveTrainLeftRearMotor = new CANTalon(10);
        LiveWindow.addActuator("DriveTrain", "LeftRearMotor", driveTrainLeftRearMotor);
        
        driveTrainRightFrontMotor = new CANTalon(2);
        LiveWindow.addActuator("DriveTrain", "RightFrontMotor", driveTrainRightFrontMotor);
        
        driveTrainRightRearMotor = new CANTalon(3);
        LiveWindow.addActuator("DriveTrain", "RightRearMotor", driveTrainRightRearMotor);
        
        gearShiftshifter = new Solenoid(0, 6);
        LiveWindow.addActuator("GearShift", "shifter", gearShiftshifter);
        
        plungerbopper = new Solenoid(0, 4);
        LiveWindow.addActuator("Plunger", "bopper", plungerbopper);
        
        shooterMotorsleftShooterMotor = new CANTalon(9);
        LiveWindow.addActuator("ShooterMotors", "leftShooterMotor", shooterMotorsleftShooterMotor);
        
        shooterMotorsrightShooterMotor = new CANTalon(4);
        LiveWindow.addActuator("ShooterMotors", "rightShooterMotor", shooterMotorsrightShooterMotor);
        
        collectorfeedRoller = new CANTalon(8);
        LiveWindow.addActuator("Collector", "feedRoller", collectorfeedRoller);
        
        collectorcenterRoller = new CANTalon(5);
        LiveWindow.addActuator("Collector", "centerRoller", collectorcenterRoller);
        
        armsarmLift = new DoubleSolenoid(0, 2, 3);
        LiveWindow.addActuator("Arms", "armLift", armsarmLift);
        
        wristwristJoint = new Solenoid(0, 5);
        LiveWindow.addActuator("Wrist", "wristJoint", wristwristJoint);
        
        shooterPivotshooterLift = new DoubleSolenoid(0, 0, 1);
        LiveWindow.addActuator("ShooterPivot", "shooterLift", shooterPivotshooterLift);
        
        ballSensorballSensorIO = new DigitalInput(1);
        LiveWindow.addSensor("BallSensor", "ballSensorIO", ballSensorballSensorIO);
        
        ballSensorballSensorSpike = new Relay(0);
        LiveWindow.addActuator("BallSensor", "ballSensorSpike", ballSensorballSensorSpike);
        
        visionLightsvisionSpike = new Relay(2);
        LiveWindow.addActuator("VisionLights", "visionSpike", visionLightsvisionSpike);
        

    // END AUTOGENERATED CODE, SOURCE=ROBOTBUILDER ID=CONSTRUCTORS

		driveTrainLeftFrontMotor.set(0);
		driveTrainLeftRearMotor.set(0);

		driveTrainRightFrontMotor.set(0);
		driveTrainRightRearMotor.set(0);

		// setting all the other motors to follower mode to follow the front two
		// motors
		// Right
		driveTrainRightRearMotor
				.changeControlMode(CANTalon.TalonControlMode.Follower);
		driveTrainRightRearMotor.set(driveTrainRightFrontMotor.getDeviceID());

		// Left
		driveTrainLeftRearMotor
				.changeControlMode(CANTalon.TalonControlMode.Follower);
		driveTrainLeftRearMotor.set(driveTrainLeftFrontMotor.getDeviceID());

		// Invert motors
		// THESE ARE FOR Competition
		driveTrainRightFrontMotor.setInverted(true);
		driveTrainRightRearMotor.setInverted(true);

	}
}
