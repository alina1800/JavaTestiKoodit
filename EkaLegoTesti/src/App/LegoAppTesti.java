package App;
import Data.*;

import lejos.hardware.Button;
import lejos.hardware.lcd.LCD;
import lejos.hardware.port.SensorPort;
import lejos.utility.Delay;

public class LegoAppTesti {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		
		float                range;
        UltraSonicSensor     uss = new UltraSonicSensor(SensorPort.S4);
        
        //Luodaan moottori ja tehdään siitä moottori-säie
        
        
        range = uss.getRange();


        // run until we find an obstacle within 1/4 of a meter.
        
        while (range > .25)
        {
        	System.out.println(range);
            Delay.msDelay(500);

            range = uss.getRange();
            
            //Käynnistetään myös moottori
            
    		
        }
        
        // free up resources.
       
        uss.close();
		
	/*	System.out.println("Hei, tervetuloa!");
		
		System.out.println("Moi Jenni!");
		System.out.println("Moi Liisa!");
		System.out.println("Moi Alina!");
		System.out.println("Moi Sanna!");
	
		Motor moottori1 = new Motor("Moottori 1");
		//Distance distance1 = new Distance("Distance");
		Thread motorThread = new Thread(moottori1);
		//Thread measureDistanceThread=new Thread(Distance);
		 * 
		motorThread.start(); 
		//measureDistanceThread.start();
		 * 
		Button.waitForAnyPress();
		
		
		*/
		Button.waitForAnyPress();
		
		

	}

}
