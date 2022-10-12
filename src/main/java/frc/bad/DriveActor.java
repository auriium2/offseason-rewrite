package frc.bad;

import frc.robot.drive.Drive;

public class DriveActor implements Actor<Drive.Should> {

    @Override
    public void handle(Drive.Should enu) {

        if (enu == Drive.Should.AIM) {
            aim();
        }

        if (enu == Drive.Should.NORMAL) {

        }


    }


    void aim() {

    }
}
