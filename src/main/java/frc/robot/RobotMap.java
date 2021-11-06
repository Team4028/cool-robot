/*----------------------------------------------------------------------------*/
/* Copyright (c) 2018-2019 FIRST. All Rights Reserved.                        */
/* Open Source Software - may be modified and shared by FRC teams. The code   */
/* must be accompanied by the FIRST BSD license file in the root directory of */
/* the project.                                                               */
/*----------------------------------------------------------------------------*/

package frc.robot;

import edu.wpi.first.wpilibj.DigitalInput;

/**
 * Add your docs here.
 */
public class RobotMap {
    public static final int MOTOR_NUMBER = 2;
    public static final int ROTATIONAL_SERVO_CHANNEL = 0;
    public static final int SERVO_CHANNEL = 1;
    public static final int FORWARD_CHANNEL = 0; // left
    public static final int REVERSE_CHANNEL = 1; // right
    public static final int ROTATIONAL_SERVO_ANGLE = 90;
    public static final int ROTATIONAL_SERVO_HOME_ANGLE = 45;
    public static final int BUTTON_CHANNEL = 0;
    public static final int CONTROLLER_PORT = 0;
    public static final DigitalInput _button = new DigitalInput(BUTTON_CHANNEL);
}
