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
    public JoystickButton shiftHighButton;
    public JoystickButton lowerIntakeArmsButton;
    public JoystickButton innerIntakeForwardButton;
    public JoystickButton outerIntakeForwardButton;
    public JoystickButton shootButtonLeft;
    public Joystick leftJoystick;
    public JoystickButton shiftLowButton;
    public JoystickButton liftIntakeArmsButton;
    public JoystickButton innerIntakeReverseButton;
    public JoystickButton outerIntakeReverseButton;
    public JoystickButton shootButtonRight;
    public Joystick rightJoystick;
    public JoystickButton fire;
    public JoystickButton prepareToShoot;
    public JoystickButton innerIntakeForwardSwitch;
    public JoystickButton outerIntakeForwardSwitch;
    public JoystickButton innerIntakeReverseSwitch;
    public JoystickButton outerIntakeReverseSwitch;
    public Joystick horse;

    // END AUTOGENERATED CODE, SOURCE=ROBOTBUILDER ID=DECLARATIONS
    public SendableChooser driveMode;
    public SendableChooser loopMode;
    
    public OI() {
        // BEGIN AUTOGENERATED CODE, SOURCE=ROBOTBUILDER ID=CONSTRUCTORS

        horse = new Joystick(2);
        
        outerIntakeReverseSwitch = new JoystickButton(horse, 6);
        outerIntakeReverseSwitch.whileHeld(new OuterIntakeReverse());
        innerIntakeReverseSwitch = new JoystickButton(horse, 5);
        innerIntakeReverseSwitch.whileHeld(new InnerIntakeReverse());
        outerIntakeForwardSwitch = new JoystickButton(horse, 4);
        outerIntakeForwardSwitch.whileHeld(new OuterIntakeForward());
        innerIntakeForwardSwitch = new JoystickButton(horse, 3);
        innerIntakeForwardSwitch.whileHeld(new InnerIntakeForward());
        prepareToShoot = new JoystickButton(horse, 2);
        prepareToShoot.whileHeld(new Shoot(0));
        fire = new JoystickButton(horse, 1);
        fire.whenPressed(new Bop());
        rightJoystick = new Joystick(1);
        
        shootButtonRight = new JoystickButton(rightJoystick, 1);
        shootButtonRight.whileHeld(new Shoot(0));
        outerIntakeReverseButton = new JoystickButton(rightJoystick, 6);
        outerIntakeReverseButton.whileHeld(new OuterIntakeReverse());
        innerIntakeReverseButton = new JoystickButton(rightJoystick, 5);
        innerIntakeReverseButton.whileHeld(new InnerIntakeReverse());
        liftIntakeArmsButton = new JoystickButton(rightJoystick, 3);
        liftIntakeArmsButton.whenPressed(new LiftIntakeArms());
        shiftLowButton = new JoystickButton(rightJoystick, 4);
        shiftLowButton.whenPressed(new ShiftLow());
        leftJoystick = new Joystick(0);
        
        shootButtonLeft = new JoystickButton(leftJoystick, 1);
        shootButtonLeft.whileHeld(new Shoot(0));
        outerIntakeForwardButton = new JoystickButton(leftJoystick, 6);
        outerIntakeForwardButton.whileHeld(new OuterIntakeForward());
        innerIntakeForwardButton = new JoystickButton(leftJoystick, 5);
        innerIntakeForwardButton.whileHeld(new InnerIntakeForward());
        lowerIntakeArmsButton = new JoystickButton(leftJoystick, 3);
        lowerIntakeArmsButton.whenPressed(new LowerIntakeArms());
        shiftHighButton = new JoystickButton(leftJoystick, 4);
        shiftHighButton.whenPressed(new ShiftHigh());


        // SmartDashboard Buttons
        SmartDashboard.putData("ShiftHigh", new ShiftHigh());
        SmartDashboard.putData("ShiftLow", new ShiftLow());
        SmartDashboard.putData("LiftIntakeArms", new LiftIntakeArms());
        SmartDashboard.putData("LowerIntakeArms", new LowerIntakeArms());
        SmartDashboard.putData("InnerIntakeForward", new InnerIntakeForward());
        SmartDashboard.putData("InnerIntakeReverse", new InnerIntakeReverse());
        SmartDashboard.putData("OuterIntakeForward", new OuterIntakeForward());
        SmartDashboard.putData("OuterIntakeReverse", new OuterIntakeReverse());
        SmartDashboard.putData("Shoot", new Shoot());
        SmartDashboard.putData("AutonomousCG", new AutonomousCG());
        SmartDashboard.putData("GyroDebug", new GyroDebug());
        SmartDashboard.putData("CameraDebug", new CameraDebug());
        SmartDashboard.putData("AutoAimHorizontal", new AutoAimHorizontal());

    // END AUTOGENERATED CODE, SOURCE=ROBOTBUILDER ID=CONSTRUCTORS
        driveMode = new SendableChooser();
        driveMode.addDefault("TankDrive", "tank");
        driveMode.addObject("ArcadeDrive", "arcade");
        driveMode.addObject("XBoxDrive", "xbox");
        driveMode.addObject("ClaytonDrive", "clayton");
        driveMode.addObject("HaloDirve", "halo");
        
        SmartDashboard.putData("Drive Mode", driveMode);
        
        //open/closed loop sendable chooser
        loopMode = new SendableChooser();
        loopMode.addDefault("ClosedLoop", CANTalon.TalonControlMode.Speed.getValue());
        loopMode.addObject("OpenLoop", CANTalon.TalonControlMode.PercentVbus.getValue());
    
        SmartDashboard.putData("Loop Mode", loopMode);
    }

    // BEGIN AUTOGENERATED CODE, SOURCE=ROBOTBUILDER ID=FUNCTIONS
    public Joystick getLeftJoystick() {
        return leftJoystick;
    }

    public Joystick getRightJoystick() {
        return rightJoystick;
    }

    public Joystick getHorse() {
        return horse;
    }


    // END AUTOGENERATED CODE, SOURCE=ROBOTBUILDER ID=FUNCTIONS
}

