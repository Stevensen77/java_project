import java.awt.Color;
import java.io.FileNotFoundException;
import java.io.Writer;

import javax.swing.JFrame;

import com.thehowtotutorial.splashscreen.JSplash;

public class splash_pos {

	public static void main(String[] args) throws FileNotFoundException {
		try{
			JSplash splash = new JSplash(splash_pos.class.getResource("pos.jpg"), true, true, false, "POS PT.INDONUSA", null,Color.WHITE, Color.BLUE);
			splash.splashOn();
			splash.setProgress(20, "Initializing");
			Thread.sleep(200);
			splash.setProgress(40, "Loading");
			Thread.sleep(3000);
			splash.setProgress(60, "Applying Configs");
			Thread.sleep(100);
			splash.setProgress(80, "Applying Settings");
			Thread.sleep(100);
			splash.setProgress(100, "Starting App");
			Thread.sleep(1000);
			splash.splashOff();
			
			JFrame framelogin = new viewlogin(null);
			framelogin.setVisible(true);
		}
		catch(Exception e){
			e.printStackTrace();
		}
	}

}
