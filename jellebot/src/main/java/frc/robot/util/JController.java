/*----------------------------------------------------------------------------*/
/* Copyright (c) 2018 FIRST. All Rights Reserved.                             */
/* Open Source Software - may be modified and shared by FRC teams. The code   */
/* must be accompanied by the FIRST BSD license file in the root directory of */
/* the project.                                                               */
/*----------------------------------------------------------------------------*/

package frc.robot.util;

import edu.wpi.first.wpilibj.XboxController;
import edu.wpi.first.wpilibj.buttons.Button;
import edu.wpi.first.wpilibj.buttons.JoystickButton;

/**
 * Add your docs here.
 */
public class JController extends XboxController {

    enum ButtonCodes {
        kBumperLeft(5), kBumperRight(6), kStickLeft(9), kStickRight(10), kA(1), kB(2), kX(3), kY(4), kBack(7),
        kStart(8);

        public int value;

        ButtonCodes(int value) {
            this.value = value;
        }
    }

    public Button bumperLeft = new JoystickButton(this, ButtonCodes.kBumperLeft.value),
            bumperRight = new JoystickButton(this, ButtonCodes.kBumperRight.value),
            aButton = new JoystickButton(this, ButtonCodes.kA.value); // uwu *sleepy weepy* *wakes up* -O- *yawn* o-O
                                                                      // *who are you???* owo *notices your great smile*

    public JController(int port) {
        super(port);

    }

    @Override
    public double getX(Hand hand) {
        double original = super.getX(hand);

        return (Math.abs(original) < 0.1) ? 0 : original;
    }

    @Override
    public double getY(Hand hand) {

        double original = super.getY(hand);

        return (Math.abs(original) < 0.1) ? 0 : original;
    }
}
