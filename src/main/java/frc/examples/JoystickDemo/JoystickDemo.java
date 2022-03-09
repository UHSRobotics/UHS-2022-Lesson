package frc.examples.JoystickDemo;

import edu.wpi.first.math.filter.SlewRateLimiter;
import edu.wpi.first.wpilibj.TimedRobot;
import edu.wpi.first.wpilibj.XboxController;
// usually we use PS4 controller:
// import edu.wpi.first.wpilibj.PS4Controller;
import edu.wpi.first.wpilibj.drive.DifferentialDrive;
import edu.wpi.first.wpilibj.motorcontrol.PWMSparkMax;

public class JoystickDemo {
    private static final XboxController m_controller = new XboxController(0);
    private static final Drivetrain m_drive = new Drivetrain();


    private double[] controllerMapping;
    public static final int controllerPrecision = 1000;

    public void initMapping(double curvature){
        controllerMapping = new double[controllerPrecision + 5];
        double tempX, w2, w1 = Math.exp(curvature * (-0.1));
        for (int i = 0; i < controllerMapping.length; i++) {
          // mapping i (probally 0 to 1000) to -1 to 1
          tempX = (i - (controllerPrecision / 2.0)) / (controllerPrecision / 2.0);
          w2 = w1 + Math.exp(10.0 * (Math.abs(tempX) - 1)) * (1 - w1);
          controllerMapping[i] = tempX * w2;
        }

    }
    public static void joystickPeriodic(){
        final var xSpeed = m_controller.getLeftY() * Drivetrain.kMaxSpeed;
        final var rot = m_controller.getRightX() * Drivetrain.kMaxAngularSpeed;

        m_drive.drive(xSpeed, rot);
    }

}


