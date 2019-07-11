package frc.robot.commands;

import edu.wpi.first.wpilibj.command.Command;
import frc.robot.Robot;
import frc.robot.util.Util;

/** Toggle PID */
public class ButtonCommandKillPID extends Command {

    public ButtonCommandKillPID() {
        requires(Robot.SUB_DRIVE);
    }

    protected void initialize() {
       // Robot.SUB_DRIVE.setPIDF(0,0,0,0);
    }

    protected void execute() { }

    protected boolean isFinished() {
        return false;
    }

    protected void end() {
       // Robot.SUB_DRIVE.setPIDF(Util.getAndSetDouble("P", 1),
           //     Util.getAndSetDouble("I", 1),
           //     Util.getAndSetDouble("D", 1),
           //     Util.getAndSetDouble("F", 1));
    }

    protected void interrupted() {}
}
