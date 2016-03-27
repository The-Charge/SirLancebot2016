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
    public JoystickButton prepShooterOn;
    public JoystickButton prepShooterOff;
    public JoystickButton fireButton;
    public JoystickButton intakeForward;
    public JoystickButton intakeStop1;
    public JoystickButton intakeReverse;
    public JoystickButton intakeStop2;
    public JoystickButton collectorOnButton;
    public JoystickButton collectorOffButton;
    public JoystickButton prepHighGoalButton;
    public JoystickButton highGoalResetButton;
    public JoystickButton prepLowGoalButton;
    public JoystickButton lowGoalResetButton;
    public JoystickButton wristUpButton;
    public JoystickButton armsUpButton;
    public JoystickButton shooterUpButton;
    public JoystickButton wristDownButton;
    public JoystickButton armsDownButton;
    public JoystickButton shooterDownButton;
    public Joystick buttonBox;

    // END AUTOGENERATED CODE, SOURCE=ROBOTBUILDER ID=DECLARATIONS
    public SendableChooser driveMode;
    public SendableChooser loopMode;
    public SendableChooser autonCommand; //this one is for testing the sendable chooser
    public SendableChooser autoposition;
    public SendableChooser autoDefenseAgainst;
    
    public OI() {
        // BEGIN AUTOGENERATED CODE, SOURCE=ROBOTBUILDER ID=CONSTRUCTORS

        buttonBox = new Joystick(2);
        
        shooterDownButton = new JoystickButton(buttonBox, 5);
        shooterDownButton.whenPressed(new LowerShooter());
        armsDownButton = new JoystickButton(buttonBox, 3);
        armsDownButton.whenPressed(new LowerArms());
        wristDownButton = new JoystickButton(buttonBox, 4);
        wristDownButton.whenPressed(new WristDown());
        shooterUpButton = new JoystickButton(buttonBox, 6);
        shooterUpButton.whenPressed(new LiftShooter());
        armsUpButton = new JoystickButton(buttonBox, 2);
        armsUpButton.whenPressed(new LiftArms());
        wristUpButton = new JoystickButton(buttonBox, 1);
        wristUpButton.whenPressed(new WristUp());
        lowGoalResetButton = new JoystickButton(buttonBox, 7);
        lowGoalResetButton.whenReleased(new DefaultPositionCG());
        prepLowGoalButton = new JoystickButton(buttonBox, 7);
        prepLowGoalButton.whenPressed(new PrepLowGoalCG());
        highGoalResetButton = new JoystickButton(buttonBox, 8);
        highGoalResetButton.whenReleased(new DefaultPositionCG());
        prepHighGoalButton = new JoystickButton(buttonBox, 8);
        prepHighGoalButton.whenPressed(new PrepHighGoalCG());
        collectorOffButton = new JoystickButton(buttonBox, 9);
        collectorOffButton.whenReleased(new CollectorOffCG());
        collectorOnButton = new JoystickButton(buttonBox, 9);
        collectorOnButton.whenPressed(new CollectorOnCG());
        intakeStop2 = new JoystickButton(buttonBox, 10);
        intakeStop2.whenReleased(new StopEatingBallCG());
        intakeReverse = new JoystickButton(buttonBox, 10);
        intakeReverse.whenPressed(new SpitCG());
        intakeStop1 = new JoystickButton(buttonBox, 11);
        intakeStop1.whenReleased(new StopEatingBallCG());
        intakeForward = new JoystickButton(buttonBox, 11);
        intakeForward.whenPressed(new EatBallCG());
        fireButton = new JoystickButton(buttonBox, 13);
        fireButton.whenPressed(new Fire());
        prepShooterOff = new JoystickButton(buttonBox, 12);
        prepShooterOff.whenReleased(new StopShooterCommand());
        prepShooterOn = new JoystickButton(buttonBox, 12);
        prepShooterOn.whenPressed(new PrepShooter());
        rightJoystick = new Joystick(1);
        
        autoAimHorizontalButtonRight = new JoystickButton(rightJoystick, 1);
        autoAimHorizontalButtonRight.whileHeld(new AutoAimHorizontal());
        shiftLowButtonRight = new JoystickButton(rightJoystick, 4);
        shiftLowButtonRight.whenPressed(new ShiftLow());
        leftJoystick = new Joystick(0);
        
        autoAimHorizontalButtonLeft = new JoystickButton(leftJoystick, 1);
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
        
        //Testing Auton Sendable Chooser
        autonCommand = new SendableChooser();
        autonCommand.addDefault("AutonomousCG()", new AutonomousCG());
        autonCommand.addObject("CrossPortculis()", new CrossPortcullisCG());
        autonCommand.addObject("CrossChevalDeFrise()", new CrossChevalDeFriseCG());
        
        SmartDashboard.putData("AutonCommand", autonCommand);
        
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

