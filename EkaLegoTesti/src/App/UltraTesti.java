package App;

import Data.*;
import lejos.hardware.motor.UnregulatedMotor;
import lejos.hardware.port.MotorPort;
import lejos.hardware.port.SensorPort;
import lejos.utility.Delay;

public class UltraTesti {

	public static void main(String[] args) {
	
		//Luodaan moottorit
		
		UnregulatedMotor motorA = new UnregulatedMotor(MotorPort.A);
		UnregulatedMotor motorD = new UnregulatedMotor(MotorPort.D);

		//Luodaan ultraäänisensori
		float                range;
        UltraSonicSensor     uss = new UltraSonicSensor(SensorPort.S4);
    
        //Haetaan matka kohteeseen
        
        range = uss.getRange();

       // Lcd.print(7, "range=");

        // run until we find an obstacle within 1/4 of a meter.
        
        while (range > .25)
        {
           // Lcd.clear(7, 7, 10);
           // Lcd.print(7, 7, "%.3f", range);
        	System.out.println(range);
            Delay.msDelay(500);

            range = uss.getRange();
            
            //Käynnistetään myös moottorit
            
            motorA.setPower(50);
    		motorA.forward();
    		motorD.setPower(50);
    		motorD.forward();
        }
        
        // free up resources.
       
        motorA.close();
        motorD.close();
        uss.close();
	}

}
