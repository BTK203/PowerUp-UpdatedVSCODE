
package frc.robot.commands;

import edu.wpi.first.wpilibj.DriverStation;
import edu.wpi.first.wpilibj.command.Command;
import frc.robot.Robot;
import frc.robot.util.Util;

public class CyborgCommandDriveDistance extends Command {

    public static final long TIME_WAIT = 1000;
    public final double inches;
    private long time;
    private boolean inRange;

    public CyborgCommandDriveDistance(double inches) {
        this.inches = inches;
        requires(Robot.SUB_DRIVE);
    }

    protected void initialize() {
    	DriverStation.reportWarning("DRIVING " + inches + " INCHES", false);
        Robot.SUB_DRIVE.setOverride(true);
        Robot.SUB_DRIVE.reset();
        time = System.currentTimeMillis() + TIME_WAIT;
    }

    protected void execute() {
        inRange = Robot.SUB_DRIVE.driveDistance(inches, inches);
    }

    protected boolean isFinished() {
        if(!inRange) {
            time = System.currentTimeMillis() + TIME_WAIT;
        }
        return time < System.currentTimeMillis();
    }

    protected void end() {
        DriverStation.reportWarning("CyborgCommandDriveDistance finished", false);
        Robot.SUB_DRIVE.setOverride(false);
        Robot.SUB_DRIVE.driveDirect(0, 0);
    }

    protected void interrupted() {
        end();
    }
}