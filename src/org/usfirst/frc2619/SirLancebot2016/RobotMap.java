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
import edu.wpi.first.wpilibj.DoubleSolenoid;

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
    public static DoubleSolenoid gearShiftshifter;
    public static DoubleSolenoid plungerbopper;
    public static CANTalon shooterleftShooterMotor;
    public static CANTalon shooterrightShooterMotor;
    public static DoubleSolenoid shootershooterLift;
    public static DoubleSolenoid collectorarmLift;
    public static CANTalon collectorfeedRoller;
    public static CANTalon collectorcenterRoller;

    // END AUTOGENERATED CODE, SOURCE=ROBOTBUILDER ID=DECLARATIONS

    public static void init() {
        // BEGIN AUTOGENERATED CODE, SOURCE=ROBOTBUILDER ID=CONSTRUCTORS
        driveTrainLeftFrontMotor = new CANTalon(19);
        LiveWindow.addActuator("DriveTrain", "leftFrontMotor", driveTrainLeftFrontMotor);
        
        driveTrainLeftRearMotor = new CANTalon(14);
        LiveWindow.addActuator("DriveTrain", "leftRearMotor", driveTrainLeftRearMotor);
        
        driveTrainRightFrontMotor = new CANTalon(13);
        LiveWindow.addActuator("DriveTrain", "rightFrontMotor", driveTrainRightFrontMotor);
        
        driveTrainRightRearMotor = new CANTalon(12);
        LiveWindow.addActuator("DriveTrain", "rightRearMotor", driveTrainRightRearMotor);
        
        gearShiftshifter = new DoubleSolenoid(0, 0, 1);
        LiveWindow.addActuator("GearShift", "shifter", gearShiftshifter);
        
        plungerbopper = new DoubleSolenoid(0, 2, 3);
        LiveWindow.addActuator("Plunger", "bopper", plungerbopper);
        
        shooterleftShooterMotor = new CANTalon(2);
        LiveWindow.addActuator("Shooter", "leftShooterMotor", shooterleftShooterMotor);
        
        shooterrightShooterMotor = new CANTalon(1);
        LiveWindow.addActuator("Shooter", "rightShooterMotor", shooterrightShooterMotor);
        
        shootershooterLift = new DoubleSolenoid(0, 4, 5);
        LiveWindow.addActuator("Shooter", "shooterLift", shootershooterLift);
        
        collectorarmLift = new DoubleSolenoid(0, 6, 7);
        LiveWindow.addActuator("Collector", "armLift", collectorarmLift);
        
        collectorfeedRoller = new CANTalon(3);
        LiveWindow.addActuator("Collector", "feedRoller", collectorfeedRoller);
        
        collectorcenterRoller = new CANTalon(4);
        LiveWindow.addActuator("Collector", "centerRoller", collectorcenterRoller);
        

    // END AUTOGENERATED CODE, SOURCE=ROBOTBUILDER ID=CONSTRUCTORS

        
        driveTrainLeftFrontMotor.set(0);
        driveTrainLeftRearMotor.set(0);
        
        driveTrainRightFrontMotor.set(0);
        driveTrainRightRearMotor.set(0);
        
        
        // setting all the other motors to follower mode to follow the front two motors
        // Right
        driveTrainRightRearMotor.changeControlMode(CANTalon.TalonControlMode.Follower);
        driveTrainRightRearMotor.set(driveTrainRightFrontMotor.getDeviceID());
        
        // Left
        driveTrainLeftRearMotor.changeControlMode(CANTalon.TalonControlMode.Follower);
        driveTrainLeftRearMotor.set(driveTrainLeftFrontMotor.getDeviceID());
        
        //Invert motors
        //THESE ARE FOR PLYBOT
        driveTrainRightFrontMotor.setInverted(true);
        driveTrainRightRearMotor.setInverted(true);

    }
}
