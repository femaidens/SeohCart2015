package org.usfirst.frc.team2265.robot.commands;

import edu.wpi.first.wpilibj.CANTalon.FeedbackDevice;
import edu.wpi.first.wpilibj.command.Command;

import org.usfirst.frc.team2265.robot.subsystems.Drive;
import org.usfirst.frc.team2265.robot.Robot;
/**
 *
 */
public class TurnLeft extends Command {

	private double speed;
	
    public TurnLeft(double s) {
        // Use requires() here to declare subsystem dependencies
        // eg. requires(chassis);
    	requires(Robot.drive);
		speed = s;
    }
    

    // Called just before this Command runs the first time
    protected void initialize() {
    	Drive.gyro.reset();
    	Robot.drive.frontRight.setFeedbackDevice(FeedbackDevice.QuadEncoder); 
    	
    }

    // Called repeatedly when this Command is scheduled to run
    protected void execute() {
    	Robot.drive.drive(speed, 0 , -speed, -speed);
    }

    // Make this return true when this Command no longer needs to run execute()
    protected boolean isFinished() {
       if(Drive.gyro.getAngle() >= 270) 
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