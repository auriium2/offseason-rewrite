package frc.robot.intake;

import edu.wpi.first.wpilibj.Joystick;
import frc.robot.util.Xbox;

public class PneumaticInput{

    final Joystick joystick;

    public PneumaticInput(Joystick joystick) {

        this.joystick = joystick;
    }

    public boolean togglePneumatics() {
        return joystick.getRawButtonPressed(Xbox.CIRCLE);
    }



}
