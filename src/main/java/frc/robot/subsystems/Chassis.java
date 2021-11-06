// Copyright (c) FIRST and other WPILib contributors.
// Open Source Software; you can modify and/or share it under the terms of
// the WPILib BSD license file in the root directory of this project.

package frc.robot.subsystems;

import java.lang.reflect.Array;

import com.ctre.phoenix.motorcontrol.can.TalonSRX;

import edu.wpi.first.wpilibj2.command.SubsystemBase;

public class Chassis extends SubsystemBase {
  /** Creates a new Chassis. */
  private TalonSRX _FL;
  private TalonSRX _BL;
  private TalonSRX _FR;
  private TalonSRX _BR;

  public Chassis() {
    _FL = new TalonSRX(1);
    _BL = new TalonSRX(2);
    _BL.follow(_FL);
    _FR = new TalonSRX(3);
    _FR.setInverted(true);
    _BR = new TalonSRX(4);
    _BR.follow(_FR);
  }

  @Override
  public void periodic() {
    // This method will be called once per scheduler run
  }
}
