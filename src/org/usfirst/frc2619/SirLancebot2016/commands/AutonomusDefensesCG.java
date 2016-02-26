package org.usfirst.frc2619.SirLancebot2016.commands;

import edu.wpi.first.wpilibj.command.Command;
import edu.wpi.first.wpilibj.command.CommandGroup;

/**
 *
 */
public class AutonomusDefensesCG extends CommandGroup {
    
    public  AutonomusDefensesCG(Command defensecommand, Command anglecommand) { 
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
    	
    	addSequential(defensecommand);
    	addSequential(anglecommand);
    	addSequential(new AutoAimHorizontal());
    	addParallel(new LowerArms());
    	addParallel(new LiftShooter());
    	addParallel(new PrepShooter());
    	addParallel(new WaitNseconds(.5));
    	addSequential(new Fire());
    	addParallel(new WaitNseconds(.5));
    	addSequential(new StopShooterCommand());
    }
}
