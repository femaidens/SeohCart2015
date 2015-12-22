package org.usfirst.frc.team2265.robot.commands;

import org.usfirst.frc.team2265.robot.Robot;
import org.usfirst.frc.team2265.robot.subsystems.Drive;
import org.usfirst.frc.team2265.robot.commands.DriveOneFoot;
import org.usfirst.frc.team2265.robot.commands.TurnLeft;
import org.usfirst.frc.team2265.robot.commands.TurnRight;
import edu.wpi.first.wpilibj.command.CommandGroup;

/**
 *
 */
public class Navigate extends CommandGroup {
    
    public  Navigate() {
    	Robot.drive.getPositions();
    	for (int i = 0 ; i < Robot.drive.getYDistance(); i++)
    		addSequential(new DriveOneFoot(0.5));
    	
    	addSequential (new TurnRight(0.5));
    	for (int i = 0; i < Robot.drive.getXDistance(); i++)
    		addSequential (new DriveOneFoot(0.5));
    	addSequential (new TurnLeft(0.5));
    
        // Add Commands here:
        // e.g. addSequential(new Command1());
        //      addSequential(new Command2());
        // these will run in order.

        // To run multiple commands at the same time,
        // use addParallel()
        // e.g. addParallel(new Command1());
        //      addSequential(new Command2());
        // Command1 and Command2 will run in parallel.

        // A command group will require all of the subsystems that each member
        // would require.
        // e.g. if Command1 requires chassis, and Command2 requires arm,
        // a CommandGroup containing them would require both the chassis and the
        // arm.
    }
}
