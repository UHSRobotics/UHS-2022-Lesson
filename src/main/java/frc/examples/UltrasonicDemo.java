package frc.examples;

import edu.wpi.first.math.filter.MedianFilter;
import edu.wpi.first.wpilibj.drive.DifferentialDrive;
import edu.wpi.first.wpilibj.motorcontrol.PWMSparkMax;
import edu.wpi.first.wpilibj.AnalogInput;
import edu.wpi.first.wpilibj.TimedRobot;

public class UltrasonicDemo {
    // distance we want robot to be away from obj
    private static final double kHoldDistance = 12.0;

    private static final double kValueToInches = 0.125;

    // error constant (you tune this)
    private static final double kP = 0.05;

    private static final int kLeftMotorPort = 0;
    private static final int kRightMotorPort = 1;
    private static final int kUltrasonicPort = 0;

    private static final MedianFilter m_filter = new MedianFilter(10);

    private static final AnalogInput m_ultrasonic = new AnalogInput(kUltrasonicPort);
    private static final DifferentialDrive m_robotDrive = new DifferentialDrive(new PWMSparkMax(kLeftMotorPort), new PWMSparkMax(kRightMotorPort));

    public static void ultraSonicPeriodic() {
        double currentDistance = m_filter.calculate(m_ultrasonic.getValue()) * kValueToInches;
        double currentSpeed = (currentDistance - kHoldDistance) * kP;
        m_robotDrive.arcadeDrive(currentSpeed, 0);
    }
}
