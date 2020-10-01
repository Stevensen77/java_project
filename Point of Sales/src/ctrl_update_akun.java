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




public class ctrl_update_akun {
	ctrl_update_akun(ActionListener listener) throws FileNotFoundException, SQLException {
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
	
	
	public static boolean cek_input(String username,String username_update,String nama,String alamat,String no_ktp,String divisi,String no_hp) {
		
	
		

		final Pattern hasSpecialChar = Pattern.compile("[^a-zA-Z]");		
	
		
		if(username.length()==0)
		{
			JOptionPane.showMessageDialog(null, "Username tidak boleh kosong");
			return false;
			
		}
		

		if(username_update.length()==0)
		{
			JOptionPane.showMessageDialog(null, "Username tidak boleh kosong");
			return false;
			
		}
		
		if(nama.length()==0)
		{
			JOptionPane.showMessageDialog(null, "Nama tidak boleh kosong");
			return false;
			
		}
		
		if(alamat.length()==0)
		{
			JOptionPane.showMessageDialog(null, "Alamat tidak boleh kosong");
			return false;
			
		}
		
	
		
		if(no_ktp.length()==0)
		{
			try {
				JOptionPane.showMessageDialog(null, "No KTP tidak boleh kosong");
			
				int no_ktp_numeric = Integer.parseInt(no_ktp);
				
				
			} catch (NumberFormatException e) 
			{
				JOptionPane.showMessageDialog(null, "No KTP harus angka");
			}
			return false;
			
		}
		
		if(no_hp.length()==0)
		{
			try {
				JOptionPane.showMessageDialog(null, "No HP tidak boleh kosong");
			
				int no_hp_numeric = Integer.parseInt(no_hp);
				
				
			} catch (NumberFormatException e) 
			{
				JOptionPane.showMessageDialog(null, "No HP harus angka");
			}
			return false;
			
		}
		
		if (!hasSpecialChar.matcher(no_ktp).find()) {
			JOptionPane.showMessageDialog(null, "No KTP harus berupa numeric");
			return false;
		}
		
		if (!hasSpecialChar.matcher(no_hp).find()) {
			JOptionPane.showMessageDialog(null, "No HP harus berupa numeric");
			return false;
		}
	
		return true;
		}
	}
		
	
	
	


