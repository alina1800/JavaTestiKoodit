package Data;

import lejos.hardware.motor.UnregulatedMotor;
import lejos.hardware.port.MotorPort;
import lejos.hardware.port.SensorPort;
import lejos.utility.Delay;
import lejos.hardware.motor.*;

public class Distance implements Runnable{
	
	float                range;
	
    UltraSonicSensor     uss = new UltraSonicSensor(SensorPort.S4);
    
    range = uss.getRange();
	
	UnregulatedMotor motorA = new UnregulatedMotor(MotorPort.A);
	UnregulatedMotor motorD = new UnregulatedMotor(MotorPort.D);

	@Override
	public void run() {
		
		while (range > .25)
        {
        	System.out.println(range);
            Delay.msDelay(500);

            range = uss.getRange();
        }
		uss.close();
		motorA.close();
        motorD.close();
	}
	


}
