package frc.examples;

import edu.wpi.first.wpilibj.DoubleSolenoid;
import edu.wpi.first.wpilibj.Solenoid;

import edu.wpi.first.wpilibj.Joystick;
import edu.wpi.first.wpilibj.PneumaticsControlModule;
import edu.wpi.first.wpilibj.PneumaticsModuleType;
import edu.wpi.first.wpilibj.motorcontrol.MotorController;
import edu.wpi.first.wpilibj.motorcontrol.PWMSparkMax;

public class SolenoidDemo {
    private static final Solenoid m_solenoid = new Solenoid(PneumaticsModuleType.CTREPCM, 0);
    private static final Joystick m_stick = new Joystick(0);
    private static final DoubleSolenoid m_doubleSolenoid = new DoubleSolenoid(PneumaticsModuleType.CTREPCM, 1, 2);

    private static final int kSolenoidButton = 1;
    private static final int kDoubleSolenoidForward = 2;
    private static final int kDoubleSolenoidReverse = 3;

    // if you press two buttons at once both wont run since its if and else if (sets to forward if you press both)
    // detects you press which button (forward/reverse)
    public static void setSolenoid() {
        // gets the input of the joystick (button) returns 0/1 false/true single port solenoid, only two states 
        m_solenoid.set(m_stick.getRawButton(kSolenoidButton));
        if (m_stick.getRawButton(kDoubleSolenoidForward)) {
            // sets the solenoid
            m_doubleSolenoid.set(DoubleSolenoid.Value.kForward);
          } else if (m_stick.getRawButton(kDoubleSolenoidReverse)) {
            m_doubleSolenoid.set(DoubleSolenoid.Value.kReverse);
          }
    }
}
