package frc.robot.commands;

import edu.wpi.first.wpilibj.command.Command;
import frc.robot.Robot;

/** move the mast */
public class ButtonCommandHook extends Command {
    
    public ButtonCommandHook() {
        // requires(Robot.SUB_HOOK);
    }

    protected void initialize() {
        // Robot.SUB_HOOK.raiseHook();
    }

    protected void execute() {}

    protected boolean isFinished() { return false; }

    protected void end() {
        // Robot.SUB_HOOK.lowerHook();
    }

    protected void interrupted() {
    	end();
    }
}
