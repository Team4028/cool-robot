/*----------------------------------------------------------------------------*/
/* Copyright (c) 2019 FIRST. All Rights Reserved.                             */
/* Open Source Software - may be modified and shared by FRC teams. The code   */
/* must be accompanied by the FIRST BSD license file in the root directory of */
/* the project.                                                               */
/*----------------------------------------------------------------------------*/

package frc.robot.subsystems;

import edu.wpi.first.wpilibj.Servo;
import edu.wpi.first.wpilibj.geometry.Rotation2d;
import edu.wpi.first.wpilibj2.command.SubsystemBase;
import frc.robot.RobotMap;

public class RotationalServoSubsystem extends SubsystemBase {
  /**
   * Creates a new RotationalServoSubsystem.
   */
  private static Servo _servo;
  private RobotController _controller;
  private static RotationalServoSubsystem _instance = new RotationalServoSubsystem();
  public RotationalServoSubsystem() {
    _servo = new Servo(RobotMap.ROTATIONAL_SERVO_CHANNEL);
    _controller = new RobotController(RobotMap.CONTROLLER_PORT);
  }

  public void setAngleWithController() {
    double XAxis = _controller.getRightXAxis();
    double YAxis = _controller.getRightYAxis();
    Rotation2d rot = new Rotation2d(XAxis, YAxis);
    double angle = rot.getDegrees() + 135;
    setAngle(angle);
  }

  public void setAngle(double angle) {
    _servo.setAngle(angle);
  }

  public static RotationalServoSubsystem getInstance() {
    return _instance;
  }

  @Override
  public void periodic() {
    // This method will be called once per scheduler run
  }
}
