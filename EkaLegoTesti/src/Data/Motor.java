package Data;

import lejos.hardware.motor.UnregulatedMotor;
import lejos.hardware.port.MotorPort;
import lejos.hardware.motor.*;

public class Motor{
	
	public String nimi;
	
	UnregulatedMotor motorA = new UnregulatedMotor(MotorPort.A);
	UnregulatedMotor motorD = new UnregulatedMotor(MotorPort.D);

	
	public Motor(String nimi)
	{
		this.nimi = nimi;
	}

}
