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




public class ctrl_laporan {
	ctrl_laporan(ActionListener listener) throws FileNotFoundException, SQLException {
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
	

	
	
	public static boolean cek_input(String tanggal) {
		
		
		//viewlogin.login();
		//String strharga=Integer.toString(harga);
		//String strkuantitas=Integer.toString(kuantitas);
		
		final Pattern hasSpecialChar = Pattern.compile("[^a-zA-Z0-9 ]");
		
		
		
		if(tanggal.length()==0)
		{
			JOptionPane.showMessageDialog(null, "Tanggal tidak boleh kosong");
			return false;
			
		}
		
	
		return true;
		}
	}
		
	

	


