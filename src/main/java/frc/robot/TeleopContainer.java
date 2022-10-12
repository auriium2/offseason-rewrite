package frc.robot;

import frc.robot.drive.DriveSystem;
import frc.robot.drive.OdoUpdateSystem;
import frc.robot.util.System;

public class TeleopContainer implements System {

    final DriveSystem driveSystem;
    final OdoUpdateSystem odoUpdateSystem;

    public TeleopContainer(DriveSystem driveSystem, OdoUpdateSystem odoUpdateSystem) {
        this.driveSystem = driveSystem;
        this.odoUpdateSystem = odoUpdateSystem;
    }

    @Override
    public void init() {
        driveSystem.init();
        odoUpdateSystem.init();
    }

    @Override
    public void periodic(long delta) {
        driveSystem.periodic(delta);
        odoUpdateSystem.periodic(delta);
    }
}
