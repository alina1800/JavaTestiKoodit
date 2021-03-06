package App;
import Data.*;

import lejos.hardware.Button;
import lejos.hardware.lcd.LCD;
import lejos.hardware.port.SensorPort;
import lejos.utility.Delay;

public class LegoAppTesti {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		
	
		//Luodaan v‰risensori ja tehd‰‰n s‰ie
		
		LightSensor sensor1 = new LightSensor();
		
		Thread sensorThread = new Thread(sensor1);
		
		//Tehd‰‰n ultra‰‰nisensori ja siit‰ s‰ie
		
		Distance ultraDistance = new Distance();
		
		Thread ultraThread = new Thread(ultraDistance);
		
		//K‰ynnistet‰‰n s‰ikeet
        
		//ultraThread.start();
		sensorThread.start();
		
		
		//Button.waitForAnyPress();
		
		

	}

}
