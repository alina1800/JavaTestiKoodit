package Data;

import lejos.hardware.motor.UnregulatedMotor;
import lejos.hardware.port.MotorPort;
import lejos.hardware.motor.*;

public class Motor implements Runnable{
	
	public String nimi;
	
	UnregulatedMotor motorA = new UnregulatedMotor(MotorPort.A);
	UnregulatedMotor motorD = new UnregulatedMotor(MotorPort.D);

	@Override
	public void run() {
		
		System.out.println(nimi + " start");
		motorA.setPower(30);
		motorA.forward();
		motorD.setPower(30);
		motorD.forward();
		
	}
	
	public Motor(String nimi)
	{
		this.nimi = nimi;
	}

}
