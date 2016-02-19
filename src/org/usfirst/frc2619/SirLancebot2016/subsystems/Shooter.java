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

import org.usfirst.frc2619.SirLancebot2016.RobotMap;
import org.usfirst.frc2619.SirLancebot2016.commands.*;

import edu.wpi.first.wpilibj.CANTalon;
import edu.wpi.first.wpilibj.DoubleSolenoid;
import edu.wpi.first.wpilibj.command.Subsystem;
import edu.wpi.first.wpilibj.smartdashboard.SmartDashboard;


/**
 *
 */
public class Shooter extends Subsystem {

	private final static double SPEED_P_CONSTANT = .75;
    private final static double SPEED_I_CONSTANT = .01;
    private final static double SPEED_D_CONSTANT = 0;
    // BEGIN AUTOGENERATED CODE, SOURCE=ROBOTBUILDER ID=CONSTANTS

    // END AUTOGENERATED CODE, SOURCE=ROBOTBUILDER ID=CONSTANTS

    // BEGIN AUTOGENERATED CODE, SOURCE=ROBOTBUILDER ID=DECLARATIONS
    private final CANTalon shooterTop = RobotMap.shooterShooterTop;
    private final CANTalon shooterBottom = RobotMap.shooterShooterBottom;
    private final DoubleSolenoid shooterPosition = RobotMap.shooterShooterPosition;
    private final CANTalon leftCollector = RobotMap.shooterLeftCollector;
    private final CANTalon rightCollector = RobotMap.shooterRightCollector;

    // END AUTOGENERATED CODE, SOURCE=ROBOTBUILDER ID=DECLARATIONS


    // Put methods for controlling this subsystem
    // here. Call these from Commands.
    public Shooter()
    {
    	writeDefaultDashboardValues();
    	initSpeedMode();
    }

    public void initDefaultCommand() {
        // BEGIN AUTOGENERATED CODE, SOURCE=ROBOTBUILDER ID=DEFAULT_COMMAND


    // END AUTOGENERATED CODE, SOURCE=ROBOTBUILDER ID=DEFAULT_COMMAND

        // Set the default command for a subsystem here.
        // setDefaultCommand(new MySpecialCommand());
    }
    
    private void writeDefaultDashboardValues() {
    	SmartDashboard.putNumber("ShooterSpeedP", SPEED_P_CONSTANT);
    	SmartDashboard.putNumber("ShooterSpeedI", SPEED_I_CONSTANT);
    	SmartDashboard.putNumber("ShooterSpeedD", SPEED_D_CONSTANT);
	}
    
    public void readDashboardControlValues()
    {
    	double SpeedP = SmartDashboard.getNumber("ShooterSpeedP");
    	double SpeedI = SmartDashboard.getNumber("ShooterSpeedI");
    	double SpeedD = SmartDashboard.getNumber("ShooterSpeedD");
    	
    	//set CANTalon PIDs
    	shooterTop.setPID(SpeedP, SpeedI,SpeedD);
    	shooterBottom.setPID(SpeedP,SpeedI,SpeedD);	
    }
    
    public void writeDashboardDebugValues()
	{
		//Output Speed of Encoders
		SmartDashboard.putNumber("ShooterTopSpeed",shooterTop.getEncVelocity());
		SmartDashboard.putNumber("ShooterBottomSpeed",shooterBottom.getEncVelocity());
	}
    
    private void initSpeedMode()
    {
    	shooterTop.setControlMode(CANTalon.TalonControlMode.Speed.getValue());
    	shooterBottom.setControlMode(CANTalon.TalonControlMode.Speed.getValue());
    }
    
    public void shoot(double speed)
    {
    	shooterTop.set(speed);
    	shooterBottom.set(speed);
    }
    
    public void intake(double speed)
    {
    	shooterTop.set(-speed);
    	shooterBottom.set(-speed);
    	leftCollector.set(speed);
    	rightCollector.set(speed);
    }
    
    public void upPosition()
    {
    	shooterPosition.set(DoubleSolenoid.Value.kForward);
    }
    
    public void downPosition()
    {
    	shooterPosition.set(DoubleSolenoid.Value.kReverse);
    }
    
    public void off()
    {
    	shooterTop.set(0);
    	shooterBottom.set(0);
    }
}

