/*----------------------------------------------------------------------------*/
/* Copyright (c) 2019 FIRST. All Rights Reserved.                             */
/* Open Source Software - may be modified and shared by FRC teams. The code   */
/* must be accompanied by the FIRST BSD license file in the root directory of */
/* the project.                                                               */
/*----------------------------------------------------------------------------*/

package frc.robot.commands;

import edu.wpi.first.wpilibj2.command.CommandBase;
import frc.robot.subsystems.RotationalServoSubsystem;

public class SetRotationalServoWithController extends CommandBase {
  /**
   * Creates a new SetRotationalServoWithController.
   */
  private RotationalServoSubsystem _rotServo = RotationalServoSubsystem.getInstance();
  public SetRotationalServoWithController() {
    addRequirements(_rotServo);
  }

  // Called when the command is initially scheduled.
  @Override
  public void initialize() {
    _rotServo.setAngleWithController();
  }

  // Called every time the scheduler runs while the command is scheduled.
  @Override
  public void execute() {
  }

  // Called once the command ends or is interrupted.
  @Override
  public void end(boolean interrupted) {
  }

  // Returns true when the command should end.
  @Override
  public boolean isFinished() {
    return true;
  }
}
