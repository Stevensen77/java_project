import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.FileNotFoundException;
import java.math.BigInteger;
import java.security.MessageDigest;
import java.sql.SQLException;
import java.util.regex.Pattern;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JOptionPane;
import javax.swing.JPasswordField;
import javax.swing.JTextField;




public class ctrl_login {
	ctrl_login(ActionListener listener) throws FileNotFoundException, SQLException {
		super();
		// TODO Auto-generated constructor stub
	}




	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	//private JPasswordField txtpw;
	//private JTextField txtnama,txtMD5;
	String vmd5;
	

	
	
	public static boolean cek_input(String username, String password) {
		
		System.out.println(username);
		//viewlogin.login();
		 
		 	String nama=username;
			String vpassword= password;
		
		
		final Pattern hasSpecialChar = Pattern.compile("[^a-zA-Z0-9 ]");
		
	
		
		if(vpassword.length()<4)
		{
			JOptionPane.showMessageDialog(null, "Panjang Password kurang");
			return false;
			
		}
		
		else if (!hasSpecialChar.matcher(vpassword).find()) {
			JOptionPane.showMessageDialog(null, "Password harus special character");
			return false;
		}
	
		return true;
		}
	}
		
	
	/*
	@Override
	public boolean actionPerformed(ActionEvent e) {
		if(e.getActionCommand() == "Login"){
			
			entitylogin.login();
			
		}
		if(e.getActionCommand() == "Register"){
			JFrame frameRegister = null;
			try {
				frameRegister = new register();
			} catch (FileNotFoundException | SQLException e1) {
				// TODO Auto-generated catch block
				e1.printStackTrace();
			}		
			frameRegister.setVisible(true);
		}
		
		if(e.getActionCommand() == "Home"){
			JFrame frameRegister = null;
			try {
				frameRegister = new beranda();
			} catch (FileNotFoundException | SQLException e1) {
				// TODO Auto-generated catch block
				e1.printStackTrace();
			}		
			frameRegister.setVisible(true);
		}
		
	}
	
	
	*/
	


