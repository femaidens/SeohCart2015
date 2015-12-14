package org.usfirst.frc.team2265.robot.subsystems;


import edu.wpi.first.wpilibj.command.Subsystem;
import edu.wpi.first.wpilibj.RobotDrive;
import edu.wpi.first.wpilibj.Joystick;
import edu.wpi.first.wpilibj.CANTalon;
import org.usfirst.frc.team2265.robot.RobotMap;
public class Drive extends Subsystem{
	
	public static CANTalon frontLeft = new CANTalon(RobotMap.frontLeftPort);
	public static CANTalon backLeft = new CANTalon(RobotMap.backLeftPort);
	public static CANTalon frontRight = new CANTalon(RobotMap.frontRightPort);
	public static CANTalon backRight = new CANTalon(RobotMap.backRightPort);
	
	public static RobotDrive drive = new RobotDrive(frontLeft, backLeft, frontRight, backRight);

	public static Joystick leftJoystick =  new Joystick(RobotMap.leftJoystickPort);
	public static Joystick rightJoystick = new Joystick(RobotMap.rightJoystickPort);
	
	private double leftSide, rightSide;
	
	public void teleDrive(){
		//KAT: I thought this was the best way to implement tank with the Scheduler. 
		leftSide = leftJoystick.getY();
		rightSide = rightJoystick.getY();
		drive.tankDrive(leftSide, rightSide);
	}

	@Override
	protected void initDefaultCommand() {
		// TODO Auto-generated method stub
		
	} 
	}

