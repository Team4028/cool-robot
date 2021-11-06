/*----------------------------------------------------------------------------*/
/* Copyright (c) 2019 FIRST. All Rights Reserved.                             */
/* Open Source Software - may be modified and shared by FRC teams. The code   */
/* must be accompanied by the FIRST BSD license file in the root directory of */
/* the project.                                                               */
/*----------------------------------------------------------------------------*/

package frc.robot.subsystems;

import edu.wpi.first.wpilibj.Servo;
import edu.wpi.first.wpilibj2.command.SubsystemBase;
import frc.robot.RobotMap;

public class ServoSubsystem extends SubsystemBase {
  /**
   * Creates a new ServoSubsystem.
   */
  private static Servo _servo;
  //private static Linear
  private RobotController _controller;
  private static ServoSubsystem _instance = new ServoSubsystem();
  public ServoSubsystem() {
    _servo = new Servo(RobotMap.SERVO_CHANNEL);
    _controller = new RobotController(RobotMap.CONTROLLER_PORT);
  }

  public void setServo(double value) {
    _servo.set(value);
  }
  
  public void homeServo() {
    _servo.set(0.2);
  }

  public void setServoWithController() {
    double YAxis = _controller.getLeftYAxis();
    setServo(YAxis);
  }

  public static ServoSubsystem getInstance() {
    return _instance;
  }

  @Override
  public void periodic() {
    // This method will be called once per scheduler run
  }
}
