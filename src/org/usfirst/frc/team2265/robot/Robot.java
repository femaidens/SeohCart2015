
package org.usfirst.frc.team2265.robot;

import java.util.HashMap;
import java.util.Map;
import edu.wpi.first.wpilibj.IterativeRobot;
import edu.wpi.first.wpilibj.command.Command;
import edu.wpi.first.wpilibj.command.Scheduler;
import edu.wpi.first.wpilibj.livewindow.LiveWindow;
import edu.wpi.first.wpilibj.smartdashboard.SendableChooser;
import edu.wpi.first.wpilibj.smartdashboard.SmartDashboard;

import org.usfirst.frc.team2265.robot.commands.ExampleCommand;
import org.usfirst.frc.team2265.robot.subsystems.ExampleSubsystem;
import org.usfirst.frc.team2265.robot.commands.TeleoperatedDrive;
import org.usfirst.frc.team2265.robot.subsystems.Drive;
import org.usfirst.frc.team2265.robot.commands.Navigate;
/**
 * The VM is configured to automatically run this class, and to call the
 * functions corresponding to each mode, as described in the IterativeRobot
 * documentation. If you change the name of this class or the package after
 * creating this project, you must also update the manifest file in the resource
 * directory.
 */
public class Robot extends IterativeRobot {

	public static final ExampleSubsystem exampleSubsystem = new ExampleSubsystem();
	public static OI oi;
	public static Drive drive;
	public static int[] currentRoom;
	public static int[] destinationRoom;
	
    Command autonomousCommand;
    SendableChooser autonChooser;
    public static SendableChooser destinationRoomSelector;
    public static SendableChooser currentRoomSelector; 

    public static HashMap<String, int[]> rooms = new HashMap<String, int[]>();

    /**
     * This function is run when the robot is first started up and should be
     * used for any initialization code.
     */
    public void robotInit() {
		oi = new OI();
		drive = new Drive();
		autonChooser = new SendableChooser();
		destinationRoomSelector= new SendableChooser();
		currentRoomSelector = new SendableChooser();
		setupRoomChoosers();
        // instantiate the command used for the autonomous period
        autonomousCommand = new Navigate();
        SmartDashboard.putData("What room are you currently in?", currentRoomSelector);
        SmartDashboard.putData("What room should the cart drive to?", destinationRoomSelector);
    }
	public void setupRoomChoosers(){
		/*currentRoomSelector.addDefault("123A", new int[] {1,123});
		currentRoomSelector.addObject("129B", new int[] {1,24});
	    currentRoomSelector.addObject("127P", new int[] {1,33});
	    currentRoomSelector.addObject("127A", new int[] {1,52});
	    currentRoomSelector.addObject("127B", new int[] {1,70});
	    currentRoomSelector.addObject("125A", new int[] {1,70});
	    currentRoomSelector.addObject("125B", new int[] {1,98});
	    currentRoomSelector.addObject("123B", new int[] {1,133});
	    currentRoomSelector.addObject("130A", new int[] {-3,63});
	    currentRoomSelector.addObject("128A", new int[] {-3,93});
	    currentRoomSelector.addObject("126A", new int[] {-3,123});
	    
	    destinationRoomSelector.addDefault("123A", new int[] {1,123});
		destinationRoomSelector.addObject("129B", new int[] {1,24});
	    destinationRoomSelector.addObject("127P", new int[] {1,33});
	    destinationRoomSelector.addObject("127A", new int[] {1,52});
	    destinationRoomSelector.addObject("127B", new int[] {1,70});
	    destinationRoomSelector.addObject("125A", new int[] {1,70});
	    destinationRoomSelector.addObject("125B", new int[] {1,98});
	    destinationRoomSelector.addObject("123B", new int[] {1,133});
	    destinationRoomSelector.addObject("130A", new int[] {-3,63});
	    destinationRoomSelector.addObject("128A", new int[] {-3,93});
	    destinationRoomSelector.addObject("126A", new int[] {-3,123});
		*/
		
	    rooms.put("129A", new int[] {1,6});
	    rooms.put("129B", new int[] {1,24});
	    rooms.put("127P", new int[] {1,33});
	    rooms.put("127A", new int[] {1,52});
	    rooms.put("127B", new int[] {1,70});
	    rooms.put("125A", new int[] {1,70});
	    rooms.put("125B", new int[] {1,98});
	    rooms.put("123P", new int[] {1,113});
	    rooms.put("123A", new int[] {1,123});
	    rooms.put("123B", new int[] {1,133});
	    rooms.put("130A", new int[] {-3,63});
	    rooms.put("128A", new int[] {-3,93});
	    rooms.put("126A", new int[] {-3,123});
	}
		
	public void disabledPeriodic() {
		Scheduler.getInstance().run();
	}

    public void autonomousInit() {
        // schedule the autonomous command (example)
    	//currentRoom =(int[]) currentRoomSelector.getSelected();
    	
    	//destinationRoom =(int[]) destinationRoomSelector.getSelected();
        if (autonomousCommand != null) autonomousCommand.start();
    }

    /**
     * This function is called periodically during autonomous
     */
    public void autonomousPeriodic() {
        Scheduler.getInstance().run();
    }

    public void teleopInit() {
		// This makes sure that the autonomous stops running when
        // teleop starts running. If you want the autonomous to 
        // continue until interrupted by another command, remove
        // this line or comment it out.
        if (autonomousCommand != null) autonomousCommand.cancel();
    }

    /**
     * This function is called when the disabled button is hit.
     * You can use it to reset subsystems before shutting down.
     */
    public void disabledInit(){

    }

    /**
     * This function is called periodically during operator control
     */
    public void teleopPeriodic() {
        Scheduler.getInstance().run();
        drive.teleDrive();
    }
    
    /**
     * This function is called periodically during test mode
     */
    public void testPeriodic() {
        LiveWindow.run();
    }
}
