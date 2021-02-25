/*package App;

import Data.*;
import lejos.hardware.motor.UnregulatedMotor;
import lejos.hardware.port.MotorPort;
import lejos.hardware.port.SensorPort;
import lejos.utility.Delay;

public class UltraTesti {

	public static void main(String[] args) {
	
		
		UnregulatedMotor motorA = new UnregulatedMotor(MotorPort.A);
		UnregulatedMotor motorD = new UnregulatedMotor(MotorPort.D);

		float                range;
        UltraSonicSensor     uss = new UltraSonicSensor(SensorPort.S4);
        
        //Luodaan moottori ja tehdään siitä moottori-säie
        
        
        range = uss.getRange();

       // Lcd.print(7, "range=");

        // run until we find an obstacle within 1/4 of a meter.
        
        while (range > .25)
        {
        	System.out.println(range);
            Delay.msDelay(500);

            range = uss.getRange();
            
            //Käynnistetään myös moottori
            
            motorA.setPower(50);
    		motorA.forward();
    		motorD.setPower(50);
    		motorD.forward();
        }
       
        motorA.close();
        motorD.close();
        uss.close();
	}

}*/
