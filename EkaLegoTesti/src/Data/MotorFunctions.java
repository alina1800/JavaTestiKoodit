package Data;

import java.util.Timer;
import lejos.utility.Delay;


public class MotorFunctions extends MotorInitializer{

	public void avoidObstacle() {

		/**
		 * Toisen esteen kohdalla ohjelma pys‰htyy
		 */
		if (stop) {
			motorV.setPower(0);
			motorO.setPower(0);
			Main.Program(false);
			return;
		}

		/**
		 *  K‰‰nnyt‰‰n pois radalta
		 */
		motorV.setPower(85);
		motorO.setPower(25);
		Delay.msDelay(550);

		/**
		 * Esteen kierto v‰risensoria tutkien
		 */
		while (Main.programRunning) {
			motorV.setPower(50);
			motorO.setPower(90);

			if (color.getRed() < 0.15f)
				break;
		}

		/**
		 * Viivalle takaisin korjaten kulmaa
		 */
		while (Main.programRunning) {
			motorV.setPower(30);
			motorO.backward();
			motorO.setPower(30);

			if (color.getRed() > 0.15f)
				break;
		}

		Stop();
	}

	/**
	 * Funktio, joka suorittaa viivan seuraamista
	 * @param value v‰risensorilta saatu arvo
	 */
	public void followLine(float value) {

		/**
		 * Oikean renkaan moottorin pyˆrimissuunta eteenp‰in
		 */
		motorO.forward();
		
		/**
		 * Vasemman renkaan moottorin pyˆrimissuunta eteenp‰in
		 */
		motorV.forward();
		
		/**
		 * Oikean renkaan moottorin pyˆrimisteho prosentteina
		 */
		motorO.setPower(60);
		
		/**
		 * Vasemman renkaan moottorin pyˆrimisteho prosentteina
		 */
		motorV.setPower(60);

		/**
		 * K‰‰ntymismetodien kutsut riippuen siit‰, mit‰ v‰risensori havaitsee
		 */
		if (value > threshHigh) {
			tiukkaVasen();
		} else if (value < threshLow) {
			tiukkaOikea();
		} else if (value > threshLow && value < threshMedLow) {
			loivaOikea();
		} else if (value > threshMedLow && value < threshMedHigh) {
			suoraan();
		} else if (value > threshMedHigh && value < threshHigh) {
			loivaVasen();
		}		
	}

	/**
	 * Tiukka vasen
	 */
	public void tiukkaVasen() {
		motorO.setPower(85);
		motorV.setPower(5);
	}

	/**
	 * Tiukka oikea
	 */
	public void tiukkaOikea() {
		motorO.setPower(5);
		motorV.setPower(90);
	}

	/**
	 * Loiva vasen
	 */
	public void loivaVasen() {
		motorA.setPower(30);
		motorD.setPower(10);
	}

	/**
	 * Loiva oikea
	 */
	public void loivaOikea() {
		motorA.setPower(10);
		motorD.setPower(30);
	}

	/**
	 * Suoraan
	 */
	public void suoraan() {
		motorO.setPower(90);
		motorV.setPower(90);
	}
	
	/**
	 * Pys‰htyminen
	 */
	public static void Stop() {

		timer = new Timer();
		timer.schedule(new java.util.TimerTask() {
			@Override
			public void run() {
				stop = true;
			}
			
		}, 2000
		);
	}
}
