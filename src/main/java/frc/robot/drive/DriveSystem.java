package frc.robot.drive;

import frc.robot.util.System;

public class DriveSystem implements System {

    final DriveInput input;
    final DriveCommands commands;

    public DriveSystem(DriveInput input, DriveCommands commands) {
        this.input = input;
        this.commands = commands;
    }

    @Override
    public void init() {
        commands.lockPeriodic();
    }

    @Override
    public void periodic(long delta) {
        boolean slow = input.isSlowDrivePressed();

        if (input.isAimDrivePressed()) {
            commands.aimPeriodic(slow); return;
        }

        if (input.isUserInputZeroed()) {
            commands.lockPeriodic(); return;
        }

        commands.drivePeriodic(slow);

    }

}
