/*----------------------------------------------------------------------------*/
/* Copyright (c) 2017-2019 FIRST. All Rights Reserved.                        */
/* Open Source Software - may be modified and shared by FRC teams. The code   */
/* must be accompanied by the FIRST BSD license file in the root directory of */
/* the project.                                                               */
/*----------------------------------------------------------------------------*/

package frc.robot;

import edu.wpi.first.wpilibj.TimedRobot;
import edu.wpi.first.wpilibj2.command.Command;
import edu.wpi.first.wpilibj2.command.CommandScheduler;
import frc.robot.commands.RunMotor;
import frc.robot.commands.RunMotorWithController;
import frc.robot.commands.RunMotorWithSensor;
import frc.robot.commands.RunServo;
import frc.robot.subsystems.Motor;
import frc.robot.subsystems.ServoSubsystem;
import frc.robot.subsystems.SolenoidSubsystem;

/**
 * The VM is configured to automatically run this class, and to call the functions corresponding to
 * each mode, as described in the TimedRobot documentation. If you change the name of this class or
 * the package after creating this project, you must also update the build.gradle file in the
 * project.
 */
public class Robot extends TimedRobot {
  private RobotContainer m_robotContainer;
  private Motor _motorSubsystem;
  private ServoSubsystem _servoSubsystem;
  private SolenoidSubsystem _solenoidSubsystem;

  private Command _runServoCommand;
  private Command _runMotorCommand;
  private Command _homeServoCommand;
  private Command _toggleSolenoidCommand;
  private Command _runRotationalServoCommand;
  private Command _homeRotationalServoCommand;
  private Command _runMotorWithButtonCommand;
  private Command _runMotorWithControllerCommand;
  private Command _setRotationalServoWithControllerCommand;
  private Command _runMotorWithSensorCommand;

  /**
   * This function is run when the robot is first started up and should be used for any
   * initialization code.
   */
  @Override
  public void robotInit() {
    // Instantiate our RobotContainer.  This will perform all our button bindings, and put our
    // autonomous chooser on the dashboard.
    m_robotContainer = new RobotContainer();
    _motorSubsystem = Motor.getInstance();
    _servoSubsystem = ServoSubsystem.getInstance();
    _solenoidSubsystem = SolenoidSubsystem.getInstance();
  }

  /**
   * This function is called every robot packet, no matter the mode. Use this for items like
   * diagnostics that you want ran during disabled, autonomous, teleoperated and test.
   *
   * <p>This runs after the mode specific periodic functions, but before
   * LiveWindow and SmartDashboard integrated updating.
   */
  @Override
  public void robotPeriodic() {
    // Runs the Scheduler.  This is responsible for polling buttons, adding newly-scheduled
    // commands, running already-scheduled commands, removing finished or interrupted commands,
    // and running subsystem periodic() methods.  This must be called from the robot's periodic
    // block in order for anything in the Command-based framework to work.
    CommandScheduler.getInstance().run();
  }

  /**
   * This function is called once each time the robot enters Disabled mode.
   */
  @Override
  public void disabledInit() {
  }

  @Override
  public void disabledPeriodic() {
  }

  /**
   * This autonomous runs the autonomous command selected by your {@link RobotContainer} class.
   */
  @Override
  public void autonomousInit() {
    // schedule the autonomous command (example)
    /*_homeServoCommand = m_robotContainer.getHomeServoCommand();
    _homeServoCommand.schedule();

    _toggleSolenoidCommand = m_robotContainer.getToggleSolenoidCommand();
    _toggleSolenoidCommand.schedule();*/

    //_homeRotationalServoCommand = m_robotContainer.getHomeRotationalServoCommand();
    //_homeRotationalServoCommand.schedule();

    _runMotorWithSensorCommand = new RunMotorWithSensor();
  }

  /**
   * This function is called periodically during autonomous.
   */
  @Override
  public void autonomousPeriodic() {
    _runMotorWithSensorCommand.schedule();
  }

  @Override
  public void teleopInit() {
    // This makes sure that the autonomous stops running when
    // teleop starts running. If you want the autonomous to
    // continue until interrupted by another command, remove
    // this line or comment it out.

    //_runServoCommand = m_robotContainer.getRunServoCommand();
    //_runServoCommand.schedule();
    _setRotationalServoWithControllerCommand = m_robotContainer.getSetRotationalServoWithControllerCommand();
    _setRotationalServoWithControllerCommand.schedule();
    // _runMotorCommand = m_robotContainer.getRunMotorCommand();
    // _runMotorCommand.schedule();
    // _runRotationalServoCommand = m_robotContainer.getRunRotationalServoCommand();
    // _runRotationalServoCommand.schedule();*/

    /*_runMotorWithButtonCommand = m_robotContainer.getRunMotorWithButtonCommand();
    _runMotorWithButtonCommand.schedule();*/
    _runMotorWithControllerCommand = m_robotContainer.getRunMotorWithControllerCommand();
    _runMotorWithControllerCommand.schedule();
    //_toggleSolenoidCommand = m_robotContainer.getToggleSolenoidCommand();
    //_toggleSolenoidCommand.schedule();
  }

  /**
   * This function is called periodically during operator control.
   */
  @Override
  public void teleopPeriodic() {
    // _runMotorCommand.schedule();
    //_runServoCommand.schedule();
    //_runRotationalServoCommand.schedule();
    _setRotationalServoWithControllerCommand.schedule();
    //_runMotorWithControllerCommand.schedule();
    //_toggleSolenoidCommand.schedule();
    _solenoidSubsystem.toggleSolenoidWithController();
    //_motorSubsystem.runMotorWithController();
    _motorSubsystem.runMotorWithButton();
    _servoSubsystem.setServoWithController();
  }

  @Override
  public void testInit() {
    // Cancels all running commands at the start of test mode.
    CommandScheduler.getInstance().cancelAll();
  }

  /**
   * This function is called periodically during test mode.
   */
  @Override
  public void testPeriodic() {
  }
}
