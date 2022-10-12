package frc.robot.drive;

import edu.wpi.first.math.kinematics.SwerveModuleState;
import frc.robot.drive.control.DriveControl;
import frc.robot.odometry.OdometryControl;
import frc.robot.util.System;

/**
 * this system updates the odometer with fresh drive states from the drive controller
 */
public class OdoUpdateSystem implements System {

    final DriveControl driveControl;
    final OdometryControl odometryControl;

    public OdoUpdateSystem(DriveControl driveControl, OdometryControl odometryControl) {
        this.driveControl = driveControl;
        this.odometryControl = odometryControl;
    }

    @Override
    public void periodic(long delta) {
        SwerveModuleState[] states = driveControl.currentStates();

        odometryControl.submitToOdometer(states);
    }
}
