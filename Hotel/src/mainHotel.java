import java.awt.Color;
import java.io.FileNotFoundException;
import java.io.Writer;

import javax.swing.JFrame;

import com.thehowtotutorial.splashscreen.JSplash;

public class mainHotel {

	public static void main(String[] args) throws FileNotFoundException {
		try{
			JSplash splash = new JSplash(mainHotel.class.getResource("splash.png"), true, true, false, "V1", null, Color.RED, Color.BLACK);
			splash.splashOn();
			splash.setProgress(20, "Initializing");
			Thread.sleep(1000);
			splash.setProgress(40, "Loading");
			Thread.sleep(1000);
			splash.setProgress(60, "Applying Configs");
			Thread.sleep(1000);
			splash.setProgress(80, "Applying Settings");
			Thread.sleep(1000);
			splash.setProgress(100, "Starting App");
			Thread.sleep(1000);
			splash.splashOff();
			
			JFrame framehotel = new Hotel();
			framehotel.setVisible(true);
		}
		catch(Exception e){
			e.printStackTrace();
		}
		
		
		
		
	}

}
