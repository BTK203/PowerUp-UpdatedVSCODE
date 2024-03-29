package frc.robot.commands;

import edu.wpi.first.wpilibj.DriverStation;
import edu.wpi.first.wpilibj.command.Command;
import frc.robot.Robot;
import frc.robot.enumeration.Position;
import frc.robot.subsystems.SubsystemDrive;
import frc.robot.util.Util;

public class CyborgCommandDriveUntilError extends Command {
    public static final long ERROR_TIME = 500;
    public static final int TARGET_ERROR = 500;

    private long time = 0;

    public CyborgCommandDriveUntilError() {
        requires(Robot.SUB_DRIVE);
    }

    protected void initialize() {
        time = System.currentTimeMillis() + ERROR_TIME;
        Robot.SUB_DRIVE.setOverride(true);
    }

    protected void execute() {
        double speed = Util.getAndSetDouble("SPEED ERROR: Forward", -0.25);
        Robot.SUB_DRIVE.driveDirect(speed, speed);
    }

    protected boolean isFinished() {
        if(Math.abs(Robot.SUB_DRIVE.getError()) < TARGET_ERROR) {
            time = System.currentTimeMillis() + ERROR_TIME;
        }
        boolean toReturn = time < System.currentTimeMillis();
        return time < System.currentTimeMillis();
    }

    protected void end() {
        DriverStation.reportWarning("CyborgCommandDriveUntilError finished", false);
        Robot.SUB_DRIVE.setOverride(false);
        Robot.SUB_DRIVE.driveDirect(0, 0);
    }

    protected void interrupted() {
        end();
    }
}