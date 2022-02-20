package frc.examples;

import edu.wpi.first.wpilibj.AnalogGyro;
import edu.wpi.first.wpilibj.Joystick;
import edu.wpi.first.wpilibj.TimedRobot;
import edu.wpi.first.wpilibj.drive.DifferentialDrive;
import edu.wpi.first.wpilibj.motorcontrol.PWMSparkMax;

public class GyroDrive {
    private static final double kAngleSetpoint = 0.0;
    private static final double kP = 0.005; 

    private static final double kVoltsPerDegreePerSecond = 0.0128;

    private static final int kLeftMotorPort = 0;
    private static final int kRightMotorPort = 1;
    private static final int kGyroPort = 0;
    private static final int kJoystickPort = 0;

    private static final PWMSparkMax m_leftDrive = new PWMSparkMax(kLeftMotorPort);
    private static final PWMSparkMax m_rightDrive = new PWMSparkMax(kRightMotorPort);
    private static final DifferentialDrive m_myRobot = new DifferentialDrive(m_leftDrive, m_rightDrive);
    private static final AnalogGyro m_gyro = new AnalogGyro(kGyroPort);
    private static final Joystick m_joystick = new Joystick(kJoystickPort);

    public static void initGyro() {
        m_gyro.setSensitivity(kVoltsPerDegreePerSecond);
        m_rightDrive.setInverted(true);
    }

    public static void gyroPeriodic() {
        double turningValue = (kAngleSetpoint - m_gyro.getAngle()) * kP;
        turningValue = Math.copySign(turningValue, m_joystick.getY());
        m_myRobot.arcadeDrive(-m_joystick.getY(), turningValue);
    }
  
}
