/*----------------------------------------------------------------------------*/
/* Copyright (c) 2018 FIRST. All Rights Reserved.                             */
/* Open Source Software - may be modified and shared by FRC teams. The code   */
/* must be accompanied by the FIRST BSD license file in the root directory of */
/* the project.                                                               */
/*----------------------------------------------------------------------------*/

package frc.robot.commands;

import edu.wpi.first.wpilibj.GenericHID.Hand;
import edu.wpi.first.wpilibj.command.Command;
import frc.robot.Robot;
import frc.robot.util.JController;

public class JOperate extends Command {

    public JOperate(JController controller) {
        // Use requires() here to declare subsystem dependencies
        // eg. requires(chassis);
        requires(Robot.m_arm);

        m_controller = controller;
    }

    private JController m_controller;

    // Called just before this Command runs the first time
    @Override
    protected void initialize() {
    }

    // Called repeatedly when this Command is scheduled to run
    @Override
    protected void execute() {

        if (m_controller.getAButton() && m_controller.getBButton()) {
            Robot.m_arm.openCannon();
        } else {
            Robot.m_arm.closeCannon();
        }

        if (m_controller.getBumper(Hand.kLeft)) {
            Robot.m_arm.setArm(0.12);
        } else if (m_controller.getBumper(Hand.kRight)) {
            Robot.m_arm.setArm(-0.12);
        } else {
            Robot.m_arm.setArm(0);
        }
    }

    // Make this return true when this Command no longer needs to run execute()
    @Override
    protected boolean isFinished() {
        return false;
    }

    // Called once after isFinished returns true
    @Override
    protected void end() {
    }

    // Called when another command which requires one or more of the same
    // subsystems is scheduled to run
    @Override
    protected void interrupted() {
    }
}
