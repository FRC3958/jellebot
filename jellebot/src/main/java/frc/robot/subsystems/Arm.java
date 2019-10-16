/*----------------------------------------------------------------------------*/
/* Copyright (c) 2018 FIRST. All Rights Reserved.                             */
/* Open Source Software - may be modified and shared by FRC teams. The code   */
/* must be accompanied by the FIRST BSD license file in the root directory of */
/* the project.                                                               */
/*----------------------------------------------------------------------------*/

package frc.robot.subsystems;

import edu.wpi.first.wpilibj.AnalogPotentiometer;
import edu.wpi.first.wpilibj.Solenoid;
import edu.wpi.first.wpilibj.command.Subsystem;
import frc.robot.Robot;
import frc.robot.RobotMap;
import frc.robot.commands.JOperate;

import com.ctre.phoenix.motorcontrol.ControlMode;
import com.ctre.phoenix.motorcontrol.can.TalonSRX;

/**
 * Add your docs here.
 */
public class Arm extends Subsystem {

    private Solenoid m_solenoid;
    private TalonSRX m_axle;

    public Arm() {
        m_solenoid = new Solenoid(RobotMap.ARM_SOLENOID);
        m_axle = new TalonSRX(RobotMap.ARM_AXLE_TALON);
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

    public void setArm(double setup) {
        m_axle.set(ControlMode.PercentOutput, setup);
    }
}
