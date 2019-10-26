/*----------------------------------------------------------------------------*/
/* Copyright (c) 2018 FIRST. All Rights Reserved.                             */
/* Open Source Software - may be modified and shared by FRC teams. The code   */
/* must be accompanied by the FIRST BSD license file in the root directory of */
/* the project.                                                               */
/*----------------------------------------------------------------------------*/

package frc.robot.subsystems;

  

import com.ctre.phoenix.motorcontrol.can.TalonSRX;
import com.ctre.phoenix.motorcontrol.ControlMode;

import edu.wpi.first.wpilibj.Encoder;
import edu.wpi.first.wpilibj.command.Subsystem;
import frc.robot.Robot;
import frc.robot.RobotMap;
import frc.robot.commands.JDrive;
import frc.robot.util.JMath;
import edu.wpi.first.wpilibj.smartdashboard.SmartDashboard;

/**
 * Jelle made this
 */
public class DriveTrain extends Subsystem {

    private TalonSRX m_frontLeftTalon, m_frontRightTalon, m_backLeftTalon, m_backRightTalon;
    private Encoder leftdrivetrain;
    public DriveTrain() {

        m_frontLeftTalon = new TalonSRX(RobotMap.DT_FRONT_LEFT_TALON);
        m_frontRightTalon = new TalonSRX(RobotMap.DT_FRONT_RIGHT_TALON);
        m_backLeftTalon = new TalonSRX(RobotMap.DT_BACK_LEFT_TALON);
        m_backRightTalon = new TalonSRX(RobotMap.DT_BACK_RIGHT_TALON);
        leftdrivetrain = new Encoder(0,1,false,Encoder.EncodingType.k4X );

        m_frontLeftTalon.setInverted(true);
        m_backLeftTalon.setInverted(true);

        m_backLeftTalon.follow(m_frontLeftTalon);
        m_backRightTalon.follow(m_frontRightTalon);

        leftdrivetrain.setMaxPeriod(0.1);
        leftdrivetrain.setMinRate(10);
        leftdrivetrain.setDistancePerPulse(5);
        leftdrivetrain.setReverseDirection(false);
        leftdrivetrain.setSamplesToAverage(7);
    }

    public void tankDrive(double forward, double turn) {
        // hard limit on turning, disable or replace with scaling later!
        turn *= .25;

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
