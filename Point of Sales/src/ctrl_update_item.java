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




public class ctrl_update_item {
	ctrl_update_item(ActionListener listener) throws FileNotFoundException, SQLException {
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
	
	
	public static boolean cek_input(Object nama,Object kode, Object harga,Object kategori) {
		
		String nama_barang = String.valueOf(nama);
		String kode_barang = String.valueOf(kode);
		String harga_barang = String.valueOf(harga);
		String kategori_barang = String.valueOf(kategori);
		

		final Pattern hasSpecialChar = Pattern.compile("[^a-zA-Z]");		
	
		
		if(nama_barang.length()==0)
		{
			JOptionPane.showMessageDialog(null, "Nama tidak boleh kosong");
			return false;
			
		}
		
		if(kode_barang.length()==0)
		{
			JOptionPane.showMessageDialog(null, "Kode barang tidak boleh kosong");
			return false;
			
		}
		
		if(harga_barang.length()==0)
		{
			try {
				JOptionPane.showMessageDialog(null, "Harga tidak boleh kosong");
			
				int hargacek = Integer.parseInt(harga_barang);
				
				
			} catch (NumberFormatException e) 
			{
				JOptionPane.showMessageDialog(null, "Harga harus angka");
			}
			return false;
			
		}
		
		if (!hasSpecialChar.matcher(harga_barang).find()) {
			JOptionPane.showMessageDialog(null, "Harga harus berupa numeric");
			return false;
		}
		
	
		return true;
		}
	}
		
	
	
	


