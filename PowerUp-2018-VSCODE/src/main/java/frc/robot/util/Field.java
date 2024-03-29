package frc.robot.util;

import edu.wpi.first.wpilibj.DriverStation;
import frc.robot.enumeration.Position;

public class Field {
	public static Position getOurScale() {
		if (DriverStation.getInstance().getGameSpecificMessage().charAt(0) == 'L') {
			return Position.LEFT;
		} else {
			return Position.RIGHT;
		}
	}
	
	public static Position getThierScale() {
		if (DriverStation.getInstance().getGameSpecificMessage().charAt(2) == 'L') {
			return Position.LEFT;
		} else {
			return Position.RIGHT;
		}
	}
	
	public static Position getSwitch() {
		if (DriverStation.getInstance().getGameSpecificMessage().charAt(1) == 'L') {
			return Position.LEFT;
		} else {
			return Position.RIGHT;
		}
	}
}
