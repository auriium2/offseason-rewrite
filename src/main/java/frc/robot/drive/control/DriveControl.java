package frc.robot.drive.control;

import com.swervedrivespecialties.swervelib.SwerveModule;
import edu.wpi.first.math.MathUtil;
import edu.wpi.first.math.geometry.Rotation2d;
import edu.wpi.first.math.kinematics.ChassisSpeeds;
import edu.wpi.first.math.kinematics.SwerveDriveKinematics;
import edu.wpi.first.math.kinematics.SwerveModuleState;
import frc.robot.drive.Drive;
import frc.robot.odometry.OdometryControl;

/**
 * a low level controller for the swerve modules
 */
public class DriveControl {

    final OdometryControl odometryControl;
    final SwerveModule[] swerve;

    DriveControl(OdometryControl odometryControl, SwerveModule[] swerve) {
        this.odometryControl = odometryControl;
        this.swerve = swerve;
    }

    public SwerveModuleState[] currentStates() {
        SwerveModuleState[] states = new SwerveModuleState[4];

        for (int i = 0; i < swerve.length; i++) {
            SwerveModule module = swerve[i];

            states[i] = new SwerveModuleState(module.getDriveVelocity(), new Rotation2d(module.getSteerAngle()));
        }

        return states;
    }

    public void driveAt(SwerveModuleState[] states) {

        for(int i = 0; i < swerve.length; i++)
        {
            double voltage = MathUtil.clamp(Drive.FF.calculate(states[i].speedMetersPerSecond), -12, 12);
            double radians = states[i].angle.getRadians();

            swerve[i].set(voltage, radians);
        }

    }

    public void driveAt(double x, double y, double rot, boolean slow) {
        ChassisSpeeds speeds = ChassisSpeeds.fromFieldRelativeSpeeds( x, y, rot, odometryControl.getEstimatedRotation() );
        SwerveModuleState[] states = Drive.KINEMATICS.toSwerveModuleStates(speeds);
        SwerveDriveKinematics.desaturateWheelSpeeds(states, slow ? Drive.SLOW_DRIVE_VELOCITY : Drive.MAX_DRIVE_VELOCITY);

        driveAt(states);
    }


}
