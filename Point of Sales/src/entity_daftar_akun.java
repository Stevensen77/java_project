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


public class entity_daftar_akun {
	

	
	entity_daftar_akun(ActionListener listener) throws FileNotFoundException, SQLException {
		super();
	
		
		
	}

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	

	public static boolean input_akun(String username, String pw){
		try {
			
		
		//int harga = Integer.parseInt(strharga);
		//int kuantitas = Integer.parseInt(strkuantitas);
		//boolean nilai = true;
		
		
        	  		String cek="select * from akun where username='"+username+"'";
		            Statement statement = (Statement) koneksi_database_pos.getKoneksi2().createStatement();
		            ResultSet resultset =  statement.executeQuery(cek) ;
				
					resultset.next();
					resultset.last();
				   if (resultset.getRow()==0)
				      {        
					   Statement statement2 = (Statement) koneksi_database_pos.getKoneksi2().createStatement();
					   statement2.executeUpdate("INSERT INTO akun(username,password) VALUES ('"+username+"','"+pw+"')");
					   statement2.close();
					   JOptionPane.showMessageDialog(null,"Berhasil Memasukan Akun");
					   
					   return true;
				      }
				   else 
				   {
					     JOptionPane.showMessageDialog(null,"Akun sudah ada");
				   }
        } 
		catch (Exception e) 
		{
            JOptionPane.showMessageDialog(null, "Gagal Koneksi");
            return false;
        }
		
		return false;
	}
	
	public static boolean input_biodata(String username,String nama, String alamat, String noktp, String divisi, String nohp){
		try {
			
		
		//int harga = Integer.parseInt(strharga);
		//int kuantitas = Integer.parseInt(strkuantitas);
		//boolean nilai = true;
		
		
        	  		String cek="select * from biodata where nama='"+nama+"'";
		            Statement statement = (Statement) koneksi_database_pos.getKoneksi2().createStatement();
		            ResultSet resultset =  statement.executeQuery(cek) ;
				
					resultset.next();
					resultset.last();
				   if (resultset.getRow()==0)
				      {        
					   Statement statement2 = (Statement) koneksi_database_pos.getKoneksi2().createStatement();
					   statement2.executeUpdate("INSERT INTO biodata(username,nama,alamat,no_ktp,divisi,no_hp) VALUES ('"+username+"',"
					   		+ "'"+nama+"','"+alamat+"','"+noktp+"','"+divisi+"','"+nohp+"')");
					   statement2.close();
					   JOptionPane.showMessageDialog(null,"Berhasil Memasukan Biodata");
					   
					   return true;
				      }
				   else 
				   {
					     JOptionPane.showMessageDialog(null,"Nama sudah ada");
				   }
        } 
		catch (Exception e) 
		{
            JOptionPane.showMessageDialog(null, "Gagal Koneksi");
            return false;
        }
		
		return false;
	}
	

	
	
	
	
}
