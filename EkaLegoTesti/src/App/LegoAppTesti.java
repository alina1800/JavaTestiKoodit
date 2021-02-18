package App;
import Data.*;

import lejos.hardware.Button;

public class LegoAppTesti {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		
		
		System.out.println("Moi Jenni!");
		System.out.println("Moi Liisa!");
		System.out.println("Moi Alina!");
		System.out.println("Moi Sanna!");
	
		Button.waitForAnyPress();
		
		Motor moottori1 = new Motor("Moottori 1");
		
		Thread motorThread = new Thread(moottori1);
		
		motorThread.start();
		Button.waitForAnyPress();
		
		

	}

}
