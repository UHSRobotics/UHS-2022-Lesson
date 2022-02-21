package frc.examples;

import edu.wpi.first.math.filter.MedianFilter;
import edu.wpi.first.wpilibj.AnalogInput;
import edu.wpi.first.wpilibj.TimedRobot;
import edu.wpi.first.wpilibj.drive.DifferentialDrive;
import edu.wpi.first.wpilibj.motorcontrol.PWMSparkMax;

public class UltrasonicDemo {
    private static final double kHoldDistance = 12.0;

    private static final double kValueToInches = 0.125;

    private static final double kP = 0.05;

    private static final int kLeftMotorPort = 0;
    private static final int kRightMotorPort = 1;
    private static final int kUltrasonicPort = 0;

    private final static MedianFilter m_filter = new MedianFilter(10);

    private final static AnalogInput m_ultrasonic = new AnalogInput(kUltrasonicPort);
    private final static DifferentialDrive m_robotDrive =
      new DifferentialDrive(new PWMSparkMax(kLeftMotorPort), new PWMSparkMax(kRightMotorPort));

    
    public static void ultrasonicPeriodic() {
        double currentDistance = m_filter.calculate(m_ultrasonic.getValue()) * kValueToInches;
        double currentSpeed = (currentDistance - kHoldDistance) * kP;
        m_robotDrive.arcadeDrive(currentSpeed, 0);
    }
}
