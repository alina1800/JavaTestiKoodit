package App;
import Data.*;

import lejos.hardware.Button;

public class ValoTestiApp {

	public static void main(String[] args) {
		
		LightSensor sensor1 = new LightSensor();
		
		Thread sensorThread = new Thread(sensor1);
		
		sensorThread.start();
		
		Button.waitForAnyPress();
		

	}

}
