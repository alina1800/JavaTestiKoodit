package App;
import java.io.File;

import Data.*;
import lejos.hardware.Audio;
import lejos.hardware.Button;
import lejos.hardware.Sound;
import lejos.hardware.Sounds;
import lejos.hardware.motor.EV3MediumRegulatedMotor;
import lejos.hardware.motor.UnregulatedMotor;
import lejos.hardware.port.MotorPort;
import lejos.utility.Delay;

public class Testaus {

	//Luokka testauksia varten 
	
	public static void main(String[] args) {
		
		//Kokeillaan oman ‰‰nitiedoston soittamista
		//Tiedosto on wav sek‰ mono, mutta ei toimi
		
		
		
		File soundFileEnd = new File("C:/temp/loppu.wav");
		File soundFileTest = new File("C:/temp/testi.wav");
		File soundFilePiano = new File("C:/temp/piano.wav");
		
		Sound.playSample(soundFileTest);
		Sound.playSample(soundFileEnd);
		Sound.playSample(soundFilePiano);
		
		

	}

}
