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




public class ctrl_input_item {
	ctrl_input_item(ActionListener listener) throws FileNotFoundException, SQLException {
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
	

	
	
	public static boolean cek_input(String nama, String kode, String strharga,String strkuantitas) {
		
		
		//viewlogin.login();
		//String strharga=Integer.toString(harga);
		//String strkuantitas=Integer.toString(kuantitas);
		
		final Pattern hasSpecialChar = Pattern.compile("[^a-zA-Z0-9 ]");
		
	
		
		if(nama.length()==0)
		{
			JOptionPane.showMessageDialog(null, "Nama tidak boleh kosong");
			return false;
			
		}
		
		if(kode.length()==0)
		{
			JOptionPane.showMessageDialog(null, "Kode barang tidak boleh kosong");
			return false;
			
		}
		
		if(kode.length()<5 || kode.length()>5 )
		{
			JOptionPane.showMessageDialog(null, "Kode barang HARUS 5 digit!");
			return false;
			
		}
		
		if(strharga.length()==0)
		{
			try {
				JOptionPane.showMessageDialog(null, "Harga tidak boleh kosong");
				int hargacek = Integer.parseInt(strharga);
				
			} catch (NumberFormatException e) {
				JOptionPane.showMessageDialog(null, "Harga harus angka");
			}
			return false;
			
		}
		if(strkuantitas.length()==0)
		{
			try {
			JOptionPane.showMessageDialog(null, "Jumlah barang tidak boleh kosong");
			int kuantitas = Integer.parseInt(strkuantitas);
			} catch (NumberFormatException e) {
				JOptionPane.showMessageDialog(null, "Jumlah harus angka");
			}
			return false;
			
		}
		
	
		return true;
		}
	}
		
	

	


