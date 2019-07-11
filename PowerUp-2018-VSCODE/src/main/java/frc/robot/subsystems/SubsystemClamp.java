package frc.robot.subsystems;

import edu.wpi.first.wpilibj.Solenoid;
import edu.wpi.first.wpilibj.command.Subsystem;
import frc.robot.Constants;

/**
 * opens and closes the clamp part of the manipulator
 */
public class SubsystemClamp extends Subsystem {
	// private Solenoid openArms;
	// private Solenoid closeArms;

	private Solenoid clamp;
	private boolean open; // current State of arms; true = open, false = closed
	
	public SubsystemClamp(){
		// openArms = new Solenoid(Constants.OPEN_ARMS);
		// closeArms = new Solenoid(Constants.CLOSE_ARMS);
		clamp = new Solenoid(6);
		open = false;
	} 

    public void initDefaultCommand() {}
   
    public void openArms(){
    	// openArms.set(true);
		// closeArms.set(false);
		clamp.set(true);
    	open = true;
    }

    
    public void closeArms(){
    	// openArms.set(false);
		// closeArms.set(true);
		clamp.set(false);
    	open = false;
    }
    
    public void toggleArms(){
    	if (open) closeArms();	else openArms();
    }
}

