/*----------------------------------------------------------------------------*/
/* Copyright (c) 2018 FIRST. All Rights Reserved.                             */
/* Open Source Software - may be modified and shared by FRC teams. The code   */
/* must be accompanied by the FIRST BSD license file in the root directory of */
/* the project.                                                               */
/*----------------------------------------------------------------------------*/

package frc.robot.subsystems;

import edu.wpi.first.wpilibj.Solenoid;
import edu.wpi.first.wpilibj.command.Subsystem;
import frc.robot.Robot;
import frc.robot.RobotMap;
import frc.robot.commands.JOperate;

/**
 * Add your docs here.
 */
public class Pneumatics extends Subsystem {

    private Solenoid m_solenoid;

    public Pneumatics() {

        m_solenoid = new Solenoid(RobotMap.SOLENOID);
    }

    public void setOff() {
        m_solenoid.set(false);
    }

    public void setOn() {
        m_solenoid.set(true);
    }

    @Override
    public void initDefaultCommand() {
        // Set the default command for a subsystem here.
        // setDefaultCommand(new MySpecialCommand());
        setDefaultCommand(new JOperate(Robot.m_oi.driverController));
    }
}
