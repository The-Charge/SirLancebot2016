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

import org.usfirst.frc2619.Constants;
import org.usfirst.frc2619.MathUtil;
import org.usfirst.frc2619.TheChargeDashboard;
import org.usfirst.frc2619.SirLancebot2016.Robot;
import org.usfirst.frc2619.SirLancebot2016.RobotMap;
import org.usfirst.frc2619.SirLancebot2016.commands.*;
import edu.wpi.first.wpilibj.CANTalon;

import edu.wpi.first.wpilibj.command.Subsystem;
import edu.wpi.first.wpilibj.smartdashboard.SmartDashboard;


/**
 *
 */
public class ShooterMotors extends Subsystem {
	private final static double SPEED_P_CONSTANT = .05;
    private final static double SPEED_I_CONSTANT = 0 ;
    private final static double SPEED_D_CONSTANT = 0;
    private final static double SPEED_F_CONSTANT = .033;
    
    private final static int MAX_TICKS_PER_SECOND = 34000;
    
    private final static double DEFAULT_INTAKE_PERCENTSPEED = .25;
    private final static double DEFAULT_SPIT_PERCENTSPEED = -.3;
    
    public double shooterSpeedSetPoint = 0;
    public double leftShooterSpeed = shooterSpeedSetPoint;
    public double rightShooterSpeed = shooterSpeedSetPoint;
    
    public double shooterIntakeSpeed = DEFAULT_INTAKE_PERCENTSPEED;
    public double shooterSpitPercentSpeed = DEFAULT_SPIT_PERCENTSPEED;
    
    public boolean shooterMotorsOn = false;
    public boolean shooterMotorsForward = true;
    
    double SpeedP = SPEED_P_CONSTANT;
    double SpeedI = SPEED_I_CONSTANT;
    double SpeedD = SPEED_D_CONSTANT;
    double SpeedF = SPEED_F_CONSTANT;
    // BEGIN AUTOGENERATED CODE, SOURCE=ROBOTBUILDER ID=CONSTANTS

    // END AUTOGENERATED CODE, SOURCE=ROBOTBUILDER ID=CONSTANTS

    // BEGIN AUTOGENERATED CODE, SOURCE=ROBOTBUILDER ID=DECLARATIONS
    private final CANTalon leftShooterMotor = RobotMap.shooterMotorsleftShooterMotor;
    private final CANTalon rightShooterMotor = RobotMap.shooterMotorsrightShooterMotor;

    // END AUTOGENERATED CODE, SOURCE=ROBOTBUILDER ID=DECLARATIONS


    // Put methods for controlling this subsystem
    // here. Call these from Commands.
    public ShooterMotors()
    {
    	writeDefaultDashboardValues();
    	initSpeedMode();
    }
    public void initDefaultCommand() {
        // BEGIN AUTOGENERATED CODE, SOURCE=ROBOTBUILDER ID=DEFAULT_COMMAND

        setDefaultCommand(new ShooterControl());

    // END AUTOGENERATED CODE, SOURCE=ROBOTBUILDER ID=DEFAULT_COMMAND

        // Set the default command for a subsystem here.
        // setDefaultCommand(new MySpecialCommand());
    }
    
    private void writeDefaultDashboardValues() {
    	TheChargeDashboard.putNumber("ShooterSpeedP", SPEED_P_CONSTANT);
    	TheChargeDashboard.putNumber("ShooterSpeedI", SPEED_I_CONSTANT);
    	TheChargeDashboard.putNumber("ShooterSpeedD", SPEED_D_CONSTANT);
    	TheChargeDashboard.putNumber("ShooterSpeedF", SPEED_F_CONSTANT);
    	
    	//Speed for the intake system
    	TheChargeDashboard.putNumber("IntakePercentSpeed", DEFAULT_INTAKE_PERCENTSPEED);
    }
    
    public void readDashboardControlValues()
    {
    	SpeedP = SmartDashboard.getNumber("ShooterSpeedP", SPEED_P_CONSTANT);
    	SpeedI = SmartDashboard.getNumber("ShooterSpeedI", SPEED_I_CONSTANT);
    	SpeedD = SmartDashboard.getNumber("ShooterSpeedD", SPEED_D_CONSTANT);
    	SpeedF = SmartDashboard.getNumber("ShooterSpeedF", SPEED_F_CONSTANT);
    	
    	shooterIntakeSpeed = SmartDashboard.getNumber("IntakePercentSpeed");
    	
    	//set CANTalon PIDs
    	leftShooterMotor.setPID(SpeedP, SpeedI,SpeedD, SpeedF, 0, 0, 0);
    	rightShooterMotor.setPID(SpeedP, SpeedI, SpeedD, SpeedF, 0, 0, 0);	
    }
    
    public void writeDashboardDebugValues()
	{
		//Output Speed of Encoders
		TheChargeDashboard.putNumber("ShooterLeftSpeed",leftShooterMotor.getEncVelocity());
		TheChargeDashboard.putNumber("ShooterRightSpeed",rightShooterMotor.getEncVelocity());
		TheChargeDashboard.putBoolean("ShooterMotorsOn",shooterMotorsOn);
		TheChargeDashboard.putBoolean("ShooterMotorsForward", shooterMotorsForward);
		SmartDashboard.putNumber("IntakePercentSpeed", shooterIntakeSpeed);
	}
    
    public void initSpeedMode()
    {
    	leftShooterMotor.setControlMode(CANTalon.TalonControlMode.Speed.getValue());
    	rightShooterMotor.setControlMode(CANTalon.TalonControlMode.Speed.getValue());
    }
    /**
     * 
     * @param speed double percent of speed to run at a velocity (Percentage of Speed used)
     */
    public double convertDistanceToSpeed(double distance)
    {
    	if(distance <= 5.5 ) return 2600 / MAX_TICKS_PER_SECOND;
    	else if(distance <= 7.5) return 2900 / MAX_TICKS_PER_SECOND;
    	//TODO: more data needed to finish convertDistanceToSpeed
    	else return 0;
    }
    
    /**
     * 
     * @param speed double percent of speed to run at a velocity (Percentage of Speed used)
     */
    public void calcSpeed()
    {
    	if(shooterMotorsForward && Robot.shooterPivot.shooterUp) //if shooting high
    	{
    		if(Robot.cameraSubsystem.isVisionRunning() && Robot.cameraSubsystem.isTargetVisible() && Robot.oi.getButtonBox().getRawButton(15)) //TODO: check button number
    			shooterSpeedSetPoint = (int)(convertDistanceToSpeed(Robot.cameraSubsystem.getDistance()) * MAX_TICKS_PER_SECOND);
        	else shooterSpeedSetPoint = (int)(MathUtil.shooterSpeedFormat(Robot.oi.buttonBox.getZ()) * MAX_TICKS_PER_SECOND);
    	}
    	else if(shooterMotorsForward && !Robot.shooterPivot.shooterUp) //if shooting low
    		shooterSpeedSetPoint = (int)(.4 * MAX_TICKS_PER_SECOND);
    	else 
    		shooterSpeedSetPoint = (int)(-.3 * MAX_TICKS_PER_SECOND);
    	
    	
    	TheChargeDashboard.putNumber("Shooter SetPoint", shooterSpeedSetPoint);
    	leftShooterMotor.set(shooterSpeedSetPoint);
    	rightShooterMotor.set(-shooterSpeedSetPoint);
    }
    
    public void run()
    {
    	if(shooterMotorsOn)calcSpeed();
    	else stop();
    }
    
    public void stop()
    {
    	leftShooterMotor.set(0);
    	rightShooterMotor.set(0);
    	TheChargeDashboard.putNumber("Shooter SetPoint", 0);
    }
}

