package frc.robot.commands;

import edu.wpi.first.wpilibj.command.Command;
import frc.robot.Robot;

/** toggles the state of the clamp */
public class ButtonCommandReverse extends Command {

    public ButtonCommandReverse() {
        requires(Robot.SUB_DRIVE);
    }

    protected void initialize() {
        Robot.SUB_DRIVE.isReversing(true);
    }

    protected void execute() {}

    protected boolean isFinished() { return false; }

    protected void end() {
        Robot.SUB_DRIVE.isReversing(false);
    }

    protected void interrupted() {
        end();
    }
}
