package frc.robot.commands;

import edu.wpi.first.wpilibj.command.Command;
import frc.robot.Robot;

/** toggles the state of the clamp */
public class ButtonCommandClamp extends Command {
	
    public ButtonCommandClamp() {
        requires(Robot.SUB_CLAMP);
    }

    protected void initialize() {
    	Robot.SUB_CLAMP.closeArms();
    }

    protected void execute() {}

    protected boolean isFinished() { return false; }

    protected void end() {
    	Robot.SUB_CLAMP.openArms();
    }

    protected void interrupted() {
    	end();
    }
}
