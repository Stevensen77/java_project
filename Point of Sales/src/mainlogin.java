import java.io.FileNotFoundException;


import javax.swing.JFrame;


public class mainlogin {

	public static void main(String[] args) throws FileNotFoundException {
		try{
		
			
			JFrame framelogin = new login();
			framelogin.setVisible(true);
		}
		catch(Exception e){
			e.printStackTrace();
		}
	}

}

