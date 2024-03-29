package frc.robot.commands;

import edu.wpi.first.wpilibj.command.Command;
import frc.robot.Robot;

/**
 * Code that kills compressor until interruption
 */
public class ButtonCommandKillCompressor extends Command {

    public ButtonCommandKillCompressor() {
        requires(Robot.SUB_COMPRESSOR);
    }

    protected void initialize() {
    	Robot.SUB_COMPRESSOR.setState(false);
    }

    protected void execute() {}

    protected boolean isFinished() {
        return false;
    }

    protected void end() {
    	Robot.SUB_COMPRESSOR.setState(true);
    }

    protected void interrupted() {
    	end();
    }
}
