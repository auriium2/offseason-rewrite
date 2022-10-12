package frc.robot.drive;

import edu.wpi.first.math.MathUtil;
import edu.wpi.first.math.controller.SimpleMotorFeedforward;
import edu.wpi.first.math.geometry.Rotation2d;
import edu.wpi.first.math.geometry.Translation2d;
import edu.wpi.first.math.kinematics.SwerveDriveKinematics;
import edu.wpi.first.math.kinematics.SwerveModuleState;

import static com.swervedrivespecialties.swervelib.SdsModuleConfigurations.MK4_L2;

public interface Drive {


    double MAX_DRIVE_VELOCITY = 6380.0 / 60.0 * MK4_L2.getDriveReduction() * MK4_L2.getWheelDiameter() * Math.PI;
    double SLOW_DRIVE_VELOCITY = MAX_DRIVE_VELOCITY * 0.75;

    //TODO divide by 2
    double WIDTH = 0.6096;
    double BASE = 0.7712;

    //TODO use actual values here
    SimpleMotorFeedforward FF = new SimpleMotorFeedforward(0,0,0);

    SwerveDriveKinematics KINEMATICS = new SwerveDriveKinematics(
            new Translation2d(WIDTH, BASE),
            new Translation2d(WIDTH, -BASE),
            new Translation2d(-WIDTH, BASE),
            new Translation2d(-WIDTH, -BASE)
    );

    SwerveModuleState[] LOCK = new SwerveModuleState[] {
            new SwerveModuleState(0, Rotation2d.fromDegrees(45)),
            new SwerveModuleState(0, Rotation2d.fromDegrees(-45)),
            new SwerveModuleState(0, Rotation2d.fromDegrees(-45)),
            new SwerveModuleState(0, Rotation2d.fromDegrees(45))
    };

    static double driveDeadband(double input) {
        double value = input;

        value = MathUtil.applyDeadband(value, 0.1);
        value = Math.copySign(value * value, value);

        return value;
    }

}
