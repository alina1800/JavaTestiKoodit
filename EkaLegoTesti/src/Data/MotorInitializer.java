package Data;

import java.util.Timer;

import lejos.hardware.motor.UnregulatedMotor;
import lejos.hardware.port.MotorPort;
import lejos.hardware.port.SensorPort;

public class MotorInitializer {

	/**
	 * Raja-arvojen kokeilua
	 */
	protected final float threshLow = 0.07f;
	protected final float threshMedLow = 0.12f;
	protected final float threshMedHigh = 0.28f;
	protected final float threshHigh = 0.36f;

	/**
	 *  Moottoreiden kontrolloiminen oliot
	 */
	UnregulatedMotor motorA = new UnregulatedMotor(MotorPort.A);
	UnregulatedMotor motorD = new UnregulatedMotor(MotorPort.D);
}
