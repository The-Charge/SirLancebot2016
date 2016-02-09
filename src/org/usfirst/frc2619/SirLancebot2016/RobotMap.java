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
    public static CANTalon driveTrainLeftMidMotor;
    public static CANTalon driveTrainLeftRearMotor;
    public static CANTalon driveTrainRightFrontMotor;
    public static CANTalon driveTrainRightMidMotor;
    public static CANTalon driveTrainRightRearMotor;
    public static CANTalon outerIntakeOuterRollerMotor;
    public static CANTalon innerIntakeInnerRollerMotor;
    public static DoubleSolenoid intakeArmsLeftIntakeArm;
    public static DoubleSolenoid intakeArmsRightIntakeArm;
    public static CANTalon shooterShooterTop;
    public static CANTalon shooterShooterBottom;
    public static DoubleSolenoid gearShiftLeftShift;
    public static DoubleSolenoid gearShiftRightShift;
    public static DoubleSolenoid plungerBopper;

    // END AUTOGENERATED CODE, SOURCE=ROBOTBUILDER ID=DECLARATIONS

    public static void init() {
        // BEGIN AUTOGENERATED CODE, SOURCE=ROBOTBUILDER ID=CONSTRUCTORS
        driveTrainLeftFrontMotor = new CANTalon(19);
        LiveWindow.addActuator("DriveTrain", "LeftFrontMotor", driveTrainLeftFrontMotor);
        
        driveTrainLeftMidMotor = new CANTalon(15);
        LiveWindow.addActuator("DriveTrain", "LeftMidMotor", driveTrainLeftMidMotor);
        
        driveTrainLeftRearMotor = new CANTalon(14);
        LiveWindow.addActuator("DriveTrain", "LeftRearMotor", driveTrainLeftRearMotor);
        
        driveTrainRightFrontMotor = new CANTalon(13);
        LiveWindow.addActuator("DriveTrain", "RightFrontMotor", driveTrainRightFrontMotor);
        
        driveTrainRightMidMotor = new CANTalon(17);
        LiveWindow.addActuator("DriveTrain", "RightMidMotor", driveTrainRightMidMotor);
        
        driveTrainRightRearMotor = new CANTalon(12);
        LiveWindow.addActuator("DriveTrain", "RightRearMotor", driveTrainRightRearMotor);
        
        outerIntakeOuterRollerMotor = new CANTalon(8);
        LiveWindow.addActuator("OuterIntake", "OuterRollerMotor", outerIntakeOuterRollerMotor);
        
        innerIntakeInnerRollerMotor = new CANTalon(9);
        LiveWindow.addActuator("InnerIntake", "InnerRollerMotor", innerIntakeInnerRollerMotor);
        
        intakeArmsLeftIntakeArm = new DoubleSolenoid(0, 4, 5);
        LiveWindow.addActuator("IntakeArms", "LeftIntakeArm", intakeArmsLeftIntakeArm);
        
        intakeArmsRightIntakeArm = new DoubleSolenoid(0, 6, 7);
        LiveWindow.addActuator("IntakeArms", "RightIntakeArm", intakeArmsRightIntakeArm);
        
        shooterShooterTop = new CANTalon(6);
        LiveWindow.addActuator("Shooter", "ShooterTop", shooterShooterTop);
        
        shooterShooterBottom = new CANTalon(7);
        LiveWindow.addActuator("Shooter", "ShooterBottom", shooterShooterBottom);
        
        gearShiftLeftShift = new DoubleSolenoid(0, 0, 1);
        LiveWindow.addActuator("GearShift", "LeftShift", gearShiftLeftShift);
        
        gearShiftRightShift = new DoubleSolenoid(0, 2, 3);
        LiveWindow.addActuator("GearShift", "RightShift", gearShiftRightShift);
        
        plungerBopper = new DoubleSolenoid(1, 0, 1);
        LiveWindow.addActuator("Plunger", "Bopper", plungerBopper);
        

    // END AUTOGENERATED CODE, SOURCE=ROBOTBUILDER ID=CONSTRUCTORS
        
        driveTrainLeftFrontMotor.set(0);
        driveTrainLeftMidMotor.set(0);
        driveTrainLeftRearMotor.set(0);
        
        driveTrainRightFrontMotor.set(0);
        driveTrainRightMidMotor.set(0);
        driveTrainRightRearMotor.set(0);
        
        // setting all the other motors to follower mode to follow the front two motors
        // Right
        driveTrainRightRearMotor.changeControlMode(CANTalon.TalonControlMode.Follower);
        driveTrainRightRearMotor.set(driveTrainRightFrontMotor.getDeviceID());
        
        driveTrainRightMidMotor.changeControlMode(CANTalon.TalonControlMode.Follower);
        driveTrainRightMidMotor.set(driveTrainRightFrontMotor.getDeviceID());
        
        // Left
        driveTrainLeftRearMotor.changeControlMode(CANTalon.TalonControlMode.Follower);
        driveTrainLeftRearMotor.set(driveTrainLeftFrontMotor.getDeviceID());
        
        driveTrainLeftMidMotor.changeControlMode(CANTalon.TalonControlMode.Follower);
        driveTrainLeftMidMotor.set(driveTrainLeftFrontMotor.getDeviceID());
        
        //Invert motors
        //THESE ARE FOR PLYBOT
        driveTrainRightFrontMotor.setInverted(true);
        driveTrainRightMidMotor.setInverted(true);
        driveTrainRightRearMotor.setInverted(true);
    }
}
