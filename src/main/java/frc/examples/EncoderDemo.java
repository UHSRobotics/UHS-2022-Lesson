package frc.examples;

import edu.wpi.first.wpilibj.CounterBase;
import edu.wpi.first.wpilibj.Encoder;
import edu.wpi.first.wpilibj.TimedRobot;

public class EncoderDemo {
    private static final Encoder m_encoder = new Encoder(1, 2, false, CounterBase.EncodingType.k4X);

    public static void initEncoder() {
        // 4 degrees per pulse, 20
        m_encoder.setDistancePerPulse(4/360 * 2 * Math.PI * 20);
        m_encoder.setMinRate(1.0);
    }
}
