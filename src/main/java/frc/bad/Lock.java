package frc.bad;

import edu.wpi.first.math.geometry.Rotation2d;
import edu.wpi.first.math.kinematics.SwerveModuleState;
import frc.robot.drive.control.DriveControl;

public class Lock implements Actor<DriveShould> {

    static final SwerveModuleState[] LOCK = new SwerveModuleState[] {
            new SwerveModuleState(0, Rotation2d.fromDegrees(45)),
            new SwerveModuleState(0, Rotation2d.fromDegrees(-45)),
            new SwerveModuleState(0, Rotation2d.fromDegrees(-45)),
            new SwerveModuleState(0, Rotation2d.fromDegrees(45))
    };

    final DriveControl driveControl;

    public Lock(DriveControl driveControl) {
        this.driveControl = driveControl;
    }

    @Override
    public void handle(DriveShould enu) {
        driveControl.driveAt(LOCK);
    }
}
