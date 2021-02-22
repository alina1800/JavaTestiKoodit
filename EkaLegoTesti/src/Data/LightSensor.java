package Data;

import lejos.hardware.BrickFinder;
import lejos.hardware.Button;
import lejos.hardware.lcd.LCD;
import lejos.hardware.motor.UnregulatedMotor;
import lejos.hardware.port.MotorPort;
import lejos.hardware.port.Port;
import lejos.hardware.sensor.EV3ColorSensor;
import lejos.hardware.sensor.SensorMode;
import lejos.robotics.Color;
import lejos.robotics.SampleProvider;
import lejos.utility.Delay;


public class LightSensor implements Runnable{
	
	EV3ColorSensor sensor;
	SampleProvider colorProvider;
	float[] colorSample;
	
	public LightSensor()
	{
		
		
	}

	@Override
	public void run() {
		
	//	LCD.clear();
	//	LCD.drawString("Color sensor on", 2,2);
		
		//Tehd‰‰n moottorit testi‰ varten, jotta niit‰ voidaan k‰ytt‰‰ k‰‰ntymisess‰
		UnregulatedMotor motorA = new UnregulatedMotor(MotorPort.A);
		UnregulatedMotor motorD = new UnregulatedMotor(MotorPort.D);
		
		//Luodaan portti s1
       Port s1 = BrickFinder.getLocal().getPort("S1");
		
       //Luodaan sensori ja sille RGB arvojen hakija sek‰ taulukko, johon arvot tallennetaan
		sensor = new EV3ColorSensor(s1);
		colorProvider = sensor.getRGBMode();
		colorSample = new float[colorProvider.sampleSize()];
		
		
		while(Button.ESCAPE.isUp())
		{
			//Haetaan eri v‰rien arvot
			//Tummilla v‰reill‰ on pienempi arvo, kuin vaaleilla
			//V‰rin arvon mukaan voidaan m‰‰ritt‰‰ ollaanko mustalla vai valkoisella alueella
			//Kun ollaan viivan reunalla light intensity on 35%
			colorProvider.fetchSample(colorSample, 0);
			System.out.println("Red: " + (colorSample[0]*1000));
			System.out.println("Green: " + (colorSample[1]*1000));
			System.out.println("Blue: " + (colorSample[2]*1000));
			Delay.msDelay(250);
		
			//Eri v‰rien haku, mutta t‰t‰ ei kannata k‰ytt‰‰, vaan valon intensiivisyytt‰ (light intensity)
			int colorBlack = Color.BLACK;
			int colorWhite = Color.WHITE;
			
			int currentColor = sensor.getColorID();
			
			if(currentColor == colorBlack)
			{
				motorA.setPower(30);
				motorD.setPower(30);
				motorA.forward();
				motorD.forward();
			}
			else if(currentColor == colorWhite)
			{
				motorA.setPower(30);
				motorD.setPower(30);
				motorA.backward();
				motorD.backward();
			}
		}
		
		motorA.close();
		motorD.close();
		
		
	}

}
