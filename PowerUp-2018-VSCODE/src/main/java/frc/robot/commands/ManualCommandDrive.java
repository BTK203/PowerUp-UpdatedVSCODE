package frc.robot.commands;

import edu.wpi.first.wpilibj.command.Command;
import edu.wpi.first.wpilibj.smartdashboard.SmartDashboard;
import frc.robot.OI;
import frc.robot.Robot;
import frc.robot.util.Util;

/** manually command the robot with joysticks */
public class ManualCommandDrive extends Command {
	
    public ManualCommandDrive() {
        requires(Robot.SUB_DRIVE);
        requires(Robot.SUB_MANIPULATOR);
    }

    protected void initialize() {}

    protected void execute() {
        SmartDashboard.putNumber("Tilt Angle", Robot.SUB_DRIVE.getYAngle());
        SmartDashboard.putBoolean("Docked", Robot.SUB_DRIVE.docking);
        SmartDashboard.putBoolean("Reversed", Robot.SUB_DRIVE.reversing);
        SmartDashboard.putNumber("Right Encoder Position", Robot.SUB_DRIVE.rightMag2in(Robot.SUB_DRIVE.getRightPos()));
        SmartDashboard.putNumber("Left Encoder Position", Robot.SUB_DRIVE.leftMag2in(Robot.SUB_DRIVE.getLeftPos()));

    	switch (Robot.SUB_DRIVE.drivetrain) {
    		case ROCKET_LEAGUE:
    			Robot.SUB_DRIVE.driveRLTank(OI.DRIVER, Util.getAndSetDouble("Ramp", .75), Util.getAndSetDouble("Drive Inhibitor", 1));
    			break;
    		case FORZA: 
    			Robot.SUB_DRIVE.driveForza(OI.DRIVER, Util.getAndSetDouble("Ramp", .75), Util.getAndSetDouble("Radius", 1), Util.getAndSetDouble("Drive Inhibitor", 1));
    			break;
    		case REV:
    			Robot.SUB_MANIPULATOR.rev(OI.DRIVER);
    	}
    }

    protected boolean isFinished() {
        return false;
    }

    protected void end() {}

    protected void interrupted() {}
}
