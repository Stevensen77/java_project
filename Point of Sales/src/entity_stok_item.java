import java.awt.List;
import java.awt.Window;
import java.awt.event.ActionListener;
import java.io.FileNotFoundException;
import java.math.BigInteger;
import java.security.MessageDigest;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;

import javax.swing.JFrame;
import javax.swing.JOptionPane;
import javax.swing.JTable;
import javax.swing.table.DefaultTableModel;

import com.mysql.jdbc.PreparedStatement;


public class entity_stok_item {
	
	static String nama = null;
	static String kode=null;
	static String kuantitas=null,kode_barang;
	
	static DefaultTableModel model = new DefaultTableModel(new String[]{"Nama barang","Kode barang","Harga","Kategori","Jumlah"}, 0);
	static DefaultTableModel model2 = new DefaultTableModel(new String[]{"Nama barang","Kode barang","Harga","Kategori","Jumlah"}, 0);
	
	static JTable table = new JTable();
	static JTable table2 = new JTable();
	
	
	entity_stok_item() throws FileNotFoundException, SQLException,NullPointerException
	
	{
	
	}
	
	
	public static String[] cari_item(String kode_huruf,String kode_angka)
			throws FileNotFoundException, SQLException, ArrayIndexOutOfBoundsException,NullPointerException
	{	
		kode= kode;
		table2.setModel(model2);
		
		ArrayList<Object[]> sets = new ArrayList<Object[]>();
		
		 nama="";
        kuantitas="";
		
		try {
			
   	  		
			 Statement statement = (Statement) koneksi_database_pos.getKoneksi2().createStatement();
	         ResultSet rs2=statement.executeQuery("select * from barang where kode_huruf='"+kode_huruf+"' AND kode_angka='"+kode_angka+"'");
	       
	            if(rs2.next()) 
	            	{
	                nama = rs2.getString("nama");             
	                kuantitas = rs2.getString("kuantitas");
	                kode_huruf = rs2.getString("kode_huruf");
	                kode_angka= rs2.getString("kode_angka");
	  
	                sets.add(new String[]{nama,kode_huruf,kode_angka,kuantitas});
	                model2.addRow(new Object[]{nama,kode,kuantitas});
	                
	                return new String[] {nama,kode_huruf,kode_angka,kuantitas};
	   		     
	            
					}
	            else {
		             JOptionPane.showMessageDialog(null, "Item tidak ditemukan");
		             kode="";  
		         	}
		     
	     
		}
		catch (ArrayIndexOutOfBoundsException e) 
		{
		    JOptionPane.showMessageDialog(null, "GAGAL mencari item!");
		}
		 return new String[] {nama,kode_huruf,kode_angka,kuantitas};
		
	}
	

	public static boolean stok_item(Object nama, String kode_huruf,String kode_angka, int kuantitas,String waktu,String nama_login)
	
	{
	
		try {
			kode_barang=kode_huruf+kode_angka;
			System.out.println(kode_barang+kuantitas);
				
        	  		String cek="select * from barang where kode_huruf='"+kode_huruf+"' AND kode_angka='"+kode_angka+"'";
		            Statement statement = (Statement) koneksi_database_pos.getKoneksi2().createStatement();
		            ResultSet resultset =  statement.executeQuery(cek) ;
				
					resultset.next();
					resultset.last();
				   if (resultset.getRow()==1)
				      {        
					   Statement statement2 = (Statement) koneksi_database_pos.getKoneksi2().createStatement();
					 statement2.executeUpdate("UPDATE barang SET kuantitas= '"+kuantitas+"' WHERE kode_huruf='"+kode_huruf+"' "
					   	+ "AND kode_angka='"+kode_angka+"';");
					   statement2.executeUpdate("INSERT INTO stok_item(nama_barang,kode_barang,tanggal_stok,nama_admin) VALUES ('"+nama+"',"
					  		+ "'"+kode_barang+"','"+waktu+"','"+nama_login+"') ");
					   statement2.close();
					   
					   
					   JOptionPane.showMessageDialog(null,"Berhasil Menyetok Kuantitas");
					   
					   return true;
				      }
				   else {
					     JOptionPane.showMessageDialog(null,"Data barang tidak ada");
				   }
        } catch (Exception e) {
            JOptionPane.showMessageDialog(null, "Gagal Menyetok Items");
            return false;
        }
		return false;
	}
	
	
	
}
