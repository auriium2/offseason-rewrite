package frc.robot.drive;

import edu.wpi.first.math.filter.SlewRateLimiter;
import edu.wpi.first.wpilibj.Joystick;
import frc.robot.drive.Drive;
import frc.robot.util.Xbox;

public class DriveInput {

    final SlewRateLimiter x = new SlewRateLimiter(2);
    final SlewRateLimiter y = new SlewRateLimiter(2);

    final Joystick joystick;

    public DriveInput(Joystick joystick) {
        this.joystick = joystick;
    }

    /**
     * @return the desired x velocity from joystick modified by an accel. limiter and a deadband
     * @units m/s
     */
    public double getInputX() {
        return x.calculate(Drive.driveDeadband(joystick.getRawAxis(0)));
    }

    /**
     * @return the desired y velocity from joystick modified by an accel. limiter and a deadband
     * @units m/s
     */
    public double getInputY() {
        return y.calculate(Drive.driveDeadband(joystick.getRawAxis(1)));
    }

    /**
     * @return gets the user desired rotation with a deadband
     * @units unknown
     */
    public double getInputRot() {
        return Drive.driveDeadband(joystick.getRawAxis(2));
    }

    /**
     * @return whether the slow drive (left trigger) is held down
     */
    public boolean isSlowDrivePressed() {
        return joystick.getRawAxis(Xbox.LEFT_TRIGGER) > 0.1;
    }

    /**
     * @return whether the aim drive is held or not
     */
    public boolean isAimDrivePressed() {
        return joystick.getRawButtonPressed(Xbox.CIRCLE);
    }

    public boolean isUserInputZeroed() {
        return getInputX() == 0 && getInputY() == 0 && getInputRot() == 0;
    }

}
