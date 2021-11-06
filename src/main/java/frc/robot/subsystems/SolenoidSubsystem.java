/*----------------------------------------------------------------------------*/
/* Copyright (c) 2019 FIRST. All Rights Reserved.                             */
/* Open Source Software - may be modified and shared by FRC teams. The code   */
/* must be accompanied by the FIRST BSD license file in the root directory of */
/* the project.                                                               */
/*----------------------------------------------------------------------------*/

package frc.robot.subsystems;

import edu.wpi.first.wpilibj.DoubleSolenoid;
import edu.wpi.first.wpilibj.DoubleSolenoid.Value;
import edu.wpi.first.wpilibj.GenericHID.Hand;
import edu.wpi.first.wpilibj2.command.SubsystemBase;
import frc.robot.RobotMap;

public class SolenoidSubsystem extends SubsystemBase {
  /**
   * Creates a new SolenoidSubsystem.
   */
  private RobotController _controller;
  private static DoubleSolenoid _solenoid;
  private Value _lastVal = Value.kOff;
  private static SolenoidSubsystem _instance = new SolenoidSubsystem();
  public SolenoidSubsystem() {
    _solenoid = new DoubleSolenoid(RobotMap.FORWARD_CHANNEL, RobotMap.REVERSE_CHANNEL);
    _controller = new RobotController(RobotMap.CONTROLLER_PORT);
  }

  public void setForward() {
    _solenoid.set(Value.kForward);
  }

  public void setReverse() {
    _solenoid.set(Value.kReverse);
  }
  
  public void toggleSolenoid() {
    switch(_lastVal) {
      case kReverse:
        setForward();
        _lastVal = Value.kForward;
        break;
      default:
        setReverse();
        _lastVal = Value.kReverse;
        break;
    }
  }

  public void toggleSolenoidWithButton() {
    if (!RobotMap._button.get()) {
      setForward();
    } else {
      setReverse();
    }
  }

  public void toggleSolenoidWithController() {
    System.out.println("cope");
    if (_controller.getXButtonPressed()) {
      toggleSolenoid();
    }
    if (_controller.getBButtonPressed()) {
      _solenoid.set(Value.kOff);
      switch (_lastVal) {
        case kReverse:
          _lastVal = Value.kForward;
          break;
        default:
          _lastVal = Value.kReverse;
          break;
      }
    }
    if (_controller.getBumperPressed(Hand.kLeft)) {
      setForward();
      _lastVal = Value.kForward;
    }
    else if (_controller.getBumperPressed(Hand.kRight)) {
      setReverse();
      _lastVal = Value.kReverse;
    }
  }

  public static SolenoidSubsystem getInstance() {
    return _instance;
  }

  @Override
  public void periodic() {
    // This method will be called once per scheduler run
  }
}
