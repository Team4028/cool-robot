/*----------------------------------------------------------------------------*/
/* Copyright (c) 2018-2019 FIRST. All Rights Reserved.                        */
/* Open Source Software - may be modified and shared by FRC teams. The code   */
/* must be accompanied by the FIRST BSD license file in the root directory of */
/* the project.                                                               */
/*----------------------------------------------------------------------------*/

package frc.robot;

import edu.wpi.first.wpilibj.GenericHID;
import edu.wpi.first.wpilibj.XboxController;
import frc.robot.commands.HomeServo;
import frc.robot.commands.RunMotor;
import frc.robot.commands.RunMotorWithButton;
import frc.robot.commands.RunMotorWithController;
import frc.robot.commands.RunMotorWithSensor;
import frc.robot.commands.RunServo;
import frc.robot.commands.SetRotationalServoAngle;
import frc.robot.commands.SetRotationalServoWithController;
import frc.robot.commands.ToggleSolenoid;
import edu.wpi.first.wpilibj2.command.Command;

/**
 * This class is where the bulk of the robot should be declared.  Since Command-based is a
 * "declarative" paradigm, very little robot logic should actually be handled in the {@link Robot}
 * periodic methods (other than the scheduler calls).  Instead, the structure of the robot
 * (including subsystems, commands, and button mappings) should be declared here.
 */
public class RobotContainer {
  // The robot's subsystems and commands are defined here...
  private final RunMotor _runMotorCommand = new RunMotor();
  private final RunServo _runServoCommand = new RunServo();
  private final HomeServo _homeServoCommand = new HomeServo();

  private final RunMotorWithController _runMotorWithControllerCommand = new RunMotorWithController();
  private final ToggleSolenoid _toggleSolenoidCommand = new ToggleSolenoid();
  private final SetRotationalServoAngle _runRotationalServoCommand = new SetRotationalServoAngle(RobotMap.ROTATIONAL_SERVO_ANGLE);
  private final SetRotationalServoAngle _homeRotationalServoCommand = new SetRotationalServoAngle(RobotMap.ROTATIONAL_SERVO_HOME_ANGLE);
  private final RunMotorWithButton _runMotorWithButtonCommand = new RunMotorWithButton();
  private final SetRotationalServoWithController _setRotationalServoWithControllerCommand = new SetRotationalServoWithController();
  private final RunMotorWithSensor _runMotorWithSensorCommand = new RunMotorWithSensor();



  /**
   * The container for the robot.  Contains subsystems, OI devices, and commands.
   */
  public RobotContainer() {
    // Configure the button bindings
    configureButtonBindings();
  }

  /**
   * Use this method to define your button->command mappings.  Buttons can be created by
   * instantiating a {@link GenericHID} or one of its subclasses ({@link
   * edu.wpi.first.wpilibj.Joystick} or {@link XboxController}), and then passing it to a
   * {@link edu.wpi.first.wpilibj2.command.button.JoystickButton}.
   */
  private void configureButtonBindings() {
  }


  /**
   * Use this to pass the autonomous command to the main {@link Robot} class.
   *
   * @return the command to run in autonomous
   */
  public Command getRunMotorCommand() {
    return _runMotorCommand;
  }
  public Command getRunServoCommand() {
    return _runServoCommand;
  }
  public Command getHomeServoCommand() {
    return _homeServoCommand;
  }
  public Command getToggleSolenoidCommand() {
    return _toggleSolenoidCommand;
  }
  public Command getRunRotationalServoCommand() {
    return _runRotationalServoCommand;
  }
  public Command getHomeRotationalServoCommand() {
    return _homeRotationalServoCommand;
  }
  public Command getRunMotorWithButtonCommand() {
    return _runMotorWithButtonCommand;
  }
  public Command getRunMotorWithControllerCommand() {
    return _runMotorWithControllerCommand;
  }
  public Command getSetRotationalServoWithControllerCommand() {
    return _setRotationalServoWithControllerCommand;
  }
  public Command getRunMotorWithSensorCommand() {
    return _runMotorWithSensorCommand;
  }
}
