/*----------------------------------------------------------------------------*/
/* Copyright (c) 2019 FIRST. All Rights Reserved.                             */
/* Open Source Software - may be modified and shared by FRC teams. The code   */
/* must be accompanied by the FIRST BSD license file in the root directory of */
/* the project.                                                               */
/*----------------------------------------------------------------------------*/

package frc.robot.commands;

import edu.wpi.first.wpilibj2.command.CommandBase;
import frc.robot.subsystems.SolenoidSubsystem;

public class ToggleSolenoid extends CommandBase {
  /**
   * Creates a new ToggleSolenoid.
   */
  private SolenoidSubsystem _solenoidSub = SolenoidSubsystem.getInstance();
  public ToggleSolenoid() {
    addRequirements(_solenoidSub);
  }

  // Called when the command is initially scheduled.
  @Override
  public void initialize() {
    _solenoidSub.toggleSolenoidWithController();
  }

  // Called every time the scheduler runs while the command is scheduled.
  @Override
  public void execute() {
    //_solenoidSub.toggleSolenoidWithAButton();
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
