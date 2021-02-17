package Data;

import lejos.hardware.motor.UnregulatedMotor;
import lejos.hardware.port.MotorPort;
import lejos.hardware.motor.*;

public class Motor implements Runnable{
	
	public String nimi;
	
	UnregulatedMotor motorA = new UnregulatedMotor(MotorPort.A);

	@Override
	public void run() {
		
		System.out.println(nimi + " start");
		motorA.setPower(50);
		motorA.forward();
		
	}
	
	public Motor(String nimi)
	{
		this.nimi = nimi;
	}

}
