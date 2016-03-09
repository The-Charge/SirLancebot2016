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

import org.usfirst.frc2619.SirLancebot2016.commands.*;

import edu.wpi.first.wpilibj.buttons.JoystickButton;
import edu.wpi.first.wpilibj.smartdashboard.SendableChooser;
import edu.wpi.first.wpilibj.smartdashboard.SmartDashboard;
import edu.wpi.first.wpilibj.CANTalon;
import edu.wpi.first.wpilibj.Joystick;

import org.usfirst.frc2619.SirLancebot2016.subsystems.*;


/**
 * This class is the glue that binds the controls on the physical operator
 * interface to the commands and command groups that allow control of the robot.
 */
public class OI {
    //// CREATING BUTTONS
    // One type of button is a joystick button which is any button on a joystick.
    // You create one by telling it which joystick it's on and which button
    // number it is.
    // Joystick stick = new Joystick(port);
    // Button button = new JoystickButton(stick, buttonNumber);

    // There are a few additional built in buttons you can use. Additionally,
    // by subclassing Button you can create custom triggers and bind those to
    // commands the same as any other Button.

    //// TRIGGERING COMMANDS WITH BUTTONS
    // Once you have a button, it's trivial to bind it to a button in one of
    // three ways:

    // Start the command when the button is pressed and let it run the command
    // until it is finished as determined by it's isFinished method.
    // button.whenPressed(new ExampleCommand());

    // Run the command while the button is being held down and interrupt it once
    // the button is released.
    // button.whileHeld(new ExampleCommand());

    // Start the command when the button is released  and let it run the command
    // until it is finished as determined by it's isFinished method.
    // button.whenReleased(new ExampleCommand());


    // BEGIN AUTOGENERATED CODE, SOURCE=ROBOTBUILDER ID=DECLARATIONS
    public JoystickButton shiftHighButtonLeft;
    public JoystickButton autoAimHorizontalButtonLeft;
    public Joystick leftJoystick;
    public JoystickButton shiftLowButtonRight;
    public JoystickButton autoAimHorizontalButtonRight;
    public Joystick rightJoystick;
    public JoystickButton prepShooterSwitch;
    public JoystickButton fireButton;
    public JoystickButton autoAimHorizontalButton;
    public JoystickButton armsDownSwitch;
    public JoystickButton eatBall;
    public JoystickButton wristDownButton;
    public JoystickButton spitBall;
    public JoystickButton liftShooterButton;
    public JoystickButton wristUpButton;
    public JoystickButton wristTestButton;
    public Joystick buttonBox;

    // END AUTOGENERATED CODE, SOURCE=ROBOTBUILDER ID=DECLARATIONS
    public SendableChooser driveMode;
    public SendableChooser loopMode;
    public SendableChooser autoposition;
    public SendableChooser autoDefenseAgainst;
    
    public OI() {
        // BEGIN AUTOGENERATED CODE, SOURCE=ROBOTBUILDER ID=CONSTRUCTORS

        buttonBox = new Joystick(2);
        
        wristTestButton = new JoystickButton(buttonBox, 6);
        wristTestButton.whenPressed(new WristDown());
        wristUpButton = new JoystickButton(buttonBox, 14);
        wristUpButton.whenReleased(new WristUp());
        liftShooterButton = new JoystickButton(buttonBox, 15);
        liftShooterButton.whileHeld(new LiftShooter());
        spitBall = new JoystickButton(buttonBox, 7);
        spitBall.whileHeld(new ShooterMotorsSpit());
        wristDownButton = new JoystickButton(buttonBox, 14);
        wristDownButton.whenPressed(new WristDown());
        eatBall = new JoystickButton(buttonBox, 9);
        eatBall.whileHeld(new EatBallCG());
        armsDownSwitch = new JoystickButton(buttonBox, 13);
        armsDownSwitch.whileHeld(new LowerArms());
        autoAimHorizontalButton = new JoystickButton(buttonBox, 4);
        autoAimHorizontalButton.whileHeld(new AutoAimHorizontal());
        fireButton = new JoystickButton(buttonBox, 8);
        fireButton.whenPressed(new Fire());
        prepShooterSwitch = new JoystickButton(buttonBox, 12);
        prepShooterSwitch.whileHeld(new PrepShooter());
        rightJoystick = new Joystick(1);
        
        autoAimHorizontalButtonRight = new JoystickButton(rightJoystick, 10);
        autoAimHorizontalButtonRight.whileHeld(new AutoAimHorizontal());
        shiftLowButtonRight = new JoystickButton(rightJoystick, 4);
        shiftLowButtonRight.whenPressed(new ShiftLow());
        leftJoystick = new Joystick(0);
        
        autoAimHorizontalButtonLeft = new JoystickButton(leftJoystick, 10);
        autoAimHorizontalButtonLeft.whileHeld(new AutoAimHorizontal());
        shiftHighButtonLeft = new JoystickButton(leftJoystick, 4);
        shiftHighButtonLeft.whenPressed(new ShiftHigh());


        // SmartDashboard Buttons
        SmartDashboard.putData("CameraDebug", new CameraDebug());

    // END AUTOGENERATED CODE, SOURCE=ROBOTBUILDER ID=CONSTRUCTORS
        driveMode = new SendableChooser();
        driveMode.addDefault("TankDrive", "tank");
        driveMode.addObject("ArcadeDrive", "arcade");
        driveMode.addObject("ClaytonDrive", "clayton");
        
        SmartDashboard.putData("Drive Mode", driveMode);
        
        //open/closed loop sendable chooser
        loopMode = new SendableChooser();
        loopMode.addDefault("OpenLoop", CANTalon.TalonControlMode.PercentVbus.getValue());
        loopMode.addObject("ClosedLoop", CANTalon.TalonControlMode.Speed.getValue());
    
        SmartDashboard.putData("Loop Mode", loopMode);
        
        // Positions for the Autonomous Sendable Chooser:
        /*
        autoposition = new SendableChooser();
        autoposition.addDefault("Arrive At Defense", new DriveXfeet(4.2)); //This is for the 2 point value
        autoposition.addObject("Position 1", new TurnNDegreesAbsolute(50));
        autoposition.addObject("Position 2", new TurnNDegreesAbsolute(35));
        autoposition.addObject("Position 3", new TurnNDegreesAbsolute(19));
        autoposition.addObject("Position 4", new TurnNDegreesAbsolute(354));
        autoposition.addObject("Position 5", new TurnNDegreesAbsolute(331));
        autoposition.addObject("Spy Bot", new SpyBotPositionCG());
        
        SmartDashboard.putData("AutonPosition", autoposition);
        
        // Sendable chooser for the auton position angels
        autoDefenseAgainst = new SendableChooser();
        autoDefenseAgainst.addDefault("LowBar", new CrossLowBarCG());
        autoDefenseAgainst.addObject("Rough Terrain", new CrossRoughTerrainCG());
        autoDefenseAgainst.addObject("Rock Wall", new CrossRockWallCG());
        //autoDefenseAgainst.addObject("Sally Port", new CrossSallyPortCG());
        //autoDefenseAgainst.addObject("Drawbridge", new CrossDrawbridgeCG());
        autoDefenseAgainst.addObject("Ramparts", new CrossRampartsCG());
        autoDefenseAgainst.addObject("Moat", new CrossMoatCG());
        autoDefenseAgainst.addObject("Cheval de Frise",new CrossChevalDeFriseCG());
        autoDefenseAgainst.addObject("Portcullis", new CrossPortcullisCG());
        
        SmartDashboard.putData("AutonAngle", autoDefenseAgainst);
        */
        
        SmartDashboard.putData("DRIVE_10_FEET", new DriveXfeet(10));
        
    }

    // BEGIN AUTOGENERATED CODE, SOURCE=ROBOTBUILDER ID=FUNCTIONS
    public Joystick getLeftJoystick() {
        return leftJoystick;
    }

    public Joystick getRightJoystick() {
        return rightJoystick;
    }

    public Joystick getButtonBox() {
        return buttonBox;
    }


    // END AUTOGENERATED CODE, SOURCE=ROBOTBUILDER ID=FUNCTIONS
}

