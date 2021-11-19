/*----------------------------------------------------------------------------*/
/* Copyright (c) 2019 FIRST. All Rights Reserved.                             */
/* Open Source Software - may be modified and shared by FRC teams. The code   */
/* must be accompanied by the FIRST BSD license file in the root directory of */
/* the project.                                                               */
/*----------------------------------------------------------------------------*/

package frc.robot.subsystems;

import com.ctre.phoenix.motorcontrol.ControlMode;
import com.ctre.phoenix.motorcontrol.FeedbackDevice;
import com.ctre.phoenix.motorcontrol.LimitSwitchNormal;
import com.ctre.phoenix.motorcontrol.LimitSwitchSource;
import com.ctre.phoenix.motorcontrol.can.TalonSRX;

import edu.wpi.first.wpilibj2.command.SubsystemBase;
import frc.robot.RobotMap;
import frc.robot.subsystems.RobotController;

public class Motor extends SubsystemBase {
  /**
   * Creates a new motor.
   */
  private TalonSRX _m;
  private static Motor _instance = new Motor();
  private RobotController _controller;
  public static Motor getInstance() {
    return _instance;
  }
  public Motor() {
    _m = new TalonSRX(RobotMap.MOTOR_NUMBER);
    _m.configFactoryDefault();
    _m.configSelectedFeedbackSensor(FeedbackDevice.QuadEncoder);
    _m.configForwardLimitSwitchSource(LimitSwitchSource.FeedbackConnector, LimitSwitchNormal.NormallyOpen);
    _controller = new RobotController(RobotMap.CONTROLLER_PORT);

    _m.selectProfileSlot(0, 0);
    _m.config_kF(0, 0.1118);
    _m.config_kP(0, 1.44);
    _m.config_kI(0, 0.002);
    _m.config_kD(0, 0);
    _m.config_IntegralZone(0, 50);

    _m.configMotionCruiseVelocity(3661);
    _m.configMotionAcceleration(1800);
  }

  public void zeroEncoder() {
    _m.setSelectedSensorPosition(0);
  }

  public void runMotor(double speedPercent) {
    _m.set(ControlMode.PercentOutput, speedPercent);
  }

  public void stopMotor() {
    _m.set(ControlMode.PercentOutput, 0.);
  }

  public void runMotorWithSensor() {
    int pos = _m.getSelectedSensorPosition(0);
    System.out.println(pos);
    if (pos < 69632) {
      runMotor(0.4);
    } else {
      stopMotor();
    }
  }

  public void runMotorWithButton() {
    if (!RobotMap._button.get()) {
      runMotor(0.5);
    } else {
      stopMotor();
    }
  }

  public void runMotorMotionMagic() {
    double targetPos = 4096 * 10.;
    System.out.println("\tTarget: " + targetPos);
    System.out.println("\tError: " + _m.getClosedLoopError(0));
    _m.set(ControlMode.MotionMagic, targetPos);
  }

  public void runMotorWithController() {
    double XAxis = _controller.getLeftXAxis();
    double left = -(_controller.getLeftTrigger());
    double right = _controller.getRightTrigger();
    double netSpeed = 0;// = left / 2 + right / 2 + 
    int totalAxes = 0;
    if (XAxis != 0) {
      netSpeed += XAxis / 2;
      totalAxes++;
    }
    if (left < 0) {
      netSpeed += left / 2;
      totalAxes++;
    }
    if (right > 0) {
      netSpeed += right / 2;
      totalAxes++;
    }

    if (totalAxes == 0) {
      netSpeed = 0;
    } else if (totalAxes != 2) {
      netSpeed *= 2;
    }

    System.out.println(netSpeed);

    runMotor(netSpeed);
  }

  @Override
  public void periodic() {
    // This method will be called once per scheduler run
  }
}
