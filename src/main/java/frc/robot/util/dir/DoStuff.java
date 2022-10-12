package frc.robot.util.dir;

import frc.robot.drive.DriveCommands;

public class DoStuff implements DirectiveBuilder {

    final DriveCommands driveCommands;

    public DoStuff(DriveCommands driveCommands) {
        this.driveCommands = driveCommands;
    }


    @Override
    public void init() {

    }

    @Override
    public void periodic(long delta) {

    }

    @Override
    public void shutdown() {

    }
}
