package frc.examples;

import edu.wpi.first.wpilibj.CounterBase;
import edu.wpi.first.wpilibj.Encoder;
import edu.wpi.first.wpilibj.TimedRobot;

public class EncoderDemo {
    private static final Encoder m_encoder = new Encoder(1, 2, false, CounterBase.EncodingType.k4X);

    public static void initEncoder() {
        m_encoder.setDistancePerPulse(1.0 / 360.0 * 2.0 * Math.PI * 1.5);
        m_encoder.setMinRate(1.0);
    }
}
