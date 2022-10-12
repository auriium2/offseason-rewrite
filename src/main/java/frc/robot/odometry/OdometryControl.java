package frc.robot.odometry;

import edu.wpi.first.math.geometry.Pose2d;
import edu.wpi.first.math.geometry.Rotation2d;
import edu.wpi.first.math.kinematics.ChassisSpeeds;
import edu.wpi.first.math.kinematics.SwerveDriveOdometry;
import edu.wpi.first.math.kinematics.SwerveModuleState;
import edu.wpi.first.wpilibj.interfaces.Gyro;
import frc.robot.drive.Drive;

public class OdometryControl {

    final Gyro gyro;
    final SwerveDriveOdometry odometry;

    public OdometryControl(Gyro gyro, SwerveDriveOdometry odometry) {
        this.gyro = gyro;
        this.odometry = odometry;
    }

    public void submitToOdometer(SwerveModuleState[] states) {
        odometry.update(gyro.getRotation2d(), states);
    }

    public Rotation2d getEstimatedRotation() {
        return gyro.getRotation2d();
    }

    public Pose2d getEstimatedPosition() {
        return odometry.getPoseMeters();
    }


}
