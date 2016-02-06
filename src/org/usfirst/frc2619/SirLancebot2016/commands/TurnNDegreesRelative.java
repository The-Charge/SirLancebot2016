package org.usfirst.frc2619.SirLancebot2016.commands;

import org.usfirst.frc2619.SirLancebot2016.Robot;

import edu.wpi.first.wpilibj.command.Command;

/**
 *
 */
public class TurnNDegreesRelative extends TurnNDegreesAbsolute{

	private double goal;
    public TurnNDegreesRelative(double desired) {
        // Use requires() here to declare subsystem dependencies
        // eg. requires(chassis);
    	
    	super(0);
    	goal = desired;
    }

    // Called just before this Command runs the first time
    protected void initialize() {
    	double current = (double)(Robot.gyroSubsystem.ahrs.getAngle());
    	
    	m_degrees2 = current+goal;
    	super.initialize();
    }
}
