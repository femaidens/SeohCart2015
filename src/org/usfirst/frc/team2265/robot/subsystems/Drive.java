package org.usfirst.frc.team2265.robot.subsystems;


import edu.wpi.first.wpilibj.command.Subsystem;
import edu.wpi.first.wpilibj.RobotDrive;
import edu.wpi.first.wpilibj.Joystick;
import edu.wpi.first.wpilibj.CANTalon;
import edu.wpi.first.wpilibj.Gyro;
import edu.wpi.first.wpilibj.Encoder;

import org.usfirst.frc.team2265.robot.RobotMap;
import org.usfirst.frc.team2265.robot.Robot;

public class Drive extends Subsystem{
	
	public static CANTalon frontLeft = new CANTalon(RobotMap.frontLeftPort);
	public static CANTalon backLeft = new CANTalon(RobotMap.backLeftPort);
	public static CANTalon frontRight = new CANTalon(RobotMap.frontRightPort);
	public static CANTalon backRight = new CANTalon(RobotMap.backRightPort);
	
	public static Gyro gyro = new Gyro (RobotMap.gyroPort);

	
	
	public static RobotDrive drive = new RobotDrive(frontLeft, backLeft, frontRight, backRight);

	public static Joystick leftJoystick =  new Joystick(RobotMap.leftJoystickPort);
	public static Joystick rightJoystick = new Joystick(RobotMap.rightJoystickPort);
	
	private double leftSide, rightSide;
	private static int currXPos;
	private static int currYPos;
	private static int toXPos;
	private static int toYPos;
	private Object currentRoomNum;
    private Object toRoomNum;
	
	
	public void getPositions(){
		//int[] currentRoom = Robot.currentRoomSelector.getSelected();
		//System.out.println("" + currentRoom[0] +","+ currentRoom[1]);
		//currXPos = currentRoom[0];
		//currYPos = currentRoom[1];
		//int[] destinationRoom = (int[])Robot.destinationRoomSelector.getSelected();
		//toXPos = destinationRoom[0];
		//toYPos = destinationRoom[1];
		currentRoomNum = Robot.currentRoomSelector.getSelected();
		toRoomNum = Robot.destinationRoomSelector.getSelected();
		int[] currPosArray = Robot.rooms.get(toRoomNum);
		int[] toPosArray = Robot.rooms.get(currentRoomNum);
		currXPos =currPosArray[0];
		currYPos = currPosArray[1];
		toXPos = toPosArray[0];
		toXPos = toPosArray[1];
	}
	public int getXDistance(){
		return toXPos - currXPos;
	}
	public int getYDistance(){
		return toYPos - currYPos;
	}
	public void drive(double fLVal, double fRVal, double bRVal, double bLVal){
		frontLeft.set(fLVal);
		backLeft.set(bLVal);
		backRight.set(bRVal);
		frontRight.set(fRVal);
			
	}
	
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

