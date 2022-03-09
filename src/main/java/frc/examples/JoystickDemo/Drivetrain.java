package frc.examples.JoystickDemo;

import edu.wpi.first.math.controller.PIDController;
import edu.wpi.first.math.controller.SimpleMotorFeedforward;
import edu.wpi.first.math.kinematics.ChassisSpeeds;
import edu.wpi.first.math.kinematics.DifferentialDriveKinematics;
import edu.wpi.first.math.kinematics.DifferentialDriveOdometry;
import edu.wpi.first.math.kinematics.DifferentialDriveWheelSpeeds;
import edu.wpi.first.wpilibj.AnalogGyro;
import edu.wpi.first.wpilibj.Encoder;
import edu.wpi.first.wpilibj.motorcontrol.MotorController;
import edu.wpi.first.wpilibj.motorcontrol.PWMVictorSPX;
import edu.wpi.first.wpilibj.motorcontrol.MotorControllerGroup;

public class Drivetrain {
    public static final double kMaxSpeed = 3.0; // meters per second
    public static final double kMaxAngularSpeed = 2 * Math.PI; //one rotation per second
    
    private static final double kWheelRadius = 0.0508; // meters
    private static final int kEncoderResolution = 4096;

    private final MotorController m_leftLeader = new PWMVictorSPX(1);
    private final MotorController m_leftFollower = new PWMVictorSPX(2);
    private final MotorController m_rightLeader = new PWMVictorSPX(3);
    private final MotorController m_rightFollower = new PWMVictorSPX(4);
  
    private final Encoder m_leftEncoder = new Encoder(0, 1);
    private final Encoder m_rightEncoder = new Encoder(2, 3);

    private final AnalogGyro m_gyro = new AnalogGyro(0);

    //grouping the left and right motor controllers together (makes it easier for setting, instead of setting both, you can set the group instead)
    private final MotorControllerGroup m_leftGroup = new MotorControllerGroup(m_leftLeader, m_leftFollower);
    private final MotorControllerGroup m_rightGroup = new MotorControllerGroup(m_rightLeader, m_rightFollower);

    public Drivetrain(){

        m_gyro.reset();
        //positive voltage result in both sides moving forward (must invert one side)
        m_rightGroup.setInverted(true);

        m_leftEncoder.setDistancePerPulse(2 * Math.PI * kWheelRadius / kEncoderResolution);
        m_rightEncoder.setDistancePerPulse(2 * Math.PI * kWheelRadius / kEncoderResolution);

        m_leftEncoder.reset();
        m_rightEncoder.reset();
    }

    public void setSpeeds(double speed) {
        m_leftGroup.setVoltage(speed);
        m_rightGroup.setVoltage(speed);
    }

    public void drive(double xSpeed, double rot){
        setSpeeds(xSpeed);
    }
}
