// RobotBuilder Version: 2.0
//
// This file was generated by RobotBuilder. It contains sections of
// code that are automatically generated and assigned by robotbuilder.
// These sections will be updated in the future when you export to
// Java from RobotBuilder. Do not put any code or make any change in
// the blocks indicating autogenerated code or it will be lost on an
// update. Deleting the comments indicating the section will prevent
// it from being updated in the future.

package org.usfirst.frc2619.SirLancebot2016.commands;

import edu.wpi.first.wpilibj.command.CommandGroup;

/**
 *
 */
public class CrossChevalDeFriseCG extends CommandGroup {

	double distanceFromStart = 4.5;  // front bumper needs to start 4ft 10 in from edge of ramps
	double getClose = .4;
	double reverseSoRampsDown = -.2;
	double driveOver = 4;

	// BEGIN AUTOGENERATED CODE, SOURCE=ROBOTBUILDER ID=PARAMETERS
	public CrossChevalDeFriseCG() {

		// END AUTOGENERATED CODE, SOURCE=ROBOTBUILDER ID=PARAMETERS
		// Add Commands here:
		// e.g. addSequential(new Command1());
		// addSequential(new Command2());
		// these will run in order.

		// To run multiple commands at the same time,
		// use addParallel()
		// e.g. addParallel(new Command1());
		// addSequential(new Command2());
		// Command1 and Command2 will run in parallel.

		// A command group will require all of the subsystems that each member
		// would require.
		// e.g. if Command1 requires chassis, and Command2 requires arm,
		// a CommandGroup containing them would require both the chassis and the
		// arm.
		// BEGIN AUTOGENERATED CODE, SOURCE=ROBOTBUILDER ID=COMMAND_DECLARATIONS

		// END AUTOGENERATED CODE, SOURCE=ROBOTBUILDER ID=COMMAND_DECLARATIONS

		// make sure arms are in correct position
		addParallel(new LiftArms());
		addParallel(new LiftShooter());
		addSequential(new WristDown());
		// get close to defense
		addSequential(new DriveXfeet(distanceFromStart));
		// make sure arms are over defense
		addSequential(new DriveXfeet(getClose));
		// lower arms, then lower wrists and drive back a little
		addParallel(new LowerArms());
		addSequential(new DriveXfeet(reverseSoRampsDown));
		// drive over defense
		addParallel(new DriveXfeet(driveOver));
	}
}
