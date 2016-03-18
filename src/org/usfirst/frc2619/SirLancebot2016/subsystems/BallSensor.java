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

import org.usfirst.frc2619.SirLancebot2016.Robot;
import org.usfirst.frc2619.SirLancebot2016.RobotMap;
import org.usfirst.frc2619.SirLancebot2016.commands.*;

import edu.wpi.first.wpilibj.DigitalInput;
import edu.wpi.first.wpilibj.Relay;
import edu.wpi.first.wpilibj.Relay.Value;
import edu.wpi.first.wpilibj.command.Subsystem;


/**
 *
 */
public class BallSensor extends Subsystem {

    // BEGIN AUTOGENERATED CODE, SOURCE=ROBOTBUILDER ID=CONSTANTS

    // END AUTOGENERATED CODE, SOURCE=ROBOTBUILDER ID=CONSTANTS

    // BEGIN AUTOGENERATED CODE, SOURCE=ROBOTBUILDER ID=DECLARATIONS
    private final DigitalInput ballSensorIO = RobotMap.ballSensorballSensorIO;
    private final Relay ballSensorSpike = RobotMap.ballSensorballSensorSpike;

    // END AUTOGENERATED CODE, SOURCE=ROBOTBUILDER ID=DECLARATIONS
    public static boolean hasBallBool = false;
    public boolean flashon = false;


    // Put methods for controlling this subsystem
    // here. Call these from Commands.

    public void initDefaultCommand() {
        // BEGIN AUTOGENERATED CODE, SOURCE=ROBOTBUILDER ID=DEFAULT_COMMAND

        setDefaultCommand(new BallCheck());

    // END AUTOGENERATED CODE, SOURCE=ROBOTBUILDER ID=DEFAULT_COMMAND

        // Set the default command for a subsystem here.
        // setDefaultCommand(new MySpecialCommand());
    }
    
    public boolean hasBall()
    {
    	return ballSensorIO.get(); // If 5v, then true, else false.
    }
    
    public void setSpike(boolean hasball)
    {
    	if (hasball)
    	{
    		ballSensorSpike.set(Relay.Value.kForward);
    	}
    	else
    	{
    		ballSensorSpike.set(Relay.Value.kOff);
    		Robot.cameraSubsystem.targetinline = false;
    	}
    }
    
    public void flashLED()
    {
    	if(flashon) ballSensorSpike.set(Relay.Value.kForward);
    	else ballSensorSpike.set(Relay.Value.kOff);
    }
}

