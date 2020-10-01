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




public class ctrl_transaksi_item {
	ctrl_transaksi_item(ActionListener listener) throws FileNotFoundException, SQLException {
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
	

	
	
	public static boolean cek_input(String kode, String jumlah) {
		
		
		
		final Pattern hasSpecialChar = Pattern.compile("[^a-zA-Z0-9 ]");
		
	
		try {
		if(kode.length()==0)
		{
			JOptionPane.showMessageDialog(null, "Kode Barang tidak boleh kosong");
			return false;
			
		}
		
		
		if(kode.length()<5 || kode.length()>5 )
		{
			JOptionPane.showMessageDialog(null, "Kode barang HARUS 5 digit!");
			return false;
			
		}
		
	
		if(jumlah.length()==0)
		{
			try {
			JOptionPane.showMessageDialog(null, "Jumlah barang tidak boleh kosong");
			int jumlah_barang = Integer.parseInt(jumlah);
			} catch (NumberFormatException e) {
				JOptionPane.showMessageDialog(null, "Jumlah harus angka");
			}
			return false;
			
		}
		}
		catch (Exception e) 
		{
		    JOptionPane.showMessageDialog(null, "GAGAL mencari item!");
		}
		
	
		return true;
		}
	}
		
	

	


