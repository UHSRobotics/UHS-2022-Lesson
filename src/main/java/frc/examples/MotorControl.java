package frc.examples;

import edu.wpi.first.wpilibj.Joystick;
import edu.wpi.first.wpilibj.motorcontrol.MotorController;
import edu.wpi.first.wpilibj.motorcontrol.PWMSparkMax;

public class MotorControl {
    private static final int kMotorPort = 0;
    private static final int kJoystickPort = 0;
  
    private static MotorController m_motor;
    private static Joystick m_joystick;

    // declaring the joystick port and the object
    public static void initControl() {
        m_motor = new PWMSparkMax(kMotorPort);
        m_joystick = new Joystick(kJoystickPort);
    }

    // set motor speed according to the up and down value of the joystick
    public static void setMotor() {
        m_motor.set(m_joystick.getY());
    }
}
