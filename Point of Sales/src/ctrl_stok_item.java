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




public class ctrl_stok_item {
	ctrl_stok_item(ActionListener listener) throws FileNotFoundException, SQLException {
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
	
	
	public static boolean cek_input(Object kode, Object kuantitas) {
		
	
		String kode_barang = String.valueOf(kode);
		String kuantitas_barang = String.valueOf(kuantitas);
		

		final Pattern hasSpecialChar = Pattern.compile("[^a-zA-Z]");		
	
		
		if(kode_barang.length()==0)
		{
			JOptionPane.showMessageDialog(null, "Kode barang tidak boleh kosong");
			return false;
			
		}
		
		if(kuantitas_barang.length()==0)
		{
			try {
				JOptionPane.showMessageDialog(null, "Kuantitas tidak boleh kosong");
			
				int kuantitas_cek = Integer.parseInt(kuantitas_barang);
				
				
			} catch (NumberFormatException e) 
			{
				JOptionPane.showMessageDialog(null, "Kuantitas harus angka");
			}
			return false;
			
		}
		
		if (!hasSpecialChar.matcher(kuantitas_barang).find()) {
			JOptionPane.showMessageDialog(null, "Kuantitas harus berupa numeric");
			return false;
		}
		
	
		return true;
		}
	}
		
	
	
	


