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

import edu.wpi.first.wpilibj.DigitalInput;
import edu.wpi.first.wpilibj.Relay;
import edu.wpi.first.wpilibj.Timer;
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
	public boolean hasBallBool = false;
	public boolean light = true;
	private int state = 1;
	
	public Timer blinktimer;

	// Put methods for controlling this subsystem
	// here. Call these from Commands.

	public void initDefaultCommand() {
		// BEGIN AUTOGENERATED CODE, SOURCE=ROBOTBUILDER ID=DEFAULT_COMMAND

        setDefaultCommand(new BallCheck());

    // END AUTOGENERATED CODE, SOURCE=ROBOTBUILDER ID=DEFAULT_COMMAND

		// Set the default command for a subsystem here.
		// setDefaultCommand(new MySpecialCommand());
	}

	public boolean hasBall() {
		return ballSensorIO.get(); // If 5v, then true, else false.
	}

	public void setSpike(boolean hasball) {
		if (hasball) {
			ballSensorSpike.set(Relay.Value.kForward);
			light = true;
		} else {
			ballSensorSpike.set(Relay.Value.kOff);
			light = false;
		}
		TheChargeDashboard.putBoolean("LightSpike", light);
	}
	public void blink()
	{
		if(light)
		{
			ballSensorSpike.set(Relay.Value.kOff);
			light = false;
		}
		else
		{
			ballSensorSpike.set(Relay.Value.kForward);
			light = true;
		}
		
		blinktimer.reset();
	}
	
	public int LEDState()
	{
		// state 1 = off, state 2 = on, state 3 = blinky
		TheChargeDashboard.putNumber("LEDState", state);
		if(state == 1)
		{
			if(!Robot.shooterPivot.shooterUp && hasBall())
			{
				state = 2;
				hasBallBool = true;
			}
		}
		
		if(state == 2)
		{
			if(!hasBallBool || (!Robot.shooterPivot.shooterUp && !hasBall()))
			{
				state = 1;
				hasBallBool = false;
			}
			else if(Robot.oi.autoAimHorizontalButtonRight.get() && Robot.cameraSubsystem.isVisionRunning()
					&& Robot.cameraSubsystem.onTarget() && hasBallBool)
			{
				state = 3;
			}
		}
		
		if(state == 3)
		{
			if(!Robot.cameraSubsystem.onTarget() || !Robot.cameraSubsystem.isVisionRunning())
			{
				state = 2;
			}
			else if(!hasBallBool || (!Robot.shooterPivot.shooterUp && !hasBall()))
			{
				state = 1;
			}
		}
		return state;
	}
}
