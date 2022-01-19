// Copyright (c) FIRST and other WPILib contributors.
// Open Source Software; you can modify and/or share it under the terms of
// the WPILib BSD license file in the root directory of this project.

package frc.robot;

import edu.wpi.first.wpilibj.TimedRobot;
import edu.wpi.first.wpilibj.smartdashboard.SendableChooser;
import edu.wpi.first.wpilibj.smartdashboard.SmartDashboard;

import edu.wpi.first.wpilibj.DoubleSolenoid;
import edu.wpi.first.wpilibj.Solenoid;

import edu.wpi.first.wpilibj.Joystick;
import edu.wpi.first.wpilibj.PneumaticsControlModule;
import edu.wpi.first.wpilibj.PneumaticsModuleType;
import edu.wpi.first.wpilibj.motorcontrol.MotorController;
import edu.wpi.first.wpilibj.motorcontrol.PWMSparkMax;


/**
 * The VM is configured to automatically run this class, and to call the functions corresponding to
 * each mode, as described in the TimedRobot documentation. If you change the name of this class or
 * the package after creating this project, you must also update the build.gradle file in the
 * project.
 */
public class Robot extends TimedRobot {
  // declaring the joystick port and the object
  private final Joystick m_stick = new Joystick(0);

  // dont hard code xDDD 
  private final Solenoid m_solenoid = new Solenoid(PneumaticsModuleType.CTREPCM, 0);

  private final DoubleSolenoid m_doubleSolenoid = new DoubleSolenoid(PneumaticsModuleType.CTREPCM, 1, 2);


  private static final int kSolenoidButton = 1;
  private static final int kDoubleSolenoidForward = 2;
  private static final int kDoubleSolenoidReverse = 3;

  private static final int kMotorPort = 0;
  private static final int kJoystickPort = 0;

  private MotorController m_motor;
  private Joystick m_joystick;

  /**
   * This function is run when the robot is first started up and should be used for any
   * initialization code.
   */
  @Override
  public void robotInit() {
    m_motor = new PWMSparkMax(kMotorPort);
    m_joystick = new Joystick(kJoystickPort);
  }

  /** This function is called periodically during operator control. */
  @Override
  public void teleopPeriodic() {
    // sets the motor speed according to the up and down value of the joystick
    m_motor.set(m_joystick.getY());

    // gets the input of the joystick (button) returns 0/1 false/true single port solenoid, only two states 
    m_solenoid.set(m_stick.getRawButton(kSolenoidButton));

    // if you press two buttons at once both wont run since its if and else if (sets to forward if you press both)
    
    // detects you press which button (forward/reverse)
    if (m_stick.getRawButton(kDoubleSolenoidForward)) {
      // sets the solenoid
      m_doubleSolenoid.set(DoubleSolenoid.Value.kForward);
    } else if (m_stick.getRawButton(kDoubleSolenoidReverse)) {
      m_doubleSolenoid.set(DoubleSolenoid.Value.kReverse);
    }
  }
}