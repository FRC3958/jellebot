/*----------------------------------------------------------------------------*/
/* Copyright (c) 2018 FIRST. All Rights Reserved.                             */
/* Open Source Software - may be modified and shared by FRC teams. The code   */
/* must be accompanied by the FIRST BSD license file in the root directory of */
/* the project.                                                               */
/*----------------------------------------------------------------------------*/

package frc.robot.subsystems;

import com.ctre.phoenix.motorcontrol.ControlMode;
import com.ctre.phoenix.motorcontrol.can.TalonSRX;

import edu.wpi.first.wpilibj.command.Subsystem;
import frc.robot.Robot;
import frc.robot.RobotMap;
import frc.robot.commands.JDrive;
import frc.robot.util.JMath;

/**
 * Jelle made this
 */
public class DriveTrain extends Subsystem {

    private TalonSRX m_frontLeftTalon, m_frontRightTalon,
     m_backLeftTalon, m_backRightTalon;

    public DriveTrain() {

        m_frontLeftTalon    = new TalonSRX(RobotMap.DT_FRONT_LEFT_TALON);
        m_frontRightTalon   = new TalonSRX(RobotMap.DT_FRONT_RIGHT_TALON);
        m_backLeftTalon     = new TalonSRX(RobotMap.DT_BACK_LEFT_TALON);
        m_backRightTalon    = new TalonSRX(RobotMap.DT_BACK_RIGHT_TALON);

        m_frontLeftTalon.setInverted(true);

        m_backLeftTalon.follow(m_frontLeftTalon);
        m_backRightTalon.follow(m_frontRightTalon);
    }

    public void tankDrive(double forward, double turn) {
        double leftPercent = forward - turn;
        double rightPercent = forward + turn;

        leftPercent = JMath.clamp(leftPercent, -1, 1);
        rightPercent = JMath.clamp(rightPercent, -1, 1);

        m_frontLeftTalon.set(ControlMode.PercentOutput, leftPercent);
        m_frontRightTalon.set(ControlMode.PercentOutput, rightPercent);
    }

    @Override
    public void initDefaultCommand() {
        // Set the default command for a subsystem here.
        // setDefaultCommand(new MySpecialCommand());
        setDefaultCommand(new JDrive(Robot.m_oi.driverController));
    }
}
