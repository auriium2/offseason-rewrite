package frc.robot;

import edu.wpi.first.wpilibj.Joystick;
import frc.robot.drive.DriveCommands;
import frc.robot.drive.DriveInput;
import frc.robot.drive.DriveSystem;
import frc.robot.drive.control.DriveControl;
import frc.robot.drive.control.DriveControlSetup;
import frc.robot.odometry.OdometryControl;

public class RobotSetup {

    public TeleopContainer setup() {

        OdometryControl odometryControl = new OdometryControl(gyro)
        DriveControl driveControl = DriveControlSetup.setup(odometryControl);
        DriveInput driveInput = new DriveInput( new Joystick(0) );
        DriveCommands driveCommands = new DriveCommands(driveInput, driveControl);
        DriveSystem driveSystem = new DriveSystem(driveInput, driveCommands);





        return new TeleopContainer();
    }

}
