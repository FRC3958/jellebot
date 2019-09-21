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
import frc.robot.RobotMap;
import frc.robot.commands.JelleDrive;

/**
 * Add your docs here.
 */
public class DriveTrain extends Subsystem {

  private TalonSRX frontLeftTalon, frontRightTalon,
    backLeftTalon, backRightTalon;

  public DriveTrain() {

    frontLeftTalon  = new TalonSRX(RobotMap.FRONT_LEFT_TALON);
    frontRightTalon = new TalonSRX(RobotMap.FRONT_RIGHT_TALON);
    backLeftTalon   = new TalonSRX(RobotMap.BACK_LEFT_TALON);
    backRightTalon  = new TalonSRX(RobotMap.BACK_RIGHT_TALON);

    frontRightTalon.setInverted(true);
    backRightTalon.setInverted(true);

    backLeftTalon.follow(frontLeftTalon);
    backRightTalon.follow(frontRightTalon);

  }

  public void arcadeDrive(double speed, double rotation) {
    
    frontLeftTalon.set(ControlMode.PercentOutput, speed);
  }

  @Override
  public void initDefaultCommand() {
    // Set the default command for a subsystem here.
    // setDefaultCommand(new MySpecialCommand());
    setDefaultCommand(new JelleDrive());
  }
}
