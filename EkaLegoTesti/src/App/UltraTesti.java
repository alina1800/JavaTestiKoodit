package App;

import Data.*;
import lejos.hardware.motor.UnregulatedMotor;
import lejos.hardware.port.MotorPort;
import lejos.hardware.port.SensorPort;
import lejos.utility.Delay;

public class UltraTesti {

	public static void main(String[] args) {
	
		Distance ultraDistance = new Distance();
		
		Thread ultraThread = new Thread(ultraDistance);
        
		ultraThread.start();
       
	}
}
