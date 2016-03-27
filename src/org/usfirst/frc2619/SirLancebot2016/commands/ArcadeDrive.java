package org.usfirst.frc2619.SirLancebot2016.commands;

import org.usfirst.frc2619.MathUtil;
import org.usfirst.frc2619.SirLancebot2016.Robot;

/**
 *
 */
public class ArcadeDrive extends DriveBase {

	public ArcadeDrive() {
		super();
		// Use requires() here to declare subsystem dependencies
		// eg. requires(chassis);
	}

	protected boolean isFinished() {
		boolean enabled = Robot.oi.driveMode.getSelected().equals("arcade");

		return !enabled || super.isFinished();
	}

	protected double getLeft() {
		double leftjoyval = MathUtil.delinearize(Robot.oi.leftJoystick.getY(),
				power);
		double rightjoyval = MathUtil.delinearize(
				Robot.oi.rightJoystick.getX(), power);
		double leftspeed = MathUtil.deadbandCheck(leftjoyval * -1,
				super.deadbandY)
				- MathUtil.deadbandCheck(-1 * rightjoyval, super.deadbandX);
		return leftspeed;
	}

	protected double getRight() {
		double leftjoyval = MathUtil.delinearize(Robot.oi.leftJoystick.getX(),
				power);
		double rightjoyval = MathUtil.delinearize(
				Robot.oi.rightJoystick.getY(), power);
		double rightspeed = MathUtil.deadbandCheck(rightjoyval * -1,
				super.deadbandY)
				+ MathUtil.deadbandCheck(-1 * leftjoyval, super.deadbandX);
		return rightspeed;
	}
}
