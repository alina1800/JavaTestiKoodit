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
			float colorLine = colorSample[2]*1000;
			Delay.msDelay(10);
			
			//Haetaan myˆs punainen v‰ri pys‰ytyst‰ varten
			
			int colorRed = Color.RED;
			int currentColor = sensor.getColorID();
		
			//Tehd‰‰n if-lauseet, jotta robotti pysyisi viivan tuntumassa
			//Jos v‰ri on punainen pys‰ytet‰‰n robotti
			motorA.setPower(30);
			motorD.setPower(30);
			//motorA.forward();
			//motorD.forward();
			
		
			if(colorLine > 70)  //Jos valkoisella
			{
				motorA.setPower(30);
				motorD.setPower(0);
				motorA.forward();
				motorD.forward();
			}
			else if(colorLine < 30)  //Jos mustalla
			{
				motorA.setPower(0);
				motorD.setPower(30);
				motorA.forward();
				motorD.forward();
			}
			else if(currentColor == colorRed)  //Jos v‰ri on punainen, pys‰hdyt‰‰n ja lopetetaan loop
			{
				motorA.setPower(0);
				motorD.setPower(0);
				motorA.close();
				motorD.close();
				sensor.close();
				break;
			}
			else if(colorLine < 70 && colorLine > 30)  //Jos viivalla
			{
				motorA.setPower(30);
				motorD.setPower(30);
				motorA.forward();
				motorD.forward();
			}
			
			
			
			
			//Eri v‰rien haku, mutta t‰t‰ ei kannata k‰ytt‰‰, vaan valon intensiivisyytt‰ (light intensity)
			//J‰t‰n t‰m‰n t‰h‰n testej‰ varten
			
			/* int colorBlack = Color.BLACK;
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
			} */
		}
		
		//motorA.close();
		//motorD.close();
		
		
	}

}
