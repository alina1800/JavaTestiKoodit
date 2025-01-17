package Data;

import java.util.Timer;
import lejos.utility.Delay;


public class MotorFunctions extends MotorInitializer{

	public void avoidObstacle() {

		/**
		 * Toisen esteen kohdalla ohjelma pysähtyy
		 */
		if (stop) {
			motorV.setPower(0);
			motorO.setPower(0);
			Main.Program(false);
			return;
		}

		/**
		 *  Käännytään pois radalta
		 */
		motorV.setPower(85);
		motorO.setPower(25);
		Delay.msDelay(550);

		/**
		 * Esteen kierto värisensoria tutkien
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
	 * @param value värisensorilta saatu arvo
	 */
	public void followLine(float value) {

		/**
		 * Oikean renkaan moottorin pyörimissuunta eteenpäin
		 */
		motorO.forward();
		
		/**
		 * Vasemman renkaan moottorin pyörimissuunta eteenpäin
		 */
		motorV.forward();
		
		/**
		 * Oikean renkaan moottorin pyörimisteho prosentteina
		 */
		motorO.setPower(60);
		
		/**
		 * Vasemman renkaan moottorin pyörimisteho prosentteina
		 */
		motorV.setPower(60);

		/**
		 * Kääntymismetodien kutsut riippuen siitä, mitä värisensori havaitsee
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
	 * Pysähtyminen
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
