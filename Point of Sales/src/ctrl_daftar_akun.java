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




public class ctrl_daftar_akun {
	ctrl_daftar_akun(ActionListener listener) throws FileNotFoundException, SQLException {
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
	

	
	
	public static boolean cek_input(String username, String password, String nama, String alamat, String noktp, String divisi, String nohp) {
		

		final Pattern hasSpecialChar = Pattern.compile("[^a-zA-Z0-9 ]");
		final Pattern hasNumber = Pattern.compile("[0-9]");
		final Pattern hasWord = Pattern.compile("[a-zA-Z]");
	
		
		if(password.length()<4)
		{
			JOptionPane.showMessageDialog(null, "Panjang Password kurang");
			return false;
			
		}
		
		else if (!hasSpecialChar.matcher(password).find()) {
			JOptionPane.showMessageDialog(null, "Password harus ada Tanda Bacanya");
			return false;
		}
		
		else if (!hasNumber.matcher(password).find()) {
			JOptionPane.showMessageDialog(null, "Password harus ada Angka");
			return false;
		}
		
		else if (hasNumber.matcher(nama).find()) {
			JOptionPane.showMessageDialog(null, "Nama tidak boleh ada Angka");
			return false;
		}
		
		else if (hasWord.matcher(noktp).find()) {
			JOptionPane.showMessageDialog(null, "No KTP Tidak boleh ada Huruf!");
			return false;
		}
		
		else if (noktp.length()<16 || noktp.length()>16) {
			JOptionPane.showMessageDialog(null, "No KTP harus 16 digit!");
			return false;
		}
		
		else if (hasWord.matcher(nohp).find()) {
			JOptionPane.showMessageDialog(null, "No HP Tidak boleh ada Huruf!");
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
	


