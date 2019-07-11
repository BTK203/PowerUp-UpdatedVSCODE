package frc.robot.commands;

import edu.wpi.first.wpilibj.command.Command;
import frc.robot.OI;
import frc.robot.Robot;
import frc.robot.util.Util;

/** move the mast */
public class ManualCommandGrow extends Command {

    
    public ManualCommandGrow() {
        requires(Robot.SUB_MAST);
    }

    protected void initialize() {
    }

    protected void execute() {
    	Robot.SUB_MAST.moveBySpeed(OI.OPERATOR, Util.getAndSetDouble("Screw Inhibitor", 1));
    }

    protected boolean isFinished() {
        return false;
    }

    protected void end() {}

    protected void interrupted() {}
}
