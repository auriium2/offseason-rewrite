package frc.robot.drive.control;

import com.swervedrivespecialties.swervelib.Mk4SwerveModuleHelper;
import com.swervedrivespecialties.swervelib.SwerveModule;
import edu.wpi.first.wpilibj.shuffleboard.BuiltInLayouts;
import edu.wpi.first.wpilibj.shuffleboard.Shuffleboard;
import edu.wpi.first.wpilibj.shuffleboard.ShuffleboardContainer;
import edu.wpi.first.wpilibj.shuffleboard.ShuffleboardLayout;
import frc.robot.odometry.OdometryControl;

import static com.swervedrivespecialties.swervelib.Mk4SwerveModuleHelper.GearRatio.L2;

public class DriveControlSetup {

    public static DriveControl setup(OdometryControl odometryControl) {
        SwerveModule[] modules = new SwerveModule[4];

        ShuffleboardContainer container = Shuffleboard.getTab("ass");
        ShuffleboardLayout frontLeft = container
                .getLayout("Front Left Module", BuiltInLayouts.kList)
                .withPosition(0, 0);
        ShuffleboardLayout frontRight = container
                .getLayout("Front Right Module", BuiltInLayouts.kList)
                .withPosition(2, 0);
        ShuffleboardLayout backLeft = container
                .getLayout("Back Left Module", BuiltInLayouts.kList)
                .withPosition(4, 0);
        ShuffleboardLayout backRight = container
                .getLayout("Back Right Module", BuiltInLayouts.kList)
                .withPosition(6, 0);

        modules[0] = Mk4SwerveModuleHelper.createFalcon500(frontLeft, L2, 1, 2, 9, -Math.toRadians(232.55));
        modules[1] = Mk4SwerveModuleHelper.createFalcon500(frontRight, L2, 7, 8, 12, -Math.toRadians(331.96 - 180));
        modules[2] = Mk4SwerveModuleHelper.createFalcon500(backLeft, L2, 5, 6, 11, -Math.toRadians(255.49));
        modules[3] = Mk4SwerveModuleHelper.createFalcon500(backRight, L2, 3, 4, 10, -Math.toRadians(70.66 + 180));

        return new DriveControl(odometryControl, modules);
    }

}
