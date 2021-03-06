// Copyright (c) FIRST and other WPILib contributors.
// Open Source Software; you can modify and/or share it under the terms of
// the WPILib BSD license file in the root directory of this project.

package frc.robot;

import edu.wpi.first.wpilibj.Joystick;
import edu.wpi.first.wpilibj.TimedRobot;
import frc.examples.EncoderDemo;
import frc.examples.GyroDrive;
import frc.examples.MotorControl;
import frc.examples.SolenoidDemo;
import frc.examples.UltrasonicDemo;
import frc.examples.JoystickDemo.JoystickDemo;

/**
 * The VM is configured to automatically run this class, and to call the functions corresponding to
 * each mode, as described in the TimedRobot documentation. If you change the name of this class or
 * the package after creating this project, you must also update the build.gradle file in the
 * project.
 */
public class Robot extends TimedRobot {

  /**
   * This function is run when the robot is first started up and should be used for any
   * initialization code.
   */
  @Override
  public void robotInit() {
    MotorControl.initControl();
    GyroDrive.initGyro();
    EncoderDemo.initEncoder();
  }

  /** This function is called periodically during operator control. */
  @Override
  public void teleopPeriodic() {
    // SEE MOTOR CONTROL FILE FOR MORE
    MotorControl.setMotor();
    // SEE SOLENOID FILE FOR MORE
    SolenoidDemo.setSolenoid();
    // SEE GYRODRIVE FILE FOR MORE
    GyroDrive.gyroPeriodic();

    UltrasonicDemo.ultraSonicPeriodic();

    JoystickDemo.joystickPeriodic();
  }
}