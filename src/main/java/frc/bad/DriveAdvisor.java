package frc.bad;

import frc.robot.drive.DriveInput;

public class DriveAdvisor implements Advisor<DriveShould> {

    final DriveInput input;

    public DriveAdvisor(DriveInput input) {
        this.input = input;
    }

    @Override
    public DriveShould getAdviceForThisLoop() {
        double rot = input.getInputRot();
        double x = input.getInputX();
        double y = input.getInputY();

        if (input.isAimDrivePressed()) {
            if (input.isSlowDrivePressed()) {
                return DriveShould.AIM_SLOW;
            }

            return DriveShould.AIM;
        }

        if (x == 0 && y == 0 && rot == 0) {
            return DriveShould.LOCK;
        }

        if (input.isSlowDrivePressed()) {
            return DriveShould.SLOW;
        }


        return DriveShould.NORMAL;
    }
}
