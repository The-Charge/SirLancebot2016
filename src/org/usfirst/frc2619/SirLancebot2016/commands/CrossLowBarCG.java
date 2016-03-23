package org.usfirst.frc2619.SirLancebot2016.commands;

import org.usfirst.frc2619.Constants;

import edu.wpi.first.wpilibj.command.CommandGroup;

/**
 *
 */
public class CrossLowBarCG extends CommandGroup {
	double distanceFromStart = Constants.DISTANCE_TO_DEFENSE_IN_FEET;
    public  CrossLowBarCG() {
        // Add Commands here:
        // e.g. addSequential(new Command1());
        //      addSequential(new Command2());
        // these will run in order.

        // To run multiple commands at the same time,
        // use addParallel()
        // e.g. addParallel(new Command1());
        //      addSequential(new Command2());
        // Command1 and Command2 will run in parallel.

        // A command group will require all of the subsystems that each member
        // would require.
        // e.g. if Command1 requires chassis, and Command2 requires arm,
        // a CommandGroup containing them would require both the chassis and the
        // arm.
    	
    	addSequential(new LowerArms()); // TODO: Test to see if the arms keep lowering. Figure out how to stop this.
    	addSequential(new DriveXfeet(distanceFromStart));
    	addSequential(new DriveUntilFlat(.5)); // TODO: Test this code for make sure the robot clears the lowbar
    }
}
