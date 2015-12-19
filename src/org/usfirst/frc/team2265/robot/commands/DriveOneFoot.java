package org.usfirst.frc.team2265.robot.commands;

import edu.wpi.first.wpilibj.CANTalon.FeedbackDevice;
import edu.wpi.first.wpilibj.command.Command;

import org.usfirst.frc.team2265.robot.subsystems.Drive;
import org.usfirst.frc.team2265.robot.Robot;
/**
 *
 */
public class DriveOneFoot extends Command {

	private double speed;
	private int numEncPosPerFt = 50;
	
    public DriveOneFoot(double s) {
        // Use requires() here to declare subsystem dependencies
        // eg. requires(chassis);
    	requires(Robot.drive);
		speed = s;
    }
    

    // Called just before this Command runs the first time
    protected void initialize() {
    	Robot.drive.frontRight.setFeedbackDevice(FeedbackDevice.QuadEncoder); 
    	
    }

    // Called repeatedly when this Command is scheduled to run
    protected void execute() {
    	Robot.drive.drive(speed, speed, speed, speed);
    }

    // Make this return true when this Command no longer needs to run execute()
    protected boolean isFinished() {
       if(Robot.drive.frontRight.getEncPosition() == numEncPosPerFt) 
    	   return true;
    return false;
    }

    // Called once after isFinished returns true
    protected void end() {
    }

    // Called when another command which requires one or more of the same
    // subsystems is scheduled to run
    protected void interrupted() {
    }
}
