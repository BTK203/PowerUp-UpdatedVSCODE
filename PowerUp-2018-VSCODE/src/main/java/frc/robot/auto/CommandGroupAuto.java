package frc.robot.auto;

import edu.wpi.first.wpilibj.DriverStation;
import edu.wpi.first.wpilibj.command.CommandGroup;
import frc.robot.Robot;
import frc.robot.commands.CyborgCommandDriveDistance;
import frc.robot.commands.CyborgCommandDriveUntilError;
import frc.robot.commands.CyborgCommandRotateDegrees;
import frc.robot.enumeration.Goal;
import frc.robot.enumeration.Position;

import static frc.robot.Constants.AutonomousConstants;

/** the sequence of commands for autonomous */
public class CommandGroupAuto extends CommandGroup {

	//Stores the states of the switches and scale
	String gameData;

	public CommandGroupAuto(Position position, Goal goal) {
		//Get the state of the switches and scale for each round
		gameData = DriverStation.getInstance().getGameSpecificMessage();

		// make sure everything is in the right state/position up here
		Robot.SUB_CLAMP.closeArms();


		// EX: making sure flap is closed before auto starts
		switch (position) {
			case LEFT:
				switch (goal){
					case RUN_FOR_IT:
						addSequential(new CyborgCommandDriveUntilError());
						break;
					case SWITCH:
						if (gameData.charAt(0) == 'L'){ //When the switch is on the left
							addSequential(new CyborgCommandDriveDistance(AutonomousConstants.DIST_TO_SWITCH_FROM_SIDE));
							addSequential(new CyborgCommandRotateDegrees(AutonomousConstants.ROT_90_CLOCKWISE));
							Robot.SUB_MANIPULATOR.spit();
						} else { //When the switch is on the right
							addSequential(new CyborgCommandDriveDistance(AutonomousConstants.DIST_WALL_TO_SWITCH_BLOCK_MID));
							addSequential(new CyborgCommandRotateDegrees(AutonomousConstants.ROT_90_CLOCKWISE));
						}
						Robot.SUB_MANIPULATOR.spit();
						break;
					case ENEMY_SWITCH:
                        if (gameData.charAt(2) == 'L'){ //When switch is on the left

                        } else { //When switch is on the right

                        }
						break;
					case SCALE:
						if (gameData.charAt(1) == 'L'){ //When scale is on the left

						} else { //When scale is on the right

						}
						break;
					
					case BEST_OPTION:
						break;
				}
				break;

			case CENTER:
				switch (goal){
					case RUN_FOR_IT:
						addSequential(new CyborgCommandDriveUntilError());
						break;
					case SWITCH:
						addSequential(new CyborgCommandDriveDistance(AutonomousConstants.DIST_PASS_PORTAL));
						if (gameData.charAt(0) == 'L'){ //When the switch is on the left
							addSequential(new CyborgCommandRotateDegrees(AutonomousConstants.ROT_90_COUNTERCLOCKWISE));
							addSequential(new CyborgCommandDriveDistance(AutonomousConstants.DIST_CENTER_LINE_SWITCH_ALIGN));
							addSequential(new CyborgCommandRotateDegrees(AutonomousConstants.ROT_90_CLOCKWISE));
							addSequential(new CyborgCommandDriveDistance(AutonomousConstants.DIST_WALL_TO_BLOCKS
																				+ AutonomousConstants.DIST_BLOCKS_TO_SWITCH
																				- AutonomousConstants.DIST_PASS_PORTAL));

						} else { //When the switch is on the right
							addSequential(new CyborgCommandRotateDegrees(AutonomousConstants.ROT_90_CLOCKWISE));
							addSequential(new CyborgCommandDriveDistance(AutonomousConstants.DIST_CENTER_LINE_SWITCH_ALIGN));
							addSequential(new CyborgCommandRotateDegrees(AutonomousConstants.ROT_90_COUNTERCLOCKWISE));
				//			addParallel(new CyborgCommandGoToMid());
							addSequential(new CyborgCommandDriveDistance(AutonomousConstants.DIST_WALL_TO_BLOCKS
																				+ AutonomousConstants.DIST_BLOCKS_TO_SWITCH
																				- AutonomousConstants.DIST_PASS_PORTAL));
						}
						break;
					case ENEMY_SWITCH:
						break;
					case SCALE:
						break;
					case BEST_OPTION:
						break;
			}
				break;
				
			case RIGHT:
				switch (goal) {
					case RUN_FOR_IT:
						addSequential(new CyborgCommandDriveUntilError());
						break;
					case SWITCH:
						if (gameData.charAt(0) == 'R'){ //When the switch is on the right
							addParallel(new CyborgCommandDriveDistance(AutonomousConstants.DIST_TO_SWITCH_FROM_SIDE));
							addSequential(new CyborgCommandRotateDegrees(AutonomousConstants.ROT_90_COUNTERCLOCKWISE));
						} else { //When the switch is on the left

						}
						break;
					case ENEMY_SWITCH:

						break;
					case SCALE:
						if (gameData.charAt(1) == 'R'){ //When scale is on the right

						} else { //When scale is on the left

						}
						break;
					case BEST_OPTION:
						break;
				}
			break;
		}	
	}
}