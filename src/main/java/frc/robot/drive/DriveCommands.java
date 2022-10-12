package frc.robot.drive;

import frc.robot.drive.control.DriveControl;

public class DriveCommands {

    final DriveInput input;
    final DriveControl control;
    //final VisionSystem system

    public DriveCommands(DriveInput input, DriveControl control) {
        this.input = input;
        this.control = control;
    }

    public void lockPeriodic() {
        control.driveAt(Drive.LOCK);
    }

    public void aimPeriodic(boolean slow) {
        throw new UnsupportedOperationException("TODO");
    }

    public void drivePeriodic(boolean slow) {

        control.driveAt(
                input.getInputX(),
                input.getInputY(),
                input.getInputRot(),
                slow
        );

    }



}
