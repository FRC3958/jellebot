/*----------------------------------------------------------------------------*/
/* Copyright (c) 2018 FIRST. All Rights Reserved.                             */
/* Open Source Software - may be modified and shared by FRC teams. The code   */
/* must be accompanied by the FIRST BSD license file in the root directory of */
/* the project.                                                               */
/*----------------------------------------------------------------------------*/

package frc.robot.util;

import edu.wpi.first.wpilibj.XboxController;

/**
 * Add your docs here.
 */
public class JController extends XboxController {

    public JController(int port) {
        super(port);
    }

    public double getLeftJoyX() {
        return getRawAxis(0);
    }

    public double getLeftJoyY() {
        return getRawAxis(1);
    }

    public double getRightJoyX() {
        return getRawAxis(4);
    }

    public double getRightJoyY() {
        return getRawAxis(5);
    }
}
