import java.awt.Window;
import java.awt.event.ActionListener;
import java.io.FileNotFoundException;
import java.math.BigInteger;
import java.security.MessageDigest;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

import javax.swing.JFrame;
import javax.swing.JOptionPane;


public class entitylogin {
	

	
	entitylogin(ActionListener listener) throws FileNotFoundException, SQLException {
		super();
	
		
		
	}

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	static String sektor;
	
	
	
	
	public static boolean validasi_login(String username, String passw){

		String nama=username;
		String vpassword= passw;
		
		
		
		boolean nilai = false;
		
		
		try {
			
		 	//encryptPasswordSHA1();
   	  		
   	  		String nama_login;
   	  		
            Statement statement = (Statement) koneksi_database_pos.getKoneksi2().createStatement();
            ResultSet result=statement.executeQuery("select * from akun where " + "username='" + nama + "'");
           
            
            if (result.next()) {
                String pw = result.getString("password");
      
				if (passw.equals(pw)) {
                	JOptionPane.showMessageDialog(null, "Password benar");
                	
					//frame.setVisible(false);
        			
        			nilai=  true;
                } else {
                    JOptionPane.showMessageDialog(null, "Password salah");
                 
                    nilai=  false;
                }
            }
            
            else {
                JOptionPane.showMessageDialog(null, "User tidak ditemukan");
            
                nilai=  false;
            }
        } catch (Exception e) {
            JOptionPane.showMessageDialog(null, "Gagal Akses Database");
        }
		
		return nilai;
	}
	
	
	public static String login_divisi(String username){


		try {
			
            Statement statement = (Statement) koneksi_database_pos.getKoneksi2().createStatement();
            ResultSet result2=statement.executeQuery("select divisi from biodata where username='"+username+"'");
            if(result2.next()) 
            {
            sektor = result2.getString("divisi");   
            
           // System.out.println("Nilai divisi :" +sektor);	
            return sektor;
            }
            
        } catch (Exception e) {
            JOptionPane.showMessageDialog(null, "Gagal Divisi");
        }
		
		return sektor;
	}
	
	

	
	
	
	
}
