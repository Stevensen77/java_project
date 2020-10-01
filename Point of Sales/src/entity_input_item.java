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




public class entity_input_item {
	
	static String kode,str_kode_angka;
	static int int_kode_angka,kode_angka_baru,maxValue = 0;
	static char[] str_to_array;
	
	entity_input_item(ActionListener listener) throws FileNotFoundException, SQLException {
		super();
	
		
		
	}

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	
	public static int kode_terbesar(String kode_huruf) throws SQLException
	{
		String cek="select * from items where kode LIKE '%'+'"+kode+"'+'%'";
        Statement statement = (Statement) koneksi_database_pos.getKoneksi2().createStatement();
        ResultSet resultset =  statement.executeQuery(cek) ;
        
        
        
        if(resultset.next()) 
    	{
        	 
        	kode = resultset.getString("kode");
            
            str_to_array = kode.toCharArray();
    		char[] kode_angka= {str_to_array[3],str_to_array[4]};
    		str_kode_angka=kode_angka.toString();
    		int_kode_angka=Integer.parseInt(str_kode_angka);
    		
    		if (int_kode_angka > maxValue) {
    		    maxValue = int_kode_angka;
    		}
    		
    		kode_angka_baru=maxValue+1;
    		
    		return kode_angka_baru;
        	
    	}
		return kode_angka_baru;
    	
        
		
	}
	
	
	
	public static boolean validasi_input (String nama, String kode_huruf,String kode_angka, String strharga,String strkuantitas)
			{
		
			System.out.println(kode_angka+kode_huruf+"tessss");
			
		int harga = Integer.parseInt(strharga);
		int kuantitas = Integer.parseInt(strkuantitas);
		//boolean nilai = true;
		
		try {
        	  		String cek="select * from barang where kode_huruf='"+kode_huruf+"' AND kode_angka='"+kode_angka+"'";
		            Statement statement = (Statement) koneksi_database_pos.getKoneksi2().createStatement();
		            ResultSet resultset =  statement.executeQuery(cek) ;
				
					resultset.next();
					resultset.last();
				   if (resultset.getRow()==0)
				      {        
					   
					   Statement statement2 = (Statement) koneksi_database_pos.getKoneksi2().createStatement();
						
					   statement2.executeUpdate("INSERT INTO barang(nama,kode_huruf,kode_angka,harga,kuantitas) VALUES ('"+nama+"',"
					   		+ "'"+kode_huruf+"','"+kode_angka+"',"
					   		+ "'"+harga+"','"+kuantitas+"')");
					   statement2.close();
					   JOptionPane.showMessageDialog(null,"Berhasil Memasukan Data");
					   
					   return true;
				      }
				   else {
					     JOptionPane.showMessageDialog(null,"Kode barang sudah ada");
					     return false;
				   }
        } catch (Exception e) {
            JOptionPane.showMessageDialog(null, "Gagal Menginput");
            return false;
        }
		
		
	}
	

	
	
	
	
}
